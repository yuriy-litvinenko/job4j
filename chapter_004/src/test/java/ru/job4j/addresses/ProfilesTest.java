package ru.job4j.addresses;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {

    @Test
    public void getAddressesListFromProfilesList() {
        Address address1 = new Address("Moscow", "Pushkina", 10, 125);
        Address address2 = new Address("Penza", "Malahova", 3, 55);
        Address address3 = new Address("Samara", "Lermontova", 22, 250);
        Profile profile1 = new Profile(address1);
        Profile profile2 = new Profile(address2);
        Profile profile3 = new Profile(address3);
        List<Address> result = new Profiles().collect(List.of(profile1, profile2, profile3));
        List<Address> expect = List.of(address1, address2, address3);
        assertThat(result, is(expect));
    }
}
