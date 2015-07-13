package javayou;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
    private List<JavaYouLog> logs;

    @Inject
    private EntityManager em;

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
     */
    @PostConstruct
    public void init() {
        text1 = "JAVA";
        text2 = "ダウンロード";
        buildImageUrl();
    }

    @Transactional
    public void generate() {
        buildImageUrl();

        logs = em.createNamedQuery("JavaYouLog.findAll", JavaYouLog.class)
                .getResultList();

        JavaYouLog log = new JavaYouLog();
        log.setText1(text1);
        log.setText2(text2);
        em.persist(log);
    }

    private void buildImageUrl() {
        try {
            imageUrl = "/api/generate?text1="
                    + URLEncoder.encode(text1, "UTF-8") + "&text2="
                    + URLEncoder.encode(text2, "UTF-8");
        } catch (UnsupportedEncodingException e) {
        }
    }

    @NotNull
    @Size(min = 1)
    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    @NotNull
    @Size(min = 1)
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

    public List<JavaYouLog> getLogs() {
        return logs;
    }

    public void setLogs(List<JavaYouLog> logs) {
        this.logs = logs;
    }
}
