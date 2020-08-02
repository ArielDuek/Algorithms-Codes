public class Gas_Station {

    public static int best(int[] a)
    {
        int max = a[0], temp_max = 0,start = 0, s = 0;

        for (int i = 0; i < a.length; i++)
        {
            temp_max += a[i];

            if (max < temp_max)
            {
                max = temp_max;
                start = s;
            }

            if (temp_max < 0)
            {
                temp_max = 0;
                s = i + 1;
            }
        }
        return start;
    }


    public static int fuelStation(int[] a, int[] b) {
        int sum1 = 0;
        int sum2 = 0;
        int[] c = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            sum1 += a[i];
            sum1 += b[i];
            c[i] += a[i] - b[i];
        }
        if (sum2 > sum1) return -1;
        int index = best(c);
        return index;
    }

    public static void main(String[] args) {
        int [] roads = {5,4,8,2,1};
        int [] gas = {0,7,0,16,0};
        System.out.println(fuelStation(gas,roads));
    }
}
