package javayou;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javayou.JaxrsApplication;

import org.glassfish.embeddable.archive.ScatteredArchive;
import org.glassfish.embeddable.archive.ScatteredArchive.Type;

import fish.payara.micro.BootstrapException;
import fish.payara.micro.PayaraMicro;

public class JavaYou {

    public static void main(String[] args) throws URISyntaxException,
            IOException, BootstrapException {

        Path webapp = Paths.get("src/main/webapp");

        ScatteredArchive archive = new ScatteredArchive("java-you", Type.WAR,
                webapp.toFile());

        File classpath = new File(JaxrsApplication.class.getResource("/")
                .toURI());

        archive.addClassPath(classpath);

        File war = new File(archive.toURI());

        PayaraMicro.getInstance().addDeploymentFile(war).bootStrap();
    }
}
