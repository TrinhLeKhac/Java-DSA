package stream;

import java.io.*;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Vector;

public class sequenceInputStream {

    public static void firstDemo() throws IOException {
        FileInputStream fin1 = new FileInputStream("src/stream/input1.txt");
        FileInputStream fin2 = new FileInputStream("src/stream/input2.txt");
        SequenceInputStream sin = new SequenceInputStream(fin1, fin2);
        FileOutputStream fout = new FileOutputStream("src/stream/outputFirstDemo.txt");
        int j;
        while ((j = sin.read()) != -1) {
//            System.out.print((char)j);
            fout.write(j);
        }
        fin1.close();
        fin2.close();
        sin.close();
        fout.close();
        System.out.println("Finished demo 1");
    }

    public static void secondDemo() throws IOException {
        // Using enumerate from Vector.elements when read sequenceInputStream from more than 2 files
        FileInputStream fin1 = new FileInputStream("src/stream/input1.txt");
        FileInputStream fin2 = new FileInputStream("src/stream/input2.txt");
        FileInputStream fin3 = new FileInputStream("src/stream/input3.txt");
        FileInputStream fin4 = new FileInputStream("src/stream/input4.txt");
        FileOutputStream fout = new FileOutputStream("src/stream/outputSecondDemo.txt");
        Vector<FileInputStream> v = new Vector<>();
        v.add(fin1);
        v.add(fin2);
        v.add(fin3);
        v.add(fin4);
        Enumeration<FileInputStream> enumFileInputStream = v.elements();
        SequenceInputStream sin = new SequenceInputStream(enumFileInputStream);
        int j;
        // read byte to byte
        while ((j = sin.read()) != -1) {
            System.out.print((char)j);
            fout.write(j);
        }
        // close resources
        fin1.close();
        fin2.close();
        fin3.close();
        fin4.close();
        fout.close();
        sin.close();
    }

    public static void thirdDemo() throws IOException {
        // try-with-resources
        try (
                FileInputStream fin1 = new FileInputStream("src/stream/input1.txt");
                FileInputStream fin2 = new FileInputStream("src/stream/input2.txt");
                FileInputStream fin3 = new FileInputStream("src/stream/input3.txt");
                FileInputStream fin4 = new FileInputStream("src/stream/input4.txt");
                FileOutputStream fout = new FileOutputStream("src/stream/outputSecondDemo.txt");

                // Using enumerate from Vector.elements when read sequenceInputStream from more than 2 files
                SequenceInputStream sin = new SequenceInputStream(new Vector<>(Arrays.asList(fin1, fin2, fin3, fin4)).elements())
        ) {
            int j;
            while ((j = sin.read()) != -1) {
                System.out.print((char)j);
                fout.write(j);
            }
        } // automatically close in there
    }

    public static void main(String[] args) throws IOException {
        firstDemo();
        secondDemo();
        thirdDemo();
    }
}
