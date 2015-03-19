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
 * Die Klasse HelloWorld enthält die Main Methode womit weitere Klassen
 * aufgerufen werden. Zusätzlich ist es möglich eine SQL Query einzugeben bei
 * getData sowie eine spezifische Klasse die extra für die bestimmte Tabelle
 * zugeordnet ist.
 *
 * @author Christian Stiefel
 * @version 1.0 Java 1.8
 */
/**
 * Die Klasse App enthält die Main Methode womit weitere Klassen aufgerufen
 * werden.Zusätzlich ist es möglich eine SQL Query einzugeben bei getData sowie
 * eine spezifische Klasse die extra für die bestimmte Tabelle zugeordnet ist.
 *
 * @author Christian Stiefel
 * @version 1.0 Java 1.8
 */
public class App {

    public static final transient Logger LOG = Logger.getLogger(App.class);

    @Autowired
    private BusinessObject bo;
    private String value;

    /**
     * Die Main Methode um die die speziellen Methoden aufzurufen die angefragt
     * werden.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        App app = (App) context.getBean("app");
        app.startApplication(context);

    }

    public void startApplication(ApplicationContext context) {
        SimpleLoader sl = (SimpleLoader) context.getBean("simpleLoader");
        Editor et = sl.getEditorClass(); // Fragt welche spezielle Editor Klasse et sein soll.
        Output op = sl.getOutputClass();
        DataSource ds = sl.getDataSourceClass();
        op.output(et.edit(ds.getData(bo.list("from Example where name = :code", value))));
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    
}
