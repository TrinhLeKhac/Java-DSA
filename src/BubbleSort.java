public class BubbleSort {
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void bubbleSort(int[] arr) {
        boolean isSwapped;
        for (int i = 0; i < arr.length - 1; i++) {
            isSwapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSwapped = true;
                }
            }
            if(!isSwapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 2, 4, 1, 3, 7, 8, 100};
        System.out.print("Original array: ");
        printArray(arr);
        System.out.println('\n');

        System.out.print("After sort elements: ");
        bubbleSort(arr);
        printArray(arr);
    }
}
