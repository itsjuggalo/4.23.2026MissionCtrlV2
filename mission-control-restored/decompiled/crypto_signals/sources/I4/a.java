package I4;

import R4.p;
import s3.D;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f645a;

    public a(h hVar) {
        this.f645a = hVar;
    }

    @Override // I4.i
    public final Object fold(Object obj, p pVar) {
        return pVar.invoke(obj, this);
    }

    @Override // I4.i
    public g get(h hVar) {
        return D.L(this, hVar);
    }

    @Override // I4.g
    public final h getKey() {
        return this.f645a;
    }

    @Override // I4.i
    public i minusKey(h hVar) {
        return D.R(this, hVar);
    }

    @Override // I4.i
    public final i plus(i iVar) {
        return D.V(this, iVar);
    }
}
