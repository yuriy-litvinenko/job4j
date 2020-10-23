package ru.job4j.addresses;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Profiles {
    List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(Profile::getAddress).sorted(
                Comparator.comparing(Address::getCity)
        ).distinct().collect(Collectors.toList());
    }
}
