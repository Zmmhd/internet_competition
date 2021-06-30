package database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class NewWordsDatabaseHelper extends WordsDatabaseHelper{
    public NewWordsDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

}
