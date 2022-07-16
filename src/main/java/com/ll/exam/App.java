package com.ll.exam;

import java.util.Scanner;

public class App {
    private Scanner input;

    public App() {
            input = new Scanner(System.in);
    }

    public void run() {
        System.out.println("== 명언 SSG ==");
        SayingController sayingController = new SayingController(input);


        outer:
        while (true) {

            System.out.print("명령) ");
            String cmd = input.nextLine().trim();


            switch (new Rq(cmd).getPath()) {
                case "종료":
                    break outer;
                case "등록":
                    sayingController.addSaying();
                    break;
                case "목록":
                    sayingController.showList();
                    break;
                case "삭제":
                    sayingController.removeSaying(new Rq(cmd));
                    break;
                case "수정":
                    sayingController.editSayingByID(new Rq(cmd));
                    break;
            }

        }
        input.close();
    }


}


