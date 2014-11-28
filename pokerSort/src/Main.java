import java.util.*;

public class Main {

	static int groupNum;
	static int packNum;
	static Scanner scanner = new Scanner(System.in);

	public static void main(String agrs[]) {

		groupNum = scanner.nextInt();
		for (int i = 0; i < groupNum; i++) {
			packNum = scanner.nextInt();
			String card[] = new String[10 * packNum];
			int number[] = new int[10*packNum];
		
			for (int j = 0; j <packNum; j++) {
				for (int k = 0; k < 10; k++) {
					String Wdata1 = scanner.next();
					String Wdata2[] = Wdata1.split("");
					card[10 * j + k] = Wdata2[k];
					
				}
			}
			
			number = setFlowerNum(card,number);
			for(int j=0;j<packNum;j++){
				int spiltNum[][] = new int [packNum][10];
			}

		}
	}
	
	static int[] setFlowerNum(String a[],int number[]){
		for(int i =0;i<a.length;i++){
			switch(a[i]){
			case "S":
				number[i]=4;
				break;
			case "H":
				number[i]=3;
				break;
			case "C":
				number[i]=2;
				break;
			case "D":
				number[i]=1;
				break;
			case "A":
				number[i]=14;
				break;
			case "2":
				number[i]=2;
				break;
			case "3":
				number[i]=3;
				break;
			case "4":
				number[i]=4;
				break;
			case "5":
				number[i]=5;
				break;
			case "6":
				number[i]=6;
				break;
			case "7":
				number[i]=7;
				break;
			case "8":
				number[i]=8;
				break;
			case "9":
				number[i]=9;
				break;
			case "0":
				number[i]=10;
				break;
			case "J":
				number[i]=11;
				break;
			case "Q":
				number[i]=12;
				break;
			case "K":
				number[i]=13;
				break;
			}
		}
		
		return number;		
	}
   
	static void setType(int a[]){
		
	}
}
