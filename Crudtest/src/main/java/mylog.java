import java.io.IOException;
import java.util.logging.*;

public class mylog extends Crudconnect {



        private static final Logger LOGGER = Logger.getLogger(Mainclass.class.getName());
        public static void main(String[] args) {

            Handler consoleHandler ;
            Handler fileHandler  ;
            try{
                //Creating consoleHandler and fileHandler
                consoleHandler = new ConsoleHandler();
                fileHandler  = new FileHandler("/Users/admin/Downloads/logsan.log");

                //Assigning handlers to LOGGER object
                LOGGER.addHandler(consoleHandler);
                LOGGER.addHandler(fileHandler);

                //Setting levels to handlers and LOGGER
                consoleHandler.setLevel(Level.ALL);
                fileHandler.setLevel(Level.ALL);
                LOGGER.setLevel(Level.ALL);

                LOGGER.config("Configuration done.");

                //Console handler removed
                LOGGER.removeHandler(consoleHandler);

                LOGGER.log(Level.FINE, "Finer logged");
            }catch(IOException exception){
                LOGGER.log(Level.SEVERE, "Error occur in FileHandler.", exception);
            }

            LOGGER.finer("Finest example on LOGGER handler completed.");

        }
    }

