package v9;

import android.view.LayoutInflater;
import u9.k;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements t9.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bd.a f23187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bd.a f23188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bd.a f23189c;

    public g(bd.a aVar, bd.a aVar2, bd.a aVar3) {
        this.f23187a = aVar;
        this.f23188b = aVar2;
        this.f23189c = aVar3;
    }

    public static g a(bd.a aVar, bd.a aVar2, bd.a aVar3) {
        return new g(aVar, aVar2, aVar3);
    }

    public static f c(k kVar, LayoutInflater layoutInflater, ea.i iVar) {
        return new f(kVar, layoutInflater, iVar);
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public f get() {
        return c((k) this.f23187a.get(), (LayoutInflater) this.f23188b.get(), (ea.i) this.f23189c.get());
    }
}
