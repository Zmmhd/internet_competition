package database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;


// 对数据库的操作都继承这个类

public class WordsDatabaseHelper extends SQLiteOpenHelper {

    // weight对于不同单词本，如四级，高中，权重不一样，获得币为weight * coincidence。当天普通词为0，特殊词为特定值。
    public static final String CREATE_WORDBOOK = "create table WordBook ("
            + "id integer primary key autoincrement, "
            + "EnglishWord text,"
            + "ChineseWord text,"
            + "PhoneticSymbols text,"
            + "PartOfSpeech text,"
            + "coincidence integer,"
            + "weight integer)";

    private Context mContext;

    public WordsDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_WORDBOOK);
        Toast.makeText(mContext,"Create succeeded",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
