package practice;

public class practice{
    public static void main(String args[]) throws Exception{

        char asc[]={'A', 'M', 'B', 'T', 'P', 'Q'};

        for(int i=0; i<asc.length; i++){
          for(int j=i+1; j<asc.length; j++){

             if(asc[i]>asc[j]){
                 char t = asc[i];
                 asc[i]=asc[j];
                 asc[j]=t;
             }
          }
        }

        for(int i=0; i<asc.length; i++){
            System.out.println(asc[i]);
        }
    }
}

