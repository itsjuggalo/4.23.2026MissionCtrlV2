package t5;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: renamed from: t5.e0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class RunnableC2672e0 implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f23752b = Logger.getLogger(RunnableC2672e0.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f23753a;

    public RunnableC2672e0(Runnable runnable) {
        this.f23753a = (Runnable) H2.m.o(runnable, "task");
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f23753a.run();
        } catch (Throwable th) {
            f23752b.log(Level.SEVERE, "Exception while executing runnable " + this.f23753a, th);
            H2.u.f(th);
            throw new AssertionError(th);
        }
    }

    public String toString() {
        return "LogExceptionRunnable(" + this.f23753a + ")";
    }
}
