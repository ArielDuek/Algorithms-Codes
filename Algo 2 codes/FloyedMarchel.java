
import java.util.Arrays;

public class FloyedMarchel {


    public static int[][] FW(int[][] weight)
    {
        int n  = weight.length;
        int[][] dist = new int[n][n];

        for (int i = 0; i < weight.length; i++) {
            for (int j = 0; j < weight[0].length; j++) {
                dist[i][j] = weight[i][j] ;
            }
        }

        for (int k = 0; k < n; k++)
        {
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++) {
                    if(dist[i][j] > dist[i][k] + dist[k][j]  && dist[i][k] + dist[k][j]  >= 0)
                    {
                        dist[i][j] = dist[i][k] + dist[k][j] ;
                    }

                }
            }

        }

        return dist ;
    }



    public static Node[][] FWandPath(int[][] weight)
    {
        int n  = weight.length;
        Node[][] dist = new Node[n][n];

        for (int i = 0; i < weight.length; i++) {
            for (int j = 0; j < weight[0].length; j++) {
                dist[i][j].weight =weight[i][j] ;
                dist[i][j].s = "" +weight[i][j] ;

            }
        }

        for (int k = 0; k < n; k++)
        {
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++) {
                    if(dist[i][j].weight > dist[i][k].weight + dist[k][j].weight  && dist[i][k].weight + dist[k][j].weight  >= 0  )
                    {
                        dist[i][j].weight = dist[i][k].weight + dist[k][j].weight ;
                        dist[i][j].s = dist[i][k].s + dist[k][j].s ;

                    }

                }
            }

        }

        return dist ;
    }


    public static void main(String[] args) {

         int [][] graph = { {0,   5, Integer.MAX_VALUE , 10},
                            {Integer.MAX_VALUE,  0,  3,  Integer.MAX_VALUE},
                            {Integer.MAX_VALUE, Integer.MAX_VALUE, 0,   1},
                             {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0} };

         Node[][] dist = FWandPath(graph);

        for (int i = 0; i < dist.length; i++) {
            System.out.println( Arrays.toString(dist[i]));
        }

    }


}