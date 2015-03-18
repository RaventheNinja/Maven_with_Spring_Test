package de.szut.ita13.cs.mavenwithspringtest;

import de.szut.ita13.cs.mavenwithspringtest.businessobject.BusinessObject;
import de.szut.ita13.cs.mavenwithspringtest.database.Example;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @Autowired
    private BusinessObject bo;
    /**
     * Die Main Methode um die die speziellen Methoden aufzurufen die angefragt werden.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        App app =  (App) context.getBean("app");
        app.start();
        
        /*Date date = null;
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
        op.output(et.edit(ds.getData(q.list(qc, context)))); // Eine Ausgabe die durch einen Editor editiert wird.*/
    }
    public void start(){
        List<Example> example =  bo.list();
        LOG.debug("DEBUG" +example);
        System.out.println(example);
    }
}
