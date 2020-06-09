package IOC.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

//DI 依赖注入用到的类
public class Alden implements UserDao {

    private String name;
    private Jack adrees;
    private String[] book;
    private List<String> hobbes;
    private Map<String,String> card;
    private Set<String> games;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Jack getAdrees() {
        return adrees;
    }

    public void setAdrees(Jack adrees) {
        this.adrees = adrees;
    }

    public String[] getBook() {
        return book;
    }

    public void setBook(String[] book) {
        this.book = book;
    }

    public List<String> getHobbes() {
        return hobbes;
    }

    public void setHobbes(List<String> hobbes) {
        this.hobbes = hobbes;
    }

    public Map<String, String> getCard() {
        return card;
    }

    public void setCard(Map<String, String> card) {
        this.card = card;
    }

    public Set<String> getGames() {
        return games;
    }

    public void setGames(Set<String> games) {
        this.games = games;
    }

    public void GetName() {
        System.out.print("用户是Alden");
    }
}
