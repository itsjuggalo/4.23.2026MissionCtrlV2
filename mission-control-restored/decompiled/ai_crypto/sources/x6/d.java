package x6;

import F5.s;
import F5.v;
import java.io.EOFException;
import java.util.ArrayList;
import kotlin.jvm.internal.r;
import w6.C2792e;
import w6.C2795h;
import w6.Q;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2795h f25327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C2795h f25328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C2795h f25329c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C2795h f25330d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C2795h f25331e;

    static {
        C2795h.a aVar = C2795h.f25106d;
        f25327a = aVar.c("/");
        f25328b = aVar.c("\\");
        f25329c = aVar.c("/\\");
        f25330d = aVar.c(".");
        f25331e = aVar.c("..");
    }

    public static final Q j(Q q7, Q child, boolean z7) {
        r.f(q7, "<this>");
        r.f(child, "child");
        if (child.i() || child.s() != null) {
            return child;
        }
        C2795h c2795hM = m(q7);
        if (c2795hM == null && (c2795hM = m(child)) == null) {
            c2795hM = s(Q.f25041c);
        }
        C2792e c2792e = new C2792e();
        c2792e.m(q7.b());
        if (c2792e.E0() > 0) {
            c2792e.m(c2795hM);
        }
        c2792e.m(child.b());
        return q(c2792e, z7);
    }

    public static final Q k(String str, boolean z7) {
        r.f(str, "<this>");
        return q(new C2792e().I(str), z7);
    }

    public static final int l(Q q7) {
        int iY = C2795h.y(q7.b(), f25327a, 0, 2, null);
        return iY != -1 ? iY : C2795h.y(q7.b(), f25328b, 0, 2, null);
    }

    public static final C2795h m(Q q7) {
        C2795h c2795hB = q7.b();
        C2795h c2795h = f25327a;
        if (C2795h.t(c2795hB, c2795h, 0, 2, null) != -1) {
            return c2795h;
        }
        C2795h c2795hB2 = q7.b();
        C2795h c2795h2 = f25328b;
        if (C2795h.t(c2795hB2, c2795h2, 0, 2, null) != -1) {
            return c2795h2;
        }
        return null;
    }

    public static final boolean n(Q q7) {
        return q7.b().k(f25331e) && (q7.b().H() == 2 || q7.b().B(q7.b().H() + (-3), f25327a, 0, 1) || q7.b().B(q7.b().H() + (-3), f25328b, 0, 1));
    }

    public static final int o(Q q7) {
        if (q7.b().H() == 0) {
            return -1;
        }
        if (q7.b().l(0) == 47) {
            return 1;
        }
        if (q7.b().l(0) == 92) {
            if (q7.b().H() <= 2 || q7.b().l(1) != 92) {
                return 1;
            }
            int iR = q7.b().r(f25328b, 2);
            return iR == -1 ? q7.b().H() : iR;
        }
        if (q7.b().H() > 2 && q7.b().l(1) == 58 && q7.b().l(2) == 92) {
            char cL = (char) q7.b().l(0);
            if ('a' <= cL && cL < '{') {
                return 3;
            }
            if ('A' <= cL && cL < '[') {
                return 3;
            }
        }
        return -1;
    }

    public static final boolean p(C2792e c2792e, C2795h c2795h) {
        if (!r.b(c2795h, f25328b) || c2792e.E0() < 2 || c2792e.T(1L) != 58) {
            return false;
        }
        char cT = (char) c2792e.T(0L);
        return ('a' <= cT && cT < '{') || ('A' <= cT && cT < '[');
    }

    public static final Q q(C2792e c2792e, boolean z7) throws EOFException {
        C2795h c2795h;
        C2795h c2795hO;
        r.f(c2792e, "<this>");
        C2792e c2792e2 = new C2792e();
        C2795h c2795hR = null;
        int i7 = 0;
        while (true) {
            if (!c2792e.R(0L, f25327a)) {
                c2795h = f25328b;
                if (!c2792e.R(0L, c2795h)) {
                    break;
                }
            }
            byte b7 = c2792e.readByte();
            if (c2795hR == null) {
                c2795hR = r(b7);
            }
            i7++;
        }
        boolean z8 = i7 >= 2 && r.b(c2795hR, c2795h);
        if (z8) {
            r.c(c2795hR);
            c2792e2.m(c2795hR);
            c2792e2.m(c2795hR);
        } else if (i7 > 0) {
            r.c(c2795hR);
            c2792e2.m(c2795hR);
        } else {
            long jX = c2792e.X(f25329c);
            if (c2795hR == null) {
                c2795hR = jX == -1 ? s(Q.f25041c) : r(c2792e.T(jX));
            }
            if (p(c2792e, c2795hR)) {
                if (jX == 2) {
                    c2792e2.L(c2792e, 3L);
                } else {
                    c2792e2.L(c2792e, 2L);
                }
            }
        }
        boolean z9 = c2792e2.E0() > 0;
        ArrayList arrayList = new ArrayList();
        while (!c2792e.u()) {
            long jX2 = c2792e.X(f25329c);
            if (jX2 == -1) {
                c2795hO = c2792e.A0();
            } else {
                c2795hO = c2792e.o(jX2);
                c2792e.readByte();
            }
            C2795h c2795h2 = f25331e;
            if (r.b(c2795hO, c2795h2)) {
                if (!z9 || !arrayList.isEmpty()) {
                    if (!z7 || (!z9 && (arrayList.isEmpty() || r.b(v.S(arrayList), c2795h2)))) {
                        arrayList.add(c2795hO);
                    } else if (!z8 || arrayList.size() != 1) {
                        s.z(arrayList);
                    }
                }
            } else if (!r.b(c2795hO, f25330d) && !r.b(c2795hO, C2795h.f25107e)) {
                arrayList.add(c2795hO);
            }
        }
        int size = arrayList.size();
        for (int i8 = 0; i8 < size; i8++) {
            if (i8 > 0) {
                c2792e2.m(c2795hR);
            }
            c2792e2.m((C2795h) arrayList.get(i8));
        }
        if (c2792e2.E0() == 0) {
            c2792e2.m(f25330d);
        }
        return new Q(c2792e2.A0());
    }

    public static final C2795h r(byte b7) {
        if (b7 == 47) {
            return f25327a;
        }
        if (b7 == 92) {
            return f25328b;
        }
        throw new IllegalArgumentException("not a directory separator: " + ((int) b7));
    }

    public static final C2795h s(String str) {
        if (r.b(str, "/")) {
            return f25327a;
        }
        if (r.b(str, "\\")) {
            return f25328b;
        }
        throw new IllegalArgumentException("not a directory separator: " + str);
    }
}
