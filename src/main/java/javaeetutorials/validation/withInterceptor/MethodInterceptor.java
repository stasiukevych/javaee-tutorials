package javaeetutorials.validation.withInterceptor;

import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.validation.executable.ExecutableValidator;

import java.util.Set;

@Interceptor
@MethodInterceptorBinding
public class MethodInterceptor {

    @Inject
    private Validator validator;

    @AroundInvoke
    public Object validateMethodInvocation(InvocationContext ctx)
            throws Exception {
        Set<ConstraintViolation<Object>> violations;
        ExecutableValidator executableValidator = validator.forExecutables();
        violations = executableValidator.validateParameters(
                ctx.getTarget(), ctx.getMethod(), ctx.getParameters());
        processViolations(violations);
        Object result = ctx.proceed();
        violations = executableValidator.validateReturnValue(
                ctx.getTarget(), ctx.getMethod(), result);
        processViolations(violations);
        return result;
    }

    private void processViolations(Set<ConstraintViolation<Object>> violations) {
        violations.stream()
                .map(ConstraintViolation::getMessage)
                .forEach(System.out::println);
    }

}