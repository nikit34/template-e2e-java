package pt.devexperts.labels;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface TestLayer {
    String[] value();

    final class Type {
        public static final String SMOCK = "smock";
        public static final String REGRESS = "regress";

        private Type() {}
    }
}
