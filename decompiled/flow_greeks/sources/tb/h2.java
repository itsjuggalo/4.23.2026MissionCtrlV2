package tb;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class h2 implements Executor {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f21411c = Logger.getLogger(h2.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f21412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayDeque f21413b;

    public final void a() {
        while (true) {
            Runnable runnable = (Runnable) this.f21413b.poll();
            if (runnable == null) {
                return;
            }
            try {
                runnable.run();
            } catch (Throwable th) {
                f21411c.log(Level.SEVERE, "Exception while executing runnable " + runnable, th);
            }
        }
    }

    public final void b(Runnable runnable) {
        if (this.f21413b == null) {
            this.f21413b = new ArrayDeque(4);
        }
        this.f21413b.add(runnable);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        p6.n.o(runnable, "'task' must not be null.");
        if (this.f21412a) {
            b(runnable);
            return;
        }
        this.f21412a = true;
        try {
            runnable.run();
        } catch (Throwable th) {
            try {
                f21411c.log(Level.SEVERE, "Exception while executing runnable " + runnable, th);
                if (this.f21413b != null) {
                }
            } finally {
                if (this.f21413b != null) {
                    a();
                }
                this.f21412a = false;
            }
        }
    }
}
