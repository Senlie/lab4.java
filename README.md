# Лабораторна робота №4

**Тема:** Класи в мові програмування Java

---

## Студент

- **ПІБ:** Кривов'яз Анастасія Олексіївна
- **Група:** ІО-з51
- **Номер залікової книжки:** 5103

---

## Опис завдання

| Параметр | Формула    | Значення | Результат          |
|----------|------------|----------|--------------------|
| C11      | 5103 % 11  | 4        | Клас: **Одяг (Clothing)** |

Створити клас `Clothing` з мінімум 5 полями, масив об'єктів, відсортувати та знайти ідентичний об'єкт.

---

## Що і як зроблено

1. Визначено варіант через остачу від ділення номера залікової книжки на 11.
2. Створено клас `Clothing` з 5 полями: `brand`, `price`, `size`, `color`, `material`.
3. Перевизначено методи `equals`, `hashCode` та `toString`.
4. У методі `main` створено масив із 8 об'єктів `Clothing`.
5. Масив відсортовано через `Arrays.sort` з компаратором: за `brand` за зростанням, при однакових `brand` — за `price` за спаданням.
6. Лінійним пошуком через `equals` знайдено об'єкт, ідентичний заданому `target`.
7. Оброблено виключні ситуації: `NullPointerException`, `ClassCastException`, `Exception`.

---

## Результати виконання

```
=== Лабораторна робота №4 ===

Масив до сортування:
  [0] Clothing{brand='Zara', price=1500.00, size='M', color='Black', material='Cotton'}
  [1] Clothing{brand='Nike', price=2200.00, size='L', color='White', material='Polyester'}
  [2] Clothing{brand='Zara', price=3100.00, size='S', color='Red', material='Wool'}
  [3] Clothing{brand='HM', price=800.00, size='XL', color='Blue', material='Cotton'}
  [4] Clothing{brand='Nike', price=1800.00, size='XS', color='Green', material='Polyester'}
  [5] Clothing{brand='Adidas', price=2500.00, size='M', color='Yellow', material='Cotton'}
  [6] Clothing{brand='HM', price=650.00, size='L', color='Gray', material='Linen'}
  [7] Clothing{brand='Zara', price=1500.00, size='XL', color='Black', material='Wool'}

Масив після сортування (brand ↑, price ↓):
  [0] Clothing{brand='Adidas', price=2500.00, size='M', color='Yellow', material='Cotton'}
  [1] Clothing{brand='HM', price=800.00, size='XL', color='Blue', material='Cotton'}
  [2] Clothing{brand='HM', price=650.00, size='L', color='Gray', material='Linen'}
  [3] Clothing{brand='Nike', price=2200.00, size='L', color='White', material='Polyester'}
  [4] Clothing{brand='Nike', price=1800.00, size='XS', color='Green', material='Polyester'}
  [5] Clothing{brand='Zara', price=3100.00, size='S', color='Red', material='Wool'}
  [6] Clothing{brand='Zara', price=1500.00, size='M', color='Black', material='Cotton'}
  [7] Clothing{brand='Zara', price=1500.00, size='XL', color='Black', material='Wool'}

Пошук об'єкта: Clothing{brand='Nike', price=1800.00, size='XS', color='Green', material='Polyester'}
-----------------------------
Знайдено на позиції [4]: Clothing{brand='Nike', price=1800.00, size='XS', color='Green', material='Polyester'}
```

---

## Висновки

У ході виконання лабораторної роботи було:
- освоєно створення власних класів з полями, конструктором, гетерами та перевизначеними методами `equals`, `hashCode`, `toString`;
- використано `Arrays.sort` зі стандартним `Comparator` для багаторівневого сортування;
- реалізовано лінійний пошук об'єкта через метод `equals`;
- закріплено навички обробки виключних ситуацій.
