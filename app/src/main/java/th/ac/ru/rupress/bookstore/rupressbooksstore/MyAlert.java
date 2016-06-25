package th.ac.ru.rupress.bookstore.rupressbooksstore;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by PLAN-NB on 6/25/2016.
 */
public class MyAlert {
    //Context คือ ท่อต่อไปหา เช่น Context ไปหาฐานข้อมูล
    public void myDialog(Context context,String strTitle,String strMessage) {


    //instant คือ ตัวแทน
        //
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(false);
        builder.setIcon(R.drawable.doremon48);
        builder.setTitle(strTitle);
        builder.setMessage(strMessage);
        builder.setPositiveButton("ตกลง", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();


    }
} //Main Class
