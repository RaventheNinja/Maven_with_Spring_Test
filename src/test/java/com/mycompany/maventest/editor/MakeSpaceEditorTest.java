package com.mycompany.maventest.editor;

import de.szut.ita13.cs.mavenwithspringtest.editor.MakeSpaceEditor;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

/**
 * MakeSpaceEditorTest ist eine Klasse die einen JUnit Test ausführt für die Klasse MakeSpaceEditor.
 * 
 * @author Christian Stiefel
 * @version 1.0 Java 1.8
 */
public class MakeSpaceEditorTest {
    
    /** Das Attribut mse ist vom Typ MakeSpaceEditor. */
    private MakeSpaceEditor mse;
    
    /**
     * In der Methode setup wird bevor die Tests durchgeführt werden eine Instanz von MakeSpaceEditor instanziert.
     */
    @Before
    public void setup() {
        mse = new MakeSpaceEditor();
    }
    
    /**
     * Der Test überprüft ob bei 2 Leerzeichen der String trotzallem nur die Leerzeichen zwischen den Chars hat.
     */
    @Test
    public void testWithEmpty() {
        assertEquals("T e s t", mse.edit("Te st "));
    }
    
    /**
     * Der Test überprüft ob bei einem normalen Text der fertige String Leerzeichen zwischen den Chars hat.
     */
    @Test
    public void testSample(){
        assertEquals("T e s t", mse.edit("Test"));
    }
    
    /**
     * Der Test überprüft ob bei einem leeren String auch nur ein leerer String zurück kommt.
     */
    @Test
    public void testEmpty(){
        assertEquals("", mse.edit(""));
    }
    
    /**
     * Der Test überprüft ob bei null auch null zurück kommt.
     */
    @Test
    public void testNull(){
        assertNull(mse.edit(null));
    }
}
