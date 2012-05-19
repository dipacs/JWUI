package eu.xibit.jwui.components;

public final class EHAlign {

    public static final EHAlign left = new EHAlign(0, "left");

    public static final EHAlign center = new EHAlign(1, "center");

    public static final EHAlign right = new EHAlign(2, "right");




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