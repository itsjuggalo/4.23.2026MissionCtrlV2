package jf;

import cd.h0;
import dd.a0;
import fe.b;
import fe.b1;
import fe.d0;
import fe.e0;
import fe.l1;
import fe.s1;
import fe.x0;
import fe.y0;
import fe.z;
import ie.j0;
import ie.k0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.ServiceLoader;
import java.util.Set;
import jf.j;
import kotlin.jvm.functions.Function0;
import xf.l0;
import xf.r0;
import xf.t1;
import xf.u1;
import xf.v0;
import yf.e;
import yf.f;
import yf.g;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class o {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final List f14336e = a0.I0(ServiceLoader.load(j.class, j.class.getClassLoader()));

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final o f14337f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final e.a f14338g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final yf.g f14339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final yf.f f14340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e.a f14341c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final pd.o f14342d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a implements e.a {
        public static /* synthetic */ void b(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "a";
            } else {
                objArr[0] = "b";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$1";
            objArr[2] = "equals";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // yf.e.a
        public boolean a(u1 u1Var, u1 u1Var2) {
            if (u1Var == null) {
                b(0);
            }
            if (u1Var2 == null) {
                b(1);
            }
            return u1Var.equals(u1Var2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b implements pd.o {
        @Override // pd.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public cd.q invoke(fe.a aVar, fe.a aVar2) {
            return new cd.q(aVar, aVar2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c implements pd.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ fe.m f14343a;

        public c(fe.m mVar) {
            this.f14343a = mVar;
        }

        @Override // pd.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean invoke(fe.b bVar) {
            return Boolean.valueOf(bVar.b() == this.f14343a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class e implements pd.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ fe.e f14344a;

        public e(fe.e eVar) {
            this.f14344a = eVar;
        }

        @Override // pd.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean invoke(fe.b bVar) {
            boolean z10 = false;
            if (!fe.t.g(bVar.getVisibility()) && fe.t.h(bVar, this.f14344a, false)) {
                z10 = true;
            }
            return Boolean.valueOf(z10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class g implements pd.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n f14345a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ fe.b f14346b;

        public g(n nVar, fe.b bVar) {
            this.f14345a = nVar;
            this.f14346b = bVar;
        }

        @Override // pd.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public h0 invoke(fe.b bVar) {
            this.f14345a.b(this.f14346b, bVar);
            return h0.f3852a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14347a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f14348b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f14349c;

        static {
            int[] iArr = new int[e0.values().length];
            f14349c = iArr;
            try {
                iArr[e0.f9461b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14349c[e0.f9462c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14349c[e0.f9463d.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14349c[e0.f9464e.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[i.a.values().length];
            f14348b = iArr2;
            try {
                iArr2[i.a.OVERRIDABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f14348b[i.a.CONFLICT.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f14348b[i.a.INCOMPATIBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[j.b.values().length];
            f14347a = iArr3;
            try {
                iArr3[j.b.OVERRIDABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f14347a[j.b.INCOMPATIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f14347a[j.b.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class i {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final i f14350c = new i(a.OVERRIDABLE, "SUCCESS");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f14351a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f14352b;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public enum a {
            OVERRIDABLE,
            INCOMPATIBLE,
            CONFLICT
        }

        public i(a aVar, String str) {
            if (aVar == null) {
                a(3);
            }
            if (str == null) {
                a(4);
            }
            this.f14351a = aVar;
            this.f14352b = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0031  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static /* synthetic */ void a(int r10) {
            /*
                r0 = 4
                r1 = 3
                r2 = 2
                r3 = 1
                if (r10 == r3) goto Lf
                if (r10 == r2) goto Lf
                if (r10 == r1) goto Lf
                if (r10 == r0) goto Lf
                java.lang.String r4 = "@NotNull method %s.%s must not return null"
                goto L11
            Lf:
                java.lang.String r4 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            L11:
                if (r10 == r3) goto L1b
                if (r10 == r2) goto L1b
                if (r10 == r1) goto L1b
                if (r10 == r0) goto L1b
                r5 = r2
                goto L1c
            L1b:
                r5 = r1
            L1c:
                java.lang.Object[] r5 = new java.lang.Object[r5]
                java.lang.String r6 = "success"
                java.lang.String r7 = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo"
                r8 = 0
                if (r10 == r3) goto L31
                if (r10 == r2) goto L31
                if (r10 == r1) goto L2e
                if (r10 == r0) goto L31
                r5[r8] = r7
                goto L35
            L2e:
                r5[r8] = r6
                goto L35
            L31:
                java.lang.String r9 = "debugMessage"
                r5[r8] = r9
            L35:
                switch(r10) {
                    case 1: goto L45;
                    case 2: goto L45;
                    case 3: goto L45;
                    case 4: goto L45;
                    case 5: goto L40;
                    case 6: goto L3b;
                    default: goto L38;
                }
            L38:
                r5[r3] = r6
                goto L47
            L3b:
                java.lang.String r6 = "getDebugMessage"
                r5[r3] = r6
                goto L47
            L40:
                java.lang.String r6 = "getResult"
                r5[r3] = r6
                goto L47
            L45:
                r5[r3] = r7
            L47:
                if (r10 == r3) goto L5a
                if (r10 == r2) goto L55
                if (r10 == r1) goto L50
                if (r10 == r0) goto L50
                goto L5e
            L50:
                java.lang.String r6 = "<init>"
                r5[r2] = r6
                goto L5e
            L55:
                java.lang.String r6 = "conflict"
                r5[r2] = r6
                goto L5e
            L5a:
                java.lang.String r6 = "incompatible"
                r5[r2] = r6
            L5e:
                java.lang.String r4 = java.lang.String.format(r4, r5)
                if (r10 == r3) goto L70
                if (r10 == r2) goto L70
                if (r10 == r1) goto L70
                if (r10 == r0) goto L70
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                r10.<init>(r4)
                goto L75
            L70:
                java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
                r10.<init>(r4)
            L75:
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: jf.o.i.a(int):void");
        }

        public static i b(String str) {
            if (str == null) {
                a(2);
            }
            return new i(a.CONFLICT, str);
        }

        public static i d(String str) {
            if (str == null) {
                a(1);
            }
            return new i(a.INCOMPATIBLE, str);
        }

        public static i e() {
            i iVar = f14350c;
            if (iVar == null) {
                a(0);
            }
            return iVar;
        }

        public a c() {
            a aVar = this.f14351a;
            if (aVar == null) {
                a(5);
            }
            return aVar;
        }

        public String toString() {
            return this.f14351a + ": " + this.f14352b;
        }
    }

    static {
        a aVar = new a();
        f14338g = aVar;
        f14337f = new o(aVar, g.a.f25404a, f.a.f25403a, null);
    }

    public o(e.a aVar, yf.g gVar, yf.f fVar, pd.o oVar) {
        if (aVar == null) {
            a(5);
        }
        if (gVar == null) {
            a(6);
        }
        if (fVar == null) {
            a(7);
        }
        this.f14341c = aVar;
        this.f14339a = gVar;
        this.f14340b = fVar;
        this.f14342d = oVar;
    }

    public static boolean A(x0 x0Var, x0 x0Var2) {
        if (x0Var == null || x0Var2 == null) {
            return true;
        }
        return H(x0Var, x0Var2);
    }

    public static boolean B(fe.a aVar, fe.a aVar2) {
        if (aVar == null) {
            a(65);
        }
        if (aVar2 == null) {
            a(66);
        }
        r0 returnType = aVar.getReturnType();
        r0 returnType2 = aVar2.getReturnType();
        if (!H(aVar, aVar2)) {
            return false;
        }
        t1 t1VarL = f14337f.l(aVar.getTypeParameters(), aVar2.getTypeParameters());
        if (aVar instanceof z) {
            return G(aVar, returnType, aVar2, returnType2, t1VarL);
        }
        if (!(aVar instanceof y0)) {
            throw new IllegalArgumentException("Unexpected callable: " + aVar.getClass());
        }
        y0 y0Var = (y0) aVar;
        y0 y0Var2 = (y0) aVar2;
        if (A(y0Var.g(), y0Var2.g())) {
            return (y0Var.i0() && y0Var2.i0()) ? xf.g.f24969a.m(t1VarL, returnType.Q0(), returnType2.Q0()) : (y0Var.i0() || !y0Var2.i0()) && G(aVar, returnType, aVar2, returnType2, t1VarL);
        }
        return false;
    }

    public static boolean C(fe.a aVar, Collection collection) {
        if (aVar == null) {
            a(69);
        }
        if (collection == null) {
            a(70);
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!B(aVar, (fe.a) it.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean G(fe.a aVar, r0 r0Var, fe.a aVar2, r0 r0Var2, t1 t1Var) {
        if (aVar == null) {
            a(71);
        }
        if (r0Var == null) {
            a(72);
        }
        if (aVar2 == null) {
            a(73);
        }
        if (r0Var2 == null) {
            a(74);
        }
        if (t1Var == null) {
            a(75);
        }
        return xf.g.f24969a.t(t1Var, r0Var.Q0(), r0Var2.Q0());
    }

    public static boolean H(fe.q qVar, fe.q qVar2) {
        if (qVar == null) {
            a(67);
        }
        if (qVar2 == null) {
            a(68);
        }
        Integer numD = fe.t.d(qVar.getVisibility(), qVar2.getVisibility());
        return numD == null || numD.intValue() >= 0;
    }

    public static boolean I(d0 d0Var, d0 d0Var2, boolean z10) {
        if (d0Var == null) {
            a(55);
        }
        if (d0Var2 == null) {
            a(56);
        }
        return !fe.t.g(d0Var2.getVisibility()) && fe.t.h(d0Var2, d0Var, z10);
    }

    public static boolean J(fe.a aVar, fe.a aVar2, boolean z10, boolean z11) {
        if (aVar == null) {
            a(13);
        }
        if (aVar2 == null) {
            a(14);
        }
        if (!aVar.equals(aVar2) && jf.g.f14323a.k(aVar.a(), aVar2.a(), z10, z11)) {
            return true;
        }
        fe.a aVarA = aVar2.a();
        Iterator it = jf.i.d(aVar).iterator();
        while (it.hasNext()) {
            if (jf.g.f14323a.k(aVarA, (fe.a) it.next(), z10, z11)) {
                return true;
            }
        }
        return false;
    }

    public static void K(fe.b bVar, pd.k kVar) {
        fe.u uVar;
        if (bVar == null) {
            a(105);
        }
        for (fe.b bVar2 : bVar.f()) {
            if (bVar2.getVisibility() == fe.t.f9513g) {
                K(bVar2, kVar);
            }
        }
        if (bVar.getVisibility() != fe.t.f9513g) {
            return;
        }
        fe.u uVarH = h(bVar);
        if (uVarH == null) {
            if (kVar != null) {
                kVar.invoke(bVar);
            }
            uVar = fe.t.f9511e;
        } else {
            uVar = uVarH;
        }
        if (bVar instanceof k0) {
            ((k0) bVar).c1(uVar);
            Iterator it = ((y0) bVar).x().iterator();
            while (it.hasNext()) {
                K((x0) it.next(), uVarH == null ? null : kVar);
            }
            return;
        }
        if (bVar instanceof ie.s) {
            ((ie.s) bVar).j1(uVar);
            return;
        }
        j0 j0Var = (j0) bVar;
        j0Var.N0(uVar);
        if (uVar != j0Var.B0().getVisibility()) {
            j0Var.L0(false);
        }
    }

    public static Object L(Collection collection, pd.k kVar) {
        Object next;
        if (collection == null) {
            a(76);
        }
        if (kVar == null) {
            a(77);
        }
        if (collection.size() == 1) {
            Object objY = a0.Y(collection);
            if (objY == null) {
                a(78);
            }
            return objY;
        }
        ArrayList arrayList = new ArrayList(2);
        List listN0 = a0.n0(collection, kVar);
        Object objY2 = a0.Y(collection);
        fe.a aVar = (fe.a) kVar.invoke(objY2);
        for (Object obj : collection) {
            fe.a aVar2 = (fe.a) kVar.invoke(obj);
            if (C(aVar2, listN0)) {
                arrayList.add(obj);
            }
            if (B(aVar2, aVar) && !B(aVar, aVar2)) {
                objY2 = obj;
            }
        }
        if (arrayList.isEmpty()) {
            if (objY2 == null) {
                a(79);
            }
            return objY2;
        }
        if (arrayList.size() == 1) {
            Object objY3 = a0.Y(arrayList);
            if (objY3 == null) {
                a(80);
            }
            return objY3;
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (!l0.b(((fe.a) kVar.invoke(next)).getReturnType())) {
                break;
            }
        }
        if (next != null) {
            return next;
        }
        Object objY4 = a0.Y(arrayList);
        if (objY4 == null) {
            a(82);
        }
        return objY4;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0035 A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void a(int r24) {
        /*
            Method dump skipped, instruction units count: 1298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: jf.o.a(int):void");
    }

    public static boolean b(Collection collection) {
        if (collection == null) {
            a(61);
        }
        if (collection.size() < 2) {
            return true;
        }
        return a0.P(collection, new c(((fe.b) collection.iterator().next()).b()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0054, code lost:
    
        r1.remove();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean c(fe.l1 r4, fe.l1 r5, xf.t1 r6) {
        /*
            if (r4 != 0) goto L7
            r0 = 47
            a(r0)
        L7:
            if (r5 != 0) goto Le
            r0 = 48
            a(r0)
        Le:
            if (r6 != 0) goto L15
            r0 = 49
            a(r0)
        L15:
            java.util.List r4 = r4.getUpperBounds()
            java.util.ArrayList r0 = new java.util.ArrayList
            java.util.List r5 = r5.getUpperBounds()
            r0.<init>(r5)
            int r5 = r4.size()
            int r1 = r0.size()
            r2 = 0
            if (r5 == r1) goto L2e
            return r2
        L2e:
            java.util.Iterator r4 = r4.iterator()
        L32:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L59
            java.lang.Object r5 = r4.next()
            xf.r0 r5 = (xf.r0) r5
            java.util.ListIterator r1 = r0.listIterator()
        L42:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L58
            java.lang.Object r3 = r1.next()
            xf.r0 r3 = (xf.r0) r3
            boolean r3 = d(r5, r3, r6)
            if (r3 == 0) goto L42
            r1.remove()
            goto L32
        L58:
            return r2
        L59:
            r4 = 1
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: jf.o.c(fe.l1, fe.l1, xf.t1):boolean");
    }

    public static boolean d(r0 r0Var, r0 r0Var2, t1 t1Var) {
        if (r0Var == null) {
            a(44);
        }
        if (r0Var2 == null) {
            a(45);
        }
        if (t1Var == null) {
            a(46);
        }
        if (v0.a(r0Var) && v0.a(r0Var2)) {
            return true;
        }
        return xf.g.f24969a.m(t1Var, r0Var.Q0(), r0Var2.Q0());
    }

    public static i e(fe.a aVar, fe.a aVar2) {
        if ((aVar.k0() == null) != (aVar2.k0() == null)) {
            return i.d("Receiver presence mismatch");
        }
        if (aVar.i().size() != aVar2.i().size()) {
            return i.d("Value parameter number mismatch");
        }
        return null;
    }

    public static void f(fe.b bVar, Set set) {
        if (bVar == null) {
            a(17);
        }
        if (set == null) {
            a(18);
        }
        if (bVar.h().a()) {
            set.add(bVar);
            return;
        }
        if (bVar.f().isEmpty()) {
            throw new IllegalStateException("No overridden descriptors found for (fake override) " + bVar);
        }
        Iterator it = bVar.f().iterator();
        while (it.hasNext()) {
            f((fe.b) it.next(), set);
        }
    }

    public static List g(fe.a aVar) {
        b1 b1VarK0 = aVar.k0();
        ArrayList arrayList = new ArrayList();
        if (b1VarK0 != null) {
            arrayList.add(b1VarK0.getType());
        }
        Iterator it = aVar.i().iterator();
        while (it.hasNext()) {
            arrayList.add(((s1) it.next()).getType());
        }
        return arrayList;
    }

    public static fe.u h(fe.b bVar) {
        if (bVar == null) {
            a(106);
        }
        Collection<fe.b> collectionF = bVar.f();
        fe.u uVarU = u(collectionF);
        if (uVarU == null) {
            return null;
        }
        if (bVar.h() != b.a.FAKE_OVERRIDE) {
            return uVarU.f();
        }
        for (fe.b bVar2 : collectionF) {
            if (bVar2.l() != e0.f9464e && !bVar2.getVisibility().equals(uVarU)) {
                return null;
            }
        }
        return uVarU;
    }

    public static o i(yf.g gVar, e.a aVar) {
        if (gVar == null) {
            a(3);
        }
        if (aVar == null) {
            a(4);
        }
        return new o(aVar, gVar, f.a.f25403a, null);
    }

    public static void j(Collection collection, fe.e eVar, n nVar) {
        if (collection == null) {
            a(83);
        }
        if (eVar == null) {
            a(84);
        }
        if (nVar == null) {
            a(85);
        }
        Collection collectionT = t(eVar, collection);
        boolean zIsEmpty = collectionT.isEmpty();
        if (!zIsEmpty) {
            collection = collectionT;
        }
        fe.b bVarL = ((fe.b) L(collection, new d())).L(eVar, n(collection, eVar), zIsEmpty ? fe.t.f9514h : fe.t.f9513g, b.a.FAKE_OVERRIDE, false);
        nVar.d(bVarL, collection);
        nVar.a(bVarL);
    }

    public static void k(fe.e eVar, Collection collection, n nVar) {
        if (eVar == null) {
            a(62);
        }
        if (collection == null) {
            a(63);
        }
        if (nVar == null) {
            a(64);
        }
        if (b(collection)) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                j(Collections.singleton((fe.b) it.next()), eVar, nVar);
            }
        } else {
            LinkedList linkedList = new LinkedList(collection);
            while (!linkedList.isEmpty()) {
                j(p(w.a(linkedList), linkedList, nVar), eVar, nVar);
            }
        }
    }

    public static o m(yf.g gVar) {
        if (gVar == null) {
            a(0);
        }
        return new o(f14338g, gVar, f.a.f25403a, null);
    }

    public static e0 n(Collection collection, fe.e eVar) {
        if (collection == null) {
            a(86);
        }
        if (eVar == null) {
            a(87);
        }
        Iterator it = collection.iterator();
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        while (it.hasNext()) {
            fe.b bVar = (fe.b) it.next();
            int i10 = h.f14349c[bVar.l().ordinal()];
            if (i10 == 1) {
                e0 e0Var = e0.f9461b;
                if (e0Var == null) {
                    a(88);
                }
                return e0Var;
            }
            if (i10 == 2) {
                throw new IllegalStateException("Member cannot have SEALED modality: " + bVar);
            }
            if (i10 == 3) {
                z11 = true;
            } else if (i10 == 4) {
                z12 = true;
            }
        }
        if (eVar.N() && eVar.l() != e0.f9464e && eVar.l() != e0.f9462c) {
            z10 = true;
        }
        if (z11 && !z12) {
            e0 e0Var2 = e0.f9463d;
            if (e0Var2 == null) {
                a(89);
            }
            return e0Var2;
        }
        if (!z11 && z12) {
            e0 e0VarL = z10 ? eVar.l() : e0.f9464e;
            if (e0VarL == null) {
                a(90);
            }
            return e0VarL;
        }
        HashSet hashSet = new HashSet();
        Iterator it2 = collection.iterator();
        while (it2.hasNext()) {
            hashSet.addAll(z((fe.b) it2.next()));
        }
        return y(r(hashSet), z10, eVar.l());
    }

    public static Collection p(fe.b bVar, Queue queue, n nVar) {
        if (bVar == null) {
            a(102);
        }
        if (queue == null) {
            a(103);
        }
        if (nVar == null) {
            a(104);
        }
        return q(bVar, queue, new f(), new g(nVar, bVar));
    }

    public static Collection q(Object obj, Collection collection, pd.k kVar, pd.k kVar2) {
        if (obj == null) {
            a(97);
        }
        if (collection == null) {
            a(98);
        }
        if (kVar == null) {
            a(99);
        }
        if (kVar2 == null) {
            a(100);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(obj);
        fe.a aVar = (fe.a) kVar.invoke(obj);
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            fe.a aVar2 = (fe.a) kVar.invoke(next);
            if (obj == next) {
                it.remove();
            } else {
                i.a aVarX = x(aVar, aVar2);
                if (aVarX == i.a.OVERRIDABLE) {
                    arrayList.add(next);
                    it.remove();
                } else if (aVarX == i.a.CONFLICT) {
                    kVar2.invoke(next);
                    it.remove();
                }
            }
        }
        return arrayList;
    }

    public static Set r(Set set) {
        if (set == null) {
            a(8);
        }
        return s(set, !set.isEmpty() && nf.e.y(nf.e.s((fe.m) set.iterator().next())), null, new b());
    }

    public static Set s(Set set, boolean z10, Function0 function0, pd.o oVar) {
        if (set == null) {
            a(9);
        }
        if (oVar == null) {
            a(10);
        }
        if (set.size() <= 1) {
            return set;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : set) {
            if (function0 != null) {
                function0.invoke();
            }
            Iterator it = linkedHashSet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    linkedHashSet.add(obj);
                    break;
                }
                cd.q qVar = (cd.q) oVar.invoke(obj, it.next());
                fe.a aVar = (fe.a) qVar.a();
                fe.a aVar2 = (fe.a) qVar.b();
                if (!J(aVar, aVar2, z10, true)) {
                    if (J(aVar2, aVar, z10, true)) {
                        break;
                    }
                } else {
                    it.remove();
                }
            }
        }
        return linkedHashSet;
    }

    public static Collection t(fe.e eVar, Collection collection) {
        if (eVar == null) {
            a(94);
        }
        if (collection == null) {
            a(95);
        }
        List listV = a0.V(collection, new e(eVar));
        if (listV == null) {
            a(96);
        }
        return listV;
    }

    public static fe.u u(Collection collection) {
        fe.u uVar;
        if (collection == null) {
            a(107);
        }
        if (collection.isEmpty()) {
            return fe.t.f9518l;
        }
        Iterator it = collection.iterator();
        loop0: while (true) {
            uVar = null;
            while (it.hasNext()) {
                fe.u visibility = ((fe.b) it.next()).getVisibility();
                if (uVar != null) {
                    Integer numD = fe.t.d(visibility, uVar);
                    if (numD == null) {
                        break;
                    }
                    if (numD.intValue() > 0) {
                    }
                }
                uVar = visibility;
            }
        }
        if (uVar == null) {
            return null;
        }
        Iterator it2 = collection.iterator();
        while (it2.hasNext()) {
            Integer numD2 = fe.t.d(uVar, ((fe.b) it2.next()).getVisibility());
            if (numD2 == null || numD2.intValue() < 0) {
                return null;
            }
        }
        return uVar;
    }

    public static i w(fe.a aVar, fe.a aVar2) {
        boolean z10;
        if (aVar == null) {
            a(38);
        }
        if (aVar2 == null) {
            a(39);
        }
        boolean z11 = aVar instanceof z;
        if ((z11 && !(aVar2 instanceof z)) || (((z10 = aVar instanceof y0)) && !(aVar2 instanceof y0))) {
            return i.d("Member kind mismatch");
        }
        if (!z11 && !z10) {
            throw new IllegalArgumentException("This type of CallableDescriptor cannot be checked for overridability: " + aVar);
        }
        if (!aVar.getName().equals(aVar2.getName())) {
            return i.d("Name mismatch");
        }
        i iVarE = e(aVar, aVar2);
        if (iVarE != null) {
            return iVarE;
        }
        return null;
    }

    public static i.a x(fe.a aVar, fe.a aVar2) {
        o oVar = f14337f;
        i.a aVarC = oVar.D(aVar2, aVar, null).c();
        i.a aVarC2 = oVar.D(aVar, aVar2, null).c();
        i.a aVar3 = i.a.OVERRIDABLE;
        if (aVarC == aVar3 && aVarC2 == aVar3) {
            return aVar3;
        }
        i.a aVar4 = i.a.CONFLICT;
        return (aVarC == aVar4 || aVarC2 == aVar4) ? aVar4 : i.a.INCOMPATIBLE;
    }

    public static e0 y(Collection collection, boolean z10, e0 e0Var) {
        if (collection == null) {
            a(91);
        }
        if (e0Var == null) {
            a(92);
        }
        e0 e0Var2 = e0.f9464e;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            fe.b bVar = (fe.b) it.next();
            e0 e0VarL = (z10 && bVar.l() == e0.f9464e) ? e0Var : bVar.l();
            if (e0VarL.compareTo(e0Var2) < 0) {
                e0Var2 = e0VarL;
            }
        }
        if (e0Var2 == null) {
            a(93);
        }
        return e0Var2;
    }

    public static Set z(fe.b bVar) {
        if (bVar == null) {
            a(15);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        f(bVar, linkedHashSet);
        return linkedHashSet;
    }

    public i D(fe.a aVar, fe.a aVar2, fe.e eVar) {
        if (aVar == null) {
            a(19);
        }
        if (aVar2 == null) {
            a(20);
        }
        i iVarE = E(aVar, aVar2, eVar, false);
        if (iVarE == null) {
            a(21);
        }
        return iVarE;
    }

    public i E(fe.a aVar, fe.a aVar2, fe.e eVar, boolean z10) {
        if (aVar == null) {
            a(22);
        }
        if (aVar2 == null) {
            a(23);
        }
        i iVarF = F(aVar, aVar2, z10);
        boolean z11 = iVarF.c() == i.a.OVERRIDABLE;
        for (j jVar : f14336e) {
            if (jVar.a() != j.a.CONFLICTS_ONLY && (!z11 || jVar.a() != j.a.SUCCESS_ONLY)) {
                int i10 = h.f14347a[jVar.b(aVar, aVar2, eVar).ordinal()];
                if (i10 == 1) {
                    z11 = true;
                } else if (i10 == 2) {
                    i iVarD = i.d("External condition");
                    if (iVarD == null) {
                        a(24);
                    }
                    return iVarD;
                }
            }
        }
        if (!z11) {
            return iVarF;
        }
        for (j jVar2 : f14336e) {
            if (jVar2.a() == j.a.CONFLICTS_ONLY) {
                int i11 = h.f14347a[jVar2.b(aVar, aVar2, eVar).ordinal()];
                if (i11 == 1) {
                    throw new IllegalStateException("Contract violation in " + jVar2.getClass().getName() + " condition. It's not supposed to end with success");
                }
                if (i11 == 2) {
                    i iVarD2 = i.d("External condition");
                    if (iVarD2 == null) {
                        a(26);
                    }
                    return iVarD2;
                }
            }
        }
        i iVarE = i.e();
        if (iVarE == null) {
            a(27);
        }
        return iVarE;
    }

    public i F(fe.a aVar, fe.a aVar2, boolean z10) {
        if (aVar == null) {
            a(28);
        }
        if (aVar2 == null) {
            a(29);
        }
        i iVarW = w(aVar, aVar2);
        if (iVarW != null) {
            return iVarW;
        }
        List listG = g(aVar);
        List listG2 = g(aVar2);
        List typeParameters = aVar.getTypeParameters();
        List typeParameters2 = aVar2.getTypeParameters();
        int i10 = 0;
        if (typeParameters.size() != typeParameters2.size()) {
            while (i10 < listG.size()) {
                if (!yf.e.f25402a.b((r0) listG.get(i10), (r0) listG2.get(i10))) {
                    i iVarD = i.d("Type parameter number mismatch");
                    if (iVarD == null) {
                        a(31);
                    }
                    return iVarD;
                }
                i10++;
            }
            i iVarB = i.b("Type parameter number mismatch");
            if (iVarB == null) {
                a(32);
            }
            return iVarB;
        }
        t1 t1VarL = l(typeParameters, typeParameters2);
        for (int i11 = 0; i11 < typeParameters.size(); i11++) {
            if (!c((l1) typeParameters.get(i11), (l1) typeParameters2.get(i11), t1VarL)) {
                i iVarD2 = i.d("Type parameter bounds mismatch");
                if (iVarD2 == null) {
                    a(33);
                }
                return iVarD2;
            }
        }
        while (i10 < listG.size()) {
            if (!d((r0) listG.get(i10), (r0) listG2.get(i10), t1VarL)) {
                i iVarD3 = i.d("Value parameter type mismatch");
                if (iVarD3 == null) {
                    a(34);
                }
                return iVarD3;
            }
            i10++;
        }
        if ((aVar instanceof z) && (aVar2 instanceof z) && ((z) aVar).isSuspend() != ((z) aVar2).isSuspend()) {
            i iVarB2 = i.b("Incompatible suspendability");
            if (iVarB2 == null) {
                a(35);
            }
            return iVarB2;
        }
        if (z10) {
            r0 returnType = aVar.getReturnType();
            r0 returnType2 = aVar2.getReturnType();
            if (returnType != null && returnType2 != null && ((!v0.a(returnType2) || !v0.a(returnType)) && !xf.g.f24969a.t(t1VarL, returnType2.Q0(), returnType.Q0()))) {
                i iVarB3 = i.b("Return type mismatch");
                if (iVarB3 == null) {
                    a(36);
                }
                return iVarB3;
            }
        }
        i iVarE = i.e();
        if (iVarE == null) {
            a(37);
        }
        return iVarE;
    }

    public final t1 l(List list, List list2) {
        if (list == null) {
            a(40);
        }
        if (list2 == null) {
            a(41);
        }
        if (list.isEmpty()) {
            t1 t1VarM0 = new p(null, this.f14341c, this.f14339a, this.f14340b, this.f14342d).M0(true, true);
            if (t1VarM0 == null) {
                a(42);
            }
            return t1VarM0;
        }
        HashMap map = new HashMap();
        for (int i10 = 0; i10 < list.size(); i10++) {
            map.put(((l1) list.get(i10)).k(), ((l1) list2.get(i10)).k());
        }
        t1 t1VarM02 = new p(map, this.f14341c, this.f14339a, this.f14340b, this.f14342d).M0(true, true);
        if (t1VarM02 == null) {
            a(43);
        }
        return t1VarM02;
    }

    public final Collection o(fe.b bVar, Collection collection, fe.e eVar, n nVar) {
        if (bVar == null) {
            a(57);
        }
        if (collection == null) {
            a(58);
        }
        if (eVar == null) {
            a(59);
        }
        if (nVar == null) {
            a(60);
        }
        ArrayList arrayList = new ArrayList(collection.size());
        hg.l lVarC = hg.l.c();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            fe.b bVar2 = (fe.b) it.next();
            i.a aVarC = D(bVar2, bVar, eVar).c();
            boolean zI = I(bVar, bVar2, false);
            int i10 = h.f14348b[aVarC.ordinal()];
            if (i10 == 1) {
                if (zI) {
                    lVarC.add(bVar2);
                }
                arrayList.add(bVar2);
            } else if (i10 == 2) {
                if (zI) {
                    nVar.c(bVar2, bVar);
                }
                arrayList.add(bVar2);
            }
        }
        nVar.d(bVar, lVarC);
        return arrayList;
    }

    public void v(ef.f fVar, Collection collection, Collection collection2, fe.e eVar, n nVar) {
        if (fVar == null) {
            a(50);
        }
        if (collection == null) {
            a(51);
        }
        if (collection2 == null) {
            a(52);
        }
        if (eVar == null) {
            a(53);
        }
        if (nVar == null) {
            a(54);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        Iterator it = collection2.iterator();
        while (it.hasNext()) {
            linkedHashSet.removeAll(o((fe.b) it.next(), collection, eVar, nVar));
        }
        k(eVar, linkedHashSet, nVar);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class d implements pd.k {
        @Override // pd.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public fe.b invoke(fe.b bVar) {
            return bVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class f implements pd.k {
        @Override // pd.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public fe.a invoke(fe.b bVar) {
            return bVar;
        }
    }
}
