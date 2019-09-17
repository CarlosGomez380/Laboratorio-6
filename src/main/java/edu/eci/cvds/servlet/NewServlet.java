package edu.eci.cvds.servlet;

import edu.eci.cvds.servlet.model.Todo;

import java.io.*;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import static javafx.beans.binding.Bindings.convert;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
    urlPatterns = "/thisServlet"
)

public class NewServlet extends HttpServlet{
    private List<Todo> todoList = new ArrayList<>();
     
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer responseWriter = resp.getWriter();
        try{
            String param= req.getParameter("id");
            int result = Integer.parseInt(param);
            todoList.add(Service.getTodo(result));
            responseWriter.write(Service.todosToHTMLTable(todoList));
        }
        catch(MalformedURLException e){
            resp.setStatus(HttpServletResponse.	SC_INTERNAL_SERVER_ERROR);
        }
        catch(FileNotFoundException e){
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        catch(NumberFormatException | IOException e ){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        
   }
    
   @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        Writer responseWriter = resp.getWriter();
        try{
            String param= req.getParameter("id");
            int result = Integer.parseInt(param);
            todoList.add(Service.getTodo(result));
            responseWriter.write(Service.todosToHTMLTable(todoList));
        }
        catch(MalformedURLException e){
            resp.setStatus(HttpServletResponse.	SC_INTERNAL_SERVER_ERROR);
        }
        catch(FileNotFoundException e){
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        catch(NumberFormatException | IOException e ){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

    }
}
