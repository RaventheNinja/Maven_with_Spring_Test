package de.szut.ita13.cs.mavenwithspringtest.database;

/**
 * Ein Interface welches das Tabellenmodell als Objekt darstellen soll.
 * @author Christian Stiefel
 * @version 1.0 Java 1.8
 */
public interface TableObject {
    
    /**
     * Lässt einen StringBuilder die Datensätze im Objekt zusammenfügen.
     * @param sb Ist ein StringBuilder der die jeweilgen Datensätze im Objekt als "String" zusammenfügt.
     */
    public void output (StringBuilder sb);
}
