package Lab_6;

public class TestSA {

	public static void main(String[] args) {
		Node initialState = new Node();
		initialState.displayBoard();
		System.out.println("H = " + initialState.getH());
		System.out.println("覧覧覧覧覧覧覧覧覧覧");

		Node re = null;
		try {
			re = SA.execute(initialState, 1000, 0.995);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("H = " + re.getH());
		re.displayBoard();

	}

}