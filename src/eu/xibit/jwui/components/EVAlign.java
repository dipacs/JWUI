package eu.xibit.jwui.components;

public final class EVAlign {

    public static final EVAlign Top = new EVAlign(0, "top");

    public static final EVAlign Middle = new EVAlign(1, "middle");

    public static final EVAlign Bottom = new EVAlign(2, "bottom");




    private final int value;
    private final String css;




    private EVAlign (int value, String css) {
        super();
        this.value = value;
        this.css = css;
    }




    @Override
    public String toString() {
        return this.css;
    }

}