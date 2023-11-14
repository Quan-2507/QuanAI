package Lab_7;

public class Test{

	public static void main(String[] args) {
		GA_NQueenAlgo ga = new GA_NQueenAlgo();

		Node re = ga.execute();
		System.out.println("H = " + re.getH());
		re.displayBoard();
		
	}

}