package AllZhuJie.model;

import IOC.dao.Jack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository  /*@Component功能一样*/
@Scope("singleton")
public class User {

    @Value("alden")
    public String name;
    @Autowired
    private Jack adrees;
    private String[] book;
    private List<String> hobbes;
    private Map<String,String> card;
    private Set<String> games;

}
