package org.example.servlet;

import org.example.model.FileElement;
import org.example.service.FileService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/files")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String pathFromRequest = req.getParameter("path");
        if (req.getParameter("path") == null) {
            pathFromRequest = new File(".").getCanonicalPath();
        }

        req.setAttribute("currentDir", pathFromRequest);
        req.setAttribute("list",
                FileService.getElements(new File(pathFromRequest)));

        String parentDirPath = new File(pathFromRequest).getParent();
        if (parentDirPath == null) {
            parentDirPath = pathFromRequest;
        }
        req.setAttribute("parentDirPath", parentDirPath);

        Date generationDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yy HH:mm:ss");

        req.setAttribute("generationTime", dateFormat.format(generationDate));
        req.getRequestDispatcher("mypage.jsp").forward(req, resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    public void destroy() {
    }
}
