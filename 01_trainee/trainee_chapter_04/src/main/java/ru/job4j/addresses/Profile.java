package ru.job4j.addresses;

class Profile {
    private Address address;

    Profile(Address address) {
        this.address = address;
    }

    Address getAddress() {
        return address;
    }
}
