import java.util.Arrays;
import java.util.Scanner;

public  class Main {
    private static final Scanner sc = new Scanner(System.in);
    static void main() {
            run();
    }

    private static void run() {
        int[] array = null;
        while (true) {
            System.out.println("\n--- Меню ---");
            System.out.println("1. Ввод элементов массива");
            System.out.println("2. Отображение массива");
            System.out.println("3. Поиск элемента в массиве");
            System.out.println("4. Сортировка массива");
            System.out.println("5. Выход");

            int choice;
            while (true) {
                System.out.println("Выберите пункт меню (1–5): ");
                if (sc.hasNextInt()) {
                    choice = sc.nextInt();
                    break;
                } else {
                    String invalidInput = sc.nextLine();
                    System.out.println("Ошибка: '" + invalidInput +
                            "' не является целым числом. Попробуйте ещё раз.");
                }
            }

            switch (choice) {
                case 1 -> array = fillArray();
                case 2 -> {
                    System.out.print("Массив: ");
                    printArray(array);
                }
                case 3 -> searchElement(array);
                case 4 -> {
                    System.out.println("Массив до сортировки: ");
                    printArray(array);
                    bubbleSort(array);
                    System.out.println("Отсортированный массив: ");
                    printArray(array);
                }
                case 5 -> {
                    sc.close();
                    return;
                }
                default -> System.out.println(
                        "Неверный выбор. Пожалуйста, введите 1, 2, 3, 4 или 5.");
            }
        }
    }

    public static int getArrSize(){
        System.out.println("Введите размер массива: ");
        while (true) {
            if (sc.hasNextInt()) {
                int size = sc.nextInt();
                if (size > 0) {
                    return size;
                } else {
                    System.out.println("Размер массива должен быть положительным. Попробуйте ещё раз:");
                }
            } else {
                System.out.println("Ошибка: введите целое число. Попробуйте ещё раз:");
                sc.next();
            }
        }
    }

    public static int[] fillArray() {
        int size = getArrSize();
        int[] arr = new int[size];
        System.out.println("Введите элементы массива (целые числа):");

        for (int i = 0; i < size; i++) {
            while (true) {
                if (sc.hasNextInt()) {
                    arr[i] = sc.nextInt();
                    break;
                } else {
                    System.out.println("Ошибка: введите целое число для элемента " + (i + 1) + ". Попробуйте ещё раз:");
                    sc.next();
                }
            }
        }
        return arr;
    }

    public static void printArray(int[] array) {
        if (array == null) {
            System.out.println("Массив не инициализирован.");
            return;
        }

        if (array.length == 0) {
            System.out.println("Массив пуст.");
            return;
        }
        System.out.println(Arrays.toString(array));
    }

    private static int findElement(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static void searchElement(int[] array) {
        if (array == null || array.length == 0) {
            System.out.println("Массив пустой. Сначала заполните массив");
            return;
        }

        System.out.println("Введите число для поиска в массиве: ");
        int value;
        while (true) {
            if (sc.hasNextInt()) {
                value = sc.nextInt();
                break;
            } else {
                String invalidInput = sc.nextLine();
                System.out.println(
                        "Ошибка: '" + invalidInput + "' не является целым числом. Попробуйте ещё раз:");
                System.out.print("Введите число для поиска в массиве: ");
            }
        }

        int index = findElement(array, value);

        if (index == -1) {
            System.out.println("Элемент " + value + " не найден в массиве.");
        } else {
            System.out.println("Элемент " + value + " найден на позиции " + index + ".");
        }
    }

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }
}