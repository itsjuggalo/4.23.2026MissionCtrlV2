package q6;

import V6.A;
import V6.C;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f22655d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f22656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f22657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f22658c;

    public static final class a {
        public a() {
        }

        public static /* synthetic */ b b(a aVar, String str, boolean z7, int i8, Object obj) {
            if ((i8 & 2) != 0) {
                z7 = false;
            }
            return aVar.a(str, z7);
        }

        public final b a(String string, boolean z7) {
            String strE;
            String str;
            AbstractC2304t.f(string, "string");
            int iX = C.X(string, '`', 0, false, 6, null);
            if (iX == -1) {
                iX = string.length();
            }
            int iE0 = C.e0(string, "/", iX, false, 4, null);
            if (iE0 == -1) {
                strE = A.E(string, "`", "", false, 4, null);
                str = "";
            } else {
                String strSubstring = string.substring(0, iE0);
                AbstractC2304t.e(strSubstring, "substring(...)");
                String strD = A.D(strSubstring, '/', com.amazon.a.a.o.c.a.b.f14112a, false, 4, null);
                String strSubstring2 = string.substring(iE0 + 1);
                AbstractC2304t.e(strSubstring2, "substring(...)");
                strE = A.E(strSubstring2, "`", "", false, 4, null);
                str = strD;
            }
            return new b(new c(str), new c(strE), z7);
        }

        public final b c(c topLevelFqName) {
            AbstractC2304t.f(topLevelFqName, "topLevelFqName");
            return new b(topLevelFqName.d(), topLevelFqName.f());
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public b(c packageFqName, c relativeClassName, boolean z7) {
        AbstractC2304t.f(packageFqName, "packageFqName");
        AbstractC2304t.f(relativeClassName, "relativeClassName");
        this.f22656a = packageFqName;
        this.f22657b = relativeClassName;
        this.f22658c = z7;
        relativeClassName.c();
    }

    public static final String c(c cVar) {
        String strA = cVar.a();
        if (!C.K(strA, '/', false, 2, null)) {
            return strA;
        }
        return '`' + strA + '`';
    }

    public static final b k(c cVar) {
        return f22655d.c(cVar);
    }

    public final c a() {
        if (this.f22656a.c()) {
            return this.f22657b;
        }
        return new c(this.f22656a.a() + com.amazon.a.a.o.c.a.b.f14112a + this.f22657b.a());
    }

    public final String b() {
        if (this.f22656a.c()) {
            return c(this.f22657b);
        }
        return A.D(this.f22656a.a(), com.amazon.a.a.o.c.a.b.f14112a, '/', false, 4, null) + "/" + c(this.f22657b);
    }

    public final b d(f name) {
        AbstractC2304t.f(name, "name");
        return new b(this.f22656a, this.f22657b.b(name), this.f22658c);
    }

    public final b e() {
        c cVarD = this.f22657b.d();
        if (!cVarD.c()) {
            return new b(this.f22656a, cVarD, this.f22658c);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return AbstractC2304t.b(this.f22656a, bVar.f22656a) && AbstractC2304t.b(this.f22657b, bVar.f22657b) && this.f22658c == bVar.f22658c;
    }

    public final c f() {
        return this.f22656a;
    }

    public final c g() {
        return this.f22657b;
    }

    public final f h() {
        return this.f22657b.f();
    }

    public int hashCode() {
        return (((this.f22656a.hashCode() * 31) + this.f22657b.hashCode()) * 31) + Boolean.hashCode(this.f22658c);
    }

    public final boolean i() {
        return this.f22658c;
    }

    public final boolean j() {
        return !this.f22657b.d().c();
    }

    public String toString() {
        if (!this.f22656a.c()) {
            return b();
        }
        return '/' + b();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(c packageFqName, f topLevelName) {
        this(packageFqName, c.f22659c.a(topLevelName), false);
        AbstractC2304t.f(packageFqName, "packageFqName");
        AbstractC2304t.f(topLevelName, "topLevelName");
    }
}
