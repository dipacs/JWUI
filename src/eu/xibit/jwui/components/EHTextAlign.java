package eu.xibit.jwui.components;

public final class EHTextAlign {

    public static final EHTextAlign Left = new EHTextAlign(0, "left");

    public static final EHTextAlign Center = new EHTextAlign(1, "center");

    public static final EHTextAlign Right = new EHTextAlign(2, "right");

    public static final EHTextAlign Justify = new EHTextAlign(3, "justify");




    private final int value;
    private final String css;




    private EHTextAlign(int value, String css) {
        super();
        this.value = value;
        this.css = css;
    }


public String toString() {
        return this.css;
    }

}