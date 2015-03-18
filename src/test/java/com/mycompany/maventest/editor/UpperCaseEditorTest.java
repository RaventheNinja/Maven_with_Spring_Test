package com.mycompany.maventest.editor;

import de.szut.ita13.cs.mavenwithspringtest.editor.UpperCaseEditor;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

/**
 * UpperCaseEditorTest ist eine Klasse die einen JUnit Test ausführt für die Klasse UpperCaseEditor.
 * 
 * @author Christian Stiefel
 * @version 1.0 Java 1.8
 */
public class UpperCaseEditorTest {
    
    /** Das Attribut use ist vom Typ UpperCaseEditor. */
    private UpperCaseEditor uce;
    
    /**
     * In der Methode setup wird bevor die Tests durchgeführt werden eine Instanz von UpperCaseEditor instanziert.
     */
    @Before
    public void setup(){
        uce = new UpperCaseEditor();
    }
    
    /**
     * Der Test überprüft ob bei einem normalen Text, der zurückgegebene Text komplett groß geschrieben ist.
     */
    @Test
    public void testSample(){
        assertEquals("TEST", uce.edit("Test"));
    }
    
    /**
     * Der Test überprüft ob bei einem leeren String, ein leerer String zurückgegeben wird.
     */
    @Test
    public void testEmpty(){
        assertEquals("", uce.edit(""));
    }
    
    /**
     * Der Test überprüft ob bei einem String mit Leerzeichen, ein String mit Leerzeichen zurückgegeben wird.
     */
    @Test
    public void testEmpty2(){
        assertEquals(" ", uce.edit(" "));
    }
    
    /**
     * Der Test überprüft ob bei null, null zurückgegeben wird.
     */
    @Test
    public void testNull(){
        assertNull(uce.edit(null));
    }
}
