package com.rasstek.gestionproduits.mesServlets;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

import com.rasstek.gestionproduits.mesModels.Produit;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "listServlet", value = "/listproduits")
public class ListProduitsServlet extends HttpServlet {

    private List<Produit> listeproduits;
    public List<Produit> getListeproduits() {
        return listeproduits;
    }
    @Override
    public void init(){
        listeproduits= new ArrayList<Produit>(){
            {
                add(new Produit(1,"Stylo Mont Blanc",110.99));
                add(new Produit(2,"Crayon",2.50));
                add(new Produit(3,"Cahier",4.99));
                add(new Produit(4,"Efface",5.00));
            }
        };
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private void processRequest(HttpServletRequest request, HttpServletResponse response)//methode qui va etre appeler par doGet et doPost
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // vérifier s'il ne s'agit pas du premier appel
        if(request.getParameter("numero")!=null){
            int num=Integer.parseInt(request.getParameter("numero"));
            // rechercher le produit de la liste
            Produit produit= this.listeproduits.stream().filter(p->p.getNumero()==num).findFirst().get();
            // supprimer le produit trouvé
            this.listeproduits.remove(produit);
        }
        //ajouter la liste a l<objet request
        request.setAttribute("listeproduits", this.listeproduits);
//rediriger vers las vue
        String destination = "listProduits.jsp";//creer une variable destination qui va contenir le chemin de la vue
        request.getRequestDispatcher(destination).forward(request, response);



    }
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }




}