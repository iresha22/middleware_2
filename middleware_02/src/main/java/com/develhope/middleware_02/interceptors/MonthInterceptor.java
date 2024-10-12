package com.develhope.middleware_02.interceptors;

import com.develhope.middleware_02.entities.Month;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

import static org.apache.tomcat.util.http.parser.HttpParser.isNumeric;


public class MonthInterceptor implements HandlerInterceptor {
    // parameters
   private  List<Month> monthList = Arrays.asList(
           new Month(1,"Gennaio","January","Januar"),
            new Month(2,"Febbraio","February","Februar"),
            new Month(3,"Marzo","March","März"),
            new Month(4,"Aprile","April","April"),
            new Month(5,"Maggio","May","Mai"),
            new Month(6,"giugno","June","Juni")
            );

   // preHandle method
   @Override
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
          String monthNumberHeader = request.getHeader("monthNumber");
          if(monthNumberHeader.isEmpty() || monthNumberHeader == null){
              response.sendError(HttpServletResponse.SC_BAD_REQUEST, "monthNumber header is required");
              return false;
          }
       if (!isNumeric(Integer.parseInt(monthNumberHeader))) {
           response.sendError(HttpServletResponse.SC_BAD_REQUEST, "monthNumber must be a valid integer");
           return false;
       }
       int monthNumber = Integer.parseInt(monthNumberHeader);

       // Find the month by monthNumber
       Month foundMonth = monthList.stream()
               .filter(month -> month.getMonthNumber() == monthNumber)
               .findFirst()
               .orElse(new Month());  // Return an empty month with "nope"

       // Add the found month to the request attribute
       request.setAttribute("foundMonth", foundMonth);
       return true;
   }

   //postHandle method
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    //afterCompletion method
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
