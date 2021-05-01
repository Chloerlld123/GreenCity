package com.example.greencity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DataBaseVille extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Paris.db";
    private static final int DATABASE_VERSION = 1;

    public DataBaseVille(Context context) {
        // context : classe de base de activity
        super(context, DATABASE_NAME, null, DATABASE_VERSION); // on prends le constructeur a 4 paramètres
    }


    // fct qui est invoqué par le syst si la bd n'existe pas
    //db : objet de base de donnée sqlite
    @Override
    public void onCreate(SQLiteDatabase db) {
        String strSql = "create table Paris (" // nom de la table
                + " NbProduits integer primary key autoincrement," //  1ère colonne, est la clé primaire, autoincrement : sera geré en automatqieu de manière en autoincrémetation
                + " produit text not null, " // 2ème colonne, du texte qui ne peut être nul
                + " modalite text not null " // 3 ème
                + ")";

        db.execSQL(strSql); //executer en auto commit, sera appliqué definitivement
        Log.i("Database", "onCreate invoked"); // permet de vérifier que la méthode est invoqué qu'une seule fois, 2 paramètres : le tag permet de filtrer et le message

    }


    // s'utilise automatqiuement quand il voit que la version a changé
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // String strSql = "alter table Villes add colum ... " ;
        String strSql = "drop table Paris "; // on se débarasse de ce qu'il y avait dans la table
        db.execSQL(strSql);
        this.onCreate(db); // on recrée la bd
        Log.i("Database", "onUpgarde invoked");
    }

    public void insertProduit(String produit, String modalite) {
        modalite = modalite.replace("'", "''"); // remplace les ' par des '' dans la string car peut poser ensuite pb
        produit = produit.replace("'", "''");
        String strSql = "insert into Paris (produit, modalite) values (' " // on met les colonnes when, métropoles et types produits
                + produit + "', '" + modalite + "' )";

        this.getWritableDatabase().execSQL(strSql); // envoie un ordre sql dans la base , généralement ne se fait que sur une sqlitedatabase, utilisation de this pour y accéder
        Log.i("Database", "InsertProduit invoked");

    }

    //méthode qui lit les infos de la table en les récupérant et les stockant dans une liste
    public List<VilleDatas> lectureProduits() { // renvoie une liste, il va créer une nouvelle classe permettant d'accéder à chaque score
        List<VilleDatas> produits = new ArrayList<>();

        Cursor cursor = this.getReadableDatabase().query("Paris ",
                new String[]{"NbProduits", "produit desc", "modalite"},
                null, null, null, null, "produit", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) { // cela veut dire que j'ai une donnée courante
            VilleDatas produit = new VilleDatas(cursor.getInt(0), cursor.getString(1),
                    cursor.getString(2));  // en 0 a NbProduits, en 1 produit, en 2 modalite
            produits.add(produit);
            cursor.moveToNext();
        }
        cursor.close();

        return produits;
    }

}