package com.example.lab6;
import android.content.Intent; import android.content.SharedPreferences; import android.os.Bundle; import android.widget.*; import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
 EditText edtName, edtRollNo, edtEmail; RadioGroup radioGroup; CheckBox checkTerms; Button btnSave;
 @Override protected void onCreate(Bundle b){ super.onCreate(b); setContentView(R.layout.activity_main);
 edtName=findViewById(R.id.edtName); edtRollNo=findViewById(R.id.edtRollNo); edtEmail=findViewById(R.id.edtEmail); radioGroup=findViewById(R.id.radioGroup); checkTerms=findViewById(R.id.checkTerms); btnSave=findViewById(R.id.btnSave);
 btnSave.setOnClickListener(v->{ String name=edtName.getText().toString().trim(), roll=edtRollNo.getText().toString().trim(), email=edtEmail.getText().toString().trim(); int selected=radioGroup.getCheckedRadioButtonId();
 if(name.isEmpty()||roll.isEmpty()||email.isEmpty()||selected==-1){Toast.makeText(this,"Please enter all details",Toast.LENGTH_SHORT).show();return;}
 if(!checkTerms.isChecked()){Toast.makeText(this,"Please agree to terms and conditions",Toast.LENGTH_SHORT).show();return;}
 String gender=((RadioButton)findViewById(selected)).getText().toString(); SharedPreferences.Editor e=getSharedPreferences("StudentData",MODE_PRIVATE).edit(); e.putString("name",name);e.putString("rollNo",roll);e.putString("email",email);e.putString("gender",gender);e.apply(); startActivity(new Intent(this,DisplayActivity.class)); }); }
}