package eu.xibit.jwui;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.fileupload.FileItem;

public final class UploadedFile {
    
    private final FileItem fileItem;

    
    
    
    UploadedFile(FileItem fileItem) {
        this.fileItem = fileItem;
    }

    
    
    
    public void write(File file) throws Exception {
        fileItem.write(file);
    }

    public long getSize() {
        return fileItem.getSize();
    }

    public String getName() {
        return fileItem.getName();
    }

    public InputStream getInputStream() throws IOException {
        return fileItem.getInputStream();
    }

    public String getFieldName() {
        return fileItem.getFieldName();
    }

    public String getContentType() {
        return fileItem.getContentType();
    }

    public byte[] get() {
        return fileItem.get();
    }

    public void delete() {
        fileItem.delete();
    }
    
}
