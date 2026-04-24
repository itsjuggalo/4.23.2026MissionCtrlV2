package S1;

import l2.AbstractC2328l;
import l2.C2329m;
import l2.InterfaceC2322f;

/* JADX INFO: renamed from: S1.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0883o implements InterfaceC2322f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C2329m f7433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0884p f7434b;

    public C0883o(C0884p c0884p, C2329m c2329m) {
        this.f7434b = c0884p;
        this.f7433a = c2329m;
    }

    @Override // l2.InterfaceC2322f
    public final void a(AbstractC2328l abstractC2328l) {
        this.f7434b.f7436b.remove(this.f7433a);
    }
}
