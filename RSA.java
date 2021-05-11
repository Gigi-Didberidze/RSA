import java.math.*;
import java.util.*;

public class RSA {
	public static void main(String args[]){
		int p, q, n, phi, d = 0, e;

		Scanner a = new Scanner(System.in);
		System.out.println("Message to encrypt and decrypt: ");
		int msg = a.nextInt();
		double c;
		BigInteger dec;

		System.out.println("Enter the 1st prime number p: ");
		p = a.nextInt();
		boolean flagp = false;
		for (int i = 2; i <= p / 2; ++i){
			if (p % i == 0){
				flagp = true;
				break;
			}
		}

        	if (!flagp)
			System.out.println(p + " is a prime number.");
		else{
			System.out.println("Output: Entered number "+p+" is not prime, run the program again and enter prime numbers");
			System.exit(0);
		}

		System.out.println("Enter the 2nd prime number q: ");
		q = a.nextInt();
		boolean flagq = false;
		for (int j = 2; j <= q / 2; ++j){
			if (q % j == 0){
				flagq = true;
				break;
		}
		}
		if (!flagq)
			System.out.println(q + " is a prime number.");
		else{
			System.out.println("Output: Entered number "+q+" is not prime, run the program again and enter prime numbers");
			System.exit(0);
		}
		n = p * q;
		phi = (p - 1) * (q - 1);
		System.out.println("\nthe value of phi = " + phi);
		
		for (e = 2; e < phi; e++){
			if (gcd(e, phi) == 1){
				break;
		}
		}
		System.out.println("the value of e = " + e);
		for (int k = 0; k <= 9; k++){
			int x = 1 + (k * phi);
			if (x % e == 0){
				d = x / e;
				break;
			}
		}
		System.out.println("the value of d = " + d);
		System.out.println("\nPublic key = " +"{"+e +","+n+"}");
		System.out.println("Private key = " +"{"+d +","+n+"}\n");

		c = (Math.pow(msg, e)) % n;
		System.out.println("Encrypted message is : " + c);

		BigInteger N = BigInteger.valueOf(n);

		BigInteger C = BigDecimal.valueOf(c).toBigInteger();
		dec = (C.pow(d)).mod(N);
		System.out.println("Decrypted message is : " + dec);
		}

	static int gcd(int e, int phi){
		if (e == 0)
			return phi;
		else
			return gcd(phi % e, e);
		}
}
