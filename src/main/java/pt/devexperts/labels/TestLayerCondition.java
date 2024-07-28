package pt.devexperts.labels;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;


public class TestLayerCondition implements ExecutionCondition {

    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
        TestLayer classLayer = context.getTestClass().flatMap(cls -> {
            return Optional.ofNullable(cls.getAnnotation(TestLayer.class));
        }).orElse(null);

        TestLayer methodLayer = context.getTestClass()
                .flatMap(t -> Arrays.stream(t.getMethods())
                .map(m -> m.getAnnotation(TestLayer.class))
                .filter(Objects::nonNull)
                .findFirst()).orElse(null);

        final String desiredLayers = System.getProperty("TEST_LAYERS");

        if (desiredLayers != null) {
            if (matchesAny(desiredLayers, classLayer) || matchesAny(desiredLayers, methodLayer)) {
                return ConditionEvaluationResult.enabled("Test enabled for layers: " + desiredLayers);
            }
            return ConditionEvaluationResult.disabled("Test not applicable for layers: " + desiredLayers);
        }

        return ConditionEvaluationResult.enabled("All tests is applicable for layers: none");
    }

    private boolean matchesAny(String layers, TestLayer testLayer) {
        if (testLayer != null) {
            for (String layer : testLayer.value()) {
                if (layers.contains(layer)) {
                    return true;
                }
            }
        }
        return false;
    }
}
