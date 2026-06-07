/**
 * Лабораторна робота №4
 * Тема: Класи в мові програмування Java
 *
 * Номер залікової книжки: 5103
 *
 * Варіант:
 *   C11 = 5103 % 11 = 4 → Клас: Одяг (Clothing)
 *
 * Завдання:
 *   - Створити клас Clothing з мінімум 5 полями
 *   - Створити масив об'єктів, відсортувати за brand (зростання),
 *     при рівних brand — за price (спадання)
 *   - Знайти об'єкт, ідентичний заданому
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
 * Клас, що описує одиницю одягу.
 */
class Clothing {

    /** Бренд одягу */
    private String brand;

    /** Ціна у гривнях */
    private double price;

    /** Розмір (XS, S, M, L, XL) */
    private String size;

    /** Колір */
    private String color;

    /** Матеріал (Cotton, Polyester, Wool тощо) */
    private String material;

    public Clothing(String brand, double price, String size,
                    String color, String material) {
        this.brand = brand;
        this.price = price;
        this.size = size;
        this.color = color;
        this.material = material;
    }

    public String getBrand()    { return brand; }
    public double getPrice()    { return price; }
    public String getSize()     { return size; }
    public String getColor()    { return color; }
    public String getMaterial() { return material; }

    /**
     * Порівняння об'єктів за всіма полями.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Clothing)) return false;
        Clothing other = (Clothing) obj;
        return Double.compare(this.price, other.price) == 0
            && Objects.equals(this.brand, other.brand)
            && Objects.equals(this.size, other.size)
            && Objects.equals(this.color, other.color)
            && Objects.equals(this.material, other.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, price, size, color, material);
    }

    @Override
    public String toString() {
        return String.format(
            "Clothing{brand='%s', price=%.2f, size='%s', color='%s', material='%s'}",
            brand, price, size, color, material
        );
    }
}

/**
 * Головний клас із виконавчим методом.
 */
public class Lab4 {

    public static void main(String[] args) {

        // --- Масив об'єктів класу Clothing ---
        Clothing[] clothes = {
            new Clothing("Zara",   1500.0, "M",  "Black",  "Cotton"),
            new Clothing("Nike",   2200.0, "L",  "White",  "Polyester"),
            new Clothing("Zara",   3100.0, "S",  "Red",    "Wool"),
            new Clothing("HM",     800.0,  "XL", "Blue",   "Cotton"),
            new Clothing("Nike",   1800.0, "XS", "Green",  "Polyester"),
            new Clothing("Adidas", 2500.0, "M",  "Yellow", "Cotton"),
            new Clothing("HM",     650.0,  "L",  "Gray",   "Linen"),
            new Clothing("Zara",   1500.0, "XL", "Black",  "Wool")
        };

        // --- Об'єкт для пошуку ---
        Clothing target = new Clothing("Nike", 1800.0, "XS", "Green", "Polyester");

        try {
            // --- Вивід масиву до сортування ---
            System.out.println("=== Лабораторна робота №4 ===");
            System.out.println("\nМасив до сортування:");
            printArray(clothes);

            // --- Сортування: за brand (зростання), при рівних — за price (спадання) ---
            Arrays.sort(clothes, Comparator
                .comparing(Clothing::getBrand)
                .thenComparing(Comparator.comparingDouble(Clothing::getPrice).reversed())
            );

            System.out.println("\nМасив після сортування (brand ↑, price ↓):");
            printArray(clothes);

            // --- Пошук ідентичного об'єкта ---
            System.out.println("\nПошук об'єкта: " + target);

            int foundIndex = -1;
            for (int i = 0; i < clothes.length; i++) {
                if (clothes[i].equals(target)) {
                    foundIndex = i;
                    break;
                }
            }

            System.out.println("-----------------------------");
            if (foundIndex != -1) {
                System.out.println("Знайдено на позиції [" + foundIndex + "]: " + clothes[foundIndex]);
            } else {
                System.out.println("Об'єкт не знайдено у масиві.");
            }

        } catch (NullPointerException e) {
            System.err.println("Помилка: масив містить null-елементи: " + e.getMessage());
        } catch (ClassCastException e) {
            System.err.println("Помилка сортування: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Непередбачена помилка: " + e.getMessage());
        }
    }

    /**
     * Виводить масив об'єктів Clothing на екран.
     *
     * @param arr масив одягу
     */
    static void printArray(Clothing[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("  [" + i + "] " + arr[i]);
        }
    }
}
