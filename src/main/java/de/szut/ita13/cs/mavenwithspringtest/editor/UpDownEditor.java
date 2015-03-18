package de.szut.ita13.cs.mavenwithspringtest.editor;

/**
 * UpDownEditor implementiert das Interface Editor und ist dazu da, die
 * Daten für die Konsolenausgabe zu editieren. 
 * UpDownEditor bearbeitet den String so,
 * dass nacheinander im String groß und klein geschrieben wird.
 * 
 * @author Christian Stiefel
 * @version 1.0 Java 1.8
 */
public class UpDownEditor implements Editor{
    
    /**
     * Die Methode edit verändert alle Chars im String so, dass nacheinander die Chars groß und dann klein geschrieben werden.
     * @param text Ist der Text der verändert werden soll.
     * @return Gibt den String zurück der bearbeitet wurde.
     */
    @Override
    public String edit(final String text) {
        if (text == null){
            return text;
        } else {
        final String[] tmp = text.split("");
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tmp.length; i++) {
            if (i % 2 == 0) {
                sb.append(tmp[i].toUpperCase());
            } else {
                sb.append(tmp[i].toLowerCase());
            }
        }
        return sb.toString();
        }
    }
}
