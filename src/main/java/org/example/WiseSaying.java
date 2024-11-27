package org.example;

//import java.util.Arrays;

public class WiseSaying { //private은 괄호밖이랑 상호작용할 필요없는 것들인데 다른괄호에도 접근되어야하기 때문에 퍼블릭.
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
