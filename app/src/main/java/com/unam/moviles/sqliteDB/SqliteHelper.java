package com.unam.moviles.sqliteDB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.unam.moviles.model.Book;

/**
 * Created by Samuel on 19/04/2017.
 */

public class SqliteHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "BooksDB";


    private static final String TABLE_BOOKS = "books";

    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_AUTHOR ="author";

    private static final String[] COLUMS = {KEY_ID,KEY_TITLE,KEY_AUTHOR};

    public long addBook(Book userBook)
    {
        long result = 0;
        Log.d("addBook", userBook.toString());
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, userBook.getId());
        values.put(KEY_TITLE, userBook.getTitle());
        values.put(KEY_AUTHOR, userBook.getAuthor());

        result = db.insert(TABLE_BOOKS, null,values);

        db.close();
        return result;
    }

    public Book consultBook(int id_book)
    {
        Book result_book = null;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_BOOKS,
                COLUMS,
                "id=?",
                new String[]{String.valueOf(id_book)},
                null,
                null,
                null,
                null);


        if (cursor!= null)
        {
            if (cursor.moveToFirst())
            {
                result_book = new Book();
                result_book.setId(Integer.parseInt(cursor.getString(0)));
                result_book.setTitle(cursor.getString(1));
                result_book.setAuthor(cursor.getString(2));
                Log.d("consultBook("+ id_book + ")",result_book.toString());
            }
        }
        else
            return null;
        return  result_book;
    }




    public SqliteHelper(Context context)
    {
        super (context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_BOOKS_TABLE = "CREATE TABLE books(id INTEGER PRIMARY KEY, title TEXT, author TEXT)";
        db.execSQL(CREATE_BOOKS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST books");
        this.onCreate(db);
    }
}
