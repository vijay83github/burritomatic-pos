package com.burritomatic.pos.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;

@JacksonXmlRootElement(localName="menulist")
public class Menu implements Serializable{
	@JacksonXmlProperty(localName="menu")
	@JacksonXmlElementWrapper(useWrapping = false)
	@JsonProperty(value="menulist")
	private MenuItem[] menulist;

	public MenuItem[] getMenulist() {
		return menulist;
	}

	public void setMenulist(MenuItem[] menulist) {
		this.menulist = menulist;
	}
	
	

}
