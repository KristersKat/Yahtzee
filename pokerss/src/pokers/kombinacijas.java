package pokers;

public class kombinacijas {
    private int[] kPunkti=new int[5];
    private int[] skaitlis=new int[6];
    private int sum=0;

    kombinacijas(int[] punkti) {
        kPunkti=punkti;
        for(int i=0;i<5;i++){
            skaitlis[kPunkti[i]-1]++;
            sum=sum+kPunkti[i];
        }
    }
       public int cik1(){
        return skaitlis[0];
    }
    public int cik2(){
        return skaitlis[1]*2;
    }
    public int cik3(){
        return skaitlis[2]*3;
    }
    public int cik4(){
        return skaitlis[3]*4;
    }
    public int cik5(){
        return skaitlis[4]*5;
    }
    public int cik6(){
        return skaitlis[5]*6;
    }
    public int cik7(){      //three of a kind
        for(int i=0;i<6;i++){
            if(skaitlis[i]>=3){
            return sum;
            }
        }
        return 0;
    }
    public int cik8(){      //four of a kind
        for(int i=0;i<6;i++){
            if(skaitlis[i]>=4){
            return sum;
            }
        }
        return 0;
    }
    public int cik9(){      //full house
        boolean divi=false, tris=false;
        for(int i=0;i<6;i++){
            if(skaitlis[i]==2){
                divi=true;
            }
            if(skaitlis[i]==3){
                tris=true;
            }
        }
        if(divi&tris){
            return 25;
        }
        return 0;
    }
    public int cik10(){     //small straight
        if(skaitlis[0] >=1 && skaitlis[1] >=1 && skaitlis[2] >=1 && skaitlis[3] >=1 || skaitlis[1] >=1 && skaitlis[2] >=1 && skaitlis[3] >=1 && skaitlis[4] >=1 || skaitlis[2] >=1 && skaitlis[3] >=1 && skaitlis[4] >=1 && skaitlis[5] >=1){
            return 30;
        }
        return 0;
    }
    public int cik11(){     //large straight
        if(skaitlis[0] >=1 && skaitlis[1] >=1 && skaitlis[2] >=1 && skaitlis[3] >=1 && skaitlis[4] >=1 || skaitlis[1] >=1 && skaitlis[2] >=1 && skaitlis[3] >=1 && skaitlis[4] >=1 && skaitlis[5] >=1){
            return 40;
        }
        return 0;
    }
    public int cik12(){     //chance
        return sum;
    }
    public int cik13(){     //YAHTZEE
        for(int i=0;i<6;i++){
            if(skaitlis[i]==5){
            return 50;    
            }
        }
        return 0;
    }

}
