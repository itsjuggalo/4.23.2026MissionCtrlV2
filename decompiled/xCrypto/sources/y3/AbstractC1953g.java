package y3;

import java.util.Collection;
import java.util.ServiceLoader;

/* JADX INFO: renamed from: y3.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1953g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Collection f15981a = q3.l.k(q3.j.c(ServiceLoader.load(t3.J.class, t3.J.class.getClassLoader()).iterator()));

    public static final Collection a() {
        return f15981a;
    }

    public static final void b(Throwable th) {
        Thread threadCurrentThread = Thread.currentThread();
        threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
    }
}
