public class Main{
        public static void main(String[] args) {

        Produto prod1 = new Produto();
        prod1.nome = "tv";
        prod1.preco = 500;
        prod1.descricao = "tv grande";

        Produto prod2 = new Produto();
        prod2.nome = "radio";
        prod2.preco = 600;
        prod2.descricao = "rádio potente";

        ArrayList<Produto> listaProdutos = ArrayList<Produto>();

        listaProdutos.add(prod1);
        listaProdutos.add(prod2);
        listaProdutos.get(n); //indice

        for(int n=0; n<listaProdutos.size(); n++){ //size tamanho de elementos que tem na lista
        Produto m = listaProdutos.get(n); 
        System.out.println(m.nome);
        System.out.println(m.preco);
        System.out.println(m.descricao);
        }
        for(int n=0; n <1000; n++){
        Produto m = new Produto();
        p.nome = "nome: " + n;
        p.preco = n;
        p.descricao = "descricao: " + n;
        listaProduto.add(m);
        }
    }
}