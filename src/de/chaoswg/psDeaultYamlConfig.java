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
    public class psDeaultYamlConfig extends ChaosTools.DeaultSnakeYamal.DeaultYamlConfig{
        public psDeaultYamlConfig() {
            ps = false;
            macAddressen = new HashMap<>();
        }
        
        private boolean ps;
        public boolean getPs() {return ps;}
        public void setPs(boolean ps) {this.ps = ps;}
        
        private Map<Integer, psServiceConfigMAC> macAddressen;
        public Map<Integer, psServiceConfigMAC> getMacAddressen() {return macAddressen;}
        public void setMacAddressen(Map<Integer, psServiceConfigMAC> macAddressen) {this.macAddressen = macAddressen;}
        
        public static class psServiceConfigMAC {
            public psServiceConfigMAC() {
                this.name = null;
                this.mac = null;
            }

            private String mac;
            public String getMac() {return mac;}
            public void setMac(String mac) {this.mac = mac;}
            
            private String name;
            public String getName() {return name;}
            public void setName(String name) {this.name = name;}
            
            @Override public String toString() {
                    return "psServiceConfigMAC{" +
                                    "mac=" + mac + " " +
                                    "name=" + name +
                                    '}';
            }
        }
        
        @Override public String toString() {
                return super.toString() +"\n"+ "psDeaultYamlConfig{" +
                                "ps=" + ps + " " +
                                "macAddressen=" + macAddressen +
                                '}';
        }
    }

