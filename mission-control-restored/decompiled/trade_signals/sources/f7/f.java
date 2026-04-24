package f7;

import Y6.AbstractC1016l0;
import s5.InterfaceC2711i;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f extends AbstractC1016l0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f17630d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f17631e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f17632f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f17633g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f17634h = z0();

    public f(int i8, int i9, long j8, String str) {
        this.f17630d = i8;
        this.f17631e = i9;
        this.f17632f = j8;
        this.f17633g = str;
    }

    public final void A0(Runnable runnable, boolean z7, boolean z8) {
        this.f17634h.B(runnable, z7, z8);
    }

    @Override // Y6.I
    public void v0(InterfaceC2711i interfaceC2711i, Runnable runnable) {
        a.D(this.f17634h, runnable, false, false, 6, null);
    }

    public final a z0() {
        return new a(this.f17630d, this.f17631e, this.f17632f, this.f17633g);
    }
}
