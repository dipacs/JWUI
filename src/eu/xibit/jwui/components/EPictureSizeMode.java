package eu.xibit.jwui.components;


public class EPictureSizeMode {

    public static final EPictureSizeMode Normal = new EPictureSizeMode(0);

    public static final EPictureSizeMode Center = new EPictureSizeMode(1);

    public static final EPictureSizeMode Stretch = new EPictureSizeMode(2);

    public static final EPictureSizeMode FitWidth = new EPictureSizeMode(3);

    public static final EPictureSizeMode FitHeight = new EPictureSizeMode(4);

    public static final EPictureSizeMode Fill = new EPictureSizeMode(5);

    public static final EPictureSizeMode Zoom = new EPictureSizeMode(6);




    private final int value;




    private EPictureSizeMode(int value) {
        super();
        this.value = value;
    }

}