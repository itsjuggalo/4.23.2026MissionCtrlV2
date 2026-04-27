package q1;

import java.util.concurrent.Executor;

/* JADX INFO: renamed from: q1.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2622e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Executor f22523a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Executor f22524b = new b();

    /* JADX INFO: renamed from: q1.e$a */
    public class a implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            AbstractC2629l.u(runnable);
        }
    }

    /* JADX INFO: renamed from: q1.e$b */
    public class b implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            runnable.run();
        }
    }

    public static Executor a() {
        return f22524b;
    }

    public static Executor b() {
        return f22523a;
    }
}
