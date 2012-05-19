package eu.xibit.jwui.components;

public final class EOverflowType {

    public static final EOverflowType Hidden = new EOverflowType("hidden");

    public static final EOverflowType Visible = new EOverflowType("visible");

    public static final EOverflowType Scroll = new EOverflowType("scroll");

    public static final EOverflowType AutoScroll = new EOverflowType("auto");




    private final String value;




    private EOverflowType(String value) {
        super();
        this.value = value;
    }




    public String toCss() {
        return this.value;
    }

}