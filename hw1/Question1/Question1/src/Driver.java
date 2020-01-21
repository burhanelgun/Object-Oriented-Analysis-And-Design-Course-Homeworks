import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {

		String[] variables;
		double rightOfEquals[];
		double[][] matrix;
		int numberOfEquations;
		
		
		Scanner myObj = new Scanner(System.in); 
	    System.out.println("NOTE: Please give the linear equations in standart form.\nLike Ax+By=C.\nx and y are unknown variables. \nA and B are coefficients of variables.\nC is result of the equation.");

	    System.out.println("\nEnter number of equations(unknown variable size):");
	    numberOfEquations= myObj.nextInt();
	    myObj.nextLine();
	    
	    
	    rightOfEquals=new double[numberOfEquations];
	    variables=new String[numberOfEquations];
	    matrix=new double[numberOfEquations][numberOfEquations];

	    for(int i=0;i<numberOfEquations;i++) {
		    System.out.println("Enter "+(i+1)+". variable (like x,y,z,t etc.):");
		    variables[i]=myObj.nextLine();
	    }
	    
	    for(int i=0;i<numberOfEquations;i++) {
	    	for (int j = 0; j < matrix.length; j++) {
	    		  System.out.println("Enter coefficient of "+variables[j]+" for "+ (i+1)+". equation");
	    		  matrix[i][j]= myObj.nextInt();
			}
	    	System.out.println("Enter result for "+ (i+1)+". equation.");
	    	rightOfEquals[i]=myObj.nextInt();
		  
	    }
	    
	    
	    

		/*
		double[][] matrix = {{2,1,3},
							{2,6,8},
							{6,8,18}};
		
		double[] rightOfEquals= {1,3,5};
									
		String[] variables= {"x","y","z"};
		
		numberOfEquations=3;
		x=0.3
		y=0.4
		z=0.0
		*/
		
		
		LinearEquationSystem linearEquationSystem = new LinearEquationSystem(matrix,rightOfEquals,variables,numberOfEquations);
		SolutionBehavior gaussianSolution= new GaussianElimination();		
		SolutionBehavior inversionSolution= new MatrixInversion();
		
	    System.out.println("Choose solving method:\n Enter 1 for Gaussian Elimination \n Enter 2 for Matrix inversion");
	    int solvingMethod= myObj.nextInt();
	    myObj.nextLine();
		

	    if(solvingMethod==1) {
			linearEquationSystem.setSolutionBehavior(gaussianSolution);
	    }
	    else {
			linearEquationSystem.setSolutionBehavior(inversionSolution);
	    }
		

		linearEquationSystem.performSolution();
		linearEquationSystem.printSolution();


	
		

	}

}
