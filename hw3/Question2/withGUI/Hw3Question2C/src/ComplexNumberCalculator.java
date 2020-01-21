
public class ComplexNumberCalculator {
	
	
	/**
	 * Returns sum of two ComplexNumber object
	 * @param complexNumber1
	 * @param complexNumber2
	 * @return
	 */
	public ComplexNumber sum(ComplexNumber complexNumber1,ComplexNumber complexNumber2) {
		return new ComplexNumber(complexNumber1.getRealNumber()+complexNumber2.getRealNumber(),
								complexNumber1.getImaginaryNumber()+complexNumber2.getImaginaryNumber());
	}
	
	/**
	 * multiply a Complex number with a double
	 * @param complexNumber
	 * @param a
	 * @return multiplied value
	 */
	public ComplexNumber multiply(ComplexNumber complexNumber,double a) {
		return new ComplexNumber(complexNumber.getRealNumber()*a,
				complexNumber.getImaginaryNumber()*a);
	}
	
	/**
	 * multiply a Complex number with a Complex number
	 * @param complexNumber1
	 * @param complexNumber2
	 * @return multiplied value
	 */
	public ComplexNumber multiply(ComplexNumber complexNumber1,ComplexNumber complexNumber2) {
		return new ComplexNumber((complexNumber1.getRealNumber()*complexNumber2.getRealNumber()+((complexNumber1.getImaginaryNumber()*complexNumber2.getImaginaryNumber())*-1)),
				(complexNumber1.getRealNumber()*complexNumber2.getImaginaryNumber())+(complexNumber2.getRealNumber()*complexNumber1.getImaginaryNumber()));
	}

}
