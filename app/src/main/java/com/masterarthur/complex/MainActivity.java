package com.masterarthur.complex;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;

public class MainActivity extends Activity implements View.OnClickListener
{
	ComplexNumber z1;
	ComplexNumber z2;
	
	Spinner Z1ModeSpinner;
	Spinner Z2ModeSpinner;
	
	TextView Z1TitleATextView;
	TextView Z1TitleBTextView;
	
	TextView Z2TitleATextView;
	TextView Z2TitleBTextView;
	
	TextView Z1PrintTextView;
	TextView Z2PrintTextView;
	
	TextView ActionTextView;
	
	Button Z1PrintButton;
	Button Z2PrintButton;
	
	Button SumButton;
	Button SubtractButton;
	Button MultiplyButton;
	Button DivideButton;
	Button ParalelButton;
	
	EditText Z1AEditText;
	EditText Z1BEditText;
	
	EditText Z2AEditText;
	EditText Z2BEditText;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		Z1ModeSpinner = findViewById(R.id.z1ModeSpinner);
		Z2ModeSpinner = findViewById(R.id.z2ModeSpinner);

		Z1TitleATextView = findViewById(R.id.z1TitleA);
		Z1TitleBTextView = findViewById(R.id.z1TitleB);

		Z2TitleATextView = findViewById(R.id.z2TitleA);
		Z2TitleBTextView = findViewById(R.id.z2TitleB);

		Z1PrintTextView = findViewById(R.id.z1PrintTextView);
		Z2PrintTextView = findViewById(R.id.z2PrintTextView);

		ActionTextView = findViewById(R.id.actionResTextView);

		Z1PrintButton = findViewById(R.id.z1PrintButton);
		Z2PrintButton = findViewById(R.id.z2PrintButton);

		SumButton = findViewById(R.id.sumButton);
		SubtractButton = findViewById(R.id.subtractButton);
		MultiplyButton = findViewById(R.id.multiplyButton);
		DivideButton = findViewById(R.id.divideButton);
		ParalelButton = findViewById(R.id.paralelButton);

		Z1AEditText = findViewById(R.id.z1EditTextA);
		Z1BEditText = findViewById(R.id.z1EditTextB);

		Z2AEditText = findViewById(R.id.z2EditTextA);
		Z2BEditText = findViewById(R.id.z2EditTextB);
		
		
		Z1PrintButton.setOnClickListener(this);
		Z2PrintButton.setOnClickListener(this);
		
		SumButton.setOnClickListener(this);
		SubtractButton.setOnClickListener(this);
		MultiplyButton.setOnClickListener(this);
		DivideButton.setOnClickListener(this);
		ParalelButton.setOnClickListener(this);
		
