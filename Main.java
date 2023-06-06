
import etu1816.framework.*;
import etu1816.framework.servlet.*;

public class Main {
    public static void main(String[] args) {

        FrontServlet frontServlet = new FrontServlet();
        frontServlet.init();

        String url = "/EmpAll";
        Mapping mapping = frontServlet.getMapping(url);
        if (mapping != null) {
            System.out.println("Class: " + mapping.getClassName());
            System.out.println("Method: " + mapping.getMethod());
        } else {
            System.out.println("No mapping found for URL: " + url);
        }
    }
}
