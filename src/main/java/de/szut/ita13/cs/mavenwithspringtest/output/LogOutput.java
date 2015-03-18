package de.szut.ita13.cs.mavenwithspringtest.output;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.log4j.Logger;

/**
 * LogOutput implementiert das Interface Output und ist dazu zuständig den 
 * finalen Text in eine log Datei zu speichern.
 * 
 * @author Christian Stiefel
 * @version 1.0 Java 1.8
 */
public class LogOutput implements Output{
    
    /** Logger ist ein spezieller Logger der von Maven als Plugin implementiert wurde. */
    private final static transient Logger LOG = Logger.getLogger(LogOutput.class);
    
    /**
     * Mit der Methode output wird der finale Text in eine log Datei gespeichert.
     * 
     * @param text Ist der text der auch schon von einem Editor verarbeitet wurde.
     */
    @Override
    public void output(String text) {
        
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter ("output.log"));
            bw.write(text);
            bw.close();
        } catch (IOException ex) {
            LOG.debug(ex);
        }
    }
    
}
