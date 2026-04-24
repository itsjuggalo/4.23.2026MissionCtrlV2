package s6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import s6.AbstractC2723j;
import s6.p;
import s6.y;

/* JADX INFO: renamed from: s6.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2721h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C2721h f23157d = new C2721h(true);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f23159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f23160c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f23158a = u.n(16);

    /* JADX INFO: renamed from: s6.h$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f23161a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f23162b;

        static {
            int[] iArr = new int[y.b.values().length];
            f23162b = iArr;
            try {
                iArr[y.b.f23234c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23162b[y.b.f23235d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f23162b[y.b.f23236e.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f23162b[y.b.f23237f.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f23162b[y.b.f23238g.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f23162b[y.b.f23239h.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f23162b[y.b.f23240i.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f23162b[y.b.f23241j.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f23162b[y.b.f23242k.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f23162b[y.b.f23245n.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f23162b[y.b.f23246o.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f23162b[y.b.f23248q.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f23162b[y.b.f23249r.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f23162b[y.b.f23250s.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f23162b[y.b.f23251t.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f23162b[y.b.f23243l.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f23162b[y.b.f23244m.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f23162b[y.b.f23247p.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr2 = new int[y.c.values().length];
            f23161a = iArr2;
            try {
                iArr2[y.c.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f23161a[y.c.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f23161a[y.c.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f23161a[y.c.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f23161a[y.c.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f23161a[y.c.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f23161a[y.c.BYTE_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f23161a[y.c.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f23161a[y.c.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    /* JADX INFO: renamed from: s6.h$b */
    public interface b extends Comparable {
        y.c C();

        p.a F(p.a aVar, p pVar);

        int d();

        boolean e();

        y.b f();

        boolean h();
    }

    public C2721h() {
    }

    public static int d(y.b bVar, int i8, Object obj) {
        int iC = C2719f.C(i8);
        if (bVar == y.b.f23243l) {
            iC *= 2;
        }
        return iC + e(bVar, obj);
    }

    public static int e(y.b bVar, Object obj) {
        switch (a.f23162b[bVar.ordinal()]) {
            case 1:
                return C2719f.g(((Double) obj).doubleValue());
            case 2:
                return C2719f.m(((Float) obj).floatValue());
            case 3:
                return C2719f.q(((Long) obj).longValue());
            case 4:
                return C2719f.E(((Long) obj).longValue());
            case 5:
                return C2719f.p(((Integer) obj).intValue());
            case 6:
                return C2719f.k(((Long) obj).longValue());
            case 7:
                return C2719f.j(((Integer) obj).intValue());
            case 8:
                return C2719f.b(((Boolean) obj).booleanValue());
            case 9:
                return C2719f.B((String) obj);
            case 10:
                return obj instanceof AbstractC2717d ? C2719f.e((AbstractC2717d) obj) : C2719f.c((byte[]) obj);
            case D3.m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                return C2719f.D(((Integer) obj).intValue());
            case 12:
                return C2719f.w(((Integer) obj).intValue());
            case 13:
                return C2719f.x(((Long) obj).longValue());
            case 14:
                return C2719f.y(((Integer) obj).intValue());
            case 15:
                return C2719f.A(((Long) obj).longValue());
            case com.amazon.c.a.a.c.f14230g /* 16 */:
                return C2719f.n((p) obj);
            case 17:
                return C2719f.s((p) obj);
            case 18:
                return obj instanceof AbstractC2723j.a ? C2719f.i(((AbstractC2723j.a) obj).d()) : C2719f.i(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int f(b bVar, Object obj) {
        y.b bVarF = bVar.f();
        int iD = bVar.d();
        if (!bVar.e()) {
            return d(bVarF, iD, obj);
        }
        int iD2 = 0;
        List list = (List) obj;
        if (bVar.h()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                iD2 += e(bVarF, it.next());
            }
            return C2719f.C(iD) + iD2 + C2719f.u(iD2);
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            iD2 += d(bVarF, iD, it2.next());
        }
        return iD2;
    }

    public static C2721h g() {
        return f23157d;
    }

    public static int l(y.b bVar, boolean z7) {
        if (z7) {
            return 2;
        }
        return bVar.b();
    }

    public static C2721h t() {
        return new C2721h();
    }

    public static Object u(C2718e c2718e, y.b bVar, boolean z7) {
        switch (a.f23162b[bVar.ordinal()]) {
            case 1:
                return Double.valueOf(c2718e.l());
            case 2:
                return Float.valueOf(c2718e.p());
            case 3:
                return Long.valueOf(c2718e.s());
            case 4:
                return Long.valueOf(c2718e.L());
            case 5:
                return Integer.valueOf(c2718e.r());
            case 6:
                return Long.valueOf(c2718e.o());
            case 7:
                return Integer.valueOf(c2718e.n());
            case 8:
                return Boolean.valueOf(c2718e.j());
            case 9:
                return z7 ? c2718e.I() : c2718e.H();
            case 10:
                return c2718e.k();
            case D3.m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                return Integer.valueOf(c2718e.K());
            case 12:
                return Integer.valueOf(c2718e.D());
            case 13:
                return Long.valueOf(c2718e.E());
            case 14:
                return Integer.valueOf(c2718e.F());
            case 15:
                return Long.valueOf(c2718e.G());
            case com.amazon.c.a.a.c.f14230g /* 16 */:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            case 17:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            case 18:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void w(s6.y.b r2, java.lang.Object r3) {
        /*
            r3.getClass()
            int[] r0 = s6.C2721h.a.f23161a
            s6.y$c r2 = r2.a()
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            r1 = 0
            switch(r2) {
                case 1: goto L3c;
                case 2: goto L39;
                case 3: goto L36;
                case 4: goto L33;
                case 5: goto L30;
                case 6: goto L2d;
                case 7: goto L24;
                case 8: goto L18;
                case 9: goto L15;
                default: goto L14;
            }
        L14:
            goto L3e
        L15:
            boolean r1 = r3 instanceof s6.p
            goto L3e
        L18:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L22
            boolean r2 = r3 instanceof s6.AbstractC2723j.a
            if (r2 == 0) goto L21
            goto L22
        L21:
            r0 = r1
        L22:
            r1 = r0
            goto L3e
        L24:
            boolean r2 = r3 instanceof s6.AbstractC2717d
            if (r2 != 0) goto L22
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L21
            goto L22
        L2d:
            boolean r1 = r3 instanceof java.lang.String
            goto L3e
        L30:
            boolean r1 = r3 instanceof java.lang.Boolean
            goto L3e
        L33:
            boolean r1 = r3 instanceof java.lang.Double
            goto L3e
        L36:
            boolean r1 = r3 instanceof java.lang.Float
            goto L3e
        L39:
            boolean r1 = r3 instanceof java.lang.Long
            goto L3e
        L3c:
            boolean r1 = r3 instanceof java.lang.Integer
        L3e:
            if (r1 == 0) goto L41
            return
        L41:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: s6.C2721h.w(s6.y$b, java.lang.Object):void");
    }

    public static void x(C2719f c2719f, y.b bVar, int i8, Object obj) throws IOException {
        if (bVar == y.b.f23243l) {
            c2719f.X(i8, (p) obj);
        } else {
            c2719f.v0(i8, l(bVar, false));
            y(c2719f, bVar, obj);
        }
    }

    public static void y(C2719f c2719f, y.b bVar, Object obj) throws IOException {
        switch (a.f23162b[bVar.ordinal()]) {
            case 1:
                c2719f.Q(((Double) obj).doubleValue());
                break;
            case 2:
                c2719f.W(((Float) obj).floatValue());
                break;
            case 3:
                c2719f.b0(((Long) obj).longValue());
                break;
            case 4:
                c2719f.y0(((Long) obj).longValue());
                break;
            case 5:
                c2719f.a0(((Integer) obj).intValue());
                break;
            case 6:
                c2719f.U(((Long) obj).longValue());
                break;
            case 7:
                c2719f.T(((Integer) obj).intValue());
                break;
            case 8:
                c2719f.L(((Boolean) obj).booleanValue());
                break;
            case 9:
                c2719f.u0((String) obj);
                break;
            case 10:
                if (!(obj instanceof AbstractC2717d)) {
                    c2719f.M((byte[]) obj);
                } else {
                    c2719f.O((AbstractC2717d) obj);
                }
                break;
            case D3.m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                c2719f.x0(((Integer) obj).intValue());
                break;
            case 12:
                c2719f.p0(((Integer) obj).intValue());
                break;
            case 13:
                c2719f.q0(((Long) obj).longValue());
                break;
            case 14:
                c2719f.r0(((Integer) obj).intValue());
                break;
            case 15:
                c2719f.t0(((Long) obj).longValue());
                break;
            case com.amazon.c.a.a.c.f14230g /* 16 */:
                c2719f.Y((p) obj);
                break;
            case 17:
                c2719f.d0((p) obj);
                break;
            case 18:
                c2719f.S(obj instanceof AbstractC2723j.a ? ((AbstractC2723j.a) obj).d() : ((Integer) obj).intValue());
                break;
        }
    }

    public static void z(b bVar, Object obj, C2719f c2719f) throws IOException {
        y.b bVarF = bVar.f();
        int iD = bVar.d();
        if (!bVar.e()) {
            x(c2719f, bVarF, iD, obj);
            return;
        }
        List list = (List) obj;
        if (!bVar.h()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                x(c2719f, bVarF, iD, it.next());
            }
            return;
        }
        c2719f.v0(iD, 2);
        Iterator it2 = list.iterator();
        int iE = 0;
        while (it2.hasNext()) {
            iE += e(bVarF, it2.next());
        }
        c2719f.n0(iE);
        Iterator it3 = list.iterator();
        while (it3.hasNext()) {
            y(c2719f, bVarF, it3.next());
        }
    }

    public void a(b bVar, Object obj) {
        List arrayList;
        if (!bVar.e()) {
            throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        }
        w(bVar.f(), obj);
        Object objH = h(bVar);
        if (objH == null) {
            arrayList = new ArrayList();
            this.f23158a.o(bVar, arrayList);
        } else {
            arrayList = (List) objH;
        }
        arrayList.add(obj);
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public C2721h clone() {
        C2721h c2721hT = t();
        for (int i8 = 0; i8 < this.f23158a.i(); i8++) {
            Map.Entry entryH = this.f23158a.h(i8);
            c2721hT.v((b) entryH.getKey(), entryH.getValue());
        }
        for (Map.Entry entry : this.f23158a.j()) {
            c2721hT.v((b) entry.getKey(), entry.getValue());
        }
        c2721hT.f23160c = this.f23160c;
        return c2721hT;
    }

    public final Object c(Object obj) {
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public Object h(b bVar) {
        return this.f23158a.get(bVar);
    }

    public Object i(b bVar, int i8) {
        if (!bVar.e()) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        Object objH = h(bVar);
        if (objH != null) {
            return ((List) objH).get(i8);
        }
        throw new IndexOutOfBoundsException();
    }

    public int j(b bVar) {
        if (!bVar.e()) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        Object objH = h(bVar);
        if (objH == null) {
            return 0;
        }
        return ((List) objH).size();
    }

    public int k() {
        int iF = 0;
        for (int i8 = 0; i8 < this.f23158a.i(); i8++) {
            Map.Entry entryH = this.f23158a.h(i8);
            iF += f((b) entryH.getKey(), entryH.getValue());
        }
        for (Map.Entry entry : this.f23158a.j()) {
            iF += f((b) entry.getKey(), entry.getValue());
        }
        return iF;
    }

    public boolean m(b bVar) {
        if (bVar.e()) {
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }
        return this.f23158a.get(bVar) != null;
    }

    public boolean n() {
        for (int i8 = 0; i8 < this.f23158a.i(); i8++) {
            if (!o(this.f23158a.h(i8))) {
                return false;
            }
        }
        Iterator it = this.f23158a.j().iterator();
        while (it.hasNext()) {
            if (!o((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public final boolean o(Map.Entry entry) {
        b bVar = (b) entry.getKey();
        if (bVar.C() != y.c.MESSAGE) {
            return true;
        }
        boolean zE = bVar.e();
        Object value = entry.getValue();
        if (!zE) {
            if (value instanceof p) {
                return ((p) value).e();
            }
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        Iterator it = ((List) value).iterator();
        while (it.hasNext()) {
            if (!((p) it.next()).e()) {
                return false;
            }
        }
        return true;
    }

    public Iterator p() {
        return this.f23160c ? new C2725l(this.f23158a.entrySet().iterator()) : this.f23158a.entrySet().iterator();
    }

    public void q() {
        if (this.f23159b) {
            return;
        }
        this.f23158a.m();
        this.f23159b = true;
    }

    public void r(C2721h c2721h) {
        for (int i8 = 0; i8 < c2721h.f23158a.i(); i8++) {
            s(c2721h.f23158a.h(i8));
        }
        Iterator it = c2721h.f23158a.j().iterator();
        while (it.hasNext()) {
            s((Map.Entry) it.next());
        }
    }

    public final void s(Map.Entry entry) {
        u uVar;
        Object objC;
        Object objH;
        b bVar = (b) entry.getKey();
        Object value = entry.getValue();
        if (bVar.e()) {
            Object objH2 = h(bVar);
            if (objH2 == null) {
                objH2 = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) objH2).add(c(it.next()));
            }
            this.f23158a.o(bVar, objH2);
            return;
        }
        if (bVar.C() != y.c.MESSAGE || (objH = h(bVar)) == null) {
            uVar = this.f23158a;
            objC = c(value);
        } else {
            objC = bVar.F(((p) objH).g(), (p) value).a();
            uVar = this.f23158a;
        }
        uVar.o(bVar, objC);
    }

    public void v(b bVar, Object obj) {
        if (!bVar.e()) {
            w(bVar.f(), obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                w(bVar.f(), it.next());
            }
            obj = arrayList;
        }
        this.f23158a.o(bVar, obj);
    }

    public C2721h(boolean z7) {
        q();
    }
}
