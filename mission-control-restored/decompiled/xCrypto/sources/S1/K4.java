package S1;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class K4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0531a4 f4073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f4074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f4075c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ C0540b5 f4076d;

    public K4(C0540b5 c0540b5, C0531a4 c0531a4, long j4, boolean z4) {
        this.f4073a = c0531a4;
        this.f4074b = j4;
        this.f4075c = z4;
        Objects.requireNonNull(c0540b5);
        this.f4076d = c0540b5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0540b5 c0540b5 = this.f4076d;
        C0531a4 c0531a4 = this.f4073a;
        c0540b5.o(c0531a4);
        c0540b5.W(c0531a4, this.f4074b, false, this.f4075c);
    }
}
