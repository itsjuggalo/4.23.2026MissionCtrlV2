package sg;

import java.util.Collection;
import java.util.ServiceLoader;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Collection f20386a = jg.t.M(jg.q.g(ServiceLoader.load(ng.l0.class, ng.l0.class.getClassLoader()).iterator()));

    public static final Collection a() {
        return f20386a;
    }

    public static final void b(Throwable th) {
        Thread threadCurrentThread = Thread.currentThread();
        threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
    }
}
