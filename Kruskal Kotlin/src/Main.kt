var edges = ArrayList<ArrayList<Int>>()
var colors = ArrayList<Int>()
var newColor = 0

fun getMinEdge(): Pair<Int, Int> {
    //Gets the minimum quite ineffectively by going through each possible edge and finding the minimum

    var edge1 = 0
    var edge2 = 0
    var weight = Int.MAX_VALUE
    for (i in (0 until edges.size)) {
        for(j in (0 until edges.size)) {
            if(edges[i][j] < weight) {
                edge1 = i
                edge2 = j
                weight = edges[i][j]
            }
        }
    }
    // If it cannot find a new edge then it return a pair with the values below
    if(weight == Int.MAX_VALUE)
        return Pair(Int.MAX_VALUE, Int.MAX_VALUE)
    return Pair(edge1, edge2)
}

fun kruskal(edge: Pair<Int, Int>, arr: ArrayList<Pair<Int, Int>>): ArrayList<Pair<Int, Int>> {
    /*
        0) The first if is to check if there are no remaining edges
            If so then the function ends

        There are 5 different states that can happen
        1)
            The 2 nodes that need to be added are the same color and have been colored
            This means that if we combine them there would be a loop so we need to remove this edge and continue

        2)  The 2 nodes both have not been colored
            This means that a new color is needed and the 2 nodes will be combined with this new color

        3 & 4)  These are to check if one of the nodes has a color and the other doesn't
                If it is so, then the node without the color is colored like the one with a color

        5)  Else the 2 nodes are different colors other than -1
            This means that one of the colors is removed and all nodes that have this color are colored like the second node

        6)  At the end the route between the 2 nodes is destroyed and the everything starts again

     */
    //  Step 0
    if(edge.first == Int.MAX_VALUE) {
        return arr
    }// Step 1
    if(colors[edge.first] == colors[edge.second] && colors[edge.second] != -1 && colors[edge.first] != -1)  {
        edges[edge.first][edge.second] = Int.MAX_VALUE
        return kruskal(getMinEdge(), arr)
    } // Step 2
    else if(colors[edge.first] == -1 && colors[edge.second] == -1) {
        colors[edge.first] = newColor
        colors[edge.second] = newColor
        newColor++
        arr.add(Pair(edge.first, edge.second))
    } // Step 3
    else if(colors[edge.first] == -1 && colors[edge.second] != -1) {
        colors[edge.first] = colors[edge.second]
        arr.add(Pair(edge.first, edge.second))

    } // Step 4
    else if(colors[edge.second] == -1 && colors[edge.first] != -1) {
        colors[edge.second] = colors[edge.first]
        arr.add(Pair(edge.first, edge.second))
    }
    else { // Step 5
        val color = colors[edge.first]
        arr.add(Pair(edge.first, edge.second))
        for(i in 0 until colors.size) {
            if(colors[i] == color) {
                colors[i] = colors[edge.second]
            }
        }
    }
    // Step 6
    edges[edge.first][edge.second] = Int.MAX_VALUE
    return kruskal(getMinEdge(), arr)
}

fun fillArr(n: Int) {

    // The default value for the edges are Int.MAX_VALUE
    for (i in 0..n) {
        var bob = ArrayList<Int>()
        for(i in 0..n)
            bob.add(Int.MAX_VALUE)
        edges.add(bob)
    }

    // The default value for all the colors is -1
    for(i in 0..n) {
        colors.add(-1)
    }

}

fun main() {
    val edgeCount = readLine()!!.toInt()
    fillArr(edgeCount)

    for (i in 0 until edgeCount) {
        val edge = readLine()!!.split(" ").map { it -> it.toInt() }

        edges[edge[0]][edge[1]] = edge[2]

    }

    val a = kruskal(getMinEdge(), ArrayList())
    a.forEach {
        println("${it.first}  -  ${it.second}")
    }
}


/*
input:
number of edges
node1 node2 length

 */


/*
10
1 2 6
1 7 5
1 3 7
1 6 4
2 7 2
3 4 3
4 8 8
5 4 7
5 6 6
6 8 5






11
1 8 4
1 2 6
1 5 3
2 7 7
3 4 2
3 6 5
4 6 8
4 7 1
5 6 4
5 7 6
7 8 6



 */