package Z2;

import Z2.i;
import i3.o;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements i.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i.c f6005a;

    public a(i.c key) {
        r.f(key, "key");
        this.f6005a = key;
    }

    @Override // Z2.i.b, Z2.i
    public Object fold(Object obj, o oVar) {
        return i.b.a.a(this, obj, oVar);
    }

    @Override // Z2.i.b, Z2.i
    public i.b get(i.c cVar) {
        return i.b.a.b(this, cVar);
    }

    @Override // Z2.i.b
    public i.c getKey() {
        return this.f6005a;
    }

    @Override // Z2.i.b, Z2.i
    public i minusKey(i.c cVar) {
        return i.b.a.c(this, cVar);
    }

    @Override // Z2.i
    public i plus(i iVar) {
        return i.b.a.d(this, iVar);
    }
}
