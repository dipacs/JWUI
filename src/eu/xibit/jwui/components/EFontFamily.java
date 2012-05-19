package eu.xibit.jwui.components;

public class EFontFamily {

    public static final EFontFamily Georgia = new EFontFamily("Georgia, serif");
    public static final EFontFamily PalatinoLinotype = new EFontFamily("'Palatino Linotype', 'Book Antiqua', Palatino, serif");
    public static final EFontFamily TimesNewRoman = new EFontFamily("'Times New Roman', Times, serif");
    public static final EFontFamily Arial = new EFontFamily("Arial, Helvetica, sans-serif");
    public static final EFontFamily ArialBlack = new EFontFamily("Arial Black, Gadget, sans-serif");
    public static final EFontFamily ComicSansMS = new EFontFamily("'Comic Sans MS', cursive, sans-serif");
    public static final EFontFamily Impact = new EFontFamily("Impact, Charcoal, sans-serif");
    public static final EFontFamily Lucida = new EFontFamily("'Lucida Sans Unicode', 'Lucida Grande', sans-serif");
    public static final EFontFamily Tahoma = new EFontFamily("Tahoma, Geneva, sans-serif");
    public static final EFontFamily TrebuchetMS = new EFontFamily("'Trebuchet MS', Helvetica, sans-serif");
    public static final EFontFamily Verdana = new EFontFamily("Verdana, Geneva, sans-serif");
    public static final EFontFamily CourierNew = new EFontFamily("'Courier New', Courier, monospace");
    public static final EFontFamily LucidaConsole = new EFontFamily("'Lucida Console', Monaco, monospace");

    

    private final String family;




    private EFontFamily(String family) {
        super();
        this.family = family;
    }




    public String getFamily() {
        return this.family;
    }

}