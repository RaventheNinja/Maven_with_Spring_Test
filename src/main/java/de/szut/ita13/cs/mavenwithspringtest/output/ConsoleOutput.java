package de.szut.ita13.cs.mavenwithspringtest.output;

/**
 * ConsoleOutput implementiert das Interface Output und ist dazu zuständig den 
 * finalen Text auszugeben per Konsole auszugeben.
 * 
 * @author Christian Stiefel
 * @version 1.0 Java 1.8
 */
public class ConsoleOutput implements Output{

    /**
     * Mit der Methode output wird der finale Text in einer Konsolenausgabe ausgegeben.
     * 
     * @param text Ist der text der auch schon von einem Editor verarbeitet wurde.
     */
    @Override
    public void output(final String text) {
        System.out.println(text);
    }
       
    
    
}
