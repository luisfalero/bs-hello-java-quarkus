package org.lfalero;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class CustomMain {

    public static void main(String ... args) {
        System.out.println("Running main - not recommendable");
        Quarkus.run(CustomApp.class, args);
        //Quarkus.run(args);
    }

    public static class CustomApp implements QuarkusApplication {
        @Override
        public int run(String... args) throws Exception {
            System.out.println("Running main - recommendable");
            Quarkus.waitForExit();
            return 0;
        }
    }
}
