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
        double width = Double.parseDouble(request.getParameter("width"));
        double length = Double.parseDouble(request.getParameter("length"));
        double numBeams = Math.ceil(length/60)+1;
        double beamLength = 0.0;
        double postsX = 0.0;
        double postsY = 0.0;
        double postsTotal = 0.0;
        double bolt = 0.0;
        double Plastmo1 = 0.0; //600mm
        double Plastmo2 = 0.0; //360mm
        float fald = calculateTriangle(length);
        double roofWidth = 109;

        if(fald > 6){
            roofWidth = 102;
        }else{
            roofWidth = 95;
        }
        Plastmo1 = Math.ceil(width/roofWidth);

        if(length > 600){
            Plastmo2 = Math.ceil(width/roofWidth);
        }

        double numBeams2 = 0.0;
        for(int i = 50; i <= 60; i++){
            numBeams2 = Math.ceil(length/i)+1;
            if(numBeams2 < numBeams){
                numBeams = numBeams2;
            }
        }

        if(length <= 480){
            beamLength = 480;
        }else if(length < 600){
            beamLength = 600;
        }else if(length > 600){
            beamLength = 480;
            numBeams = numBeams*2;
        }

        if(length < 600){
            postsY = 2.0;
        }else{
            postsY = 3.0;
        }

        if(width < 600){
            postsX = 2.0;
        }else{
            postsX = 3.0;
        }
        postsTotal = postsX + postsY;

        bolt = postsTotal*2;

        double uni190mm = numBeams*2; //total mængde, unviversal 190mm beslag har både højre er forskellig fra venstre
        Double beslagSkruer = Math.ceil((uni190mm*9)/250);

        request.setAttribute("numBeams", numBeams);
        request.setAttribute("beamLength", beamLength);
        request.setAttribute("posts", postsTotal);
        request.setAttribute("beslagSkruer", beslagSkruer);
        return pageToShow;
    }

    public float calculateTriangle(double length){
        float result;
        float C = (float) Math.sqrt(Math.pow(length, 2)-100);
        result = (float) Math.acos((Math.pow(length, 2)+Math.pow(C, 2)-100)/(2*length*C));
        return result*10;
    }
}
