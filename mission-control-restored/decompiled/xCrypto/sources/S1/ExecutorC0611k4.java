package S1;

import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: S1.k4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class ExecutorC0611k4 implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0540b5 f4716a;

    public ExecutorC0611k4(C0540b5 c0540b5) {
        Objects.requireNonNull(c0540b5);
        this.f4716a = c0540b5;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f4716a.f4245a.b().t(runnable);
    }
}
