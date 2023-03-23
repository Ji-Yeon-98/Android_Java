package com.example.firebaseemailaccount;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth;      //파이어베이스 인증
    private DatabaseReference mDatabaseRef; //실시간 데이터 베이스

    private EditText mEtEmail, mEtPwd;      //회원가입 입력필드
    private Button mBtnRegister;            //회원가입 버튼

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFirebaseAuth = FirebaseAuth.getInstance(); // FirebaseAuth 사용할 준비
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("FirebaseAccuont");

        mEtEmail = findViewById(R.id.et_email);
        mEtPwd = findViewById(R.id.et_pwd);
        mBtnRegister = findViewById(R.id.btn_register);

        mBtnRegister.setOnClickListener(new View.OnClickListener() { //회원가입 버튼 눌렀을 때
            @Override
            public void onClick(View v) {
                //회원가입 처리 시작
                String strEmail = mEtEmail.getText().toString(); //입력 필드에 있는 값 가져오는 기능
                String strPwd = mEtPwd.getText().toString();

                //Firebase Auth 진행 (firebase에서 이메일과 패스워스로 유저를 생성)
                mFirebaseAuth.createUserWithEmailAndPassword(strEmail, strPwd).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) { //회원가입이 성공이 되었을 때
                        //task : 회원가입 처리를 한 결과 값
                        if(task.isSuccessful()){
                            //현재 회원가입이 된 유저를 가져온다.
                            FirebaseUser firebaseUser = mFirebaseAuth.getCurrentUser();
                            UserAccount account = new UserAccount();
                            account.setIdToken(firebaseUser.getUid());      //고유값 가져오기
                            account.setEmailId(firebaseUser.getEmail());    //로그인이 된 user 이메일이 중요하기 때문에
                            account.setPassword(strPwd);                    //pw는 가져올 수 없다.

                            //setValue : database에 insert (삽입) 행위
                            //FirebaseAccount의 하위개념인 UserAccount에 firebase uid를 키값으로 하는 setValue(account) 정보 넣기
                            mDatabaseRef.child("UserAccount").child(firebaseUser.getUid()).setValue(account);

                            Toast.makeText(RegisterActivity.this, "회원가입에 성공하셨습니다.", Toast.LENGTH_SHORT).show();

                        }else{
                            Toast.makeText(RegisterActivity.this, "회원가입에 실해하셨습니다.", Toast.LENGTH_SHORT).show();
                        }

                    }
                });

            }
        });

    }
}