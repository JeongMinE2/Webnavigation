package Webnavigation;

import java.util.Scanner;
import java.util.Stack;

public class Webnavigation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<String> current = new Stack<>();    // 현재 페이지 선언
        Stack<String> back = new Stack<>();       // 뒤로가기 페이지 선언
        Stack<String> forward = new Stack<>();    // 앞으로 가기 페이지 스택 선언

        current.push("http://www.acm.org/");

        boolean run = true;

        while (run) {
            String page = sc.next();
            switch (page) {
                case "VISIT":   // 방문 시
                    back.push(current.pop());
                    current.push(sc.next());
                    forward.clear();
                    System.out.println(current.peek());
                    break;
                case "BACK":    // 뒤로가기
                    if (back.empty()) {
                        System.out.println("Ignored");
                    } else {
                        forward.push(current.pop());
                        current.push(back.pop());
                        System.out.println(current.peek());
                    }
                    break;
                case "FORWARD": // 앞으로 가기
                    if (forward.empty()) {
                        System.out.println("Ignored");
                    } else {
                        back.push(current.pop());
                        current.push(forward.pop());
                        System.out.println(current.peek());
                    }
                    break;
                case "QUIT":    // 종료
                    run = false;
                    break;
            }
        }
    }
}
