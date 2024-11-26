

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package principal;
import  Controlador.Restaurante;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import restaurante.poo.Atendente;
import restaurante.poo.Constantes;
import restaurante.poo.Cozinheiro;
import restaurante.poo.Garcom;
import restaurante.poo.Gerador;
import restaurante.poo.Gerente;
import restaurante.poo.Output.OutputFactory;
import restaurante.poo.Output.OutputInterface;

/**
 *
 * @author rodri
 */
public class Principal2 {
    static String tipoOutput = "console";
    static OutputInterface output = OutputFactory.getInstance().getTipoOutput(tipoOutput);
    static Restaurante restaurante = new Restaurante("Restaurante FCT", OutputFactory.getInstance(), tipoOutput, 30, "Menu Normal", "Menu pensado para as operações cotidianas do Restaurante FCT", "11:00 - 14:00 e 17:00 - 22:00");
    static Atendente atendente = new Atendente(Constantes.SALARIO_MINIMO, Gerador.geradorAleatorioNome(), "oqequwqioe@email.com",  restaurante, output);
    static Cozinheiro cozinheiro = new Cozinheiro("Cozinheiro", Constantes.SALARIO_MINIMO, Gerador.geradorAleatorioNome(), "uqywiweyquiwiueq@email.com", output, tipoOutput);
    static Garcom garcom = new Garcom(Gerador.geradorAleatorioNome(), "qhejyqgtyeqtyugw@email.com", "Garcom1", Constantes.SALARIO_MINIMO, 10, output);
    static Gerente gerente = new Gerente(Constantes.SALARIO_MINIMO*2, Gerador.geradorAleatorioNome(), "ujquiqweyuqguyeq@email.com", output);
    static Scanner sc = new Scanner(System.in);
    
    /**
     * @Brief: Exibe o menu principal e executa as opções escolhidas pelo usuário
     */
    public static void menuPrincipal() {
        int opc = 0;
        restaurante.adicionarObserver(atendente);

        output.display("=================== MENU PRINCIPAL ========================");
        output.display("Selecione sua opção: ");
        //output.display("1 - Cadastrar Cliente"); //Desnecessário, pois agora toda vez que uma pessoa entra na fila a cada 30 segundos, o atendente cria o cliente
        output.display("1 - Cadastrar Reserva");
        output.display("2 - Verificar Disponibilidade");
        output.display("3 - Cancelar Reserva");
        output.display("4 - Cadastrar Reserva Clientes Fila");
        output.display("5 - Cadastrar Mesa");
        output.display("6 - Remover Mesa");
        output.display("7 - Exibir Mesas");
        output.display("8 - Imprimir Menu");
        output.display("9 - Cadastrar ItemMenu");
        output.display("10 - Remover ItemMenu");
        output.display("11 - Cadastrar Pedido");
        output.display("12 - Cadastrar Garçom");
        output.display("13 - Pagar");
        opc = sc.nextInt();
        sc.nextLine();

        switch (opc) {
            case 1:
                cadastrarReserva();
                break;
            case 2:
                verificarDisponibilidade();
                break;
            case 3:
                cancelarReserva();
                break;
            case 4:
                cadastrarReservaClientesFila();
                break;
            case 5:
                cadastrarMesa();
                break;
            case 6:
                removerMesa();
                break;
            case 7:
                exibirMesas();
                break;
            case 8:
                imprimirMenu();
            break;
            case 9:
                cadastrarItemMenu();
            break;
            case 10:
                removerItemMenu();
            break;
            case 11:
                cadastrarPedido();
            break;
            case 12:
                cadastrarGarcom();
            break;
            case 13:
                pagar();
            break;
            default:
                output.display("Opção invalida");
                menuPrincipal();
                break;
        }
    }
    
    /**
     * @Brief: Realiza o cadastro de uma reserva
     */
    public static void cadastrarReserva() {
        output.display("Data da Reserva (formato: yyyy-MM-dd): ");
        String dataInput = sc.nextLine(); 

        output.display("Horário (formato: HH:mm): ");
        String horarioInput = sc.nextLine(); 

        output.display("Nome do Cliente: ");
        String nomeCliente = sc.nextLine(); 
        
        output.display("Quantidade de Pessoas: ");
        int quantidadePessoas = sc.nextInt();
        
        LocalDate data = LocalDate.parse(dataInput); 
        LocalTime horario = LocalTime.parse(horarioInput);
        
        restaurante.cadastrarReserva(data, horario, nomeCliente, quantidadePessoas);
    }
    
    /**
     * @Brief: Verifica a disponibilidade de mesas no restaurante
     */
    public static void verificarDisponibilidade(){
        output.display("Data (formato: yyyy-MM-dd): ");
        String dataInput = sc.nextLine(); 

        output.display("Horário (formato: HH:mm): ");
        String horarioInput = sc.nextLine();
        
        output.display("Quantidade máxima da mesa: ");
        int maximoMesas = sc.nextInt();
        
        LocalDate data = LocalDate.parse(dataInput); 
        LocalTime horario = LocalTime.parse(horarioInput);
        
       restaurante.verificarDisponibilidade(maximoMesas, data, horario);
    }
    
