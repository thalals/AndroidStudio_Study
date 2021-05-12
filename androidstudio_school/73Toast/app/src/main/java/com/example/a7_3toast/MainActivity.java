package com.example.a7_3toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvName;
    TextView tvEmail;
    EditText dlgEdtName,dlgEdtEmail;
    TextView toastText;
    View dialogView, toastView;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("사용자 정보 입력");

        tvName=(TextView) findViewById(R.id.tvName);
        tvEmail=(TextView) findViewById(R.id.tvEmail);
        button1=(Button)findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                dialogView=(View)View.inflate(MainActivity.this,R.layout.dialog1,null);
                AlertDialog.Builder dlg=new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("사용자 정보 입력");
                dlg.setIcon(R.drawable.pic01);
                dlg.setView(dialogView);
                dlg.setPositiveButton("확인",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dlgEdtName = (EditText)dialogView.findViewById(R.id.dlgEdit1);
                                dlgEdtEmail= (EditText)dialogView.findViewById(R.id.dlgEdit2);

                                tvName.setText(dlgEdtName.getText().toString());
                                tvEmail.setText(dlgEdtEmail.getText().toString());
                            }
                        });
                dlg.setPositiveButton("취소",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast toast=new Toast(MainActivity.this);
                                toastView=(View)View.inflate(MainActivity.this,R.layout.toast1,null);
                                toastText=(TextView)toastView.findViewById(R.id.textView);
                                toastText.setText("취소했습니다.");
                                toast.setView(toastView) ;

                                toast.show();
                            }
                        });
                dlg.show();
            }
        });
    }
}