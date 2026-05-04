package g8;

import g8.h;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class j implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f10121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f10122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h f10123c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f10124d;

    public j(Object obj, Object obj2, h hVar, h hVar2) {
        this.f10121a = obj;
        this.f10122b = obj2;
        this.f10123c = hVar == null ? g.j() : hVar;
        this.f10124d = hVar2 == null ? g.j() : hVar2;
    }

    public static h.a q(h hVar) {
        return hVar.f() ? h.a.BLACK : h.a.RED;
    }

    @Override // g8.h
    public h a() {
        return this.f10123c;
    }

    @Override // g8.h
    public h b(Object obj, Object obj2, Comparator comparator) {
        int iCompare = comparator.compare(obj, this.f10121a);
        return (iCompare < 0 ? l(null, null, this.f10123c.b(obj, obj2, comparator), null) : iCompare == 0 ? l(obj, obj2, null, null) : l(null, null, null, this.f10124d.b(obj, obj2, comparator))).m();
    }

    @Override // g8.h
    public h d(Object obj, Comparator comparator) {
        j jVarL;
        if (comparator.compare(obj, this.f10121a) < 0) {
            j jVarO = (this.f10123c.isEmpty() || this.f10123c.f() || ((j) this.f10123c).f10123c.f()) ? this : o();
            jVarL = jVarO.l(null, null, jVarO.f10123c.d(obj, comparator), null);
        } else {
            j jVarT = this.f10123c.f() ? t() : this;
            if (!jVarT.f10124d.isEmpty() && !jVarT.f10124d.f() && !((j) jVarT.f10124d).f10123c.f()) {
                jVarT = jVarT.p();
            }
            if (comparator.compare(obj, jVarT.f10121a) == 0) {
                if (jVarT.f10124d.isEmpty()) {
                    return g.j();
                }
                h hVarH = jVarT.f10124d.h();
                jVarT = jVarT.l(hVarH.getKey(), hVarH.getValue(), null, ((j) jVarT.f10124d).r());
            }
            jVarL = jVarT.l(null, null, null, jVarT.f10124d.d(obj, comparator));
        }
        return jVarL.m();
    }

    @Override // g8.h
    public void e(h.b bVar) {
        this.f10123c.e(bVar);
        bVar.a(this.f10121a, this.f10122b);
        this.f10124d.e(bVar);
    }

    @Override // g8.h
    public h g() {
        return this.f10124d;
    }

    @Override // g8.h
    public Object getKey() {
        return this.f10121a;
    }

    @Override // g8.h
    public Object getValue() {
        return this.f10122b;
    }

    @Override // g8.h
    public h h() {
        return this.f10123c.isEmpty() ? this : this.f10123c.h();
    }

    @Override // g8.h
    public h i() {
        return this.f10124d.isEmpty() ? this : this.f10124d.i();
    }

    @Override // g8.h
    public boolean isEmpty() {
        return false;
    }

    public final j j() {
        h hVar = this.f10123c;
        h hVarC = hVar.c(null, null, q(hVar), null, null);
        h hVar2 = this.f10124d;
        return c(null, null, q(this), hVarC, hVar2.c(null, null, q(hVar2), null, null));
    }

    @Override // g8.h
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public j c(Object obj, Object obj2, h.a aVar, h hVar, h hVar2) {
        if (obj == null) {
            obj = this.f10121a;
        }
        if (obj2 == null) {
            obj2 = this.f10122b;
        }
        if (hVar == null) {
            hVar = this.f10123c;
        }
        if (hVar2 == null) {
            hVar2 = this.f10124d;
        }
        return aVar == h.a.RED ? new i(obj, obj2, hVar, hVar2) : new f(obj, obj2, hVar, hVar2);
    }

    public abstract j l(Object obj, Object obj2, h hVar, h hVar2);

    public final j m() {
        j jVarS = (!this.f10124d.f() || this.f10123c.f()) ? this : s();
        if (jVarS.f10123c.f() && ((j) jVarS.f10123c).f10123c.f()) {
            jVarS = jVarS.t();
        }
        return (jVarS.f10123c.f() && jVarS.f10124d.f()) ? jVarS.j() : jVarS;
    }

    public abstract h.a n();

    public final j o() {
        j jVarJ = j();
        return jVarJ.g().a().f() ? jVarJ.l(null, null, null, ((j) jVarJ.g()).t()).s().j() : jVarJ;
    }

    public final j p() {
        j jVarJ = j();
        return jVarJ.a().a().f() ? jVarJ.t().j() : jVarJ;
    }

    public final h r() {
        if (this.f10123c.isEmpty()) {
            return g.j();
        }
        j jVarO = (a().f() || a().a().f()) ? this : o();
        return jVarO.l(null, null, ((j) jVarO.f10123c).r(), null).m();
    }

    public final j s() {
        return (j) this.f10124d.c(null, null, n(), c(null, null, h.a.RED, null, ((j) this.f10124d).f10123c), null);
    }

    public final j t() {
        return (j) this.f10123c.c(null, null, n(), null, c(null, null, h.a.RED, ((j) this.f10123c).f10124d, null));
    }

    public void u(h hVar) {
        this.f10123c = hVar;
    }
}
