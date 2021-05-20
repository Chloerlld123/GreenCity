package com.example.greencity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DataBaseVille extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Villes.db";
    private static final String NOM_TABLE = "Villes";
    private static final String COL_ID = "Id";
    private static final String COL_VILLE = "ville";
    private static final String COL_PRODUIT = "produit";
    private static final String COL_MODALITE = "modalite";
    private static final int DATABASE_VERSION = 1;

    public DataBaseVille(Context context) {
        // context : classe de base de activity
        super(context, DATABASE_NAME, null, DATABASE_VERSION); // on prends le constructeur a 4 paramètres
    }


    // fct qui est invoqué par le syst si la bd n'existe pas
    //db : objet de base de donnée sqlite
    @Override
    public void onCreate(SQLiteDatabase db) {
        String strSql = "create table " + NOM_TABLE + "(" // nom de la table
                + COL_ID + " integer primary key autoincrement, " //  1ère colonne, est la clé primaire, autoincrement : sera geré en automatqieu de manière en autoincrémetation
                + COL_VILLE +" text not null, " // 2ème colonne, du texte qui ne peut être nul
                + COL_PRODUIT+ " text not null, " // 3ème colonne, du texte qui ne peut être nul
                + COL_MODALITE+ " text not null " // 4 ème
                + ")";

        db.execSQL(strSql); //executer en auto commit, sera appliqué definitivement
        Log.i("Database", "onCreate invoked"); // permet de vérifier que la méthode est invoqué qu'une seule fois, 2 paramètres : le tag permet de filtrer et le message

    }


    // s'utilise automatqiuement quand il voit que la version a changé
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // String strSql = "alter table Villes add colum ... " ;
        String strSql = "drop table " + NOM_TABLE + ";" ; // on se débarasse de ce qu'il y avait dans la table
        db.execSQL(strSql);
        this.onCreate(db); // on recrée la bd
        Log.i("Database", "onUpgarde invoked");
    }

    public void insertProduit(String ville, String produit, String modalite) {
        modalite = modalite.replace("'", "''"); // remplace les ' par des '' dans la string car peut poser ensuite pb
        produit = produit.replace("'", "''");
        ville = ville.replace("'", "''");
        // on insère les valeurs dans la table
        String strSql = "insert into " + NOM_TABLE +" (" + COL_VILLE + ", " + COL_PRODUIT + ", " + COL_MODALITE +") values ('"
                + ville + "', '" + produit + "', '" + modalite + "' )";

        this.getWritableDatabase().execSQL(strSql); // envoie un ordre sql dans la base , généralement ne se fait que sur une sqlitedatabase, utilisation de this pour y accéder
        Log.i("Database", "InsertProduit invoked");

    }

    //méthode qui lit les infos de la table en les récupérant et les stockant dans une liste
    public List<VilleDatas> lectureProduits() { // renvoie une liste, il va créer une nouvelle classe permettant d'accéder à chaque score
        List<VilleDatas> produits = new ArrayList<>();
        //2 manière pour relire le top10
        /*String strSql = "select * from Villes order by ville limit 10"  ; //méthode avec ordre sql, récupère toutes les colonnes de la table
        Cursor cusror = this.getReadableDatabase().rawQuery(strSql, null) ;
        cusror.moveToFirst() ;
        while (!cusror.isAfterLast()){ // cela veut dire que j'ai une donnée courante
            VilleData ville = new VilleData( cusror.getInt(0), cusror.getString(1),
                    cusror.getString(2), new Date (cusror.getInt(3))) ;  // en 0 a NbMetropoles, en 1 Ville, en 2 produit et en 3 when
            villes.add(ville) ;
            cusror.moveToNext() ;
        }
        cusror.close();*/

        // fct query : 1er argument : la table, 2: les colonnes, 3: les lignes à selectionner (null = toutes), 4: recherche des string particulière,
        // 5: regroupement possible des lignes, 6: récupère certaies données des groupes, 7: comment sont ordonnés les lignes, 8: limite de ligne à prendre, null = pas de limite
        Cursor cursor = this.getReadableDatabase().query( NOM_TABLE,
                new String[]{COL_ID, COL_VILLE + " desc", COL_PRODUIT, COL_MODALITE},
                null, null, null, null, COL_VILLE,null );
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


    //méthode qui récupère les modalités en fonction d'une ville donnée et d'un produit
    public String selection(String ville1, String produit1) { // renvoie une liste, il va créer une nouvelle classe permettant d'accéder à chaque score
        String modalite1  = "";
        //méthode avec requete sql,
        String strSql = "select * from "+ NOM_TABLE +" where "
                + COL_VILLE + "='" + ville1 +"' and " + COL_PRODUIT +  "='"+ produit1 +"' ; " ;
        Cursor cusror = this.getReadableDatabase().rawQuery(strSql, null) ;
        cusror.moveToFirst() ;
        while (!cusror.isAfterLast()){ // cela veut dire que j'ai une donnée courante
            modalite1  = "";
            modalite1 = modalite1 + cusror.getString(3) ;
            cusror.moveToNext() ;
        }
        cusror.close();

        return modalite1;
    }
}