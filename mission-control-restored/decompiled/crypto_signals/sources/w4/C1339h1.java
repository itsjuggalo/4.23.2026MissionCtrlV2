package w4;

import java.util.logging.Level;
import u4.C1230l;
import u4.EnumC1229k;

/* JADX INFO: renamed from: w4.h1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1339h1 implements u4.L {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C1230l f11277a = C1230l.a(EnumC1229k.f10452d);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public C1348k1 f11278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C1351l1 f11279c;

    public C1339h1(C1351l1 c1351l1) {
        this.f11279c = c1351l1;
    }

    @Override // u4.L
    public final void a(C1230l c1230l) {
        C1351l1.f11312o.log(Level.FINE, "Received health status {0} for subchannel {1}", new Object[]{c1230l, this.f11278b.f11304a});
        this.f11277a = c1230l;
        C1351l1 c1351l1 = this.f11279c;
        if (c1351l1.f11315h.c() && ((C1348k1) c1351l1.f11314g.get(c1351l1.f11315h.a())).f11306c == this) {
            c1351l1.j(this.f11278b);
        }
    }
}
