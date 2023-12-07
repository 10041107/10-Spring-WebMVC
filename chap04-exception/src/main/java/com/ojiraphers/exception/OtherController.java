package com.ojiraphers.exception;

import org.springframework.web.bind.annotation.GetMapping;

public class OtherController {

    @GetMapping("other-controller-null")
    public String otherNullPointerException() {
        String str = null;
        System.out.println(str.charAt(0));
        return "/";
    }

        @GetMapping("other-controller-user")
        public String otherUserPointerException() throws MemberRegistExcaption {

        if(true) {
            throw new MemberRegistExcaption("입사 불가");
        }
            return "/";
        }


        @GetMapping("other-controller-array")
    public String otherArrayExcaptionTEst(){
        double[] array = new double[0];
            System.out.println(array[0]);
            return "/";
        }

}
