package pt.estga.ti.rmi.utils;

public class HealthUtils {

    public static String bodyMassIndex(double w, double h){

        if(h <= 0 || w <= 0) {
            throw new IllegalArgumentException("Height or weight invalid");
        }

        if(h > 3) {
            h = h / 100.0;
        }

        double result = w / (h * h);

        return String.format("IMC: %.2f Classification: %s",
                result,
                getClassification(result));
    }

    public static String getClassification(double result){

        if(result < 18.5){
            return "Low Weight";
        }else if(result <= 24.9){
            return "Normal Weight";
        }else if(result <= 29.9){
            return "Excess Weight";
        }else if(result <= 34.9){
            return "Obesity I";
        }else if(result <= 39.9){
            return "Obesity II";
        }else{
            return "Mordib Obesity";
        }
    }

}
