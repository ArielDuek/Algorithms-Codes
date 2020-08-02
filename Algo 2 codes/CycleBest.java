public class CycleBest {



    public static int Calculate(int[] a)
    {
        int max = a[0],
                temp_max = 0,start = 0,
                end = 0, s = 0;

        for (int i = 0; i < a.length; i++)
        {
            temp_max += a[i];

            if (max < temp_max)
            {
                max = temp_max;
                start = s;
                end = i;
            }

            if (temp_max < 0)
            {
                temp_max = 0;
                s = i + 1;
            }
        }
        int sum =  max;
        int startIndex =  start;
        int endIndex = end;
        return sum;
    }

    public static int CycleBest(int[] a ){

        int tempsum = 0 ;
        int[] tempA = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            tempsum += a[i];
            tempA[i] = -a[i];
        }

        int sumCycle = tempsum + Calculate(tempA);
        return sumCycle;
    }

    public static void main(String[] args) {
       int[] a = {10,2,-5,8,-30,12};
        System.out.println(CycleBest(a));
    }


}




