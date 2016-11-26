package javayou;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@EventHandler
public class JavaYouRecorder {

    private final EntityManager em;

    @Inject
    public JavaYouRecorder(EntityManager em) {
        this.em = em;
    }

    @Transactional
    public void handle(@Observes JavaYouEvent javaYouEvent) {
        JavaYouLog log = new JavaYouLog();
        log.setText1(javaYouEvent.text1);
        log.setText2(javaYouEvent.text2);
        em.persist(log);
    }
}
