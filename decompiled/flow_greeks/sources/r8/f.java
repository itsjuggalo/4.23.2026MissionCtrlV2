package r8;

import r8.k;
import r8.n;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class f extends k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Double f19412c;

    public f(Double d10, n nVar) {
        super(nVar);
        this.f19412c = d10;
    }

    @Override // r8.n
    public String C(n.b bVar) {
        return (u(bVar) + "number:") + m8.m.c(this.f19412c.doubleValue());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f19412c.equals(fVar.f19412c) && this.f19419a.equals(fVar.f19419a);
    }

    @Override // r8.n
    public Object getValue() {
        return this.f19412c;
    }

    public int hashCode() {
        return this.f19412c.hashCode() + this.f19419a.hashCode();
    }

    @Override // r8.k
    public k.b s() {
        return k.b.Number;
    }

    @Override // r8.k
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public int a(f fVar) {
        return this.f19412c.compareTo(fVar.f19412c);
    }

    @Override // r8.n
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public f D(n nVar) {
        m8.m.f(r.b(nVar));
        return new f(this.f19412c, nVar);
    }
}
