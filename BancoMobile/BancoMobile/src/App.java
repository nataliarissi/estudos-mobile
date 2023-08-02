import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        
        Produto produto = new Produto();
        Produto cenoura = new Produto();

        System.out.println("Digite o nome do produto: ");
        produto.Nome = scanner.next();
        System.out.println("Digite o preço do produto: ");
        produto.Preco = scanner.nextFloat();
        System.out.println("Digite uma descrição para o produto: ");
        produto.Descricao = scanner.next();

        System.out.println();

        System.out.println("Digite o nome do produto 2: ");
        cenoura.Nome = scanner.next();
        System.out.println("Digite o preço do produto 2: ");
        cenoura.Preco = scanner.nextFloat();
        System.out.println("Digite uma descrição para o produto 2: ");
        cenoura.Descricao = scanner.next();    

        produtos.add(produto);
        produtos.add(cenoura);

        for(int n=0; n<produtos.size(); n++){
            Produto produtoAtual = produtos.get(n);
            System.out.println(produtoAtual.toString());
        }
    }
}
