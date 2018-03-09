import edu.princeton.cs.algs4.Selection;

public class Selector {
    /*
     * Example of a brute force-solution.
     */
    public static double select(Sample sample, int rank){
        for(int i = 0; i < sample.size(); i++)
            if(rank(sample,sample.get(i)) == rank)
                return sample.get(i);
        return -1.0;// "ERROR CODE"
    }

    public static int rank(Sample sample, double selectedValue){
        int rank = 0;
        for(int i = 0; i < sample.size() ; i++) 
            if (sample.get(i) < selectedValue) rank++;
        return rank;
    }




    /*
     * Client code
     */
    public static void main(String[] args){

        Sample sample = new Sample(10);
        System.out.println(sample);
        for(int rank = 0; rank < sample.size(); rank++){
            double selected = select(sample,rank);
            String judgement = sample.rank(selected) == rank ? "Acceptable choice" : "Unaccaptable choice";
            System.out.printf("Select(sample,%d) = %f, %s %n",rank,selected,judgement);
        }
        System.out.println(sample);
    }
}
