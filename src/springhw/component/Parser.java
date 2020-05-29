package springhw.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import springhw.beans.*;
import org.springframework.context.annotation.PropertySource;

import java.util.*;

@Component("Parser")
@PropertySource("resources/class.properties")
public class Parser {

    @Value("#{${tp.props}}")
    private Map<Integer, Map<String, String>> props;


    public Parser() {
    }

    public Characters[] parse() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("resources/applicationContext.xml");
        ArrayList<Characters> al = new ArrayList<>();
        Integer j = 0;
        this.props.forEach((i, map) -> {
                    if (map.get("type").equals("tank")) {
                        Characters chars = ctx.getBean("Tank", Characters.class);
                        chars.setName(map.get("name"));
                        al.add(j, chars);
                    } else {
                        if (map.get("type").equals("range")) {
                            Characters chars = ctx.getBean("Range", Characters.class);
                            chars.setName(map.get("name"));
                            al.add(j, chars);
                        } else {
                            if (map.get("type").equals("melee")) {
                                Characters chars = ctx.getBean("Melee", Characters.class);
                                chars.setName(map.get("name"));
                                al.add(j, chars);
                            } else {
                                al.add(null);
                            }
                        }
                    }
                }
        );
        if (al.isEmpty()){
            return null;
        }
        Characters[] mass = null;
        mass = al.toArray(new Characters[al.size()]);
        return mass;
    }
}
