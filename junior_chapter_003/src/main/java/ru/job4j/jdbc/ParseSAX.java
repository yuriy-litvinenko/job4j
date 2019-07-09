package ru.job4j.jdbc;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

class ParseSAX {

    void parse(File xmlFile) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            XMLHandler handler = new XMLHandler();
            parser.parse(xmlFile, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class XMLHandler extends DefaultHandler {
        int sum;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            if (qName.equals("entry")) {
                int value = Integer.valueOf(attributes.getValue("field"));
                sum = sum + value;
            }
        }

        @Override
        public void endDocument() {
            System.out.println("Sum of fields = " + sum);
        }
    }
}
