package gd;

import gd.i;
import kotlin.jvm.internal.t;
import pd.o;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements i.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i.c f10525a;

    public a(i.c key) {
        t.f(key, "key");
        this.f10525a = key;
    }

    @Override // gd.i.b, gd.i
    public Object fold(Object obj, o oVar) {
        return i.b.a.a(this, obj, oVar);
    }

    @Override // gd.i.b, gd.i
    public i.b get(i.c cVar) {
        return i.b.a.b(this, cVar);
    }

    @Override // gd.i.b
    public i.c getKey() {
        return this.f10525a;
    }

    @Override // gd.i.b, gd.i
    public i minusKey(i.c cVar) {
        return i.b.a.c(this, cVar);
    }

    @Override // gd.i
    public i plus(i iVar) {
        return i.b.a.d(this, iVar);
    }
}
