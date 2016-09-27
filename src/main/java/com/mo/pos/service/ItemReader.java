package com.mo.pos.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.stream.XMLInputFactory;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.mo.pos.model.Items;

@Component
public class ItemReader {

	private static final String FILE_LOCATION = "src/main/resources/";

	public Items readList(String fileName) {
		StringBuilder xmlContent = new StringBuilder();
		File xmlFile = new File(FILE_LOCATION + fileName);
		Items itemList = null;
		if (xmlFile.exists()) {
			System.out.println(xmlFile);

			XMLInputFactory f = XMLInputFactory.newInstance();
			BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(xmlFile));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			String s;

			try {
				while ((s = br.readLine()) != null) {
					xmlContent.append(s);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(xmlContent.toString());
			XmlMapper mapper = new XmlMapper(f);

			try {
				itemList = mapper.readValue(xmlContent.toString(), Items.class);
			} catch (IOException e) {
				e.printStackTrace();
			}

		} 
		return itemList;
	}

}
