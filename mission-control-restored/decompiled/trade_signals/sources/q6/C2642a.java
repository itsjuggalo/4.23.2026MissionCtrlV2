package q6;

import V6.A;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: q6.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2642a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C0389a f22647f = new C0389a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final f f22648g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final c f22649h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f22650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f22651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f22652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f22653d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f22654e;

    /* JADX INFO: renamed from: q6.a$a, reason: collision with other inner class name */
    public static final class C0389a {
        public C0389a() {
        }

        public /* synthetic */ C0389a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    static {
        f fVar = h.f22688m;
        f22648g = fVar;
        f22649h = c.f22659c.a(fVar);
    }

    public C2642a(c cVar, c cVar2, f fVar, b bVar, c cVar3) {
        this.f22650a = cVar;
        this.f22651b = cVar2;
        this.f22652c = fVar;
        this.f22653d = bVar;
        this.f22654e = cVar3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C2642a) {
            C2642a c2642a = (C2642a) obj;
            if (AbstractC2304t.b(this.f22650a, c2642a.f22650a) && AbstractC2304t.b(this.f22651b, c2642a.f22651b) && AbstractC2304t.b(this.f22652c, c2642a.f22652c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (527 + this.f22650a.hashCode()) * 31;
        c cVar = this.f22651b;
        return ((iHashCode + (cVar != null ? cVar.hashCode() : 0)) * 31) + this.f22652c.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(A.D(this.f22650a.a(), com.amazon.a.a.o.c.a.b.f14112a, '/', false, 4, null));
        sb.append("/");
        c cVar = this.f22651b;
        if (cVar != null) {
            sb.append(cVar);
            sb.append(".");
        }
        sb.append(this.f22652c);
        return sb.toString();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C2642a(c packageName, f callableName) {
        this(packageName, null, callableName, null, null);
        AbstractC2304t.f(packageName, "packageName");
        AbstractC2304t.f(callableName, "callableName");
    }
}
