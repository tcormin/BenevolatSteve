package org.benevolat.project.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;

@RequestScoped //View
public class ToolBarBean implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -4042397248369464493L;
	
	private String groupSeparator;
    private String groupItemSeparator;

    public String getGroupItemSeparator() {
        return groupItemSeparator;
    }

    public void setGroupItemSeparator(String groupItemSeparator) {
        this.groupItemSeparator = groupItemSeparator;
    }

    public String getGroupSeparator() {
        return groupSeparator;
    }

    public void setGroupSeparator(String groupSeparator) {
        this.groupSeparator = groupSeparator;
    }

}