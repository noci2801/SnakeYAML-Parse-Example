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
public class MultieConfig {
    public MultieConfig() {
        this.userMax = -1;
    }
    public void MultieConfigIni() {
        this.playerUID = 0L;
        this.adminList = new ArrayList<>();
    }

    private Long playerUID;
    public Long getPlayerUID() {return playerUID;}
    public void setPlayerUID(Long msgDebug) {this.playerUID = msgDebug;}
    
    private List<Long> adminList;
    public List<Long> getAdminList() {return adminList;}
    public void setAdminList(List<Long> adminList) {this.adminList = adminList;}
    
    private int userMax;
    public int getUserMax() {return userMax;}
    public void setUserMax(int userMax) {this.userMax = userMax;}

    
    @Override public String toString() {
            return "MultieYamlConfig{" +
                            "playerUID=" + playerUID + " " +
                            "adminList=" + adminList + " " +
                            "debugLv=" + userMax + " " +
                            '}';
    }

}
