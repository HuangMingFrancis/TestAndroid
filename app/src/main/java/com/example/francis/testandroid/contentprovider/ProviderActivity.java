package com.example.francis.testandroid.contentprovider;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.francis.testandroid.R;
import com.example.francis.testandroid.aidl.Book;

public class ProviderActivity extends AppCompatActivity {
    private static final String TAG = "ProviderActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider);

        Uri bookUri = Uri.parse("content://" + BookProvider.AUTHORITY + "/book");
        ContentValues values = new ContentValues();
        values.put("_id", 6);
        values.put("name", "程序设计的艺术");
        getContentResolver().insert(bookUri, values);
        Cursor bookCrisor = getContentResolver().query(bookUri, new String[]{"_id", "name"}, null, null, null);
        while (bookCrisor.moveToNext()){
            Book book = new Book(bookCrisor.getInt(0), bookCrisor.getString(1));
            Log.d(TAG, "onCreate: book: " + book.bookId + "  " + book.bookName);
        }
        bookCrisor.close();

        Uri userUri = Uri.parse("content://com.example.francis.testandroid.book.provider/user");
        Cursor userCursor = getContentResolver().query(userUri, new String[]{"_id" , "name", "sex"}, null, null, null);
        while (userCursor.moveToNext()){
            Log.d(TAG, "onCreate: user: " + userCursor.getInt(0) + " " + userCursor.getString(1) + " " + userCursor.getInt(2));
        }
        userCursor.close();
    }
}
