package repositoy;

import java.util.List;
import java.util.ArrayList;
import model.Impressora3D;

public class CatalogoImpressoras {

    private List<Impressora3D> impressoras;

    public CatalogoImpressoras() {

        impressoras = new ArrayList<>();

        impressoras.add(
            new Impressora3D(
                "Ender 3",
                1500.00,
                350.0,
                "ender3.png",
                "Impressora 3D de entrada"
            )
        );

        impressoras.add(
            new Impressora3D(
                "Creality K1",
                3500.00,
                500.0,
                "k1.png",
                "Impressora de alta velocidade"
            )
        );

        impressoras.add(
            new Impressora3D(
                "Bambu Lab A1",
                4200.00,
                400.0,
                "bambu_a1.png",
                "Impressora moderna"
            )
        );
    }

    public List<Impressora3D> getImpressoras() {
        return impressoras;
    }

}
