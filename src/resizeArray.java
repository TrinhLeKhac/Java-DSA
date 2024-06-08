// Given an array of integers, resize the array to new capacity

// Input
//   - Given an array of integers - {1, 2, 3, 4, 5}
//   - Resize array to new capacity (2 * array.length)

// Output
//  {1, 2, 3, 4, 5, 0, 0, 0, 0, 0}

public class resizeArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Utils.printArray(arr);
        int[] newArr = resizeArr(arr, arr.length*2);
        Utils.printArray(newArr);
    }

    private static int[] resizeArr(int[] arr, int capacity) {
        int[] newArr = new int[capacity];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        System.out.println("Size: " + newArr.length);
        System.out.println("Last element: " + newArr[newArr.length-1]);
        return newArr;
    }
}
