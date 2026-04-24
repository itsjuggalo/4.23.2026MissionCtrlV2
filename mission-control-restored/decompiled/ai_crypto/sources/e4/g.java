package e4;

import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.firebase.storage.G;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f13630b = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f13631a;

    public g(Executor executor) {
        if (executor != null) {
            this.f13631a = executor;
        } else if (f13630b) {
            this.f13631a = null;
        } else {
            this.f13631a = G.b().c();
        }
    }

    public void a(Runnable runnable) {
        AbstractC1207s.k(runnable);
        Executor executor = this.f13631a;
        if (executor != null) {
            executor.execute(runnable);
        } else {
            G.b().e(runnable);
        }
    }
}
