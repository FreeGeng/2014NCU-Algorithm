//HeapSort
//can 2014/10/3

import java.util.*;
public class Main {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String arg[]){
		
		int numOfGroup = scanner.nextInt();

		for(int i = 0 ; i < numOfGroup ; i++){
			
			int count = scanner.nextInt();
			int data[] = new int[count];
			int temp_data[] = new int[count];
			int finalAns[] = new int[count];
			
			String input = scanner.next();
			String data_String[] = input.split(",");
					
			for(int j = 0 ; j < count ; j++){
				data[j] = 65586;
				temp_data[j] = Integer.parseInt(data_String[j]);
			}

			for(int k = 0 ; k < data.length ; k++){
				data[k] = temp_data[k];
				print(data);
				for(int z = (k+1)/2 , y = k+1 ; z != 0 ; y = z , z /= 2 ){
					if(data[y-1] > data[z-1]){
						swap(data , y-1 , z-1);
						print(data);
					}else
						break;
				}
			}
			
			print(data);
			for(int count1 = count ; count1 > 0 ; count1--){
				swap(data , 0 , count1-1);
				if(count1 != 1){
					print(data);
				}
				finalAns[count-count1] = data[count1-1];
				data[count1-1] = 65586;
				if(count1 != 1){
					print(data);
				}
				heap(data);
			}
			print(finalAns);
			System.out.printf("*\n");
			
		}
	}

	
	private static int[] heap(int[] a){
		for(int index1 = 0 ; index1 < a.length && a[index1] != 65586 ; index1++){
			int now = index1 , next = index1+1;
			while(now < a.length){
				if((next*2) < a.length){
					
					if(a[next*2] != 65586 && a[(next*2) - 1] != 65586){
						if(a[next*2] < a[(next*2) - 1]){
							next = next*2;
						}
						else if(a[next*2] > a[(next*2) - 1]){
							next = next*2 + 1;
						}
					}
					else if(a[next*2] != 65586){
						next = next*2 + 1;
					}
					else if(a[(next*2) - 1] != 65586){
						next = next*2;
					}
					
				}
				else{
					if((next*2)-1 < a.length){
						next = next*2;
					}
				}
				
				if(a[now] < a[next-1] && a[next-1] != 65586){
					swap(a, now, next-1);
					print(a);
					now = next-1;
				}
				else{
					break;
				}
			}
		}
		return a;
	}
	
	private static void swap(int[] a , int b , int c){
		int temp;
		temp = a[b];
		a[b] = a[c];
		a[c] = temp;
	}
	
	private static void print(int[] a){
		for(int i = 0 ; i < a.length ; i++){
			if(a[i] == 65586)
				break;
			if(i != a.length-1 && a[i+1] != 65586)
				System.out.printf("%d, " , a[i]);
			else
				System.out.printf("%d\n" , a[i]);
			
		}
	}
}