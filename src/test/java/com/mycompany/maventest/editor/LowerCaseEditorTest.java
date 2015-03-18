package com.mycompany.maventest.editor;

import de.szut.ita13.cs.mavenwithspringtest.editor.LowerCaseEditor;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

/**
 * LowerCaseEditorTest ist eine Klasse die einen JUnit Test ausführt für die Klasse LowerCaseEditor.
 * 
 * @author Christian Stiefel
 * @version 1.0 Java 1.8
 */
public class LowerCaseEditorTest {
    
    /** Das Attribut lcs ist vom Typ LowerCaseEditor. */
    private LowerCaseEditor lce;
    
    /**
     * In der Methode setup wird bevor die Tests durchgeführt werden eine Instanz von LowerCaseEditor instanziert.
     */
    @Before
    public void setup (){
        lce = new LowerCaseEditor();
    }
    
    /**
     * Der Test überprüft ob bei einem normal geschriebenen Text auch alles klein zurück kommt.
     */
    @Test
    public void testSample(){
        assertEquals("test", lce.edit("Test"));
    }
    
    /**
     * Der Test überprüft ob bei einem leeren String auch ein leerer String zurück kommt.
     */
    @Test
    public void testEmpty(){
        assertEquals("", lce.edit(""));
    }
    
    /**
     * Der Test überprüft ob bei einem Leerzeichen auch ein Leerzeichen zurück kommt.
     */
    @Test
    public void testEmpty2(){
        assertEquals(" ", lce.edit(" "));
    }
    
    /**
     * Der Test überprüft ob bei null auch null zurück kommt.
     */
    @Test
    public void testNull(){
        assertNull(lce.edit(null));
    }
}
