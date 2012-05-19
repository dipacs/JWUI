package eu.xibit.jwui;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.fileupload.FileItem;

/**
 * This class holds some informations from an uploaded file.
 * 
 * @author dipacs
 */
public final class UploadedFile {
    
    private final FileItem fileItem;

    
    
    
    UploadedFile(FileItem fileItem) {
        this.fileItem = fileItem;
    }

    
    
    /**
     * Copy the uploaded file to the given file.
     * 
     * @param file
     * The target file.
     * 
     * @throws Exception 
     * If the copy isn't success.
     */
    public void copy(File file) throws Exception {
        fileItem.write(file);
    }

    /**
     * Returns the size of the file in bytes.
     * 
     * @return 
     * The size of the file in bytes.
     */
    public long getSize() {
        return fileItem.getSize();
    }

    /**
     * Returns the name of the file.
     * 
     * @return 
     * The name of the file.
     */
    public String getName() {
        return fileItem.getName();
    }

    /**
     * Returns the input stream which can be used to read the content of the file.
     * 
     * @return
     * the input stream which can be used to read the content of the file.
     * 
     * @throws IOException 
     * If something is went wrong.
     */
    public InputStream getInputStream() throws IOException {
        return fileItem.getInputStream();
    }

    /**
     * Returns the name of the html input tag which uploads this file.
     * 
     * @return 
     * the name of the html input tag which uploads this file.
     */
    public String getFieldName() {
        return fileItem.getFieldName();
    }

    /**
     * Returns the content type of the file eg.: text/html.
     * 
     * @return 
     * the content type of the file eg.: text/html.
     */
    public String getContentType() {
        return fileItem.getContentType();
    }

    /**
     * Returns all the bytes of the file's content as a byte array.
     * 
     * @return 
     * all the bytes of the file's content as a byte array.
     */
    public byte[] getBytes() {
        return fileItem.get();
    }

    /**
     * Deletes this file from the temporary storage.
     */
    public void delete() {
        fileItem.delete();
    }
    
}
