package javayou;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.enterprise.inject.Stereotype;
import javax.inject.Singleton;

@Stereotype
@Singleton
@Retention(RetentionPolicy.RUNTIME)
public @interface EventHandler {
}
