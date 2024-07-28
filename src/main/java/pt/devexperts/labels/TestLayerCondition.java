package pt.devexperts.labels;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;
import pt.devexperts.configs.TestScopeConfig;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

import static pt.devexperts.properties.ConfigPropertiesService.getProperties;


public class TestLayerCondition implements ExecutionCondition {
    private static final TestScopeConfig TEST_SCOPE_CONFIG = ConfigFactory.create(TestScopeConfig.class, getProperties());

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

        final String desiredLayers = TEST_SCOPE_CONFIG.testLayers();

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
