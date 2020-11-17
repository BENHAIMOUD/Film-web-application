package me.ruiz.thierry.film.init;

import me.ruiz.thierry.film.model.Actor;
import me.ruiz.thierry.film.model.Director;
import me.ruiz.thierry.film.repository.ActorRepository;
import me.ruiz.thierry.film.repository.DirectorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RestServiceRunner implements CommandLineRunner {

    private static final Logger logger =  LoggerFactory.getLogger(RestServiceRunner.class);

    @Autowired
    private ActorRepository actorRepository;
    @Autowired
    DirectorRepository directorRepository;



    @Override
    public void run(String... args) throws Exception {
        logger.info("#################### Rest Service Runner ##########################");

        //actors
        Actor actor1 = new Actor("Said", "Nassiri");
        actorRepository.save(actor1);

        //directors
        Director director1 = new Director("Mouhmed", "Ben");
        directorRepository.save(director1);

        //films



    }
}
