import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;



public class Bord {
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


        int sumA0 = 0, sumA2 = 0, sumA1 = 0;
        int sumB0 = 0, sumB2 = 0, sumB1 = 0;
        int sumC0 = 0, sumC2 = 0, sumC1 = 0;
        int A, B, C;
        int a_sum=0, b_sum=0, c_sum=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1) {
                    if (j == 0) {
                        A = arr[i][3] * 3;
                        sumA0 += A;
                    }
                    if (j == 1) {
                        A = arr[i][3] * 2;
                        sumA1 += A;
                    }
                    if (j == 2) {
                        A = arr[i][3];
                        sumA2 += A;
                    }
                    a_sum = sumA0+sumA1+sumA2;
                }

                if (arr[i][j] == 2) {
                    if (j == 0) {
                        B = arr[i][3] * 3;
                        sumB0 += B;
                    }
                    if (j == 1) {
                        B = arr[i][3] * 2;
                        sumB1 += B;
                    }
                    if (j == 2) {
                        B = arr[i][3];
                        sumB2 += B;
                    }
                    b_sum = sumB0+sumB1+sumB2;
                }
                if (arr[i][j] == 3) {
                    if (j == 0) {
                        C = arr[i][3] * 3;
                        sumC0 += C;
                    }
                    if (j == 1) {
                        C = arr[i][3] * 2;
                        sumC1 += C;
                    }
                    if (j == 2) {
                        C = arr[i][3];
                        sumC2 += C;
                    }
                    c_sum = sumC0+sumC1+sumC2;
                }

            }
        }
        int max;
        if (a_sum > b_sum && a_sum > c_sum) {
            max = a_sum;
            System.out.println("Переміг кандидат A - " + max);
        } else if (b_sum > c_sum && b_sum > a_sum) {
            max = b_sum;
            System.out.println("Переміг кандидат B - " + max);
        } else {
            max = c_sum;
            System.out.println("Переміг кандидат C - " + max);
        }

        System.out.println("Кандидат A набрав - " + a_sum);
        System.out.println("Кандидат B набрав - " + b_sum);
        System.out.println("Кандидат C набрав - " + c_sum);
    }
}
