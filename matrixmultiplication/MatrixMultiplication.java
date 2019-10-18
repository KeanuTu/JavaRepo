package matrixmultiplication;

//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class MatrixMultiplication {

	public static int[][] A, B, C;
	public static int row_A, cow_A, cow_B;
	public static int numberOfThreads;

	public static void main(String[] args) throws InterruptedException {
		numberOfThreads = 8;
		// 从命令行获取线程数
		/*
		 * if(args.length > 0){ numberOfThreads = Integer.parseInt(args[0]); }
		 */
		/*
		 * Scanner input = new Scanner(System.in); System.out.print("请输入线程数：");
		 * numberOfThreads = input.nextInt();
		 */

		// 从文件中读取矩阵A,B
		/*
		 * try (BufferedReader br = new BufferedReader(new FileReader("Test1_A.txt"))) {
		 * //getting the size String line; line = br.readLine(); String[] m_and_p =
		 * line.split(" "); row_A = Integer.parseInt(m_and_p[0]); cow_B =
		 * Integer.parseInt(m_and_p[1]); A = new int[row_A][cow_B];
		 * 
		 * //getting A int row_No = 0; while ((line = br.readLine()) != null) {
		 * 
		 * String[] row = line.split(" "); for(int column = 0;column< cow_B; column++) {
		 * A[row_No][column] = (int)Double.parseDouble(row[column]); } row_No++; } }
		 * catch (IOException e) { e.printStackTrace(); }
		 * 
		 * //reading the file and get B try (BufferedReader br = new BufferedReader(new
		 * FileReader("Test1_B.txt"))) { //getting the size String line; line =
		 * br.readLine(); String[] p_and_n = line.split(" "); cow_B =
		 * Integer.parseInt(p_and_n[0]); cow_A = Integer.parseInt(p_and_n[1]); B = new
		 * int[cow_B][cow_A];
		 * 
		 * //getting B int row_No = 0; while ((line = br.readLine()) != null) {
		 * 
		 * String[] row = line.split(" "); for(int column = 0;column< cow_A; column++) {
		 * B[row_No][column] = (int)Double.parseDouble(row[column]); } row_No++; } }
		 * catch (IOException e) { e.printStackTrace(); }
		 */

//		System.out.print("请输入矩阵A的行数和列数:");
//		row_A = input.nextInt();
//		cow_A = input.nextInt();
//		System.out.print("请输入矩阵B的行数和列数:");
//		cow_A = input.nextInt();
//		cow_B = input.nextInt();

		row_A = cow_A = cow_B = 1000;
		A = CreateMatrix(row_A, cow_A);
		B = CreateMatrix(cow_A, cow_B);
		C = new int[row_A][cow_A];

		// 法1：计算单线程下矩阵乘法耗时
		long Starting_time = System.currentTimeMillis();
		CalculateC();
		long Calculation_time = System.currentTimeMillis() - Starting_time;
		System.out.println("1Thread下矩阵乘法所需时间" + Calculation_time );
		
		// 法2：计算多线程下矩阵乘法所需时间
		Thread[] T = new Thread[numberOfThreads];

		for (int i = 0; i < numberOfThreads; i++) {
			final int startIndex_i = i * (row_A / numberOfThreads);
			final int endIndex_i;
			if (i == numberOfThreads - 1)
				endIndex_i = row_A - 1;
			else {
				endIndex_i = i * (row_A / numberOfThreads) + ((row_A / numberOfThreads) - 1);
			}

			T[i] = new Thread(new Runnable() {
				@Override
				public void run() {
					for (int i = startIndex_i; i <= endIndex_i; i++) {
						for (int j = 0; j < cow_A; j++) {
							C[i][j] = 0;
							for (int k = 0; k < cow_B; k++) {
								C[i][j] = C[i][j] + (A[i][k] * B[k][j]);
							}
						}
					}
				}
			});
		}

		// calculating the time taken when using threads
		Starting_time = System.currentTimeMillis();
		for (int i = 0; i < numberOfThreads; i++) {
			T[i].start();
		}
		for (int i = 0; i < numberOfThreads; i++) {
			T[i].join();
		}
		Calculation_time = System.currentTimeMillis() - Starting_time;
		System.out.println(numberOfThreads + "Thread(s)下矩阵乘法所需时间" + Calculation_time);
		
		// 法3：计算线程池下矩阵乘法所需时间
		for(int i = 0; i < row_A; i++)
			for(int j = 0; j < cow_A; j++)
				C[i][j]=0;
		ExecutorService pool = Executors.newCachedThreadPool();
		Starting_time = System.currentTimeMillis();
		for(int i = 0; i < numberOfThreads; i++)
			pool.execute(T[i]);
		pool.shutdown();
		while(true) {
			if(pool.isTerminated())
				break;
		}//用一个死循环判断线程池是否执行完成
		
		Calculation_time = System.currentTimeMillis() - Starting_time;
		System.out.println(numberOfThreads +"备用线程的"+ "线程池下矩阵乘法所需时间" + Calculation_time );
		
	}
	

	
		
	public static void CalculateC() {
		for (int i = 0; i <= row_A - 1; i++) {
			for (int j = 0; j < cow_A; j++) {
				C[i][j] = 0;
				for (int k = 0; k < cow_B; k++) {
					C[i][j] = C[i][j] + (A[i][k] * B[k][j]);
				}
			}
		}
	}

	public static int[][] CreateMatrix(int row, int cow) {
		int[][] result = new int[row][cow];
		for (int i = 0; i < row; i++) {
			result[i] = new int[row];
			for (int j = 0; j < cow; j++) {
				result[i][j] = (int) Math.random();
			}
		}
		return result;
	}
}