package l2;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class Q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ P f20571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Callable f20572b;

    public Q(P p8, Callable callable) {
        this.f20571a = p8;
        this.f20572b = callable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f20571a.s(this.f20572b.call());
        } catch (Exception e8) {
            this.f20571a.r(e8);
        } catch (Throwable th) {
            this.f20571a.r(new RuntimeException(th));
        }
    }
}
