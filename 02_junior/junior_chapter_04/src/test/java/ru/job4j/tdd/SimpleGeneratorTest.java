package ru.job4j.tdd;

import javafx.util.Pair;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleGeneratorTest {

    @Test
    public void setTemplateAndTwoParamsAndGetReplacedString() {
        SimpleGenerator sg = new SimpleGenerator();
        Pair[] keys = new Pair[]{new Pair<>("name", "Yuriy"), new Pair<>("subject", "you")};
        String text = "I am a ${name}, Who are ${subject}?";
        String result = sg.generate(text, keys);
        String expect = "I am a Yuriy, Who are you?";
        assertThat(result, is(expect));
    }

    @Test
    public void setTemplateAndOneParamAndGetReplacedString() {
        SimpleGenerator sg = new SimpleGenerator();
        Pair[] keys = new Pair[]{new Pair<>("sos", "please")};
        String text = "Help, ${sos}, ${sos}, ${sos}";
        String result = sg.generate(text, keys);
        String expect = "Help, please, please, please";
        assertThat(result, is(expect));
    }

    @Test(expected = KeysNotValidException.class)
    public void setNotEnoughParamsAndGetException() {
        SimpleGenerator sg = new SimpleGenerator();
        Pair[] keys = new Pair[]{new Pair<>("name", "Yuriy")};
        String text = "I am a ${name}, Who are ${subject}?";
        sg.generate(text, keys);
    }

    @Test(expected = KeysNotValidException.class)
    public void setTooManyParamsAndGetException() {
        SimpleGenerator sg = new SimpleGenerator();
        Pair[] keys = new Pair[]{new Pair<>("name", "Yuriy"), new Pair<>("subject", "you"), new Pair<>("key", "none")};
        String text = "I am a ${name}, Who are ${subject}?";
        sg.generate(text, keys);
    }
}
