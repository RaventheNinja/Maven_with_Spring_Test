package de.szut.ita13.cs.mavenwithspringtest.editor;

/**
 * MakeSpaceEditor implementiert das Interface Editor und ist dazu da, die
 * Daten für die Konsolenausgabe zu editieren. 
 * MakeSpaceEditor bearbeitet den String so,
 * dass zwischen allen Chars ein Leerzeichen steht.
 * 
 * @author Christian Stiefel
 * @version 1.0 Java 1.8
 */
public class MakeSpaceEditor implements Editor{
    
    /**
     * Die Methode edit verändert alle Chars im String so, 
     * dass zwischen alles Chars ein Leerzeichen steht.
     * 
     * @param text Ist der Text der verändert werden soll.
     * @return Gibt den String zurück der bearbeitet wurde.
     */
    @Override
    public String edit(final String text) {
       if (text == null){
            return text;
        } else {
            // Als erstes werden alle Leerzeichen durch keinen Abstand ersetzt. 
            final String tmp = text.replace(" ", ""); 
            final String[] tmpArray = tmp.split("");
            final StringBuilder sb = new StringBuilder();
            for (int i = 0; i < tmpArray.length; i++) {
                sb.append(tmpArray[i]).append(" ");
            }
        // Damit am Anfang und Ende des Strings keine Leerzeichen mehr vorhanden sind.
        return sb.toString().trim();
       }
    }
    
}
