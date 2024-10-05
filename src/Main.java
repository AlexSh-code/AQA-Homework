import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println("Задание №1:");
        printThreeWords();
        System.out.println("Задание №2:");
        checkSumSign();
        System.out.println("Задание №3:");
        printColor();
        System.out.println("Задание №4:");
        compareNumbers();
        System.out.println("Задание №5:");
        System.out.println(checkTwoNumber(33,8));
        System.out.println("Задание №6:");
        positiveNegative(0);
        System.out.println("Задание №7:");
        System.out.println(positiveNegative2(-2));
        System.out.println("Задание №8:");
        printString("Hello", 4);
        System.out.println("Задание №9:");
        System.out.println(leapYear(2024));;
        System.out.println("Задание №10:");
        int[] arr = {1,1,0,0,1,0,1,1,0,0};
        swapArray(arr);
        System.out.println("Задание №11:");
        emptyArray();
        System.out.println("Задание №12:");
        int[] arr2 = {1,5,3,2,11,4,5,2,4,8,9,1};
        multiArray(arr2);
        System.out.println("Задание №13:");
        twoDimArray();
        System.out.println("Задание №14:");
        System.out.println(Arrays.toString(intLenArray(9,9)));


    }

    static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");

    }

    static void checkSumSign() {
        int a=5;
        int b=-6;
        int sum=a+b;
        if (sum>=0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }

    }

    static void printColor() {
        int value=100;
        if (value<=0) {
            System.out.println("Красный");
        } else if (0<value && value<=100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");

        }
    }

    static void  compareNumbers() {
        int a=-17;
        int b=-7;
        if (a>=b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    static boolean checkTwoNumber(int a, int b) {
        int s=a+b;
        return (10<=s) && (s<=20);
    }

    static void positiveNegative(int a) {
        if (a>=0) {
            System.out.println(a + " - положительное число");
        } else {
            System.out.println(a + " - отрицательное число");
        }
    }

    static boolean positiveNegative2 (int a) {
        return a < 0;
    }

    static void printString (String a, int b ) {
        for (int i=0; i<b; i++) {
            System.out.println(a);
        }
    }

    static boolean leapYear (int year) {
        return ((year %4==0 && year%100 !=0) || year %400==0);
    }

    static void swapArray(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            if (arr[i]==0) {
                arr[i] = 1;
            } else if (arr[i]==1) {
                arr[i]=0;
            }

        }
        System.out.println(Arrays.toString(arr));
    }

    static void emptyArray(){
        int[] arr = new int[100];
        for (int i=0; i<arr.length; i++) {
            arr[i] = i+1;
        }
        System.out.println(Arrays.toString(arr));

    }

    static void multiArray(int[] arr){
        for (int i=0; i<arr.length; i++) {
            if (arr[i]<6) arr[i] = arr[i]*2;
        }
        System.out.println(Arrays.toString(arr));
    }

    static void twoDimArray () {
        int[][] arr = new int [4][4];
        for (int i =0; i<arr.length; i++){
            for (int j=0, x=arr[i].length-1; j<arr.length; j++, x--) {
                if (i==j || i==x) arr[i][j] = 1;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[] intLenArray(int len, int initialValue) {
        int arr[] = new int[len];
        for (int i=0; i<arr.length; i++) {
            arr[i]=initialValue;
        }
        return arr;
    }


}