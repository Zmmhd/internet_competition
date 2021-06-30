package database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    public static final String CREATE_USER = "create table User ("
            + "id integer primary key autoincrement, "
            + "username text, "
            + "password text)";

    private Context mContext;

    public MyDatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER);//执行建表语句
        Toast.makeText(mContext, "Create succeeded", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public int queryByUser(String targetUsername, String targetPassword){
        if(targetPassword.equals("") && targetUsername.equals(""))return 2;
        int flag = 0;
        SQLiteDatabase db = getReadableDatabase();
        String username, password;
        Cursor cursor = db.query("User", null, null, null, null, null, null);
        if(cursor.moveToFirst()){
            do{
                username = cursor.getString(cursor.getColumnIndex("username"));
                password = cursor.getString(cursor.getColumnIndex("password"));

                if (username.equals(targetUsername)){
                    if(password.equals(targetPassword))
                        flag = 1;
                }
            } while(cursor.moveToNext());
        }
        cursor.close();
        return flag;
    }


    public boolean queryByUsername(String targetUsername){
        if(targetUsername.equals(""))return false;
        boolean flag = false;
        SQLiteDatabase db = getReadableDatabase();
        String username;
        Cursor cursor = db.query("User", null, null, null, null, null, null);
        if(cursor.moveToFirst()){
            do{
                username = cursor.getString(cursor.getColumnIndex("username"));
                if (username.equals(targetUsername)){
                    flag=true;
                }
            } while(cursor.moveToNext());
        }
        cursor.close();
        return flag;
    }

}
