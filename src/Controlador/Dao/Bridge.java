/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Dao;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import java.io.File;

/**
 *
 * @author ALEJANDRO
 */
public class Bridge {
     public static String URL="files"+File.separatorChar;
    public static XStream conection;

    public static String getURL() {
        return URL;
    }

    public static void setURL(String URL) {
        Bridge.URL = URL;
    }

    
    
    public static XStream getConection() {
        if(conection==null){
            conection=new XStream(new JettisonMappedXmlDriver());
            conection.addPermission(AnyTypePermission.ANY);
        }
        return conection;
    }

    public static void setConection(XStream conection) {
        Bridge.conection = conection;
    }
}
