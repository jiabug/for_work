package data_structures;
/*
 * Write an algorithm such that if an element in an M*N matrix is 0, its entire 
 * row and column are set to 0.
 */
public class exercise7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]array = {{1,2,3,0,4,5},{4,6,3,6,7,0},{3,3,2,3,3,3}};
		exercise7 e = new exercise7();
		e.arrayDisplay(array);
		System.out.println();
		e.setZeros(array, array.length, array[0].length);
		e.arrayDisplay(array);
	}
	
	public void setZeros(int [][]array, int r, int c){
		boolean [] row = new boolean[r];// default is false
		boolean [] column = new boolean[c];
		for (int i = 0; i < r; i++ ){
			for (int j = 0; j < c; j++){
				if (array[i][j] == 0){
					row[i] = true;
					column[j] = true;
				}
			}
		}
		
		for (int i = 0; i < r; i++){
			if (row[i] == true){
				for (int j = 0; j < c; j++){
					array[i][j] = 0;
				}
			}
		}
		
		for (int i = 0; i < c; i++){
			if (column[i] == true){
				for (int k = 0; k < r; k++){
					array[k][i] = 0;
				}
			}
		}
	}
	
	public void arrayDisplay(int [][]array){
		for (int i = 0; i < array.length; i++){
			for (int j = 0; j < array[i].length; j++){
				System.out.print(array[i][j]+" ");
				if (j == array[i].length-1){
					System.out.println();
				}
			}
		}
	}

}
