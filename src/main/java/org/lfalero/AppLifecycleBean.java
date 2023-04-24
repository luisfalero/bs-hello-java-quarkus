package org.lfalero;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@ApplicationScoped
@Slf4j
public class AppLifecycleBean {

    void onStart(@Observes StartupEvent evt) {
        log.info("The application is starting...");
    }

    void onStop(@Observes ShutdownEvent evt) {
        log.info("The application is stopping...");
    }

}
