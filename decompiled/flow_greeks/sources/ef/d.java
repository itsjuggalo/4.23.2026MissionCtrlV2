package ef;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import kg.c0;
import kg.z;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f8787e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final f f8788f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Pattern f8789g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient c f8791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient d f8792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public transient f f8793d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final d a(f shortName) {
            t.f(shortName, "shortName");
            String strB = shortName.b();
            t.e(strB, "asString(...)");
            return new d(strB, c.f8784d.i(), shortName, null);
        }

        public a() {
        }
    }

    static {
        f fVarO = f.o("<root>");
        t.e(fVarO, "special(...)");
        f8788f = fVarO;
        Pattern patternCompile = Pattern.compile("\\.");
        t.e(patternCompile, "compile(...)");
        f8789g = patternCompile;
    }

    public /* synthetic */ d(String str, d dVar, f fVar, kotlin.jvm.internal.k kVar) {
        this(str, dVar, fVar);
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
        return this.f8790a;
    }

    public final d b(f name) {
        String strB;
        t.f(name, "name");
        if (e()) {
            strB = name.b();
        } else {
            strB = this.f8790a + com.amazon.a.a.o.c.a.b.f4610a + name.b();
        }
        t.c(strB);
        return new d(strB, this, name);
    }

    public final void c() {
        int iD = d(this.f8790a);
        if (iD < 0) {
            this.f8793d = f.i(this.f8790a);
            this.f8792c = c.f8784d.i();
            return;
        }
        String strSubstring = this.f8790a.substring(iD + 1);
        t.e(strSubstring, "substring(...)");
        this.f8793d = f.i(strSubstring);
        String strSubstring2 = this.f8790a.substring(0, iD);
        t.e(strSubstring2, "substring(...)");
        this.f8792c = new d(strSubstring2);
    }

    public final int d(String str) {
        int length = str.length() - 1;
        boolean z10 = false;
        while (length >= 0) {
            char cCharAt = str.charAt(length);
            if (cCharAt == '.' && !z10) {
                return length;
            }
            if (cCharAt == '`') {
                z10 = !z10;
            } else if (cCharAt == '\\') {
                length--;
            }
            length--;
        }
        return -1;
    }

    public final boolean e() {
        return this.f8790a.length() == 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof d) && t.b(this.f8790a, ((d) obj).f8790a);
    }

    public final boolean f() {
        return this.f8791b != null || c0.b0(a(), '<', 0, false, 6, null) < 0;
    }

    public final d g() {
        d dVar = this.f8792c;
        if (dVar != null) {
            return dVar;
        }
        if (e()) {
            throw new IllegalStateException("root");
        }
        c();
        d dVar2 = this.f8792c;
        t.c(dVar2);
        return dVar2;
    }

    public final List h() {
        return i(this);
    }

    public int hashCode() {
        return this.f8790a.hashCode();
    }

    public final f j() {
        f fVar = this.f8793d;
        if (fVar != null) {
            return fVar;
        }
        if (e()) {
            throw new IllegalStateException("root");
        }
        c();
        f fVar2 = this.f8793d;
        t.c(fVar2);
        return fVar2;
    }

    public final f k() {
        return e() ? f8788f : j();
    }

    public final boolean l(f segment) {
        t.f(segment, "segment");
        if (e()) {
            return false;
        }
        int iB0 = c0.b0(this.f8790a, com.amazon.a.a.o.c.a.b.f4610a, 0, false, 6, null);
        if (iB0 == -1) {
            iB0 = this.f8790a.length();
        }
        int i10 = iB0;
        String strB = segment.b();
        t.e(strB, "asString(...)");
        return i10 == strB.length() && z.A(this.f8790a, 0, strB, 0, i10, false, 16, null);
    }

    public final c m() {
        c cVar = this.f8791b;
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c(this);
        this.f8791b = cVar2;
        return cVar2;
    }

    public String toString() {
        if (!e()) {
            return this.f8790a;
        }
        String strB = f8788f.b();
        t.e(strB, "asString(...)");
        return strB;
    }

    public d(String fqName, c safe) {
        t.f(fqName, "fqName");
        t.f(safe, "safe");
        this.f8790a = fqName;
        this.f8791b = safe;
    }

    public d(String fqName) {
        t.f(fqName, "fqName");
        this.f8790a = fqName;
    }

    public d(String str, d dVar, f fVar) {
        this.f8790a = str;
        this.f8792c = dVar;
        this.f8793d = fVar;
    }
}
