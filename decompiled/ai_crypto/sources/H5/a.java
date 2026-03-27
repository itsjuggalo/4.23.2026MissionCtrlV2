package H5;

import H5.g;
import Q5.o;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements g.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g.c f2662a;

    public a(g.c key) {
        r.f(key, "key");
        this.f2662a = key;
    }

    @Override // H5.g.b, H5.g
    public Object fold(Object obj, o oVar) {
        return g.b.a.a(this, obj, oVar);
    }

    @Override // H5.g.b, H5.g
    public g.b get(g.c cVar) {
        return g.b.a.b(this, cVar);
    }

    @Override // H5.g.b
    public g.c getKey() {
        return this.f2662a;
    }

    @Override // H5.g.b, H5.g
    public g minusKey(g.c cVar) {
        return g.b.a.c(this, cVar);
    }

    @Override // H5.g
    public g plus(g gVar) {
        return g.b.a.d(this, gVar);
    }
}
