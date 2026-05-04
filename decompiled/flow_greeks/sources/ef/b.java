package ef;

import kg.c0;
import kg.z;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f8779d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f8780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f8781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f8782c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public static /* synthetic */ b b(a aVar, String str, boolean z10, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                z10 = false;
            }
            return aVar.a(str, z10);
        }

        public final b a(String string, boolean z10) {
            String strF;
            String str;
            t.f(string, "string");
            int iB0 = c0.b0(string, '`', 0, false, 6, null);
            if (iB0 == -1) {
                iB0 = string.length();
            }
            int iI0 = c0.i0(string, "/", iB0, false, 4, null);
            if (iI0 == -1) {
                strF = z.F(string, "`", "", false, 4, null);
                str = "";
            } else {
                String strSubstring = string.substring(0, iI0);
                t.e(strSubstring, "substring(...)");
                String strE = z.E(strSubstring, '/', com.amazon.a.a.o.c.a.b.f4610a, false, 4, null);
                String strSubstring2 = string.substring(iI0 + 1);
                t.e(strSubstring2, "substring(...)");
                strF = z.F(strSubstring2, "`", "", false, 4, null);
                str = strE;
            }
            return new b(new c(str), new c(strF), z10);
        }

        public final b c(c topLevelFqName) {
            t.f(topLevelFqName, "topLevelFqName");
            return new b(topLevelFqName.d(), topLevelFqName.f());
        }

        public a() {
        }
    }

    public b(c packageFqName, c relativeClassName, boolean z10) {
        t.f(packageFqName, "packageFqName");
        t.f(relativeClassName, "relativeClassName");
        this.f8780a = packageFqName;
        this.f8781b = relativeClassName;
        this.f8782c = z10;
        relativeClassName.c();
    }

    public static final String c(c cVar) {
        String strA = cVar.a();
        if (!c0.O(strA, '/', false, 2, null)) {
            return strA;
        }
        return '`' + strA + '`';
    }

    public static final b k(c cVar) {
        return f8779d.c(cVar);
    }

    public final c a() {
        if (this.f8780a.c()) {
            return this.f8781b;
        }
        return new c(this.f8780a.a() + com.amazon.a.a.o.c.a.b.f4610a + this.f8781b.a());
    }

    public final String b() {
        if (this.f8780a.c()) {
            return c(this.f8781b);
        }
        return z.E(this.f8780a.a(), com.amazon.a.a.o.c.a.b.f4610a, '/', false, 4, null) + "/" + c(this.f8781b);
    }

    public final b d(f name) {
        t.f(name, "name");
        return new b(this.f8780a, this.f8781b.b(name), this.f8782c);
    }

    public final b e() {
        c cVarD = this.f8781b.d();
        if (cVarD.c()) {
            return null;
        }
        return new b(this.f8780a, cVarD, this.f8782c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return t.b(this.f8780a, bVar.f8780a) && t.b(this.f8781b, bVar.f8781b) && this.f8782c == bVar.f8782c;
    }

    public final c f() {
        return this.f8780a;
    }

    public final c g() {
        return this.f8781b;
    }

    public final f h() {
        return this.f8781b.f();
    }

    public int hashCode() {
        return (((this.f8780a.hashCode() * 31) + this.f8781b.hashCode()) * 31) + Boolean.hashCode(this.f8782c);
    }

    public final boolean i() {
        return this.f8782c;
    }

    public final boolean j() {
        return !this.f8781b.d().c();
    }

    public String toString() {
        if (!this.f8780a.c()) {
            return b();
        }
        return '/' + b();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(c packageFqName, f topLevelName) {
        this(packageFqName, c.f8783c.a(topLevelName), false);
        t.f(packageFqName, "packageFqName");
        t.f(topLevelName, "topLevelName");
    }
}
