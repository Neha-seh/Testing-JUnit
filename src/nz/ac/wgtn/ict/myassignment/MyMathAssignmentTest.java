package nz.ac.wgtn.ict.myassignment;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MyMathAssignmentTest {

	MyMathAssignment ma = new MyMathAssignment();

	@Test
	public static Collection addTest1() {
		return Arrays.asList(new Object[][] { { 1, 1, 2 }, { 3.14, -1.72, 1.42 }, { -7, -1, -8 }});
	}

	@ParameterizedTest(name = "{index}: add({0}, {1})= {2}")
	@DisplayName("Addition method with collection")
	@MethodSource("addTest1")
	public void addTest(double v1, double v2, double exp) {
		assertEquals(exp, ma.add(v1, v2), "This method is not working");
	}

	@Test
	public static Collection subTest1() {
		return Arrays.asList(new Object[][] { { -2, -1, -1 }, { 3.14, 1.72, 1.42 }, { 7, 1, 6 } });
	}

	@ParameterizedTest(name = "{index}: sub({0}, {1})= {2}")
	@MethodSource("subTest1")
	public void subTest(double v1, double v2, double exp) {
		assertEquals(exp, ma.sub(v1, v2), "This method is not working");
	}

	@Test
	public static Collection mulTest1() {
		return Arrays.asList(new Object[][] { { 6, 2, 12 }, { -3, 0, 0 }, { -11.2, 9, -100.8 }});
	}

	@ParameterizedTest(name = "{index}: mul({0}, {1})= {2}")
	@MethodSource("mulTest1")
	public void mulTest(double v1, double v2, double exp) {
		assertEquals(exp, ma.mul(v1, v2), "This method is not working");
	}

	@Test
	public static Collection divTest1() {
		return Arrays.asList(new Object[][] { { 6, 2, 3 }, { 12, 6, 2 }, { 3.14, -1.72, -1.82558 }});
	}

	@ParameterizedTest(name = "{index}: div({0}, {1})= {2}")
	@MethodSource("divTest1")
	public void divTest(double v1, double v2, double exp) {
		assertEquals(exp, ma.div(v1, v2), "This method is not working");
	}

	//-----------test for "divided by 0"-------------

	static Stream<Arguments>  divTestDATA2() {
		return Stream.of(
				Arguments.of(6,0));
	}
	@ParameterizedTest
	@MethodSource("divTestDATA2")
	public void divTest2(double v1, double v2) {
		assertThrows(IllegalArgumentException.class,() ->ma.div(v1, v2)); 
	}
	
	
	
	//-------------------------- Vector product----------------
	
	static Stream<Arguments> vectorTestData() {
			return Stream.of(
			Arguments.of(new double[] {1,2,3}, new double[] {4, 5, 6}, new double[] {4, 10, 18}),
			Arguments.of(new double[] {-4,-6,-8}, new double[] {-7, 5, 0}, new double[] {28, -30, 0}),
			Arguments.of(new double[] {3.7, 1.1, -4.3}, new double[] {8.1, 5.2, 7.6}, new double[] {29.97, 5.72, -32.68}));
		}

	@ParameterizedTest(name = "{index}: vector({0}, {1} )= {2}")
	@MethodSource("vectorTestData")

	public void vectorTest1(double[] v1, double[] v2, double[] exp) throws Exception {
		assertArrayEquals(exp, ma.vectorProduct(v1, v2), "This method is not working");
	}

	

	//-----------------------------------Matrix and vector Product----------------------
	
	static Stream<Arguments> matrixVectorProductTestData() {
		return Stream.of(Arguments.of(new double[][] {{1,2},{3,4}}, new double[] {1,2,3,4}, new double[] {5,11,15,22}),
				Arguments.of(new double[][] {{3, 4, 2},{1, 3, 1}}, new double[] {4, 7, 1}, new double[] {42,26}), 
				Arguments.of(new double[][] {{0, 4,-2},{-4, -3, 1}}, new double[] {2, -1, 0}, new double[] {-4, -5}));
			
	}

	@ParameterizedTest
	@MethodSource("matrixVectorProductTestData")
	public void MatrixVectorTest1(double[][] v1, double[] v2, double[] exp) {
	
		try {
				assertArrayEquals(exp, ma.MatrixVectorProduct(v1,v2),
						"This method is not working");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//------------------------------------------Matrix and Matrix product----------------------
	
	static Stream<Arguments> multiplyTwoMatrixTestData() {
		return Stream.of(Arguments.of(new double[][] {{1,2,3},{4,5,6}}, new double[][] {{7,8},{9,10}, {11,12}}, new double[][] {{58, 64}, {139, 154}}),
				Arguments.of(new double[][] {{-1,-2},{-3,-4}},new double[][] {{-1,-2},{-3,-4}}, new double[][] {{7,10},{15,22}}),
				Arguments.of(new double[][]{{0,0},{0,0}}, new double[][] {{0,0},{0,0}}, new double[][]{{0,0},{0,0}})); 
	
	}

	@ParameterizedTest
	@MethodSource("multiplyTwoMatrixTestData")
	public void MultiplyTwoMatrixTest1(double[][] v1, double[][] v2, double[][] exp) {
	
				
					try {
						assertArrayEquals(exp, ma.multiplyTwoMatrix(v1,v2),
								"This method is not working");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
	}
	
	
	//------------------------------------------Transpose Matrix-----------------
	
	static Stream<Arguments> transposeMatrixTestData() {
		return Stream.of(Arguments.of(new double[][] {{6, 4, 24},{1, -9, 8}}, new double[][] {{6, 1}, {4, -9}, {24, 8}}));		
	}

	@ParameterizedTest
	@MethodSource("transposeMatrixTestData")
	public void TransposeMatricTest(double[][] v1, double[][] exp) {
	
				try {
					assertArrayEquals(exp, ma.transposeMatrix(v1),
							"This method is not working");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
	}

	
	//-----------------------------------------------Identity Matrix------------------------
	
	static Stream<Arguments> IndentityMatrixTestData() {
		return Stream.of(Arguments.of(new double[][] {{1,0,0},{0,1,0}, {0,0,1}},true));		
	}

	@ParameterizedTest
	@MethodSource("IndentityMatrixTestData")
	public void IndentityMatrixTest(double[][] v1, boolean exp) {
	
				try {
					assertEquals(exp, ma.IdentityMatrixSourceData(v1));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
	}
	
}
