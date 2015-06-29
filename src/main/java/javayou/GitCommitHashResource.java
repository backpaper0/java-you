package javayou;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Named
@RequestScoped
@Path("head")
public class GitCommitHashResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getHead() {
        URL resource = getClass().getResource("/head");
        if (resource != null) {
            try {
                byte[] b = Files.readAllBytes(Paths.get(resource.toURI()));
                return new String(b);
            } catch (URISyntaxException | IOException ignored) {
                //普通は例外を握りつぶしてはいけませんが
                //これは完全なるオマケ機能なので握りつぶします。
            }
        }
        //コミットハッシュを書いたファイルが無かったらビローン`
        return "o< ´･ω･` >oﾋﾞﾛｰﾝ";
    }
}
