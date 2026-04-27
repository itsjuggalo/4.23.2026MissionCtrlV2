package M2;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: renamed from: M2.e0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC0417e0 implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f2201b = Logger.getLogger(RunnableC0417e0.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f2202a;

    public RunnableC0417e0(Runnable runnable) {
        this.f2202a = (Runnable) Z1.m.o(runnable, "task");
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f2202a.run();
        } catch (Throwable th) {
            f2201b.log(Level.SEVERE, "Exception while executing runnable " + this.f2202a, th);
            Z1.u.f(th);
            throw new AssertionError(th);
        }
    }

    public String toString() {
        return "LogExceptionRunnable(" + this.f2202a + ")";
    }
}
