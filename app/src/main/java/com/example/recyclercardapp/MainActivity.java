package com.example.recyclercardapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv1;
    String [] personajes={"Goku", "Krilin", "Frezzer", "Vegeta"};
    String [] descripcion = {"Gokū es hijo de Bardock y Gine, nace en el año 737 con el nombre de Kakarot / Kakarotto. Gokū comenzó a aprender artes marciales",
            "Es un artista marcial de baja estatura y que lleva la cabeza rapada por su entrenamiento como monje en el templo de Oorin y seis puntos tatuados en su frente. Sin embargo su principal rasgo físico es que carece de nariz.",
            "Freezer heredó de su padre el Rey Cold el imperio de la Organización Interplanetaria de Comercio y por lo tanto, al planeta Vegeta como parte de los planetas conquistados por su progenitor. Al recibir su nombramiento como el nuevo emperador del mal.",
            "Vegeta es el príncipe de una raza guerrera extraterrestre conocida como los Saiyajin. Es extremadamente arrogante, orgulloso y trabajador; constantemente se refiere a su herencia y estatus real a lo largo de la serie."};
    int [] fotos ={R.drawable.goku, R.drawable.krilin, R.drawable.frezzer, R.drawable.vegeta};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv1 = (RecyclerView) findViewById(R.id.rv1);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this); 
        rv1.setLayoutManager(linearLayoutManager);

        rv1.setAdapter(new Adaptadorpersonaje());


    }

    private class Adaptadorpersonaje extends RecyclerView.Adapter <Adaptadorpersonaje.AdaptadorpersonajeHolder> {

        @NonNull
        @Override

        public AdaptadorpersonajeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new AdaptadorpersonajeHolder(getLayoutInflater().inflate(R.layout.item_personajes, parent, false));
        }

        @Override

        public void onBindViewHolder(@NonNull AdaptadorpersonajeHolder holder, int position) {
            holder.print(position);
        }

        @Override

        public int getItemCount() {

            return personajes.length;
        }

        class AdaptadorpersonajeHolder extends RecyclerView.ViewHolder {
            ImageView iv1;
            TextView tv1;
            TextView tv2;

            public AdaptadorpersonajeHolder(@NonNull View itemView) {
                super(itemView);
                iv1 = itemView.findViewById(R.id.iv1);
                tv1 = itemView.findViewById(R.id.tv1titulo);
                tv2 = itemView.findViewById(R.id.tv2descripcion);
            }


            public void print(int position) {
                iv1.setImageResource(fotos [position]);
                tv1.setText(personajes[position]);
                tv2.setText(descripcion[position]);
            }
        }
    }
}