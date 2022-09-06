
/**
 * Убрать дубликаты, отсортировать по идентификатору, сгруппировать по имени
 * <p>
 * Должно получиться
 * Key:     Amelia
 * Value:   4
 * Key:     Emily
 * Value:   1
 * Key:     Harry
 * Value:   3
 * Key:     Jack
 * Value:   1
 */

package task1;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.BiConsumer;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Main {
    static class Person {
        final int id;

        final String name;

        Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person person)) return false;
            return getId() == person.getId() && getName().equals(person.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getName());
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    private final static Person[] RAW_DATA = new Person[]{
            new Person(0, "Harry"),
            new Person(0, "Harry"), // дубликат
            new Person(1, "Harry"), // тёзка
            new Person(2, "Harry"),
            new Person(3, "Emily"),
            new Person(4, "Jack"),
            new Person(4, "Jack"),
            new Person(5, "Amelia"),
            new Person(5, "Amelia"),
            new Person(6, "Amelia"),
            new Person(7, "Amelia"),
            new Person(8, "Amelia"),
    };

    public static void main(String[] args) {

        System.out.println("Raw data:");
        System.out.println();

        for (Person person : RAW_DATA) {
            System.out.println(person.id + " - " + person.name);
        }

        System.out.println();
        System.out.println("**************************************************");
        System.out.println();
        System.out.println("Duplicate filtered, grouped by name, sorted by name and id:");
        System.out.println();

        BiConsumer<String, Long> KeyValueConsumer =
                (key, value) -> System.out.println("Key:\t" + key + "\nValue:\t" + value);

        Arrays.stream(RAW_DATA)
                .distinct()
                .collect(groupingBy(Person::getName, counting()))
                .forEach(KeyValueConsumer);
    }
}
