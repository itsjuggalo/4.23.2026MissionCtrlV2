package S1;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class J4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0531a4 f4059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f4060b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f4061c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ C0540b5 f4062d;

    public J4(C0540b5 c0540b5, C0531a4 c0531a4, long j4, boolean z4) {
        this.f4059a = c0531a4;
        this.f4060b = j4;
        this.f4061c = z4;
        Objects.requireNonNull(c0540b5);
        this.f4062d = c0540b5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0540b5 c0540b5 = this.f4062d;
        C0531a4 c0531a4 = this.f4059a;
        c0540b5.o(c0531a4);
        c0540b5.W(c0531a4, this.f4060b, true, this.f4061c);
    }
}
