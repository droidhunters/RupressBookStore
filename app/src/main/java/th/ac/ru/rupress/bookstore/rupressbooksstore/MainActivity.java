package th.ac.ru.rupress.bookstore.rupressbooksstore;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private EditText userEditText, passEditText;
    private String userString, passString;
    private static final String urlJSON = "http://swiftcodingthai.com/25JUN/get_user_dew.php";
    private boolean statusABoolean = true;
    private String truePasswordString;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget
        userEditText = (EditText) findViewById(R.id.editText5);
        passEditText = (EditText) findViewById(R.id.editText6);


    }  //Main Method

    //Inner Class
    private class SynUserTABLE extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {

            try {

                OkHttpClient okHttpClient = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                Request request = builder.url(urlJSON).build();
                Response response = okHttpClient.newCall(request).execute();
                return response.body().string();



            } catch (Exception e) {
                Log.d("26June","e==> " + e.toString());
                return null;
            }


        }// doInBack เมดธอดที่ทำงานอยู่เบื้องหลัง

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Log.d("26June", "JSON ==> " + s);
            try {
                JSONArray jsonArray = new JSONArray(s);
                for (int i=0;i<jsonArray.length();i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    if (userString.equals(jsonObject.getString("User"))) {
                        statusABoolean = false;
                        truePasswordString = jsonObject.getString("Password");
                    } //if
                } //for
            } catch (Exception e) {
                Log.d("26June", "e onPost ==>" + e.toString());
            }
            if (statusABoolean) {
                MyAlert myAlert = new MyAlert();
                myAlert.myDialog(MainActivity.this, "ไม่มี ผู้ใช่นี้", "ไม่มี" + userString + "ในฐานข้อมูลของเรา");
            } else if (passString.equals(truePasswordString)) {

                Intent intent = new Intent(MainActivity.this,ShowBookActivity. class);
                startActivity(intent);

            }else {
                MyAlert myAlert = new MyAlert();
                myAlert.myDialog(MainActivity.this, "Password False","Plase try Again Password False");
            }

        } //onPost


    } // Class




    public void clickSignIn(View view) {

        userString = userEditText.getText().toString().trim();
        passString = passEditText.getText().toString().trim();
        if (userString.equals("") || passString.equals("")) {

            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(this,"มีช่องว่าง","กรุณากรอกข้อมูลให้ครบ");



        } else {

            SynUserTABLE synUserTABLE = new SynUserTABLE();
            synUserTABLE.execute();


        }




    } //clickSign



    public void ClickSignUpMain(View view) {
        startActivity(new Intent(MainActivity.this,SingUpActivity.class));
    }
} //Main Class
