import java.util.ArrayList;

@SuppressWarnings("ALL")
public class BSBaum<E extends Comparable> {

	static int nodeCounter = 0;

	private class Node<E extends Comparable> {

		private E element;
		private boolean exists = false;
		private Node left = null;
		private Node right = null;
		private Node parent = null;
		private int id = 0;


		public Node(E element, Node<E> parent) {
			this.element = element;
			this.parent = parent;
			left = new Node(this);
			right = new Node(this);
			exists = true;
			this.id = ++nodeCounter;
		}

		Node(boolean exists, Node<E> parent, int dir) {
			this.setParent(parent, dir);
		}

		Node(Node<E> parent) {
			left = new Node(false, this, 0);
			right = new Node(false, this, 1);
			this.parent = parent;
		}

		Node() {
			left = new Node(false, this, 0);
			right = new Node(false, this, 1);
		}

		public E getElement() {
			return element;
		}

		public boolean isExists() {
			return exists;
		}

		public Node getLeft() {
			return left;
		}

		public Node getRight() {
			return right;
		}

		public void setLeft(Node left) {
			this.left = left;
			left.parent = this;
		}

		public void setRight(Node right) {
			this.right = right;
			right.parent = this;
		}

		public Node getParent() {
			return parent;
		}

		public void setParent(Node parent, int dir) {
			if(dir == 0)
				parent.setLeft(this);
			else if(dir == 1)
				parent.setRight(this);
		}

		public boolean hasRight() {
			if(right == null)
				return false;
			return right.exists;
		}

		public boolean hasLeft() {
			if(left == null)
				return false;
			return left.exists;
		}
	}

	private Node<E> root = new Node<>(new Node<E>());

	public BSBaum(E e) {
		root.setRight(new Node<>(e, root));

	}

	public BSBaum() {
	}

	public void add(E e) {
		if(!root.hasRight()) {
			root.setRight(new Node<E>(e, root));
			return;
		}

		Node item = root.right;

		while(true) {
			if(e.compareTo(item.element) > 0) {
				if(item.hasRight())
					item = item.right;
				else {
					item.setRight(new Node<>(e, item));
					break;
				}
			}
			else {
				if(item.hasLeft())
					item = item.left;
				else {
					item.setLeft(new Node<>(e, item));
					break;
				}
			}
		}
	}

	public void printInorder() {
		ArrayList<Node> arr = new ArrayList<>();
		arr = treeTraverse(root.right, arr);
		for(Node n : arr)
			System.out.println(n.element);
	}

	private ArrayList<Node> treeTraverse(Node<E> start, ArrayList<Node> arr) {
		if(start.hasLeft())
			arr = treeTraverse(start.left, arr);
		if(start.isExists())
			arr.add(start);
		if(start.hasRight())
			arr = treeTraverse(start.right, arr);
		return arr;
	}

	public int delete(E e) {

		if(!root.hasRight())
			return -1;

		Node item = root.right;
		int dir = 1;                /// / 0 for left 1 for right

		while(item.element.compareTo(e) != 0) {
			if(e.compareTo(item.element) > 0) {
				if(!item.hasRight())
					return -1;
				item = item.getRight();
				dir = 1;
			}
			else if(e.compareTo(item.element) < 0) {
				if(!item.hasLeft())
					return -1;
				item = item.getLeft();
				dir = 0;
			}
			else break;
		}

		Node replaceWith;
		int dir2 = dir;

		if(item.hasRight()) {
			replaceWith = item.right;
			dir2 = 1;
		}
		else if(dir == 0) {
			item.parent.setLeft(item.getLeft());
			return 1;
		}
		else {
			item.parent.setRight(item.getLeft());
			return 1;
		}

		while(replaceWith.hasLeft()) {
			replaceWith = replaceWith.left;
			dir2 = 0;
		}

		replaceWith.right.setParent(replaceWith.parent, dir2);

		item.element = replaceWith.element;

		return 1;
	}
}























