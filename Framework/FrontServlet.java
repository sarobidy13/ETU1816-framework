package etu1816.framework.servlet;

import etu1816.framework.*;
import etu1816.framework.Mapping;
import etu1816.framework.MethodAnnotation.*;
import fonction.*;
import model.*;

import java.util.HashMap;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.*;
import java.lang.reflect.Method;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FrontServlet extends HttpServlet {
    Util util = new Util();
    HashMap<String, Mapping> MappingUrls = new HashMap<String, Mapping>();
    HashMap<String, Mapping> mappingHashMap = new HashMap<String, Mapping>();

    public FrontServlet() {
        mappingHashMap = new HashMap<>();
    }

    public void init() {
        Class<?>[] classes = { Emp.class };

        for (Class<?> clazz : classes) {
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                Annotation annotation = method.getAnnotation(Annotation.class);
                if (annotation != null) {
                    String url = annotation.url();

                    Mapping mapping = new Mapping();
                    mapping.setClassName(clazz.getSimpleName());
                    mapping.setMethod(method.getName());

                    mappingHashMap.put(url, mapping);
                }
            }
        }
    }

    public Mapping getMapping(String url) {
        return mappingHashMap.get(url);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = request.getRequestURI();
        String valiny = util.getURL(url);
        out.println("URL:" + valiny);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
