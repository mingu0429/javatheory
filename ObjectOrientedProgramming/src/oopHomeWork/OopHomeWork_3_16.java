package oopHomeWork;

public class OopHomeWork_3_16 {

	public static void main(String[] args) {
		double[][] arr = { { 1, 2, 3 }, { 2, 5, 3 }, { 1, 0, 8 } }; 
		//임의의 행렬 입력
		double[][] trans_arr = new double[3][3];
		int i, j;

		for (i = 0; i < arr.length; i++) {
			for (j = 0; j < arr[0].length; j++) {
				trans_arr[j][i] = arr[i][j];
			}
		}
		System.out.println("\n처음 주어진 행렬: ");//입력된 행렬을 출력
		for (i = 0; i < arr.length; i++) {
			for (j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + "  ");
				;
			}
			System.out.print("\n");
		}

		System.out.println("\n전치행렬을 구하라: ");//(a)전치 행렬을 구하여라
		for (i = 0; i < trans_arr.length; i++) {//for 문을 이용한 전치행렬 구하기
			for (j = 0; j < trans_arr[0].length; j++) {
				System.out.print(trans_arr[i][j] + "  ");
			}
			System.out.print("\n"); // 
		}

		double x, y, z, determinant = 0; //변수 생성

		x = (arr[1][1] * arr[2][2]) - (arr[2][1] * arr[1][2]); //행렬식 구하기
		y = (arr[1][0] * arr[2][2]) - (arr[2][0] * arr[1][2]);
		z = (arr[1][0] * arr[2][1]) - (arr[2][0] * arr[1][1]);

		determinant = (arr[0][0] * x) - (arr[0][1] * y) + (arr[0][2] * z); 

		System.out.println("\n행렬식을 구하라 = " + determinant);// (b)정방행렬이면 행렬식을 구하여라
		if (determinant == 0) {//행렬식이 0일 경우 역행렬이 없다고 출력
			System.out.println("역행렬이 존재하지 않습니다.");
		}
		
		double det = 0;
		
		for (i = 0; i < 3; i++)
			det = det + (arr[0][i] * (arr[1][(i + 1) % 3] * arr[2][(i + 2) % 3] 
					- arr[1][(i + 2) % 3] * arr[2][(i + 1) % 3]));
		
		System.out.println("\n역행렬을 구하여라:");//(c) 가능하면 역행렬을 구하라
		for (i = 0; i < 3; ++i) {//가우스 조던 방법을 활용한 역행렬 구하기
			for (j = 0; j < 3; ++j)
				System.out.print((((arr[(j + 1) % 3][(i + 1) % 3] * arr[(j + 2) % 3][(i + 2) % 3]) - (arr[(j + 1) % 3][(i + 2) % 3] 
						* arr[(j + 2) % 3][(i + 1) % 3])) / det) + " ");
			System.out.print("\n");
		}
	}

}
