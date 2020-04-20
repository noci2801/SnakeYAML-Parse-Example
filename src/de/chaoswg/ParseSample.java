/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.chaoswg;

/**
 *
 * @author Schmull
 */
import static de.chaoswg.ChaosTools.DeaultSnakeYamal.loadYAMAL;
import static de.chaoswg.ChaosTools.DeaultSnakeYamal.writeYAMAL;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.security.CodeSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.TypeDescription;


import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.representer.Representer;

public class ParseSample {
    /**
     * https://gist.github.com/marceldiass/f1d0e25671d7f47b24271f15c1066ea3
     * oder neu in RW
     * http://theoryapp.com/parse-json-in-java/
    */ 
    private static File jarDir;

    public static void main(String... a) {
        //### getPhat ###
        try{
            CodeSource codeSource = ParseSample.class.getProtectionDomain().getCodeSource();
            File jarFile = new File(codeSource.getLocation().toURI().getPath());
            jarDir = jarFile;
        }catch (Exception ex){}
        //### setFile ###
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

        data.getApplications().put("test", value);

        //### SnakeYAMAL ###
        Yaml yaml;

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
                    //throw new ImportException("Failed to load yaml object");
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

        //##############
        //### Ver II ###
        //##############

        //### Manuelle Daten ###
        psDeaultYamlConfig data2 = new psDeaultYamlConfig();
        data2.setAuthor("noci");
        data2.setDebug(true);
        data2.setVersion("0.0.1");
        //###
        data2.setPs(true);
        Map<Integer, psDeaultYamlConfig.psServiceConfigMAC> macAddressen = new HashMap<>();
        psDeaultYamlConfig.psServiceConfigMAC macData = new psDeaultYamlConfig.psServiceConfigMAC();
        
        macData.setMac("00-00-00-00-00-00-00");
        macData.setName("test");
        macAddressen.put(macAddressen.size(), macData);
        
        macData = new psDeaultYamlConfig.psServiceConfigMAC();
        macData.setMac("00-00-00-00-00-00-01");
        macData.setName("test1");
        macAddressen.put(macAddressen.size(), macData);

        data2.setMacAddressen(macAddressen);

        //### File ###
        File yamalFile2 = new File(jarDir,"configTest.yml");
        System.out.println("Load Config  DIR: "+jarDir.getAbsolutePath());
        System.out.println("Load Config FILE: "+yamalFile2.getAbsolutePath());

        if (yamalFile2.exists()){
            try {
                data2 = (psDeaultYamlConfig) loadYAMAL(yamalFile2, psDeaultYamlConfig.class, options);
            } catch (ChaosTools.ImportException ex) {
                ex.printStackTrace();
            }
        }else{
            try {
                writeYAMAL(yamalFile2, data2, options);
            } catch (ChaosTools.AndrolibException ex) {
                ex.printStackTrace();
            }
        }
        
        System.out.println( "###" );
        System.out.println( yaml.dump( data2 ));
        System.out.println( "###  "+data2.getMacAddressen().size() );
        //System.out.println( "###  "+data2.getMacAddressen().get(0).getMac() );
        data2.getMacAddressen().forEach((nr, dat) -> {
            System.out.println( "###"+nr+">"+dat.getMac()+" "+dat.getName() );
        });
        System.out.println(data2.toString());

        //###############
        //### Ver III ###
        //###############

        //### Manuelle Daten ###
        MultieYamlConfig data3 = new MultieYamlConfig();
        MultieConfig multieConfig = new MultieConfig();
        List<Long> adminList = new ArrayList<>();
        List<MultieConfigComando> comanos = new ArrayList<>();
        MultieConfigComando comando = new MultieConfigComando();
        
        data3.setAuthor("noci");
        data3.setDebug(true);
        //data3.setDebug(3);
        data3.setVersion("0.0.0");
        
        adminList.add(1000000L);
        adminList.add(2000000L);
        
        multieConfig.setAdminList(adminList);
        multieConfig.setPlayerUID(2801L);
        multieConfig.setUserMax(25);
        
        data3.setMultieConfig(multieConfig);
        
        comando.setComando("list");
        comando.setDebugLv(0);
        comando.setMsgDebug("LISTE - Run");
        Map<String, String> message=new HashMap<>();
        message.put("de", "Liste anzeigen");
        message.put("en", "show List");
        comando.setMessage(message);
        
        comanos.add(comando);
        data3.setComanos(comanos);
        
        //### File ###
        File yamalFile3 = new File(jarDir,"configTestPlugin.yml");
        System.out.println("Load Config  DIR: "+jarDir.getAbsolutePath());
        System.out.println("Load Config FILE: "+yamalFile3.getAbsolutePath());

        if (yamalFile3.exists()){
            try {
                data3 = (MultieYamlConfig) loadYAMAL(yamalFile3, MultieYamlConfig.class, options);
            } catch (ChaosTools.ImportException ex) {
                ex.printStackTrace();
            }
        }else{
            try {
                writeYAMAL(yamalFile3, data3, options);
            } catch (ChaosTools.AndrolibException ex) {
                ex.printStackTrace();
            }
        }
        
        System.out.println( "###" );
        System.out.println( yaml.dump( data3 ));
    }

}