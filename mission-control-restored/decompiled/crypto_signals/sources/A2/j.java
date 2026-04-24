package A2;

import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public abstract class j implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f53a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f54b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h f55c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f56d;

    public j(Object obj, Object obj2, h hVar, h hVar2) {
        this.f53a = obj;
        this.f54b = obj2;
        g gVar = g.f52a;
        this.f55c = hVar == null ? gVar : hVar;
        this.f56d = hVar2 == null ? gVar : hVar2;
    }

    @Override // A2.h
    public final h a() {
        return this.f55c;
    }

    @Override // A2.h
    public final h b(Object obj, Object obj2, Comparator comparator) {
        int iCompare = comparator.compare(obj, this.f53a);
        return (iCompare < 0 ? k(null, null, this.f55c.b(obj, obj2, comparator), null) : iCompare == 0 ? k(obj, obj2, null, null) : k(null, null, null, this.f56d.b(obj, obj2, comparator))).l();
    }

    @Override // A2.h
    public final h d() {
        return this.f56d;
    }

    @Override // A2.h
    public final h e(Object obj, Comparator comparator) {
        j jVarK;
        if (comparator.compare(obj, this.f53a) < 0) {
            j jVarN = (this.f55c.isEmpty() || this.f55c.c() || ((j) this.f55c).f55c.c()) ? this : n();
            jVarK = jVarN.k(null, null, jVarN.f55c.e(obj, comparator), null);
        } else {
            j jVarP = this.f55c.c() ? p() : this;
            h hVar = jVarP.f56d;
            if (!hVar.isEmpty() && !hVar.c() && !((j) hVar).f55c.c()) {
                jVarP = jVarP.i();
                if (jVarP.f55c.a().c()) {
                    jVarP = jVarP.p().i();
                }
            }
            if (comparator.compare(obj, jVarP.f53a) == 0) {
                h hVar2 = jVarP.f56d;
                if (hVar2.isEmpty()) {
                    return g.f52a;
                }
                h hVarG = hVar2.g();
                jVarP = jVarP.k(hVarG.getKey(), hVarG.getValue(), null, ((j) hVar2).o());
            }
            jVarK = jVarP.k(null, null, null, jVarP.f56d.e(obj, comparator));
        }
        return jVarK.l();
    }

    @Override // A2.h
    public final h g() {
        return this.f55c.isEmpty() ? this : this.f55c.g();
    }

    @Override // A2.h
    public final Object getKey() {
        return this.f53a;
    }

    @Override // A2.h
    public final Object getValue() {
        return this.f54b;
    }

    @Override // A2.h
    public final h h() {
        h hVar = this.f56d;
        return hVar.isEmpty() ? this : hVar.h();
    }

    public final j i() {
        h hVar = this.f55c;
        h hVarF = hVar.f(hVar.c() ? 2 : 1, null, null);
        h hVar2 = this.f56d;
        return f(c() ? 2 : 1, hVarF, hVar2.f(hVar2.c() ? 2 : 1, null, null));
    }

    @Override // A2.h
    public final boolean isEmpty() {
        return false;
    }

    @Override // A2.h
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public final j f(int i, h hVar, h hVar2) {
        if (hVar == null) {
            hVar = this.f55c;
        }
        if (hVar2 == null) {
            hVar2 = this.f56d;
        }
        Object obj = this.f53a;
        Object obj2 = this.f54b;
        return i == 1 ? new i(obj, obj2, hVar, hVar2) : new f(obj, obj2, hVar, hVar2);
    }

    public abstract j k(Object obj, Object obj2, h hVar, h hVar2);

    public final j l() {
        h hVar = this.f56d;
        j jVarP = (!hVar.c() || this.f55c.c()) ? this : (j) hVar.f(m(), f(1, null, ((j) hVar).f55c), null);
        if (jVarP.f55c.c() && ((j) jVarP.f55c).f55c.c()) {
            jVarP = jVarP.p();
        }
        return (jVarP.f55c.c() && jVarP.f56d.c()) ? jVarP.i() : jVarP;
    }

    public abstract int m();

    public final j n() {
        j jVarI = i();
        h hVar = jVarI.f56d;
        if (!hVar.a().c()) {
            return jVarI;
        }
        j jVarK = jVarI.k(null, null, null, ((j) hVar).p());
        h hVar2 = jVarK.f56d;
        return ((j) hVar2.f(jVarK.m(), jVarK.f(1, null, ((j) hVar2).f55c), null)).i();
    }

    public final h o() {
        if (this.f55c.isEmpty()) {
            return g.f52a;
        }
        j jVarN = (this.f55c.c() || this.f55c.a().c()) ? this : n();
        return jVarN.k(null, null, ((j) jVarN.f55c).o(), null).l();
    }

    public final j p() {
        return (j) this.f55c.f(m(), null, f(1, ((j) this.f55c).f56d, null));
    }

    public void q(j jVar) {
        this.f55c = jVar;
    }
}
