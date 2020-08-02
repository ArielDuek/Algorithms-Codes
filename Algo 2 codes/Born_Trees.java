import java.util.LinkedList;

public class Born_Trees {



    public static int count_how_much_true(boolean[][] Mat , int i )
    {
        int count = 0 ;
        for (int j = 0; j < Mat[i].length; j++) {
            if(Mat[i][j])
            {
                count++;
            }
        }
        return count;
    }


    public static void bornTrees(boolean[][] adj)
    {
        int size = adj.length;
        int[] deg_of_the_tree  = new int[size];
        LinkedList<Integer> the_leafQ = new LinkedList<>();
        LinkedList<Integer> new_leafQ = new LinkedList<>();
        int count = size;
        int theSteps = 0  ;

        for (int i = 0; i < size; i++)
        {
            int temp = count_how_much_true(adj,i);
            deg_of_the_tree[i] = temp ;
            if(temp == 1) {the_leafQ.add(i);}
        }

        while (count > 2 )
        {
            theSteps++;
            while (!the_leafQ.isEmpty())
            {
                int pop_leaf = the_leafQ.pop();
                deg_of_the_tree[pop_leaf]--;
                if (deg_of_the_tree[pop_leaf] == 0) count--; // undirected?
                int nighebor = first_negibor(adj , pop_leaf);
                deg_of_the_tree[nighebor]--;
                if (deg_of_the_tree[nighebor] == 1) { new_leafQ.add(nighebor); }
            }
            the_leafQ = (LinkedList<Integer>) new_leafQ.clone();
            new_leafQ.clear();
        }
        if(count == 2)
        {
            System.out.println(the_leafQ.pop());
            System.out.println(the_leafQ.pop());

        }

        else
            System.out.println(the_leafQ.pop());

    }

    private static int first_negibor(boolean[][] adj, int pop_leaf)
    {
        int count = 0 ;
        for (int j = 0; j < adj[pop_leaf].length; j++) {
            if(adj[pop_leaf][j])
            {
               return j;
            }
        }
        return -1;

    }


    public static void main(String[] args) {
        boolean[][] graph = new boolean[9][9];

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
             graph[i][j] = false;
            }
        }
        graph[7][4] = true;
        graph[4][7] = true;
        graph[8][4] = true;
        graph[4][8] = true;
        graph[0][5] = true;
        graph[5][3] = true;
        graph[5][0] = true;
        graph[5][6] = true;
        graph[5][1] = true;
        graph[6][5] = true;
        graph[1][5] = true;
        graph[3][5] = true;
        graph[4][3] = true;
        graph[3][4] = true;
        graph[3][2] = true;
        graph[2][3] = true;


        bornTrees(graph);


    }
}
