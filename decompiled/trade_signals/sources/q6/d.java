package q6;

import V6.A;
import V6.C;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f22663e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final f f22664f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Pattern f22665g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient c f22667b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient d f22668c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public transient f f22669d;

    public static final class a {
        public a() {
        }

        public final d a(f shortName) {
            AbstractC2304t.f(shortName, "shortName");
            String strB = shortName.b();
            AbstractC2304t.e(strB, "asString(...)");
            return new d(strB, c.f22660d.i(), shortName, null);
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    static {
        f fVarQ = f.q("<root>");
        AbstractC2304t.e(fVarQ, "special(...)");
        f22664f = fVarQ;
        Pattern patternCompile = Pattern.compile("\\.");
        AbstractC2304t.e(patternCompile, "compile(...)");
        f22665g = patternCompile;
    }

    public d(String fqName) {
        AbstractC2304t.f(fqName, "fqName");
        this.f22666a = fqName;
    }

    public static final List i(d dVar) {
        if (dVar.e()) {
            return new ArrayList();
        }
        List listI = i(dVar.g());
        listI.add(dVar.j());
        return listI;
    }

    public final String a() {
        return this.f22666a;
    }

    public final d b(f name) {
        String strB;
        AbstractC2304t.f(name, "name");
        if (e()) {
            strB = name.b();
        } else {
            strB = this.f22666a + com.amazon.a.a.o.c.a.b.f14112a + name.b();
        }
        AbstractC2304t.c(strB);
        return new d(strB, this, name);
    }

    public final void c() {
        int iD = d(this.f22666a);
        if (iD < 0) {
            this.f22669d = f.k(this.f22666a);
            this.f22668c = c.f22660d.i();
            return;
        }
        String strSubstring = this.f22666a.substring(iD + 1);
        AbstractC2304t.e(strSubstring, "substring(...)");
        this.f22669d = f.k(strSubstring);
        String strSubstring2 = this.f22666a.substring(0, iD);
        AbstractC2304t.e(strSubstring2, "substring(...)");
        this.f22668c = new d(strSubstring2);
    }

    public final int d(String str) {
        int length = str.length() - 1;
        boolean z7 = false;
        while (length >= 0) {
            char cCharAt = str.charAt(length);
            if (cCharAt == '.' && !z7) {
                return length;
            }
            if (cCharAt == '`') {
                z7 = !z7;
            } else if (cCharAt == '\\') {
                length--;
            }
            length--;
        }
        return -1;
    }

    public final boolean e() {
        return this.f22666a.length() == 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof d) && AbstractC2304t.b(this.f22666a, ((d) obj).f22666a);
    }

    public final boolean f() {
        return this.f22667b != null || C.X(a(), '<', 0, false, 6, null) < 0;
    }

    public final d g() {
        d dVar = this.f22668c;
        if (dVar != null) {
            return dVar;
        }
        if (!(!e())) {
            throw new IllegalStateException("root".toString());
        }
        c();
        d dVar2 = this.f22668c;
        AbstractC2304t.c(dVar2);
        return dVar2;
    }

    public final List h() {
        return i(this);
    }

    public int hashCode() {
        return this.f22666a.hashCode();
    }

    public final f j() {
        f fVar = this.f22669d;
        if (fVar != null) {
            return fVar;
        }
        if (!(!e())) {
            throw new IllegalStateException("root".toString());
        }
        c();
        f fVar2 = this.f22669d;
        AbstractC2304t.c(fVar2);
        return fVar2;
    }

    public final f k() {
        return e() ? f22664f : j();
    }

    public final boolean l(f segment) {
        AbstractC2304t.f(segment, "segment");
        if (e()) {
            return false;
        }
        int iX = C.X(this.f22666a, com.amazon.a.a.o.c.a.b.f14112a, 0, false, 6, null);
        if (iX == -1) {
            iX = this.f22666a.length();
        }
        int i8 = iX;
        String strB = segment.b();
        AbstractC2304t.e(strB, "asString(...)");
        return i8 == strB.length() && A.z(this.f22666a, 0, strB, 0, i8, false, 16, null);
    }

    public final c m() {
        c cVar = this.f22667b;
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c(this);
        this.f22667b = cVar2;
        return cVar2;
    }

    public String toString() {
        if (!e()) {
            return this.f22666a;
        }
        String strB = f22664f.b();
        AbstractC2304t.e(strB, "asString(...)");
        return strB;
    }

    public d(String fqName, c safe) {
        AbstractC2304t.f(fqName, "fqName");
        AbstractC2304t.f(safe, "safe");
        this.f22666a = fqName;
        this.f22667b = safe;
    }

    public d(String str, d dVar, f fVar) {
        this.f22666a = str;
        this.f22668c = dVar;
        this.f22669d = fVar;
    }

    public /* synthetic */ d(String str, d dVar, f fVar, AbstractC2296k abstractC2296k) {
        this(str, dVar, fVar);
    }
}
