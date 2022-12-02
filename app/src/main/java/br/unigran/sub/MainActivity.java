package br.unigran.sub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText km;
    EditText qntAbs;
    EditText data;
    EditText valor;
    ListView listagem;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        ler();
        salvar();

    }
    public void salvar(){
        Abastecimentos abastecimentos = new Abastecimentos();
        abastecimentos.km="2000";
        abastecimentos.qntAbs="23";
        abastecimentos.data="14/10/2016";
        abastecimentos.valor="79";
        DatabaseReference Abastecimento = databaseReference.child("Abastecimento");
        Abastecimento.child("002").setValue(abastecimentos);

    }

    List lista = new LinkedList();
    public void ler(){
        DatabaseReference Abastecimento = databaseReference.child("Abastecimento");
        Abastecimento.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                lista.clear();
                Log.i("Firebase",snapshot.getValue().toString());
                for (DataSnapshot dados:snapshot.getChildren()
                ) {
                            Abastecimentos abastecimentos = dados.getValue(Abastecimentos.class);
                    lista.add(abastecimentos);
                    Log.i("Firebase",abastecimentos.km);

                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.i("Firebase",error.toString());
            }
        });
    }
}