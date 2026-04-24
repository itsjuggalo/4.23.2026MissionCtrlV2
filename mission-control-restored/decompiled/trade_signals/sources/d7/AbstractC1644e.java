package d7;

import java.util.Collection;
import java.util.ServiceLoader;

/* JADX INFO: renamed from: d7.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC1644e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Collection f17044a = U6.r.J(U6.o.e(ServiceLoader.load(Y6.J.class, Y6.J.class.getClassLoader()).iterator()));

    public static final Collection a() {
        return f17044a;
    }

    public static final void b(Throwable th) {
        Thread threadCurrentThread = Thread.currentThread();
        threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
    }
}
