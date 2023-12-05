package com.ojiraphers.request;

/*
3.path Varable
@PathVarable 어노테이션을 통해 요청을 path로부터 변수를 받아올 수 있다.
path variable로 전달되는 {변수명} 값은 반드시 매개변수명과 동일해야 한다.
만약 동일하지 않으면 @PathVarible("이름")을 설정해주어야 한다.
이는 rest형 웹서비스를 설계할때 유용하게 사용된다.

인텔리제이의 builder설정을 Inteellij로 했을 경우에는 PathVarible에 이름을 지정해주지 않으면 찾지 못한다.
 */

// Spring Framework의 UI Model 및 Web 요청 핸들링에 필요한 클래스를 임포트합니다.
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;

// Controller 애노테이션은 이 클래스가 Spring MVC의 컨트롤러로 동작하게 합니다.
@Controller
// RequestMapping 애노테이션은 이 컨트롤러의 모든 메서드가 '/order/' 경로를 기반으로 요청을 처리하도록 합니다.
@RequestMapping("/order/*")
public class ClassMappingTestController {

// port 80 = web: 웹 서버가 보통 이 포트를 사용하여 HTTP 요청을 수신합니다.
// port 8080 = was: 웹 애플리케이션 서버(WAS)는 보통 이 포트를 사용하여 요청을 수신합니다.
// port 443 = https: HTTPS 요청을 수신하는데 사용하는 보안 포트입니다.

    // GetMapping 애노테이션은 이 메서드가 HTTP GET 요청을 처리하도록 합니다. 여기서는 '/order/regist' 경로에 대한 요청을 처리합니다.
    @GetMapping("/regist")
    public String registOrder(Model model){
        // 모델 객체에 메시지 속성을 추가합니다. 이 메시지는 뷰에서 사용될 수 있습니다.
        model.addAttribute("message", "get방식의 주문 등록용 핸들러 메소드 호출");

        // 'mappingResult' 뷰 이름을 반환합니다. Spring MVC는 이 이름을 사용하여 클라이언트에게 보낼 뷰를 결정합니다.
        return "mappingResult";
    }

    @RequestMapping (value = {"modify", "delete"), method = RequestMethod.POST)
    public String modifyAndDelete(Model model){
        model.addAttribute("message", "GET방식의 주문 등록형 핸들러 메소드 호출");
         return "mappingResult";
}

@GetMapping ("/detail/{orderNo}")
    public String selectOrderDetail (Model model)@PathVariable int orderNO){
        model.addAttribute("message", orderNO+"빈 주문 상세 내용 조회용 핸들러 메소드 호출");
        return "mappingResult";
    }


    @GetMapping ("/detail/{orderNo}")
    public String selectOrderDetail (Model model)@PathVariable int orderNO){
        model.addAttribute("message", orderNO+"order요청이긴 하지만 다른 기능의 존재하지 않ㅇㅁ" +
                "ㄱㄷ");
        return "mappingResult";

        GetMapping(modifyAndDelete                                                                                                                                                                                                                                                                          (ealt.gererLnep))
    }

}

