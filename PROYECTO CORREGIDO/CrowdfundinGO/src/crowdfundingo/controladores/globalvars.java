package crowdfundingo.controladores;

import java.util.Locale;

public class globalvars {
    
    
    public static String id = "", destiny="[Carpeta de destino de las imagenes]", idproy="";
    
    //Configuración de listener
    public static String conn="jdbc:oracle:thin:@localhost:1521:orcl";
    
    //Ejemplo [usar como ultimo recurso]
    //public static String conn="jdbc:oracle:thin:@//localhost:1521/XE";
    
    public String[] getAllCountries() {
        String[] countries = new String[Locale.getISOCountries().length];
        String[] countryCodes = Locale.getISOCountries();
        for (int i = 0; i < countryCodes.length; i++) {
            Locale obj = new Locale("", countryCodes[i]);
            countries[i] = obj.getDisplayCountry();
        }
        return countries;
    }
    
}
