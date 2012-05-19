/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.xibit.jwui;

import eu.xibit.jwui.components.AComponent;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class is the base class of all the JWUI pages. You need to create a servlet which inherited from this class.
 * In you servlet class, overwrite initPage(...) abstract method, and create your UI as you want. A hello world page 
 * may looks like this: 
 * <p><pre><code>
 * public class JwuiTest extends APage {
 * 
 *     protected void initPage(Request request, Response response) {
 *         // creating a label
 *         Label lbl = new Label();
 *         
 *         // setting propertyes of the label
 *         lbl.setText("Hello Wrold!");
 *         lbl.setFontFamily(EFontFamily.ComicSansMS);
 *         lbl.setFontSize(32);
 * 
 *         // adding the label as the root component of this page
 *         this.setRootComponent(lbl);
 *     }
 * }
 * </code></pre></p>
 * @author dipacs
 */
public abstract class APage extends HttpServlet {

    private AComponent rootComponent;
    private final List<String> javaScriptIncludes = new ArrayList<>();
    private String title = "Untitled Document";

    
    
    
    @Override
    protected final void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        initPage(new Request(req), new Response(resp));
        if (rootComponent != null) {
            PrintWriter out = resp.getWriter();
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html;charset=UTF-8");

            out.println("<!DOCTYPE html>");
            out.println("<html><head>");
            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
            String t = this.title;
            if (t == null || t.equals("")) {
                t = "Untitled Document";
            }
            out.println("<title>" + t + "</title>");
            for (String scriptUrl : javaScriptIncludes) {
                out.println("<script type=\"text/javascript\" src=\"" + scriptUrl + "\"></script>");
            }
            /*
             * <script type="text/javascript" src="ABC.js"></script>
             */
            
            out.println("</head><body style=\"margin:0;padding:0;\">");
            out.println(rootComponent.render());
            out.println("</body></html>");
            out.close();
        }
    }

    @Override
    protected final void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
    
    @Override
    public final String getServletInfo() {
        String title = this.getTitle();
        if (title == null || title.equals("")) {
            title = "Untitled Document";
        }
        return "JWUI page: " + title;
    }

    
    
    /**
     * Returns the root component of this page.<br/>
     * The root component of the page is the component which is rendered. In the most of the cases this will be some kind of 
     * container.
     * 
     * @return 
     * The root component of this page.
     */
    public AComponent getRootComponent() {
        return rootComponent;
    }

    /**
     * Sets the root component of the page.<br/>
     * The root component of the page is the component which is rendered. In the most of the cases this will be some kind of 
     * container.
     * 
     * @param rootComponent 
     * The new root component.
     */
    public void setRootComponent(AComponent rootComponent) {
        this.rootComponent = rootComponent;
    }

    /**
     * Returns the list of the included JavaScript (.js) files. You can add your own JavaScript which will be included to the html page.<br/>
     * Just put the url and name of your javascript file. Eg.: if your javascript has the name myscript.js and it's in the scripts folder in the webroot,
     * then add the "scripts/myscript.js" to the list.
     * 
     * @return 
     * The list of the included JavaScript (.js) files.
     */
    public List<String> getJavaScriptIncludes() {
        return javaScriptIncludes;
    }

    /**
     * Returns the title of this page.
     * <p>
     * The title of the page is visible on the browser's title bar. If the title is null or empty string, than 
     * "Untitled Document" will be the title of your page.
     * </p>
     * 
     * @return 
     * The title of this page.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of this page.
     * <p>
     * The title of the page is visible on the browser's title bar. If the title is null or empty string, than 
     * "Untitled Document" will be the title of your page.
     * </p>
     * 
     * @param title 
     * The new title of this page.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    
    
    /**
     * This method is invoked every time when this page is requested. You need to override this method and construct your
     * UI in this method.
     * <p>
     * Do not forget to set the root component of this page using the setRootComponent(...) method. Without this, your page will be empty.
     * </p>
     * 
     * @param request
     * The request parameters of the page.
     * @param response 
     * The response object which can be used to set response parameters (eg.: headers and cookies).
     */
    protected abstract void initPage(Request request, Response response);
}
