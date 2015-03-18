package de.szut.ita13.cs.mavenwithspringtest.editor;

/**
 * LowerCaseEditor implementiert das Interface Editor und ist dazu da, die
 * Daten für die Konsolenausgabe zu editieren. 
 * LowerCaseEditor bearbeitet den String so,
 * dass alles im String klein geschrieben wird.
 * 
 * @author Christian Stiefel
 * @version 1.0 Java 1.8
 */
public class LowerCaseEditor implements Editor {
    
    /**
     * Die Methode edit verändert alle Chars im String so, dass alles klein geschrieben wird.
     * @param text Ist der Text der verändert werden soll.
     * @return Gibt den String zurück der bearbeitet wurde.
     */
    @Override
    public String edit(final String text) {
        if (text == null){
            return text;
        } else {
        return text.toLowerCase();
        }
    }
}
