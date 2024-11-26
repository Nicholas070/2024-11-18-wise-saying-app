package org.example;

//import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}

class App { //run만 하면 다 따라오는거라 private으로 기능 한정, class안에 있는거는 final붙이는게 좋음.
    private final Scanner scanner; //= new Scanner(System.in);
    private int lastId;// = 0;
    //WiseSaying lastwiseSaying = null;      //WiseSaying lastWiseSaying = null;
    //int a;                            는   //WiseSaying[] wiseSayings = new WiseSaying[3];  을 대신해 쓰임
    //int[] arArr = new int[100]             //int wiseSayingsSize = 0;
    //                                       //wiseSayings[wiseSayingsSize++] = wiseSaying;
    //                                       //wiseSayingsSize++;
    //**WiseSaying lastWiseSaying = null; 목록에서 하나밖에 못보여줌.
    private final List<WiseSaying> wiseSayings;//private final WiseSaying[] wiseSayings; // = new WiseSaying[3];//명언 공간 3개까지 저장가능(배열. 배열이라 to string을 바꿀 수 없음.)
    private int wiseSayingsSize; // = 0;// 해주면, wiseSayings에 데이터가 지금은 0개있다.


    public App(){ //이거는 private하면 외부에서 생산 못함. 생성자는 공개.
        scanner = new Scanner(System.in);
        lastId = 0; //매번 증가해서 final붙이면 안됨
        wiseSayings = new ArrayList<>();//wiseSayings = new WiseSaying[10];
        //wiseSayingsSize = 0; ArrayList 쓰면서 배열을 계산할 필요가 없어지니까 얘도 필요없어짐.//매번 증가해서 final붙이면 안됨.
    }

    public void run() { // 런은 작동이 되어야하니까 오픈
        System.out.println("== 명언 앱 ==");

        addWiseSaying("삶은 계란이다.", "석진규");
        addWiseSaying("나의 죽음을 적에게 알리지말라.", "이순신");

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                actionAdd();
            } else if (cmd.equals("목록")) {
                actionList();

                //위로발전
                //for (int i = 0 ;i < wiseSayingsSize; i++) { //i++이 for문 끝에 있거나 괄호안에 있거나 다른게 없음
                //  WiseSaying wiseSaying = wiseSayings[i];
                //System.out.println("%d / %s / %s".formatted(wiseSaying.id, wiseSaying.author, wiseSaying.content));
                ;
                //위로발전
                //while (i < wiseSayingsSize) {
                //WiseSaying wiseSaying = wiseSayings[i];
                //System.out.println("%d / %s / %s".formatted(wiseSaying.id, wiseSaying.author, wiseSaying.content));
                //i++;
            }
            //**try {
            //**System.out.println("%d / %s / %s".formatted(lastWiseSaying.id, lastWiseSaying.author, lastWiseSaying.content));
            //**} catch (NullPointerException e) {
            //** System.out.println("등록된 명언이 없습니다.");
        }


        scanner.close();
    }
    private WiseSaying addWiseSaying(String content, String author){   //따로 그루핑해서 배열 또는 리스트화를 선택하기 편하게 함., 콘텐츠랑 작가는 스트링으로 원래있던걸 받아줌.
        int id = ++lastId; //id는 안받아와도 되는이유는 번호는 자동으로 매겨지기 때문

        WiseSaying wiseSaying = new WiseSaying(id, content, author); // 위 void addWiseSaying에서 wiseSaying addWiseSaying으로 바꾼건, 아래 wiseSaying을 리턴하기 위한 wiseSaying의 타입이 WiseSaying이기 때문이다.
        //System.out.println(wiseSaying);
        // WiseSaying (id=1, content= "명언", author="작가")으로 만들고 싶다. 오버라이드
        //**lastWiseSaying = wiseSaying;
        //wiseSayings[wiseSayingsSize] = wiseSaying; ArrayList 넣을때 사라짐
        //**wiseSayings[wiseSayingsSize++] = wiseSaying;
        //wiseSayingsSize++; ArrayList 넣을때 사라짐
        wiseSayings.add(wiseSaying); //ArrayList 넣을때 생김

        System.out.println("wiseSayings = " + wiseSayings); // ArrayList할때 같이 확인용으로 추가

        return wiseSaying;
    }

    private void actionAdd() {
        System.out.print("명언 : ");
        String content = scanner.nextLine();
        System.out.print("작가 : ");
        String author = scanner.nextLine();
        //int id = ++lastId;

        WiseSaying wiseSaying = addWiseSaying(content, author);//addWiseSaying(content, author);에서 바뀜
        //wiseSaying이 addWiseSaying 한테 content, author를 받아오는 것.

        //**System.out.println(Arrays.toString(wiseSayings)); //System.out.println(wiseSayings);에서 바뀜. wiseSayings는 객체가 아니라 리모콘
        //[WiseSaying(id=1, content="명언", author="작가"), ...]
        System.out.println("%d번 명언이 등록되었습니다.".formatted(wiseSaying.getId())); //System.out.println("%d번 명언이 등록되었습니다.".formatted(id));에서 변경
    }

    private void actionList(){
        System.out.println("번호 / 작가 / 명언");
        System.out.println("------------------");


        //int i = 0; //**

        //if(lastwiseSaying != null){
        //    System.out.println("%d / %s / %s".formatted(lastwiseSaying.id, lastwiseSaying.author, lastwiseSaying.content);
        //} else{
        //   System.out.println("명언이 없습니다.");}
        //목록에서 하나밖에 못보여줌

        for (WiseSaying wiseSaying : wiseSayings) {  //향상된for문
            //if (wiseSaying == null) break; List여도 향상된 for문을 사용할수는 있지만, 값이 비어있으면 그만두라고 명령하는 if절은 필요없다. List는 고정길이 없고, wiseSayings에 한개넣으면 한번돌고, 두개넣으면 두번 돌기때문.
            System.out.println("%d / %s / %s".formatted(wiseSaying.getId(), wiseSaying.getAutor(), wiseSaying.getContent()));
        }
    }

}
class WiseSaying extends Object{ //private은 괄호밖이랑 상호작용할 필요없는 것들인데 다른괄호에도 접근되어야하기 때문에 퍼블릭.
    private final int id; //개발자가 실수로 아이디를 건드리는 상황을 방지함
    private String content;
    private String author;

    public WiseSaying(int id, String content, String author) { //App에서 WiseSaying을 쓰니까 공개.
        this.id = id;
        this.content = content;
        this.author = author;
    }

    public int getId(){  //일단 private로 외부접근을 모두 막고 외부에서 읽기는 가능해야한다면 gettter, 쓸수도 있어야 한다면 setter.
        return id;
    }
    public String getContent() {
        return content;
    }
    public String getAutor(){
        return author;
    }

    @Override //코드를 이쁘게 꾸며주기 위함.
    public String toString() {
        return "WiseSaying (id=%d, content=\"%s\", author=\"%s\")".formatted(id, content, author);
    }
}