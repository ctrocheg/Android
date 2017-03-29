package com.example.cooper.mobil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


/**
 * Created by Cooper on 28/12/2016.
 */

public class DB extends _Default implements Runnable {
    private Connection conn;
    private String host="192.168.121.46";
    private String db="jayacmayu";
    private int port=5432;
    private String usuario="postgres";
    private String password="hlosv";
    private String url="jdbc:postgresql://192.168.88.254:5432/jayacmayu";
            //"jdbc:postgresql://%s:%d/%s ";

    public DB() {
        super();
        //this.url=String.format(this.url,this.host,this.port,this.db);
        //Abrir la Conexion
        this.conectar();
        this.desconectar();
    }

    @Override
    public void run() {
        //Ejecutamos la Conexion de la Base de Datos
        try{
            Class.forName("org.postgresql.Driver");
            this.conn = DriverManager.getConnection(this.url,this.usuario,this.password);

        }catch (Exception e){
            this._mensage=e.getMessage();
            this._status=false;
        }
    }

    private void conectar(){
        Thread Conexion = new Thread(this);
        Conexion.start();
        try{
            Conexion.join();

        }catch (Exception e){
            this._mensage=e.getMessage();
            this._status=false;
        }
    }

    private void desconectar(){
        if (this.conn!=null){
            try{
                this.conn.close();
            }catch (Exception e){
                this._mensage=e.getMessage();
                this._status=false;

            }finally {
                this.conn =null;
            }
        }
    }

    public ResultSet select(String query){
        this.conectar();
        ResultSet resultSet =null;
        try{
            resultSet=new ExecuteDB(this.conn,query).execute().get();
        }catch (Exception e){
            this._mensage=e.getMessage();
            this._status=false;
        }
        return resultSet;
    }


    public ResultSet execute(String query){
        this.conectar();
        ResultSet resultSet =null;
        try{
            resultSet=new ExecuteDB(this.conn,query).execute().get();
        }catch (Exception e){
            this._mensage=e.getMessage();
            this._status=false;
        }
        return resultSet;
    }
}
