package org.benevolat.project.util;

import java.io.Serializable;

public final class SecurityContext implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4063825749314527298L;
	private static InheritableThreadLocal<MyPrincipal> principalHolder =
                new InheritableThreadLocal<MyPrincipal>();

    private SecurityContext() { }

    public static MyPrincipal getPrincipal() {
        if (principalHolder.get() == null) {
            principalHolder.set(new MyPrincipal(null, null));
        }
        return (MyPrincipal) principalHolder.get();
    }

    public static void setPrincipal(final MyPrincipal principal) {
        principalHolder.set(principal);
    }

    public static void removePrincipal() {
        principalHolder.remove();
    }
}
