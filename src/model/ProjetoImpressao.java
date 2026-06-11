package model;

public class ProjetoImpressao {
    private String nomeArquivoSTL;
    private String descricao;
    private double quantidadeMaterial;
    private double tempoImpressao;
    private MaterialImpressao material;
    private Impressora3D impressora;
    private Risco risco;
    private Pagamento tipoPagamento;

    
    public ProjetoImpressao(String nomeArquivoSTL, String descricao, double quantidadeMaterial, double tempoImpressao,
            MaterialImpressao material, Impressora3D impressora, Risco risco, Pagamento tipoPagamento) {
        this.nomeArquivoSTL = nomeArquivoSTL;
        this.descricao = descricao;
        this.quantidadeMaterial = quantidadeMaterial;
        this.tempoImpressao = tempoImpressao;
        this.material = material;
        this.impressora = impressora;
        this.risco = risco;
        this.tipoPagamento = tipoPagamento;
    }

    public String getNomeArquivoSTL() {
        return nomeArquivoSTL;
    }

    public String Descricao() {
        return descricao;
    }

    public double getQuantidadeMaterial() {
        return quantidadeMaterial;
    }

    public double getTempoImpressao() {
        return tempoImpressao;
    }

    public MaterialImpressao getMaterial() {
        return material;
    }

    public Impressora3D getImpressora() {
        return impressora;
    }

    public Risco getRisco() {
        return risco;
    }

    public Pagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(Pagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }          
}
