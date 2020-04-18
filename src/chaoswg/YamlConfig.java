/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chaoswg;

/**
 *
 * @author Schmull
 */
import java.util.Map;

public class YamlConfig {
        int version;
        public int getVersion() {return version;}
        public void setVersion(int version) {this.version = version;}
        
	Map<String, ServiceConfig> applications;
	public Map<String, ServiceConfig> getApplications() {return applications;}
	public void setApplications(Map<String, ServiceConfig> applications) {this.applications = applications;}

	@Override public String toString() {
		return "YamlConfig{" +
				"applications=" + applications +
				'}';
	}
}