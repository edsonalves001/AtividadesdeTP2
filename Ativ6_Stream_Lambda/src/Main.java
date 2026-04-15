import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        List<Funcionario> func = new ArrayList<>();
        func.add( new Funcionario("Ronaldo","TI",4000,10));
        func.add( new Funcionario("Igor","Design",2000,1));
        func.add( new Funcionario("Edsu","TI",3500,7));
        func.add( new Funcionario("Pedro","Gastronomia",87,1));
        func.add( new Funcionario("Saltão","Moda e manicure",100,12));
        func.add( new Funcionario("Milena","Hardware",1567,1000));
        func.add( new Funcionario("Francisco","Design",3300,3));
        func.add( new Funcionario("Pelé","Futebol",1119.99,19));

        /* Exercicio 1 - Filtra quem tem salario maior que 3000 */
        System.out.println("Exercicio 1 - Filtra quem tem salario maior que 3000" + "\n");
        func.stream().filter(f->f.getSalario() > 3000).forEach(System.out::println);


        /* Exercicio 2 - Filtrar quem tem mais de 10 anos de serviço e dar um aumento de 5% */
        System.out.println( "\n" + "Exercicio 2 - Filtrar quem tem mais de 10 anos de serviço e dar um aumento de 5%" + "\n");
        func.stream().filter(f->f.getAnosDeServico() > 10).map(f-> {
            f.setSalario(f.getSalario() * 1.05);
            return f;
        }).forEach(System.out::println);


        /* Exercicio 3 - Exibir o nome em ordem alfabetica */
        System.out.println( "\n" + "Exercicio 3 - Exibir o nome em ordem alfabetica" + "\n");
        func.stream().sorted((f1,f2)->f1.getNome().
                compareTo(f2.getNome())).forEach(System.out::println);

        /* Exercicio 4 - Fazer a soma de todos os salarios da empresa */
        System.out.println( "\n" + "Exercicio 4 - Fazer a soma de todos os salarios da empresa" + "\n");
        Double SomaSalarios = func.stream().map(f->f.getSalario()).reduce(0.0,Double::sum);
        System.out.println("Soma dos salarios: " + Math.round(SomaSalarios*100.0)/100.0);

        /* Exercicio 5 - Agrupar os departamentos e fazer a media salarial com base nesses departamentos agrupados */
        System.out.println( "\n" + "Exercicio 5 - Agrupar os departamentos e fazer a media salarial com base nesses departamentos agrupados" + "\n");
        Map<String,Double> ordenado = func.stream().collect(Collectors.groupingBy(f->f.getDepartamento(),Collectors.averagingDouble(f->f.getSalario())));
        ordenado.forEach((departamento,media)->{
            System.out.println("Departamento: " + departamento + " || Média Salarial: " + Math.round(media*100.0)/100.0);
        });


        /* Desafio 1 - Usar o Stream para saber qual o funcionario com mais anos de serviço */
        System.out.println( "\n" + "Desafio 1 - Usar o Stream para saber qual o funcionario com mais anos de serviço" + "\n");
        Optional<Funcionario> MaiorTempoDeServico = func.stream().max((a,b)-> Integer.compare(a.getAnosDeServico(), b.getAnosDeServico()));
        System.out.println("O maior tempo de serviço é de: " + MaiorTempoDeServico.get().getNome() + " com " + MaiorTempoDeServico.get().getAnosDeServico() + " Anos de serviço");

        /* Desafio 2 - Usar o Lambda para formatar a saida de cada funcionario de forma personalizada */
        System.out.println( "\n" + "Desafio 2 - Usar o Lambda para formatar a saida de cada funcionario de forma personalizada" + "\n");
        func.stream().map(f-> "Nome: {" + f.getNome() + "}, Departamento: {" + f.getDepartamento() + "}, Salario: {" + Math.round(f.getSalario()*100.0)/100.0 + "}, Anos de serviço: {" + f.getAnosDeServico() + "}").forEach(System.out::println);
    }
}
