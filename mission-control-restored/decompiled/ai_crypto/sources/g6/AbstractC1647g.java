package g6;

import java.util.Collection;
import java.util.ServiceLoader;

/* JADX INFO: renamed from: g6.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC1647g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Collection f14295a = Y5.m.l(Y5.k.c(ServiceLoader.load(b6.J.class, b6.J.class.getClassLoader()).iterator()));

    public static final Collection a() {
        return f14295a;
    }

    public static final void b(Throwable th) {
        Thread threadCurrentThread = Thread.currentThread();
        threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
    }
}
