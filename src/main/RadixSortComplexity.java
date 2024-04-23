package main;

public class RadixSortComplexity {

    public static void main(String[] args) {
        int[] numbers = {95, 3, 85, 2, 56, 88, 1, 55, 44, 0};
        // base de numeración (por defecto 10)
        int radix = 10; 
        // numero máximo de dígitos
        int maxDigits = getMaxDigits(numbers, radix); 

        for (int digit = 1; digit <= maxDigits; digit++) {
            countingSort(numbers, radix, digit);
        }

        // se imprime el arreglo ordenado 
        for (int number : numbers) {
            System.out.print(number + " ");
        }

        // se evalua la complejidad
        int n = numbers.length;
        System.out.println("\nComplejidad temporal: O(n * k)");
        System.out.println("Donde:");
        System.out.println("- n es la cantidad de elementos en el arreglo");
        System.out.println("- k es el número máximo de dígitos en los elementos");
        System.out.println("En este caso, la complejidad es O(" + n + " * " + maxDigits + ")");
    }

    private static int getMaxDigits(int[] numbers, int radix) {
        int maxDigits = 0;
        for (int number : numbers) {
            int currentDigits = 0;
            int temp = number;
            while (temp > 0) {
                temp /= radix;
                currentDigits++;
            }
            maxDigits = Math.max(maxDigits, currentDigits);
        }
        return maxDigits;
    }

    private static void countingSort(int[] numbers, int radix, int digit) {
        int[] buckets = new int[radix];
        for (int number : numbers) {
            int index = (number / digit) % radix;
            buckets[index]++;
        }

        int i = 0;
        for (int bucketIndex = 0; bucketIndex < radix; bucketIndex++) {
            for (int count = 0; count < buckets[bucketIndex]; count++) {
                numbers[i++] = bucketIndex * digit;
            }
        }
    }
}
