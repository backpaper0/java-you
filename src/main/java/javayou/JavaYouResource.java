package javayou;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.CompletableFuture;

import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.context.RequestScoped;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;

@RequestScoped
@Path("generate")
public class JavaYouResource {

    @Inject
    private ManagedExecutorService executor;

    /**
     * 「あなたと○○、今すぐ○○」画像を生成するリソースメソッド。
     * 
     * @param text1 1つ目の○○に入れる文字列
     * @param text2 2つ目の○○に入れる文字列
     * @param response JAX-RSの非同期処理で使用するクラス。
     *                 別スレッドで処理を行って結果をresponse.resume()メソッドへ渡す。
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public void generate(@QueryParam("text1") String text1,
            @QueryParam("text2") String text2, @Suspended AsyncResponse response) {

        //CompletableFutureで(無駄に)非同期処理をしている。
        CompletableFuture.runAsync(() -> {
            try (InputStream in = getClass().getResourceAsStream("/duke.png")) {
                BufferedImage image = ImageIO.read(in);
                Graphics2D g = image.createGraphics();

                //指定したフォントが無いければデフォルトのフォントが使われるっぽい
                g.setFont(new Font("Yutapon coding RegularBackslash",
                        Font.BOLD, 24));

                g.setColor(Color.BLACK);

                //Java + You, Download Today!
                g.drawString("あなたと", 40, 80);
                g.drawString(text1, 60, 120);
                g.drawString("今すぐ", 290, 380);
                g.drawString(text2, 300, 420);

                //Graphics2Dをいじったら忘れずdisposeする
                g.dispose();

                //byte配列で結果を返しているけれどもっとサイズが大きい、
                //またはサイズが予測できない場合は一時ファイルにでも書き出して
                //おいてInputStreamを返した方が良いと思う。
                //今回はサイズが小さいというのもあり、手抜き実装(・ω<) ﾃﾍﾍﾟﾛ
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                ImageIO.write(image, "png", out);
                response.resume(out.toByteArray());

            } catch (IOException e) {
                response.resume(e);
            }
        }, executor);
        //Java EE環境ではexecutorの指定をしてサーバが管理しているスレッドを使うようにする
    }
}
