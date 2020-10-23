package ru.job4j.jdbc;

import java.io.File;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class Main {
    private static final String CONF_PATH = "sqlite.properties";
    private static final String XML_PATH = "target\\entries.xml";
    private static final String XML_CONV_PATH = "target\\entriesConv.xml";
    private static final String XSL_PATH = "entries.xsl";
    private File xmlFile;
    private File xmlConvFile;
    private File xslFile;
    private StoreSQL storeSQL;
    private StoreXML storeXML;
    private ConvertXSQT convertXSQT;
    private ParseSAX parseSAX;

    public static void main(String[] args) {
        Main main = new Main();
        main.prepare();
        main.execute();
    }

    private void prepare() {
        xmlFile = new File(XML_PATH);
        xmlConvFile = new File(XML_CONV_PATH);
        xslFile = new File(URLDecoder.decode(Objects.requireNonNull(getClass().getClassLoader().getResource(XSL_PATH)).getPath(), StandardCharsets.UTF_8));
        Config config = new Config(CONF_PATH);
        storeSQL = new StoreSQL(config);
        storeXML = new StoreXML();
        convertXSQT = new ConvertXSQT();
        parseSAX = new ParseSAX();
    }

    private void execute() {
        storeSQL.generate(10);
        storeXML.save(storeSQL.load(), xmlFile);
        convertXSQT.convert(xmlFile, xmlConvFile, xslFile);
        parseSAX.parse(xmlConvFile);
    }
}
