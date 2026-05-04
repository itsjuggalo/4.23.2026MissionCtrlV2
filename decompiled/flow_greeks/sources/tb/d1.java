package tb;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class d1 implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f21193b = Logger.getLogger(d1.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f21194a;

    public d1(Runnable runnable) {
        this.f21194a = (Runnable) p6.n.o(runnable, "task");
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f21194a.run();
        } catch (Throwable th) {
            f21193b.log(Level.SEVERE, "Exception while executing runnable " + this.f21194a, th);
            p6.v.f(th);
            throw new AssertionError(th);
        }
    }

    public String toString() {
        return "LogExceptionRunnable(" + this.f21194a + ")";
    }
}
