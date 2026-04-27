package com.google.protobuf;

import com.google.protobuf.C;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public abstract class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Class f11141a = B();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final w0 f11142b = C();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final w0 f11143c = new y0();

    public static Object A(Object obj, int i4, List list, C.e eVar, Object obj2, w0 w0Var) {
        if (eVar == null) {
            return obj2;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                if (!eVar.a(iIntValue)) {
                    obj2 = J(obj, i4, iIntValue, obj2, w0Var);
                    it.remove();
                }
            }
            return obj2;
        }
        int size = list.size();
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            Integer num = (Integer) list.get(i6);
            int iIntValue2 = num.intValue();
            if (eVar.a(iIntValue2)) {
                if (i6 != i5) {
                    list.set(i5, num);
                }
                i5++;
            } else {
                obj2 = J(obj, i4, iIntValue2, obj2, w0Var);
            }
        }
        if (i5 != size) {
            list.subList(i5, size).clear();
        }
        return obj2;
    }

    public static Class B() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessageV3");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static w0 C() {
        try {
            Class clsD = D();
            if (clsD == null) {
                return null;
            }
            return (w0) clsD.getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Class D() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void E(r rVar, Object obj, Object obj2) {
        C1073u c1073uC = rVar.c(obj2);
        if (c1073uC.m()) {
            return;
        }
        rVar.d(obj).t(c1073uC);
    }

    public static void F(Q q4, Object obj, Object obj2, long j4) {
        A0.V(obj, j4, q4.a(A0.G(obj, j4), A0.G(obj2, j4)));
    }

    public static void G(w0 w0Var, Object obj, Object obj2) {
        w0Var.p(obj, w0Var.k(w0Var.g(obj), w0Var.g(obj2)));
    }

    public static void H(Class cls) {
        Class cls2;
        if (!AbstractC1077y.class.isAssignableFrom(cls) && (cls2 = f11141a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessageV3 or GeneratedMessageLite");
        }
    }

    public static boolean I(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static Object J(Object obj, int i4, int i5, Object obj2, w0 w0Var) {
        if (obj2 == null) {
            obj2 = w0Var.f(obj);
        }
        w0Var.e(obj2, i4, i5);
        return obj2;
    }

    public static w0 K() {
        return f11142b;
    }

    public static w0 L() {
        return f11143c;
    }

    public static void M(int i4, List list, D0 d02, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d02.w(i4, list, z4);
    }

    public static void N(int i4, List list, D0 d02) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d02.I(i4, list);
    }

    public static void O(int i4, List list, D0 d02, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d02.G(i4, list, z4);
    }

    public static void P(int i4, List list, D0 d02, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d02.F(i4, list, z4);
    }

    public static void Q(int i4, List list, D0 d02, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d02.v(i4, list, z4);
    }

    public static void R(int i4, List list, D0 d02, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d02.s(i4, list, z4);
    }

    public static void S(int i4, List list, D0 d02, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d02.a(i4, list, z4);
    }

    public static void T(int i4, List list, D0 d02, o0 o0Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d02.K(i4, list, o0Var);
    }

    public static void U(int i4, List list, D0 d02, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d02.m(i4, list, z4);
    }

    public static void V(int i4, List list, D0 d02, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d02.E(i4, list, z4);
    }

    public static void W(int i4, List list, D0 d02, o0 o0Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d02.J(i4, list, o0Var);
    }

    public static void X(int i4, List list, D0 d02, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d02.t(i4, list, z4);
    }

    public static void Y(int i4, List list, D0 d02, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d02.f(i4, list, z4);
    }

    public static void Z(int i4, List list, D0 d02, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d02.C(i4, list, z4);
    }

    public static int a(int i4, List list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z4 ? AbstractC1065l.S(i4) + AbstractC1065l.A(size) : size * AbstractC1065l.e(i4, true);
    }

    public static void a0(int i4, List list, D0 d02, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d02.y(i4, list, z4);
    }

    public static int b(List list) {
        return list.size();
    }

    public static void b0(int i4, List list, D0 d02) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d02.j(i4, list);
    }

    public static int c(int i4, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iS = size * AbstractC1065l.S(i4);
        for (int i5 = 0; i5 < list.size(); i5++) {
            iS += AbstractC1065l.i((AbstractC1062i) list.get(i5));
        }
        return iS;
    }

    public static void c0(int i4, List list, D0 d02, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d02.x(i4, list, z4);
    }

    public static int d(int i4, List list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iE = e(list);
        return z4 ? AbstractC1065l.S(i4) + AbstractC1065l.A(iE) : iE + (size * AbstractC1065l.S(i4));
    }

    public static void d0(int i4, List list, D0 d02, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d02.g(i4, list, z4);
    }

    public static int e(List list) {
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof B)) {
            int iM = 0;
            while (i4 < size) {
                iM += AbstractC1065l.m(((Integer) list.get(i4)).intValue());
                i4++;
            }
            return iM;
        }
        B b4 = (B) list;
        int iM2 = 0;
        while (i4 < size) {
            iM2 += AbstractC1065l.m(b4.p(i4));
            i4++;
        }
        return iM2;
    }

    public static int f(int i4, List list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z4 ? AbstractC1065l.S(i4) + AbstractC1065l.A(size * 4) : size * AbstractC1065l.n(i4, 0);
    }

    public static int g(List list) {
        return list.size() * 4;
    }

    public static int h(int i4, List list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z4 ? AbstractC1065l.S(i4) + AbstractC1065l.A(size * 8) : size * AbstractC1065l.p(i4, 0L);
    }

    public static int i(List list) {
        return list.size() * 8;
    }

    public static int j(int i4, List list, o0 o0Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iT = 0;
        for (int i5 = 0; i5 < size; i5++) {
            iT += AbstractC1065l.t(i4, (W) list.get(i5), o0Var);
        }
        return iT;
    }

    public static int k(int i4, List list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iL = l(list);
        return z4 ? AbstractC1065l.S(i4) + AbstractC1065l.A(iL) : iL + (size * AbstractC1065l.S(i4));
    }

    public static int l(List list) {
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof B)) {
            int iX = 0;
            while (i4 < size) {
                iX += AbstractC1065l.x(((Integer) list.get(i4)).intValue());
                i4++;
            }
            return iX;
        }
        B b4 = (B) list;
        int iX2 = 0;
        while (i4 < size) {
            iX2 += AbstractC1065l.x(b4.p(i4));
            i4++;
        }
        return iX2;
    }

    public static int m(int i4, List list, boolean z4) {
        if (list.size() == 0) {
            return 0;
        }
        int iN = n(list);
        return z4 ? AbstractC1065l.S(i4) + AbstractC1065l.A(iN) : iN + (list.size() * AbstractC1065l.S(i4));
    }

    public static int n(List list) {
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof M)) {
            int iZ = 0;
            while (i4 < size) {
                iZ += AbstractC1065l.z(((Long) list.get(i4)).longValue());
                i4++;
            }
            return iZ;
        }
        M m4 = (M) list;
        int iZ2 = 0;
        while (i4 < size) {
            iZ2 += AbstractC1065l.z(m4.p(i4));
            i4++;
        }
        return iZ2;
    }

    public static int o(int i4, Object obj, o0 o0Var) {
        return AbstractC1065l.D(i4, (W) obj, o0Var);
    }

    public static int p(int i4, List list, o0 o0Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iS = AbstractC1065l.S(i4) * size;
        for (int i5 = 0; i5 < size; i5++) {
            iS += AbstractC1065l.F((W) list.get(i5), o0Var);
        }
        return iS;
    }

    public static int q(int i4, List list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iR = r(list);
        return z4 ? AbstractC1065l.S(i4) + AbstractC1065l.A(iR) : iR + (size * AbstractC1065l.S(i4));
    }

    public static int r(List list) {
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof B)) {
            int iN = 0;
            while (i4 < size) {
                iN += AbstractC1065l.N(((Integer) list.get(i4)).intValue());
                i4++;
            }
            return iN;
        }
        B b4 = (B) list;
        int iN2 = 0;
        while (i4 < size) {
            iN2 += AbstractC1065l.N(b4.p(i4));
            i4++;
        }
        return iN2;
    }

    public static int s(int i4, List list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iT = t(list);
        return z4 ? AbstractC1065l.S(i4) + AbstractC1065l.A(iT) : iT + (size * AbstractC1065l.S(i4));
    }

    public static int t(List list) {
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof M)) {
            int iP = 0;
            while (i4 < size) {
                iP += AbstractC1065l.P(((Long) list.get(i4)).longValue());
                i4++;
            }
            return iP;
        }
        M m4 = (M) list;
        int iP2 = 0;
        while (i4 < size) {
            iP2 += AbstractC1065l.P(m4.p(i4));
            i4++;
        }
        return iP2;
    }

    public static int u(int i4, List list) {
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        int iS = AbstractC1065l.S(i4) * size;
        if (!(list instanceof K)) {
            while (i5 < size) {
                Object obj = list.get(i5);
                iS += obj instanceof AbstractC1062i ? AbstractC1065l.i((AbstractC1062i) obj) : AbstractC1065l.R((String) obj);
                i5++;
            }
            return iS;
        }
        K k4 = (K) list;
        while (i5 < size) {
            Object objJ = k4.j(i5);
            iS += objJ instanceof AbstractC1062i ? AbstractC1065l.i((AbstractC1062i) objJ) : AbstractC1065l.R((String) objJ);
            i5++;
        }
        return iS;
    }

    public static int v(int i4, List list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iW = w(list);
        return z4 ? AbstractC1065l.S(i4) + AbstractC1065l.A(iW) : iW + (size * AbstractC1065l.S(i4));
    }

    public static int w(List list) {
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof B)) {
            int iU = 0;
            while (i4 < size) {
                iU += AbstractC1065l.U(((Integer) list.get(i4)).intValue());
                i4++;
            }
            return iU;
        }
        B b4 = (B) list;
        int iU2 = 0;
        while (i4 < size) {
            iU2 += AbstractC1065l.U(b4.p(i4));
            i4++;
        }
        return iU2;
    }

    public static int x(int i4, List list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iY = y(list);
        return z4 ? AbstractC1065l.S(i4) + AbstractC1065l.A(iY) : iY + (size * AbstractC1065l.S(i4));
    }

    public static int y(List list) {
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof M)) {
            int iW = 0;
            while (i4 < size) {
                iW += AbstractC1065l.W(((Long) list.get(i4)).longValue());
                i4++;
            }
            return iW;
        }
        M m4 = (M) list;
        int iW2 = 0;
        while (i4 < size) {
            iW2 += AbstractC1065l.W(m4.p(i4));
            i4++;
        }
        return iW2;
    }

    public static Object z(Object obj, int i4, List list, C.d dVar, Object obj2, w0 w0Var) {
        if (dVar == null) {
            return obj2;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                if (dVar.a(iIntValue) == null) {
                    obj2 = J(obj, i4, iIntValue, obj2, w0Var);
                    it.remove();
                }
            }
            return obj2;
        }
        int size = list.size();
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            Integer num = (Integer) list.get(i6);
            int iIntValue2 = num.intValue();
            if (dVar.a(iIntValue2) != null) {
                if (i6 != i5) {
                    list.set(i5, num);
                }
                i5++;
            } else {
                obj2 = J(obj, i4, iIntValue2, obj2, w0Var);
            }
        }
        if (i5 != size) {
            list.subList(i5, size).clear();
        }
        return obj2;
    }
}
