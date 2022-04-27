import javax.swing.JOptionPane;


public class Main {

    public static void main(String[] args) {

        String input;
        boolean exit = false;

        do {
        input = JOptionPane.showInputDialog(menu());
        try {
            switch(menu()) {
                case "1":
                    Util.reservarMesa();
                    break;
                case "2":
                    Util.pesquisarReserva();
                    break;
                case "3":
                    Util.imprimirReservas();
                    break;
                case "4":
                    Util.imprimirListaEspera();
                    break;
                case "5":
                    Util.cancelarReserva();
                    break;
                case "6":
                    exit = true;
                    break;
                default:
                JOptionPane.showMessageDialog(null,"Comando inválido! \nPor favor digite um numero entre 1 e 6");
                throw new UnsupportedOperationException();
            }
            
                }  catch (UnsupportedOperationException e) {
                        e.printStackTrace();
                }

        }while (input != "6");

    }

    public static String menu(){
        String aux = "Restaurante SABOR SOFISTICADO";
            aux += "\n1.Reservar mesa";
            aux += "\n2.Pesquisar reserva";
            aux += "\n3.Imprimir reservas";
            aux += "\n4.Imprimir lista de espera";
            aux += "\n5.Cancelar reserva";
            aux += "\n6.Finalizar";
    return aux;    
    }


         }
     