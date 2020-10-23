package ru.job4j.jdbc;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.List;

class StoreXML {

    void save(List<Entry> list, File fileXml) {
        Entries entries = new Entries(list);
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ru.job4j.jdbc.Entries.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(entries, fileXml);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
