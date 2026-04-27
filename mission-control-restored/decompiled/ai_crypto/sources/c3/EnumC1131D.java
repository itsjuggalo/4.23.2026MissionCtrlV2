package c3;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: c3.D, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC1131D implements Executor {
    INSTANCE;


    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Handler f9359b = new Handler(Looper.getMainLooper());

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        f9359b.post(runnable);
    }
}
