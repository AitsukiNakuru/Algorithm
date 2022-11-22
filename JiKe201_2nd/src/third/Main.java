package third;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    private void mian() {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Long sum = (long) 0;
        Long max =  (long) -1000000000;
        Long min = (long) 1000000000;
        boolean flag = true;
        for (int i = 0 ; i<n; i++) {
            int num = sc.nextInt();
            if (flag == false) {
                sum = sum +num;
                if (sum > max) {
                    max = sum;
                }
                continue;
            }
            if (sum + num >= min) {
                sum = sum +num;
                flag = true;
            }
            if (sum + num <= min) {
                sum = (long) 0;
                flag = false;
            }
            if (sum > max) {
                max = sum;
            }
        }
        System.out.println(max);
    }
}