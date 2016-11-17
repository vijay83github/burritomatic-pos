package com.burritomatic.pos.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.stream.XMLInputFactory;

import com.burritomatic.pos.dao.MenuDao;
import com.burritomatic.pos.model.Menu;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.stereotype.Repository;

@Repository("menuDao")
public class MenuDaoImpl implements MenuDao {

	private static final String FILE_LOCATION = "src/main/resources/";

	@Override
	public Menu retrieveMenu(String fileName) {
		StringBuilder xmlContent = new StringBuilder();
		File xmlFile = new File(FILE_LOCATION + fileName);
		Menu itemList = null;
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
				itemList = mapper.readValue(xmlContent.toString(), Menu.class);
			} catch (IOException e) {
				e.printStackTrace();
			}

		} 
		return itemList;
	}

}
