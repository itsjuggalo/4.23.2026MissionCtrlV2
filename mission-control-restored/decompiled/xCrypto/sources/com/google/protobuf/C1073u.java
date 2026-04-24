package com.google.protobuf;

import com.google.firebase.firestore.index.FirestoreIndexValueWriter;
import com.google.protobuf.C;
import com.google.protobuf.C0;
import com.google.protobuf.H;
import com.google.protobuf.W;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p2.C1698D;

/* JADX INFO: renamed from: com.google.protobuf.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1073u {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C1073u f11169d = new C1073u(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r0 f11170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f11171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f11172c;

    /* JADX INFO: renamed from: com.google.protobuf.u$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11173a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f11174b;

        static {
            int[] iArr = new int[C0.b.values().length];
            f11174b = iArr;
            try {
                iArr[C0.b.f10891c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11174b[C0.b.f10892d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11174b[C0.b.f10893e.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11174b[C0.b.f10894f.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f11174b[C0.b.f10895g.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f11174b[C0.b.f10896h.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f11174b[C0.b.f10897i.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f11174b[C0.b.f10898j.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f11174b[C0.b.f10900l.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f11174b[C0.b.f10901m.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f11174b[C0.b.f10899k.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f11174b[C0.b.f10902n.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f11174b[C0.b.f10903o.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f11174b[C0.b.f10905q.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f11174b[C0.b.f10906r.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f11174b[C0.b.f10907s.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f11174b[C0.b.f10908t.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f11174b[C0.b.f10904p.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr2 = new int[C0.c.values().length];
            f11173a = iArr2;
            try {
                iArr2[C0.c.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f11173a[C0.c.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f11173a[C0.c.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f11173a[C0.c.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f11173a[C0.c.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f11173a[C0.c.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f11173a[C0.c.BYTE_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f11173a[C0.c.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f11173a[C0.c.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    /* JADX INFO: renamed from: com.google.protobuf.u$b */
    public interface b extends Comparable {
        W.a b(W.a aVar, W w4);

        boolean d();

        C0.b e();

        boolean f();

        int getNumber();

        C0.c j();
    }

    public C1073u() {
        this.f11170a = r0.r(16);
    }

    public static Object c(Object obj) {
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public static int d(C0.b bVar, int i4, Object obj) {
        int iS = AbstractC1065l.S(i4);
        if (bVar == C0.b.f10900l) {
            iS *= 2;
        }
        return iS + e(bVar, obj);
    }

    public static int e(C0.b bVar, Object obj) {
        switch (a.f11174b[bVar.ordinal()]) {
            case 1:
                return AbstractC1065l.k(((Double) obj).doubleValue());
            case 2:
                return AbstractC1065l.s(((Float) obj).floatValue());
            case 3:
                return AbstractC1065l.z(((Long) obj).longValue());
            case 4:
                return AbstractC1065l.W(((Long) obj).longValue());
            case 5:
                return AbstractC1065l.x(((Integer) obj).intValue());
            case 6:
                return AbstractC1065l.q(((Long) obj).longValue());
            case 7:
                return AbstractC1065l.o(((Integer) obj).intValue());
            case 8:
                return AbstractC1065l.f(((Boolean) obj).booleanValue());
            case 9:
                return AbstractC1065l.u((W) obj);
            case 10:
                return AbstractC1065l.E((W) obj);
            case 11:
                return obj instanceof AbstractC1062i ? AbstractC1065l.i((AbstractC1062i) obj) : AbstractC1065l.R((String) obj);
            case 12:
                return obj instanceof AbstractC1062i ? AbstractC1065l.i((AbstractC1062i) obj) : AbstractC1065l.g((byte[]) obj);
            case 13:
                return AbstractC1065l.U(((Integer) obj).intValue());
            case 14:
                return AbstractC1065l.J(((Integer) obj).intValue());
            case FirestoreIndexValueWriter.INDEX_TYPE_NUMBER /* 15 */:
                return AbstractC1065l.L(((Long) obj).longValue());
            case 16:
                return AbstractC1065l.N(((Integer) obj).intValue());
            case C1698D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                return AbstractC1065l.P(((Long) obj).longValue());
            case C1698D.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                return obj instanceof C.c ? AbstractC1065l.m(((C.c) obj).getNumber()) : AbstractC1065l.m(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int f(b bVar, Object obj) {
        C0.b bVarE = bVar.e();
        int number = bVar.getNumber();
        if (!bVar.d()) {
            return d(bVarE, number, obj);
        }
        List list = (List) obj;
        int iD = 0;
        if (!bVar.f()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                iD += d(bVarE, number, it.next());
            }
            return iD;
        }
        if (list.isEmpty()) {
            return 0;
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            iD += e(bVarE, it2.next());
        }
        return AbstractC1065l.S(number) + iD + AbstractC1065l.U(iD);
    }

    public static int l(C0.b bVar, boolean z4) {
        if (z4) {
            return 2;
        }
        return bVar.c();
    }

    public static boolean o(Map.Entry entry) {
        b bVar = (b) entry.getKey();
        if (bVar.j() != C0.c.MESSAGE) {
            return true;
        }
        if (!bVar.d()) {
            return p(entry.getValue());
        }
        Iterator it = ((List) entry.getValue()).iterator();
        while (it.hasNext()) {
            if (!p(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean p(Object obj) {
        if (obj instanceof X) {
            return ((X) obj).isInitialized();
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    public static boolean q(C0.b bVar, Object obj) {
        C.a(obj);
        switch (a.f11173a[bVar.a().ordinal()]) {
            case 7:
                if ((obj instanceof AbstractC1062i) || (obj instanceof byte[])) {
                }
                break;
            case 8:
                if ((obj instanceof Integer) || (obj instanceof C.c)) {
                }
                break;
            case 9:
                if (!(obj instanceof W)) {
                }
                break;
        }
        return false;
    }

    public static C1073u v() {
        return new C1073u();
    }

    public static void y(AbstractC1065l abstractC1065l, C0.b bVar, int i4, Object obj) {
        if (bVar == C0.b.f10900l) {
            abstractC1065l.x0(i4, (W) obj);
        } else {
            abstractC1065l.T0(i4, l(bVar, false));
            z(abstractC1065l, bVar, obj);
        }
    }

    public static void z(AbstractC1065l abstractC1065l, C0.b bVar, Object obj) {
        switch (a.f11174b[bVar.ordinal()]) {
            case 1:
                abstractC1065l.o0(((Double) obj).doubleValue());
                break;
            case 2:
                abstractC1065l.w0(((Float) obj).floatValue());
                break;
            case 3:
                abstractC1065l.E0(((Long) obj).longValue());
                break;
            case 4:
                abstractC1065l.X0(((Long) obj).longValue());
                break;
            case 5:
                abstractC1065l.C0(((Integer) obj).intValue());
                break;
            case 6:
                abstractC1065l.u0(((Long) obj).longValue());
                break;
            case 7:
                abstractC1065l.s0(((Integer) obj).intValue());
                break;
            case 8:
                abstractC1065l.i0(((Boolean) obj).booleanValue());
                break;
            case 9:
                abstractC1065l.z0((W) obj);
                break;
            case 10:
                abstractC1065l.G0((W) obj);
                break;
            case 11:
                if (!(obj instanceof AbstractC1062i)) {
                    abstractC1065l.S0((String) obj);
                } else {
                    abstractC1065l.m0((AbstractC1062i) obj);
                }
                break;
            case 12:
                if (!(obj instanceof AbstractC1062i)) {
                    abstractC1065l.j0((byte[]) obj);
                } else {
                    abstractC1065l.m0((AbstractC1062i) obj);
                }
                break;
            case 13:
                abstractC1065l.V0(((Integer) obj).intValue());
                break;
            case 14:
                abstractC1065l.K0(((Integer) obj).intValue());
                break;
            case FirestoreIndexValueWriter.INDEX_TYPE_NUMBER /* 15 */:
                abstractC1065l.M0(((Long) obj).longValue());
                break;
            case 16:
                abstractC1065l.O0(((Integer) obj).intValue());
                break;
            case C1698D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                abstractC1065l.Q0(((Long) obj).longValue());
                break;
            case C1698D.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                if (!(obj instanceof C.c)) {
                    abstractC1065l.q0(((Integer) obj).intValue());
                } else {
                    abstractC1065l.q0(((C.c) obj).getNumber());
                }
                break;
        }
    }

    public void a(b bVar, Object obj) {
        List arrayList;
        if (!bVar.d()) {
            throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        }
        x(bVar, obj);
        Object objH = h(bVar);
        if (objH == null) {
            arrayList = new ArrayList();
            this.f11170a.s(bVar, arrayList);
        } else {
            arrayList = (List) objH;
        }
        arrayList.add(obj);
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public C1073u clone() {
        C1073u c1073uV = v();
        for (int i4 = 0; i4 < this.f11170a.l(); i4++) {
            Map.Entry entryK = this.f11170a.k(i4);
            c1073uV.w((b) entryK.getKey(), entryK.getValue());
        }
        for (Map.Entry entry : this.f11170a.n()) {
            c1073uV.w((b) entry.getKey(), entry.getValue());
        }
        c1073uV.f11172c = this.f11172c;
        return c1073uV;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C1073u) {
            return this.f11170a.equals(((C1073u) obj).f11170a);
        }
        return false;
    }

    public Iterator g() {
        return this.f11172c ? new H.b(this.f11170a.i().iterator()) : this.f11170a.i().iterator();
    }

    public Object h(b bVar) {
        return this.f11170a.get(bVar);
    }

    public int hashCode() {
        return this.f11170a.hashCode();
    }

    public int i() {
        int iJ = 0;
        for (int i4 = 0; i4 < this.f11170a.l(); i4++) {
            iJ += j(this.f11170a.k(i4));
        }
        Iterator it = this.f11170a.n().iterator();
        while (it.hasNext()) {
            iJ += j((Map.Entry) it.next());
        }
        return iJ;
    }

    public final int j(Map.Entry entry) {
        b bVar = (b) entry.getKey();
        Object value = entry.getValue();
        return (bVar.j() != C0.c.MESSAGE || bVar.d() || bVar.f()) ? f(bVar, value) : AbstractC1065l.B(((b) entry.getKey()).getNumber(), (W) value);
    }

    public int k() {
        int iF = 0;
        for (int i4 = 0; i4 < this.f11170a.l(); i4++) {
            Map.Entry entryK = this.f11170a.k(i4);
            iF += f((b) entryK.getKey(), entryK.getValue());
        }
        for (Map.Entry entry : this.f11170a.n()) {
            iF += f((b) entry.getKey(), entry.getValue());
        }
        return iF;
    }

    public boolean m() {
        return this.f11170a.isEmpty();
    }

    public boolean n() {
        for (int i4 = 0; i4 < this.f11170a.l(); i4++) {
            if (!o(this.f11170a.k(i4))) {
                return false;
            }
        }
        Iterator it = this.f11170a.n().iterator();
        while (it.hasNext()) {
            if (!o((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public Iterator r() {
        return this.f11172c ? new H.b(this.f11170a.entrySet().iterator()) : this.f11170a.entrySet().iterator();
    }

    public void s() {
        if (this.f11171b) {
            return;
        }
        for (int i4 = 0; i4 < this.f11170a.l(); i4++) {
            Map.Entry entryK = this.f11170a.k(i4);
            if (entryK.getValue() instanceof AbstractC1077y) {
                ((AbstractC1077y) entryK.getValue()).makeImmutable();
            }
        }
        this.f11170a.q();
        this.f11171b = true;
    }

    public void t(C1073u c1073u) {
        for (int i4 = 0; i4 < c1073u.f11170a.l(); i4++) {
            u(c1073u.f11170a.k(i4));
        }
        Iterator it = c1073u.f11170a.n().iterator();
        while (it.hasNext()) {
            u((Map.Entry) it.next());
        }
    }

    public final void u(Map.Entry entry) {
        b bVar = (b) entry.getKey();
        Object value = entry.getValue();
        if (bVar.d()) {
            Object objH = h(bVar);
            if (objH == null) {
                objH = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) objH).add(c(it.next()));
            }
            this.f11170a.s(bVar, objH);
            return;
        }
        if (bVar.j() != C0.c.MESSAGE) {
            this.f11170a.s(bVar, c(value));
            return;
        }
        Object objH2 = h(bVar);
        if (objH2 == null) {
            this.f11170a.s(bVar, c(value));
        } else {
            this.f11170a.s(bVar, bVar.b(((W) objH2).toBuilder(), (W) value).build());
        }
    }

    public void w(b bVar, Object obj) {
        if (!bVar.d()) {
            x(bVar, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                x(bVar, it.next());
            }
            obj = arrayList;
        }
        this.f11170a.s(bVar, obj);
    }

    public final void x(b bVar, Object obj) {
        if (!q(bVar.e(), obj)) {
            throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(bVar.getNumber()), bVar.e().a(), obj.getClass().getName()));
        }
    }

    public C1073u(boolean z4) {
        this(r0.r(0));
        s();
    }

    public C1073u(r0 r0Var) {
        this.f11170a = r0Var;
        s();
    }
}
