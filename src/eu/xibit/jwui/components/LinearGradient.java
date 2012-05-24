/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.xibit.jwui.components;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dipacs
 */
public class LinearGradient extends ABackground {

    private final ELinearGradientOrientation orientation;
    private final List<Stop> stops = new ArrayList<Stop>();

    public LinearGradient(ELinearGradientOrientation orientation) {
        this.orientation = orientation;
    }

    public List<Stop> getStops() {
        return stops;
    }

    @Override
    public String toCss() {
        String res = "";

        String univRes = orientation.toCSS();
        for (Stop stop : stops) {
            univRes += ",";
            univRes += stop.getColor().toCssRGB();
            univRes += " ";
            univRes += "" + ((int) (stop.getPosition() * 100)) + "%";
        }
        
        // simple
        res += "background-image:linear-gradient(" + univRes + ");";
        // opera
        res += "background-image:-o-linear-gradient(" + univRes + ");";
        // firefox
        res += "background-image:-moz-linear-gradient(" + univRes + ");";
        // webkit1
        res += "background-image:-webkit-linear-gradient(" + univRes + ");";
        // IE
        res += "background-image:-ms-linear-gradient(" + univRes + ");";

        // webkit 2
        res += "background-image:-webkit-gradient(linear," + orientation.toFullCss();
        for (Stop stop : stops) {
            res += ",color-stop(";
            res += "" + stop.getPosition() + ",";
            res += stop.getColor().toCssRGB();
            res += ")),";
        }
        res += ");";

        return res;

        /*
         * background-image: linear-gradient (left , rgb(152,107,88) 0%, rgb(87,50,28) 64%, rgb(247,8,8) 100%);
         * background-image: -o-linear-gradient (left , rgb(152,107,88) 0%, rgb(87,50,28) 64%, rgb(247,8,8) 100%);
         * background-image: -moz-linear-gradient (left , rgb(152,107,88) 0%, rgb(87,50,28) 64%, rgb(247,8,8) 100%);
         * background-image: -webkit-linear-gradient(left , rgb(152,107,88) 0%, rgb(87,50,28) 64%, rgb(247,8,8) 100%);
         * background-image: -ms-linear-gradient (left , rgb(152,107,88) 0%, rgb(87,50,28) 64%, rgb(247,8,8) 100%);
         *
         * background-image: -webkit-gradient( linear, left top, right top, 
         *   color-stop(0, rgb(152,107,88)),
         *   color-stop(0.64, rgb(87,50,28)), 
         *   color-stop(1, rgb(247,8,8)) 
         * );
         */
    }
}
