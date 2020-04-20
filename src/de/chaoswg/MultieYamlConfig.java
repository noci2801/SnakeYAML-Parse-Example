/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.chaoswg;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Schmull
 */
public class MultieYamlConfig {
    public MultieYamlConfig() {
        this.version = null;
        this.author = "";
        this.DEBUG = false;
        this.multieConfig = new MultieConfig();
        this.comanos = new ArrayList<>();
    }
    
    private String version;
    public String getVersion() {return version;}
    public void setVersion(String version) {this.version = version;}

    private String author;
    public String getAuthor() {return author;}
    public void setAuthor(String author) {this.author = author;}

    private boolean DEBUG;
    public boolean isDebug() {return DEBUG;}
    public void setDebug(boolean debug) {this.DEBUG = debug;}

    //private int debug;
    //void setDebug(int debug) {this.debug=debug;}
    //public int getDEBUB() {return debug;}
    
    private MultieConfig multieConfig;
    public MultieConfig getMultieConfig() {return multieConfig;}
    public void setMultieConfig(MultieConfig multieConfig) {this.multieConfig = multieConfig;}
    
    private List<MultieConfigComando> comanos;
    public List<MultieConfigComando> getComanos() {return comanos;}
    public void setComanos(List<MultieConfigComando> comanos) {this.comanos = comanos;}
    

    @Override public String toString() {
            return "MultieYamlConfig{" +
                            "version=" + version + " " +
                            "author=" + author + " " +
                            "debug=" + DEBUG + " " +
                            "MultieConfig=" + multieConfig +
                            '}';
    }

}
