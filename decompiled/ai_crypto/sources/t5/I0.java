package t5;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public class I0 implements Executor {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f23470c = Logger.getLogger(I0.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f23471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayDeque f23472b;

    public final void a() {
        while (true) {
            Runnable runnable = (Runnable) this.f23472b.poll();
            if (runnable == null) {
                return;
            }
            try {
                runnable.run();
            } catch (Throwable th) {
                f23470c.log(Level.SEVERE, "Exception while executing runnable " + runnable, th);
            }
        }
    }

    public final void b(Runnable runnable) {
        if (this.f23472b == null) {
            this.f23472b = new ArrayDeque(4);
        }
        this.f23472b.add(runnable);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        H2.m.o(runnable, "'task' must not be null.");
        if (this.f23471a) {
            b(runnable);
            return;
        }
        this.f23471a = true;
        try {
            runnable.run();
        } catch (Throwable th) {
            try {
                f23470c.log(Level.SEVERE, "Exception while executing runnable " + runnable, th);
                if (this.f23472b != null) {
                }
            } finally {
                if (this.f23472b != null) {
                    a();
                }
                this.f23471a = false;
            }
        }
    }
}
