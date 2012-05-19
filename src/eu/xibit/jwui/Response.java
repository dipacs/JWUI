/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.xibit.jwui;

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
    
}
