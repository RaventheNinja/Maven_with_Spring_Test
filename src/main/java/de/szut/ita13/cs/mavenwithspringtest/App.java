package de.szut.ita13.cs.mavenwithspringtest;

import de.szut.ita13.cs.mavenwithspringtest.businessobject.BusinessObject;
import de.szut.ita13.cs.mavenwithspringtest.datasource.DataSource;
import de.szut.ita13.cs.mavenwithspringtest.editor.Editor;
import de.szut.ita13.cs.mavenwithspringtest.loader.SimpleLoader;
import de.szut.ita13.cs.mavenwithspringtest.output.Output;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Die Klasse App enthält die Main Methode womit weitere Klassen aufgerufen
 * werden.
 * 
 * @author Christian Stiefel
 * @version 1.0 Java 1.8
 */
public class App {
    
    /** Logger ist ein spezieller Logger der von Maven als Plugin implementiert wurde. */ 
    public static final transient Logger LOG = Logger.getLogger(App.class);
    
    @Autowired
    /** Die Klasse BusinessObject wird von Spring von selbst aufgerufen druch die annotation Autowired. */
    private BusinessObject bo;
    
    /** Das Objekt value ist für die Query gedacht. Nach welchem Wert soll die Spalte überprüft werden. */
    private Object value;

    /**
     * Die Main Methode um die die speziellen Methoden aufzurufen die angefragt
     * werden.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Die Spring XML Datei wird injiziert. Sie enthält die beans der speziellen Klassen
        // und setzt Attribute falls nötig.
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        // Die Klasse App wird injiziert durch den ApplicationContext.
        App app = (App) context.getBean("app");
        app.startApplication(context);
    }
    
    /**
     * Diese Methode injiziert die Klassen für den Editor, die Ausgabe und welche Daten verwendet 
     * werden sollen. 
     * 
     * @param context Der ApplicationContext um SimpleLoader zu instantzieren.
     */
    public void startApplication(ApplicationContext context) {
        SimpleLoader sl = (SimpleLoader) context.getBean("simpleLoader");
        Editor et = sl.getEditorClass(); // Fragt welche spezielle Editor Klasse et sein soll.
        Output op = sl.getOutputClass();
        DataSource ds = sl.getDataSourceClass();
        // Mit HQL werden Queries übergeben.
        op.output(et.edit(ds.getData(bo.list("from Example where name = :code", value))));
    }
    
    /**
     * Für die Spring XML um den Wert des Attributs zu setzen.
     * 
     * @param value Ist der Wert für die Query.
     */
    public void setValue(String value) {
        this.value = value;
    }
}
