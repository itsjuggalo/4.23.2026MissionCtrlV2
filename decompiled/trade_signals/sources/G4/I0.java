package G4;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import v2.AbstractC2848n;

/* JADX INFO: loaded from: classes2.dex */
public class I0 implements Executor {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f2507c = Logger.getLogger(I0.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayDeque f2509b;

    public final void a() {
        while (true) {
            Runnable runnable = (Runnable) this.f2509b.poll();
            if (runnable == null) {
                return;
            }
            try {
                runnable.run();
            } catch (Throwable th) {
                f2507c.log(Level.SEVERE, "Exception while executing runnable " + runnable, th);
            }
        }
    }

    public final void b(Runnable runnable) {
        if (this.f2509b == null) {
            this.f2509b = new ArrayDeque(4);
        }
        this.f2509b.add(runnable);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        AbstractC2848n.o(runnable, "'task' must not be null.");
        if (this.f2508a) {
            b(runnable);
            return;
        }
        this.f2508a = true;
        try {
            runnable.run();
        } catch (Throwable th) {
            try {
                f2507c.log(Level.SEVERE, "Exception while executing runnable " + runnable, th);
                if (this.f2509b != null) {
                }
            } finally {
                if (this.f2509b != null) {
                    a();
                }
                this.f2508a = false;
            }
        }
    }
}
