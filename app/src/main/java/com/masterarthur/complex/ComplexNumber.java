package com.masterarthur.complex;
import java.security.*;

public class ComplexNumber
{
	Double mReal;
	Double mImaginary;
	
	Double mAbsValue;
	Double mArgument;
	
	private ComplexNumber()
	{}

	public void setReal(double mReal)
	{
		this.mReal = mReal;
	}
	

	public double getReal()
	{
		return mReal;
	}
	
	public String getRealStr() {
		return toFixed(mReal,2);
	}

	public void setImaginary(double mImaginary)
	{
		this.mImaginary = mImaginary;
	}

	public double getImaginary()
	{
		return mImaginary;
	}
	
	public String getImaginaryStr() {
		return toFixed(mImaginary,2);
	}

	public void setAbsValue(double mAbsValue)
	{
		this.mAbsValue = mAbsValue;
	}

	public double getAbsValue()
	{
		return mAbsValue;
	}
	
	public String getAbsValueStr(){
		return toFixed(mAbsValue, 2);
	}

	public void setArgument(double mArgument)
	{
		this.mArgument = mArgument;
	}

	public double getArgument()
	{
		return mArgument;
	}

	public String getArgumentStr() {
		return toFixed(mArgument,2);
	}
	public static ComplexNumber createArifmetic(double real, double imaginary) {
		ComplexNumber res = new ComplexNumber();
		res.setReal(real);
		res.setImaginary(imaginary);
		res.calcEulerForm();
		return res;
	}
	
	public static ComplexNumber createEuler(double absValue, double arg) {
		ComplexNumber res = new ComplexNumber();
		res.setAbsValue(absValue);
		res.setArgument(arg);
		res.calcArifmeticForm();
		
		return res;
	}
	
	public void calcEulerForm() {
		mAbsValue = Math.sqrt(Math.pow(mReal, 2) + Math.pow(mImaginary, 2));
		mArgument = Math.atan(mImaginary/mReal)*180/Math.PI;
		
	}
	
	public void calcArifmeticForm() {
		mReal = mAbsValue * Math.cos(mArgument*Math.PI/180);
		mImaginary = mAbsValue * Math.sin(mArgument*Math.PI/180);
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder("");
		builder.append(toFixed(mReal,2));
		if(mImaginary < 0) {
			builder.append("-i");
		} else {
			builder.append("+i");
		}
		builder.append(toFixed(Math.abs(mImaginary),2));
		
		builder.append(" = ");
		builder.append(toFixed(mAbsValue,2));
		if(mArgument < 0) {
			builder.append("*e^(-i");
		} else {
			builder.append("*e^(i");
		}
		builder.append(toFixed(Math.abs(mArgument),2));
		builder.append("°)");
		return builder.toString();
	}
	
	public ComplexNumber sum(ComplexNumber a) {
		ComplexNumber res = new ComplexNumber();
		res.setReal(mReal + a.getReal());
		res.setImaginary(mImaginary + a.getImaginary());
		res.calcEulerForm();
		
		return res;
	}
	
	public ComplexNumber subtract(ComplexNumber a) {
		ComplexNumber res = new ComplexNumber();
		res.setReal(mReal - a.getReal());
		res.setImaginary(mImaginary - a.getImaginary());
		res.calcEulerForm();

		return res;
	}
	
	public ComplexNumber multiply(ComplexNumber a) {
		ComplexNumber res = new ComplexNumber();
		res.setAbsValue(mAbsValue * a.getAbsValue());
		res.setArgument(mArgument + a.getArgument());
		res.calcArifmeticForm();

		return res;
	}
	
	public ComplexNumber divide(ComplexNumber a) {
		ComplexNumber res = new ComplexNumber();
		res.setAbsValue(mAbsValue / a.getAbsValue());
		res.setArgument(mArgument - a.getArgument());
		res.calcArifmeticForm();

		return res;
	}
	
	
	private String toFixed(Double num, int digits) {
		String res = num.toString();
		if(res.indexOf(".") != -1 && res.indexOf(".")+digits+1 < res.length())
			res = res.substring(0, res.indexOf(".")+digits+1);
		return res;
	}
}
