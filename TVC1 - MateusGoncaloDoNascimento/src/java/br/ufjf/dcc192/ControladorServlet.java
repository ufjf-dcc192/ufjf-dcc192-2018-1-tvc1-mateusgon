package br.ufjf.dcc192;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Controlador", urlPatterns = {"/controlador.html", "/cadastrar.html", "/erro.html", "/confirmacao.html", "/inscritos.html", "/senhaadm.html", "/inscritosadm.html", "/modificar.html", "/excluir.html"})
public class ControladorServlet extends HttpServlet {

    String loginAdm = "admin";
    String senhaAdm = "admin";
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("operacaoAdicionarParticipante") != null)
        {
            Integer pe = -1;
            Integer idTipo = Integer.parseInt(request.getParameter("itens"));
            String nome = request.getParameter("nome");
            String disponibilidade = request.getParameter("disponibilidade");
            if (request.getParameter("dias").equals(""))
            {
                response.sendRedirect("erro.html");
                return;
            }
            Integer dias = Integer.parseInt(request.getParameter("dias"));
            String email = request.getParameter("email");
            String login = request.getParameter("login");
            String senha = request.getParameter("senha");
            if ((!"".equals(nome)) && (!"".equals(disponibilidade)) && (!"".equals(login)) && (!"".equals(senha)) && (!"".equals(email)))
            {
                String qualificacao = "Erro";
                if (idTipo == 0)
                {
                    qualificacao = "Intercambista";
                    int id=0;
                    List<Pessoa> pessoas = ListaDeParticipantes.getIntercambista();
                    for (Pessoa pessoa : pessoas) {
                        id = pessoa.getId();
                    }
                    id++;
                    Pessoa p = new Pessoa(id, nome, disponibilidade, dias, login, senha, email);
                    p.setQualificacao(qualificacao);
                    pe = p.getId();
                    ListaDeParticipantes.getIntercambista().add(p);
                }
                    if (idTipo == 1)
                    {
                        qualificacao = "Docente";
                                            int id=0;
                        List<Pessoa> pessoas = ListaDeParticipantes.getDocente();
                        for (Pessoa pessoa : pessoas) {
                        id = pessoa.getId();
                        }
                        id++;
                        Pessoa p = new Pessoa(id, nome, disponibilidade, dias, login, senha, email);
                        p.setQualificacao(qualificacao);
                        pe = p.getId();
                        ListaDeParticipantes.getDocente().add(p);
                    }
                    if (idTipo == 2)
                    {
                        qualificacao = "TAE";
                                            int id=0;
                        List<Pessoa> pessoas = ListaDeParticipantes.getTAE();
                        for (Pessoa pessoa : pessoas) {
                            id = pessoa.getId();
                        }
                        id++;
                        Pessoa p = new Pessoa(id, nome, disponibilidade, dias, login, senha, email);
                        p.setQualificacao(qualificacao);
                        pe = p.getId();
                        ListaDeParticipantes.getTAE().add(p);
                    }
                    if (idTipo == 3)
                    {
                        qualificacao = "Aluno";
                                            int id=0;
                        List<Pessoa> pessoas = ListaDeParticipantes.getEstudante();
                        for (Pessoa pessoa : pessoas) {
                            id = pessoa.getId();
                        }
                        id++;
                        Pessoa p = new Pessoa(id, nome, disponibilidade, dias, login, senha, email);
                        p.setQualificacao(qualificacao);
                        pe = p.getId();
                        ListaDeParticipantes.getEstudante().add(p);
                    }
                response.sendRedirect("confirmacao.html?codigo="+idTipo+"&codigo2="+pe+"");
            }
            else
            {
                response.sendRedirect("erro.html");
            }
        }
        if (request.getParameter("operacaoVerTodosInscritos") != null)
        {
            String email = request.getParameter("login");
            String senha = request.getParameter("senha");
            if (loginAdm.equals(email) && senhaAdm.equals(senha))
            {
                response.sendRedirect("inscritosadm.html");
            }
            else
            {
                response.sendRedirect("erro.html");
            }
        }
        if (request.getParameter("operacaoSenha") != null)
        {
            String email = request.getParameter("login");
            String senha = request.getParameter("senha");
            Integer id = Integer.parseInt(request.getParameter("pessoa"));
            Integer id2 = Integer.parseInt(request.getParameter("tipoP"));
            if (id2 == 0)
            {
                Pessoa p = ListaDeParticipantes.getIntercambista().get(id);
                if (p.getLogin().equals(email) && p.getSenha().equals(senha))
                {
                    ListaDeParticipantes.getIntercambista().remove(p);
                                    response.sendRedirect("controlador.html");
                }
            }
            if (id2 == 1)
            {
                Pessoa p = ListaDeParticipantes.getDocente().get(id);
                if (p.getLogin().equals(email) && p.getSenha().equals(senha))
                {
                    ListaDeParticipantes.getDocente().remove(p);
                                    response.sendRedirect("controlador.html");
                }
            }
            if (id2 == 2)
            {
                Pessoa p = ListaDeParticipantes.getTAE().get(id);
                if (p.getLogin().equals(email) && p.getSenha().equals(senha))
                {
                    ListaDeParticipantes.getTAE().remove(p);
                                    response.sendRedirect("controlador.html");
                }
            }
            if (id2 == 3)
            {
                Pessoa p = ListaDeParticipantes.getEstudante().get(id);
                if (p.getLogin().equals(email) && p.getSenha().equals(senha))
                {
                    ListaDeParticipantes.getEstudante().remove(p);
                                    response.sendRedirect("controlador.html");
                }
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
       if ("/confirmacao.html".equals(request.getServletPath()))
       {
           listarConfirmacaoCadastro(request, response);
       }
       if ("/inscritos.html".equals(request.getServletPath()))
       {
           listarInscritos(request, response);
       }
       if ("/senhaadm.html".equals(request.getServletPath()))
       {
           listarSenha(request, response);
       }
       if ("/inscritosadm.html".equals(request.getServletPath()))
       {
           listarInscritosAdm(request, response);
       }
       if ("/excluir.html".equals(request.getServletPath()))
       {
           excluirParticipante(request, response);
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

    private void listarConfirmacaoCadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idTipo = Integer.parseInt(request.getParameter("codigo"));
        int codigoPessoa = Integer.parseInt(request.getParameter("codigo2"));
        if (idTipo == 0)
        {
            Pessoa p = ListaDeParticipantes.getIntercambista().get(codigoPessoa);
            request.setAttribute("pessoa", p);
        }
        if (idTipo == 1)
        {
            Pessoa p = ListaDeParticipantes.getDocente().get(codigoPessoa);
            request.setAttribute("pessoa", p);
        }
        if (idTipo == 2)
        {
            Pessoa p = ListaDeParticipantes.getTAE().get(codigoPessoa);
            request.setAttribute("pessoa", p);
        }
        if (idTipo == 3)
        {
            Pessoa p = ListaDeParticipantes.getEstudante().get(codigoPessoa);
            request.setAttribute("pessoa", p);   
        }
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/verconfirmacao.jsp");
        despachante.forward(request, response);
    }

    private void listarInscritos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            List<Pessoa> estudante = ListaDeParticipantes.getEstudante();
            List<Pessoa> TAE = ListaDeParticipantes.getTAE();
            List<Pessoa> intercambista = ListaDeParticipantes.getIntercambista();
            List<Pessoa> docente = ListaDeParticipantes.getDocente();
            request.setAttribute("estudantes", estudante);
            request.setAttribute("taes", TAE);
            request.setAttribute("intercambistas", intercambista);
            request.setAttribute("docents", docente);
            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/verparticipantes.jsp");
            despachante.forward(request, response);
    }

    private void listarInscritosAdm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           List<Pessoa> estudante = ListaDeParticipantes.getEstudante();
           List<Pessoa> TAE = ListaDeParticipantes.getTAE();
           List<Pessoa> intercambista = ListaDeParticipantes.getIntercambista();
           List<Pessoa> docente = ListaDeParticipantes.getDocente();
           request.setAttribute("estudantes", estudante);
           request.setAttribute("taes", TAE);
           request.setAttribute("intercambistas", intercambista);
           request.setAttribute("docents", docente);
           RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/vertodosparticipantes.jsp");
           despachante.forward(request, response);
    }

    private void listarSenha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/senha.jsp");
        despachante.forward(request, response);
    }

    private void excluirParticipante(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int codigoPessoa = Integer.parseInt(request.getParameter("codigo"));
        int idTipo = Integer.parseInt(request.getParameter("codigo2"));
        request.setAttribute("codigoPessoa", codigoPessoa);
        request.setAttribute("idTipo", idTipo);
        if (idTipo == 0)
        {
            Pessoa p = ListaDeParticipantes.getIntercambista().get(codigoPessoa);
            request.setAttribute("pessoa", p);
        }
        if (idTipo == 1)
        {
            Pessoa p = ListaDeParticipantes.getDocente().get(codigoPessoa);
            request.setAttribute("pessoa", p);
        }
        if (idTipo == 2)
        {
            Pessoa p = ListaDeParticipantes.getTAE().get(codigoPessoa);
            request.setAttribute("pessoa", p);
        }
        if (idTipo == 3)
        {
            Pessoa p = ListaDeParticipantes.getEstudante().get(codigoPessoa);
            request.setAttribute("pessoa", p);   
        }
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/senhaExcluir.jsp");
        despachante.forward(request, response);
    }
    
}
