package gov.va.ascent.document;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Controller
public class DocumentServiceHomeController {

    @RequestMapping("/")
    public void home(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	response.sendRedirect(ServletUriComponentsBuilder.fromCurrentContextPath().path("/swagger-ui.html").build().toUriString());
    }
}
