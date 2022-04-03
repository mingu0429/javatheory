package oopHomeWork;

public class OopHomeWork_3_16 {

	public static void main(String[] args) {
		double[][] arr = { { 15, 25, 35 }, { 45, 55, 65 }, { 75, 85, 95 } };
		double[][] trans_arr = new double[3][3];
		int i, j;

		for (i = 0; i < arr.length; i++) {
			for (j = 0; j < arr[0].length; j++) {
				trans_arr[j][i] = arr[i][j];
			}
		}
		System.out.println("\n처음 주어진 행렬: ");
		for (i = 0; i < arr.length; i++) {
			for (j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + "  ");
				;
			}
			System.out.print("\n");
		}

		System.out.println("\n전치행렬을 구하라: ");
		for (i = 0; i < trans_arr.length; i++) {
			for (j = 0; j < trans_arr[0].length; j++) {
				System.out.print(trans_arr[i][j] + "  ");
			}
			System.out.print("\n"); // (a)전치 행렬을 구하여라
		}

		double x, y, z, determinant = 0;

		x = (arr[1][1] * arr[2][2]) - (arr[2][1] * arr[1][2]);
		y = (arr[1][0] * arr[2][2]) - (arr[2][0] * arr[1][2]);
		z = (arr[1][0] * arr[2][1]) - (arr[2][0] * arr[1][1]);

		determinant = (arr[0][0] * x) - (arr[0][1] * y) + (arr[0][2] * z);

		System.out.println("\n행렬식을 구하라 = " + determinant);//(b)정방행렬이면 행렬식을 구하여라

	}

}
