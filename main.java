//PLEASE NOTE THAT THE SIZE OF THE GRAPH IS CURRENTLY SET TO 5.
//IF YOU WANT TO ADD MORE NODE, YOU WILL HAVE TO CHANGE IT IN THE NODE FILE

import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        //Initialize & declare the root of the Node
        Node root = new Node ();
        root.initializeGraph();
        Scanner kb = new Scanner(System.in);

        //Function to print the graph
        root.printGraph(root);

        //Declare the Node with the activity name and duration
        Node A = new Node("A", 3);
        //Node A1 = new Node("A", 10);
        Node B = new Node("B", 4);
        Node C = new Node("C", 4);
        Node D = new Node("D", 4);
        Node E = new Node("E", 4);

        //Add Nodes to root of the graph
        root.addNode(D);
        root.addNode(E);
        root.addNode(A);
        root.addNode(B);
        root.addNode(C);

        //root.addNode(A1);

        //Add dependencies (Prev, Now)
        root.addDependencies(A, A);
        //root.addDependencies(A, C);
        //root.addDependencies(A, D);
        //root.addDependencies(B, E);

        //Function to print the graph
        root.printGraph(root);
        System.out.println("------------------------------------");
        root.printDecOrder(root);

        //Function to print the dependencies
        A.printDependencies();
        E.printDependencies();
    }
}
