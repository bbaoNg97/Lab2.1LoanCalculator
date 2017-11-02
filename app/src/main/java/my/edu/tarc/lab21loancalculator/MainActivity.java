package my.edu.tarc.lab21loancalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

private EditText editTextPrice,editTextDownpayment,editTextRepayment,editTextIntRate,editTextSalary;

    public static final String LOAN_PAYMENT = "payment";
    public static final String LOAN_STATUS = "status";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//link to UI
        editTextPrice=(EditText)findViewById(R.id.editTextPrice);
        editTextDownpayment=(EditText)findViewById(R.id.editTextDownpayment);
        editTextRepayment=(EditText)findViewById(R.id.editTextRepayment);
        editTextIntRate=(EditText)findViewById(R.id.editTextIntRate);
        editTextSalary=(EditText)findViewById(R.id.editTextSalary);
    }
    public void claculateLoan(View view){
        //this 'blue line' not only comment, but can maintainance
        //TODO:calculate repayment amount and determine the status of loan apps
        double payment=450.0;
        String status="Approved";
        double vehiclePrice=Double.parseDouble(editTextPrice.getText().toString());
        double dowmPayment=Double.parseDouble(editTextDownpayment.getText().toString());
        double interestRate=Double.parseDouble(editTextIntRate.getText().toString());
        double repayment=Double.parseDouble(editTextRepayment.getText().toString());
        double salary=Double.parseDouble(editTextSalary.getText().toString());

double totalInterest=(vehiclePrice-dowmPayment)*(interestRate/100)*(repayment/12);
      double totalLoan=(vehiclePrice-dowmPayment)+totalInterest;
        double monthlyPayment=totalLoan/repayment;
payment=monthlyPayment;
        if(monthlyPayment>0.3*salary){
            status="Rejected";

        }
        else
            status="Approved";
        //Define Intent Object
        //this is an explicit intent
        Intent intent=new Intent(this,ResultActivity.class);
        //use the putExtra method to pass data
        //formate: putExtra(TAG,value);
        intent.putExtra(LOAN_PAYMENT,payment);
        intent.putExtra(LOAN_STATUS, status);
        startActivity(intent);
    }
    public void resetScreen(View view){
        editTextDownpayment.setText("");
        editTextRepayment.setText("");
        editTextIntRate.setText("");
        editTextSalary.setText("");
        editTextPrice.setText("");
    }
}





