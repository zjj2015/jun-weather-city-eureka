package com.jun.spring.cloud.weather.util;

import java.io.Reader;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class XmlBuilder {
	/**
	 * 将XMl转换为指定的pojo
	 * @param clazz
	 * @param xmlStr
	 * @return
	 * @throws Exception
	 */
	public static Object xmlStrToObject(Class<?> clazz,String xmlStr) throws Exception {
		Object xmlObject = null;
		Reader reader = null;
		JAXBContext context=JAXBContext.newInstance(clazz);
		//XML 转为对象的接口
		Unmarshaller unmarshaller = context.createUnmarshaller();
		reader = new StringReader(xmlStr);
		xmlObject=unmarshaller.unmarshal(reader);
		if(null !=reader) {
			reader.close();
		}
		return xmlObject;
	}

}
