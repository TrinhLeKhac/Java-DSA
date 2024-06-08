// Demo function printAll elements of an array

public class demoArray {
    public static void main(String[] args) {
        demoArray arrUtil = new demoArray();
        arrUtil.arrayDemo();
    }

    private void arrayDemo() {
        int[] myArray = new int[5];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = i;
        }
        Utils.printArrayBasic(myArray);
        System.out.println(myArray[myArray.length-1]);
    }


}
