package ui.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Overview extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        // als overview getoond wordt na toevoegen:
        // dier dat net toegevoegd werd uitlezen en wegschrijven naar request attribuut
        HttpSession session = request.getSession();
        request.setAttribute("last" , session.getAttribute("lastAddedAnimal"));
        // session attribuut cancellen want anders blijft het er staan bij elke overview
        session.setAttribute("lastAddedAnimal",null);

        // eigenlijke overzicht
        request.setAttribute("animals", service.getAllAnimals());
        return "overview.jsp";

    }
}
