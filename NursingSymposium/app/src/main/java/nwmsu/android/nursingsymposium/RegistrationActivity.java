package nwmsu.android.nursingsymposium;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }
    public void onRegisterBtnClick(View view)
    {
        TextView txtFirstName = findViewById(R.id.registerValidationTXT_firstName);
        TextView txtLastName = findViewById(R.id.registerValidationTXT_lastName);
        TextView txtEmail = findViewById(R.id.registerValidationTXT_email);
        TextView txtValidation = findViewById(R.id.registerValidationTXT_email);
        EditText editTxtFirstName = findViewById(R.id.registerText_firstName);
        EditText editTxtLastName = findViewById(R.id.registerText_lastName);
        EditText editTxtEmail = findViewById(R.id.registerText_email);

        txtFirstName.setText("Fist Name:"+editTxtFirstName.getText().toString());
        txtLastName.setText("Last Name:"+editTxtLastName.getText().toString());
        txtEmail.setText("Email :"+editTxtEmail.getText().toString());
        String myValidationText = "";
        if ( !isNameValid( editTxtFirstName.getText().toString())) {
            myValidationText += "First Name is not valid\n";
            txtFirstName.setText(myValidationText);
        }
        if( !isNameValid( editTxtLastName.getText().toString())) {
            myValidationText += "Last Name is not valid\n";
            txtFirstName.setText(myValidationText);
        }

        if( !isEmailValid( editTxtEmail.getText().toString())) {
            myValidationText += "Email is not a valid email\n";
            txtFirstName.setText(myValidationText);
        }
        if( !myValidationText.equals("")) {
            txtValidation.setText( "Data cannot be empty");
        }

        

    }

    public boolean isNameValid( String myString) {
        return true;
    }

    public boolean isEmailValid( String myString) {
        return true;
    }

}