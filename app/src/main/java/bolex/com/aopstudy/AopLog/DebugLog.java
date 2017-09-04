package bolex.com.aopstudy.AopLog;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.RetentionPolicy.CLASS;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
/**
 * Created by liushenen on 2017/9/4.
 */

@Target({TYPE, METHOD, CONSTRUCTOR}) @Retention(CLASS)
public @interface DebugLog {
}
