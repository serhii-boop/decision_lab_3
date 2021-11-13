import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;



public class Conderc {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new BufferedReader(new FileReader("C:\\Users\\serhi\\OneDrive\\Робочий стіл\\Теорія прийняття рішень\\2_lab\\src\\matrix.txt")));
        int rows = 6;
        int columns = 4;
        int[][] arr = new int[rows][columns];
        while (sc.hasNextLine()) {
            for (int i = 0; i < arr.length; i++) {
                String[] line = sc.nextLine().trim().split(" ");
                for (int j = 0; j < line.length; j++) {
                    arr[i][j] = Integer.parseInt(line[j]);
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }



        int maxA=0, maxB=0, maxC=0;
        char[] c;
        int a_sum = 0, b_sum = 0, c_sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 2; j++) {
                if (arr[i][j] == 1 && (arr[i][j++] != 2 || arr[i][j + 2] != 2)) {
                    a_sum += arr[i][3];
                } else if (arr[i][j] == 2 && (arr[i][j++] != 1 || arr[i][j + 2] != 1)) {
                    b_sum += arr[i][3];
                }
            }
        }
        System.out.println("Compare A and B\n" +
                "A - " + a_sum + ", B - " + b_sum);
        if (a_sum > b_sum) {
            maxA = maxA + 1;
            System.out.println("A > B");
        } else {
            maxB = maxB + 1;
            System.out.println("B > A");
        }





        a_sum=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 2; j++) {
                if (arr[i][j] == 1 && (arr[i][j++] != 3 || arr[i][j + 2] != 3)) {
                    a_sum += arr[i][3];
                } else if (arr[i][j] == 3 && (arr[i][j++] != 1 || arr[i][j + 2] != 1)) {
                    c_sum += arr[i][3];
                }
            }
        }
        System.out.println("Compare A and C\n" +
                "A - " + a_sum + ", C - " + c_sum);
        if (a_sum > c_sum) {
            maxA = maxA + 1;
            System.out.println("A > C");
        } else {
            maxC = maxC + 1;
            System.out.println("C > A");}

        b_sum=0;
        c_sum=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 2; j++) {
                if (arr[i][j] == 2 && (arr[i][j++] != 3 || arr[i][j + 2] != 3)) {
                    b_sum += arr[i][3];
                } else if (arr[i][j] == 3 && (arr[i][j++] != 2 || arr[i][j + 2] != 2)) {
                    c_sum += arr[i][3];
                }
            }
        }
        System.out.println("Compare B and C\n" +
                "B - " + b_sum + ", C - " + c_sum);
        if (b_sum > c_sum) {
            maxB = maxB + 1;
            System.out.println("B > C");
        } else {
            maxC = maxC + 1;
            System.out.println("C > B");}


        if (maxA > maxB && maxA > maxC) {
            System.out.println("Переміг кандидат A");
        } else if (maxB > maxC && maxB > maxA) {
            System.out.println("Переміг кандидат B");
        } else {
            System.out.println("Переміг кандидат C ");
        }

    }
}
