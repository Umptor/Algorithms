public class Main {

	public static void main(String args[]) {

		BSBaum b = new BSBaum();
		b.add(5);
		b.add(3);
		b.add(2);
		b.add(8);
		b.add(7);
		b.add(4);
		b.add(1);
		b.delete(4);


		b.delete(1);
		b.delete(7);
		b.delete(8);
		b.delete(2);
		b.delete(3);
		b.delete(5);
		b.delete(5);
		b.printInorder();
		//System.out.println(b.delete(2));
	}
}
