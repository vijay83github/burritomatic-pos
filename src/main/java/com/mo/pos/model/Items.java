package com.mo.pos.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName="items")
public class Items {
	@JacksonXmlProperty(localName="item")
	@JacksonXmlElementWrapper(useWrapping = false)
	@JsonProperty(value="items")
	private Item[] items;

	public Item[] getItems() {
		return items;
	}

	public void setItems(Item[] items) {
		this.items = items;
	}
	
	

}