		Z1ModeSpinner.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, new String[] {
													  "Arif",
													  "Euler"
												  }));
												  
		Z2ModeSpinner.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, new String[] {
													  "Arif",
													  "Euler"
												  }));
		
												  
		Z1ModeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

				@Override
				public void onNothingSelected(AdapterView<?> p1)
				{
					// TODO: Implement this method
				}
				

				@Override
				public void onItemSelected(AdapterView<?> p1, View p2, int p3, long p4)
				{
					if(p3 == 0) {
						if(z1 != null) {
							Z1AEditText.setText(z1.getRealStr());
							Z1BEditText.setText(z1.getImaginaryStr());
						}
						Z1TitleATextView.setText("Real");
						Z1TitleBTextView.setText("Imaginary");
					} else {
						if(z1 != null) {
							Z1AEditText.setText(z1.getAbsValueStr());
							Z1BEditText.setText(z1.getArgumentStr());
						}
						Z1TitleATextView.setText("Abs value");
						Z1TitleBTextView.setText("Argument");
					}
				}
			
		});
		
		Z2ModeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

				@Override
				public void onNothingSelected(AdapterView<?> p2)
				{
					// TODO: Implement this method
				}


				@Override
				public void onItemSelected(AdapterView<?> p1, View p2, int p3, long p4)
				{
					if(p3 == 0) {
						if(z2 != null) {
							Z2AEditText.setText(z2.getRealStr());
							Z2BEditText.setText(z2.getImaginaryStr());
						}
						Z2TitleATextView.setText("Real");
						Z2TitleBTextView.setText("Imaginary");
					} else {
						if(z2 != null) {
							Z2AEditText.setText(z2.getAbsValueStr());
							Z2BEditText.setText(z2.getArgumentStr());
						}
						Z2TitleATextView.setText("Abs value");
						Z2TitleBTextView.setText("Argument");
					}
				}

			});
    }

	@Override
	public void onClick(View p1)
	{
		double a,b;
		ComplexNumber res;
		switch(p1.getId()) {
			case R.id.z1PrintButton: 
				if(Z1AEditText.getText().toString().equals("") ||
					Z1BEditText.getText().toString().equals("")) {
						Toast.makeText(this, "Введи нормально, долбоеб", 0).show();
						break;
				}
				
				a = Double.parseDouble(Z1AEditText.getText().toString());
				b = Double.parseDouble(Z1BEditText.getText().toString());
				
				if(Z1ModeSpinner.getSelectedItemPosition() == 0) {
					z1 = ComplexNumber.createArifmetic(a,b);
				} else {
					z1 = ComplexNumber.createEuler(a,b);
				}
				
				Z1PrintTextView.setText("Z1 = " + z1);
				break;
			
			case R.id.z2PrintButton: 
				if(Z2AEditText.getText().toString().equals("") ||
				   Z1BEditText.getText().toString().equals("")) {
					Toast.makeText(this, "Введи нормально, долбоеб", 0).show();
					break;
				}

				a = Double.parseDouble(Z2AEditText.getText().toString());
				b = Double.parseDouble(Z2BEditText.getText().toString());

				if(Z2ModeSpinner.getSelectedItemPosition() == 0) {
					z2 = ComplexNumber.createArifmetic(a,b);
				} else {
					z2 = ComplexNumber.createEuler(a,b);
				}

				Z2PrintTextView.setText("Z2 = " + z2);
				break;
				
			case R.id.sumButton:
				if(Z1AEditText.getText().toString().equals("") ||
				   Z1BEditText.getText().toString().equals("")) {
					Toast.makeText(this, "Введи нормально, долбоеб", 0).show();
					break;
				}
				
				if(Z2AEditText.getText().toString().equals("") ||
				   Z1BEditText.getText().toString().equals("")) {
					Toast.makeText(this, "Введи нормально, долбоеб", 0).show();
					break;
				}
				
				if(z1 == null) {
					a = Double.parseDouble(Z1AEditText.getText().toString());
					b = Double.parseDouble(Z1BEditText.getText().toString());

					if(Z1ModeSpinner.getSelectedItemPosition() == 0) {
						z1 = ComplexNumber.createArifmetic(a,b);
					} else {
						z1 = ComplexNumber.createEuler(a,b);
					}
				}
				
				if(z2 == null) {
					a = Double.parseDouble(Z2AEditText.getText().toString());
					b = Double.parseDouble(Z2BEditText.getText().toString());

					if(Z2ModeSpinner.getSelectedItemPosition() == 0) {
						z2 = ComplexNumber.createArifmetic(a,b);
					} else {
						z2 = ComplexNumber.createEuler(a,b);
					}
					
				}
				
				res = z1.sum(z2);
				
				ActionTextView.setText("Z1 + Z2= " + res);
				break;
				
			case R.id.subtractButton:
				if(Z1AEditText.getText().toString().equals("") ||
				   Z1BEditText.getText().toString().equals("")) {
					Toast.makeText(this, "Введи нормально, долбоеб", 0).show();
					break;
				}

				if(Z2AEditText.getText().toString().equals("") ||
				   Z1BEditText.getText().toString().equals("")) {
					Toast.makeText(this, "Введи нормально, долбоеб", 0).show();
					break;
				}

				if(z1 == null) {
					a = Double.parseDouble(Z1AEditText.getText().toString());
					b = Double.parseDouble(Z1BEditText.getText().toString());

					if(Z1ModeSpinner.getSelectedItemPosition() == 0) {
						z1 = ComplexNumber.createArifmetic(a,b);
					} else {
						z1 = ComplexNumber.createEuler(a,b);
					}
				}

				if(z2 == null) {
					a = Double.parseDouble(Z2AEditText.getText().toString());
					b = Double.parseDouble(Z2BEditText.getText().toString());

					if(Z2ModeSpinner.getSelectedItemPosition() == 0) {
						z2 = ComplexNumber.createArifmetic(a,b);
					} else {
						z2 = ComplexNumber.createEuler(a,b);
					}

				}

				res = z1.subtract(z2);

				ActionTextView.setText("Z1 - Z2= " + res);
				break;
			
			case R.id.multiplyButton:
				if(Z1AEditText.getText().toString().equals("") ||
				   Z1BEditText.getText().toString().equals("")) {
					Toast.makeText(this, "Введи нормально, долбоеб", 0).show();
					break;
				}

				if(Z2AEditText.getText().toString().equals("") ||
				   Z1BEditText.getText().toString().equals("")) {
					Toast.makeText(this, "Введи нормально, долбоеб", 0).show();
					break;
				}

				if(z1 == null) {
					a = Double.parseDouble(Z1AEditText.getText().toString());
					b = Double.parseDouble(Z1BEditText.getText().toString());

					if(Z1ModeSpinner.getSelectedItemPosition() == 0) {
						z1 = ComplexNumber.createArifmetic(a,b);
					} else {
						z1 = ComplexNumber.createEuler(a,b);
					}
				}

				if(z2 == null) {
					a = Double.parseDouble(Z2AEditText.getText().toString());
					b = Double.parseDouble(Z2BEditText.getText().toString());

					if(Z2ModeSpinner.getSelectedItemPosition() == 0) {
						z2 = ComplexNumber.createArifmetic(a,b);
					} else {
						z2 = ComplexNumber.createEuler(a,b);
					}

				}

				res = z1.multiply(z2);

				ActionTextView.setText("Z1 * Z2= " + res);
				break;
				
			case R.id.divideButton:
				if(Z1AEditText.getText().toString().equals("") ||
				   Z1BEditText.getText().toString().equals("")) {
					Toast.makeText(this, "Введи нормально, долбоеб", 0).show();
					break;
				}

				if(Z2AEditText.getText().toString().equals("") ||
				   Z1BEditText.getText().toString().equals("")) {
					Toast.makeText(this, "Введи нормально, долбоеб", 0).show();
					break;
				}

				if(z1 == null) {
					a = Double.parseDouble(Z1AEditText.getText().toString());
					b = Double.parseDouble(Z1BEditText.getText().toString());

					if(Z1ModeSpinner.getSelectedItemPosition() == 0) {
						z1 = ComplexNumber.createArifmetic(a,b);
					} else {
						z1 = ComplexNumber.createEuler(a,b);
					}
				}

				if(z2 == null) {
					a = Double.parseDouble(Z2AEditText.getText().toString());
					b = Double.parseDouble(Z2BEditText.getText().toString());

					if(Z2ModeSpinner.getSelectedItemPosition() == 0) {
						z2 = ComplexNumber.createArifmetic(a,b);
					} else {
						z2 = ComplexNumber.createEuler(a,b);
					}

				}

				res = z1.divide(z2);

				ActionTextView.setText("Z1 / Z2= " + res);
				break;
			case R.id.paralelButton:
				if(Z1AEditText.getText().toString().equals("") ||
				   Z1BEditText.getText().toString().equals("")) {
					Toast.makeText(this, "Введи нормально, долбоеб", 0).show();
					break;
				}

				if(Z2AEditText.getText().toString().equals("") ||
				   Z1BEditText.getText().toString().equals("")) {
					Toast.makeText(this, "Введи нормально, долбоеб", 0).show();
					break;
				}

				if(z1 == null) {
					a = Double.parseDouble(Z1AEditText.getText().toString());
					b = Double.parseDouble(Z1BEditText.getText().toString());

					if(Z1ModeSpinner.getSelectedItemPosition() == 0) {
						z1 = ComplexNumber.createArifmetic(a,b);
					} else {
						z1 = ComplexNumber.createEuler(a,b);
					}
				}

				if(z2 == null) {
					a = Double.parseDouble(Z2AEditText.getText().toString());
					b = Double.parseDouble(Z2BEditText.getText().toString());

					if(Z2ModeSpinner.getSelectedItemPosition() == 0) {
						z2 = ComplexNumber.createArifmetic(a,b);
					} else {
						z2 = ComplexNumber.createEuler(a,b);
					}

				}

				res = z1.multiply(z2).divide(z1.sum(z2));

				ActionTextView.setText("Z1 || Z2 = (Z1*Z2)/(Z1+Z2) = " + res);
				break;
		}
	}

	
	
}
