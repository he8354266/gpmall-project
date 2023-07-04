package com.gupaoedu.pay.validatorextend;

import org.hibernate.validator.internal.constraintvalidators.bv.PatternValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Description //TODO
 * @Date 2023/7/4 9:18
 * @Author hy
 **/
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {PatternValidator.class})
public @interface PayChannel {

    String message() default "支付渠道不合法";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
