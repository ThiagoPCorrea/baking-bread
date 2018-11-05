package elementos;

import java.util.ArrayList;

public class Receita {
    private String Nome;
    ArrayList<String> Ingredientes = new ArrayList();
    @SuppressWarnings("FieldMayBeFinal")
    private int N_ingr = Ingredientes.size();
    private String ModoPrep;

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public ArrayList<String> getIngredientes() {
        return Ingredientes;
    }

    public void setIngredientes(ArrayList<String> Ingredientes) {
        this.Ingredientes = Ingredientes;
    }

    public int getN_ingr() {
        return N_ingr;
    }

    public void setN_ingr(int N_ingr) {
        this.N_ingr = N_ingr;
    }

    public String getModoPrep() {
        return ModoPrep;
    }

    public void setModoPrep(String ModoPrep) {
        this.ModoPrep = ModoPrep;
    }


}