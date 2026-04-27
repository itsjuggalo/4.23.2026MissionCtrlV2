package v7;

import kotlin.jvm.internal.AbstractC2304t;
import u7.C2811d;
import u7.C2814g;
import u7.M;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2814g f23909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C2814g f23910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C2814g f23911c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C2814g f23912d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C2814g f23913e;

    static {
        C2814g.a aVar = C2814g.f23648d;
        f23909a = aVar.a("/");
        f23910b = aVar.a("\\");
        f23911c = aVar.a("/\\");
        f23912d = aVar.a(".");
        f23913e = aVar.a("..");
    }

    public static final M j(M m8, M child, boolean z7) {
        AbstractC2304t.f(m8, "<this>");
        AbstractC2304t.f(child, "child");
        if (child.k() || child.I() != null) {
            return child;
        }
        C2814g c2814gM = m(m8);
        if (c2814gM == null && (c2814gM = m(child)) == null) {
            c2814gM = s(M.f23584c);
        }
        C2811d c2811d = new C2811d();
        c2811d.y0(m8.b());
        if (c2811d.s0() > 0) {
            c2811d.y0(c2814gM);
        }
        c2811d.y0(child.b());
        return q(c2811d, z7);
    }

    public static final M k(String str, boolean z7) {
        AbstractC2304t.f(str, "<this>");
        return q(new C2811d().G(str), z7);
    }

    public static final int l(M m8) {
        int iL = C2814g.L(m8.b(), f23909a, 0, 2, null);
        return iL != -1 ? iL : C2814g.L(m8.b(), f23910b, 0, 2, null);
    }

    public static final C2814g m(M m8) {
        C2814g c2814gB = m8.b();
        C2814g c2814g = f23909a;
        if (C2814g.B(c2814gB, c2814g, 0, 2, null) != -1) {
            return c2814g;
        }
        C2814g c2814gB2 = m8.b();
        C2814g c2814g2 = f23910b;
        if (C2814g.B(c2814gB2, c2814g2, 0, 2, null) != -1) {
            return c2814g2;
        }
        return null;
    }

    public static final boolean n(M m8) {
        return m8.b().i(f23913e) && (m8.b().R() == 2 || m8.b().N(m8.b().R() + (-3), f23909a, 0, 1) || m8.b().N(m8.b().R() + (-3), f23910b, 0, 1));
    }

    public static final int o(M m8) {
        if (m8.b().R() == 0) {
            return -1;
        }
        if (m8.b().k(0) == 47) {
            return 1;
        }
        if (m8.b().k(0) == 92) {
            if (m8.b().R() <= 2 || m8.b().k(1) != 92) {
                return 1;
            }
            int iT = m8.b().t(f23910b, 2);
            return iT == -1 ? m8.b().R() : iT;
        }
        if (m8.b().R() > 2 && m8.b().k(1) == 58 && m8.b().k(2) == 92) {
            char cK = (char) m8.b().k(0);
            if ('a' <= cK && cK < '{') {
                return 3;
            }
            if ('A' <= cK && cK < '[') {
                return 3;
            }
        }
        return -1;
    }

    public static final boolean p(C2811d c2811d, C2814g c2814g) {
        if (!AbstractC2304t.b(c2814g, f23910b) || c2811d.s0() < 2 || c2811d.K(1L) != 58) {
            return false;
        }
        char cK = (char) c2811d.K(0L);
        return ('a' <= cK && cK < '{') || ('A' <= cK && cK < '[');
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final u7.M q(u7.C2811d r16, boolean r17) throws java.io.EOFException {
        /*
            Method dump skipped, instruction units count: 290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v7.d.q(u7.d, boolean):u7.M");
    }

    public static final C2814g r(byte b8) {
        if (b8 == 47) {
            return f23909a;
        }
        if (b8 == 92) {
            return f23910b;
        }
        throw new IllegalArgumentException("not a directory separator: " + ((int) b8));
    }

    public static final C2814g s(String str) {
        if (AbstractC2304t.b(str, "/")) {
            return f23909a;
        }
        if (AbstractC2304t.b(str, "\\")) {
            return f23910b;
        }
        throw new IllegalArgumentException("not a directory separator: " + str);
    }
}
