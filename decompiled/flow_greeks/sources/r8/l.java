package r8;

import r8.k;
import r8.n;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class l extends k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f19427c;

    public l(Long l10, n nVar) {
        super(nVar);
        this.f19427c = l10.longValue();
    }

    @Override // r8.n
    public String C(n.b bVar) {
        return (u(bVar) + "number:") + m8.m.c(this.f19427c);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return this.f19427c == lVar.f19427c && this.f19419a.equals(lVar.f19419a);
    }

    @Override // r8.n
    public Object getValue() {
        return Long.valueOf(this.f19427c);
    }

    public int hashCode() {
        long j10 = this.f19427c;
        return ((int) (j10 ^ (j10 >>> 32))) + this.f19419a.hashCode();
    }

    @Override // r8.k
    public k.b s() {
        return k.b.Number;
    }

    @Override // r8.k
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public int a(l lVar) {
        return m8.m.b(this.f19427c, lVar.f19427c);
    }

    @Override // r8.n
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public l D(n nVar) {
        return new l(Long.valueOf(this.f19427c), nVar);
    }
}
