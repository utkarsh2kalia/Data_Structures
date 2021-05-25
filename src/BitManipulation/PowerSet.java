package BitManipulation;

public class PowerSet {


    public void generatePowerSet(int set[]){
        // total number of compinations possible
        int n = (int)Math.pow(2, set.length);
        for(int i = 0; i<n; i++){

            for(int j = 0; j< set.length; j++){

                if((i & (1<<j))!=0){
                    System.out.print(set[j]+" ");
                }

            }
            System.out.println();

        }
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3};
        PowerSet powerSet = new PowerSet();
        powerSet.generatePowerSet(arr);
    }
}
