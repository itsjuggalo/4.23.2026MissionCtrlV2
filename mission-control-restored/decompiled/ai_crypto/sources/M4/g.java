package M4;

import M4.c;
import android.os.Handler;
import android.os.Looper;
import q5.AbstractC2562a;

/* JADX INFO: loaded from: classes2.dex */
public class g implements c.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f3891a = AbstractC2562a.a(Looper.getMainLooper());

    @Override // M4.c.d
    public void a(Runnable runnable) {
        this.f3891a.post(runnable);
    }
}
