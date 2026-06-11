package repositoy;

import java.util.List;
import java.util.ArrayList;
import model.MaterialImpressao;
import model.Densidade;

public class CatalogoMateriais {
    private List<MaterialImpressao> materiais;

    public CatalogoMateriais() {

        materiais = new ArrayList<>();

        materiais.add(
                new MaterialImpressao(
                        "PLA",
                        Densidade.BAIXA,
                        0.08));

        materiais.add(
                new MaterialImpressao(
                        "PLA",
                        Densidade.MEDIA,
                        0.12));

        materiais.add(
                new MaterialImpressao(
                        "PLA",
                        Densidade.ALTA,
                        0.18));

        materiais.add(
                new MaterialImpressao(
                        "PETG",
                        Densidade.BAIXA,
                        0.10));

        materiais.add(
                new MaterialImpressao(
                        "PETG",
                        Densidade.MEDIA,
                        0.15));

        materiais.add(
                new MaterialImpressao(
                        "PETG",
                        Densidade.ALTA,
                        0.22));
    }

    public List<MaterialImpressao> getMateriais() {
        return materiais;
    }
}
