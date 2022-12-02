package br.unigran.sub;

public class Abastecimentos {
    public String km;
    public String qntAbs;
    public String data;
    public String valor;



    @Override
    public String toString() {
        return "Abastecimento{" +
                "km='" + km + '\'' +
                ", qntAbs='" + qntAbs + '\'' +
                ", data=" + data +
                ", valor='" + valor + '\'' +
                '}';
    }
}
