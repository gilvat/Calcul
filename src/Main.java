import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        //вод строки
        Scanner scan = new Scanner(System.in);
        String arif;
        System.out.print("Введите выражение:");
        arif = scan.nextLine();
        //System.out.println(arif);

        int count = new StringTokenizer(arif," ").countTokens();
        if (count != 3) {  //проверяем правильно введенного выражения
            System.out.println("Выражение введено не верно.");
            System.exit(1);
        }

        String[] arifMas = arif.split(" ");
        //System.out.println(Arrays.toString(arifMas));

        String[] arr = new String[]{"1","2","3","4","5","6","7","8","9","10","I","II","III","IV","V","VI","VII","VIII","IX","X"};
        String[] arr2 = new String[]{"+","-","*","/"};
        //System.out.print(arr.length);

        int Mark1 = 0;
        int Mark2 = 0;
        int Mark3 = 0;
        int A=0, B=0, S = 0;
        String Ss;

        for (int i=0; i<20; i++) {
            if (arifMas[0].equals(arr[i])) {
                if (i < 9) {
                    Mark1 = 1;
                    A = i + 1;
                } else {
                    Mark1 = 2;
                    A = i - 9;
                }
            }
            if (arifMas[2].equals(arr[i])) {
                if (i < 9) {
                    Mark2 = 1;
                    B = i + 1;
                } else {
                    Mark2 = 2;
                    B = i - 9;
                }
            }
        }

        // проверка правильности ввода чисел
        if (Mark1 != Mark2 || Mark1 == 0 ) {
            System.out.println("Выражение введено не верно.");
            System.exit(2);
        }
        // какие цифры введены
        // System.out.println(A);
        // System.out.println(B);
        // математическое действие
        for (int j=0; j<4; j++) {
            if (arifMas[1].equals(arr2[j])) {
                if (j == 0) {
                    S = A + B;
                    Mark3 = 1;
                }
                if (j == 1) {
                    S = A - B;
                    Mark3 = 1;
                }
                if (j == 2) {
                    S = A * B;
                    Mark3 = 1;

                }
                if (j == 3) {
                    S = A / B;
                    Mark3 = 1;
                }
            }
        }
        // System.out.println(S);
        // проверка правильности ввода математического оператора
        if (Mark3 == 0 ) {
            System.out.println("Выражение введено не верно.");
            System.exit(3);
        }
        if (Mark1 == 1) {
            System.out.println(S);
        }
        //переводим в римские
        else {
            String[] arr3 = new String[]{" ", "I","II","III","IV","V","VI","VII","VIII","IX","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
            if (S == 100) {
                System.out.print("C");
            }
            else {
                if (S<11) {
                    Ss = arr3[S];
                }
                else {
                    int des =  S/10+9;
                    int cis = S%10;
                    // System.out.println(des);
                    // System.out.println(cis);
                    Ss = arr3[des] + arr3[cis];
                }
                System.out.print(Ss);
            }
        }
    }
}
