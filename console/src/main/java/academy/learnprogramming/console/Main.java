package academy.learnprogramming.console;

import academy.learnprogramming.config.AppConfig;
import academy.learnprogramming.Game;
import academy.learnprogramming.MessageGenerator;
import academy.learnprogramming.NumberGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

    private final static Logger log = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) {
        log.info("Guess the number game");

        //create context (container)
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        //get number generator bean
        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);

        //get message generator bean
        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);

        //call method next() to get a random number
        int number = numberGenerator.next();

        //log generated number
        log.info("number = {}", number);

        //log message generator messages
        log.info("getMainMessage= {}", messageGenerator.getMainMessage());
        log.info("getResultMessage= {}", messageGenerator.getResultMessage());


        // get the game bean from context (container)
        Game game = context.getBean(Game.class);

        //call reset method
        /*game.reset();*/


        //close context
        context.close();
    }
}
