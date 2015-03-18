package com.mycompany.maventest.util;

import de.szut.ita13.cs.mavenwithspringtest.util.Helper;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * HelperTest ist eine Klasse die einen JUnit Test ausführt für die Klasse Helper.
 * 
 * @author Christian Stiefel
 * @version 1.0 Java 1.8
 */
public class HelperTest {
    
    /**
     * Der Test überprüft ob bei einem klein geschriebenen Text, setBeispiel zurückgegeben wird.
     */
    @Test
    public void testSample (){
        assertEquals("setTest", Helper.methodify("test"));
    }
    
    /**
     * Der Test überprüft ob bei einem groß geschriebenen Text, setBeispiel zurückgegeben wird.
     */
    @Test
    public void testWithBigLetters (){
        assertEquals("setTest", Helper.methodify("TEST"));
    }
    
    /**
     * Der Test überprüft ob bei einem groß und klein geschriebenen Text, setBeispiel zurückgegeben wird.
     */
    @Test
    public void testWithOneBigLetters (){
        assertEquals("setTest", Helper.methodify("teSt"));
    }
    
    /**
     * Der Test überprüft ob bei einem leeren String, leerer String zurückgegeben wird.
     */
    @Test
    public void testWithNothing (){
        assertEquals("", Helper.methodify(""));
    }
    
    /**
     * Der Test überprüft ob bei null, null auch zurückgegeben wird.
     */
    @Test
    public void testWithNull (){
        assertNull(Helper.methodify(null));
    }
}
