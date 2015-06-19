package javayou;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * JAX-RSを有効化するクラス。
 * 
 * Applicationを継承し、@ApplicationPathを付けたクラスがあれば
 * アプリケーションサーバはJAX-RSを有効化してくれる。
 * 
 * 基本的には中身は空っぽで良い。
 *
 */
@ApplicationPath("api")
public class JaxrsApplication extends Application {
}
