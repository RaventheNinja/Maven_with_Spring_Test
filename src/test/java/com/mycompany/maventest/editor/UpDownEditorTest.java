package com.mycompany.maventest.editor;

import de.szut.ita13.cs.mavenwithspringtest.editor.UpDownEditor;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

/**
 * UpDownEditorTest ist eine Klasse die einen JUnit Test ausführt für die Klasse UpDownEditor.
 * 
 * @author Christian Stiefel
 * @version 1.0 Java 1.8
 */
public class UpDownEditorTest {
    
    /** Das Attribut mse ist vom Typ UpDownEditor. */
    private UpDownEditor ude;
    
    /**
     * In der Methode setup wird bevor die Tests durchgeführt werden eine Instanz von UpDownEditor instanziert.
     */
    @Before
    public void setup (){
        ude = new UpDownEditor();
    }
    
    /**
     * Der Test überprüft ob bei einem normalen Text der erste Buchstabe groß ist, der nächste klein, der nächste wieder groß usw..
     */
    @Test
    public void testSample(){
        assertEquals("TeSt", ude.edit("Test"));
    }
    
    /**
     * Der Test überprüft ob bei einem leeren String auch ein leerer String zurück kommt.
     */
    @Test
    public void testEmpty(){
        assertEquals("", ude.edit(""));
    }
    
    /**
     * Der Test überprüft ob bei einem Leerzeichen ein String mit einem Leerzeichen zurück kommt.
     */
    @Test
    public void testEmpty2(){
        assertEquals(" ", ude.edit(" "));
    }
    
    /**
     * Der Test überprüft ob bei null auch null zurück gegeben wird.
     */
    @Test
    public void testNull(){
        assertNull(ude.edit(null));
    }
}
