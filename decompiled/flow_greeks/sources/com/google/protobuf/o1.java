package com.google.protobuf;

import com.google.protobuf.c0;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class o1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Class f7116a = A();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final u1 f7117b = B();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final u1 f7118c = new w1();

    public static Class A() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessageV3");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static u1 B() {
        try {
            Class clsC = C();
            if (clsC == null) {
                return null;
            }
            return (u1) clsC.getConstructor(null).newInstance(null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Class C() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void D(r rVar, Object obj, Object obj2) {
        u uVarC = rVar.c(obj2);
        if (uVarC.j()) {
            return;
        }
        rVar.d(obj).p(uVarC);
    }

    public static void E(p0 p0Var, Object obj, Object obj2, long j10) {
        y1.V(obj, j10, p0Var.a(y1.G(obj, j10), y1.G(obj2, j10)));
    }

    public static void F(u1 u1Var, Object obj, Object obj2) {
        u1Var.p(obj, u1Var.k(u1Var.g(obj), u1Var.g(obj2)));
    }

    public static void G(Class cls) {
        Class cls2;
        if (!y.class.isAssignableFrom(cls) && (cls2 = f7116a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessageV3 or GeneratedMessageLite");
        }
    }

    public static boolean H(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static Object I(Object obj, int i10, int i11, Object obj2, u1 u1Var) {
        if (obj2 == null) {
            obj2 = u1Var.f(obj);
        }
        u1Var.e(obj2, i10, i11);
        return obj2;
    }

    public static u1 J() {
        return f7117b;
    }

    public static u1 K() {
        return f7118c;
    }

    public static void L(int i10, List list, b2 b2Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b2Var.w(i10, list, z10);
    }

    public static void M(int i10, List list, b2 b2Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b2Var.I(i10, list);
    }

    public static void N(int i10, List list, b2 b2Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b2Var.G(i10, list, z10);
    }

    public static void O(int i10, List list, b2 b2Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b2Var.F(i10, list, z10);
    }

    public static void P(int i10, List list, b2 b2Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b2Var.v(i10, list, z10);
    }

    public static void Q(int i10, List list, b2 b2Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b2Var.s(i10, list, z10);
    }

    public static void R(int i10, List list, b2 b2Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b2Var.a(i10, list, z10);
    }

    public static void S(int i10, List list, b2 b2Var, m1 m1Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b2Var.K(i10, list, m1Var);
    }

    public static void T(int i10, List list, b2 b2Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b2Var.m(i10, list, z10);
    }

    public static void U(int i10, List list, b2 b2Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b2Var.E(i10, list, z10);
    }

    public static void V(int i10, List list, b2 b2Var, m1 m1Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b2Var.J(i10, list, m1Var);
    }

    public static void W(int i10, List list, b2 b2Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b2Var.t(i10, list, z10);
    }

    public static void X(int i10, List list, b2 b2Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b2Var.f(i10, list, z10);
    }

    public static void Y(int i10, List list, b2 b2Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b2Var.C(i10, list, z10);
    }

    public static void Z(int i10, List list, b2 b2Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b2Var.y(i10, list, z10);
    }

    public static int a(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z10 ? l.Q(i10) + l.A(size) : size * l.e(i10, true);
    }

    public static void a0(int i10, List list, b2 b2Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b2Var.j(i10, list);
    }

    public static int b(List list) {
        return list.size();
    }

    public static void b0(int i10, List list, b2 b2Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b2Var.x(i10, list, z10);
    }

    public static int c(int i10, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iQ = size * l.Q(i10);
        for (int i11 = 0; i11 < list.size(); i11++) {
            iQ += l.i((i) list.get(i11));
        }
        return iQ;
    }

    public static void c0(int i10, List list, b2 b2Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b2Var.g(i10, list, z10);
    }

    public static int d(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iE = e(list);
        return z10 ? l.Q(i10) + l.A(iE) : iE + (size * l.Q(i10));
    }

    public static int e(List list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof b0)) {
            int iM = 0;
            while (i10 < size) {
                iM += l.m(((Integer) list.get(i10)).intValue());
                i10++;
            }
            return iM;
        }
        b0 b0Var = (b0) list;
        int iM2 = 0;
        while (i10 < size) {
            iM2 += l.m(b0Var.r(i10));
            i10++;
        }
        return iM2;
    }

    public static int f(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z10 ? l.Q(i10) + l.A(size * 4) : size * l.n(i10, 0);
    }

    public static int g(List list) {
        return list.size() * 4;
    }

    public static int h(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z10 ? l.Q(i10) + l.A(size * 8) : size * l.p(i10, 0L);
    }

    public static int i(List list) {
        return list.size() * 8;
    }

    public static int j(int i10, List list, m1 m1Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iT = 0;
        for (int i11 = 0; i11 < size; i11++) {
            iT += l.t(i10, (u0) list.get(i11), m1Var);
        }
        return iT;
    }

    public static int k(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iL = l(list);
        return z10 ? l.Q(i10) + l.A(iL) : iL + (size * l.Q(i10));
    }

    public static int l(List list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof b0)) {
            int iX = 0;
            while (i10 < size) {
                iX += l.x(((Integer) list.get(i10)).intValue());
                i10++;
            }
            return iX;
        }
        b0 b0Var = (b0) list;
        int iX2 = 0;
        while (i10 < size) {
            iX2 += l.x(b0Var.r(i10));
            i10++;
        }
        return iX2;
    }

    public static int m(int i10, List list, boolean z10) {
        if (list.size() == 0) {
            return 0;
        }
        int iN = n(list);
        return z10 ? l.Q(i10) + l.A(iN) : iN + (list.size() * l.Q(i10));
    }

    public static int n(List list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof l0)) {
            int iZ = 0;
            while (i10 < size) {
                iZ += l.z(((Long) list.get(i10)).longValue());
                i10++;
            }
            return iZ;
        }
        l0 l0Var = (l0) list;
        int iZ2 = 0;
        while (i10 < size) {
            iZ2 += l.z(l0Var.d(i10));
            i10++;
        }
        return iZ2;
    }

    public static int o(int i10, Object obj, m1 m1Var) {
        return l.B(i10, (u0) obj, m1Var);
    }

    public static int p(int i10, List list, m1 m1Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iQ = l.Q(i10) * size;
        for (int i11 = 0; i11 < size; i11++) {
            iQ += l.D((u0) list.get(i11), m1Var);
        }
        return iQ;
    }

    public static int q(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iR = r(list);
        return z10 ? l.Q(i10) + l.A(iR) : iR + (size * l.Q(i10));
    }

    public static int r(List list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof b0)) {
            int iL = 0;
            while (i10 < size) {
                iL += l.L(((Integer) list.get(i10)).intValue());
                i10++;
            }
            return iL;
        }
        b0 b0Var = (b0) list;
        int iL2 = 0;
        while (i10 < size) {
            iL2 += l.L(b0Var.r(i10));
            i10++;
        }
        return iL2;
    }

    public static int s(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iT = t(list);
        return z10 ? l.Q(i10) + l.A(iT) : iT + (size * l.Q(i10));
    }

    public static int t(List list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof l0)) {
            int iN = 0;
            while (i10 < size) {
                iN += l.N(((Long) list.get(i10)).longValue());
                i10++;
            }
            return iN;
        }
        l0 l0Var = (l0) list;
        int iN2 = 0;
        while (i10 < size) {
            iN2 += l.N(l0Var.d(i10));
            i10++;
        }
        return iN2;
    }

    public static int u(int i10, List list) {
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        int iQ = l.Q(i10) * size;
        if (!(list instanceof j0)) {
            while (i11 < size) {
                Object obj = list.get(i11);
                iQ += obj instanceof i ? l.i((i) obj) : l.P((String) obj);
                i11++;
            }
            return iQ;
        }
        j0 j0Var = (j0) list;
        while (i11 < size) {
            Object objM = j0Var.M(i11);
            iQ += objM instanceof i ? l.i((i) objM) : l.P((String) objM);
            i11++;
        }
        return iQ;
    }

    public static int v(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iW = w(list);
        return z10 ? l.Q(i10) + l.A(iW) : iW + (size * l.Q(i10));
    }

    public static int w(List list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof b0)) {
            int iS = 0;
            while (i10 < size) {
                iS += l.S(((Integer) list.get(i10)).intValue());
                i10++;
            }
            return iS;
        }
        b0 b0Var = (b0) list;
        int iS2 = 0;
        while (i10 < size) {
            iS2 += l.S(b0Var.r(i10));
            i10++;
        }
        return iS2;
    }

    public static int x(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iY = y(list);
        return z10 ? l.Q(i10) + l.A(iY) : iY + (size * l.Q(i10));
    }

    public static int y(List list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof l0)) {
            int iU = 0;
            while (i10 < size) {
                iU += l.U(((Long) list.get(i10)).longValue());
                i10++;
            }
            return iU;
        }
        l0 l0Var = (l0) list;
        int iU2 = 0;
        while (i10 < size) {
            iU2 += l.U(l0Var.d(i10));
            i10++;
        }
        return iU2;
    }

    public static Object z(Object obj, int i10, List list, c0.c cVar, Object obj2, u1 u1Var) {
        if (cVar == null) {
            return obj2;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                if (!cVar.a(iIntValue)) {
                    obj2 = I(obj, i10, iIntValue, obj2, u1Var);
                    it.remove();
                }
            }
            return obj2;
        }
        int size = list.size();
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            Integer num = (Integer) list.get(i12);
            int iIntValue2 = num.intValue();
            if (cVar.a(iIntValue2)) {
                if (i12 != i11) {
                    list.set(i11, num);
                }
                i11++;
            } else {
                obj2 = I(obj, i10, iIntValue2, obj2, u1Var);
            }
        }
        if (i11 != size) {
            list.subList(i11, size).clear();
        }
        return obj2;
    }
}
