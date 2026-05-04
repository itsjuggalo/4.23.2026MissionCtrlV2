package v9;

import android.view.LayoutInflater;
import u9.k;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements t9.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bd.a f23201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bd.a f23202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bd.a f23203c;

    public i(bd.a aVar, bd.a aVar2, bd.a aVar3) {
        this.f23201a = aVar;
        this.f23202b = aVar2;
        this.f23203c = aVar3;
    }

    public static i a(bd.a aVar, bd.a aVar2, bd.a aVar3) {
        return new i(aVar, aVar2, aVar3);
    }

    public static h c(k kVar, LayoutInflater layoutInflater, ea.i iVar) {
        return new h(kVar, layoutInflater, iVar);
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public h get() {
        return c((k) this.f23201a.get(), (LayoutInflater) this.f23202b.get(), (ea.i) this.f23203c.get());
    }
}
