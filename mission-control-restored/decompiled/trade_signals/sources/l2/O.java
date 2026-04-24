package l2;

import android.os.Handler;
import android.os.Looper;
import g2.HandlerC1783a;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class O implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f20564a = new HandlerC1783a(Looper.getMainLooper());

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f20564a.post(runnable);
    }
}
