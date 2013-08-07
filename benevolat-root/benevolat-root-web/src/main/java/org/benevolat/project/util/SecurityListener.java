package org.benevolat.project.util;

import java.io.InputStream;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SecurityListener implements ServletRequestListener {

    private static List<String> roles = null;
    
    @Override
    public void requestInitialized(final ServletRequestEvent sre) {
        SecurityContext.setPrincipal(getMyPrincipal((HttpServletRequest) sre.getServletRequest()));
    }

    @Override
    public void requestDestroyed(final ServletRequestEvent sre) {
        SecurityContext.removePrincipal();
    }

    public static MyPrincipal getMyPrincipal(final HttpServletRequest request) {
        if (roles == null) {
            roles = getSecurityRoles(request.getServletPath());
        }

        Principal principal = (Principal) request.getUserPrincipal();
        List<String> currentRoles = new ArrayList<String>();
        for (String role : roles) {
            if (request.isUserInRole(role)) {
                currentRoles.add(role);
            }
        }
        return new MyPrincipal(principal, currentRoles);
    }

	public static synchronized List<String> getSecurityRoles(final String string) {
        List<String> r = new ArrayList<String>();
        
        InputStream is = String.class.getResourceAsStream("/WEB-INF/web.xml");

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        dbFactory.setNamespaceAware(true);
        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = (Document) dBuilder.parse(is);
            ((Node) doc.getDefaultRootElement()).normalize();

            NodeList elements = ((org.w3c.dom.Document) doc).getElementsByTagName("role-name");
            for (int i = 0; i < elements.getLength(); i++) {
                r.add(elements.item(i).getTextContent().trim());
            }
        } catch (Exception e) {
            new IllegalAccessException(e.getMessage());
        }
        return r;
    }
}