package Lab_6;

public class Test {

	public static void main(String[] args) {
		GeneticAlgo ga = new GeneticAlgo();
		Node re = ga.execute();
		System.out.println("H = " + re.getH());
		re.displayBoard();
	}
}
