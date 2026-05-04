package ke;

import kg.z;
import kotlin.jvm.internal.t;
import xe.x;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements x {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f14831c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f14832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ye.a f14833b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final f a(Class klass) {
            t.f(klass, "klass");
            ye.b bVar = new ye.b();
            c.f14829a.b(klass, bVar);
            ye.a aVarN = bVar.n();
            kotlin.jvm.internal.k kVar = null;
            if (aVarN == null) {
                return null;
            }
            return new f(klass, aVarN, kVar);
        }

        public a() {
        }
    }

    public /* synthetic */ f(Class cls, ye.a aVar, kotlin.jvm.internal.k kVar) {
        this(cls, aVar);
    }

    @Override // xe.x
    public String a() {
        StringBuilder sb2 = new StringBuilder();
        String name = this.f14832a.getName();
        t.e(name, "getName(...)");
        sb2.append(z.E(name, com.amazon.a.a.o.c.a.b.f4610a, '/', false, 4, null));
        sb2.append(".class");
        return sb2.toString();
    }

    @Override // xe.x
    public ye.a b() {
        return this.f14833b;
    }

    @Override // xe.x
    public void c(x.d visitor, byte[] bArr) {
        t.f(visitor, "visitor");
        c.f14829a.i(this.f14832a, visitor);
    }

    @Override // xe.x
    public void d(x.c visitor, byte[] bArr) {
        t.f(visitor, "visitor");
        c.f14829a.b(this.f14832a, visitor);
    }

    public final Class e() {
        return this.f14832a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && t.b(this.f14832a, ((f) obj).f14832a);
    }

    @Override // xe.x
    public ef.b g() {
        return le.f.e(this.f14832a);
    }

    public int hashCode() {
        return this.f14832a.hashCode();
    }

    public String toString() {
        return f.class.getName() + ": " + this.f14832a;
    }

    public f(Class cls, ye.a aVar) {
        this.f14832a = cls;
        this.f14833b = aVar;
    }
}
