package com.google.android.gms.internal.play_billing;

import io.flutter.Build;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.i2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1349i2 implements InterfaceC1384p2 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int[] f15430l = new int[0];

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Unsafe f15431m = C2.l();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f15432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f15433b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f15434c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f15435d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final InterfaceC1334f2 f15436e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f15437f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int[] f15438g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f15439h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f15440i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AbstractC1413v2 f15441j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final A1 f15442k;

    public C1349i2(int[] iArr, Object[] objArr, int i8, int i9, InterfaceC1334f2 interfaceC1334f2, boolean z7, int[] iArr2, int i10, int i11, C1359k2 c1359k2, T1 t12, AbstractC1413v2 abstractC1413v2, A1 a12, C1309a2 c1309a2) {
        this.f15432a = iArr;
        this.f15433b = objArr;
        this.f15434c = i8;
        this.f15435d = i9;
        this.f15438g = iArr2;
        this.f15439h = i10;
        this.f15440i = i11;
        this.f15441j = abstractC1413v2;
        this.f15442k = a12;
        this.f15436e = interfaceC1334f2;
    }

    public static float A(Object obj, long j8) {
        return ((Float) C2.k(obj, j8)).floatValue();
    }

    public static int B(Object obj, long j8) {
        return ((Integer) C2.k(obj, j8)).intValue();
    }

    public static int E(int i8) {
        return (i8 >>> 20) & 255;
    }

    public static long G(Object obj, long j8) {
        return ((Long) C2.k(obj, j8)).longValue();
    }

    public static Field M(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e8) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields), e8);
        }
    }

    public static void h(Object obj) {
        if (!s(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    public static boolean r(Object obj, int i8, InterfaceC1384p2 interfaceC1384p2) {
        return interfaceC1384p2.zzk(C2.k(obj, i8 & 1048575));
    }

    public static boolean s(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof J1) {
            return ((J1) obj).x();
        }
        return true;
    }

    public static boolean u(Object obj, long j8) {
        return ((Boolean) C2.k(obj, j8)).booleanValue();
    }

    public static final void v(int i8, Object obj, G2 g22) {
        if (obj instanceof String) {
            g22.c(i8, (String) obj);
        } else {
            g22.f(i8, (AbstractC1378o1) obj);
        }
    }

    public static C1417w2 x(Object obj) {
        J1 j12 = (J1) obj;
        C1417w2 c1417w2 = j12.zzc;
        if (c1417w2 != C1417w2.c()) {
            return c1417w2;
        }
        C1417w2 c1417w2F = C1417w2.f();
        j12.zzc = c1417w2F;
        return c1417w2F;
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0396  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.play_billing.C1349i2 y(java.lang.Class r34, com.google.android.gms.internal.play_billing.InterfaceC1319c2 r35, com.google.android.gms.internal.play_billing.C1359k2 r36, com.google.android.gms.internal.play_billing.T1 r37, com.google.android.gms.internal.play_billing.AbstractC1413v2 r38, com.google.android.gms.internal.play_billing.A1 r39, com.google.android.gms.internal.play_billing.C1309a2 r40) {
        /*
            Method dump skipped, instruction units count: 1042
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.C1349i2.y(java.lang.Class, com.google.android.gms.internal.play_billing.c2, com.google.android.gms.internal.play_billing.k2, com.google.android.gms.internal.play_billing.T1, com.google.android.gms.internal.play_billing.v2, com.google.android.gms.internal.play_billing.A1, com.google.android.gms.internal.play_billing.a2):com.google.android.gms.internal.play_billing.i2");
    }

    public static double z(Object obj, long j8) {
        return ((Double) C2.k(obj, j8)).doubleValue();
    }

    public final int C(int i8) {
        return this.f15432a[i8 + 2];
    }

    public final int D(int i8, int i9) {
        int[] iArr = this.f15432a;
        int length = (iArr.length / 3) - 1;
        while (i9 <= length) {
            int i10 = (length + i9) >>> 1;
            int i11 = i10 * 3;
            int i12 = iArr[i11];
            if (i8 == i12) {
                return i11;
            }
            if (i8 < i12) {
                length = i10 - 1;
            } else {
                i9 = i10 + 1;
            }
        }
        return -1;
    }

    public final int F(int i8) {
        return this.f15432a[i8 + 1];
    }

    public final M1 H(int i8) {
        int i9 = i8 / 3;
        return (M1) this.f15433b[i9 + i9 + 1];
    }

    public final InterfaceC1384p2 I(int i8) {
        Object[] objArr = this.f15433b;
        int i9 = i8 / 3;
        int i10 = i9 + i9;
        InterfaceC1384p2 interfaceC1384p2 = (InterfaceC1384p2) objArr[i10];
        if (interfaceC1384p2 != null) {
            return interfaceC1384p2;
        }
        InterfaceC1384p2 interfaceC1384p2B = C1369m2.a().b((Class) objArr[i10 + 1]);
        objArr[i10] = interfaceC1384p2B;
        return interfaceC1384p2B;
    }

    public final Object J(int i8) {
        int i9 = i8 / 3;
        return this.f15433b[i9 + i9];
    }

    public final Object K(Object obj, int i8) {
        InterfaceC1384p2 interfaceC1384p2I = I(i8);
        int iF = F(i8) & 1048575;
        if (!p(obj, i8)) {
            return interfaceC1384p2I.zze();
        }
        Object object = f15431m.getObject(obj, iF);
        if (s(object)) {
            return object;
        }
        Object objZze = interfaceC1384p2I.zze();
        if (object != null) {
            interfaceC1384p2I.e(objZze, object);
        }
        return objZze;
    }

    public final Object L(Object obj, int i8, int i9) {
        InterfaceC1384p2 interfaceC1384p2I = I(i9);
        if (!t(obj, i8, i9)) {
            return interfaceC1384p2I.zze();
        }
        Object object = f15431m.getObject(obj, F(i9) & 1048575);
        if (s(object)) {
            return object;
        }
        Object objZze = interfaceC1384p2I.zze();
        if (object != null) {
            interfaceC1384p2I.e(objZze, object);
        }
        return objZze;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00f1 A[PHI: r1 r2
      0x00f1: PHI (r1v12 int) = (r1v7 int), (r1v13 int) binds: [B:74:0x010d, B:68:0x00ef] A[DONT_GENERATE, DONT_INLINE]
      0x00f1: PHI (r2v8 java.lang.Object) = (r2v5 java.lang.Object), (r2v9 java.lang.Object) binds: [B:74:0x010d, B:68:0x00ef] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.gms.internal.play_billing.InterfaceC1384p2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(java.lang.Object r9) {
        /*
            Method dump skipped, instruction units count: 462
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.C1349i2.a(java.lang.Object):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v20 */
    @Override // com.google.android.gms.internal.play_billing.InterfaceC1384p2
    public final void b(Object obj, G2 g22) throws Throwable {
        int i8;
        int i9;
        int i10;
        boolean z7;
        boolean z8;
        ?? r9 = 1;
        Throwable th = null;
        if (this.f15437f) {
            android.support.v4.media.session.b.a(obj);
            throw null;
        }
        int[] iArr = this.f15432a;
        Unsafe unsafe = f15431m;
        int i11 = 1048575;
        int i12 = 1048575;
        int i13 = 0;
        int i14 = 0;
        while (i14 < iArr.length) {
            int iF = F(i14);
            int iE = E(iF);
            int i15 = iArr[i14];
            if (iE <= 17) {
                int i16 = iArr[i14 + 2];
                int i17 = i16 & i11;
                if (i17 != i12) {
                    i13 = i17 == i11 ? 0 : unsafe.getInt(obj, i17);
                    i12 = i17;
                }
                i8 = i12;
                i9 = i13;
                i10 = r9 << (i16 >>> 20);
            } else {
                i8 = i12;
                i9 = i13;
                i10 = 0;
            }
            long j8 = iF & i11;
            switch (iE) {
                case 0:
                    if (q(obj, i14, i8, i9, i10)) {
                        g22.zzf(i15, C2.f(obj, j8));
                    }
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case 1:
                    if (q(obj, i14, i8, i9, i10)) {
                        g22.q(i15, C2.g(obj, j8));
                    }
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case 2:
                    if (q(obj, i14, i8, i9, i10)) {
                        g22.g(i15, unsafe.getLong(obj, j8));
                    }
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case 3:
                    if (q(obj, i14, i8, i9, i10)) {
                        g22.y(i15, unsafe.getLong(obj, j8));
                    }
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case 4:
                    if (q(obj, i14, i8, i9, i10)) {
                        g22.m(i15, unsafe.getInt(obj, j8));
                    }
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case 5:
                    if (q(obj, i14, i8, i9, i10)) {
                        g22.w(i15, unsafe.getLong(obj, j8));
                    }
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case 6:
                    if (q(obj, i14, i8, i9, i10)) {
                        g22.zzk(i15, unsafe.getInt(obj, j8));
                    }
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case 7:
                    if (q(obj, i14, i8, i9, i10)) {
                        g22.e(i15, C2.B(obj, j8));
                    }
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case 8:
                    if (q(obj, i14, i8, i9, i10)) {
                        v(i15, unsafe.getObject(obj, j8), g22);
                    }
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case 9:
                    if (q(obj, i14, i8, i9, i10)) {
                        g22.o(i15, unsafe.getObject(obj, j8), I(i14));
                    }
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case 10:
                    if (q(obj, i14, i8, i9, i10)) {
                        g22.f(i15, (AbstractC1378o1) unsafe.getObject(obj, j8));
                    }
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case D3.m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                    if (q(obj, i14, i8, i9, i10)) {
                        g22.d(i15, unsafe.getInt(obj, j8));
                    }
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case 12:
                    if (q(obj, i14, i8, i9, i10)) {
                        g22.zzi(i15, unsafe.getInt(obj, j8));
                    }
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case 13:
                    if (q(obj, i14, i8, i9, i10)) {
                        g22.s(i15, unsafe.getInt(obj, j8));
                    }
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case 14:
                    if (q(obj, i14, i8, i9, i10)) {
                        g22.k(i15, unsafe.getLong(obj, j8));
                    }
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case 15:
                    if (q(obj, i14, i8, i9, i10)) {
                        g22.v(i15, unsafe.getInt(obj, j8));
                    }
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case com.amazon.c.a.a.c.f14230g /* 16 */:
                    if (q(obj, i14, i8, i9, i10)) {
                        g22.n(i15, unsafe.getLong(obj, j8));
                    }
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case 17:
                    if (q(obj, i14, i8, i9, i10)) {
                        g22.a(i15, unsafe.getObject(obj, j8), I(i14));
                    }
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case 18:
                    z7 = false;
                    AbstractC1393r2.w(iArr[i14], (List) unsafe.getObject(obj, j8), g22, false);
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case 19:
                    z7 = false;
                    AbstractC1393r2.A(iArr[i14], (List) unsafe.getObject(obj, j8), g22, false);
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case 20:
                    z7 = false;
                    AbstractC1393r2.C(iArr[i14], (List) unsafe.getObject(obj, j8), g22, false);
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case 21:
                    z7 = false;
                    AbstractC1393r2.d(iArr[i14], (List) unsafe.getObject(obj, j8), g22, false);
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case Build.API_LEVELS.API_22 /* 22 */:
                    z7 = false;
                    AbstractC1393r2.B(iArr[i14], (List) unsafe.getObject(obj, j8), g22, false);
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case Build.API_LEVELS.API_23 /* 23 */:
                    z7 = false;
                    AbstractC1393r2.z(iArr[i14], (List) unsafe.getObject(obj, j8), g22, false);
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case Build.API_LEVELS.API_24 /* 24 */:
                    z7 = false;
                    AbstractC1393r2.y(iArr[i14], (List) unsafe.getObject(obj, j8), g22, false);
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case Build.API_LEVELS.API_25 /* 25 */:
                    z7 = false;
                    AbstractC1393r2.v(iArr[i14], (List) unsafe.getObject(obj, j8), g22, false);
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case Build.API_LEVELS.API_26 /* 26 */:
                    int i18 = iArr[i14];
                    List list = (List) unsafe.getObject(obj, j8);
                    AbstractC1413v2 abstractC1413v2 = AbstractC1393r2.f15496a;
                    if (list != null && !list.isEmpty()) {
                        g22.x(i18, list);
                    }
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case Build.API_LEVELS.API_27 /* 27 */:
                    int i19 = iArr[i14];
                    List list2 = (List) unsafe.getObject(obj, j8);
                    InterfaceC1384p2 interfaceC1384p2I = I(i14);
                    AbstractC1413v2 abstractC1413v22 = AbstractC1393r2.f15496a;
                    if (list2 != null && !list2.isEmpty()) {
                        for (int i20 = 0; i20 < list2.size(); i20 += r9) {
                            ((C1416w1) g22).o(i19, list2.get(i20), interfaceC1384p2I);
                        }
                    }
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case Build.API_LEVELS.API_28 /* 28 */:
                    int i21 = iArr[i14];
                    List list3 = (List) unsafe.getObject(obj, j8);
                    AbstractC1413v2 abstractC1413v23 = AbstractC1393r2.f15496a;
                    if (list3 != null && !list3.isEmpty()) {
                        g22.b(i21, list3);
                    }
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case Build.API_LEVELS.API_29 /* 29 */:
                    z8 = false;
                    AbstractC1393r2.c(iArr[i14], (List) unsafe.getObject(obj, j8), g22, false);
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case Build.API_LEVELS.API_30 /* 30 */:
                    z8 = false;
                    AbstractC1393r2.x(iArr[i14], (List) unsafe.getObject(obj, j8), g22, false);
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case Build.API_LEVELS.API_31 /* 31 */:
                    z8 = false;
                    AbstractC1393r2.D(iArr[i14], (List) unsafe.getObject(obj, j8), g22, false);
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case 32:
                    z8 = false;
                    AbstractC1393r2.E(iArr[i14], (List) unsafe.getObject(obj, j8), g22, false);
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case Build.API_LEVELS.API_33 /* 33 */:
                    z8 = false;
                    AbstractC1393r2.a(iArr[i14], (List) unsafe.getObject(obj, j8), g22, false);
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case Build.API_LEVELS.API_34 /* 34 */:
                    z8 = false;
                    AbstractC1393r2.b(iArr[i14], (List) unsafe.getObject(obj, j8), g22, false);
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case Build.API_LEVELS.API_35 /* 35 */:
                    AbstractC1393r2.w(iArr[i14], (List) unsafe.getObject(obj, j8), g22, r9);
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case Build.API_LEVELS.API_36 /* 36 */:
                    AbstractC1393r2.A(iArr[i14], (List) unsafe.getObject(obj, j8), g22, r9);
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case 37:
                    AbstractC1393r2.C(iArr[i14], (List) unsafe.getObject(obj, j8), g22, r9);
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case 38:
                    AbstractC1393r2.d(iArr[i14], (List) unsafe.getObject(obj, j8), g22, r9);
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case 39:
                    AbstractC1393r2.B(iArr[i14], (List) unsafe.getObject(obj, j8), g22, r9);
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case 40:
                    AbstractC1393r2.z(iArr[i14], (List) unsafe.getObject(obj, j8), g22, r9);
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case 41:
                    AbstractC1393r2.y(iArr[i14], (List) unsafe.getObject(obj, j8), g22, r9);
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case 42:
                    AbstractC1393r2.v(iArr[i14], (List) unsafe.getObject(obj, j8), g22, r9);
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case 43:
                    AbstractC1393r2.c(iArr[i14], (List) unsafe.getObject(obj, j8), g22, r9);
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case 44:
                    AbstractC1393r2.x(iArr[i14], (List) unsafe.getObject(obj, j8), g22, r9);
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case 45:
                    AbstractC1393r2.D(iArr[i14], (List) unsafe.getObject(obj, j8), g22, r9);
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case 46:
                    AbstractC1393r2.E(iArr[i14], (List) unsafe.getObject(obj, j8), g22, r9);
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case 47:
                    AbstractC1393r2.a(iArr[i14], (List) unsafe.getObject(obj, j8), g22, r9);
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case 48:
                    AbstractC1393r2.b(iArr[i14], (List) unsafe.getObject(obj, j8), g22, r9);
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case 49:
                    int i22 = iArr[i14];
                    List list4 = (List) unsafe.getObject(obj, j8);
                    InterfaceC1384p2 interfaceC1384p2I2 = I(i14);
                    AbstractC1413v2 abstractC1413v24 = AbstractC1393r2.f15496a;
                    if (list4 != null && !list4.isEmpty()) {
                        for (int i23 = 0; i23 < list4.size(); i23 += r9) {
                            ((C1416w1) g22).a(i22, list4.get(i23), interfaceC1384p2I2);
                        }
                    }
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case 50:
                    if (unsafe.getObject(obj, j8) != null) {
                        android.support.v4.media.session.b.a(J(i14));
                        throw th;
                    }
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case 51:
                    if (t(obj, i15, i14)) {
                        g22.zzf(i15, z(obj, j8));
                    }
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case 52:
                    if (t(obj, i15, i14)) {
                        g22.q(i15, A(obj, j8));
                    }
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case 53:
                    if (t(obj, i15, i14)) {
                        g22.g(i15, G(obj, j8));
                    }
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case 54:
                    if (t(obj, i15, i14)) {
                        g22.y(i15, G(obj, j8));
                    }
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case 55:
                    if (t(obj, i15, i14)) {
                        g22.m(i15, B(obj, j8));
                    }
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case 56:
                    if (t(obj, i15, i14)) {
                        g22.w(i15, G(obj, j8));
                    }
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case 57:
                    if (t(obj, i15, i14)) {
                        g22.zzk(i15, B(obj, j8));
                    }
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case 58:
                    if (t(obj, i15, i14)) {
                        g22.e(i15, u(obj, j8));
                    }
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case 59:
                    if (t(obj, i15, i14)) {
                        v(i15, unsafe.getObject(obj, j8), g22);
                    }
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case 60:
                    if (t(obj, i15, i14)) {
                        g22.o(i15, unsafe.getObject(obj, j8), I(i14));
                    }
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case 61:
                    if (t(obj, i15, i14)) {
                        g22.f(i15, (AbstractC1378o1) unsafe.getObject(obj, j8));
                    }
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case 62:
                    if (t(obj, i15, i14)) {
                        g22.d(i15, B(obj, j8));
                    }
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case 63:
                    if (t(obj, i15, i14)) {
                        g22.zzi(i15, B(obj, j8));
                    }
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case 64:
                    if (t(obj, i15, i14)) {
                        g22.s(i15, B(obj, j8));
                    }
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case 65:
                    if (t(obj, i15, i14)) {
                        g22.k(i15, G(obj, j8));
                    }
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case 66:
                    if (t(obj, i15, i14)) {
                        g22.v(i15, B(obj, j8));
                    }
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case 67:
                    if (t(obj, i15, i14)) {
                        g22.n(i15, G(obj, j8));
                    }
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                case 68:
                    if (t(obj, i15, i14)) {
                        g22.a(i15, unsafe.getObject(obj, j8), I(i14));
                    }
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
                default:
                    i14 += 3;
                    i12 = i8;
                    i13 = i9;
                    r9 = 1;
                    th = null;
                    i11 = 1048575;
                    break;
            }
        }
        ((J1) obj).zzc.k(g22);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0061  */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.calcSwitchOut(SwitchRegionMaker.java:217)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:125)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    @Override // com.google.android.gms.internal.play_billing.InterfaceC1384p2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(java.lang.Object r8) {
        /*
            Method dump skipped, instruction units count: 208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.C1349i2.c(java.lang.Object):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x01e8, code lost:
    
        r1 = (com.google.android.gms.internal.play_billing.AbstractC1412v1.c(r14 << 3) + com.google.android.gms.internal.play_billing.AbstractC1412v1.c(r0)) + r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0201, code lost:
    
        if (r0 > 0) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x020e, code lost:
    
        if (r0 > 0) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x021b, code lost:
    
        if (r0 > 0) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0228, code lost:
    
        if (r0 > 0) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0235, code lost:
    
        if (r0 > 0) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0244, code lost:
    
        if (r0 > 0) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0251, code lost:
    
        if (r0 > 0) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x025e, code lost:
    
        if (r0 > 0) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x026b, code lost:
    
        if (r0 > 0) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0279, code lost:
    
        if (r0 > 0) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0287, code lost:
    
        if (r0 > 0) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0295, code lost:
    
        if (r0 > 0) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x02a3, code lost:
    
        if (r0 > 0) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ac, code lost:
    
        if (t(r21, r14, r12) != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ae, code lost:
    
        r0 = com.google.android.gms.internal.play_billing.AbstractC1412v1.c(r14 << 3) + 8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00bb, code lost:
    
        if (t(r21, r14, r12) != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00bd, code lost:
    
        r0 = com.google.android.gms.internal.play_billing.AbstractC1412v1.c(r14 << 3) + 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ca, code lost:
    
        if (t(r21, r14, r12) != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00cc, code lost:
    
        r0 = r14 << 3;
        r1 = B(r21, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00d3, code lost:
    
        r0 = com.google.android.gms.internal.play_billing.AbstractC1412v1.c(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x014b, code lost:
    
        if (t(r21, r14, r12) != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0153, code lost:
    
        if (t(r21, r14, r12) != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x015b, code lost:
    
        if (t(r21, r14, r12) != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0163, code lost:
    
        if (t(r21, r14, r12) != false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0165, code lost:
    
        r0 = r14 << 3;
        r1 = G(r21, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0171, code lost:
    
        if (t(r21, r14, r12) != false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0178, code lost:
    
        if (t(r21, r14, r12) != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0180, code lost:
    
        if (t(r21, r14, r12) != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01e6, code lost:
    
        if (r0 > 0) goto L100;
     */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01c6  */
    @Override // com.google.android.gms.internal.play_billing.InterfaceC1384p2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int d(java.lang.Object r21) {
        /*
            Method dump skipped, instruction units count: 1916
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.C1349i2.d(java.lang.Object):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002b  */
    @Override // com.google.android.gms.internal.play_billing.InterfaceC1384p2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(java.lang.Object r9, java.lang.Object r10) {
        /*
            Method dump skipped, instruction units count: 454
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.C1349i2.e(java.lang.Object, java.lang.Object):void");
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC1384p2
    public final boolean f(Object obj, Object obj2) {
        for (int i8 = 0; i8 < this.f15432a.length; i8 += 3) {
            int iF = F(i8);
            long j8 = iF & 1048575;
            switch (E(iF)) {
                case 0:
                    if (!o(obj, obj2, i8) || Double.doubleToLongBits(C2.f(obj, j8)) != Double.doubleToLongBits(C2.f(obj2, j8))) {
                        return false;
                    }
                    break;
                    break;
                case 1:
                    if (!o(obj, obj2, i8) || Float.floatToIntBits(C2.g(obj, j8)) != Float.floatToIntBits(C2.g(obj2, j8))) {
                        return false;
                    }
                    break;
                    break;
                case 2:
                    if (!o(obj, obj2, i8) || C2.i(obj, j8) != C2.i(obj2, j8)) {
                        return false;
                    }
                    break;
                    break;
                case 3:
                    if (!o(obj, obj2, i8) || C2.i(obj, j8) != C2.i(obj2, j8)) {
                        return false;
                    }
                    break;
                    break;
                case 4:
                    if (!o(obj, obj2, i8) || C2.h(obj, j8) != C2.h(obj2, j8)) {
                        return false;
                    }
                    break;
                    break;
                case 5:
                    if (!o(obj, obj2, i8) || C2.i(obj, j8) != C2.i(obj2, j8)) {
                        return false;
                    }
                    break;
                    break;
                case 6:
                    if (!o(obj, obj2, i8) || C2.h(obj, j8) != C2.h(obj2, j8)) {
                        return false;
                    }
                    break;
                    break;
                case 7:
                    if (!o(obj, obj2, i8) || C2.B(obj, j8) != C2.B(obj2, j8)) {
                        return false;
                    }
                    break;
                    break;
                case 8:
                    if (!o(obj, obj2, i8) || !AbstractC1393r2.e(C2.k(obj, j8), C2.k(obj2, j8))) {
                        return false;
                    }
                    break;
                    break;
                case 9:
                    if (!o(obj, obj2, i8) || !AbstractC1393r2.e(C2.k(obj, j8), C2.k(obj2, j8))) {
                        return false;
                    }
                    break;
                    break;
                case 10:
                    if (!o(obj, obj2, i8) || !AbstractC1393r2.e(C2.k(obj, j8), C2.k(obj2, j8))) {
                        return false;
                    }
                    break;
                    break;
                case D3.m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                    if (!o(obj, obj2, i8) || C2.h(obj, j8) != C2.h(obj2, j8)) {
                        return false;
                    }
                    break;
                    break;
                case 12:
                    if (!o(obj, obj2, i8) || C2.h(obj, j8) != C2.h(obj2, j8)) {
                        return false;
                    }
                    break;
                    break;
                case 13:
                    if (!o(obj, obj2, i8) || C2.h(obj, j8) != C2.h(obj2, j8)) {
                        return false;
                    }
                    break;
                    break;
                case 14:
                    if (!o(obj, obj2, i8) || C2.i(obj, j8) != C2.i(obj2, j8)) {
                        return false;
                    }
                    break;
                    break;
                case 15:
                    if (!o(obj, obj2, i8) || C2.h(obj, j8) != C2.h(obj2, j8)) {
                        return false;
                    }
                    break;
                    break;
                case com.amazon.c.a.a.c.f14230g /* 16 */:
                    if (!o(obj, obj2, i8) || C2.i(obj, j8) != C2.i(obj2, j8)) {
                        return false;
                    }
                    break;
                    break;
                case 17:
                    if (!o(obj, obj2, i8) || !AbstractC1393r2.e(C2.k(obj, j8), C2.k(obj2, j8))) {
                        return false;
                    }
                    break;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case Build.API_LEVELS.API_22 /* 22 */:
                case Build.API_LEVELS.API_23 /* 23 */:
                case Build.API_LEVELS.API_24 /* 24 */:
                case Build.API_LEVELS.API_25 /* 25 */:
                case Build.API_LEVELS.API_26 /* 26 */:
                case Build.API_LEVELS.API_27 /* 27 */:
                case Build.API_LEVELS.API_28 /* 28 */:
                case Build.API_LEVELS.API_29 /* 29 */:
                case Build.API_LEVELS.API_30 /* 30 */:
                case Build.API_LEVELS.API_31 /* 31 */:
                case 32:
                case Build.API_LEVELS.API_33 /* 33 */:
                case Build.API_LEVELS.API_34 /* 34 */:
                case Build.API_LEVELS.API_35 /* 35 */:
                case Build.API_LEVELS.API_36 /* 36 */:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                    if (!AbstractC1393r2.e(C2.k(obj, j8), C2.k(obj2, j8))) {
                        return false;
                    }
                    break;
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long jC = C(i8) & 1048575;
                    if (C2.h(obj, jC) != C2.h(obj2, jC) || !AbstractC1393r2.e(C2.k(obj, j8), C2.k(obj2, j8))) {
                        return false;
                    }
                    break;
                    break;
            }
        }
        if (!((J1) obj).zzc.equals(((J1) obj2).zzc)) {
            return false;
        }
        if (!this.f15437f) {
            return true;
        }
        android.support.v4.media.session.b.a(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC1384p2
    public final void g(Object obj, byte[] bArr, int i8, int i9, C1323d1 c1323d1) {
        w(obj, bArr, i8, i9, 0, c1323d1);
    }

    public final void i(Object obj, Object obj2, int i8) {
        if (p(obj2, i8)) {
            int iF = F(i8) & 1048575;
            Unsafe unsafe = f15431m;
            long j8 = iF;
            Object object = unsafe.getObject(obj2, j8);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.f15432a[i8] + " is present but null: " + obj2.toString());
            }
            InterfaceC1384p2 interfaceC1384p2I = I(i8);
            if (!p(obj, i8)) {
                if (s(object)) {
                    Object objZze = interfaceC1384p2I.zze();
                    interfaceC1384p2I.e(objZze, object);
                    unsafe.putObject(obj, j8, objZze);
                } else {
                    unsafe.putObject(obj, j8, object);
                }
                k(obj, i8);
                return;
            }
            Object object2 = unsafe.getObject(obj, j8);
            if (!s(object2)) {
                Object objZze2 = interfaceC1384p2I.zze();
                interfaceC1384p2I.e(objZze2, object2);
                unsafe.putObject(obj, j8, objZze2);
                object2 = objZze2;
            }
            interfaceC1384p2I.e(object2, object);
        }
    }

    public final void j(Object obj, Object obj2, int i8) {
        int[] iArr = this.f15432a;
        int i9 = iArr[i8];
        if (t(obj2, i9, i8)) {
            int iF = F(i8) & 1048575;
            Unsafe unsafe = f15431m;
            long j8 = iF;
            Object object = unsafe.getObject(obj2, j8);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + iArr[i8] + " is present but null: " + obj2.toString());
            }
            InterfaceC1384p2 interfaceC1384p2I = I(i8);
            if (!t(obj, i9, i8)) {
                if (s(object)) {
                    Object objZze = interfaceC1384p2I.zze();
                    interfaceC1384p2I.e(objZze, object);
                    unsafe.putObject(obj, j8, objZze);
                } else {
                    unsafe.putObject(obj, j8, object);
                }
                l(obj, i9, i8);
                return;
            }
            Object object2 = unsafe.getObject(obj, j8);
            if (!s(object2)) {
                Object objZze2 = interfaceC1384p2I.zze();
                interfaceC1384p2I.e(objZze2, object2);
                unsafe.putObject(obj, j8, objZze2);
                object2 = objZze2;
            }
            interfaceC1384p2I.e(object2, object);
        }
    }

    public final void k(Object obj, int i8) {
        int iC = C(i8);
        long j8 = 1048575 & iC;
        if (j8 == 1048575) {
            return;
        }
        C2.v(obj, j8, (1 << (iC >>> 20)) | C2.h(obj, j8));
    }

    public final void l(Object obj, int i8, int i9) {
        C2.v(obj, C(i9) & 1048575, i8);
    }

    public final void m(Object obj, int i8, Object obj2) {
        f15431m.putObject(obj, F(i8) & 1048575, obj2);
        k(obj, i8);
    }

    public final void n(Object obj, int i8, int i9, Object obj2) {
        f15431m.putObject(obj, F(i9) & 1048575, obj2);
        l(obj, i8, i9);
    }

    public final boolean o(Object obj, Object obj2, int i8) {
        return p(obj, i8) == p(obj2, i8);
    }

    public final boolean p(Object obj, int i8) {
        int iC = C(i8);
        long j8 = iC & 1048575;
        if (j8 != 1048575) {
            return (C2.h(obj, j8) & (1 << (iC >>> 20))) != 0;
        }
        int iF = F(i8);
        long j9 = iF & 1048575;
        switch (E(iF)) {
            case 0:
                return Double.doubleToRawLongBits(C2.f(obj, j9)) != 0;
            case 1:
                return Float.floatToRawIntBits(C2.g(obj, j9)) != 0;
            case 2:
                return C2.i(obj, j9) != 0;
            case 3:
                return C2.i(obj, j9) != 0;
            case 4:
                return C2.h(obj, j9) != 0;
            case 5:
                return C2.i(obj, j9) != 0;
            case 6:
                return C2.h(obj, j9) != 0;
            case 7:
                return C2.B(obj, j9);
            case 8:
                Object objK = C2.k(obj, j9);
                if (objK instanceof String) {
                    return !((String) objK).isEmpty();
                }
                if (objK instanceof AbstractC1378o1) {
                    return !AbstractC1378o1.f15475b.equals(objK);
                }
                throw new IllegalArgumentException();
            case 9:
                return C2.k(obj, j9) != null;
            case 10:
                return !AbstractC1378o1.f15475b.equals(C2.k(obj, j9));
            case D3.m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                return C2.h(obj, j9) != 0;
            case 12:
                return C2.h(obj, j9) != 0;
            case 13:
                return C2.h(obj, j9) != 0;
            case 14:
                return C2.i(obj, j9) != 0;
            case 15:
                return C2.h(obj, j9) != 0;
            case com.amazon.c.a.a.c.f14230g /* 16 */:
                return C2.i(obj, j9) != 0;
            case 17:
                return C2.k(obj, j9) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    public final boolean q(Object obj, int i8, int i9, int i10, int i11) {
        return i9 == 1048575 ? p(obj, i8) : (i10 & i11) != 0;
    }

    public final boolean t(Object obj, int i8, int i9) {
        return C2.h(obj, (long) (C(i9) & 1048575)) == i8;
    }

    /* JADX WARN: Code restructure failed: missing block: B:209:0x05d6, code lost:
    
        if (r3 == 0) goto L210;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x05d8, code lost:
    
        r12.add(com.google.android.gms.internal.play_billing.AbstractC1378o1.f15475b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x05de, code lost:
    
        r12.add(com.google.android.gms.internal.play_billing.AbstractC1378o1.H(r36, r2, r3));
        r2 = r2 + r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x05e6, code lost:
    
        if (r2 >= r38) goto L604;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x05e8, code lost:
    
        r3 = com.google.android.gms.internal.play_billing.AbstractC1328e1.i(r36, r2, r40);
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x05ee, code lost:
    
        if (r10 != r40.f15402a) goto L605;
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x05f0, code lost:
    
        r2 = com.google.android.gms.internal.play_billing.AbstractC1328e1.i(r36, r3, r40);
        r3 = r40.f15402a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x05f6, code lost:
    
        if (r3 < 0) goto L528;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x05fa, code lost:
    
        if (r3 > (r36.length - r2)) goto L529;
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x05fc, code lost:
    
        if (r3 != 0) goto L211;
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x0604, code lost:
    
        throw new com.google.android.gms.internal.play_billing.R1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x060c, code lost:
    
        throw new com.google.android.gms.internal.play_billing.R1("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x060d, code lost:
    
        r4 = r34;
        r3 = true;
        r0 = r38;
        r32 = r14;
        r8 = r30;
        r1 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:512:0x05e6, code lost:
    
        r12.add(com.google.android.gms.internal.play_billing.AbstractC1378o1.H(r36, r2, r3));
        r2 = r2 + r3;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:251:0x06ac  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x06fa  */
    /* JADX WARN: Removed duplicated region for block: B:472:0x0b9c  */
    /* JADX WARN: Removed duplicated region for block: B:474:0x0bb0  */
    /* JADX WARN: Removed duplicated region for block: B:481:0x0bc4  */
    /* JADX WARN: Removed duplicated region for block: B:484:0x0be6  */
    /* JADX WARN: Removed duplicated region for block: B:550:0x0902 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:554:0x0055 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:580:0x0917 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:219:0x05fc -> B:210:0x05d8). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:255:0x06bc -> B:247:0x069b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:274:0x070a -> B:265:0x06e1). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int w(java.lang.Object r35, byte[] r36, int r37, int r38, int r39, com.google.android.gms.internal.play_billing.C1323d1 r40) {
        /*
            Method dump skipped, instruction units count: 3306
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.C1349i2.w(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.play_billing.d1):int");
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC1384p2
    public final Object zze() {
        return ((J1) this.f15436e).n();
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x009d  */
    @Override // com.google.android.gms.internal.play_billing.InterfaceC1384p2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzk(java.lang.Object r19) {
        /*
            Method dump skipped, instruction units count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.C1349i2.zzk(java.lang.Object):boolean");
    }
}
