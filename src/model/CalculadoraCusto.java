package model;


public class CalculadoraCusto {

    private static final double MANUTENCAO = 2.50;
    private static final double HORAS_USO_DIA = 8.0;

    // Material
    public double calcularCustoMaterial(ProjetoImpressao projeto) {
        return projeto.getQuantidadeMaterial()
                * projeto.getMaterial().getCusto();
    }

    // Falha (10%)
    public double calcularFalha(ProjetoImpressao projeto) {
        return calcularCustoMaterial(projeto) * 0.10;
    }

    // Máquina
    public double calcularCustoMaquina(ProjetoImpressao projeto) {

        double horasTotais = 2 * 365 * HORAS_USO_DIA;

        double custoPorHora =
                projeto.getImpressora().getPreco() / horasTotais;

        return custoPorHora * projeto.getTempoImpressao();
    }

    // Energia
    public double calcularCustoEnergia(ProjetoImpressao projeto,
                                        double valorKwh) {

        double energiaKwh =
                (projeto.getImpressora().getPotencia() / 1000)
                        * projeto.getTempoImpressao();

        return energiaKwh * valorKwh;
    }

    // Mão de obra
    public double calcularCustoMaoObra(double horasTrabalho,
                                        double valorHora) {

        return horasTrabalho * valorHora;
    }

    // Manutenção
    public double calcularManutencao() {
        return MANUTENCAO;
    }

    // Custo Total
    public double calcularCustoTotal(ProjetoImpressao projeto,
                                      double valorKwh,
                                      double horasTrabalho,
                                      double valorHora) {

        return calcularCustoMaterial(projeto)
                + calcularFalha(projeto)
                + calcularCustoMaquina(projeto)
                + calcularCustoEnergia(projeto, valorKwh)
                + calcularCustoMaoObra(horasTrabalho, valorHora)
                + calcularManutencao();
    }

    // Risco
    public double aplicarRisco(double valor,
                                Risco risco) {

        switch (risco) {

            case Baixo:
                return valor;

            case Medio:
                return valor * 1.05;

            case Alto:
                return valor * 1.10;

            default:
                return valor;
        }
    }

    // Pagamento
    public double aplicarPagamento(double valor,
                                    Pagamento pagamento) {

        switch (pagamento) {

            case PIX:
                return valor * 0.95;

            case DINHEIRO:
                return valor * 0.97;

            case DEBITO:
                return valor;

            case CREDITO:
                return valor * 1.05;

            default:
                return valor;
        }
    }

    // Lucro 100%
    public double aplicarLucro(double valor) {
        return valor * 2;
    }

    // Valor Final
    public double calcularValorFinal(ProjetoImpressao projeto,
                                      double valorKwh,
                                      double horasTrabalho,
                                      double valorHora) {

        double total = calcularCustoTotal(
                projeto,
                valorKwh,
                horasTrabalho,
                valorHora
        );

        total = aplicarRisco(total, projeto.getRisco());

        total = aplicarPagamento(total,
                projeto.getTipoPagamento());

        return aplicarLucro(total);
    }
}