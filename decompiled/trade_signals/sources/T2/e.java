package T2;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import l2.AbstractC2328l;
import l2.AbstractC2331o;
import l2.InterfaceC2319c;

/* JADX INFO: loaded from: classes.dex */
public class e implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f7941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f7942b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AbstractC2328l f7943c = AbstractC2331o.e(null);

    public e(ExecutorService executorService) {
        this.f7941a = executorService;
    }

    public static /* synthetic */ AbstractC2328l d(Runnable runnable, AbstractC2328l abstractC2328l) {
        runnable.run();
        return AbstractC2331o.e(null);
    }

    public static /* synthetic */ AbstractC2328l e(Callable callable, AbstractC2328l abstractC2328l) {
        return (AbstractC2328l) callable.call();
    }

    public ExecutorService c() {
        return this.f7941a;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f7941a.execute(runnable);
    }

    public AbstractC2328l f(final Runnable runnable) {
        AbstractC2328l abstractC2328lI;
        synchronized (this.f7942b) {
            abstractC2328lI = this.f7943c.i(this.f7941a, new InterfaceC2319c() { // from class: T2.d
                @Override // l2.InterfaceC2319c
                public final Object a(AbstractC2328l abstractC2328l) {
                    return e.d(runnable, abstractC2328l);
                }
            });
            this.f7943c = abstractC2328lI;
        }
        return abstractC2328lI;
    }

    public AbstractC2328l g(final Callable callable) {
        AbstractC2328l abstractC2328lI;
        synchronized (this.f7942b) {
            abstractC2328lI = this.f7943c.i(this.f7941a, new InterfaceC2319c() { // from class: T2.c
                @Override // l2.InterfaceC2319c
                public final Object a(AbstractC2328l abstractC2328l) {
                    return e.e(callable, abstractC2328l);
                }
            });
            this.f7943c = abstractC2328lI;
        }
        return abstractC2328lI;
    }
}
