package de.szut.ita13.cs.mavenwithspringtest;

import de.szut.ita13.cs.mavenwithspringtest.database.ExampleTable;
import de.szut.ita13.cs.mavenwithspringtest.output.Output;
import de.szut.ita13.cs.mavenwithspringtest.datasource.DataSource;
import de.szut.ita13.cs.mavenwithspringtest.editor.Editor;
import de.szut.ita13.cs.mavenwithspringtest.loader.SimpleLoader;
import de.szut.ita13.cs.mavenwithspringtest.query.Query;
import de.szut.ita13.cs.mavenwithspringtest.query.QueryConfiguration;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Die Klasse HelloWorld enthält die Main Methode womit weitere Klassen aufgerufen werden. 
 * Zusätzlich ist es möglich eine SQL Query einzugeben bei getData sowie eine spezifische Klasse die extra für die bestimmte Tabelle zugeordnet ist.
 * 
 * @author Christian Stiefel
 * @version 1.0 Java 1.8
 */

/**
 * Die Klasse App enthält die Main Methode womit weitere Klassen aufgerufen werden.Zusätzlich ist es möglich eine SQL Query einzugeben bei getData sowie eine spezifische Klasse die extra für die bestimmte Tabelle zugeordnet ist.
 * @author Christian Stiefel
 * @version 1.0 Java 1.8
 */
public class App {
    
    public static final transient Logger LOG = Logger.getLogger(App.class);
    /**
     * Die Main Methode um die die speziellen Methoden aufzurufen die angefragt werden.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        Date date = null;
        SimpleDateFormat df = new SimpleDateFormat ("yyyy-MM-dd");
        try {
            date = df.parse("1808-12-25");
        } catch (ParseException ex) {
            LOG.debug(ex);
        }
       
        SimpleLoader sl = (SimpleLoader) context.getBean("simpleLoader");
        //sl.load(); // Instansziert die gefragten Klassen dynamisch
        Editor et = sl.getEditorClass(); // Fragt welche spezielle Editor Klasse et sein soll.
        Output op = sl.getOutputClass();
        DataSource ds = sl.getDataSourceClass();
        Query q = new Query(ExampleTable.class); // Die richtige Klasse für muss immer mit angegeben werden.
        QueryConfiguration qc = (QueryConfiguration) context.getBean("queryConfiguration");
        qc.addTableName("example").addDirection("id desc"). // Zum Auswählen der Tabelle.
                addCondition("birth > ?", date);
        op.output(et.edit(ds.getData(q.list(qc, context)))); // Eine Ausgabe die durch einen Editor editiert wird.
    }
}
