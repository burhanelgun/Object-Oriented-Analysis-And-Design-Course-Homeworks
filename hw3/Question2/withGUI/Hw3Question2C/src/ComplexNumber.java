import java.util.Random;

public class ComplexNumber {
	/**
	 * real part of complex number
	 */
	private double realNumber;
	/**
	 * imaginary part of complex number
	 */
	private double imaginaryNumber;

	
	/**
	 * Generates a random complex number
	 */
	public ComplexNumber() {
		Random r = new Random();
		double max = 50;
		double min = 1;
		
		
		this.realNumber=roundDouble(min + (max - min) * r.nextDouble()); 
		this.imaginaryNumber=roundDouble(min + (max - min) * r.nextDouble());
		this.realNumber = roundDouble(realNumber);
		this.imaginaryNumber=roundDouble(imaginaryNumber);
		
		
	/*	this.realNumber=r.nextInt((max - min) + 1) + min;
		this.imaginaryNumber=r.nextInt((max - min) + 1) + min;
*/
	}
	
	/**
	 * Generates a complex random according to given parameters
	 * @param realNumber real part of the complex number
	 * @param imaginaryNumber imaginary part of the complex number
	 */
	public ComplexNumber(double realNumber,double imaginaryNumber) {
		this.realNumber=roundDouble(realNumber);
		this.imaginaryNumber=roundDouble(imaginaryNumber);
	}
	
	/**
	 * Prints the complex number
	 */
	@Override
	public String toString() {
		if (imaginaryNumber==0) {
			return "("+realNumber+")";
		}
	    else if(imaginaryNumber>0) {
			return "("+realNumber+"+"+imaginaryNumber+"i"+")";
		}

		return "("+realNumber+imaginaryNumber+"i"+")";

	}
	
	public double getRealNumber() {
		return realNumber;
	}
	
	public double getImaginaryNumber() {
		return imaginaryNumber;
	}
	
	public double roundDouble(double num) {
		return (double)Math.round(num * 1d) / 1d;
	}

}
