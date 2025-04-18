// Prime: số nguyên tố


import java.util.Scanner;

public class PrimeSoNguyenTo {

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Nhập số nguyên tố muốn kiểm tra: ");
        int n = sc.nextInt();
        boolean result = isPrime(n);
        System.out.println("n: " + result);
        
        System.out.print("In đến số: ");
        int k = sc.nextInt();
        printPreimeList(k);
    }
//Kiểm tra có phải số nguyên tố không
    public static boolean isPrime(int n){
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0)
                return false;

            return true;
    }
//In ra các số nguyên tố từ 1 đến 1000    
    public static void printPreimeList(int k) {
        System.out.println("The list of primes from 1....."  + k );
        for (int i = 1; i <= k; i++)
            if (isPrime(i) == true)  // chỉ ghi if(isPrime(i)) cũng sẽ run tiếp trong if nếu true
                System.out.print(i + " ");
    }
}
