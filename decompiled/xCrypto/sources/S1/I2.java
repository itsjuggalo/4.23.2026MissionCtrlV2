package S1;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class I2 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f3996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ K2 f3997b;

    public I2(K2 k22, boolean z4) {
        this.f3996a = z4;
        Objects.requireNonNull(k22);
        this.f3997b = k22;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3997b.c().r0(this.f3996a);
    }
}
