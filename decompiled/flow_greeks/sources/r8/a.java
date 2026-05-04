package r8;

import r8.k;
import r8.n;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a extends k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f19384c;

    public a(Boolean bool, n nVar) {
        super(nVar);
        this.f19384c = bool.booleanValue();
    }

    @Override // r8.n
    public String C(n.b bVar) {
        return u(bVar) + "boolean:" + this.f19384c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f19384c == aVar.f19384c && this.f19419a.equals(aVar.f19419a);
    }

    @Override // r8.n
    public Object getValue() {
        return Boolean.valueOf(this.f19384c);
    }

    public int hashCode() {
        boolean z10 = this.f19384c;
        return (z10 ? 1 : 0) + this.f19419a.hashCode();
    }

    @Override // r8.k
    public k.b s() {
        return k.b.Boolean;
    }

    @Override // r8.k
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public int a(a aVar) {
        boolean z10 = this.f19384c;
        if (z10 == aVar.f19384c) {
            return 0;
        }
        return z10 ? 1 : -1;
    }

    @Override // r8.n
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public a D(n nVar) {
        return new a(Boolean.valueOf(this.f19384c), nVar);
    }
}
