package G4;

import java.util.logging.Level;
import java.util.logging.Logger;
import v2.AbstractC2848n;
import v2.AbstractC2856v;

/* JADX INFO: renamed from: G4.e0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class RunnableC0525e0 implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f2789b = Logger.getLogger(RunnableC0525e0.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f2790a;

    public RunnableC0525e0(Runnable runnable) {
        this.f2790a = (Runnable) AbstractC2848n.o(runnable, "task");
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f2790a.run();
        } catch (Throwable th) {
            f2789b.log(Level.SEVERE, "Exception while executing runnable " + this.f2790a, th);
            AbstractC2856v.f(th);
            throw new AssertionError(th);
        }
    }

    public String toString() {
        return "LogExceptionRunnable(" + this.f2790a + ")";
    }
}
