// Computes the periodical payment necessary to pay a given loan.
public class LoanCalc {
	
	static double epsilon = 0.001;  // Approximation accuracy
	static int iterationCounter;    // Number of iterations 
	
	// Gets the loan data and computes the periodical payment.
    // Expects to get three command-line arguments: loan amount (double),
    // interest rate (double, as a percentage), and number of payments (int).  
	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);

		// Computes the periodical payment using brute force search
		System.out.print("\nPeriodical payment, using brute force: ");
		System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);
		iterationCounter = 0;
		// Computes the periodical payment using bisection search
		System.out.print("\nPeriodical payment, using bi-section search: ");
		System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);
	}

	// Computes the ending balance of a loan, given the loan amount, the periodical
	// interest rate (as a percentage), the number of periods (n), and the periodical payment.
	// the customer give the details on the loan and how much he want to pay each year
	// 1. from year 1 we start to count
	// 2. we each time taking the (loan - payment) * rate n times
	private static double endBalance(double loan, double rate, int n, double payment) {	
		for (int i=1 ; i<=n ; i++){
			loan -= payment;
			loan *= ((rate+100)/100);
		}
		return loan;
	}
	
	// Uses sequential search to compute an approximation of the periodical payment
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
	// if the endbalance above 0 we need to pay more on the payment if it less ...
	// 
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
		double g = loan/n;
		while (endBalance(loan, rate, n, g) > 0) {
			g += epsilon;
			iterationCounter++;
		}
		return g;
    }
    
    // Uses bisection search to compute an approximation of the periodical payment 
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
	// we need to create f(x)>0 and f(y)<0 and than fx+fy/2 
	// if fx+fy/2 > 0 fx = fx+fy/2 
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
		double H = loan/n;
		double L = loan*1.01;
		double g = (L+H)/2.0; 
		while (Math.abs(endBalance(loan, rate, n, H)-endBalance(loan, rate, n, L)) > epsilon) {
			if (endBalance(loan, rate, n, g)>0 ) {
				H = g;				
			}else {
				L = g;
			}
			g = (L+H)/2;
			iterationCounter++;
		}
		return g;
    }
}