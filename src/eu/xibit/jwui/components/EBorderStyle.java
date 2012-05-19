package eu.xibit.jwui.components;

public class EBorderStyle {

    public static final EBorderStyle Dashed = new EBorderStyle("dashed");
    public static final EBorderStyle Dotted = new EBorderStyle("dotted");
    public static final EBorderStyle Solid = new EBorderStyle("solid");
    public static final EBorderStyle Double = new EBorderStyle("double");
    public static final EBorderStyle Groove = new EBorderStyle("groove");
    public static final EBorderStyle Ridge = new EBorderStyle("ridge");
    public static final EBorderStyle Inset = new EBorderStyle("inset");
    public static final EBorderStyle Outset = new EBorderStyle("outset");




    private final String value;




    private EBorderStyle(String value) {
        super();
        this.value = value;
    }
    



    public String toCss() {
        return this.value;
    }

}