package com.google.protobuf;

import com.google.protobuf.B0;
import com.google.protobuf.C;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import k4.C2105D;

/* JADX INFO: renamed from: com.google.protobuf.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1251u {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C1251u f12785d = new C1251u(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q0 f12786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f12787b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f12788c;

    /* JADX INFO: renamed from: com.google.protobuf.u$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12789a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f12790b;

        static {
            int[] iArr = new int[B0.b.values().length];
            f12790b = iArr;
            try {
                iArr[B0.b.f12513c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12790b[B0.b.f12514d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12790b[B0.b.f12515e.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12790b[B0.b.f12516f.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f12790b[B0.b.f12517g.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f12790b[B0.b.f12518h.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f12790b[B0.b.f12519i.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f12790b[B0.b.f12520j.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f12790b[B0.b.f12522l.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f12790b[B0.b.f12523m.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f12790b[B0.b.f12521k.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f12790b[B0.b.f12524n.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f12790b[B0.b.f12525o.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f12790b[B0.b.f12527q.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f12790b[B0.b.f12528r.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f12790b[B0.b.f12529s.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f12790b[B0.b.f12530t.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f12790b[B0.b.f12526p.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr2 = new int[B0.c.values().length];
            f12789a = iArr2;
            try {
                iArr2[B0.c.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f12789a[B0.c.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f12789a[B0.c.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f12789a[B0.c.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f12789a[B0.c.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f12789a[B0.c.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f12789a[B0.c.BYTE_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f12789a[B0.c.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f12789a[B0.c.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    /* JADX INFO: renamed from: com.google.protobuf.u$b */
    public interface b extends Comparable {
        int d();

        boolean e();

        B0.b f();

        boolean g();
    }

    public C1251u() {
        this.f12786a = q0.r(16);
    }

    public static int b(B0.b bVar, int i7, Object obj) {
        int iQ = AbstractC1243l.Q(i7);
        if (bVar == B0.b.f12522l) {
            iQ *= 2;
        }
        return iQ + c(bVar, obj);
    }

    public static int c(B0.b bVar, Object obj) {
        switch (a.f12790b[bVar.ordinal()]) {
            case 1:
                return AbstractC1243l.k(((Double) obj).doubleValue());
            case 2:
                return AbstractC1243l.s(((Float) obj).floatValue());
            case 3:
                return AbstractC1243l.z(((Long) obj).longValue());
            case 4:
                return AbstractC1243l.U(((Long) obj).longValue());
            case 5:
                return AbstractC1243l.x(((Integer) obj).intValue());
            case 6:
                return AbstractC1243l.q(((Long) obj).longValue());
            case 7:
                return AbstractC1243l.o(((Integer) obj).intValue());
            case 8:
                return AbstractC1243l.f(((Boolean) obj).booleanValue());
            case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                return AbstractC1243l.u((V) obj);
            case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                return AbstractC1243l.C((V) obj);
            case 11:
                return obj instanceof AbstractC1240i ? AbstractC1243l.i((AbstractC1240i) obj) : AbstractC1243l.P((String) obj);
            case 12:
                return obj instanceof AbstractC1240i ? AbstractC1243l.i((AbstractC1240i) obj) : AbstractC1243l.g((byte[]) obj);
            case 13:
                return AbstractC1243l.S(((Integer) obj).intValue());
            case 14:
                return AbstractC1243l.H(((Integer) obj).intValue());
            case 15:
                return AbstractC1243l.J(((Long) obj).longValue());
            case com.amazon.c.a.a.c.f10119g /* 16 */:
                return AbstractC1243l.L(((Integer) obj).intValue());
            case C2105D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                return AbstractC1243l.N(((Long) obj).longValue());
            case C2105D.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                return obj instanceof C.a ? AbstractC1243l.m(((C.a) obj).d()) : AbstractC1243l.m(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int d(b bVar, Object obj) {
        B0.b bVarF = bVar.f();
        int iD = bVar.d();
        if (!bVar.e()) {
            return b(bVarF, iD, obj);
        }
        List list = (List) obj;
        int iB = 0;
        if (!bVar.g()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                iB += b(bVarF, iD, it.next());
            }
            return iB;
        }
        if (list.isEmpty()) {
            return 0;
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            iB += c(bVarF, it2.next());
        }
        return AbstractC1243l.Q(iD) + iB + AbstractC1243l.S(iB);
    }

    public static int i(B0.b bVar, boolean z7) {
        if (z7) {
            return 2;
        }
        return bVar.b();
    }

    public static boolean l(Map.Entry entry) {
        android.support.v4.media.session.b.a(entry.getKey());
        throw null;
    }

    public static boolean m(B0.b bVar, Object obj) {
        C.a(obj);
        switch (a.f12789a[bVar.a().ordinal()]) {
            case 1:
                return obj instanceof Integer;
            case 2:
                return obj instanceof Long;
            case 3:
                return obj instanceof Float;
            case 4:
                return obj instanceof Double;
            case 5:
                return obj instanceof Boolean;
            case 6:
                return obj instanceof String;
            case 7:
                return (obj instanceof AbstractC1240i) || (obj instanceof byte[]);
            case 8:
                return (obj instanceof Integer) || (obj instanceof C.a);
            case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                return obj instanceof V;
            default:
                return false;
        }
    }

    public static C1251u r() {
        return new C1251u();
    }

    public static void u(AbstractC1243l abstractC1243l, B0.b bVar, int i7, Object obj) {
        if (bVar == B0.b.f12522l) {
            abstractC1243l.v0(i7, (V) obj);
        } else {
            abstractC1243l.R0(i7, i(bVar, false));
            v(abstractC1243l, bVar, obj);
        }
    }

    public static void v(AbstractC1243l abstractC1243l, B0.b bVar, Object obj) {
        switch (a.f12790b[bVar.ordinal()]) {
            case 1:
                abstractC1243l.m0(((Double) obj).doubleValue());
                break;
            case 2:
                abstractC1243l.u0(((Float) obj).floatValue());
                break;
            case 3:
                abstractC1243l.C0(((Long) obj).longValue());
                break;
            case 4:
                abstractC1243l.V0(((Long) obj).longValue());
                break;
            case 5:
                abstractC1243l.A0(((Integer) obj).intValue());
                break;
            case 6:
                abstractC1243l.s0(((Long) obj).longValue());
                break;
            case 7:
                abstractC1243l.q0(((Integer) obj).intValue());
                break;
            case 8:
                abstractC1243l.g0(((Boolean) obj).booleanValue());
                break;
            case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                abstractC1243l.x0((V) obj);
                break;
            case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                abstractC1243l.E0((V) obj);
                break;
            case 11:
                if (!(obj instanceof AbstractC1240i)) {
                    abstractC1243l.Q0((String) obj);
                } else {
                    abstractC1243l.k0((AbstractC1240i) obj);
                }
                break;
            case 12:
                if (!(obj instanceof AbstractC1240i)) {
                    abstractC1243l.h0((byte[]) obj);
                } else {
                    abstractC1243l.k0((AbstractC1240i) obj);
                }
                break;
            case 13:
                abstractC1243l.T0(((Integer) obj).intValue());
                break;
            case 14:
                abstractC1243l.I0(((Integer) obj).intValue());
                break;
            case 15:
                abstractC1243l.K0(((Long) obj).longValue());
                break;
            case com.amazon.c.a.a.c.f10119g /* 16 */:
                abstractC1243l.M0(((Integer) obj).intValue());
                break;
            case C2105D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                abstractC1243l.O0(((Long) obj).longValue());
                break;
            case C2105D.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                if (!(obj instanceof C.a)) {
                    abstractC1243l.o0(((Integer) obj).intValue());
                } else {
                    abstractC1243l.o0(((C.a) obj).d());
                }
                break;
        }
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C1251u clone() {
        C1251u c1251uR = r();
        for (int i7 = 0; i7 < this.f12786a.l(); i7++) {
            Map.Entry entryK = this.f12786a.k(i7);
            android.support.v4.media.session.b.a(entryK.getKey());
            c1251uR.s(null, entryK.getValue());
        }
        for (Map.Entry entry : this.f12786a.n()) {
            android.support.v4.media.session.b.a(entry.getKey());
            c1251uR.s(null, entry.getValue());
        }
        c1251uR.f12788c = this.f12788c;
        return c1251uR;
    }

    public Iterator e() {
        return this.f12788c ? new H(this.f12786a.i().iterator()) : this.f12786a.i().iterator();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C1251u) {
            return this.f12786a.equals(((C1251u) obj).f12786a);
        }
        return false;
    }

    public int f() {
        int iG = 0;
        for (int i7 = 0; i7 < this.f12786a.l(); i7++) {
            iG += g(this.f12786a.k(i7));
        }
        Iterator it = this.f12786a.n().iterator();
        while (it.hasNext()) {
            iG += g((Map.Entry) it.next());
        }
        return iG;
    }

    public final int g(Map.Entry entry) {
        android.support.v4.media.session.b.a(entry.getKey());
        entry.getValue();
        throw null;
    }

    public int h() {
        int iD = 0;
        for (int i7 = 0; i7 < this.f12786a.l(); i7++) {
            Map.Entry entryK = this.f12786a.k(i7);
            android.support.v4.media.session.b.a(entryK.getKey());
            iD += d(null, entryK.getValue());
        }
        for (Map.Entry entry : this.f12786a.n()) {
            android.support.v4.media.session.b.a(entry.getKey());
            iD += d(null, entry.getValue());
        }
        return iD;
    }

    public int hashCode() {
        return this.f12786a.hashCode();
    }

    public boolean j() {
        return this.f12786a.isEmpty();
    }

    public boolean k() {
        for (int i7 = 0; i7 < this.f12786a.l(); i7++) {
            if (!l(this.f12786a.k(i7))) {
                return false;
            }
        }
        Iterator it = this.f12786a.n().iterator();
        while (it.hasNext()) {
            if (!l((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public Iterator n() {
        return this.f12788c ? new H(this.f12786a.entrySet().iterator()) : this.f12786a.entrySet().iterator();
    }

    public void o() {
        if (this.f12787b) {
            return;
        }
        for (int i7 = 0; i7 < this.f12786a.l(); i7++) {
            Map.Entry entryK = this.f12786a.k(i7);
            if (entryK.getValue() instanceof AbstractC1255y) {
                ((AbstractC1255y) entryK.getValue()).J();
            }
        }
        this.f12786a.q();
        this.f12787b = true;
    }

    public void p(C1251u c1251u) {
        for (int i7 = 0; i7 < c1251u.f12786a.l(); i7++) {
            q(c1251u.f12786a.k(i7));
        }
        Iterator it = c1251u.f12786a.n().iterator();
        while (it.hasNext()) {
            q((Map.Entry) it.next());
        }
    }

    public final void q(Map.Entry entry) {
        android.support.v4.media.session.b.a(entry.getKey());
        entry.getValue();
        throw null;
    }

    public void s(b bVar, Object obj) {
        if (!bVar.e()) {
            t(bVar, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                t(bVar, it.next());
            }
            obj = arrayList;
        }
        this.f12786a.s(bVar, obj);
    }

    public final void t(b bVar, Object obj) {
        if (!m(bVar.f(), obj)) {
            throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(bVar.d()), bVar.f().a(), obj.getClass().getName()));
        }
    }

    public C1251u(boolean z7) {
        this(q0.r(0));
        o();
    }

    public C1251u(q0 q0Var) {
        this.f12786a = q0Var;
        o();
    }
}
