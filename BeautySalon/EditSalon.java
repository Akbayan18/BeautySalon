package kz.baibalaeva.success;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/editSalon")
public class EditSalon extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/editSalon.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String red= "/editSalon?error";
        Long id = Long.valueOf(req.getParameter("id"));
        String hair = req.getParameter("hair");
        int price= Integer.parseInt(req.getParameter("price"));
        String master = req.getParameter("master");
        Salon salon = new Salon();
        salon.setId(id);
        salon.setHair(hair);
        salon.setPrice(price);
        salon.setMaster(master);
        if (DBManager.updateSalon(salon)){
            red="/homeSalon";
        }
        resp.sendRedirect(red);
    }
}
