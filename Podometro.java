/**
 * La clase modela un sencillo pod�metro que registra informaci�n
 * acerca de los pasos, distancia, ..... que una persona
 * ha dado en una semana. 
 * 
 * @author  Javier Mayor 
 */
public class Podometro {
    
    private final char HOMBRE = 'H';
    private final char MUJER = 'M';
    private final double ZANCADA_HOMBRE = 0.45;
    private final double ZANCADA_MUJER = 0.41;
    private final int SABADO = 6;
    private final int DOMINGO = 7;
    
    private String marca;
    private double altura;
    private char sexo;
    private double longitudZancada;
    private int totalPasosLaborales;
    private int totalPasosSabado;
    private int totalPasosDomingo;
    private double totalDistanciaSemana;
    private double totalDistanciaFinSemana;
    private int tiempo;
    private int caminatasNoche;
    
    
    /**
     * Inicializa el pod�metro con la marca indicada por el par�metro.
     * El resto de atributos se ponen a 0 y el sexo, por defecto, es mujer
     */
    public Podometro(String queMarca) {
        marca = queMarca;
        altura = 0;
        sexo = MUJER;
        longitudZancada = 0;
        totalPasosLaborales = 0;
        totalPasosSabado = 0;
        totalPasosDomingo = 0;
        totalDistanciaSemana = 0;
        totalDistanciaFinSemana = 0;
        tiempo = 0;
        caminatasNoche = 0;
        
        
        
    }

    /**
     * accesor para la marca
     *  
     */
    public  String    getMarca() {

         return marca;

    }

    /**
     * Simula la configuraci�n del pod�metro.
     * Recibe como par�metros la altura y el sexo de una persona
     * y asigna estos valores a los atributos correspondiente.
     * Asigna adem�s el valor adecuado al atributo longitudZancada
     * 
     * (leer enunciado)
     *  
     */
    public void configurar(double queAltura, char queSexo) {

        altura = queAltura ;
        sexo = queSexo;
        if(sexo == HOMBRE){
            longitudZancada = Math.ceil(altura * ZANCADA_HOMBRE);
        }
        else {
            longitudZancada = Math.floor(altura * ZANCADA_MUJER);
        }
        
    }

     /**
     *  Recibe cuatro par�metros que supondremos correctos:
     *    pasos - el n� de pasos caminados
     *    dia - n� de d�a de la semana en que se ha hecho la caminata 
     *              (1 - Lunes, 2 - Martes - .... - 6 - S�bado, 7 - Domingo)
     *    horaInicio � hora de inicio de la caminata
     *    horaFin � hora de fin de la caminata
     *    
     *    A partir de estos par�metros el m�todo debe realizar ciertos c�lculos
     *    y  actualizar� el pod�metro adecuadamente  
     *   
     *   (leer enunciado del ejercicio)
     */
    public void registrarCaminata(int pasos, int dia, int horaInicio,
                            int horaFin) {

        tiempo += horaFin - horaInicio;
        
     
        
        switch(dia){
            case 1:
            case 2:
            case 3:
            case 4:
            case 5: 
                totalPasosLaborales += pasos; 
                break;
            case 6: 
                totalPasosSabado += pasos; 
                break;
            case 7: 
                totalPasosDomingo += pasos; 
                break;
        
        }
        totalDistanciaSemana = (totalPasosLaborales + totalPasosSabado +totalPasosDomingo ) * longitudZancada ;
        totalDistanciaFinSemana = (totalPasosSabado + totalPasosDomingo) * longitudZancada;

        
        if(horaInicio >= 2100){
            caminatasNoche++;
        }

    }
    
     /**
     * Muestra en pantalla la configuraci�n del pod�metro
     * (altura, sexo y longitud de la zancada)
     * 
     * (ver enunciado)
     *  
     */
    public void printConfiguracion() {
        System.out.println(
        "Configuracion del podometro\n************************\nAltura: " +
         altura/100 + "mtos\nSexo: " + sexo + "\nLongitud zancada: " + 
         longitudZancada/100 + "mtos");
        

    }

    /**
     * Muestra en pantalla informaci�n acerca de la distancia recorrida,
     * pasos, tiempo total caminado, ....
     * 
     * (leer enunciado)
     *  
     */
    public void printEstad�sticas() {
     
          System.out.println(
        "\nEstadisticas\n************************\n\nDistania recorrida toda la semana: " 
        + totalDistanciaSemana/100000 + "Km\nDistancia recorrida fin de semana: " 
        + totalDistanciaFinSemana/100000 + "Km\n\nN� pasos dias laborales: " + 
        totalPasosLaborales + "\nN� pasos SABADO: " + totalPasosSabado + "\nN� pasos DOMINGO: " + 
        totalPasosDomingo + "\n\nN� caminatas realizadas a partir de las 21h: " + 
        caminatasNoche + "\n\nTiempo total caminado en la semana: " + 
        tiempo/60 + "h " + tiempo % 60 + "m" );

    }

   

    /**
     *  Calcula y devuelve un String que representa el nombre del d�a
     *  en el que se ha caminado m�s pasos - "S�BADO"   "DOMINGO" o  "LABORABLES"
     */
    public String diaMayorNumeroPasos() {

            String str = "";
        if(totalPasosLaborales > totalPasosSabado && 
        totalPasosLaborales > totalPasosDomingo ){
            str = "LABORABLES";
        }
        else if(totalPasosLaborales < totalPasosSabado && 
        totalPasosSabado > totalPasosDomingo ){
            str = "SABADO";
        }
        else if (totalPasosDomingo > totalPasosSabado && 
        totalPasosDomingo > totalPasosLaborales){
            str = "DOMINGO";
        }
        else if((totalPasosLaborales == totalPasosSabado ) &&
        (totalPasosLaborales > totalPasosDomingo)){
            return "LABORALES  SABADO";
        }
        else if((totalPasosLaborales == totalPasosDomingo) &&
        (totalPasosLaborales > totalPasosSabado)){
            return "LABORALES  DOMINGO";
        }else if((totalPasosDomingo == totalPasosLaborales) &&
        (totalPasosDomingo == totalPasosSabado)){
            return "LABORALES  SABADO  DOMINGO";
        }else{
            return "SABADO DOMINGO";
        }
        
        return str;

    }
    
    
    /**
     * Restablecer los valores iniciales del pod�metro
     * Todos los atributos se ponen a cero salvo el sexo
     * que se establece a MUJER. La marca no var�a
     *  
     */    
    public void reset() {
        altura = 0;
        sexo = MUJER;
        longitudZancada = 0;
        totalPasosLaborales = 0;
        totalPasosSabado = 0;
        totalPasosDomingo = 0;
        totalDistanciaSemana = 0;
        totalDistanciaFinSemana = 0;
        tiempo = 0;
        caminatasNoche = 0;
        

    }

}
