package be.vdab.muziek.utility;

public class Convertor {
    public static String printDoubleAlsMinutenEnSeconden(double tijd) {
        if (tijd < 0) {
            return "0:00";
        } else {
            var minuten = (int) Math.floor(tijd / 60);
            var seconden = (int) Math.floor(tijd % 60);
            var secondenString =
                    (seconden < 10)
                            ? "0" + seconden
                            : String.valueOf(seconden);
            return String.valueOf(minuten) + ':' + secondenString;
        }
    }
}
