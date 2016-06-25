package th.ac.ru.rupress.bookstore.rupressbooksstore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SingUpActivity extends AppCompatActivity {

    //Explicit ประกาศตัวแปร
    // ประกาศ ตัวแปร แบบ Private โดยเฉพาะ โดยสร้างตัวแปร ให้ตรงกัน กับ Form
    private EditText UserEditText, PassEditText, NameEditText, AddrEditText;
    private String userString, passString, nameString, addrString;
    // Text อยู่ในรูปแบบ String
    //control + alt + L เพื่อทำการเรียง Code เพื่อความสวยงาม

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

        //Bind Widget   การผูกตัวแปร = findview(ใส่ R .id .ตัวแปร(Form) กด alt + Enter เพื่อทำการ Cast)
        UserEditText = (EditText) findViewById(R.id.editText);
        PassEditText = (EditText) findViewById(R.id.editText2);
        NameEditText = (EditText) findViewById(R.id.editText3);
        AddrEditText = (EditText) findViewById(R.id.editText4);


    } // Main Method

    public void ClickSignUpSign(View view) {

        //Get Value form Editext
        userString = UserEditText.getText().toString().trim();
        passString = PassEditText.getText().toString().trim();
        nameString = NameEditText.getText().toString().trim();
        addrString = AddrEditText.getText().toString().trim();


        // CheckSpace สิ่งที่กรอกครบแล้วหรือยัง แล้ว แจ้ง Alert
        // if (ctrl+enter) สร้างปีกกา
        if (userString.equals("") ||
                passString.equals("") ||
                nameString.equals("") ||
                addrString.equals("")) {
            //Have Space
            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(this,"OK","Test");
            }
        else {
            //No Space
            // สร้าง Sting + alt+enter เพื่อให้โปรแกรมสร้าง Method อัตโนมัติ
            uploadUserToServer();

        }

    } // ClickSign

    private void uploadUserToServer() {

    }

} //Main Class
