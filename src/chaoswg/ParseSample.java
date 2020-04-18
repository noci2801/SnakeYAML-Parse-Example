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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.security.CodeSource;
import java.util.HashMap;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.TypeDescription;


import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.representer.Representer;

public class ParseSample {
    //###https://gist.github.com/marceldiass/f1d0e25671d7f47b24271f15c1066ea3
    private static File jarDir;

	public static void main(String... a) {
            try{
                CodeSource codeSource = ParseSample.class.getProtectionDomain().getCodeSource();
                File jarFile = new File(codeSource.getLocation().toURI().getPath());
                jarDir = jarFile;
            }catch (Exception ex){}
            File yamalFile = new File(jarDir,"config.yml");
            System.out.println("Load Config  DIR: "+jarDir.getAbsolutePath());
            System.out.println("Load Config FILE: "+yamalFile.getAbsolutePath());
            
            //### Manuelle Daten ###
            YamlConfig data = new YamlConfig();
            data.setApplications(new HashMap<>());
            data.setVersion(2800);
            
            ServiceConfig value = new ServiceConfig();
            value.setServiceName("TS 2801");
            value.setServiceVersion("2.8.0.1");
            
            data.getApplications().put("Test", value);
            
            Yaml yaml = null;

            DumperOptions options=new DumperOptions();
            options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
            options.setIndent(2);
            options.setWidth(80);

            if (yamalFile.exists()){
                //### Read ###
                Constructor constructor = new Constructor(YamlConfig.class);

                TypeDescription configD = new TypeDescription(ServiceConfig.class);
                //configD.putListPropertyType("applications", YamlConfig.class);
                constructor.addTypeDescription(configD);

                Representer rep = new Representer();
                rep.addTypeDescription(configD);

                //yaml=new Yaml(options);
                yaml = new Yaml( constructor, rep, options );

                InputStream input = null;
                try {
                        input = new FileInputStream(yamalFile);
                } catch (FileNotFoundException e) {
                        e.printStackTrace();
                }
                data = yaml.loadAs( input, YamlConfig.class );
            }else{
                //### Write ###
                yaml=new Yaml(options);
                 
                FileWriter writer=null;
                try {
                    writer=new FileWriter(yamalFile);
                    yaml.dump(data,writer);
                }catch (  IOException ex) {
                    ex.printStackTrace();
                    //throw new AndrolibException(ex);
                }finally {
                    if (writer != null) {try {writer.close();}catch (IOException ex) {}}
                }
            }
            
            System.out.println( data );
            System.out.println( "###" );
            System.out.println( yaml.dump( data ));
        
        }
}