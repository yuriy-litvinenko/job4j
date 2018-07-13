package ru.job4j.pseudo;

/**
 * Часть 002. ООП
 * 4. Полиморфизм
 * 4. Используя шаблон проектирования - стратегию
 * @author Yuriy Litvinenko
 * @since 13.07.18
 */
public class Paint {
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    public static void main(String[] args) {
        Paint paint = new Paint();
        paint.draw(new Triangle());
        System.out.println();
        paint.draw(new Square());
    }
}
