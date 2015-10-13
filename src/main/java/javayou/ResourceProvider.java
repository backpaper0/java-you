package javayou;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    @Resource
    private ManagedExecutorService executor;

    @PersistenceContext
    private EntityManager entityManager;

    @Produces
    @Dependent
    public ManagedExecutorService getExecutor() {
        return executor;
    }

    @Produces
    @Dependent
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
