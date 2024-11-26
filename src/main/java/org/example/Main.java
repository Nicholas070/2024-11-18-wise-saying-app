package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}

class App {
    public void run() {
        System.out.println("== 명언 앱 ==");

        Scanner scanner = new Scanner(System.in);

        int lastid = 0;
        WiseSaying lastwiseSaying=null;


        while ( true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();
            if (cmd.equals("종료")) {
                break;
            }
            else if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                String content = scanner.nextLine();
                System.out.print("작가 : ");
                String author = scanner.nextLine();
                int id =++lastid;

                WiseSaying wiseSaying = new WiseSaying();
                wiseSaying.id = id;
                wiseSaying.content = content;
                wiseSaying.author = author;

                lastwiseSaying = wiseSaying;

                System.out.println("%d번 명언이 등록되었습니다.".formatted(id));
            }
            else if (cmd.equals("목록")){
                System.out.println("번호 / 작가 / 명언");
                System.out.println("------------------");
                System.out.println("%d / %s / %s".formatted(lastwiseSaying.id, lastwiseSaying.author, lastwiseSaying.content));
            }
        }

        scanner.close();
    }
}
    class WiseSaying{
        int id;
        String content;
        String author;
    WiseSaying(){

    }
    WiseSaying(int id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }
}