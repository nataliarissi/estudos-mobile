public class Produto {
    public String Nome;
    public float Preco;
    public String Descricao;
    
    public Produto(){

    }

    @Override //somente para classe
    public String toString(){
        return "Nome do produto: " + Nome + ", Preço: " + Preco + ", Descrição: " + Descricao;
    }
}
