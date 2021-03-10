package nz.ac.wgtn.ict.myassignment;

import java.util.InputMismatchException;

class MyMathAssignment {

	/**
	 * This function will add two given numbers and will return the adition
	 * 
	 * @param x : The first operand
	 * @param y : The second operand
	 * @return res : the adition of two operands
	 */
	public double add(double x, double y) {
		double res = x + y;
		double finalRes = Math.round(res * 100000) / 100000.0;
		return finalRes;

	}

	/**
	 * This function will subtract two given numbers and will return the subtraction
	 * 
	 * @param x : the first operand
	 * @param y : the second operand
	 * @return res : the subtraction of two operands
	 */
	public double sub(double x, double y) {
		double res = x - y;
		double finalRes = Math.round(res * 100000) / 100000.0;
		return finalRes;

	}

	/**
	 * This function will multiply two given numbers and will return the
	 * multiplication
	 * 
	 * @param x : the first operand
	 * @param y : the second operand
	 * @return res : the multiplication of two operands
	 */
	public double mul(double x, double y) {

		double res = x * y;
		double finalRes = Math.round(res * 100000) / 100000.0;
		return finalRes;
	}

	/**
	 * This function will divide two given numbers and will return the division
	 * 
	 * @param x : the first operand
	 * @param y : the second operand
	 * @return res : the division of two operands
	 */

	public double div(double x, double y) {
		if(y == 0) {
			throw new IllegalArgumentException("Can't divide by zero");
		}
			double res = x / y;
			double finalRes = Math.round(res * 100000) / 100000.0;
			return finalRes;
	}
	
	
	/**
	 * This function will return the product of two vectors
	 * 
	 * @param a : the first operand
	 * @param b : the second operand
	 * @return res : the dot product of two operands
	 */
	public double[] vectorProduct(double[] a, double[] b) throws Exception {
		if (a.length != b.length) {
			throw new IllegalArgumentException("The dimensions have to be equal!");
		}
		double[] res = new double[a.length];
		for (int i = 0; i < a.length; i++) {
			 res[i] += Math.round(( a[i] * b[i]) * 100000) / 100000.0;
		}
		return res;
	}

	
	
	
	/**
	 * This function will return the product of two matrix
	 * 
	 * @param m1 : Multiplicand
	 * @param m2 : Multiplier
	 * @return mResult : the result products of matrix and vector
	 */
	public double[][] multiplyTwoMatrix(double[][] m1, double[][] m2) throws Exception {
		int m1CLength = m1[0].length; // m1 columns length
		int m2RLength = m2.length; // m2 rows length

		if (m1CLength != m2RLength) {
			throw new InputMismatchException("Incompatible matrices. cols of first matrix must equal rows of second matrix");

		} else {
			int RRLength = m1.length; // m1 result rows length

			int RCLength = m2[0].length; // m2 result columns length

			double[][] mResult = new double[RRLength][RCLength];

			for (int i = 0; i < RRLength; i++) { // rows from m1
				for (int j = 0; j < RCLength; j++) { // columns from m2
					for (int k = 0; k < m1CLength; k++) { // columns from m1

						mResult[i][j] += Math.round((m1[i][k] * m2[k][j]) * 100000) / 100000.0;
					}
				}

			}
			return mResult;
		}
	}

	/**
	 * This function will return the transpose of a matrix
	 * 
	 * @param m  : for rows length
	 * @param m2 : Multiplier
	 * @return mResult : the result products of matrix and vector
	 */

	public double[][] transposeMatrix(double[][] matrix) {
		int n = matrix[0].length;   //column length
		int m = matrix.length;   //rows length

		double[][] transposedMatrix = new double[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				transposedMatrix[i][j] = matrix[j][i];
			}
		}

		return transposedMatrix;
	}

	
	/**
	 * Checks whether given matrix parameter is an identity matrix. returns boolean
	 * true or false.
	 */
	
	public boolean IdentityMatrixSourceData(double[][] matrix) {
		 boolean flag = true ;
		int n = matrix[0].length;   //n = column length
		int m = matrix.length;   //m = rows length

		if (m != n) {
			throw new InputMismatchException("Matrix should be a square matrix");

		} else {   
			for(int i = 0; i < m; i++){    
                for(int j = 0; j < n; j++){    
                  if(i == j && matrix[i][j] != 1){    
                      flag = false;    
                      break;    
                  }    
                  if(i != j && matrix[i][j] != 0){    
                      flag = false;    
                      break;    
                  }    
                }    
            }  
			return true;
	}
	}
	

}
