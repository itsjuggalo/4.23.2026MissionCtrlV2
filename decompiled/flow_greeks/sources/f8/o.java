package f8;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class o implements j8.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f9387a = new Handler(Looper.getMainLooper());

    @Override // j8.k
    public void b(Runnable runnable) {
        this.f9387a.post(runnable);
    }

    @Override // j8.k
    public void a() {
    }
}
