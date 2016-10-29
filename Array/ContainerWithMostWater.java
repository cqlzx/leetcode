package array;

public class ContainerWithMostWater {
	public static void main(String args[]){
		int[] height = {1, 1};
		int max = maxArea(height);
		System.out.println(max);
	}
	
	public static int maxArea(int[] height){
		int i = 0, j = height.length - 1;
		int max = 0;
		int shorter = 0;
		int temp = 0;
		while(i < j){
			shorter = height[i] < height[j] ? height[i] : height[j];
			temp = shorter * (j - i);
			if(temp > max){
				max = temp;
			}
			
			if(height[i] < height[j]){
				i++;
			}else{
				j--;
			}
		}
		
		return max;
	}
	
//	Will exceed time limit in some extreme cases, but better in average
//	public static int maxArea(int[] height){
//		int i = 0, j = height.length - 1;
//		int max = 0;
//		int shorter = 0;
//		int temp = 0;
//		while(i < j){
//			shorter = height[i] < height[j] ? height[i] : height[j];
//			temp = shorter * (j - i);
//			if(temp > max){
//				max = temp;
//			}
//			
//			if(height[i] < height[j]){
//				while(height[i] < shorter && i < j){
//					i++;	
//				}
//			}else{
//				while(height[j] < shorter && i < j){
//					j++;
//				}
//			}
//		}
//		
//		return max;
//	}
}
