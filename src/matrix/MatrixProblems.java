package matrix;

public class MatrixProblems {

	static void printMatrix(int mat[][], int n, int k) {

		int[][] stripSum = new int[n][n];
		// pre processing it , first adding first k*1 matrix
		for (int j = 0; j < n; j++) {
			int sum = 0;
			// first k*1
			for (int i = 0; i < k; i++) {
				sum = +mat[i][j];
				stripSum[0][j] = sum;
			}
			// remaining k *1 rectangles
			for (int i = 1; i < n - k + 1; i++) {
				sum += (mat[i + k - 1][j] - mat[i - 1][j]);
				stripSum[i][j] = sum;
			}
		}
		for (int i = 0; i < n - k + 1; i++) {
			int sum = 0;
			for (int j = 0; j < k; j++) {
				sum += stripSum[i][j];

			}
			System.out.print(sum + "\t");

			for (int j = 1; j < n - k + 1; j++) {
				sum += (stripSum[i][j + k - 1] - stripSum[i][j - 1]);
				System.out.print(sum + "\t");
			}

		}

	}

	/*
	 * make the corresponding row and column zero if that element is zero
	 * example if a12 = 0 , then a10 , a11 ... make them 0 similarly for 2
	 */
	public int[][] makeRowAndColumnZero(int[][] matrix) {
		int n = matrix.length;
		boolean[] rowindex = new boolean[n];
		boolean[] columnindex = new boolean[matrix[0].length];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					rowindex[i] = true;
					columnindex[j] = true;
				}
			}
		}

		for (int i = 0; i < n; i++) {

			for (int j = 0; j < matrix[0].length; j++) {
				if (rowindex[i] || columnindex[j])
					matrix[i][j] = 0;
			}

		}
		return matrix;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mat[][] = new int[][] { { 1, 1, 0, 1, 1 }, { 2, 2, 2, 2, 2 },
				{ 3, 3, 3, 3, 3 }, { 4, 7, 4, 14, 4 }, { 5, 5, 5, 5, 5 }, };
		int k = 3;
		//printMatrix(mat, 5, k);
		MatrixProblems matr = new MatrixProblems();
		System.out.println(matr.makeRowAndColumnZero(mat)[2][4]);
	}

}
