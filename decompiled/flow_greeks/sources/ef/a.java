package ef;

import kg.z;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C0167a f8771f = new C0167a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final f f8772g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final c f8773h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f8774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f8775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f8776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f8777d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f8778e;

    /* JADX INFO: renamed from: ef.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0167a {
        public /* synthetic */ C0167a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public C0167a() {
        }
    }

    static {
        f fVar = h.f8812m;
        f8772g = fVar;
        f8773h = c.f8783c.a(fVar);
    }

    public a(c cVar, c cVar2, f fVar, b bVar, c cVar3) {
        this.f8774a = cVar;
        this.f8775b = cVar2;
        this.f8776c = fVar;
        this.f8777d = bVar;
        this.f8778e = cVar3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return t.b(this.f8774a, aVar.f8774a) && t.b(this.f8775b, aVar.f8775b) && t.b(this.f8776c, aVar.f8776c);
    }

    public int hashCode() {
        int iHashCode = (527 + this.f8774a.hashCode()) * 31;
        c cVar = this.f8775b;
        return ((iHashCode + (cVar != null ? cVar.hashCode() : 0)) * 31) + this.f8776c.hashCode();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(z.E(this.f8774a.a(), com.amazon.a.a.o.c.a.b.f4610a, '/', false, 4, null));
        sb2.append("/");
        c cVar = this.f8775b;
        if (cVar != null) {
            sb2.append(cVar);
            sb2.append(".");
        }
        sb2.append(this.f8776c);
        return sb2.toString();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(c packageName, f callableName) {
        this(packageName, null, callableName, null, null);
        t.f(packageName, "packageName");
        t.f(callableName, "callableName");
    }
}
