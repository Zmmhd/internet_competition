package database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class NewWordsDatabaseHelper extends SQLiteOpenHelper {

    public static final String CREATE_NEWWORD = "create table NewWord ("
            + "id integer primary key autoincrement, "
            + "Word text)";

    private Context mContext;

    public NewWordsDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_NEWWORD);
    }

    public String getNextWord(String currentWord){
        String nextWord;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("NewWord", null, null, null, null, null, null, null);
        if(cursor.moveToFirst()){
            do{
                nextWord = cursor.getString(cursor.getColumnIndex("Word"));
                if(nextWord.equals(currentWord)){
                    if(cursor.moveToNext()){
                        nextWord = cursor.getString(cursor.getColumnIndex("Word"));
                        return nextWord;
                    }
                    return null;
                }

            } while(cursor.moveToNext());
        }
        return null;
    }

    public String getPreviousWord(String currentWord){
        String previousWord;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("NewWord", null, null, null, null, null, null, null);
        if(cursor.moveToFirst()){
            do{
                previousWord = cursor.getString(cursor.getColumnIndex("Word"));
                if(previousWord.equals(currentWord)){
                    if(cursor.moveToPrevious()){
                        previousWord = cursor.getString(cursor.getColumnIndex("Word"));
                        return previousWord;
                    }
                    return null;
                }

            } while(cursor.moveToNext());
        }
        return null;
    }
    
    
    

    public String getFirstWord(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("NewWord", null, null, null, null, null, null, null);
        if(cursor.moveToFirst()){
            return cursor.getString(cursor.getColumnIndex("Word"));
        }
        return null;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
