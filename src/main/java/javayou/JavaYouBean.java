package javayou;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * JSFのバッキングビーン。
 * 
 * index.xhtmlからEL式経由で使用される。
 *
 */
@Named
@RequestScoped
public class JavaYouBean {

    private String text1;
    private String text2;
    private String imageUrl;

    /*
     * Java EEアプリケーションではインスタンスフィールドの初期化は
     * @PostConstractをつけたメソッドで行うのが良い。
     * (フィールドの宣言時やコンストラクタでは行わない方が良い)
     * 
     * CDIやEJBは対象クラス(CDI管理ビーン、セッションビーン)を継承して
     * 動的にプロキシクラスを作るけど、そのプロキシクラスをインスタンス化
     * するときにスーパークラスのコンストラクタも呼ぶため無駄にフィールドを
     * 初期化してしまう。
     * (プロキシクラスのインスタンスはフィールドを使わないので初期化する
     * 必要がない)
     * 
     * ……と言いつつ、このバッキングビーンはCDI管理ビーンにしていない(・ω<) ﾃﾍﾍﾟﾛ
     */
    @PostConstruct
    public void init() {
        text1 = "JAVA";
        text2 = "ダウンロード";
        generate();
    }

    public void generate() {
        try {
            imageUrl = "/api/generate?text1="
                    + URLEncoder.encode(text1, "UTF-8") + "&text2="
                    + URLEncoder.encode(text2, "UTF-8");
        } catch (UnsupportedEncodingException e) {
        }
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
