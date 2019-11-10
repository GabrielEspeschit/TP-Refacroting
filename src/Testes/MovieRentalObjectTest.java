package Testes;

import Classes.Customer;
import Classes.Movie;
import Classes.Rental;
import org.junit.Assert;
import org.junit.Test;


public class MovieRentalObjectTest {

    @Test
    public void TestaCriaçãodeFilme(){
        //Dado que:
        String titulo = "O Iluminado";
        int codigo = 0;

        //Quando:
        Movie filme = new Movie(titulo, codigo);

        //Então:
        Assert.assertTrue(filme.getTitle().equals(titulo));
        Assert.assertTrue(filme.getPriceCode() == codigo);
    }

    @Test
    public void TestaMudançaDeClasseDePreço(){
        //Dado que:
        String titulo = "O Iluminado";
        int codigo = 1;
        Movie filme = new Movie(titulo, codigo);

        //Quando:
        int novo_codigo = 0;
        filme.setPriceCode(novo_codigo);

        //Então:
        Assert.assertFalse(filme.getPriceCode() == codigo);
        Assert.assertTrue(filme.getPriceCode()== novo_codigo);
    }

    @Test
    public void TestaClientecomAluguel(){
        //Dado que:
        String nome_iluminado = "O Iluminado";
        int codigo_iluminado = 0;
        Movie iluminado = new Movie(nome_iluminado, codigo_iluminado);

        String nome_coringa = "Coringa";
        int codigo_coringa = 1;
        Movie coringa = new Movie(nome_coringa, codigo_coringa);

        String nome = "Gabriel";
        Customer cliente_Gabriel = new Customer(nome);

        //Quando:
        Rental aluguel_ilumindado = new Rental(iluminado, 6);
        Rental aluguel_coringa = new Rental(coringa, 3);
        cliente_Gabriel.addRental(aluguel_coringa);
        cliente_Gabriel.addRental(aluguel_ilumindado);

        //Considerando:
        String esperada = "";
        esperada = "Rental Record for Gabriel\n" +
                "	Coringa\t9.0\n" +
                "	O Iluminado\t8.0\n" +
                "Amount owed is 17.0\n" +
                "You earned 3 frequent renter points";

        Assert.assertEquals(cliente_Gabriel.statement(), esperada);
    }

    @Test
    public void TestaClientecomAluguelHTML(){
        //Dado que:
        String nome_iluminado = "O Iluminado";
        int codigo_iluminado = 0;
        Movie iluminado = new Movie(nome_iluminado, codigo_iluminado);

        String nome_coringa = "Coringa";
        int codigo_coringa = 1;
        Movie coringa = new Movie(nome_coringa, codigo_coringa);

        String nome = "Gabriel";
        Customer cliente_Gabriel = new Customer(nome);

        //Quando:
        Rental aluguel_ilumindado = new Rental(iluminado, 6);
        Rental aluguel_coringa = new Rental(coringa, 3);
        cliente_Gabriel.addRental(aluguel_coringa);
        cliente_Gabriel.addRental(aluguel_ilumindado);

        //Considerando:
        String esperada = "";
        esperada = "<H1>Rentals for <EM>Gabriel</EM></H1><P>\n" +
                "Coringa: 9.0<BR>\n" +
                "O Iluminado: 8.0<BR>\n" +
                "<P>You owe <EM>17.0</EM><P>\n" +
                "On this rental you earned <EM>3</EM> frequent renter points<P>";

        Assert.assertEquals(cliente_Gabriel.htmlStatement(), esperada);
    }
}