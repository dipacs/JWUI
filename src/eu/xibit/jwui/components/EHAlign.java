package eu.xibit.jwui.components;

public final class EHAlign {

    public static final EHAlign Left = new EHAlign(0, "left");
    public static final EHAlign Center = new EHAlign(1, "center");
    public static final EHAlign Right = new EHAlign(2, "right");




    private final int value;
    private final String css;




    private EHAlign (int value, String css) {
        super();
        this.value = value;
        this.css = css;
    }




    @Override
    public String toString() {
        return this.css;
    }

}