    /**
     * @Brief: Cancela uma reserva existente
     */
    public static void cancelarReserva(){
        output.display("Data da Reserva (formato: yyyy-MM-dd): ");
        String dataInput = sc.nextLine(); 

        output.display("Horário (formato: HH:mm): ");
        String horarioInput = sc.nextLine(); 

        output.display("Nome do Cliente: ");
        String nomeCliente = sc.nextLine(); 
        
        output.display("Quantidade de Pessoas: ");
        int quantidadePessoas = sc.nextInt();
        
        LocalDate data = LocalDate.parse(dataInput); 
        LocalTime horario = LocalTime.parse(horarioInput);
        
        restaurante.cancelarReservaMesa(data, horario, nomeCliente, quantidadePessoas);
    }
    
    /**
     * @Brief: Exibe todas os clientes na fila do restaurante
     */
    public static void exibirClientesFila(){
        restaurante.exibirClientesFila();
    }
    
    /**
     * @Brief: Cadastra reserva para os clientes na fila do restaurante
     */
    public static void cadastrarReservaClientesFila(){
        exibirClientesFila();
        output.display("Nome Cliente");
        String nomeCliente = sc.nextLine();

        output.display("Horário (formato: HH:mm): ");
        String horarioInput = sc.nextLine(); 

        output.display("Quantidade de Pessoas: ");
        int quantidadePessoas = sc.nextInt();

        LocalTime horario = LocalTime.parse(horarioInput);

        restaurante.cadastrarReservaClienteFila(LocalDate.now(), horario, nomeCliente, quantidadePessoas);
    }

    /**
     * @Brief: Cadastra uma nova mesa no restaurante
     */
    public static void cadastrarMesa() {
        output.display("Número da mesa: ");
        String numeroMesa = sc.nextLine();

        output.display("Capacidade: ");
        int capacidade = sc.nextInt();

        restaurante.adicionarMesa(numeroMesa, capacidade);
    }
   
    /**
     * @Brief: Remove uma mesa existente no restaurante
     */
    public static void removerMesa() {
        output.display("Número da mesa: ");
        String numeroMesa = sc.nextLine();

        restaurante.removerMesa(numeroMesa);
    }
    
    /**
     * @Brief: Exibe todas as mesas cadastradas no restaurante
     */
    public static void exibirMesas(){
        restaurante.exibirMesas();
    }

    /**
     * @Brief: Exibe o menu de itens disponíveis no restaurante
     */
    public static void imprimirMenu() {
        output.display("Menu: ");
        restaurante.exibirMenu();
    }

    /**
     * @Brief: Cadastra um novo item no menu do restaurante
     */
    public static void cadastrarItemMenu() {
        output.display("Nome: ");
        String nomeItem = sc.nextLine();

        output.display("Descrição: ");
        String descricaoItem = sc.nextLine();

        output.display("Preço: ");
        double preco = sc.nextDouble();

        restaurante.adicionarItemMenu(nomeItem, descricaoItem, preco);
    }

    /**
     * @Brief: Remove um item do menu do restaurante
     */
    public static void removerItemMenu() {
        output.display("Nome: ");
        String nomeItem = sc.nextLine();

        output.display("Preço: ");
        double preco = sc.nextDouble();

        restaurante.removerItemMenu(nomeItem, preco);
    }

    /**
     * @Brief: Cadastra um novo pedido associado a uma mesa
     */
    public static void cadastrarPedido() {
        output.display("Numero da mesa: ");
        String numeroMesa = sc.nextLine();
       
        restaurante.adicionarPedido(numeroMesa);
    }
   
    /**
     * @Brief: Cadastra um novo garçom no restaurante
     */
    public static void cadastrarGarcom(){
        output.display("Nome: ");
        String nome = sc.nextLine();
       
        output.display("Email: ");
        String email = sc.nextLine();
       
        output.display("Registro do Garçom: ");
        String registroGarcom = sc.nextLine();
       
        output.display("Salario base: ");
        double salarioBaseGarcom = sc.nextInt();
       
        output.display("Gorjeta: ");
        double gorjetaGarcom = sc.nextInt();

        restaurante.adicionarGarcom(nome, email, registroGarcom, salarioBaseGarcom, gorjetaGarcom);
    }
   
    /**
     * @Brief: Realiza o pagamento associado a uma mesa
     */
    public static void pagar(){
        output.display("Numero da mesa: ");
        String numeroMesa = sc.nextLine();
        
        restaurante.pagar(numeroMesa);
    }
    
    /**
     * @Brief: Método principal que inicializa o sistema do restaurante
     */
    public static void main(String[] args) {
        restaurante.adicionarMesa("1", 6);
        restaurante.adicionarMesa("2", 10);
        restaurante.adicionarItemMenu("Feijoada", "Feijão preto com derivados de porco", 10);
        restaurante.adicionarItemMenu("Lasanha", "Massa de farinha com molho de tomate, carne moída, presunto e queijo assados", 10);
        while (true) {
            menuPrincipal();
        }
    }
    
}
