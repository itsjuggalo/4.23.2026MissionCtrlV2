package l8;

import j8.l;
import m8.d;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m8.i f15547b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final m8.i f15548c = new b();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final m8.d f15549d = new m8.d(Boolean.TRUE);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final m8.d f15550e = new m8.d(Boolean.FALSE);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m8.d f15551a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements m8.i {
        @Override // m8.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean a(Boolean bool) {
            return !bool.booleanValue();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements m8.i {
        @Override // m8.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean a(Boolean bool) {
            return bool.booleanValue();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c implements d.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c f15552a;

        public c(d.c cVar) {
            this.f15552a = cVar;
        }

        @Override // m8.d.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Object a(l lVar, Boolean bool, Object obj) {
            return !bool.booleanValue() ? this.f15552a.a(lVar, null, obj) : obj;
        }
    }

    public g() {
        this.f15551a = m8.d.c();
    }

    public g a(r8.b bVar) {
        m8.d dVarR = this.f15551a.r(bVar);
        if (dVarR == null) {
            dVarR = new m8.d((Boolean) this.f15551a.getValue());
        } else if (dVarR.getValue() == null && this.f15551a.getValue() != null) {
            dVarR = dVarR.A(l.G(), (Boolean) this.f15551a.getValue());
        }
        return new g(dVarR);
    }

    public Object b(Object obj, d.c cVar) {
        return this.f15551a.g(obj, new c(cVar));
    }

    public g c(l lVar) {
        return this.f15551a.y(lVar, f15547b) != null ? this : new g(this.f15551a.G(lVar, f15550e));
    }

    public g d(l lVar) {
        if (this.f15551a.y(lVar, f15547b) == null) {
            return this.f15551a.y(lVar, f15548c) != null ? this : new g(this.f15551a.G(lVar, f15549d));
        }
        throw new IllegalArgumentException("Can't prune path that was kept previously!");
    }

    public boolean e() {
        return this.f15551a.a(f15548c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof g) && this.f15551a.equals(((g) obj).f15551a);
    }

    public boolean f(l lVar) {
        Boolean bool = (Boolean) this.f15551a.u(lVar);
        return (bool == null || bool.booleanValue()) ? false : true;
    }

    public boolean g(l lVar) {
        Boolean bool = (Boolean) this.f15551a.u(lVar);
        return bool != null && bool.booleanValue();
    }

    public int hashCode() {
        return this.f15551a.hashCode();
    }

    public String toString() {
        return "{PruneForest:" + this.f15551a.toString() + "}";
    }

    public g(m8.d dVar) {
        this.f15551a = dVar;
    }
}
