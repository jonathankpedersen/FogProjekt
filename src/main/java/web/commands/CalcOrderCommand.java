package web.commands;

import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalcOrderCommand extends CommandProtectedPage{
    public CalcOrderCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){
        Double width = Double.parseDouble(request.getParameter("width"));
        Double length = Double.parseDouble(request.getParameter("length"));
        Double numBeams = 0.0;
        Double posts = 0.0;
        if(Math.ceil(length/55)+1 > Math.ceil(length/60)+1){
            numBeams = Math.ceil(length/60)+1;
        }else{
            numBeams = Math.ceil(length/55)+1;
        }

        if(length < 6.0){
            posts = 4.0;
        }else{
            posts = 6.0;
        }

        if(width > 6.0){
            posts = posts*1.5;
        }

        Double uni190mm = numBeams*2; //total mængde, unviversal 190mm beslag har både højre er forskellig fra venstre
        Double beslagSkruer = Math.ceil((uni190mm*9)/250);
        return pageToShow;
    }
}
