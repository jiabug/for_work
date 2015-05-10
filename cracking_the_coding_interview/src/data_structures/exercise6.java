package data_structures;
/*
 * Given an image represented by an N*N matrix, where each pixel in the image is 4
 * bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
 */
public class exercise6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] array = {{1,2,3,4,5,6,7,8},{1,2,3,4,5,6,7,8},{1,2,3,4,5,6,7,8},{1,2,3,4,5,6,7,8},{1,2,3,4,5,6,7,8},{1,2,3,4,5,6,7,8},{1,2,3,4,5,6,7,8},{1,2,3,4,5,6,7,8}};
		System.out.println(array.length);
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array[i].length; j++){
				System.out.print(array[i][j]+" ");
				if ( j == array[i].length-1){
					System.out.println();
				}
			}
		}
		System.out.println();
		exercise6 e = new exercise6();
		e.rotate(array,array.length);
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array[i].length; j++){
				System.out.print(array[i][j]+" ");
				if ( j == array[i].length-1){
					System.out.println();
				}
			}
		}
	}
	
	public void rotate(int [][] array, int n){
		for (int layer = 0; layer < (n+1)/2; layer++ ){
			//we just need to rotate n-1 dots,that is offset != n-2*layer-1, if we rotate all, it will be overwritten.
			for (int offset = 0; offset < n - 2*layer - 1; offset++){//if there is one left in the middle, we do not need to handle it
				//temporary store the value of the top
				int top = array[layer][layer + offset];
				//assign the value of left edge to top
				array[layer][layer+offset] = array[n-layer-offset-1][layer];
				//assign the value of the bottom to left
				array[n-layer-offset-1][layer] = array[n-layer-1][n-layer-offset-1];
				//assign the value of the right to the bottom
				array[n-layer-1][n-layer-offset-1] = array[layer+offset][n-layer-1];
				//assign the value of the top to the right 
				array[layer+offset][n-layer-1] = top;
			}
		}
	}
}
