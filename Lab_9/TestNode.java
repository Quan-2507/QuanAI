package Lab_9;

import java.util.Arrays;

public class TestNode {

	public static void main(String[] args) {
		Node node = new Node();
		Integer[] data = { 7 };
		node.addAll(Arrays.asList(data));

		MinimaxAlgo algo = new MinimaxAlgo();
		System.out.println("Numbers of tokens = 7");
		System.out.print("Value = ");
		algo.execute(node);
		System.out.println("Best next move for MIN: " + node.getBestNextMove());
		System.out.println("覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧");

		data[0] = 8;
		node.clear();
		node.addAll(Arrays.asList(data));
		System.out.println("Numbers of tokens = 8");
		System.out.print("Value = ");
		algo.execute(node);
		System.out.println("Best next move for MIN: " + node.getBestNextMove());
		System.out.println("覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧");

		data[0] = 9;
		node.clear();
		node.addAll(Arrays.asList(data));
		System.out.println("Numbers of tokens = 9");
		System.out.print("Value = ");
		algo.execute(node);
		System.out.println("Best next move for MIN: " + node.getBestNextMove());
	}
}