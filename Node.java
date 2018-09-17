import java.util.*;

public class Node {
    private String activityName;
    private int duration;
    private List<Node> dependencies;
    public ArrayList<Node> test = new ArrayList<Node>(5);
    LinkedList<Node> adjListArray[] = new LinkedList[5];

    //Default Constructor
    public Node()
    {
        this.activityName = "N/A";
        this.duration = 0;
        dependencies = new ArrayList<Node>();
    }

    //Parameterized Constructor.
    public Node(String activityName, int duration)
    {
        this.activityName = activityName;
        this.duration = duration;
        dependencies = new ArrayList<Node>();
    }

    //Getter
    public String getActivityName()
    {
        return activityName;
    }

    //Getter
    public int getDuration()
    {
        return duration;
    }

    //Setter
    public void setActivityName(String activityName)
    {
        this.activityName = activityName;
    }

    //Setter
    public void setDuration(int duration)
    {
        this.duration = duration;
    }

    //Function to add dependencies with the prev Node and the current Node
    public void addDependencies(Node prev, Node now)
    {
        //Set the dependencies to the array list of the current Node
        now.dependencies.add(prev);

        String prevString = prev.getActivityName();

        //Loop to assign the Node to the right position
        for (int y = 0; y < 5; y++)
        {
            if (adjListArray[y].get(0).getActivityName().equals(prevString))
            {
                adjListArray[y].addLast(now);
            }
        }
    }

    //Function to print the dependencies
    public void printDependencies()
    {
        if (dependencies.size() == 0)
        {
            System.out.println(activityName + " does not have any dependencies");
            return;
        }
        String print = activityName + " has the dependencies ";
        for (int i = 0; i < dependencies.size(); i++)
        {
            String p = dependencies.get(i).activityName + ", ";
            print += p;
        }
        System.out.println(print);
    }

    public Node getDep(String actName)
    {
        for (int i = 0; i < dependencies.size(); i++) {
            if (dependencies.get(i).getActivityName().equals(actName)) {
                return dependencies.get(i);
            }
        }
        return null;
    }


    //Function to initialize graph
    public void initializeGraph ()
    {
        //Loop through the array and set the linked list (SIZE IS CURRENTLY 5)
        for(int i = 0; i < 5 ; i++)
        {
            adjListArray[i] = new LinkedList<>();
        }
    }

    //Function to add Node to graph
    public void addNode (Node current)
    {
        int choice;

        //Loop through the array of linked list (SIZE IS CURRENTLY 5)
        for (int counter = 0; counter < 5; counter++)
        {
            //If there is a duplicate, ask user to replace it or discard it
            if (adjListArray[counter].isEmpty() != true && adjListArray[counter].get(0).getActivityName() == current.getActivityName())
            {
                Scanner kb = new Scanner(System.in);
                System.out.println("We have detected a duplicate node with the same activity name and/or with different duration. ");
                System.out.println("This is that we have thus far:" + " " + adjListArray[counter].get(0).getActivityName() + " " + "with the duration:" + " " + adjListArray[counter].get(0).getDuration());
                System.out.println("\nYou have inputted:" + " " + current.getActivityName() + " " + "for the activity name" + " and " + current.getDuration() + " for the duration."  );
                System.out.println("Are you sure that you want to overwrite the previous node? (1/0)");
                choice = kb.nextInt();

                if (choice == 1)
                {
                    adjListArray[counter].clear();
                    adjListArray[counter].add(current);
                }
                break;
            }

            //Otherwise add it to the graph
            else if (adjListArray[counter].isEmpty() == true)
            {
                adjListArray[counter].add(current);
                break;
            }
        }


    }

    //Function to print the graph
    static void printGraph(Node graph)
    {
        for(int v = 0; v < 5; v++)
        {
            System.out.println("Adjacency list of vertex "+ v);
            System.out.print("head");
            for(Node pCrawl: graph.adjListArray[v]){
                System.out.print(" -> "+pCrawl.getActivityName()+","+pCrawl.getDuration());
            }
            System.out.println("\n");
        }
    }
}
