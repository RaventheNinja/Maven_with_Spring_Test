package de.szut.ita13.cs.mavenwithspringtest.output;

/**
 * Ein Interface welches die Ausgabe darstellt.
 * 
 * @author Christian Stiefel
 * @version 1.0 Java 1.8
 */
public interface Output {
        
    /**
     * Gibt den jeweiligen Text in der speziellen Output Klasse aus.
     * 
     * @param text Ist der finale Text der auch schon bearbeitet wurde durch einen Editor.
     */
        void output (final String text);
}
