package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.u;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Class f1941a = A();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e1 f1942b = B();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e1 f1943c = new g1();

    public static Class A() {
        if (t0.f1908d) {
            return null;
        }
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static e1 B() {
        try {
            Class clsC = C();
            if (clsC == null) {
                return null;
            }
            return (e1) clsC.getConstructor(null).newInstance(null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Class C() {
        if (t0.f1908d) {
            return null;
        }
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void D(n nVar, Object obj, Object obj2) {
        q qVarC = nVar.c(obj2);
        if (qVarC.j()) {
            return;
        }
        nVar.d(obj).p(qVarC);
    }

    public static void E(e0 e0Var, Object obj, Object obj2, long j10) {
        h1.O(obj, j10, e0Var.a(h1.z(obj, j10), h1.z(obj2, j10)));
    }

    public static void F(e1 e1Var, Object obj, Object obj2) {
        e1Var.p(obj, e1Var.k(e1Var.g(obj), e1Var.g(obj2)));
    }

    public static void G(Class cls) {
        Class cls2;
        if (!t.class.isAssignableFrom(cls) && !t0.f1908d && (cls2 = f1941a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static boolean H(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static Object I(Object obj, int i10, int i11, Object obj2, e1 e1Var) {
        if (obj2 == null) {
            obj2 = e1Var.f(obj);
        }
        e1Var.e(obj2, i10, i11);
        return obj2;
    }

    public static e1 J() {
        return f1942b;
    }

    public static e1 K() {
        return f1943c;
    }

    public static void L(int i10, List list, k1 k1Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        k1Var.w(i10, list, z10);
    }

    public static void M(int i10, List list, k1 k1Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        k1Var.I(i10, list);
    }

    public static void N(int i10, List list, k1 k1Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        k1Var.G(i10, list, z10);
    }

    public static void O(int i10, List list, k1 k1Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        k1Var.F(i10, list, z10);
    }

    public static void P(int i10, List list, k1 k1Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        k1Var.v(i10, list, z10);
    }

    public static void Q(int i10, List list, k1 k1Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        k1Var.s(i10, list, z10);
    }

    public static void R(int i10, List list, k1 k1Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        k1Var.a(i10, list, z10);
    }

    public static void S(int i10, List list, k1 k1Var, x0 x0Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        k1Var.K(i10, list, x0Var);
    }

    public static void T(int i10, List list, k1 k1Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        k1Var.m(i10, list, z10);
    }

    public static void U(int i10, List list, k1 k1Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        k1Var.E(i10, list, z10);
    }

    public static void V(int i10, List list, k1 k1Var, x0 x0Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        k1Var.J(i10, list, x0Var);
    }

    public static void W(int i10, List list, k1 k1Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        k1Var.t(i10, list, z10);
    }

    public static void X(int i10, List list, k1 k1Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        k1Var.f(i10, list, z10);
    }

    public static void Y(int i10, List list, k1 k1Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        k1Var.C(i10, list, z10);
    }

    public static void Z(int i10, List list, k1 k1Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        k1Var.y(i10, list, z10);
    }

    public static int a(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z10 ? i.O(i10) + i.y(size) : size * i.c(i10, true);
    }

    public static void a0(int i10, List list, k1 k1Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        k1Var.j(i10, list);
    }

    public static int b(List list) {
        return list.size();
    }

    public static void b0(int i10, List list, k1 k1Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        k1Var.x(i10, list, z10);
    }

    public static int c(int i10, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iO = size * i.O(i10);
        for (int i11 = 0; i11 < list.size(); i11++) {
            iO += i.g((f) list.get(i11));
        }
        return iO;
    }

    public static void c0(int i10, List list, k1 k1Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        k1Var.g(i10, list, z10);
    }

    public static int d(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iE = e(list);
        return z10 ? i.O(i10) + i.y(iE) : iE + (size * i.O(i10));
    }

    public static int e(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iK = 0;
        for (int i10 = 0; i10 < size; i10++) {
            iK += i.k(((Integer) list.get(i10)).intValue());
        }
        return iK;
    }

    public static int f(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z10 ? i.O(i10) + i.y(size * 4) : size * i.l(i10, 0);
    }

    public static int g(List list) {
        return list.size() * 4;
    }

    public static int h(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z10 ? i.O(i10) + i.y(size * 8) : size * i.n(i10, 0L);
    }

    public static int i(List list) {
        return list.size() * 8;
    }

    public static int j(int i10, List list, x0 x0Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iR = 0;
        for (int i11 = 0; i11 < size; i11++) {
            iR += i.r(i10, (j0) list.get(i11), x0Var);
        }
        return iR;
    }

    public static int k(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iL = l(list);
        return z10 ? i.O(i10) + i.y(iL) : iL + (size * i.O(i10));
    }

    public static int l(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iV = 0;
        for (int i10 = 0; i10 < size; i10++) {
            iV += i.v(((Integer) list.get(i10)).intValue());
        }
        return iV;
    }

    public static int m(int i10, List list, boolean z10) {
        if (list.size() == 0) {
            return 0;
        }
        int iN = n(list);
        return z10 ? i.O(i10) + i.y(iN) : iN + (list.size() * i.O(i10));
    }

    public static int n(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iX = 0;
        for (int i10 = 0; i10 < size; i10++) {
            iX += i.x(((Long) list.get(i10)).longValue());
        }
        return iX;
    }

    public static int o(int i10, Object obj, x0 x0Var) {
        return i.z(i10, (j0) obj, x0Var);
    }

    public static int p(int i10, List list, x0 x0Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iO = i.O(i10) * size;
        for (int i11 = 0; i11 < size; i11++) {
            iO += i.B((j0) list.get(i11), x0Var);
        }
        return iO;
    }

    public static int q(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iR = r(list);
        return z10 ? i.O(i10) + i.y(iR) : iR + (size * i.O(i10));
    }

    public static int r(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iJ = 0;
        for (int i10 = 0; i10 < size; i10++) {
            iJ += i.J(((Integer) list.get(i10)).intValue());
        }
        return iJ;
    }

    public static int s(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iT = t(list);
        return z10 ? i.O(i10) + i.y(iT) : iT + (size * i.O(i10));
    }

    public static int t(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iL = 0;
        for (int i10 = 0; i10 < size; i10++) {
            iL += i.L(((Long) list.get(i10)).longValue());
        }
        return iL;
    }

    public static int u(int i10, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iO = i.O(i10) * size;
        for (int i11 = 0; i11 < size; i11++) {
            Object obj = list.get(i11);
            iO += obj instanceof f ? i.g((f) obj) : i.N((String) obj);
        }
        return iO;
    }

    public static int v(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iW = w(list);
        return z10 ? i.O(i10) + i.y(iW) : iW + (size * i.O(i10));
    }

    public static int w(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iQ = 0;
        for (int i10 = 0; i10 < size; i10++) {
            iQ += i.Q(((Integer) list.get(i10)).intValue());
        }
        return iQ;
    }

    public static int x(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iY = y(list);
        return z10 ? i.O(i10) + i.y(iY) : iY + (size * i.O(i10));
    }

    public static int y(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iS = 0;
        for (int i10 = 0; i10 < size; i10++) {
            iS += i.S(((Long) list.get(i10)).longValue());
        }
        return iS;
    }

    public static Object z(Object obj, int i10, List list, u.a aVar, Object obj2, e1 e1Var) {
        if (aVar == null) {
            return obj2;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                if (!aVar.a(iIntValue)) {
                    obj2 = I(obj, i10, iIntValue, obj2, e1Var);
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
            if (aVar.a(iIntValue2)) {
                if (i12 != i11) {
                    list.set(i11, num);
                }
                i11++;
            } else {
                obj2 = I(obj, i10, iIntValue2, obj2, e1Var);
            }
        }
        if (i11 != size) {
            list.subList(i11, size).clear();
        }
        return obj2;
    }
}
