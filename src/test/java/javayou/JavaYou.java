package javayou;

import fish.payara.micro.BootstrapException;
import fish.payara.micro.PayaraMicro;
import org.glassfish.embeddable.archive.ScatteredArchive;
import org.glassfish.embeddable.archive.ScatteredArchive.Type;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JavaYou {

    public static void main(String[] args) throws URISyntaxException,
            IOException, BootstrapException {

        Path webapp = Paths.get("src/main/webapp");

        ScatteredArchive archive = new ScatteredArchive("java-you", Type.WAR,
                webapp.toFile());

        File classpath = new File(JaxrsApplication.class.getResource("/")
                .toURI());

        archive.addClassPath(classpath);

        // IDEA向けの雑な対応
        addClassPathIfExists(archive, "build/classes/main");
        addClassPathIfExists(archive, "build/resources/main");

        File war = new File(archive.toURI());

        PayaraMicro.getInstance().addDeploymentFile(war).setNoCluster(true)
                .bootStrap();
    }

    private static void addClassPathIfExists(ScatteredArchive archive, String target) throws IOException {
        File file = new File(target);
        if (file.exists()) {
            archive.addClassPath(file);
        }
    }
}
