package circList;

import com.test.renata.projetorenata.R;

import java.util.ArrayList;

import elementos.Receita;

public class ListaInstance {

    public static CircularLinkedList<Receita>  lista ;

    public static Receita receita = new Receita();
    public static ArrayList<String> ing = new ArrayList();

    public static CircularLinkedList <Receita> init1()
    {
        lista = new CircularLinkedList<Receita>();

        receita.setNome("Bolo de cenoura");
        receita.setN_ingr(3);
        receita.setModoPrep("Faça o bolo de cenoura");
        ing.add("Bolo");
        ing.add("Cenoura");
        receita.setCategoria("Doce");
        receita.setTempo("2 horas");
        receita.setIngredientes(ing);
        receita.setImagem(R.drawable.bolo_de_cenoura);

        lista.add(receita);
        receita = new Receita();
        ing = new ArrayList();

        receita.setNome("Bolo de sorvete");
        receita.setN_ingr(3);
        receita.setModoPrep("Faça o bolo de sorvete");
        ing.add("Bolo");
        ing.add("Sorvete");
        receita.setIngredientes(ing);
        receita.setCategoria("Doce");
        receita.setTempo("2 horas");
        receita.setImagem(R.drawable.bolo_de_sorvete);

        lista.add(receita);
        receita = new Receita();
        ing = new ArrayList();

        receita.setNome("Bolo de laranja");
        receita.setN_ingr(3);
        receita.setModoPrep("Faça o bolo de laranja");
        ing.add("Bolo");
        ing.add("Laranja");
        ing.add("Amor");
        ing.add("Carinho");
        receita.setIngredientes(ing);
        receita.setCategoria("Doce");
        receita.setTempo("2 horas");
        receita.setImagem(R.drawable.bolo_de_laranja);

        lista.add(receita);
        receita = new Receita();
        ing = new ArrayList();

        return lista;
    }

    public static CircularLinkedList <Receita> init2()
    {
        lista = new CircularLinkedList<Receita>();

        receita.setNome("Coxinha");
        receita.setN_ingr(3);
        receita.setModoPrep("faça a coxinha");
        ing.add("Catupiry");
        ing.add("Frango");
        ing.add("Massa");
        receita.setIngredientes(ing);
        receita.setCategoria("Salgado");
        receita.setTempo("2 horas");
        receita.setImagem(R.drawable.coxinha);

        lista.add(receita);
        receita = new Receita();
        ing = new ArrayList();

        receita.setNome("Bolinha de Queijo");
        receita.setN_ingr(3);
        receita.setModoPrep("faça a bolnha de queijo");
        ing.add("Bolinha");
        ing.add("Queijo");
        receita.setIngredientes(ing);
        receita.setCategoria("Salgado");
        receita.setTempo("2 horas");
        receita.setImagem(R.drawable.bolinha_de_queijo);

        lista.add(receita);
        receita = new Receita();
        ing = new ArrayList();

        receita.setNome("Croquete de Carne");
        receita.setN_ingr(3);
        receita.setModoPrep("faça o Croquete");
        ing.add("Croquete");
        ing.add("Carne");
        receita.setIngredientes(ing);
        receita.setCategoria("Salgado");
        receita.setTempo("2 horas");
        receita.setImagem(R.drawable.croquete_2);

        lista.add(receita);
        receita = new Receita();
        ing = new ArrayList();

        return lista;
    }

