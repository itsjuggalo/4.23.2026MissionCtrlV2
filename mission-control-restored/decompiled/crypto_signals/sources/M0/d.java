package M0;

import Y3.h;
import android.os.Handler;
import android.os.Looper;
import java.io.Serializable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.jvm.internal.j;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Handler f1056c = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ExecutorService f1057d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f1058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1059b;

    static {
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(8);
        j.d(executorServiceNewFixedThreadPool, "newFixedThreadPool(...)");
        f1057d = executorServiceNewFixedThreadPool;
    }

    public d(h hVar) {
        this.f1058a = hVar;
    }

    public final void a(Serializable serializable) {
        if (this.f1059b) {
            return;
        }
        this.f1059b = true;
        h hVar = this.f1058a;
        this.f1058a = null;
        f1056c.post(new E3.h(5, hVar, serializable));
    }
}
