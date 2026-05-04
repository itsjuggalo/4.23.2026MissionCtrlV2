package r8;

import java.util.Map;
import r8.k;
import r8.n;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class e extends k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map f19411c;

    public e(Map map, n nVar) {
        super(nVar);
        this.f19411c = map;
    }

    @Override // r8.n
    public String C(n.b bVar) {
        return u(bVar) + "deferredValue:" + this.f19411c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f19411c.equals(eVar.f19411c) && this.f19419a.equals(eVar.f19419a);
    }

    @Override // r8.n
    public Object getValue() {
        return this.f19411c;
    }

    public int hashCode() {
        return this.f19411c.hashCode() + this.f19419a.hashCode();
    }

    @Override // r8.k
    public k.b s() {
        return k.b.DeferredValue;
    }

    @Override // r8.k
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public int a(e eVar) {
        return 0;
    }

    @Override // r8.n
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public e D(n nVar) {
        m8.m.f(r.b(nVar));
        return new e(this.f19411c, nVar);
    }
}
