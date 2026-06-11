import javax.xml.catalog.Catalog;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Material;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.CalculadoraCusto;
import model.Densidade;
import model.Impressora3D;
import model.MaterialImpressao;
import model.Pagamento;
import model.ProjetoImpressao;
import model.Risco;
import repositoy.CatalogoImpressoras;
import repositoy.CatalogoMateriais;

public class App extends Application {
        public static void main(String[] args) throws Exception {
                launch(args);

        }

        @Override
        public void start(Stage primaryStage) throws Exception {
                CatalogoImpressoras catalogoImpressoras = new CatalogoImpressoras();
                CatalogoMateriais catalogoMateriais = new CatalogoMateriais();

                // COLUNA DA ESQUERDA
                Label lblTitulo = new Label("PARÂMETROS DO PROJETO");
                lblTitulo.setText("PARÂMETROS DO PROJETO");

                // ComBox - pegando os modelos da impressoras - da classe impressora3D
                ComboBox<String> cbModeloImpressora = new ComboBox<>();
                Label lblSelecionado = new Label(null);
                for (Impressora3D imp : catalogoImpressoras.getImpressoras()) {
                        cbModeloImpressora.getItems().add(imp.toString());
                }
                ;
                cbModeloImpressora.setPromptText("Seleciona uma impressora");
                // Mostra oque foi selecionado
                cbModeloImpressora.setOnAction(e -> {
                        String modeloEscolhidoo = cbModeloImpressora.getValue();
                        lblSelecionado.setText("Impressora esocolhida: " + modeloEscolhidoo);
                });

                // TextField - para pegar o nome do projeto
                Label lblcampoNomeProjeto = new Label("Nome do projeto");

                TextField tfCampoNomeProjeto = new TextField();
                tfCampoNomeProjeto.setPromptText("Nome Projeto");

                tfCampoNomeProjeto.setOnAction(e -> {
                        String nomeProjeto = tfCampoNomeProjeto.getText(); // pega o nome do projeto
                        System.out.println("Nome do projeto: " + nomeProjeto); // mostra no terminal
                });

                HBox linhaNomeProjeto = new HBox(10); // 10 = espaço entre eles
                linhaNomeProjeto.getChildren().addAll(
                                lblcampoNomeProjeto,
                                tfCampoNomeProjeto);

                // TextArea - pegar a descrição do projeto
                Label lblcampoDescricao = new Label("Descrição do projeto: ");

                TextArea txtCampoDescricao = new TextArea();
                txtCampoDescricao.setPromptText("Coloca a sua descrição aqui...");
                txtCampoDescricao.setWrapText(true);
                txtCampoDescricao.setPrefSize(300, 50);

                HBox linhaDescricaoProjeto = new HBox(10);
                linhaDescricaoProjeto.getChildren().addAll(
                                lblcampoDescricao,
                                txtCampoDescricao);

                // Label para deixar a gramas
                Label lblQtdMaterial = new Label("Quantidade de material: ");
                // TextField - vai quantidade em gramas
                TextField tfQtdMaterial = new TextField();
                tfQtdMaterial.setPromptText("Ex.: 120.0");

                String textoQtdMaterial = tfQtdMaterial.getText();

                double qtdMaterial = 0;

                if (textoQtdMaterial != null && !textoQtdMaterial.isEmpty()) {
                        qtdMaterial = Double.parseDouble(textoQtdMaterial);

                }

                System.out.printf("Quantidade" + qtdMaterial); // isso aqui vamos colocar para criar o projeto

                HBox linhaQtdMaterial = new HBox(10);
                linhaQtdMaterial.getChildren().addAll(
                                lblQtdMaterial,
                                tfQtdMaterial);

                // TextField - Tempo da impressão
                Label lblTempo = new Label("Tempo de impressão: ");

                TextField tfTempo = new TextField();
                tfTempo.setPromptText("Ex.: 5 ");

                String textoTempo = tfTempo.getText();

                double tempo = 0;

                if (textoTempo != null && !textoTempo.isEmpty()) {
                        tempo = Double.parseDouble(textoTempo);
                }

                System.out.printf("\nTempo da impressão: " + tempo); // isso aqui vamos colocar para criar o projeto

                HBox linhaTempo = new HBox(10);
                linhaTempo.getChildren().addAll(
                                lblTempo,
                                tfTempo);

                // ComBox - para selecionar o tipo do material - da classe materialImpressao
                Label lblSelecionarMaterial = new Label("Tipo do material: ");

                ComboBox<String> cbMateriaisImpressao = new ComboBox<>();

                Label lblSelecionadoMaterial = new Label(null);

                // preenchendo ComboBox
                for (MaterialImpressao imp : catalogoMateriais.getMateriais()) {
                        cbMateriaisImpressao.getItems().add(imp.toString());
                }

                cbMateriaisImpressao.setPromptText("Tipo de Material");

                // evento de seleção
                cbMateriaisImpressao.setOnAction(e -> {
                        String materialEscolhido = cbMateriaisImpressao.getValue();

                        lblSelecionadoMaterial.setText("Material escolhido: " + materialEscolhido);

                        System.out.println("\nMaterial escolhido: " + materialEscolhido);
                });

                HBox linhaMaterialSelecionado = new HBox(10);
                linhaMaterialSelecionado.getChildren().addAll(
                                lblSelecionarMaterial,
                                cbMateriaisImpressao);
                // ComboBox - Risco
                Label lblcbRisco = new Label("Tipo do risco: ");
                ComboBox<Risco> cbRisco = new ComboBox<>();

                cbRisco.getItems().addAll(Risco.values());

                cbRisco.setOnAction(e -> {
                        Risco riscoSelecionado = cbRisco.getValue();
                        System.out.println("\nRisco selecionado: " + riscoSelecionado);
                });

                HBox linhaRisco = new HBox(10);
                linhaRisco.getChildren().addAll(
                                lblcbRisco,
                                cbRisco);

                // Label/TextFiled - PRENCHER AUTOMATICO COM AS CLASSE RESPECTIVAS Valor da
                // energia (kWh)
                Label lblValorEnergia = new Label("Valor da energia (kWh): ");

                TextField tfValorEnergia = new TextField();
                tfValorEnergia.setPromptText("Ex.: 0.85");

                double valorEnergia = 0;

                String textoValorEnergia = tfValorEnergia.getText();

                if (textoValorEnergia != null && !textoValorEnergia.isEmpty()) {
                        valorEnergia = Double.parseDouble(textoValorEnergia);
                        System.out.printf("Valor da enrgia: " + valorEnergia);
                }

                HBox linhaValorEnergia = new HBox(10);
                linhaValorEnergia.getChildren().addAll(
                                lblValorEnergia,
                                tfValorEnergia);

                // Label/TextField - Valor da mão de obra (por hora)
                Label lblValorMaoObra = new Label("Valor da mão de obra (por hora): ");

                TextField tfValorMaoObra = new TextField();
                tfValorMaoObra.setPromptText("Ex.: 25.00");

                double valorMaoObra = 0;

                String textoValorMaoObra = tfValorMaoObra.getText();

                if (textoValorMaoObra != null && !textoValorMaoObra.isEmpty()) {
                        valorMaoObra = Double.parseDouble(textoValorMaoObra);
                        System.out.println("Valor mão de obra: " + valorMaoObra);
                }

                HBox linhaValorMaoObra = new HBox(10);
                linhaValorMaoObra.getChildren().addAll(
                                lblValorMaoObra,
                                tfValorMaoObra);

                // Label/TextField - Margem de lucro
                Label lblMargemLucro = new Label("Margem de lucro (%): ");

                TextField tfMargemLucro = new TextField("100");
                tfMargemLucro.setEditable(false);

                HBox linhaMargemLucro = new HBox(10);
                linhaMargemLucro.getChildren().addAll(
                                lblMargemLucro,
                                tfMargemLucro);

                // Label/TextField - Taxa de falha (desperdício)
                Label lblTaxaFalha = new Label("Taxa de falha (%):");

                TextField tfTaxaFalha = new TextField("10");
                tfTaxaFalha.setEditable(false);

                HBox linhaTaxaFalha = new HBox(10);
                linhaTaxaFalha.getChildren().addAll(
                                lblTaxaFalha,
                                tfTaxaFalha);

                // Label/TextField - Custo de manutenção (por hora)
                Label lblCustoManutencao = new Label("Custo de manutenção (por hora): ");

                TextField tfCustoManutencao = new TextField();
                tfCustoManutencao.setPromptText("Ex.: 2.50");

                double custoManutencao = 0;

                String textoCustoManutencao = tfCustoManutencao.getText();

                if (textoCustoManutencao != null && !textoCustoManutencao.isEmpty()) {
                        custoManutencao = Double.parseDouble(textoCustoManutencao);
                        System.out.println("Custo manutenção: " + custoManutencao);
                }

                HBox linhaCustoManutencao = new HBox(10);
                linhaCustoManutencao.getChildren().addAll(
                                lblCustoManutencao,
                                tfCustoManutencao);
                // Botões

                Button btnCalcular = new Button("Calcular Custos");

                // DIREITA

                // COLUNA DA DIREITA

                // Label/TextFiled - PRENCHER AUTOMATICO COM A CLASSE IMPRESSORA3D
                Label lblTituloResumo = new Label("IMPRESSORA SELECIONADA");

                Label lblModelo = new Label("Modelo: ");
                Label lblDescricao = new Label("Descrição: ");
                Label lblPotencia = new Label("Potencia: ");
                // Material: R$ XX,XX - PEGAR OS DADOS NA CLASSE calculadoraCusto
                Label lblMaterial = new Label("Material: R$ 0,00");

                // Label - RESUMOS DE CUSTOS
                Label lblResumoCusto = new Label("RESEUMO DE CUSTOS");
                // Falha (10%): R$ XX,XX - PEGAR OS DADOS NA CLASSE calculadoraCusto
                Label lblFalha = new Label("Falha: R$ 0,00");

                // Máquina: R$ XX,XX - PEGAR OS DADOS NA CLASSE calculadoraCusto
                Label lblMaquina = new Label("Máquina: R$ 0,00");
                // Energia: R$ XX -
                Label lblEnergia = new Label("Energia: R$ 0,00");
                // Mão de obra: R$ XX,XX - PEGAR OS DADOS NA CLASSE calculadoraCusto
                Label lblMaoObra = new Label("Mão de obra: R$ 0,00");

                // Manutenção: R$ 2,50 - PEGAR OS DADOS NA CLASSE calculadoraCusto
                Label lblManutencao = new Label("Manutenção: R$ 0,00");

                // vamos colocar

                Label lblTotal = new Label("Valor total: R$ 0,00");

                // Label/TextFiled - valor no pix
                Label lblPix = new Label("PIX: ");

                TextField tfPix = new TextField("R$ 00,00");
                tfPix.setEditable(false);

                HBox linhaPix = new HBox(10);
                linhaPix.getChildren().addAll(
                                lblPix,
                                tfPix);

                // Label/TextFiled - valor no Dinheiro
                Label lblDinheiro = new Label("Dinheiro: ");
                TextField tfDinheiro = new TextField("R$ 00,00");
                tfDinheiro.setEditable(false);

                HBox linhaDinheiro = new HBox(10);
                linhaDinheiro.getChildren().addAll(lblDinheiro, tfDinheiro);

                // Label/TextFiled - valor no debito

                Label lblDebito = new Label("Débito: ");
                TextField tfDebito = new TextField("R$ 00,00");
                tfDebito.setEditable(false);

                HBox linhaDebito = new HBox(10);
                linhaDebito.getChildren().addAll(lblDebito, tfDebito);

                // Label/TextFiled - valor no credito
                Label lblCredito = new Label("Crédito: ");
                TextField tfCredito = new TextField("R$ 00,00");
                tfCredito.setEditable(false);

                HBox linhaCredito = new HBox(10);
                linhaCredito.getChildren().addAll(lblCredito, tfCredito);

                btnCalcular.setOnAction(e -> {
                        try {
                                String nomeProjeto = tfCampoNomeProjeto.getText();
                                String descricao = txtCampoDescricao.getText();
                                double quantidadeMaterial = Double.parseDouble(tfQtdMaterial.getText());
                                double tempoemHoras = Double.parseDouble(tfTempo.getText());
                                double valorEnergiaDouble = Double.parseDouble(tfValorEnergia.getText());
                                double valorMaoObraDouble = Double.parseDouble(tfValorMaoObra.getText());
                                Risco risco = cbRisco.getValue();
                                String modeloSelecionado = cbModeloImpressora.getValue();
                                String materialSelecionado = cbMateriaisImpressao.getValue();
                                System.out.println(nomeProjeto);
                                System.out.println(descricao);
                                System.out.println(quantidadeMaterial);
                                System.out.println(tempoemHoras);
                                System.out.println(valorEnergiaDouble);
                                System.out.println(valorMaoObraDouble);
                                System.out.println(risco);
                                System.out.println(modeloSelecionado);
                                System.out.println(materialSelecionado);

                                Impressora3D impressoraSelecionada = null;
                                for (Impressora3D imp : catalogoImpressoras.getImpressoras()) {
                                        if (imp.toString().equals(modeloSelecionado)) {
                                                impressoraSelecionada = imp;
                                                break;
                                        }
                                }

                                String ModeloImpressoraSelecionada = impressoraSelecionada.getModelo();
                                System.out.println(ModeloImpressoraSelecionada);
                                Double PotenciaImpressoraSelecionada = impressoraSelecionada.getPotencia();
                                String descricaoImpressoraSelecionada = impressoraSelecionada.getDescricao();

                                MaterialImpressao materialObjeto = null;

                                for (MaterialImpressao mat : catalogoMateriais.getMateriais()) {
                                        if (mat.toString().equals(materialSelecionado)) {
                                                materialObjeto = mat;
                                                break;
                                        }
                                }
                                ProjetoImpressao projeto = new ProjetoImpressao(
                                                nomeProjeto,
                                                descricao,
                                                quantidadeMaterial,
                                                tempoemHoras,
                                                materialObjeto,
                                                impressoraSelecionada,
                                                risco,
                                                Pagamento.PIX);

                                CalculadoraCusto calculadora = new CalculadoraCusto();
                                double custoMaterial = calculadora.calcularCustoMaterial(projeto);

                                double falha = calculadora.calcularFalha(projeto);

                                double maquina = calculadora.calcularCustoMaquina(projeto);

                                double energia = calculadora.calcularCustoEnergia(
                                                projeto,
                                                valorEnergiaDouble);

                                double maoObra = calculadora.calcularCustoMaoObra(
                                                tempoemHoras,
                                                valorMaoObraDouble);

                                double manutencao = calculadora.calcularManutencao();

                                double total = calculadora.calcularCustoTotal(
                                                projeto,
                                                valorEnergiaDouble,
                                                tempoemHoras,
                                                valorMaoObraDouble);

                                total = calculadora.aplicarRisco(total, risco);

                                double totalComLucro = calculadora.aplicarLucro(total);

                                double valorPix = calculadora.aplicarPagamento(
                                                totalComLucro,
                                                Pagamento.PIX);

                                double valorDinheiro = calculadora.aplicarPagamento(
                                                totalComLucro,
                                                Pagamento.DINHEIRO);

                                double valorDebito = calculadora.aplicarPagamento(
                                                totalComLucro,
                                                Pagamento.DEBITO);

                                double valorCredito = calculadora.aplicarPagamento(
                                                totalComLucro,
                                                Pagamento.CREDITO);

                                System.out.println("===== RESUMO =====");

                                System.out.println("Material: R$ " + custoMaterial);
                                System.out.println("Falha: R$ " + falha);
                                System.out.println("Máquina: R$ " + maquina);
                                System.out.println("Energia: R$ " + energia);
                                System.out.println("Mão de obra: R$ " + maoObra);
                                System.out.println("Manutenção: R$ " + manutencao);

                                System.out.println("Total com lucro: R$ " + totalComLucro);

                                System.out.println("PIX: R$ " + valorPix);
                                System.out.println("Dinheiro: R$ " + valorDinheiro);
                                System.out.println("Débito: R$ " + valorDebito);
                                System.out.println("Crédito: R$ " + valorCredito);

                                lblModelo.setText("Modelo: " + ModeloImpressoraSelecionada);

                                lblPotencia.setText(
                                                String.format("Potencia: %.2f", PotenciaImpressoraSelecionada));

                                lblDescricao.setText("Descrição: " + descricaoImpressoraSelecionada);

                                lblMaterial.setText(
                                                String.format("Material: R$ %.2f", custoMaterial));
                                lblFalha.setText(
                                                String.format("Falha: R$ %.2f", falha));
                                lblMaquina.setText(
                                                String.format("Máquina: R$ %.2f", maquina));

                                lblEnergia.setText(
                                                String.format("Energia: R$ %.2f", energia));

                                lblMaoObra.setText(
                                                String.format("Mão de obra: R$ %.2f", maoObra));

                                lblManutencao.setText(
                                                String.format("Manutenção: R$ %.2f", manutencao));

                                lblTotal.setText(
                                                String.format("Total: R$ %.2f", totalComLucro));

                                tfPix.setText(
                                                String.format("PIX: R$ %.2f", valorPix));

                                tfDinheiro.setText(
                                                String.format("Dinheiro: R$ %.2f", valorDinheiro));

                                tfDebito.setText(
                                                String.format("Débito: R$ %.2f", valorDebito));

                                tfCredito.setText(
                                                String.format("Crédito: R$ %.2f", valorCredito));

                        } catch (NumberFormatException ex) {
                                System.out.println("Preencha todos os campos numéricos!");
                        }

                });

                // CheckBox para escolher o valor
                // button - disparar o alert
                // Alert - com o valor e um texto
                //

                // COLUNA ESQUERDA
                VBox colunaEsquerda = new VBox(10);
                colunaEsquerda.setPadding(new Insets(20));
                colunaEsquerda.setPrefWidth(600);

                colunaEsquerda.getChildren().addAll(
                                lblTitulo,
                                cbModeloImpressora,
                                lblSelecionado,
                                linhaNomeProjeto,
                                linhaDescricaoProjeto,
                                linhaQtdMaterial,
                                linhaTempo,
                                linhaMaterialSelecionado,
                                lblSelecionadoMaterial,
                                linhaRisco,
                                linhaValorEnergia,
                                linhaValorMaoObra,
                                linhaMargemLucro,
                                linhaTaxaFalha,
                                linhaCustoManutencao,
                                btnCalcular);

                // COLUNA DIREITA
                VBox colunaDireita = new VBox(10);
                colunaDireita.setPadding(new Insets(20));

                colunaDireita.getChildren().addAll(
                                lblTituloResumo,
                                lblModelo,
                                lblDescricao,
                                lblPotencia,
                                lblMaterial,
                                lblResumoCusto,
                                lblFalha,
                                lblMaquina,
                                lblEnergia,
                                lblMaoObra,
                                lblManutencao,
                                lblTotal,
                                linhaPix,
                                linhaDinheiro,
                                linhaDebito,
                                linhaCredito);

                // DUAS COLUNAS LADO A LADO
                HBox cabecalho = new HBox(150);
                cabecalho.setAlignment(Pos.CENTER);
                cabecalho.setPadding(new Insets(20));

                cabecalho.getChildren().addAll(
                                colunaEsquerda,
                                colunaDireita);

                // ROOT PRINCIPAL

                VBox root = new VBox();
                root.getChildren().add(cabecalho);
                root.setAlignment(Pos.CENTER);

                // ESTILIZAÇÃO GERAL

                root.setStyle("""
                                    -fx-background-color: #20242e;
                                """);

                // COLUNAS

                colunaEsquerda.setStyle("""
                                    -fx-background-color: #111827;
                                    -fx-background-radius: 10;
                                    -fx-border-color: #2563EB;
                                    -fx-border-radius: 10;
                                    -fx-padding: 20;
                                """);

                colunaDireita.setStyle("""
                                    -fx-background-color: #111827;
                                    -fx-background-radius: 10;
                                    -fx-border-color: #2563EB;
                                    -fx-border-radius: 10;
                                    -fx-padding: 20;
                                """);

                cabecalho.setSpacing(30);

                // TÍTULOS

                lblTitulo.setStyle("""
                                    -fx-text-fill: #60A5FA;
                                    -fx-font-size: 22px;
                                    -fx-font-weight: bold;
                                """);

                lblTituloResumo.setStyle("""
                                    -fx-text-fill: #60A5FA;
                                    -fx-font-size: 22px;
                                    -fx-font-weight: bold;
                                """);

                lblResumoCusto.setStyle("""
                                    -fx-text-fill: #60A5FA;
                                    -fx-font-size: 18px;
                                    -fx-font-weight: bold;
                                """);

                lblTotal.setStyle("""
                                    -fx-text-fill: #22C55E;
                                    -fx-font-size: 24px;
                                    -fx-font-weight: bold;
                                """);

                // LABELS

                String estiloLabel = """
                                    -fx-text-fill: white;
                                    -fx-font-size: 14px;
                                """;
                lblSelecionado.setStyle(estiloLabel);
                linhaNomeProjeto.setStyle(estiloLabel);
                lblSelecionado.setStyle(estiloLabel);
                lblSelecionadoMaterial.setStyle(estiloLabel);
                lblModelo.setStyle(estiloLabel);
                lblDescricao.setStyle(estiloLabel);
                lblPotencia.setStyle(estiloLabel);
                lblMaterial.setStyle(estiloLabel);
                lblFalha.setStyle(estiloLabel);
                lblMaquina.setStyle(estiloLabel);
                lblEnergia.setStyle(estiloLabel);
                lblMaoObra.setStyle(estiloLabel);
                lblManutencao.setStyle(estiloLabel);
                lblcampoNomeProjeto.setStyle(estiloLabel);
                lblcampoDescricao.setStyle(estiloLabel);
                lblQtdMaterial.setStyle(estiloLabel);
                lblTempo.setStyle(estiloLabel);
                lblSelecionarMaterial.setStyle(estiloLabel);
                lblcbRisco.setStyle(estiloLabel);
                lblValorEnergia.setStyle(estiloLabel);
                lblValorMaoObra.setStyle(estiloLabel);
                lblMargemLucro.setStyle(estiloLabel);
                lblTaxaFalha.setStyle(estiloLabel);
                lblCustoManutencao.setStyle(estiloLabel);
                cbMateriaisImpressao.setStyle(estiloLabel);
                cbRisco.setStyle(estiloLabel);
                cbModeloImpressora.setStyle(estiloLabel);
                lblPix.setStyle(estiloLabel);
                lblDinheiro.setStyle(estiloLabel);
                lblDebito.setStyle(estiloLabel);
                lblCredito.setStyle(estiloLabel);
                // CAMPOS

                String estiloCampo = """
                                    -fx-background-color: #1F2937;
                                    -fx-text-fill: white;
                                    -fx-border-color: #374151;
                                    -fx-border-radius: 5;
                                    -fx-background-radius: 5;
                                    -fx-font-size: 14px;
                                    -fx-pref-height: 40;
                                """;

                tfCampoNomeProjeto.setStyle(estiloCampo);
                tfCampoNomeProjeto.setPrefHeight(100);

                tfQtdMaterial.setStyle(estiloCampo);
                tfQtdMaterial.setPrefHeight(40);

                tfTempo.setStyle(estiloCampo);
                tfTempo.setPrefHeight(40);

                tfValorEnergia.setStyle(estiloCampo);
                tfValorEnergia.setPrefHeight(40);

                tfValorMaoObra.setStyle(estiloCampo);
                tfValorMaoObra.setPrefHeight(40);

                tfMargemLucro.setStyle(estiloCampo);
                tfMargemLucro.setPrefHeight(40);

                tfTaxaFalha.setStyle(estiloCampo);
                tfTaxaFalha.setPrefHeight(40);

                tfCustoManutencao.setStyle(estiloCampo);
                tfCustoManutencao.setPrefHeight(40);

                tfPix.setStyle(estiloCampo);
                tfPix.setPrefHeight(40);

                tfDinheiro.setStyle(estiloCampo);
                tfDinheiro.setPrefHeight(40);

                tfDebito.setStyle(estiloCampo);
                tfDebito.setPrefHeight(40);

                tfCredito.setStyle(estiloCampo);
                tfCredito.setPrefHeight(40);

                ///txtCampoDescricao.setStyle(estiloCampo);
                txtCampoDescricao.setPrefHeight(80);

                // BOTÃO

                btnCalcular.setStyle("""
                                    -fx-background-color: #2563EB;
                                    -fx-text-fill: white;
                                    -fx-font-size: 15px;
                                    -fx-font-weight: bold;
                                    -fx-background-radius: 8;
                                    -fx-padding: 10 20 10 20;
                                """);

                Scene scene = new Scene(root, 1000, 600);

                primaryStage.setTitle("Calculadora de Custos 3D");
                primaryStage.setScene(scene);
                primaryStage.show();

        }
}
