/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.chaoswg;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Schmull
 */
public class MultieConfigComando {
    public MultieConfigComando() {
        this.comando = "";
        this.debugLv = -1;
        this.msgDebug = "";
        this.msgLang = new HashMap<>();
    }

    private String comando;
    public String getComando() {return comando;}
    public void setComando(String comando) {this.comando = comando;}
    
    private int debugLv;
    public int getDebugLv() {return debugLv;}
    public void setDebugLv(int debugLv) {this.debugLv = debugLv;}

    private String msgDebug;
    public String getMsgDebug() {return msgDebug;}
    public void setMsgDebug(String msgDebug) {this.msgDebug = msgDebug;}
    
    
    private Map<String,String> msgLang;
    public Map<String, String> getMessage() {return msgLang;}
    public void setMessage(Map<String, String> message) {this.msgLang = message;}
    
    
    @Override public String toString() {
            return "MultieConfigComando{" +
                            "comando=" + comando + " " +
                            "debugLv=" + debugLv + " " +
                            "msgDebug=" + msgDebug + " " +
                            "msgLang=" + msgLang + "" +
                            '}';
    }

}
