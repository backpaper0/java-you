package javayou;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;

/**
 * JNDIリソースやJPAのエンティティマネージャなどとCDIを繋ぐためのクラス。
 * 
 * .@Producesが付いているメソッドで返されているクラスは@Injectで
 * インジェクション出来るようになる。
 *
 */
@Dependent
public class ResourceProvider {

    /**
     * アプリケーションサーバ(Payara)にデフォルトで定義されているManagedExecutorService
     */
    @Resource(name = "DefaultManagedExecutorService")
    private ManagedExecutorService executor;

    @Produces
    @Dependent
    public ManagedExecutorService getExecutor() {
        return executor;
    }
}
