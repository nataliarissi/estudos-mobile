public class Computador {
    public String Nome;
    public int Clock;

    public Computador(String nome, int clock){
        Nome = nome;
        Clock = clock;
    }
    
    public Computador(){
    }

    @Override 
    public String toString(){
        return "Nome: " + Nome + ", Clock: " + Clock;
    }
}

// main

// public class App {
//     public static void main(String[] args) throws Exception {
//         Computador computador = new Computador("Luke", 1200); //objeto - instanciar

//         System.out.println(computador.toString());
//     }
// }
