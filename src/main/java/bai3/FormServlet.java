package bai3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/form/update")
public class FormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        User bean = new User();
        bean.setFullname("Nguyễn Văn Tèo");
        bean.setGender(true);
        bean.setCountry("VN");
        
        req.setAttribute("user", bean);
        req.setAttribute("editabled", true);
        req.getRequestDispatcher("/bai_3/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String fullname = req.getParameter("fullname");
        System.out.println("Fullname: " + fullname);
        
        // Re-set attributes to maintain form state if needed, or just forward
        // For simplicity as per instruction:
        req.getRequestDispatcher("/bai_3/form.jsp").forward(req, resp);
    }
}
