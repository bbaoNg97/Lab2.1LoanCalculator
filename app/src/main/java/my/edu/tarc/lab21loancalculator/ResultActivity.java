package my.edu.tarc.lab21loancalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
private TextView textViewMonthlyPayment,textViewStatus;
    private ImageView imageViewResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
textViewMonthlyPayment=(TextView)findViewById(R.id.textViewMonthlyPayment);
        textViewStatus=(TextView)findViewById(R.id.textViewStatus);
        imageViewResult=(ImageView)findViewById(R.id.imageViewResult);

        //get the intent
        Intent intent=getIntent();//asking who call me?
        double payment=intent.getDoubleExtra(MainActivity.LOAN_PAYMENT,0);//0 is default value
        String status=intent.getStringExtra(MainActivity.LOAN_STATUS);

        textViewMonthlyPayment.setText("Monthly payment: RM "+payment);
        textViewStatus.setText("Status: "+status);
        //tODO display outputs
        if(status.equals("Approved"))
imageViewResult.setImageResource(R.drawable.transparentthumbsup);


        else

            imageViewResult.setImageResource(R.drawable.transparentthumbsdown);

    }
    public void closeActivity(View view){
        //Terminate current activity
        finish();
    }
}
