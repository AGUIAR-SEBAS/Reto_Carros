package com.retosofka;

import java.util.Scanner;

public class Ingresar {

    private static Scanner sc = new Scanner(System.in);
        private static int canCorredores;
    private static int kilom;
    private static int selecauto;
    private static String auto = "";

    
    //---------------Configuracion del juego-----------------------------------
    public static int canCorredores() {
        System.out.println("¿Cuantas personas correrán? Recuerda que minimo deben ser tres corredores");
        canCorredores = sc.nextInt();
        while (canCorredores < 3) {
            System.out.println("Amigo! Recuerda que minimo deben ser tres corredores e ingresaste " + canCorredores);
            canCorredores = sc.nextInt();
        }
        return canCorredores;
    }

    public static int kilom(){
        System.out.println("En need for xpeed nos encanta correr! pero tu eliges cuanto...\n" + 
                            "Ingresa cuantos kilometros vas a recorrer");
        kilom=sc.nextInt() * 1000;
        while(kilom==0){
            System.out.println("Oye! recuerda que minimo deben de ser 1km e ingresaste "+kilom+" Km\n");
            kilom=sc.nextInt() * 1000;
            
            
        }
        return kilom;
        
    }
    
    public static String id (int i){
        System.out.println("Para el jugador numero "+i);
      
        return ""+i;         
    }
   
    
    public static String alias(){
        System.out.println("Ingresa el nombre o el alias que deseas para ti");
        return sc.next();
    }
    
   public static String auto (int i){
       System.out.println("¿Que carro deseas? escribe el numero\n"
               + "1. Bugatti Veyron\n"
               + "2. Chevrolet Corvette\n"
               + "3. Dodge Viper\n" 
               + "4. Lamborghini Countach\n" 
               + "5. Shelby Cobra\n" 
               + "6. Ferrari Testarrosa");
       selecauto=sc.nextInt();
       while (selecauto>6  || selecauto==0){
           System.out.println("Recuerda que debes de seleccionar las opciones que aparecen en la consola");
           selecauto=sc.nextInt();
           
       }
       switch (selecauto) {
           case 1:
               auto = "Bugatti Veyron"; 
               break;
               
          case 2:
                auto = "Chevrolet Corvette";
                break;
            case 3:
                auto = "Dodge Viper";
                break;
            case 4:
                auto = "Lamborghini Countach";
                break;
            case 5:
                auto = "Shelby Cobra";
                break;
            case 6:
                auto = "Ferrari Testarrosa";
                break;
            default:
                auto = "";

       }
       return auto;
   }

   //----------------EJECUTANDO EL JUEGO-------------------------
   
   

    
}


