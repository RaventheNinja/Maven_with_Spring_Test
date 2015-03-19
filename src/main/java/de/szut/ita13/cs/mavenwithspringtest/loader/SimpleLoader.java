package de.szut.ita13.cs.mavenwithspringtest.loader;

import de.szut.ita13.cs.mavenwithspringtest.datasource.DataSource;
import de.szut.ita13.cs.mavenwithspringtest.editor.Editor;
import de.szut.ita13.cs.mavenwithspringtest.output.Output;

/**
 * SimpleLoader ist dazu da, die Klassen dynamisch zu instantizieren.
 * 
 * @author Christian Stiefel
 * @version 1.0 Java 1.8
 */
public class SimpleLoader {
    
    /** Ein Attribut vom Typen Editor um die Klasse zurückzugeben. */
    private Editor editorClass;
    /** Ein Attribut vom Typen DataSource um die Klasse zurückzugeben. */
    private DataSource dataSourceClass;
    /** Ein Attribut vom Typen Output um die Klasse zurückzugeben. */
    private Output outputClass;
    
    /**
     * Die Methode getEditorClass gibt den Wert des Attributes wieder für die Klasse.
     * @return Enthält die Instanz der jeweiligen Klasse.
     */
    public Editor getEditorClass() {
        return editorClass;
    }
    
    /**
     * Die Methode getDataSourceClass gibt den Wert des Attributes wieder für die Klasse.
     * @return Enthält die Instanz der jeweiligen Klasse.
     */
    public DataSource getDataSourceClass() {
        return dataSourceClass;
    }

    /**
     * Die Methode getOutputClass gibt den Wert des Attributes wieder für die Klasse.
     * @return Enthält die Instanz der jeweiligen Klasse.
     */
    public Output getOutputClass() {
        return outputClass;
    }

    public void setEditorClass(Editor editorClass) {
        this.editorClass = editorClass;
    }

    public void setDataSourceClass(DataSource dataSourceClass) {
        this.dataSourceClass = dataSourceClass;
    }

    public void setOutputClass(Output outputClass) {
        this.outputClass = outputClass;
    }

    
    
    
}
