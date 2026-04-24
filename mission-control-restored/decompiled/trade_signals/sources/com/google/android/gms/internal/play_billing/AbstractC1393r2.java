package com.google.android.gms.internal.play_billing;

import java.util.List;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.r2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1393r2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AbstractC1413v2 f15496a;

    static {
        C1369m2 c1369m2 = C1369m2.f15457c;
        f15496a = new C1421x2();
    }

    public static void A(int i8, List list, G2 g22, boolean z7) {
        if (list == null || list.isEmpty()) {
            return;
        }
        g22.u(i8, list, z7);
    }

    public static void B(int i8, List list, G2 g22, boolean z7) {
        if (list == null || list.isEmpty()) {
            return;
        }
        g22.j(i8, list, z7);
    }

    public static void C(int i8, List list, G2 g22, boolean z7) {
        if (list == null || list.isEmpty()) {
            return;
        }
        g22.r(i8, list, z7);
    }

    public static void D(int i8, List list, G2 g22, boolean z7) {
        if (list == null || list.isEmpty()) {
            return;
        }
        g22.zzy(i8, list, z7);
    }

    public static void E(int i8, List list, G2 g22, boolean z7) {
        if (list == null || list.isEmpty()) {
            return;
        }
        g22.zzA(i8, list, z7);
    }

    public static void a(int i8, List list, G2 g22, boolean z7) {
        if (list == null || list.isEmpty()) {
            return;
        }
        g22.zzC(i8, list, z7);
    }

    public static void b(int i8, List list, G2 g22, boolean z7) {
        if (list == null || list.isEmpty()) {
            return;
        }
        g22.zzE(i8, list, z7);
    }

    public static void c(int i8, List list, G2 g22, boolean z7) {
        if (list == null || list.isEmpty()) {
            return;
        }
        g22.zzJ(i8, list, z7);
    }

    public static void d(int i8, List list, G2 g22, boolean z7) {
        if (list == null || list.isEmpty()) {
            return;
        }
        g22.zzL(i8, list, z7);
    }

    public static boolean e(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int f(List list) {
        int iD;
        int size = list.size();
        int i8 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof K1) {
            K1 k12 = (K1) list;
            iD = 0;
            while (i8 < size) {
                iD += AbstractC1412v1.d(k12.d(i8));
                i8++;
            }
        } else {
            iD = 0;
            while (i8 < size) {
                iD += AbstractC1412v1.d(((Integer) list.get(i8)).intValue());
                i8++;
            }
        }
        return iD;
    }

    public static int g(int i8, List list, boolean z7) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (AbstractC1412v1.c(i8 << 3) + 4);
    }

    public static int h(List list) {
        return list.size() * 4;
    }

    public static int i(int i8, List list, boolean z7) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (AbstractC1412v1.c(i8 << 3) + 8);
    }

    public static int j(List list) {
        return list.size() * 8;
    }

    public static int k(List list) {
        int iD;
        int size = list.size();
        int i8 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof K1) {
            K1 k12 = (K1) list;
            iD = 0;
            while (i8 < size) {
                iD += AbstractC1412v1.d(k12.d(i8));
                i8++;
            }
        } else {
            iD = 0;
            while (i8 < size) {
                iD += AbstractC1412v1.d(((Integer) list.get(i8)).intValue());
                i8++;
            }
        }
        return iD;
    }

    public static int l(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iD = 0;
        for (int i8 = 0; i8 < size; i8++) {
            iD += AbstractC1412v1.d(((Long) list.get(i8)).longValue());
        }
        return iD;
    }

    public static int m(int i8, Object obj, InterfaceC1384p2 interfaceC1384p2) {
        return AbstractC1412v1.c(i8 << 3) + AbstractC1412v1.a((InterfaceC1334f2) obj, interfaceC1384p2);
    }

    public static int n(List list) {
        int iC;
        int size = list.size();
        int i8 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof K1) {
            K1 k12 = (K1) list;
            iC = 0;
            while (i8 < size) {
                int iD = k12.d(i8);
                iC += AbstractC1412v1.c((iD >> 31) ^ (iD + iD));
                i8++;
            }
        } else {
            iC = 0;
            while (i8 < size) {
                int iIntValue = ((Integer) list.get(i8)).intValue();
                iC += AbstractC1412v1.c((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i8++;
            }
        }
        return iC;
    }

    public static int o(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iD = 0;
        for (int i8 = 0; i8 < size; i8++) {
            long jLongValue = ((Long) list.get(i8)).longValue();
            iD += AbstractC1412v1.d((jLongValue >> 63) ^ (jLongValue + jLongValue));
        }
        return iD;
    }

    public static int p(List list) {
        int iC;
        int size = list.size();
        int i8 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof K1) {
            K1 k12 = (K1) list;
            iC = 0;
            while (i8 < size) {
                iC += AbstractC1412v1.c(k12.d(i8));
                i8++;
            }
        } else {
            iC = 0;
            while (i8 < size) {
                iC += AbstractC1412v1.c(((Integer) list.get(i8)).intValue());
                i8++;
            }
        }
        return iC;
    }

    public static int q(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iD = 0;
        for (int i8 = 0; i8 < size; i8++) {
            iD += AbstractC1412v1.d(((Long) list.get(i8)).longValue());
        }
        return iD;
    }

    public static AbstractC1413v2 r() {
        return f15496a;
    }

    public static Object s(Object obj, int i8, int i9, Object obj2, AbstractC1413v2 abstractC1413v2) {
        if (obj2 == null) {
            obj2 = abstractC1413v2.a(obj);
        }
        ((C1417w2) obj2).j(i8 << 3, Long.valueOf(i9));
        return obj2;
    }

    public static void t(A1 a12, Object obj, Object obj2) {
        android.support.v4.media.session.b.a(obj2);
        throw null;
    }

    public static void u(AbstractC1413v2 abstractC1413v2, Object obj, Object obj2) {
        J1 j12 = (J1) obj;
        C1417w2 c1417w2E = j12.zzc;
        C1417w2 c1417w2 = ((J1) obj2).zzc;
        if (!C1417w2.c().equals(c1417w2)) {
            if (C1417w2.c().equals(c1417w2E)) {
                c1417w2E = C1417w2.e(c1417w2E, c1417w2);
            } else {
                c1417w2E.d(c1417w2);
            }
        }
        j12.zzc = c1417w2E;
    }

    public static void v(int i8, List list, G2 g22, boolean z7) {
        if (list == null || list.isEmpty()) {
            return;
        }
        g22.h(i8, list, z7);
    }

    public static void w(int i8, List list, G2 g22, boolean z7) {
        if (list == null || list.isEmpty()) {
            return;
        }
        g22.t(i8, list, z7);
    }

    public static void x(int i8, List list, G2 g22, boolean z7) {
        if (list == null || list.isEmpty()) {
            return;
        }
        g22.l(i8, list, z7);
    }

    public static void y(int i8, List list, G2 g22, boolean z7) {
        if (list == null || list.isEmpty()) {
            return;
        }
        g22.i(i8, list, z7);
    }

    public static void z(int i8, List list, G2 g22, boolean z7) {
        if (list == null || list.isEmpty()) {
            return;
        }
        g22.p(i8, list, z7);
    }
}
