package com.example.cooper.mobil;

/**
 * Created by Cooper on 28/12/2016.
 */

public class _Default {
    protected String _mensage;
    protected  boolean _status;
    public  _Default(){
        this._status=true;
        this._mensage="";
    }

    public String get_mensage() {
        return _mensage;
    }

    public void set_mensage(String _mensage) {
        this._mensage = _mensage;
    }

    public boolean is_status() {
        return _status;
    }

    public void set_status(boolean _status) {
        this._status = _status;
    }
}
