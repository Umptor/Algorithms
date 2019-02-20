internal class Node {
	var value: Int = 0
	var isRed: Boolean = true
	var parent: Node? = null
	var left: Node? = null
	var right: Node? = null
	val isRoot: Boolean
		get() = parent == null

	constructor(value: Int) {
		this.value = value
	}

	constructor(value: Int, parent: Node) {
		this.value = value
		this.parent = parent
	}

	fun changeParent(newParent: Node?, oldChild: Node) {
		if(newParent != null) {
			if(newParent.right == oldChild)
				newParent.right = this
			else if(newParent.left == this)
				newParent.left = this
		}
		this.parent = newParent
	}
}

internal class BlackRedBST {

	var root: Node? = null


	fun addNode(toAdd: Int) {

		if(root == null) {
			root = Node(toAdd)
			root!!.isRed = false
			return
		}

		var parent: Node = root!!
		var curr = root
		var wentRight = false

		while(curr != null) {
			parent = curr
			when {
				toAdd > curr.value -> {
					curr = curr.right
					wentRight = true
				}
				toAdd < curr.value -> {
					curr = curr.left
					wentRight = false
				}
				else -> {
					println("Already exists"); return
				}
			}
		}

		val newNode = Node(toAdd, parent)
		when(wentRight) {
			true -> parent.right = newNode
			else -> parent.left = newNode
		}

		diagnose(parent)


	}

	private fun diagnose(parent: Node) {

		val right = parent.right
		val left = parent.left

		fixRoot()

		if(parent.isRoot) {
			if(parent.isRed) {
				leftRotate(parent)
				return
			}
		}

		if(right != null) {
			if(left != null) {
				if(right.isRed && left.isRed) {
					right.isRed = false
					left.isRed = false
					parent.isRed = true
					if(parent.parent != null)
						diagnose(parent.parent!!)
					else
						fixRoot()
					return
				}
			}
			if(right.isRed) {
				leftRotate(parent)
				diagnose(right)
				return
			}
		}
		if(left != null) {
			if(left.left != null) {
				if(left.isRed && left.left!!.isRed) {
					rightRotate(parent)
					diagnose(left)
					return
				}
			}
		}
		if(right != null && left != null && left.isRed && right.isRed) {
			right.isRed = false
			left.isRed = false
			diagnose(parent)
		}
	}

	private fun fixRoot() {
		if(!root!!.isRoot) {
			var newRoot: Node? = root
			while(newRoot!!.parent != null)
				newRoot = newRoot.parent
			root = newRoot
		}
		if(root != null) {
			if(root!!.isRed) {
				root!!.isRed = false
				if(root!!.left != null)
					root!!.left!!.isRed = true
			}
		}
	}

	private fun leftRotate(parent: Node) {
		val right = parent.right!!

		parent.right = right.left
		right.parent = parent.parent
		if(parent.parent != null) {
			if(parent.parent!!.left!! == parent)
				parent.parent!!.left = right
			else
				parent.parent!!.right = right
		}

		parent.parent = right
		right.left = parent
		right.isRed = false
		parent.isRed = true

	}

	private fun rightRotate(parent: Node) {
		val left = parent.left!!

		left.parent = parent.parent
		parent.parent = left
		left.right = parent
		left.left!!.isRed = false
		left.isRed = true
	}

	private fun treePrinter(arr: ArrayList<Node>) {

		var newArr = ArrayList<Node>()

		if(arr.size == 0)
			return

		arr.forEach {
			if(it.left != null) {
				newArr.add(it.left!!)
				if(it.isRed)
					print("Red ")
				print("" + "L" + it.left!!.value + " ")
			}
			if(it.right != null) {
				newArr.add(it.right!!)
				if(it.isRed)
					print("Red" )
				print("" + "R" + it.right!!.value + " ")
			}
		}

		println("")
		treePrinter(newArr)
	}

	private fun treePrinterHelper(arr: ArrayList<Node>, cur: Node) {

		if(cur.left != null)
			if(cur.left!!.isRed)
				treePrinterHelper(arr, cur.left!!)

		arr.add(cur)
		print("" + cur.value + " ")
	}

	fun printTree() {
		val arr = ArrayList<Node>()
		if(root == null) {
			println("Empty")
			return
		}
		arr.add(root!!)
		println("" + root!!.value)
		treePrinter(arr)
	}
}

	fun main(args: Array<String>) {

		val numbers = readLine()!!.split(' ').map { it.toInt() }

		val myTree = BlackRedBST()
		for(num in numbers) {
			myTree.addNode(num)
		}
		myTree.printTree()

	}


// 5 8 6 4 7 9