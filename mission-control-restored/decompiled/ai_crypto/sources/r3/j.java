package r3;

import java.util.Comparator;
import r3.h;

/* JADX INFO: loaded from: classes.dex */
public abstract class j implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f22468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f22469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h f22470c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f22471d;

    public j(Object obj, Object obj2, h hVar, h hVar2) {
        this.f22468a = obj;
        this.f22469b = obj2;
        this.f22470c = hVar == null ? g.i() : hVar;
        this.f22471d = hVar2 == null ? g.i() : hVar2;
    }

    public static h.a p(h hVar) {
        return hVar.e() ? h.a.BLACK : h.a.RED;
    }

    @Override // r3.h
    public h a() {
        return this.f22470c;
    }

    @Override // r3.h
    public h b(Object obj, Object obj2, Comparator comparator) {
        int iCompare = comparator.compare(obj, this.f22468a);
        return (iCompare < 0 ? k(null, null, this.f22470c.b(obj, obj2, comparator), null) : iCompare == 0 ? k(obj, obj2, null, null) : k(null, null, null, this.f22471d.b(obj, obj2, comparator))).l();
    }

    @Override // r3.h
    public h c(Object obj, Comparator comparator) {
        j jVarK;
        if (comparator.compare(obj, this.f22468a) < 0) {
            j jVarN = (this.f22470c.isEmpty() || this.f22470c.e() || ((j) this.f22470c).f22470c.e()) ? this : n();
            jVarK = jVarN.k(null, null, jVarN.f22470c.c(obj, comparator), null);
        } else {
            j jVarS = this.f22470c.e() ? s() : this;
            if (!jVarS.f22471d.isEmpty() && !jVarS.f22471d.e() && !((j) jVarS.f22471d).f22470c.e()) {
                jVarS = jVarS.o();
            }
            if (comparator.compare(obj, jVarS.f22468a) == 0) {
                if (jVarS.f22471d.isEmpty()) {
                    return g.i();
                }
                h hVarG = jVarS.f22471d.g();
                jVarS = jVarS.k(hVarG.getKey(), hVarG.getValue(), null, ((j) jVarS.f22471d).q());
            }
            jVarK = jVarS.k(null, null, null, jVarS.f22471d.c(obj, comparator));
        }
        return jVarK.l();
    }

    @Override // r3.h
    public h f() {
        return this.f22471d;
    }

    @Override // r3.h
    public h g() {
        return this.f22470c.isEmpty() ? this : this.f22470c.g();
    }

    @Override // r3.h
    public Object getKey() {
        return this.f22468a;
    }

    @Override // r3.h
    public Object getValue() {
        return this.f22469b;
    }

    @Override // r3.h
    public h h() {
        return this.f22471d.isEmpty() ? this : this.f22471d.h();
    }

    public final j i() {
        h hVar = this.f22470c;
        h hVarD = hVar.d(null, null, p(hVar), null, null);
        h hVar2 = this.f22471d;
        return d(null, null, p(this), hVarD, hVar2.d(null, null, p(hVar2), null, null));
    }

    @Override // r3.h
    public boolean isEmpty() {
        return false;
    }

    @Override // r3.h
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public j d(Object obj, Object obj2, h.a aVar, h hVar, h hVar2) {
        if (obj == null) {
            obj = this.f22468a;
        }
        if (obj2 == null) {
            obj2 = this.f22469b;
        }
        if (hVar == null) {
            hVar = this.f22470c;
        }
        if (hVar2 == null) {
            hVar2 = this.f22471d;
        }
        return aVar == h.a.RED ? new i(obj, obj2, hVar, hVar2) : new f(obj, obj2, hVar, hVar2);
    }

    public abstract j k(Object obj, Object obj2, h hVar, h hVar2);

    public final j l() {
        j jVarR = (!this.f22471d.e() || this.f22470c.e()) ? this : r();
        if (jVarR.f22470c.e() && ((j) jVarR.f22470c).f22470c.e()) {
            jVarR = jVarR.s();
        }
        return (jVarR.f22470c.e() && jVarR.f22471d.e()) ? jVarR.i() : jVarR;
    }

    public abstract h.a m();

    public final j n() {
        j jVarI = i();
        return jVarI.f().a().e() ? jVarI.k(null, null, null, ((j) jVarI.f()).s()).r().i() : jVarI;
    }

    public final j o() {
        j jVarI = i();
        return jVarI.a().a().e() ? jVarI.s().i() : jVarI;
    }

    public final h q() {
        if (this.f22470c.isEmpty()) {
            return g.i();
        }
        j jVarN = (a().e() || a().a().e()) ? this : n();
        return jVarN.k(null, null, ((j) jVarN.f22470c).q(), null).l();
    }

    public final j r() {
        return (j) this.f22471d.d(null, null, m(), d(null, null, h.a.RED, null, ((j) this.f22471d).f22470c), null);
    }

    public final j s() {
        return (j) this.f22470c.d(null, null, m(), null, d(null, null, h.a.RED, ((j) this.f22470c).f22471d, null));
    }

    public void t(h hVar) {
        this.f22470c = hVar;
    }
}
