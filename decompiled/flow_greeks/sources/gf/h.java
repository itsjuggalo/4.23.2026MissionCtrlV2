package gf;

import bb.d0;
import gf.j;
import gf.p;
import gf.y;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h f10659d = new h(true);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f10661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f10662c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f10660a = u.o(16);

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10663a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f10664b;

        static {
            int[] iArr = new int[y.b.values().length];
            f10664b = iArr;
            try {
                iArr[y.b.f10736c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10664b[y.b.f10737d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10664b[y.b.f10738e.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10664b[y.b.f10739f.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10664b[y.b.f10740g.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10664b[y.b.f10741h.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f10664b[y.b.f10742i.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f10664b[y.b.f10743j.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f10664b[y.b.f10744k.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f10664b[y.b.f10747n.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f10664b[y.b.f10748o.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f10664b[y.b.f10750q.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f10664b[y.b.f10751r.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f10664b[y.b.f10752s.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f10664b[y.b.f10753t.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f10664b[y.b.f10745l.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f10664b[y.b.f10746m.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f10664b[y.b.f10749p.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr2 = new int[y.c.values().length];
            f10663a = iArr2;
            try {
                iArr2[y.c.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f10663a[y.c.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f10663a[y.c.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f10663a[y.c.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f10663a[y.c.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f10663a[y.c.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f10663a[y.c.BYTE_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f10663a[y.c.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f10663a[y.c.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface b extends Comparable {
        int d();

        boolean e();

        y.b f();

        boolean g();

        p.a p(p.a aVar, p pVar);

        y.c r();
    }

    public h() {
    }

    public static int d(y.b bVar, int i10, Object obj) {
        int iC = f.C(i10);
        if (bVar == y.b.f10745l) {
            iC *= 2;
        }
        return iC + e(bVar, obj);
    }

    public static int e(y.b bVar, Object obj) {
        switch (a.f10664b[bVar.ordinal()]) {
            case 1:
                return f.g(((Double) obj).doubleValue());
            case 2:
                return f.m(((Float) obj).floatValue());
            case 3:
                return f.q(((Long) obj).longValue());
            case 4:
                return f.E(((Long) obj).longValue());
            case 5:
                return f.p(((Integer) obj).intValue());
            case 6:
                return f.k(((Long) obj).longValue());
            case 7:
                return f.j(((Integer) obj).intValue());
            case 8:
                return f.b(((Boolean) obj).booleanValue());
            case 9:
                return f.B((String) obj);
            case 10:
                return obj instanceof d ? f.e((d) obj) : f.c((byte[]) obj);
            case 11:
                return f.D(((Integer) obj).intValue());
            case 12:
                return f.w(((Integer) obj).intValue());
            case 13:
                return f.x(((Long) obj).longValue());
            case 14:
                return f.y(((Integer) obj).intValue());
            case 15:
                return f.A(((Long) obj).longValue());
            case 16:
                return f.n((p) obj);
            case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                return f.s((p) obj);
            case d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                return obj instanceof j.a ? f.i(((j.a) obj).d()) : f.i(((Integer) obj).intValue());
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
        if (bVar.g()) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                iD2 += e(bVarF, it.next());
            }
            return f.C(iD) + iD2 + f.u(iD2);
        }
        Iterator it2 = ((List) obj).iterator();
        while (it2.hasNext()) {
            iD2 += d(bVarF, iD, it2.next());
        }
        return iD2;
    }

    public static h g() {
        return f10659d;
    }

    public static int l(y.b bVar, boolean z10) {
        if (z10) {
            return 2;
        }
        return bVar.b();
    }

    public static h t() {
        return new h();
    }

    public static Object u(e eVar, y.b bVar, boolean z10) {
        switch (a.f10664b[bVar.ordinal()]) {
            case 1:
                return Double.valueOf(eVar.l());
            case 2:
                return Float.valueOf(eVar.p());
            case 3:
                return Long.valueOf(eVar.s());
            case 4:
                return Long.valueOf(eVar.L());
            case 5:
                return Integer.valueOf(eVar.r());
            case 6:
                return Long.valueOf(eVar.o());
            case 7:
                return Integer.valueOf(eVar.n());
            case 8:
                return Boolean.valueOf(eVar.j());
            case 9:
                return z10 ? eVar.I() : eVar.H();
            case 10:
                return eVar.k();
            case 11:
                return Integer.valueOf(eVar.K());
            case 12:
                return Integer.valueOf(eVar.D());
            case 13:
                return Long.valueOf(eVar.E());
            case 14:
                return Integer.valueOf(eVar.F());
            case 15:
                return Long.valueOf(eVar.G());
            case 16:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            case d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
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
    public static void w(gf.y.b r2, java.lang.Object r3) {
        /*
            r3.getClass()
            int[] r0 = gf.h.a.f10663a
            gf.y$c r2 = r2.a()
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
            boolean r1 = r3 instanceof gf.p
            goto L3e
        L18:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L22
            boolean r2 = r3 instanceof gf.j.a
            if (r2 == 0) goto L21
            goto L22
        L21:
            r0 = r1
        L22:
            r1 = r0
            goto L3e
        L24:
            boolean r2 = r3 instanceof gf.d
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
        throw new UnsupportedOperationException("Method not decompiled: gf.h.w(gf.y$b, java.lang.Object):void");
    }

    public static void x(f fVar, y.b bVar, int i10, Object obj) throws IOException {
        if (bVar == y.b.f10745l) {
            fVar.X(i10, (p) obj);
        } else {
            fVar.v0(i10, l(bVar, false));
            y(fVar, bVar, obj);
        }
    }

    public static void y(f fVar, y.b bVar, Object obj) throws IOException {
        switch (a.f10664b[bVar.ordinal()]) {
            case 1:
                fVar.Q(((Double) obj).doubleValue());
                break;
            case 2:
                fVar.W(((Float) obj).floatValue());
                break;
            case 3:
                fVar.b0(((Long) obj).longValue());
                break;
            case 4:
                fVar.y0(((Long) obj).longValue());
                break;
            case 5:
                fVar.a0(((Integer) obj).intValue());
                break;
            case 6:
                fVar.U(((Long) obj).longValue());
                break;
            case 7:
                fVar.T(((Integer) obj).intValue());
                break;
            case 8:
                fVar.L(((Boolean) obj).booleanValue());
                break;
            case 9:
                fVar.u0((String) obj);
                break;
            case 10:
                if (!(obj instanceof d)) {
                    fVar.M((byte[]) obj);
                } else {
                    fVar.O((d) obj);
                }
                break;
            case 11:
                fVar.x0(((Integer) obj).intValue());
                break;
            case 12:
                fVar.p0(((Integer) obj).intValue());
                break;
            case 13:
                fVar.q0(((Long) obj).longValue());
                break;
            case 14:
                fVar.r0(((Integer) obj).intValue());
                break;
            case 15:
                fVar.t0(((Long) obj).longValue());
                break;
            case 16:
                fVar.Y((p) obj);
                break;
            case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                fVar.d0((p) obj);
                break;
            case d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                if (!(obj instanceof j.a)) {
                    fVar.S(((Integer) obj).intValue());
                } else {
                    fVar.S(((j.a) obj).d());
                }
                break;
        }
    }

    public static void z(b bVar, Object obj, f fVar) throws IOException {
        y.b bVarF = bVar.f();
        int iD = bVar.d();
        if (!bVar.e()) {
            x(fVar, bVarF, iD, obj);
            return;
        }
        List list = (List) obj;
        if (!bVar.g()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                x(fVar, bVarF, iD, it.next());
            }
            return;
        }
        fVar.v0(iD, 2);
        Iterator it2 = list.iterator();
        int iE = 0;
        while (it2.hasNext()) {
            iE += e(bVarF, it2.next());
        }
        fVar.n0(iE);
        Iterator it3 = list.iterator();
        while (it3.hasNext()) {
            y(fVar, bVarF, it3.next());
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
            this.f10660a.p(bVar, arrayList);
        } else {
            arrayList = (List) objH;
        }
        arrayList.add(obj);
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public h clone() {
        h hVarT = t();
        for (int i10 = 0; i10 < this.f10660a.j(); i10++) {
            Map.Entry entryI = this.f10660a.i(i10);
            hVarT.v((b) entryI.getKey(), entryI.getValue());
        }
        for (Map.Entry entry : this.f10660a.k()) {
            hVarT.v((b) entry.getKey(), entry.getValue());
        }
        hVarT.f10662c = this.f10662c;
        return hVarT;
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
        return this.f10660a.get(bVar);
    }

    public Object i(b bVar, int i10) {
        if (!bVar.e()) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        Object objH = h(bVar);
        if (objH != null) {
            return ((List) objH).get(i10);
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
        for (int i10 = 0; i10 < this.f10660a.j(); i10++) {
            Map.Entry entryI = this.f10660a.i(i10);
            iF += f((b) entryI.getKey(), entryI.getValue());
        }
        for (Map.Entry entry : this.f10660a.k()) {
            iF += f((b) entry.getKey(), entry.getValue());
        }
        return iF;
    }

    public boolean m(b bVar) {
        if (bVar.e()) {
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }
        return this.f10660a.get(bVar) != null;
    }

    public boolean n() {
        for (int i10 = 0; i10 < this.f10660a.j(); i10++) {
            if (!o(this.f10660a.i(i10))) {
                return false;
            }
        }
        Iterator it = this.f10660a.k().iterator();
        while (it.hasNext()) {
            if (!o((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public final boolean o(Map.Entry entry) {
        b bVar = (b) entry.getKey();
        if (bVar.r() != y.c.MESSAGE) {
            return true;
        }
        if (!bVar.e()) {
            Object value = entry.getValue();
            if (value instanceof p) {
                return ((p) value).d();
            }
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        Iterator it = ((List) entry.getValue()).iterator();
        while (it.hasNext()) {
            if (!((p) it.next()).d()) {
                return false;
            }
        }
        return true;
    }

    public Iterator p() {
        return this.f10662c ? new l(this.f10660a.entrySet().iterator()) : this.f10660a.entrySet().iterator();
    }

    public void q() {
        if (this.f10661b) {
            return;
        }
        this.f10660a.n();
        this.f10661b = true;
    }

    public void r(h hVar) {
        for (int i10 = 0; i10 < hVar.f10660a.j(); i10++) {
            s(hVar.f10660a.i(i10));
        }
        Iterator it = hVar.f10660a.k().iterator();
        while (it.hasNext()) {
            s((Map.Entry) it.next());
        }
    }

    public final void s(Map.Entry entry) {
        b bVar = (b) entry.getKey();
        Object value = entry.getValue();
        if (bVar.e()) {
            Object objH = h(bVar);
            if (objH == null) {
                objH = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) objH).add(c(it.next()));
            }
            this.f10660a.p(bVar, objH);
            return;
        }
        if (bVar.r() != y.c.MESSAGE) {
            this.f10660a.p(bVar, c(value));
            return;
        }
        Object objH2 = h(bVar);
        if (objH2 == null) {
            this.f10660a.p(bVar, c(value));
        } else {
            this.f10660a.p(bVar, bVar.p(((p) objH2).f(), (p) value).build());
        }
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
        this.f10660a.p(bVar, obj);
    }

    public h(boolean z10) {
        q();
    }
}
