package de.szut.ita13.cs.mavenwithspringtest.properties;

/**
 * DatabaseSettings implementiert das Interface Settings und lädt die database.properties.
 * Die Werte die in der Datei stehen, werden den Attributen hinzugefügt.
 * 
 * @author Christian Stiefel
 * @version 1.0 Java 1.8
 */
public class DatabaseSettings {
    
    /** Speichert die URL zu der Datenbank die benutzt werden soll. */
    private String url;
    /** Speichert den Benutzer für den Zugang zu der Datenbank. */
    private String user;
    /** Speichert das Passwort für den Zugang zu der Datenbank. */
    private String passwd;
    /** Speichert die Tabelle die genutzt werden soll. */
    private String driverClass;
    
    /**
     * Gibt das Attribut user zurück.
     * @return Enthält den Benutzer für den Zugang zur Datenbank.
     */
    public String getUser() {
        return user;
    }

    /**
     * Gibt das attribut passwd zurück.
     * @return Enthält das Passwort für den Zugang zur Datenbank.
     */
    public String getPasswd() {
        return passwd;
    }
        
    /**
     * Gibt ein zusammenbau aus der url und der database zurück. 
     * @return Enthält die vollständige URL zur Datenbank.
     */
    public String getUrl() {
        return url;
    }
    
    public String getDriverClass() {
        return driverClass;
    }

    /**
     * Setzt eine gegebene URL für das Attribut.
     * Wird jedoch nur für den JUnit Test verwendet.
     * @param url Enthält die URL zur Datenbank.
     */
        public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Setzt einen gegebenen Benutzer für das Attribut.
     * Wird jedoch nur für den JUnit Test verwendet.
     * @param user Enthält den Benutzer für die Verbindung zur Datenbank.
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Setzt ein gegebenes Passwort für das Attribut.
     * Wird jedoch nur für den JUnit Test verwendet.
     * @param passwd Enthält das Passwort für die Verbindung zur Datenbank.
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    
    /**
     * Setzt eine gegebene Datenbank für das Attribut.
     * Wird jedoch nur für den JUnit Test verwendet.
     * @param driverClass
     */
    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }
}
