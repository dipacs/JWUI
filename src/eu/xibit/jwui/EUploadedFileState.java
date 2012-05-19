package eu.xibit.jwui;

public class EUploadedFileState {

    public static final EUploadedFileState Ok = new EUploadedFileState(0);
    
    public static final EUploadedFileState ErrorIniSize = new EUploadedFileState(1);

    public static final EUploadedFileState ErrorFormSize = new EUploadedFileState(2);

    public static final EUploadedFileState ErrorPartial = new EUploadedFileState(3);

    public static final EUploadedFileState ErrorNoFile = new EUploadedFileState(4);

    private final int value;

    private EUploadedFileState(int value) {
        super();
        this.value = value;
    }

}