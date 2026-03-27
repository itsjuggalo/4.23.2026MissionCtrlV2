package w4;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public final class A0 implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f10829b = Logger.getLogger(A0.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f10830a;

    public A0(Runnable runnable) {
        this.f10830a = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable = this.f10830a;
        try {
            runnable.run();
        } catch (Throwable th) {
            f10829b.log(Level.SEVERE, "Exception while executing runnable " + runnable, th);
            Object obj = U1.p.f3121a;
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new AssertionError(th);
            }
            throw ((Error) th);
        }
    }

    public final String toString() {
        return "LogExceptionRunnable(" + this.f10830a + ")";
    }
}
