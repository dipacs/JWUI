/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.xibit.jwui;

import java.io.IOException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dipacs
 */
public class Response {
    
    private final HttpServletResponse response;

    
    
    
    Response(HttpServletResponse response) {
        this.response = response;
    }

    
    
    
    public void setContentType(String type) {
        response.setContentType(type);
    }

    public void setCharacterEncoding(String charset) {
        response.setCharacterEncoding(charset);
    }

    public String getContentType() {
        return response.getContentType();
    }

    public String getCharacterEncoding() {
        return response.getCharacterEncoding();
    }

    public void setStatus(int sc) {
        response.setStatus(sc);
    }

    public void sendRedirect(String location) throws IOException {
        response.sendRedirect(location);
    }

    public void sendError(int sc) throws IOException {
        response.sendError(sc);
    }

    public void sendError(int sc, String msg) throws IOException {
        response.sendError(sc, msg);
    }

    public void addHeader(String name, String value) {
        response.addHeader(name, value);
    }

    public void addCookie(Cookie cookie) {
        response.addCookie(cookie);
    }
    
}
