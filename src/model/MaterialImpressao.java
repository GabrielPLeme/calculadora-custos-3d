package model;

public class MaterialImpressao {
    private String tipoMaterial;
    private Densidade densidade;
    private double custo; // Custo por grama

    public MaterialImpressao(String tipoMaterial, Densidade densidade, double custo) {
        this.tipoMaterial = tipoMaterial;
        this.densidade = densidade;
        this.custo = custo;
    }

    public String getTipoMaterial() {
        return tipoMaterial;
    }

    public Densidade getDensidade() {
        return densidade;
    }

    public double getCusto() {
        return custo;
    }

    @Override
    public String toString() {
        return tipoMaterial + " - " + densidade;
    }

}