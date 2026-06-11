package model;

public class Impressora3D {
    private String modelo;
    private Double preco;
    private Double potencia;
    private String caminhoImagem;
    private String descricao;

    

    public Impressora3D(String modelo, Double preco, Double potencia, String caminhoImagem, String descricao) {
        this.modelo = modelo;
        this.preco = preco;
        this.potencia = potencia;
        this.caminhoImagem = caminhoImagem;
        this.descricao = descricao;
    }

    public String getModelo() {
        return modelo;
    }

    public Double getPreco() {
        return preco;
    }

    public Double getPotencia() {
        return potencia;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public String getDescricao() {
        return descricao;
    }

    

    @Override
    public String toString(){
        return modelo;
    }
}
