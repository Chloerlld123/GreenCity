package com.example.greencity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private DataBaseVille databaseville ;
    private TextView FicheProduit ; // crée un pointeur de type Text View

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_calendar, R.id.navigation_recycling, R.id.navigation_user)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.navigation_search);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        FicheProduit = (TextView) findViewById(R.id.FicheProduit) ; // find view renvoie un view de type TextView ,cette fct , id : class
        databaseville = new DataBaseVille(this) ;

        databaseville.insertProduit("compote", "bac jaune ");
        databaseville.insertProduit("journal", "bac jaune ");
        databaseville.insertProduit("bocaux ", "bac verre ");

        List<VilleDatas> produits = databaseville.lectureProduits() ; // devrait afficher tous ce qui a dans ma base
        String produit1 = " compote" ;
        for (VilleDatas produit : produits){
            //FicheProduit.append(produit.toString() + "\n\n");
            if (produit.equals(produit1)){
                FicheProduit.append(produit.toStringProduit() + "\n\n");
            }
        }

        databaseville.close();// ferme la connexion avec la bd
    }

}