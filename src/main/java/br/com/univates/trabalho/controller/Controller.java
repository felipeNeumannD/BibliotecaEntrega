/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.com.univates.trabalho.controller;


import br.com.univates.trabalho.acao.post.AlteraLivro;
import br.com.univates.trabalho.acao.post.Alugar;
import br.com.univates.trabalho.acao.post.CriarConta;
import br.com.univates.trabalho.acao.post.Devolver;
import br.com.univates.trabalho.acao.post.ExcluiLivro;
import br.com.univates.trabalho.acao.Executer;
import br.com.univates.trabalho.acao.get.ListaReserva;
import br.com.univates.trabalho.acao.get.ListarDisponivel;
import br.com.univates.trabalho.acao.post.Login;
import br.com.univates.trabalho.acao.get.ModificaLivro;
import br.com.univates.trabalho.acao.get.PesquisaAlt;
import br.com.univates.trabalho.acao.get.PesquisaHistorico;
import br.com.univates.trabalho.acao.post.AdicionaLivro;
import br.com.univates.trabalho.acao.get.MostrarModUsuario;
import br.com.univates.trabalho.acao.post.AlterarPessoa;
import br.com.univates.trabalho.acao.post.Logout;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 *
 * @author Felipe
 */
@WebServlet(name = "Controller", urlPatterns = {"/controlador", "/login","/erro", "/criarConta","/ListaReserva", "/devolver", "/listarSemAluguel", "/alugar", "/listarDisponivel", "/pesquisaHistorico",
    "/pesquisaAlt", "/alteraLivro", "/excluiLivro", "/ModificarLivro", "/AdicionaLivro", "/MostrarUsuario", "/AlterarPessoa", "/LogOut"}, 
        initParams = {@WebInitParam(name = "Name", value = "Value")})
public class Controller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controller</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controller at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        
            switch (action) {
            case "/ListaReserva":
                ListaReserva listaReserva = new ListaReserva();
                Executer.executar(listaReserva, request, response);
                break;

            case "/listarDisponivel":
                ListarDisponivel listarDisponivel = new ListarDisponivel();
                Executer.executar(listarDisponivel, request, response);
                break;

            case "/pesquisaHistorico":
                PesquisaHistorico pesquisaHistorico = new PesquisaHistorico();
                Executer.executar(pesquisaHistorico, request, response);
                break;

            case "/pesquisaAlt":
                PesquisaAlt pesquisaAlt = new PesquisaAlt();
                Executer.executar(pesquisaAlt, request, response);
                break;
                
            case "/MostrarUsuario":
                MostrarModUsuario modificarUsuario = new MostrarModUsuario();
                Executer.executar(modificarUsuario, request, response);
                break;    
            default:
                break;
        }
    }

   
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        
            switch (action) {
            case "/login":
                Login login = new Login();
                Executer.executar(login, request, response);
                break;

            case "/criarConta":
                CriarConta criarConta = new CriarConta();
                Executer.executar(criarConta, request, response);
                break;

            case "/devolver":
                Devolver devolver = new Devolver();
                Executer.executar(devolver, request, response);
                break;

            case "/alugar":
                Alugar alugar = new Alugar();
                Executer.executar(alugar, request, response);
                break;

            case "/alteraLivro":
                AlteraLivro alteraLivro = new AlteraLivro();
                Executer.executar(alteraLivro, request, response);
                break;

            case "/excluiLivro":
                ExcluiLivro excluiLivro = new ExcluiLivro();
                Executer.executar(excluiLivro, request, response);
                break;

            case "/ModificarLivro":
                ModificaLivro modificaLivro = new ModificaLivro();
                Executer.executar(modificaLivro, request, response);
                break;
                
            case "/AdicionaLivro":
                AdicionaLivro adicionaLivro = new AdicionaLivro();
                Executer.executar(adicionaLivro, request, response);
                break;
            
            case "/AlterarPessoa":
                AlterarPessoa alterarPessoa = new AlterarPessoa();
                Executer.executar(alterarPessoa, request, response);
             
            default:
                break;
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
