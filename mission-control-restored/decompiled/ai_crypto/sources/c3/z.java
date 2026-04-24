package c3;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public abstract class z {
    public static Executor a(Executor executor, int i7) {
        return new ExecutorC1129B(executor, i7);
    }

    public static Executor b(Executor executor) {
        return new ExecutorC1130C(executor);
    }
}
