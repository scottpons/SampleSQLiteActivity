package scottsalvador.pons.com.mycrud;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class DBHelper extends SQLiteOpenHelper {
    final static String DBName = "Students.db";
    final static int VSR = 1;
    final static String TABLE = "GRADE";

    public DBHelper(Context context) {
        super(context, DBName, null, VSR);
        SQLiteDatabase db = this.getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE Grade (ID INTEGER PRIMARY KEY AUTOINCREMENT, FirstName TEXT, LastName TEXT, LabGrade INTEGER)";
        db.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String deleteTable = "DROP TABLE IF EXISTS Grade";
        db.execSQL(deleteTable);
    }

    public boolean insert(String fname,String lname, int lgrade){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("FirstName",fname);
        cv.put("LastName",lname);
        cv.put("LabGrade",lgrade);
        db.insert(TABLE,null,cv);
        return true;
    }
}
