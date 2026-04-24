package i7;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f18941a = new a();

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }
}
