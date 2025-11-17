// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(0,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(-4,4));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	// if a or b =0 return the x or b
	// we need to count i a times
	// "          " b times
	// need i will be i>=a and i >=b
	public static int plus(int x1, int x2) {
		int i =0;
		int j =0;
		if (x2 == 0 ){
			return x1;
		}else if (x1 == 0 ){
			return x2;
		}else if (x1<0 && x2 <0){
			 { while (i>x1){
			i--;
		} 	while (j > x2 ) {
			i--;
			j--;
		}return i;
	}
		}else if ((x1 < 0 && x2>0)){
			while (i>x1) {
				i--;
				}
				while (j<x2) {
					i++;
					j++;
				}return i;
			}else if ((x2 < 0 && x1>0)){
			while (i>x2) {
				i--;
				}
				while (j<x1) {
					i++;
					j++;
				}return i;
			}
			else { while (i<x1){
			i++;
		} while (j <x2 ) {
			i++;
			j++;
		}return i;
	}
}

	

	// Returns x1 - x2

	public static int minus(int x1, int x2) {
		int i =0;
		int j =0;
		if (x2 == 0 ){
			return x1;
		}else if (x1 == 0 ){
			return -x2;
		}else if (x2<0 && x1>0){
			int a = plus(x1, -x2);
			return a;
		}else if ((x1<0 && x2>0) ||(x1<0 && x2<0 )){
			int a = plus(x1, x2);
			return a;
		}
		else { while (i<x1){
			i++;
		} while (j <x2 ) {
			i--;
			j++;
		}
	}return i;
}
	

	// Returns x1 * x2
	// we need to use plus
	//if x1 or x2 == 0 ret 0
	// if x1 xor x2 negative 
	public static int times(int x1, int x2) {
		int i = 0;
		int j = 0;
		if (x1 == 0 || x2 == 0)
			return 0;
		else if (x1 < 0 || x2 < 0){
			if (x2 <0) {
				x2 = -x2;
				while ( i < x2 ){
					j=plus(j, x1);
					i++;
				}return -j;
			}else if (x1<0) {
				x1 = -x1;
				while (i<x1) {
					j = plus(j, x2);
					i++;
				}return -j;
			}
		}else if (!(x1 < 0 ^ x2 < 0)){
			while ( i<x2 ){
				j=plus(j, x1);
				i++;
		}
	}return j;
}
	// Returns x^n (for n >= 0)
	// x*x n times5
	public static int pow(int x, int n) {
		int j = 1;
		if (n == 0){
			return 1;
		}else {for (int i = 0; i < n; i++){
			j = times(j, x);
			
		}
	}
		return j;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int i = 0 ;
		int j = 0;
		if (x1 == 0) {
			return 0;
		}
		if (x2 == 0){
			return -1;
		}else if (x1>0 && x2<0){
			while (j<x1) {
			j = plus(j, -x2);
			i++;
		}
		if (times(i, -x2) > x1) {
			i-=1;
		}return -i;
		}else if (x1<0 && x2>0) {
		while (j<-x1) {
			j = plus(j, x2);
			i++;
		}if (times(i, x2) > -x1) {
			i-=1;
		}return -i;
	}		
		else {while (j<x1) {
			j = plus(j, x2);
			i++;
		} 
		if (times(i, x2) > x1) {
			return --i;
		}return i;
	}
}
	

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		if (x1 == 0) {
			return 0;
		}
		if (x2 == 0){
			return -1;
		}else if (x1 < x2) {
			return x1;
	}	return minus(x1 , times(div(x1,x2), x2));
}

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int i = 2;
		if (x == 1 || x == 0) {
			return x;
		}else { while (pow(i, 2)<x){
			i++;
		}
		if (pow(i, 2) == x) {
			return i;
		}
		}
		return--i;
	}	  	  
}