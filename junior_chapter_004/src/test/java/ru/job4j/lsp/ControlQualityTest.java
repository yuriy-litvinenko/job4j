package ru.job4j.lsp;

import org.junit.Test;

import java.util.Calendar;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ControlQualityTest {

    private Calendar calcDateFromCur(int days) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, days);
        return cal;
    }

    @Test
    public void putFoodstuffsAndVerificationOfStoragesSize() {
        ControlQuality control = new ControlQuality();
        control.addWarehouse(3);
        control.addShop(3);
        control.addTrash(3);
        boolean result1 = control.putFood(new Milk(
                "Fresh milk", calcDateFromCur(-15), calcDateFromCur(15), 240, 100));
        boolean result2 = control.putFood(new Milk(
                "Fresh milk", calcDateFromCur(-30), calcDateFromCur(5), 240, 100));
        boolean result3 = control.putFood(new Milk(
                "Fresh milk", calcDateFromCur(-5), calcDateFromCur(20), 240, 100));
        boolean result4 = control.putFood(new Bread(
                "White Toast", calcDateFromCur(-2), calcDateFromCur(3), 70, 30));
        boolean result5 = control.putFood(new Bread(
                "White Toast", calcDateFromCur(-6), calcDateFromCur(-1), 70, 30));
        boolean result6 = control.putFood(new Meat(
                "Beef ribs", calcDateFromCur(-4), calcDateFromCur(35), 450, 200));
        boolean result7 = control.putFood(new Bread(
                "White Toast", calcDateFromCur(-2), calcDateFromCur(3), 70, 30));
        assertThat(result1, is(true));
        assertThat(result2, is(true));
        assertThat(result3, is(true));
        assertThat(result4, is(true));
        assertThat(result5, is(true));
        assertThat(result6, is(true));
        assertThat(result7, is(false));
        control.addShop(3);
        boolean result8 = control.putFood(new Bread(
                "White Toast", calcDateFromCur(-2), calcDateFromCur(3), 70, 30));
        assertThat(result8, is(true));
    }
}
