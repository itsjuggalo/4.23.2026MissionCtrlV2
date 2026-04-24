package M2;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public class I0 implements Executor {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f1919c = Logger.getLogger(I0.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayDeque f1921b;

    public final void a() {
        while (true) {
            Runnable runnable = (Runnable) this.f1921b.poll();
            if (runnable == null) {
                return;
            }
            try {
                runnable.run();
            } catch (Throwable th) {
                f1919c.log(Level.SEVERE, "Exception while executing runnable " + runnable, th);
            }
        }
    }

    public final void b(Runnable runnable) {
        if (this.f1921b == null) {
            this.f1921b = new ArrayDeque(4);
        }
        this.f1921b.add(runnable);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        Z1.m.o(runnable, "'task' must not be null.");
        if (this.f1920a) {
            b(runnable);
            return;
        }
        this.f1920a = true;
        try {
            runnable.run();
        } catch (Throwable th) {
            try {
                f1919c.log(Level.SEVERE, "Exception while executing runnable " + runnable, th);
                if (this.f1921b != null) {
                }
            } finally {
                if (this.f1921b != null) {
                    a();
                }
                this.f1920a = false;
            }
        }
    }
}
