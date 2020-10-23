package ru.job4j.search;

class Person {
    private String name;
    private String surname;
    private String phone;
    private String address;

    Person(String name, String surname, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
    }

    String getName() {
        return name;
    }

    String getSurname() {
        return surname;
    }

    String getPhone() {
        return phone;
    }

    String getAddress() {
        return address;
    }
}