    public static CircularLinkedList <Receita> init3()
    {
        lista = new CircularLinkedList<Receita>();

        receita.setNome("Sopa de legumes");
        receita.setN_ingr(3);
        receita.setModoPrep("faça a sopa");
        ing.add("Sopa");
        ing.add("Legumes");
        receita.setIngredientes(ing);
        receita.setCategoria("Salgado");
        receita.setTempo("2 horas");
        receita.setImagem(R.drawable.sopa);

        lista.add(receita);
        receita = new Receita();
        ing = new ArrayList();

        receita.setNome("Brigadeiro");
        receita.setN_ingr(3);
        receita.setModoPrep("faça o brigadeiro");
        ing.add("chocolate");
        ing.add("alegria");
        ing.add("motivos pra viver");
        receita.setIngredientes(ing);
        receita.setCategoria("Doce");
        receita.setTempo("2 horas");
        receita.setImagem(R.drawable.brigadeiro);

        lista.add(receita);
        receita = new Receita();
        ing = new ArrayList();

        receita.setNome("Macarrao");
        receita.setN_ingr(3);
        receita.setModoPrep("faça o Macarrao");
        ing.add("Macarrao");
        ing.add("espirito italiano");
        receita.setIngredientes(ing);
        receita.setCategoria("Doce");
        receita.setTempo("2 horas");
        receita.setImagem(R.drawable.macarrao);

        lista.add(receita);
        receita = new Receita();
        ing = new ArrayList();

        return lista;
    }

    public static CircularLinkedList <Receita> init4()
    {
        lista = new CircularLinkedList<Receita>();

        receita.setNome("Molho branco");
        receita.setN_ingr(3);
        receita.setModoPrep("faça o molho branco");
        ing.add("Molho");
        ing.add("Branco");
        receita.setIngredientes(ing);
        receita.setCategoria("Doce");
        receita.setTempo("2 horas");
        receita.setImagem(R.drawable.molho_branco);

        lista.add(receita);
        receita = new Receita();
        ing = new ArrayList();

        receita.setNome("Molho de tomate");
        receita.setN_ingr(3);
        receita.setModoPrep("faça o molho de tomate");
        ing.add("Molho");
        ing.add("Tomate");
        receita.setIngredientes(ing);
        receita.setCategoria("Doce");
        receita.setTempo("2 horas");
        receita.setImagem(R.drawable.molho_de_tomate);

        lista.add(receita);
        receita = new Receita();
        ing = new ArrayList();

        receita.setNome("Molho a bolonhesa");
        receita.setN_ingr(3);
        receita.setModoPrep("faça o molho a bolonhesa");
        ing.add("Molho");
        ing.add("Bolonhesa");
        receita.setIngredientes(ing);
        receita.setCategoria("Doce");
        receita.setTempo("2 horas");
        receita.setImagem(R.drawable.molho_a_bolonhesa);

        lista.add(receita);
        receita = new Receita();
        ing = new ArrayList();

        return lista;
    }

    public static CircularLinkedList <Receita> init5()
    {
        lista = new CircularLinkedList<Receita>();

        receita.setNome("Hot Roll");
        receita.setN_ingr(3);
        receita.setModoPrep("faça o hot roll");
        ing.add("hot");
        ing.add("roll");
        receita.setIngredientes(ing);
        receita.setCategoria("Doce");
        receita.setTempo("2 horas");
        receita.setImagem(R.drawable.hot_roll);

        lista.add(receita);
        receita = new Receita();
        ing = new ArrayList();

        receita.setNome("temaki de salmao");
        receita.setN_ingr(3);
        receita.setModoPrep("faça o temaki de salmao");
        ing.add("Temaki");
        ing.add("Salmao");
        receita.setIngredientes(ing);
        receita.setCategoria("Doce");
        receita.setTempo("2 horas");
        receita.setImagem(R.drawable.temaki_de_salmao);

        lista.add(receita);
        receita = new Receita();
        ing = new ArrayList();

        receita.setNome("Suco de laranja");
        receita.setN_ingr(3);
        receita.setModoPrep("faça o suco de laranja");
        ing.add("suco");
        ing.add("laranja");
        receita.setIngredientes(ing);
        receita.setCategoria("Doce");
        receita.setTempo("2 horas");
        receita.setImagem(R.drawable.suco_de_laranja);

        lista.add(receita);
        receita = new Receita();
        ing = new ArrayList();

        return lista;
    }
}
