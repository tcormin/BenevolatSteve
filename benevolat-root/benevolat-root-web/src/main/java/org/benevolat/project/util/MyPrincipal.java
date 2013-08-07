	package org.benevolat.project.util;

import java.io.Serializable;
import java.security.Principal;
import java.util.List;

import javax.security.auth.Subject;

public class MyPrincipal implements Principal, Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 2234588143511495273L;

	private String name;

	private Principal principal;

	private List<String> roles;
	
	public MyPrincipal(final Principal pPrincipal, final List<String> pRoles) {
        this.principal = pPrincipal;
        this.roles = pRoles;
    }

    public boolean isUserInRole(final String pRole) {
        return roles.contains(pRole);
    }

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}
}