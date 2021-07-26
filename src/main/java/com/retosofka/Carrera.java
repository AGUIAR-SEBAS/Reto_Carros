
package com.retosofka;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Carrera {
    
    
    /*
    Lo que se busca en este juego es crear unos carros y posicionarlo en una pista (cada carro tiene un conductor),
    puede existir tantos carros como carriles, cada pista deberá tener el mismo límite de distancia (kilómetros)
    para el recorrido del carro, los carros avanzan de forma aleatoria aumentado su distancia por medio de metros
    (los kilómetros de debe convertir a metros para que el avance sea en metros).
    
    Cada avance debe existir un dado (de 1 a 6) que permite mover el carro y se debe multiplicar por 100, donde
    si se tira el dado y sacas 5 entonces debería ser 5*100 = 500 metros de recorrido.
    
    Al final debe existir un podio donde se clasifique primer, segundo y tercer ganador.
    
    */    
    
    
    public static void main (String[] args) throws InterruptedException, IOException{
   
    Scanner sc=new Scanner (System.in);
    int selecauto;
    int kilom = 0;
    int canCorredores = 0;
    String auto;
    Map<String, List<String>> bdCorredores = new HashMap<String, List<String>>();
    Map<Integer, Integer> puntacion = new HashMap<Integer, Integer>();
    Integer ganadores[] = new Integer[3];
    
    //----------- INICIO DEL JUEGO -----------//

    //Ingreso de la cantidad de personas que van a jugar
        System.out.println("Bienvenido a Need For xpeed\n" +
               "Primero, elige la configuración de tu carrera\n");
        canCorredores=Ingresar.canCorredores();
        
        //Ingreso de la cantidad de kilometros con los que se van a jugar
        kilom=Ingresar.kilom();
        
        //Le solicita unos datos para cada uno de los jugadores
        System.out.println("Con posterioridad debemos ingresar unos datos para poder diferenciarte");
        for (int i=1 ; i<=canCorredores; i++){
            List<String> datosCorredores = new ArrayList<String>();
            datosCorredores.add(Ingresar.id(i));
            datosCorredores.add(Ingresar.alias());
            datosCorredores.add(Ingresar.auto(i));
          
            bdCorredores.put(""+i,datosCorredores);
        }
        
        //---------------------------------------------------------------
          System.out.println("EMPIEZA EL JUEGO EN....");
        Thread.sleep(1000);
        System.out.println("3....");
        Thread.sleep(1000);
        System.out.println("2....");
        Thread.sleep(1000);
        System.out.println("1....");
        Thread.sleep(1000);
        System.out.println("GO!");

        //---------------------------EJECUTANDO EL JUEGO-----------------------
        
         int iterador=0;
        int seguro1frt=0;
        do{
            for (int i=1 ; i<=canCorredores ; i++){
                int tempResult=0;
                List<String> corredores = bdCorredores.get(""+i);
                if(!corredores.get(0).equals(""+ganadores[0]) && !corredores.get(0).equals(""+ganadores[1]) && !corredores.get(0).equals(""+ganadores[2])){
                    System.out.println(
                            "Juega el corredor " + corredores.get(1) + "\n"+
                            "Ingresa el numero '0' para tirar el dado");
                    sc.nextInt();
                    int resultadoDado = (int) Math.floor(Math.random()*6+1);
                    resultadoDado = resultadoDado*100;
                    System.out.println("Sacaste: "+resultadoDado+"!");
                    if(seguro1frt<canCorredores){
                        tempResult = resultadoDado;
                    }else{
                        tempResult = resultadoDado + puntacion.get(i);
                    }
                    puntacion.put(i, tempResult);
                    System.out.println("Llevas "+puntacion.get(i)+"mts! de "+kilom+"mts\n"+
                            "________________________________\n");
                    if(puntacion.get(i)>=kilom){
                        ganadores[iterador]= Integer.valueOf(corredores.get(0));
                        iterador++;
                        System.out.println(
                                "_______________________________________________________________________________\n"+
                                "!!FELICIDADES!!\n"+
                                "El jugador "+corredores.get(1)+ " quedó en la posicion "+(iterador)+"!\n" +
                                "_______________________________________________________________________________\n");
                    }
                    seguro1frt++;
                }
            }
        }while(iterador<3);
        
        
        //--------Creacion de archivo txt(Base de datos)---------
        File archivo;
        int contador = 1;

        archivo = new File (contador+"BaseDeDatosDeGanadores.txt");
        

        while(archivo.exists()){
            contador++;
            archivo = new File (contador+"BaseDeDatosDeGanadores.txt");
        }
        FileWriter fichero = new FileWriter(archivo);
        PrintWriter pw = new PrintWriter(fichero);
        System.out.println("El podium de los ganadores quedo asi! \n");
        for(int i=0 ; i < ganadores.length ; i++){
            List<String> datosCorredores = bdCorredores.get(""+ganadores[i]);
            pw.println(i+1+". con ID "+datosCorredores.get(0) + " y alias "+datosCorredores.get(1));
            System.out.println(i+1+". con ID "+datosCorredores.get(0) + " y alias "+datosCorredores.get(1));
        }
        fichero.close();
 
     
        
        
        
        
    }
}

            

     

