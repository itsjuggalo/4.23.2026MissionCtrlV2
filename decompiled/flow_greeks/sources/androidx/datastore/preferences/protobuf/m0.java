package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.j1;
import androidx.datastore.preferences.protobuf.k1;
import androidx.datastore.preferences.protobuf.u;
import com.revenuecat.purchases.common.events.EventsManager;
import com.revenuecat.purchases.utils.PurchaseParamsValidator;
import io.flutter.Build;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class m0 implements x0 {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int[] f1810r = new int[0];

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Unsafe f1811s = h1.A();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f1812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f1813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1814c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1815d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j0 f1816e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f1817f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f1818g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final s0 f1819h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f1820i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int[] f1821j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f1822k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f1823l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final o0 f1824m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final y f1825n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final e1 f1826o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final n f1827p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final e0 f1828q;

    public m0(int[] iArr, Object[] objArr, int i10, int i11, j0 j0Var, s0 s0Var, boolean z10, int[] iArr2, int i12, int i13, o0 o0Var, y yVar, e1 e1Var, n nVar, e0 e0Var) {
        this.f1812a = iArr;
        this.f1813b = objArr;
        this.f1814c = i10;
        this.f1815d = i11;
        this.f1818g = j0Var instanceof t;
        this.f1819h = s0Var;
        this.f1817f = nVar != null && nVar.e(j0Var);
        this.f1820i = z10;
        this.f1821j = iArr2;
        this.f1822k = i12;
        this.f1823l = i13;
        this.f1824m = o0Var;
        this.f1825n = yVar;
        this.f1826o = e1Var;
        this.f1827p = nVar;
        this.f1816e = j0Var;
        this.f1828q = e0Var;
    }

    public static boolean B(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof t) {
            return ((t) obj).C();
        }
        return true;
    }

    public static boolean E(int i10) {
        return (i10 & 268435456) != 0;
    }

    public static long F(Object obj, long j10) {
        return h1.x(obj, j10);
    }

    public static m0 N(Class cls, h0 h0Var, o0 o0Var, y yVar, e1 e1Var, n nVar, e0 e0Var) {
        if (h0Var instanceof v0) {
            return P((v0) h0Var, o0Var, yVar, e1Var, nVar, e0Var);
        }
        android.support.v4.media.session.b.a(h0Var);
        return O(null, o0Var, yVar, e1Var, nVar, e0Var);
    }

    public static m0 O(b1 b1Var, o0 o0Var, y yVar, e1 e1Var, n nVar, e0 e0Var) {
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0375  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.datastore.preferences.protobuf.m0 P(androidx.datastore.preferences.protobuf.v0 r33, androidx.datastore.preferences.protobuf.o0 r34, androidx.datastore.preferences.protobuf.y r35, androidx.datastore.preferences.protobuf.e1 r36, androidx.datastore.preferences.protobuf.n r37, androidx.datastore.preferences.protobuf.e0 r38) {
        /*
            Method dump skipped, instruction units count: 1008
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.m0.P(androidx.datastore.preferences.protobuf.v0, androidx.datastore.preferences.protobuf.o0, androidx.datastore.preferences.protobuf.y, androidx.datastore.preferences.protobuf.e1, androidx.datastore.preferences.protobuf.n, androidx.datastore.preferences.protobuf.e0):androidx.datastore.preferences.protobuf.m0");
    }

    public static long R(int i10) {
        return i10 & 1048575;
    }

    public static boolean S(Object obj, long j10) {
        return ((Boolean) h1.z(obj, j10)).booleanValue();
    }

    public static double T(Object obj, long j10) {
        return ((Double) h1.z(obj, j10)).doubleValue();
    }

    public static float U(Object obj, long j10) {
        return ((Float) h1.z(obj, j10)).floatValue();
    }

    public static int V(Object obj, long j10) {
        return ((Integer) h1.z(obj, j10)).intValue();
    }

    public static long W(Object obj, long j10) {
        return ((Long) h1.z(obj, j10)).longValue();
    }

    public static Field d0(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    public static int j0(int i10) {
        return (i10 & 267386880) >>> 20;
    }

    public static boolean k(Object obj, long j10) {
        return h1.p(obj, j10);
    }

    public static void l(Object obj) {
        if (B(obj)) {
            return;
        }
        throw new IllegalArgumentException("Mutating immutable message: " + obj);
    }

    public static double m(Object obj, long j10) {
        return h1.u(obj, j10);
    }

    public static float p(Object obj, long j10) {
        return h1.v(obj, j10);
    }

    public static int u(Object obj, long j10) {
        return h1.w(obj, j10);
    }

    public static boolean v(int i10) {
        return (i10 & 536870912) != 0;
    }

    public static boolean y(Object obj, int i10, x0 x0Var) {
        return x0Var.c(h1.z(obj, R(i10)));
    }

    public final boolean A(Object obj, int i10, int i11) {
        Map mapH = this.f1828q.h(h1.z(obj, R(i10)));
        if (mapH.isEmpty()) {
            return true;
        }
        if (this.f1828q.c(r(i11)).f1672c.a() != j1.c.MESSAGE) {
            return true;
        }
        x0 x0VarC = null;
        for (Object obj2 : mapH.values()) {
            if (x0VarC == null) {
                x0VarC = t0.a().c(obj2.getClass());
            }
            if (!x0VarC.c(obj2)) {
                return false;
            }
        }
        return true;
    }

    public final boolean C(Object obj, Object obj2, int i10) {
        long jY = Y(i10) & 1048575;
        return h1.w(obj, jY) == h1.w(obj2, jY);
    }

    public final boolean D(Object obj, int i10, int i11) {
        return h1.w(obj, (long) (Y(i11) & 1048575)) == i10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:328:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:329:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a8, code lost:
    
        r0 = r10.f1822k;
        r4 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00ad, code lost:
    
        if (r0 >= r10.f1823l) goto L326;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00af, code lost:
    
        r4 = r10.o(r2, r10.f1821j[r0], r4, r5, r20);
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00c0, code lost:
    
        if (r4 == null) goto L328;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00c2, code lost:
    
        r5.o(r2, r4);
     */
    /* JADX WARN: Removed duplicated region for block: B:229:0x06d2 A[Catch: all -> 0x06f3, TRY_LEAVE, TryCatch #10 {all -> 0x06f3, blocks: (B:227:0x06cc, B:229:0x06d2, B:240:0x06f7, B:241:0x06fc), top: B:272:0x06cc }] */
    /* JADX WARN: Removed duplicated region for block: B:239:0x06f5  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x072d A[LOOP:4: B:254:0x0729->B:256:0x072d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0740  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void G(androidx.datastore.preferences.protobuf.e1 r18, androidx.datastore.preferences.protobuf.n r19, java.lang.Object r20, androidx.datastore.preferences.protobuf.w0 r21, androidx.datastore.preferences.protobuf.m r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 2002
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.m0.G(androidx.datastore.preferences.protobuf.e1, androidx.datastore.preferences.protobuf.n, java.lang.Object, androidx.datastore.preferences.protobuf.w0, androidx.datastore.preferences.protobuf.m):void");
    }

    public final void H(Object obj, int i10, Object obj2, m mVar, w0 w0Var) {
        long jR = R(k0(i10));
        Object objZ = h1.z(obj, jR);
        if (objZ == null) {
            objZ = this.f1828q.e(obj2);
            h1.O(obj, jR, objZ);
        } else if (this.f1828q.g(objZ)) {
            Object objE = this.f1828q.e(obj2);
            this.f1828q.a(objE, objZ);
            h1.O(obj, jR, objE);
            objZ = objE;
        }
        w0Var.K(this.f1828q.d(objZ), this.f1828q.c(obj2), mVar);
    }

    public final void I(Object obj, Object obj2, int i10) {
        if (w(obj2, i10)) {
            long jR = R(k0(i10));
            Unsafe unsafe = f1811s;
            Object object = unsafe.getObject(obj2, jR);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + Q(i10) + " is present but null: " + obj2);
            }
            x0 x0VarS = s(i10);
            if (!w(obj, i10)) {
                if (B(object)) {
                    Object objF = x0VarS.f();
                    x0VarS.a(objF, object);
                    unsafe.putObject(obj, jR, objF);
                } else {
                    unsafe.putObject(obj, jR, object);
                }
                e0(obj, i10);
                return;
            }
            Object object2 = unsafe.getObject(obj, jR);
            if (!B(object2)) {
                Object objF2 = x0VarS.f();
                x0VarS.a(objF2, object2);
                unsafe.putObject(obj, jR, objF2);
                object2 = objF2;
            }
            x0VarS.a(object2, object);
        }
    }

    public final void J(Object obj, Object obj2, int i10) {
        int iQ = Q(i10);
        if (D(obj2, iQ, i10)) {
            long jR = R(k0(i10));
            Unsafe unsafe = f1811s;
            Object object = unsafe.getObject(obj2, jR);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + Q(i10) + " is present but null: " + obj2);
            }
            x0 x0VarS = s(i10);
            if (!D(obj, iQ, i10)) {
                if (B(object)) {
                    Object objF = x0VarS.f();
                    x0VarS.a(objF, object);
                    unsafe.putObject(obj, jR, objF);
                } else {
                    unsafe.putObject(obj, jR, object);
                }
                f0(obj, iQ, i10);
                return;
            }
            Object object2 = unsafe.getObject(obj, jR);
            if (!B(object2)) {
                Object objF2 = x0VarS.f();
                x0VarS.a(objF2, object2);
                unsafe.putObject(obj, jR, objF2);
                object2 = objF2;
            }
            x0VarS.a(object2, object);
        }
    }

    public final void K(Object obj, Object obj2, int i10) {
        int iK0 = k0(i10);
        long jR = R(iK0);
        int iQ = Q(i10);
        switch (j0(iK0)) {
            case 0:
                if (w(obj2, i10)) {
                    h1.K(obj, jR, h1.u(obj2, jR));
                    e0(obj, i10);
                }
                break;
            case 1:
                if (w(obj2, i10)) {
                    h1.L(obj, jR, h1.v(obj2, jR));
                    e0(obj, i10);
                }
                break;
            case 2:
                if (w(obj2, i10)) {
                    h1.N(obj, jR, h1.x(obj2, jR));
                    e0(obj, i10);
                }
                break;
            case 3:
                if (w(obj2, i10)) {
                    h1.N(obj, jR, h1.x(obj2, jR));
                    e0(obj, i10);
                }
                break;
            case 4:
                if (w(obj2, i10)) {
                    h1.M(obj, jR, h1.w(obj2, jR));
                    e0(obj, i10);
                }
                break;
            case 5:
                if (w(obj2, i10)) {
                    h1.N(obj, jR, h1.x(obj2, jR));
                    e0(obj, i10);
                }
                break;
            case 6:
                if (w(obj2, i10)) {
                    h1.M(obj, jR, h1.w(obj2, jR));
                    e0(obj, i10);
                }
                break;
            case 7:
                if (w(obj2, i10)) {
                    h1.E(obj, jR, h1.p(obj2, jR));
                    e0(obj, i10);
                }
                break;
            case 8:
                if (w(obj2, i10)) {
                    h1.O(obj, jR, h1.z(obj2, jR));
                    e0(obj, i10);
                }
                break;
            case 9:
                I(obj, obj2, i10);
                break;
            case 10:
                if (w(obj2, i10)) {
                    h1.O(obj, jR, h1.z(obj2, jR));
                    e0(obj, i10);
                }
                break;
            case 11:
                if (w(obj2, i10)) {
                    h1.M(obj, jR, h1.w(obj2, jR));
                    e0(obj, i10);
                }
                break;
            case 12:
                if (w(obj2, i10)) {
                    h1.M(obj, jR, h1.w(obj2, jR));
                    e0(obj, i10);
                }
                break;
            case 13:
                if (w(obj2, i10)) {
                    h1.M(obj, jR, h1.w(obj2, jR));
                    e0(obj, i10);
                }
                break;
            case 14:
                if (w(obj2, i10)) {
                    h1.N(obj, jR, h1.x(obj2, jR));
                    e0(obj, i10);
                }
                break;
            case 15:
                if (w(obj2, i10)) {
                    h1.M(obj, jR, h1.w(obj2, jR));
                    e0(obj, i10);
                }
                break;
            case 16:
                if (w(obj2, i10)) {
                    h1.N(obj, jR, h1.x(obj2, jR));
                    e0(obj, i10);
                }
                break;
            case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                I(obj, obj2, i10);
                break;
            case bb.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
            case 19:
            case 20:
            case Build.API_LEVELS.API_21 /* 21 */:
            case Build.API_LEVELS.API_22 /* 22 */:
            case Build.API_LEVELS.API_23 /* 23 */:
            case 24:
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
            case PurchaseParamsValidator.MAX_NUMBER_OF_ADD_ON_PRODUCTS /* 49 */:
                this.f1825n.a(obj, obj2, jR);
                break;
            case EventsManager.EVENTS_TO_CLEAR_ON_LIMIT /* 50 */:
                z0.E(this.f1828q, obj, obj2, jR);
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
                if (D(obj2, iQ, i10)) {
                    h1.O(obj, jR, h1.z(obj2, jR));
                    f0(obj, iQ, i10);
                }
                break;
            case 60:
                J(obj, obj2, i10);
                break;
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
                if (D(obj2, iQ, i10)) {
                    h1.O(obj, jR, h1.z(obj2, jR));
                    f0(obj, iQ, i10);
                }
                break;
            case 68:
                J(obj, obj2, i10);
                break;
        }
    }

    public final Object L(Object obj, int i10) {
        x0 x0VarS = s(i10);
        long jR = R(k0(i10));
        if (!w(obj, i10)) {
            return x0VarS.f();
        }
        Object object = f1811s.getObject(obj, jR);
        if (B(object)) {
            return object;
        }
        Object objF = x0VarS.f();
        if (object != null) {
            x0VarS.a(objF, object);
        }
        return objF;
    }

    public final Object M(Object obj, int i10, int i11) {
        x0 x0VarS = s(i11);
        if (!D(obj, i10, i11)) {
            return x0VarS.f();
        }
        Object object = f1811s.getObject(obj, R(k0(i11)));
        if (B(object)) {
            return object;
        }
        Object objF = x0VarS.f();
        if (object != null) {
            x0VarS.a(objF, object);
        }
        return objF;
    }

    public final int Q(int i10) {
        return this.f1812a[i10];
    }

    public final int X(int i10) {
        if (i10 < this.f1814c || i10 > this.f1815d) {
            return -1;
        }
        return g0(i10, 0);
    }

    public final int Y(int i10) {
        return this.f1812a[i10 + 2];
    }

    public final void Z(Object obj, long j10, w0 w0Var, x0 x0Var, m mVar) {
        w0Var.M(this.f1825n.c(obj, j10), x0Var, mVar);
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public void a(Object obj, Object obj2) {
        l(obj);
        obj2.getClass();
        for (int i10 = 0; i10 < this.f1812a.length; i10 += 3) {
            K(obj, obj2, i10);
        }
        z0.F(this.f1826o, obj, obj2);
        if (this.f1817f) {
            z0.D(this.f1827p, obj, obj2);
        }
    }

    public final void a0(Object obj, int i10, w0 w0Var, x0 x0Var, m mVar) {
        w0Var.N(this.f1825n.c(obj, R(i10)), x0Var, mVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006a  */
    @Override // androidx.datastore.preferences.protobuf.x0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(java.lang.Object r8) {
        /*
            Method dump skipped, instruction units count: 216
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.m0.b(java.lang.Object):void");
    }

    public final void b0(Object obj, int i10, w0 w0Var) {
        if (v(i10)) {
            h1.O(obj, R(i10), w0Var.H());
        } else if (this.f1818g) {
            h1.O(obj, R(i10), w0Var.v());
        } else {
            h1.O(obj, R(i10), w0Var.z());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x007c  */
    @Override // androidx.datastore.preferences.protobuf.x0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(java.lang.Object r15) {
        /*
            r14 = this;
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r1 = 0
            r3 = r0
            r2 = r1
            r4 = r2
        L7:
            int r5 = r14.f1822k
            r6 = 1
            if (r2 >= r5) goto L9b
            int[] r5 = r14.f1821j
            r9 = r5[r2]
            int r5 = r14.Q(r9)
            int r13 = r14.k0(r9)
            int[] r7 = r14.f1812a
            int r8 = r9 + 2
            r7 = r7[r8]
            r8 = r7 & r0
            int r7 = r7 >>> 20
            int r12 = r6 << r7
            if (r8 == r3) goto L32
            if (r8 == r0) goto L2f
            sun.misc.Unsafe r3 = androidx.datastore.preferences.protobuf.m0.f1811s
            long r6 = (long) r8
            int r4 = r3.getInt(r15, r6)
        L2f:
            r11 = r4
            r10 = r8
            goto L34
        L32:
            r10 = r3
            r11 = r4
        L34:
            boolean r3 = E(r13)
            r7 = r14
            r8 = r15
            if (r3 == 0) goto L43
            boolean r15 = r7.x(r8, r9, r10, r11, r12)
            if (r15 != 0) goto L43
            return r1
        L43:
            int r15 = j0(r13)
            r3 = 9
            if (r15 == r3) goto L83
            r3 = 17
            if (r15 == r3) goto L83
            r3 = 27
            if (r15 == r3) goto L7c
            r3 = 60
            if (r15 == r3) goto L6b
            r3 = 68
            if (r15 == r3) goto L6b
            r3 = 49
            if (r15 == r3) goto L7c
            r3 = 50
            if (r15 == r3) goto L64
            goto L94
        L64:
            boolean r15 = r14.A(r8, r13, r9)
            if (r15 != 0) goto L94
            return r1
        L6b:
            boolean r15 = r14.D(r8, r5, r9)
            if (r15 == 0) goto L94
            androidx.datastore.preferences.protobuf.x0 r15 = r14.s(r9)
            boolean r15 = y(r8, r13, r15)
            if (r15 != 0) goto L94
            return r1
        L7c:
            boolean r15 = r14.z(r8, r13, r9)
            if (r15 != 0) goto L94
            return r1
        L83:
            boolean r15 = r7.x(r8, r9, r10, r11, r12)
            if (r15 == 0) goto L94
            androidx.datastore.preferences.protobuf.x0 r15 = r14.s(r9)
            boolean r15 = y(r8, r13, r15)
            if (r15 != 0) goto L94
            return r1
        L94:
            int r2 = r2 + 1
            r15 = r8
            r3 = r10
            r4 = r11
            goto L7
        L9b:
            r7 = r14
            r8 = r15
            boolean r15 = r7.f1817f
            if (r15 == 0) goto Lae
            androidx.datastore.preferences.protobuf.n r15 = r7.f1827p
            androidx.datastore.preferences.protobuf.q r15 = r15.c(r8)
            boolean r15 = r15.k()
            if (r15 != 0) goto Lae
            return r1
        Lae:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.m0.c(java.lang.Object):boolean");
    }

    public final void c0(Object obj, int i10, w0 w0Var) {
        if (v(i10)) {
            w0Var.y(this.f1825n.c(obj, R(i10)));
        } else {
            w0Var.x(this.f1825n.c(obj, R(i10)));
        }
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public boolean d(Object obj, Object obj2) {
        int length = this.f1812a.length;
        for (int i10 = 0; i10 < length; i10 += 3) {
            if (!n(obj, obj2, i10)) {
                return false;
            }
        }
        if (!this.f1826o.g(obj).equals(this.f1826o.g(obj2))) {
            return false;
        }
        if (this.f1817f) {
            return this.f1827p.c(obj).equals(this.f1827p.c(obj2));
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // androidx.datastore.preferences.protobuf.x0
    public int e(Object obj) {
        int i10;
        int iH;
        int iP;
        int iW;
        int i11;
        int iO;
        int iQ;
        m0 m0Var = this;
        Object obj2 = obj;
        Unsafe unsafe = f1811s;
        int i12 = 1048575;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 1048575;
        while (i13 < m0Var.f1812a.length) {
            int iK0 = m0Var.k0(i13);
            int iJ0 = j0(iK0);
            int iQ2 = m0Var.Q(i13);
            int i17 = m0Var.f1812a[i13 + 2];
            int i18 = i17 & i12;
            if (iJ0 <= 17) {
                if (i18 != i16) {
                    i14 = i18 == i12 ? 0 : unsafe.getInt(obj2, i18);
                    i16 = i18;
                }
                i10 = 1 << (i17 >>> 20);
            } else {
                i10 = 0;
            }
            int i19 = i15;
            long jR = R(iK0);
            if (iJ0 < r.V.a() || iJ0 > r.f1855i0.a()) {
                i18 = 0;
            }
            switch (iJ0) {
                case 0:
                    if (m0Var.x(obj2, i13, i16, i14, i10)) {
                        iH = i.h(iQ2, 0.0d);
                        i15 = i19 + iH;
                    }
                    i15 = i19;
                    break;
                case 1:
                    if (m0Var.x(obj2, i13, i16, i14, i10)) {
                        iP = i.p(iQ2, 0.0f);
                        i15 = i19 + iP;
                        m0Var = this;
                        obj2 = obj;
                    }
                    m0Var = this;
                    obj2 = obj;
                    i15 = i19;
                    break;
                case 2:
                    if (m0Var.x(obj2, i13, i16, i14, i10)) {
                        iW = i.w(iQ2, unsafe.getLong(obj2, jR));
                        i15 = i19 + iW;
                        m0Var = this;
                    }
                    m0Var = this;
                    i15 = i19;
                    break;
                case 3:
                    if (m0Var.x(obj2, i13, i16, i14, i10)) {
                        iW = i.R(iQ2, unsafe.getLong(obj2, jR));
                        i15 = i19 + iW;
                        m0Var = this;
                    }
                    m0Var = this;
                    i15 = i19;
                    break;
                case 4:
                    if (m0Var.x(obj2, i13, i16, i14, i10)) {
                        iW = i.u(iQ2, unsafe.getInt(obj2, jR));
                        i15 = i19 + iW;
                        m0Var = this;
                    }
                    m0Var = this;
                    i15 = i19;
                    break;
                case 5:
                    if (m0Var.x(obj2, i13, i16, i14, i10)) {
                        iP = i.n(iQ2, 0L);
                        i15 = i19 + iP;
                        m0Var = this;
                        obj2 = obj;
                    }
                    m0Var = this;
                    obj2 = obj;
                    i15 = i19;
                    break;
                case 6:
                    if (m0Var.x(obj2, i13, i16, i14, i10)) {
                        iP = i.l(iQ2, 0);
                        i15 = i19 + iP;
                        m0Var = this;
                        obj2 = obj;
                    }
                    m0Var = this;
                    obj2 = obj;
                    i15 = i19;
                    break;
                case 7:
                    if (m0Var.x(obj2, i13, i16, i14, i10)) {
                        iP = i.c(iQ2, true);
                        i15 = i19 + iP;
                        m0Var = this;
                        obj2 = obj;
                    }
                    m0Var = this;
                    obj2 = obj;
                    i15 = i19;
                    break;
                case 8:
                    if (m0Var.x(obj2, i13, i16, i14, i10)) {
                        Object object = unsafe.getObject(obj2, jR);
                        iW = object instanceof f ? i.f(iQ2, (f) object) : i.M(iQ2, (String) object);
                        i15 = i19 + iW;
                        m0Var = this;
                    }
                    m0Var = this;
                    i15 = i19;
                    break;
                case 9:
                    if (m0Var.x(obj2, i13, i16, i14, i10)) {
                        iH = z0.o(iQ2, unsafe.getObject(obj2, jR), m0Var.s(i13));
                        i15 = i19 + iH;
                    }
                    i15 = i19;
                    break;
                case 10:
                    if (m0Var.x(obj2, i13, i16, i14, i10)) {
                        iW = i.f(iQ2, (f) unsafe.getObject(obj2, jR));
                        i15 = i19 + iW;
                        m0Var = this;
                    }
                    m0Var = this;
                    i15 = i19;
                    break;
                case 11:
                    if (m0Var.x(obj2, i13, i16, i14, i10)) {
                        iW = i.P(iQ2, unsafe.getInt(obj2, jR));
                        i15 = i19 + iW;
                        m0Var = this;
                    }
                    m0Var = this;
                    i15 = i19;
                    break;
                case 12:
                    if (m0Var.x(obj2, i13, i16, i14, i10)) {
                        iW = i.j(iQ2, unsafe.getInt(obj2, jR));
                        i15 = i19 + iW;
                        m0Var = this;
                    }
                    m0Var = this;
                    i15 = i19;
                    break;
                case 13:
                    if (m0Var.x(obj2, i13, i16, i14, i10)) {
                        iP = i.E(iQ2, 0);
                        i15 = i19 + iP;
                        m0Var = this;
                        obj2 = obj;
                    }
                    m0Var = this;
                    obj2 = obj;
                    i15 = i19;
                    break;
                case 14:
                    if (m0Var.x(obj2, i13, i16, i14, i10)) {
                        iP = i.G(iQ2, 0L);
                        i15 = i19 + iP;
                        m0Var = this;
                        obj2 = obj;
                    }
                    m0Var = this;
                    obj2 = obj;
                    i15 = i19;
                    break;
                case 15:
                    if (m0Var.x(obj2, i13, i16, i14, i10)) {
                        iW = i.I(iQ2, unsafe.getInt(obj2, jR));
                        i15 = i19 + iW;
                        m0Var = this;
                    }
                    m0Var = this;
                    i15 = i19;
                    break;
                case 16:
                    if (m0Var.x(obj2, i13, i16, i14, i10)) {
                        iW = i.K(iQ2, unsafe.getLong(obj2, jR));
                        i15 = i19 + iW;
                        m0Var = this;
                    }
                    m0Var = this;
                    i15 = i19;
                    break;
                case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                    if (m0Var.x(obj2, i13, i16, i14, i10)) {
                        iH = i.r(iQ2, (j0) unsafe.getObject(obj2, jR), m0Var.s(i13));
                        i15 = i19 + iH;
                    }
                    i15 = i19;
                    break;
                case bb.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                    iH = z0.h(iQ2, (List) unsafe.getObject(obj2, jR), false);
                    i15 = i19 + iH;
                    break;
                case 19:
                    iH = z0.f(iQ2, (List) unsafe.getObject(obj2, jR), false);
                    i15 = i19 + iH;
                    break;
                case 20:
                    iH = z0.m(iQ2, (List) unsafe.getObject(obj2, jR), false);
                    i15 = i19 + iH;
                    break;
                case Build.API_LEVELS.API_21 /* 21 */:
                    iH = z0.x(iQ2, (List) unsafe.getObject(obj2, jR), false);
                    i15 = i19 + iH;
                    break;
                case Build.API_LEVELS.API_22 /* 22 */:
                    iH = z0.k(iQ2, (List) unsafe.getObject(obj2, jR), false);
                    i15 = i19 + iH;
                    break;
                case Build.API_LEVELS.API_23 /* 23 */:
                    iH = z0.h(iQ2, (List) unsafe.getObject(obj2, jR), false);
                    i15 = i19 + iH;
                    break;
                case 24:
                    iH = z0.f(iQ2, (List) unsafe.getObject(obj2, jR), false);
                    i15 = i19 + iH;
                    break;
                case Build.API_LEVELS.API_25 /* 25 */:
                    iH = z0.a(iQ2, (List) unsafe.getObject(obj2, jR), false);
                    i15 = i19 + iH;
                    break;
                case Build.API_LEVELS.API_26 /* 26 */:
                    iH = z0.u(iQ2, (List) unsafe.getObject(obj2, jR));
                    i15 = i19 + iH;
                    break;
                case Build.API_LEVELS.API_27 /* 27 */:
                    iH = z0.p(iQ2, (List) unsafe.getObject(obj2, jR), m0Var.s(i13));
                    i15 = i19 + iH;
                    break;
                case Build.API_LEVELS.API_28 /* 28 */:
                    iH = z0.c(iQ2, (List) unsafe.getObject(obj2, jR));
                    i15 = i19 + iH;
                    break;
                case Build.API_LEVELS.API_29 /* 29 */:
                    iH = z0.v(iQ2, (List) unsafe.getObject(obj2, jR), false);
                    i15 = i19 + iH;
                    break;
                case Build.API_LEVELS.API_30 /* 30 */:
                    iH = z0.d(iQ2, (List) unsafe.getObject(obj2, jR), false);
                    i15 = i19 + iH;
                    break;
                case Build.API_LEVELS.API_31 /* 31 */:
                    iH = z0.f(iQ2, (List) unsafe.getObject(obj2, jR), false);
                    i15 = i19 + iH;
                    break;
                case 32:
                    iH = z0.h(iQ2, (List) unsafe.getObject(obj2, jR), false);
                    i15 = i19 + iH;
                    break;
                case Build.API_LEVELS.API_33 /* 33 */:
                    iH = z0.q(iQ2, (List) unsafe.getObject(obj2, jR), false);
                    i15 = i19 + iH;
                    break;
                case Build.API_LEVELS.API_34 /* 34 */:
                    iH = z0.s(iQ2, (List) unsafe.getObject(obj2, jR), false);
                    i15 = i19 + iH;
                    break;
                case Build.API_LEVELS.API_35 /* 35 */:
                    i11 = z0.i((List) unsafe.getObject(obj2, jR));
                    if (i11 > 0) {
                        if (m0Var.f1820i) {
                            unsafe.putInt(obj2, i18, i11);
                        }
                        iO = i.O(iQ2);
                        iQ = i.Q(i11);
                        i15 = i19 + iO + iQ + i11;
                    }
                    i15 = i19;
                    break;
                case Build.API_LEVELS.API_36 /* 36 */:
                    i11 = z0.g((List) unsafe.getObject(obj2, jR));
                    if (i11 > 0) {
                        if (m0Var.f1820i) {
                            unsafe.putInt(obj2, i18, i11);
                        }
                        iO = i.O(iQ2);
                        iQ = i.Q(i11);
                        i15 = i19 + iO + iQ + i11;
                    }
                    i15 = i19;
                    break;
                case 37:
                    i11 = z0.n((List) unsafe.getObject(obj2, jR));
                    if (i11 > 0) {
                        if (m0Var.f1820i) {
                            unsafe.putInt(obj2, i18, i11);
                        }
                        iO = i.O(iQ2);
                        iQ = i.Q(i11);
                        i15 = i19 + iO + iQ + i11;
                    }
                    i15 = i19;
                    break;
                case 38:
                    i11 = z0.y((List) unsafe.getObject(obj2, jR));
                    if (i11 > 0) {
                        if (m0Var.f1820i) {
                            unsafe.putInt(obj2, i18, i11);
                        }
                        iO = i.O(iQ2);
                        iQ = i.Q(i11);
                        i15 = i19 + iO + iQ + i11;
                    }
                    i15 = i19;
                    break;
                case 39:
                    i11 = z0.l((List) unsafe.getObject(obj2, jR));
                    if (i11 > 0) {
                        if (m0Var.f1820i) {
                            unsafe.putInt(obj2, i18, i11);
                        }
                        iO = i.O(iQ2);
                        iQ = i.Q(i11);
                        i15 = i19 + iO + iQ + i11;
                    }
                    i15 = i19;
                    break;
                case 40:
                    i11 = z0.i((List) unsafe.getObject(obj2, jR));
                    if (i11 > 0) {
                        if (m0Var.f1820i) {
                            unsafe.putInt(obj2, i18, i11);
                        }
                        iO = i.O(iQ2);
                        iQ = i.Q(i11);
                        i15 = i19 + iO + iQ + i11;
                    }
                    i15 = i19;
                    break;
                case 41:
                    i11 = z0.g((List) unsafe.getObject(obj2, jR));
                    if (i11 > 0) {
                        if (m0Var.f1820i) {
                            unsafe.putInt(obj2, i18, i11);
                        }
                        iO = i.O(iQ2);
                        iQ = i.Q(i11);
                        i15 = i19 + iO + iQ + i11;
                    }
                    i15 = i19;
                    break;
                case 42:
                    i11 = z0.b((List) unsafe.getObject(obj2, jR));
                    if (i11 > 0) {
                        if (m0Var.f1820i) {
                            unsafe.putInt(obj2, i18, i11);
                        }
                        iO = i.O(iQ2);
                        iQ = i.Q(i11);
                        i15 = i19 + iO + iQ + i11;
                    }
                    i15 = i19;
                    break;
                case 43:
                    i11 = z0.w((List) unsafe.getObject(obj2, jR));
                    if (i11 > 0) {
                        if (m0Var.f1820i) {
                            unsafe.putInt(obj2, i18, i11);
                        }
                        iO = i.O(iQ2);
                        iQ = i.Q(i11);
                        i15 = i19 + iO + iQ + i11;
                    }
                    i15 = i19;
                    break;
                case 44:
                    i11 = z0.e((List) unsafe.getObject(obj2, jR));
                    if (i11 > 0) {
                        if (m0Var.f1820i) {
                            unsafe.putInt(obj2, i18, i11);
                        }
                        iO = i.O(iQ2);
                        iQ = i.Q(i11);
                        i15 = i19 + iO + iQ + i11;
                    }
                    i15 = i19;
                    break;
                case 45:
                    i11 = z0.g((List) unsafe.getObject(obj2, jR));
                    if (i11 > 0) {
                        if (m0Var.f1820i) {
                            unsafe.putInt(obj2, i18, i11);
                        }
                        iO = i.O(iQ2);
                        iQ = i.Q(i11);
                        i15 = i19 + iO + iQ + i11;
                    }
                    i15 = i19;
                    break;
                case 46:
                    i11 = z0.i((List) unsafe.getObject(obj2, jR));
                    if (i11 > 0) {
                        if (m0Var.f1820i) {
                            unsafe.putInt(obj2, i18, i11);
                        }
                        iO = i.O(iQ2);
                        iQ = i.Q(i11);
                        i15 = i19 + iO + iQ + i11;
                    }
                    i15 = i19;
                    break;
                case 47:
                    i11 = z0.r((List) unsafe.getObject(obj2, jR));
                    if (i11 > 0) {
                        if (m0Var.f1820i) {
                            unsafe.putInt(obj2, i18, i11);
                        }
                        iO = i.O(iQ2);
                        iQ = i.Q(i11);
                        i15 = i19 + iO + iQ + i11;
                    }
                    i15 = i19;
                    break;
                case 48:
                    i11 = z0.t((List) unsafe.getObject(obj2, jR));
                    if (i11 > 0) {
                        if (m0Var.f1820i) {
                            unsafe.putInt(obj2, i18, i11);
                        }
                        iO = i.O(iQ2);
                        iQ = i.Q(i11);
                        i15 = i19 + iO + iQ + i11;
                    }
                    i15 = i19;
                    break;
                case PurchaseParamsValidator.MAX_NUMBER_OF_ADD_ON_PRODUCTS /* 49 */:
                    iH = z0.j(iQ2, (List) unsafe.getObject(obj2, jR), m0Var.s(i13));
                    i15 = i19 + iH;
                    break;
                case EventsManager.EVENTS_TO_CLEAR_ON_LIMIT /* 50 */:
                    iH = m0Var.f1828q.f(iQ2, unsafe.getObject(obj2, jR), m0Var.r(i13));
                    i15 = i19 + iH;
                    break;
                case 51:
                    if (m0Var.D(obj2, iQ2, i13)) {
                        iH = i.h(iQ2, 0.0d);
                        i15 = i19 + iH;
                    }
                    i15 = i19;
                    break;
                case 52:
                    if (m0Var.D(obj2, iQ2, i13)) {
                        iH = i.p(iQ2, 0.0f);
                        i15 = i19 + iH;
                    }
                    i15 = i19;
                    break;
                case 53:
                    if (m0Var.D(obj2, iQ2, i13)) {
                        iH = i.w(iQ2, W(obj2, jR));
                        i15 = i19 + iH;
                    }
                    i15 = i19;
                    break;
                case 54:
                    if (m0Var.D(obj2, iQ2, i13)) {
                        iH = i.R(iQ2, W(obj2, jR));
                        i15 = i19 + iH;
                    }
                    i15 = i19;
                    break;
                case 55:
                    if (m0Var.D(obj2, iQ2, i13)) {
                        iH = i.u(iQ2, V(obj2, jR));
                        i15 = i19 + iH;
                    }
                    i15 = i19;
                    break;
                case 56:
                    if (m0Var.D(obj2, iQ2, i13)) {
                        iH = i.n(iQ2, 0L);
                        i15 = i19 + iH;
                    }
                    i15 = i19;
                    break;
                case 57:
                    if (m0Var.D(obj2, iQ2, i13)) {
                        iH = i.l(iQ2, 0);
                        i15 = i19 + iH;
                    }
                    i15 = i19;
                    break;
                case 58:
                    if (m0Var.D(obj2, iQ2, i13)) {
                        iH = i.c(iQ2, true);
                        i15 = i19 + iH;
                    }
                    i15 = i19;
                    break;
                case 59:
                    if (m0Var.D(obj2, iQ2, i13)) {
                        Object object2 = unsafe.getObject(obj2, jR);
                        iH = object2 instanceof f ? i.f(iQ2, (f) object2) : i.M(iQ2, (String) object2);
                        i15 = i19 + iH;
                    }
                    i15 = i19;
                    break;
                case 60:
                    if (m0Var.D(obj2, iQ2, i13)) {
                        iH = z0.o(iQ2, unsafe.getObject(obj2, jR), m0Var.s(i13));
                        i15 = i19 + iH;
                    }
                    i15 = i19;
                    break;
                case 61:
                    if (m0Var.D(obj2, iQ2, i13)) {
                        iH = i.f(iQ2, (f) unsafe.getObject(obj2, jR));
                        i15 = i19 + iH;
                    }
                    i15 = i19;
                    break;
                case 62:
                    if (m0Var.D(obj2, iQ2, i13)) {
                        iH = i.P(iQ2, V(obj2, jR));
                        i15 = i19 + iH;
                    }
                    i15 = i19;
                    break;
                case 63:
                    if (m0Var.D(obj2, iQ2, i13)) {
                        iH = i.j(iQ2, V(obj2, jR));
                        i15 = i19 + iH;
                    }
                    i15 = i19;
                    break;
                case 64:
                    if (m0Var.D(obj2, iQ2, i13)) {
                        iH = i.E(iQ2, 0);
                        i15 = i19 + iH;
                    }
                    i15 = i19;
                    break;
                case 65:
                    if (m0Var.D(obj2, iQ2, i13)) {
                        iH = i.G(iQ2, 0L);
                        i15 = i19 + iH;
                    }
                    i15 = i19;
                    break;
                case 66:
                    if (m0Var.D(obj2, iQ2, i13)) {
                        iH = i.I(iQ2, V(obj2, jR));
                        i15 = i19 + iH;
                    }
                    i15 = i19;
                    break;
                case 67:
                    if (m0Var.D(obj2, iQ2, i13)) {
                        iH = i.K(iQ2, W(obj2, jR));
                        i15 = i19 + iH;
                    }
                    i15 = i19;
                    break;
                case 68:
                    if (m0Var.D(obj2, iQ2, i13)) {
                        iH = i.r(iQ2, (j0) unsafe.getObject(obj2, jR), m0Var.s(i13));
                        i15 = i19 + iH;
                    }
                    i15 = i19;
                    break;
                default:
                    i15 = i19;
                    break;
            }
            i13 += 3;
            i12 = 1048575;
        }
        int iT = i15 + m0Var.t(m0Var.f1826o, obj2);
        return m0Var.f1817f ? iT + m0Var.f1827p.c(obj2).h() : iT;
    }

    public final void e0(Object obj, int i10) {
        int iY = Y(i10);
        long j10 = 1048575 & iY;
        if (j10 == 1048575) {
            return;
        }
        h1.M(obj, j10, (1 << (iY >>> 20)) | h1.w(obj, j10));
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public Object f() {
        return this.f1824m.a(this.f1816e);
    }

    public final void f0(Object obj, int i10, int i11) {
        h1.M(obj, Y(i11) & 1048575, i10);
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public int g(Object obj) {
        int i10;
        int iF;
        int length = this.f1812a.length;
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12 += 3) {
            int iK0 = k0(i12);
            int iQ = Q(i12);
            long jR = R(iK0);
            int iHashCode = 37;
            switch (j0(iK0)) {
                case 0:
                    i10 = i11 * 53;
                    iF = u.f(Double.doubleToLongBits(h1.u(obj, jR)));
                    i11 = i10 + iF;
                    break;
                case 1:
                    i10 = i11 * 53;
                    iF = Float.floatToIntBits(h1.v(obj, jR));
                    i11 = i10 + iF;
                    break;
                case 2:
                    i10 = i11 * 53;
                    iF = u.f(h1.x(obj, jR));
                    i11 = i10 + iF;
                    break;
                case 3:
                    i10 = i11 * 53;
                    iF = u.f(h1.x(obj, jR));
                    i11 = i10 + iF;
                    break;
                case 4:
                    i10 = i11 * 53;
                    iF = h1.w(obj, jR);
                    i11 = i10 + iF;
                    break;
                case 5:
                    i10 = i11 * 53;
                    iF = u.f(h1.x(obj, jR));
                    i11 = i10 + iF;
                    break;
                case 6:
                    i10 = i11 * 53;
                    iF = h1.w(obj, jR);
                    i11 = i10 + iF;
                    break;
                case 7:
                    i10 = i11 * 53;
                    iF = u.c(h1.p(obj, jR));
                    i11 = i10 + iF;
                    break;
                case 8:
                    i10 = i11 * 53;
                    iF = ((String) h1.z(obj, jR)).hashCode();
                    i11 = i10 + iF;
                    break;
                case 9:
                    Object objZ = h1.z(obj, jR);
                    if (objZ != null) {
                        iHashCode = objZ.hashCode();
                    }
                    i11 = (i11 * 53) + iHashCode;
                    break;
                case 10:
                    i10 = i11 * 53;
                    iF = h1.z(obj, jR).hashCode();
                    i11 = i10 + iF;
                    break;
                case 11:
                    i10 = i11 * 53;
                    iF = h1.w(obj, jR);
                    i11 = i10 + iF;
                    break;
                case 12:
                    i10 = i11 * 53;
                    iF = h1.w(obj, jR);
                    i11 = i10 + iF;
                    break;
                case 13:
                    i10 = i11 * 53;
                    iF = h1.w(obj, jR);
                    i11 = i10 + iF;
                    break;
                case 14:
                    i10 = i11 * 53;
                    iF = u.f(h1.x(obj, jR));
                    i11 = i10 + iF;
                    break;
                case 15:
                    i10 = i11 * 53;
                    iF = h1.w(obj, jR);
                    i11 = i10 + iF;
                    break;
                case 16:
                    i10 = i11 * 53;
                    iF = u.f(h1.x(obj, jR));
                    i11 = i10 + iF;
                    break;
                case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                    Object objZ2 = h1.z(obj, jR);
                    if (objZ2 != null) {
                        iHashCode = objZ2.hashCode();
                    }
                    i11 = (i11 * 53) + iHashCode;
                    break;
                case bb.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                case 19:
                case 20:
                case Build.API_LEVELS.API_21 /* 21 */:
                case Build.API_LEVELS.API_22 /* 22 */:
                case Build.API_LEVELS.API_23 /* 23 */:
                case 24:
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
                case PurchaseParamsValidator.MAX_NUMBER_OF_ADD_ON_PRODUCTS /* 49 */:
                    i10 = i11 * 53;
                    iF = h1.z(obj, jR).hashCode();
                    i11 = i10 + iF;
                    break;
                case EventsManager.EVENTS_TO_CLEAR_ON_LIMIT /* 50 */:
                    i10 = i11 * 53;
                    iF = h1.z(obj, jR).hashCode();
                    i11 = i10 + iF;
                    break;
                case 51:
                    if (D(obj, iQ, i12)) {
                        i10 = i11 * 53;
                        iF = u.f(Double.doubleToLongBits(T(obj, jR)));
                        i11 = i10 + iF;
                    }
                    break;
                case 52:
                    if (D(obj, iQ, i12)) {
                        i10 = i11 * 53;
                        iF = Float.floatToIntBits(U(obj, jR));
                        i11 = i10 + iF;
                    }
                    break;
                case 53:
                    if (D(obj, iQ, i12)) {
                        i10 = i11 * 53;
                        iF = u.f(W(obj, jR));
                        i11 = i10 + iF;
                    }
                    break;
                case 54:
                    if (D(obj, iQ, i12)) {
                        i10 = i11 * 53;
                        iF = u.f(W(obj, jR));
                        i11 = i10 + iF;
                    }
                    break;
                case 55:
                    if (D(obj, iQ, i12)) {
                        i10 = i11 * 53;
                        iF = V(obj, jR);
                        i11 = i10 + iF;
                    }
                    break;
                case 56:
                    if (D(obj, iQ, i12)) {
                        i10 = i11 * 53;
                        iF = u.f(W(obj, jR));
                        i11 = i10 + iF;
                    }
                    break;
                case 57:
                    if (D(obj, iQ, i12)) {
                        i10 = i11 * 53;
                        iF = V(obj, jR);
                        i11 = i10 + iF;
                    }
                    break;
                case 58:
                    if (D(obj, iQ, i12)) {
                        i10 = i11 * 53;
                        iF = u.c(S(obj, jR));
                        i11 = i10 + iF;
                    }
                    break;
                case 59:
                    if (D(obj, iQ, i12)) {
                        i10 = i11 * 53;
                        iF = ((String) h1.z(obj, jR)).hashCode();
                        i11 = i10 + iF;
                    }
                    break;
                case 60:
                    if (D(obj, iQ, i12)) {
                        i10 = i11 * 53;
                        iF = h1.z(obj, jR).hashCode();
                        i11 = i10 + iF;
                    }
                    break;
                case 61:
                    if (D(obj, iQ, i12)) {
                        i10 = i11 * 53;
                        iF = h1.z(obj, jR).hashCode();
                        i11 = i10 + iF;
                    }
                    break;
                case 62:
                    if (D(obj, iQ, i12)) {
                        i10 = i11 * 53;
                        iF = V(obj, jR);
                        i11 = i10 + iF;
                    }
                    break;
                case 63:
                    if (D(obj, iQ, i12)) {
                        i10 = i11 * 53;
                        iF = V(obj, jR);
                        i11 = i10 + iF;
                    }
                    break;
                case 64:
                    if (D(obj, iQ, i12)) {
                        i10 = i11 * 53;
                        iF = V(obj, jR);
                        i11 = i10 + iF;
                    }
                    break;
                case 65:
                    if (D(obj, iQ, i12)) {
                        i10 = i11 * 53;
                        iF = u.f(W(obj, jR));
                        i11 = i10 + iF;
                    }
                    break;
                case 66:
                    if (D(obj, iQ, i12)) {
                        i10 = i11 * 53;
                        iF = V(obj, jR);
                        i11 = i10 + iF;
                    }
                    break;
                case 67:
                    if (D(obj, iQ, i12)) {
                        i10 = i11 * 53;
                        iF = u.f(W(obj, jR));
                        i11 = i10 + iF;
                    }
                    break;
                case 68:
                    if (D(obj, iQ, i12)) {
                        i10 = i11 * 53;
                        iF = h1.z(obj, jR).hashCode();
                        i11 = i10 + iF;
                    }
                    break;
            }
        }
        int iHashCode2 = (i11 * 53) + this.f1826o.g(obj).hashCode();
        return this.f1817f ? (iHashCode2 * 53) + this.f1827p.c(obj).hashCode() : iHashCode2;
    }

    public final int g0(int i10, int i11) {
        int length = (this.f1812a.length / 3) - 1;
        while (i11 <= length) {
            int i12 = (length + i11) >>> 1;
            int i13 = i12 * 3;
            int iQ = Q(i13);
            if (i10 == iQ) {
                return i13;
            }
            if (i10 < iQ) {
                length = i12 - 1;
            } else {
                i11 = i12 + 1;
            }
        }
        return -1;
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public void h(Object obj, w0 w0Var, m mVar) throws Throwable {
        mVar.getClass();
        l(obj);
        G(this.f1826o, this.f1827p, obj, w0Var, mVar);
    }

    public final void h0(Object obj, int i10, Object obj2) {
        f1811s.putObject(obj, R(k0(i10)), obj2);
        e0(obj, i10);
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public void i(Object obj, k1 k1Var) {
        if (k1Var.i() == k1.a.DESCENDING) {
            m0(obj, k1Var);
        } else {
            l0(obj, k1Var);
        }
    }

    public final void i0(Object obj, int i10, int i11, Object obj2) {
        f1811s.putObject(obj, R(k0(i11)), obj2);
        f0(obj, i10, i11);
    }

    public final boolean j(Object obj, Object obj2, int i10) {
        return w(obj, i10) == w(obj2, i10);
    }

    public final int k0(int i10) {
        return this.f1812a[i10 + 1];
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l0(java.lang.Object r19, androidx.datastore.preferences.protobuf.k1 r20) {
        /*
            Method dump skipped, instruction units count: 1424
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.m0.l0(java.lang.Object, androidx.datastore.preferences.protobuf.k1):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m0(java.lang.Object r11, androidx.datastore.preferences.protobuf.k1 r12) {
        /*
            Method dump skipped, instruction units count: 1586
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.m0.m0(java.lang.Object, androidx.datastore.preferences.protobuf.k1):void");
    }

    public final boolean n(Object obj, Object obj2, int i10) {
        int iK0 = k0(i10);
        long jR = R(iK0);
        switch (j0(iK0)) {
            case 0:
                if (!j(obj, obj2, i10) || Double.doubleToLongBits(h1.u(obj, jR)) != Double.doubleToLongBits(h1.u(obj2, jR))) {
                }
                break;
            case 1:
                if (!j(obj, obj2, i10) || Float.floatToIntBits(h1.v(obj, jR)) != Float.floatToIntBits(h1.v(obj2, jR))) {
                }
                break;
            case 2:
                if (!j(obj, obj2, i10) || h1.x(obj, jR) != h1.x(obj2, jR)) {
                }
                break;
            case 3:
                if (!j(obj, obj2, i10) || h1.x(obj, jR) != h1.x(obj2, jR)) {
                }
                break;
            case 4:
                if (!j(obj, obj2, i10) || h1.w(obj, jR) != h1.w(obj2, jR)) {
                }
                break;
            case 5:
                if (!j(obj, obj2, i10) || h1.x(obj, jR) != h1.x(obj2, jR)) {
                }
                break;
            case 6:
                if (!j(obj, obj2, i10) || h1.w(obj, jR) != h1.w(obj2, jR)) {
                }
                break;
            case 7:
                if (!j(obj, obj2, i10) || h1.p(obj, jR) != h1.p(obj2, jR)) {
                }
                break;
            case 8:
                if (!j(obj, obj2, i10) || !z0.H(h1.z(obj, jR), h1.z(obj2, jR))) {
                }
                break;
            case 9:
                if (!j(obj, obj2, i10) || !z0.H(h1.z(obj, jR), h1.z(obj2, jR))) {
                }
                break;
            case 10:
                if (!j(obj, obj2, i10) || !z0.H(h1.z(obj, jR), h1.z(obj2, jR))) {
                }
                break;
            case 11:
                if (!j(obj, obj2, i10) || h1.w(obj, jR) != h1.w(obj2, jR)) {
                }
                break;
            case 12:
                if (!j(obj, obj2, i10) || h1.w(obj, jR) != h1.w(obj2, jR)) {
                }
                break;
            case 13:
                if (!j(obj, obj2, i10) || h1.w(obj, jR) != h1.w(obj2, jR)) {
                }
                break;
            case 14:
                if (!j(obj, obj2, i10) || h1.x(obj, jR) != h1.x(obj2, jR)) {
                }
                break;
            case 15:
                if (!j(obj, obj2, i10) || h1.w(obj, jR) != h1.w(obj2, jR)) {
                }
                break;
            case 16:
                if (!j(obj, obj2, i10) || h1.x(obj, jR) != h1.x(obj2, jR)) {
                }
                break;
            case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                if (!j(obj, obj2, i10) || !z0.H(h1.z(obj, jR), h1.z(obj2, jR))) {
                }
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
                if (!C(obj, obj2, i10) || !z0.H(h1.z(obj, jR), h1.z(obj2, jR))) {
                }
                break;
        }
        return true;
    }

    public final void n0(k1 k1Var, int i10, Object obj, int i11) {
        if (obj != null) {
            k1Var.N(i10, this.f1828q.c(r(i11)), this.f1828q.h(obj));
        }
    }

    public final Object o(Object obj, int i10, Object obj2, e1 e1Var, Object obj3) {
        Q(i10);
        if (h1.z(obj, R(k0(i10))) == null) {
            return obj2;
        }
        q(i10);
        return obj2;
    }

    public final void o0(int i10, Object obj, k1 k1Var) {
        if (obj instanceof String) {
            k1Var.k(i10, (String) obj);
        } else {
            k1Var.L(i10, (f) obj);
        }
    }

    public final void p0(e1 e1Var, Object obj, k1 k1Var) {
        e1Var.t(e1Var.g(obj), k1Var);
    }

    public final u.a q(int i10) {
        android.support.v4.media.session.b.a(this.f1813b[((i10 / 3) * 2) + 1]);
        return null;
    }

    public final Object r(int i10) {
        return this.f1813b[(i10 / 3) * 2];
    }

    public final x0 s(int i10) {
        int i11 = (i10 / 3) * 2;
        x0 x0Var = (x0) this.f1813b[i11];
        if (x0Var != null) {
            return x0Var;
        }
        x0 x0VarC = t0.a().c((Class) this.f1813b[i11 + 1]);
        this.f1813b[i11] = x0VarC;
        return x0VarC;
    }

    public final int t(e1 e1Var, Object obj) {
        return e1Var.h(e1Var.g(obj));
    }

    public final boolean w(Object obj, int i10) {
        boolean zEquals;
        int iY = Y(i10);
        long j10 = 1048575 & iY;
        if (j10 != 1048575) {
            return (h1.w(obj, j10) & (1 << (iY >>> 20))) != 0;
        }
        int iK0 = k0(i10);
        long jR = R(iK0);
        switch (j0(iK0)) {
            case 0:
                return Double.doubleToRawLongBits(h1.u(obj, jR)) != 0;
            case 1:
                return Float.floatToRawIntBits(h1.v(obj, jR)) != 0;
            case 2:
                return h1.x(obj, jR) != 0;
            case 3:
                return h1.x(obj, jR) != 0;
            case 4:
                return h1.w(obj, jR) != 0;
            case 5:
                return h1.x(obj, jR) != 0;
            case 6:
                return h1.w(obj, jR) != 0;
            case 7:
                return h1.p(obj, jR);
            case 8:
                Object objZ = h1.z(obj, jR);
                if (objZ instanceof String) {
                    zEquals = ((String) objZ).isEmpty();
                } else {
                    if (!(objZ instanceof f)) {
                        throw new IllegalArgumentException();
                    }
                    zEquals = f.f1682b.equals(objZ);
                }
                break;
            case 9:
                return h1.z(obj, jR) != null;
            case 10:
                zEquals = f.f1682b.equals(h1.z(obj, jR));
                break;
            case 11:
                return h1.w(obj, jR) != 0;
            case 12:
                return h1.w(obj, jR) != 0;
            case 13:
                return h1.w(obj, jR) != 0;
            case 14:
                return h1.x(obj, jR) != 0;
            case 15:
                return h1.w(obj, jR) != 0;
            case 16:
                return h1.x(obj, jR) != 0;
            case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                return h1.z(obj, jR) != null;
            default:
                throw new IllegalArgumentException();
        }
        return !zEquals;
    }

    public final boolean x(Object obj, int i10, int i11, int i12, int i13) {
        return i11 == 1048575 ? w(obj, i10) : (i12 & i13) != 0;
    }

    public final boolean z(Object obj, int i10, int i11) {
        List list = (List) h1.z(obj, R(i10));
        if (list.isEmpty()) {
            return true;
        }
        x0 x0VarS = s(i11);
        for (int i12 = 0; i12 < list.size(); i12++) {
            if (!x0VarS.c(list.get(i12))) {
                return false;
            }
        }
        return true;
    }
}
