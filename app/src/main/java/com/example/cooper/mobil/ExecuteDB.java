package com.example.cooper.mobil;

import android.app.DownloadManager;
import android.graphics.Interpolator;
import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Created by Cooper on 28/12/2016.
 */

public class ExecuteDB extends AsyncTask<String,Void,ResultSet> {
    private Connection connection;
    private String query;

    public ExecuteDB(Connection connection, String query) {
        this.connection = connection;
        this.query = query;
    }

    @Override
    protected ResultSet doInBackground(String... strings) {
        ResultSet resulset =null;
        try{
            resulset=connection.prepareStatement(query).executeQuery();

        }catch (Exception e){

        }finally {
            try{
                connection.close();
            }catch (Exception ex){

            }
        }
        return resulset;



    }
}

