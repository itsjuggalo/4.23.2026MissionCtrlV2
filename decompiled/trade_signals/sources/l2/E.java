package l2;

import com.google.android.gms.common.internal.AbstractC1294n;

/* JADX INFO: loaded from: classes.dex */
public final class E implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractC2328l f20545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ F f20546b;

    public E(F f8, AbstractC2328l abstractC2328l) {
        this.f20546b = f8;
        this.f20545a = abstractC2328l;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f20546b.f20548b) {
            try {
                F f8 = this.f20546b;
                if (f8.f20549c != null) {
                    f8.f20549c.onFailure((Exception) AbstractC1294n.j(this.f20545a.j()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
