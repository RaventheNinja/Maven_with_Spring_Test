package de.szut.ita13.cs.mavenwithspringtest.editor;

/**
 * Ein Interface welches die Daten editiert die ausgegeben werden sollen.
 * 
 * @author Christian Stiefel
 * @version 1.0 Java 1.8
 */
public interface Editor {
    
    /**
     * Editiert den übergebenen Text.
     * @param text Enthält den Text der editiert werden soll.
     * @return gibt den editierten String zurück.
     */
    String edit(final String text);
    
}
