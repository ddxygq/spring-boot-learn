package com.ikeguang.monitor.mysql.util;

import com.google.common.io.Resources;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @ Author: keguang
 * @ Date: 2019/7/8 16:08
 * @ version: v1.0.0
 * @ description:
 */
public class Configuration {
    private static final Logger logger = LoggerFactory.getLogger(Configuration.class);

    public static Map<String, String> initConfig(String configFile){

        Map<String, String> map = new HashMap<>();

        // 构建xml解析器
        SAXReader saxReader = new SAXReader();
        Document document = null;

        try{
            document = saxReader.read(Resources.getResource(configFile));
        }catch (DocumentException e){
            logger.error(String.format("read {0} failure", configFile), e.getMessage());
        }

        if(document != null){
            Element root = document.getRootElement();
            Iterator<Element> elementIterator = root.elementIterator();
            while (elementIterator.hasNext()){
                Element element = elementIterator.next();
                String parentKey = element.getQualifiedName();
                Iterator<Element> elementIterator2 = element.elementIterator();
                while (elementIterator2.hasNext()){
                    Element element2 = elementIterator2.next();
                    map.put(parentKey + "-" + element2.getQualifiedName(), element2.getText());
                }

            }
        }

        return map;

    }
}
