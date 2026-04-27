package S1;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class H4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Boolean f3988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0540b5 f3989b;

    public H4(C0540b5 c0540b5, Boolean bool) {
        this.f3988a = bool;
        Objects.requireNonNull(c0540b5);
        this.f3989b = c0540b5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3989b.V(this.f3988a, true);
    }
}
