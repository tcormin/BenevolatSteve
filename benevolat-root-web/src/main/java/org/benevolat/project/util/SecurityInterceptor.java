package org.benevolat.project.util;

import java.io.Serializable;
import java.lang.reflect.Method;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Secure(roles = { })
@Interceptor
public class SecurityInterceptor implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1570129014012769789L;

	@AroundInvoke
    public Object invoke(final InvocationContext context) throws Exception {
        String[] roles = getRoles(context.getMethod());
        MyPrincipal principal = SecurityContext.getPrincipal();

        if (!principal.isUserInRole(roles.toString())) {
            throw new IllegalAccessException("Current user not autorised!");
        }

        return context.proceed();
    }

    private String[] getRoles(final Method method) {
        if (method.isAnnotationPresent(Secure.class)) {
            return method.getAnnotation(Secure.class).roles();
        }

        if (method.getDeclaringClass().isAnnotationPresent(Secure.class)) {
            return method.getDeclaringClass().getAnnotation(Secure.class).roles();
        }

        return null;
    }
    
}
