package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class StoreTest {

    @Test
    public void testOperationsWithUserStore() {
        UserStore userStore = new UserStore(10);
        userStore.add(new User("1"));
        userStore.add(new User("2"));
        userStore.add(new User("3"));
        userStore.add(new User("4"));
        userStore.add(new User("5"));
        User user6 = new User("6");
        userStore.replace("3", user6);
        assertThat(userStore.findById("6"), is(user6));
        userStore.delete("6");
        assertThat(userStore.findById("6"), is(nullValue()));
    }

    @Test
    public void testOperationsWithRoleStore() {
        RoleStore roleStore = new RoleStore(10);
        roleStore.add(new Role("1"));
        roleStore.add(new Role("2"));
        roleStore.add(new Role("3"));
        roleStore.add(new Role("4"));
        roleStore.add(new Role("5"));
        Role role6 = new Role("6");
        roleStore.replace("3", role6);
        assertThat(roleStore.findById("6"), is(role6));
        roleStore.delete("6");
        assertThat(roleStore.findById("6"), is(nullValue()));
    }
}
