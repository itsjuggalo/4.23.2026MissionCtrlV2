package v9;

import android.view.LayoutInflater;
import u9.k;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements t9.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bd.a f23162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bd.a f23163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bd.a f23164c;

    public b(bd.a aVar, bd.a aVar2, bd.a aVar3) {
        this.f23162a = aVar;
        this.f23163b = aVar2;
        this.f23164c = aVar3;
    }

    public static b a(bd.a aVar, bd.a aVar2, bd.a aVar3) {
        return new b(aVar, aVar2, aVar3);
    }

    public static a c(k kVar, LayoutInflater layoutInflater, ea.i iVar) {
        return new a(kVar, layoutInflater, iVar);
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public a get() {
        return c((k) this.f23162a.get(), (LayoutInflater) this.f23163b.get(), (ea.i) this.f23164c.get());
    }
}
