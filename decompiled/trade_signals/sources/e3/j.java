package e3;

import e3.h;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public abstract class j implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f17163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f17164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h f17165c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f17166d;

    public j(Object obj, Object obj2, h hVar, h hVar2) {
        this.f17163a = obj;
        this.f17164b = obj2;
        this.f17165c = hVar == null ? g.j() : hVar;
        this.f17166d = hVar2 == null ? g.j() : hVar2;
    }

    public static h.a q(h hVar) {
        return hVar.e() ? h.a.BLACK : h.a.RED;
    }

    @Override // e3.h
    public h b() {
        return this.f17165c;
    }

    @Override // e3.h
    public h c(Object obj, Object obj2, Comparator comparator) {
        int iCompare = comparator.compare(obj, this.f17163a);
        return (iCompare < 0 ? l(null, null, this.f17165c.c(obj, obj2, comparator), null) : iCompare == 0 ? l(obj, obj2, null, null) : l(null, null, null, this.f17166d.c(obj, obj2, comparator))).m();
    }

    @Override // e3.h
    public h d(Object obj, Comparator comparator) {
        j jVarL;
        if (comparator.compare(obj, this.f17163a) < 0) {
            j jVarO = (this.f17165c.isEmpty() || this.f17165c.e() || ((j) this.f17165c).f17165c.e()) ? this : o();
            jVarL = jVarO.l(null, null, jVarO.f17165c.d(obj, comparator), null);
        } else {
            j jVarT = this.f17165c.e() ? t() : this;
            if (!jVarT.f17166d.isEmpty() && !jVarT.f17166d.e() && !((j) jVarT.f17166d).f17165c.e()) {
                jVarT = jVarT.p();
            }
            if (comparator.compare(obj, jVarT.f17163a) == 0) {
                if (jVarT.f17166d.isEmpty()) {
                    return g.j();
                }
                h hVarH = jVarT.f17166d.h();
                jVarT = jVarT.l(hVarH.getKey(), hVarH.getValue(), null, ((j) jVarT.f17166d).r());
            }
            jVarL = jVarT.l(null, null, null, jVarT.f17166d.d(obj, comparator));
        }
        return jVarL.m();
    }

    @Override // e3.h
    public h f() {
        return this.f17166d;
    }

    @Override // e3.h
    public void g(h.b bVar) {
        this.f17165c.g(bVar);
        bVar.a(this.f17163a, this.f17164b);
        this.f17166d.g(bVar);
    }

    @Override // e3.h
    public Object getKey() {
        return this.f17163a;
    }

    @Override // e3.h
    public Object getValue() {
        return this.f17164b;
    }

    @Override // e3.h
    public h h() {
        return this.f17165c.isEmpty() ? this : this.f17165c.h();
    }

    @Override // e3.h
    public h i() {
        return this.f17166d.isEmpty() ? this : this.f17166d.i();
    }

    @Override // e3.h
    public boolean isEmpty() {
        return false;
    }

    public final j j() {
        h hVar = this.f17165c;
        h hVarA = hVar.a(null, null, q(hVar), null, null);
        h hVar2 = this.f17166d;
        return a(null, null, q(this), hVarA, hVar2.a(null, null, q(hVar2), null, null));
    }

    @Override // e3.h
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public j a(Object obj, Object obj2, h.a aVar, h hVar, h hVar2) {
        if (obj == null) {
            obj = this.f17163a;
        }
        if (obj2 == null) {
            obj2 = this.f17164b;
        }
        if (hVar == null) {
            hVar = this.f17165c;
        }
        if (hVar2 == null) {
            hVar2 = this.f17166d;
        }
        return aVar == h.a.RED ? new i(obj, obj2, hVar, hVar2) : new f(obj, obj2, hVar, hVar2);
    }

    public abstract j l(Object obj, Object obj2, h hVar, h hVar2);

    public final j m() {
        j jVarS = (!this.f17166d.e() || this.f17165c.e()) ? this : s();
        if (jVarS.f17165c.e() && ((j) jVarS.f17165c).f17165c.e()) {
            jVarS = jVarS.t();
        }
        return (jVarS.f17165c.e() && jVarS.f17166d.e()) ? jVarS.j() : jVarS;
    }

    public abstract h.a n();

    public final j o() {
        j jVarJ = j();
        return jVarJ.f().b().e() ? jVarJ.l(null, null, null, ((j) jVarJ.f()).t()).s().j() : jVarJ;
    }

    public final j p() {
        j jVarJ = j();
        return jVarJ.b().b().e() ? jVarJ.t().j() : jVarJ;
    }

    public final h r() {
        if (this.f17165c.isEmpty()) {
            return g.j();
        }
        j jVarO = (b().e() || b().b().e()) ? this : o();
        return jVarO.l(null, null, ((j) jVarO.f17165c).r(), null).m();
    }

    public final j s() {
        return (j) this.f17166d.a(null, null, n(), a(null, null, h.a.RED, null, ((j) this.f17166d).f17165c), null);
    }

    public final j t() {
        return (j) this.f17165c.a(null, null, n(), null, a(null, null, h.a.RED, ((j) this.f17165c).f17166d, null));
    }

    public void u(h hVar) {
        this.f17165c = hVar;
    }
}
