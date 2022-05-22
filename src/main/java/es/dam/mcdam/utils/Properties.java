package es.dam.mcdam.utils;

import java.io.File;

public class Properties {
    //Base de datos
    private static final String APP_PATH = System.getProperty("user.dir");

    public static final String DB_DIR = APP_PATH + File.separator + "db";
    public static final String DB_FILE = DB_DIR + File.separator + "mcdamsql.sql";

    //Datos
    public static final String DATA_DIR = APP_PATH + File.separator + "data";
    public static final String BACKUP_DIR = DATA_DIR + File.separator + "backup";

    public static final String BACKUP_FILE = BACKUP_DIR + File.separator + "agenda.bak";
    public static final String IMAGES_DIR = DATA_DIR + File.separator + "images";

    //General
    public static final String APP_TITLE = "MCDAM";
    public static final String APP_ICON = "icons/logo.ico";
    public static final int APP_WIDTH = 600;
    public static final int APP_HEIGHT = 400;


    //Splash
    public static final int SPLASH_HEIGHT = 400;
    public static final int SPLASH_WIDTH = 600;


    //Menu Cliente
    public static final int MENUCLIENTE_HEIGHT = 616;
    public static final int MENUCLIENTE_WIDTH = 845;

    //Menu Administrador
    public static final int MENUADMIN_HEIGHT = 400;
    public static final int MENUADMIN_WIDTH = 600;

    //Menu Registro
    public static final int MENUREG_HEIGHT = 400;
    public static final int MENUREG_WIDTH = 600;

    //Menu Login
    public static final int MENULOG_HEIGHT = 400;
    public static final int MENULOG_WIDTH = 600;

    //Menu proceso de pago
    public static final int PROCESOPAGO_HEIGHT = 400;
    public static final int PROCESOPAGO_WIDTH = 600;

    //Menu de consulta administrador
    public static final int CONSULTAADMINISTRADOR_HEIGHT = 400;
    public static final int CONSULTAADMINISTRADOR_WIDTH = 600;

    //Menu edicion administrador
    public static final int EDICIONADMINISTRADOR_HEIGHT = 400;
    public static final int EDICIONADMINISTRADOR_WIDTH = 600;

    //Menu actualizar producto
    public static final int ACTUALIZARPRODUCTO_HEIGHT = 400;
    public static final int ACTUALIZARPRODUCTO_WIDTH = 600;

    //Menu actualizar codigo descuento
    public static final int ACTUALIZARCODIGO_HEIGHT = 400;
    public static final int ACTUALIZARCODIGO_WIDTH = 600;

    //Acerca de
    public static final String APP_LOGO = "images/logo.png";
    public static final String APP_VERSION = "1.0";
    public static final String APP_AUTHOR = "· Alejandro Sánchez Monzón \n"
                                            + "· Mireya Sánchez Pinzón \n"
                                            + "· Ainhoa Bermejo Esteban \n"
                                            + "· Rubén García-Redondo Marín \n"
                                            + "· Sergio Pérez Fernández";
    public static final String ACERCADE_LINK = "https://github.com/Mireyasanche/McDAM";
    public static final int ACERCADE_HEIGHT = 400;
    public static final int ACERCADE_WIDTH = 600;

    //Controlador administrador
    public static final String USER_DEFAULT = "icons/comeraqui.png";
    public static final String PEDIDO_DEFAULT = "icons/parallevar.png";
    public static final String CODIGODESCUENTO_DEFAULT = "icons/propina.png";



}
