import java.util.Scanner;
import java.util.InputMismatchException;
public class reservarAsiento {
    public static Scanner teclat= new Scanner(System.in);//Para poder introducir textos/numeros
    public static int fila=0;
    public static int columna=0;
    public static void omplirSeients(char[][] seients){// Se rellenara la matriz con O para indicarle que los asientos estan libres.
        System.out.println("Seients actuals:\n------------");
        for (fila=0; fila<seients.length; fila++){
            for (columna=0; columna< seients.length; columna++) seients[fila][columna]='O';
        }
        mostrarSeients(seients);
    }
    public static void mostrarSeients(char[][] seientsMatriu){//Mostrara al usuario los asientos llibres con un O i reservados con un X-
        System.out.println("  1 2 3 4 5");
        for (fila=0; fila<seientsMatriu.length; fila++){
            System.out.print(fila+1 + " ");
            for (columna=0; columna< seientsMatriu.length; columna++)System.out.print(seientsMatriu[fila][columna]+ " ");
            System.out.println();
        }
    }
    public static void reservarCliente(){ //Para confirmar que quiere reservar lo pregunta.
        String resposta;
        System.out.println("Vols reservar seients?(Si/No)");
        resposta= teclat.next();
        if(!resposta.equalsIgnoreCase("Si")){
            System.out.println("Adeu!");
            System.exit(0);
        }
    }
    public static int demanarSeients(int seients){ //Le pedira un numero de asientos al usuario.
        System.out.println("Quants seients vols reservar?");
        do{
            try{
                teclat.nextLine();
                seients= teclat.nextInt();
                if (seients<1 || seients>25){
                    System.out.println("Introdueix un numero superior que 0:");
                }
            }catch(InputMismatchException ime){//Para que no salte el error y poder continuar el programa si el usuario introduce un caracter.
                System.out.println("Introdueix un numero, no un caracter.");
            }
        }while(seients<1 || seients>25);// Si el numero de seients es menor o igual que 0 o superior a 25
        return seients;
    }
    public static void triaSeients(char[][] seientsMatriu, int seients){
        int contador;
                for(fila=0, columna=0, contador=0; contador<seients; contador++){
                    try{
                        System.out.println("Introdueix la fila.");
                        teclat.nextLine();
                        fila=teclat.nextInt();
                        while(fila<1||fila>5){ //Si el numero es pequeño que uno o superior que 5 se le pedira otra vez.
                            System.out.println("Inserteix una fila igual o superior de 1 y igual o inferior que 5");
                            fila= teclat.nextInt();
                        }
                        System.out.println("Introdueix la columna");
                        teclat.nextLine();
                        columna=teclat.nextInt();
                        while(columna<1||columna>5){ //Si el numero es pequeño que uno o superior que 5 se le pedira otra vez.
                            System.out.println("Inserteix una columna igual o superior de 1 y igual o inferior que 5");
                            columna=teclat.nextInt();
                        }
                        seientsMatriu[fila-1][columna-1]='X';
                        mostrarSeients(seientsMatriu);
                    }catch(InputMismatchException ime){//Para que no salte el error y poder continuar el programa si el usuario introduce un caracter.
                        System.out.println("Solament es pot insertar numeros, no lletres. Inserteix un altra vegada les files i columnes.");
                        contador--;
                    }
                }
    }
    public static void main(String[] args) {
        char[][] seientsMatriu = new char[5][5];
        int seients=0;
        omplirSeients(seientsMatriu); //Para poder rellenar la matriz con O.
        reservarCliente(); //Preguntarle si quiere reservar.
        seients=demanarSeients(seients);//Pide el numero de asientos que quiere.
        triaSeients(seientsMatriu, seients);
        System.out.println("Gracies per confiar en nosaltres.");
        teclat.close();
    }
}
