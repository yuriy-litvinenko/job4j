package ru.job4j.jdbc;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "entries")
public class Entries {
    @XmlElement(name = "entry")
    private List<Entry> entries;

    public Entries() {

    }

    Entries(List<Entry> entries) {
        this.entries = entries;
    }
}
