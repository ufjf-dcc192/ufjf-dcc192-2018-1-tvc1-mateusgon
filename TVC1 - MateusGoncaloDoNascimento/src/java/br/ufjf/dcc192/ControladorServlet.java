package br.ufjf.dcc192;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Controlador", urlPatterns = {"/controlador.html", "/cadastrar.html", "/erro.html"})
public class ControladorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("operacaoAdicionarParticipante") != null)
        {
            Integer idTipo = Integer.parseInt(request.getParameter("itens"));
            String nome = request.getParameter("nome");
            String disponibilidade = request.getParameter("disponibilidade");
            Integer dias = Integer.parseInt(request.getParameter("dias"));
            String login = request.getParameter("login");
            String senha = request.getParameter("senha");
            if (idTipo != null && nome != null && disponibilidade != null && dias != null && login != null && senha != null)
            {
                String qualificacao = "Erro";
                if (idTipo == 0)
                {
                    qualificacao = "Intercambista";
                    Integer id = ListaDeParticipantes.getIntercambista().size();
                    Pessoa p = new Pessoa(id, nome, disponibilidade, dias, login, senha);
                    p.setQualificacao(qualificacao);
                    ListaDeParticipantes.getIntercambista().add(p);
                }
                    if (idTipo == 1)
                    {
                        qualificacao = "Docente";
                        Integer id = ListaDeParticipantes.getDocente().size();
                        Pessoa p = new Pessoa(id, nome, disponibilidade, dias, login, senha);
                        p.setQualificacao(qualificacao);
                        ListaDeParticipantes.getDocente().add(p);
                    }
                    if (idTipo == 2)
                    {
                        qualificacao = "TAE";
                        Integer id = ListaDeParticipantes.getTAE().size();
                        Pessoa p = new Pessoa(id, nome, disponibilidade, dias, login, senha);
                        p.setQualificacao(qualificacao);
                        ListaDeParticipantes.getTAE().add(p);
                    }
                    if (idTipo == 3)
                    {
                        qualificacao = "Aluno";
                        Integer id = ListaDeParticipantes.getEstudante().size();
                        Pessoa p = new Pessoa(id, nome, disponibilidade, dias, login, senha);
                        p.setQualificacao(qualificacao);
                        ListaDeParticipantes.getEstudante().add(p);
                    }
                response.sendRedirect("controlador.html");
            }
            else
            {
                response.sendRedirect("erro.html");
            }
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       if ("/controlador.html".equals(request.getServletPath()))
       {
           listarInicio(request, response);           
       }
       if ("/cadastrar.html".equals(request.getServletPath()))
       {
           listarCadastro(request, response);
       }
       if ("/erro.html".equals(request.getServletPath()))
       {
           listarErro(request, response);
       }
    }

    private void listarInicio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/listarFuncionamento.jsp");
        despachante.forward(request, response);
    }

    private void listarCadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/fichaDeCadastro.jsp");
        despachante.forward(request, response);
    }

    private void listarErro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/erro.jsp");
        despachante.forward(request, response);
    }
}
