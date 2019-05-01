package ru.job4j.control;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AnalizeTest {

    @Test
    public void diffTwoUserListTest() {
        Analize.User user1 = new Analize.User(1, "User1");
        Analize.User user2 = new Analize.User(2, "User2");
        Analize.User user3 = new Analize.User(3, "User3");
        Analize.User user4 = new Analize.User(4, "User4");
        Analize.User user5 = new Analize.User(5, "User5");
        List<Analize.User> userList1 = new ArrayList<>();
        userList1.add(user1);
        userList1.add(user2);
        userList1.add(user3);
        userList1.add(user4);
        userList1.add(user5);
        Analize.User user6 = new Analize.User(1, "User1");
        Analize.User user7 = new Analize.User(2, "User2mod");
        Analize.User user8 = new Analize.User(3, "User3mod");
        Analize.User user9 = new Analize.User(9, "User9");
        Analize.User user10 = new Analize.User(10, "User10");
        Analize.User user11 = new Analize.User(11, "User11");
        List<Analize.User> userList2 = new ArrayList<>();
        userList2.add(user6);
        userList2.add(user7);
        userList2.add(user8);
        userList2.add(user9);
        userList2.add(user10);
        userList2.add(user11);
        Analize.Info result = new Analize().diff(userList1, userList2);
        Analize.Info expect = new Analize.Info(3, 2, 2);
        assertThat(result.equals(expect), is(true));
    }
}
