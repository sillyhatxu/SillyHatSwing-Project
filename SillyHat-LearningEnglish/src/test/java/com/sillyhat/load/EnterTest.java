package com.sillyhat.load;

/**
 * Created by ${XUSHIKUAN} on 2017-03-13.
 */
public class EnterTest {

    public static void main(String[] args) {
        String test = "AAAAAAAAAAAAA$E$BBBBBBBBBBBB";
        System.out.println(test);
        System.out.println(test.replaceAll("$E$","\n"));
    }
}
