/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.xibit.jwui;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author dipacs
 */
public class Request {

    private final HttpServletRequest request;
    private final HashMap<String, UploadedFile> files = new HashMap<>();

    Request(HttpServletRequest request) {
        this.request = request;
        
        // getting files
        try {
            List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
            for (FileItem item : items) {
                if (item.isFormField()) {
                    // simple filed, do nothing
                } else {
                    // file item
                    files.put(item.getFieldName(), new UploadedFile(item));
                }
            }
        } catch (FileUploadException e) {
            // TODO valami hibakezelés
        }
    }

    
    
    
    public int getServerPort() {
        return request.getServerPort();
    }

    public String getServerName() {
        return request.getServerName();
    }

    public String getRemoteHost() {
        return request.getRemoteHost();
    }

    public String getRemoteAddr() {
        return request.getRemoteAddr();
    }

    public Enumeration<String> getParameterNames() {
        return request.getParameterNames();
    }

    public String getParameter(String name) {
        return request.getParameter(name);
    }

    public String getRequestURI() {
        return request.getRequestURI();
    }

    public String getMethod() {
        return request.getMethod();
    }

    public Enumeration<String> getHeaderNames() {
        return request.getHeaderNames();
    }

    public String getHeader(String name) {
        return request.getHeader(name);
    }

    public Cookie[] getCookies() {
        return request.getCookies();
    }

    public UploadedFile getFile(String key) {
        return files.get(key);
    }
    
    public List<String> getFileKeys() {
        ArrayList<String> res = new ArrayList<>();
        res.addAll(files.keySet());
        return res;
    }
    
    public List<UploadedFile> getFiles() {
        ArrayList<UploadedFile> res = new ArrayList<>();
        res.addAll(files.values());
        return res;
    }
    
    
}
