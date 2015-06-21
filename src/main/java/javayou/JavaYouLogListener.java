package javayou;

import java.time.LocalDateTime;

import javax.persistence.PrePersist;

public class JavaYouLogListener {

    @PrePersist
    public void prePersist(JavaYouLog log) {
        log.setCreatedAt(LocalDateTime.now());
    }
}
