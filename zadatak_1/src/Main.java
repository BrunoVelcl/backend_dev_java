public class Main {
    public static void main(String[] args) {
        for (int i = 0; i <10001; i++){
            if(isArmstrong(i)){
                System.out.print( i + ", ");
            }
        }

    }
    // bez pohranjivanja pošto nisam siguran dali smo prosli
    private static boolean isArmstrong(int num) {
        int temp = num;
        int sum = 0;
        int j = 0;
        while (temp != 0){
            temp /= 10;
            j++;
        }
        temp = num;
        while(temp != 0){
            sum += (int)Math.pow(temp % 10, j);
            temp /= 10;
        }
        return sum == num;
    }
// ***********************************************************************
//    // najsmislenije rjesenje
//    private static boolean isArmstrong(int num) {
//        int temp = num;
//        List<Integer> arrLst = new ArrayList<>();
//        while(temp != 0){
//            arrLst.add(temp % 10);
//            temp /= 10;
//        }
//        int sum = 0;
//        for(Integer num: arrLst ){
//            sum += (int) Math.pow(num, arrLst.size());
//        }
//        return sum == num;
//    }
// ***********************************************************************
//    // preseravanje (bez listi)
//    private int reCnt;
//
//    private static boolean isArmstrong(int i) {
//        Main z1 = new Main();
//        z1.reCnt = -1;  //prebrojat ce za 1 na zadnjem pozivu
//        return z1.recArmstrong(i) == i;
//    }
//
//    private int recArmstrong(int num){
//        reCnt++;
//        int temp;
//
//        if (num == 0){
//            return 0;
//        }
//        temp = recArmstrong(num / 10);
//        return ((int) Math.pow(num%10,reCnt)) + temp;
//    }

}
