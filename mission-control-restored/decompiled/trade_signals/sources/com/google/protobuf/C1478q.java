package com.google.protobuf;

import com.google.protobuf.AbstractC1481u;
import com.google.protobuf.l0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.google.protobuf.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1478q {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C1478q f16502d = new C1478q(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b0 f16503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f16504b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f16505c;

    /* JADX INFO: renamed from: com.google.protobuf.q$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16506a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f16507b;

        static {
            int[] iArr = new int[l0.b.values().length];
            f16507b = iArr;
            try {
                iArr[l0.b.f16459c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16507b[l0.b.f16460d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16507b[l0.b.f16461e.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f16507b[l0.b.f16462f.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f16507b[l0.b.f16463g.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f16507b[l0.b.f16464h.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f16507b[l0.b.f16465i.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f16507b[l0.b.f16466j.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f16507b[l0.b.f16468l.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f16507b[l0.b.f16469m.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f16507b[l0.b.f16467k.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f16507b[l0.b.f16470n.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f16507b[l0.b.f16471o.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f16507b[l0.b.f16473q.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f16507b[l0.b.f16474r.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f16507b[l0.b.f16475s.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f16507b[l0.b.f16476t.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f16507b[l0.b.f16472p.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr2 = new int[l0.c.values().length];
            f16506a = iArr2;
            try {
                iArr2[l0.c.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f16506a[l0.c.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f16506a[l0.c.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f16506a[l0.c.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f16506a[l0.c.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f16506a[l0.c.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f16506a[l0.c.BYTE_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f16506a[l0.c.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f16506a[l0.c.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    /* JADX INFO: renamed from: com.google.protobuf.q$b */
    public interface b extends Comparable {
        int d();

        boolean e();

        l0.b f();

        boolean h();
    }

    public C1478q() {
        this.f16503a = b0.q(16);
    }

    public static int b(l0.b bVar, int i8, Object obj) {
        int iP = AbstractC1470i.P(i8);
        if (bVar == l0.b.f16468l) {
            iP *= 2;
        }
        return iP + c(bVar, obj);
    }

    public static int c(l0.b bVar, Object obj) {
        switch (a.f16507b[bVar.ordinal()]) {
            case 1:
                return AbstractC1470i.j(((Double) obj).doubleValue());
            case 2:
                return AbstractC1470i.r(((Float) obj).floatValue());
            case 3:
                return AbstractC1470i.y(((Long) obj).longValue());
            case 4:
                return AbstractC1470i.T(((Long) obj).longValue());
            case 5:
                return AbstractC1470i.w(((Integer) obj).intValue());
            case 6:
                return AbstractC1470i.p(((Long) obj).longValue());
            case 7:
                return AbstractC1470i.n(((Integer) obj).intValue());
            case 8:
                return AbstractC1470i.e(((Boolean) obj).booleanValue());
            case 9:
                return AbstractC1470i.t((J) obj);
            case 10:
                return AbstractC1470i.B((J) obj);
            case D3.m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                return obj instanceof AbstractC1467f ? AbstractC1470i.h((AbstractC1467f) obj) : AbstractC1470i.O((String) obj);
            case 12:
                return obj instanceof AbstractC1467f ? AbstractC1470i.h((AbstractC1467f) obj) : AbstractC1470i.f((byte[]) obj);
            case 13:
                return AbstractC1470i.R(((Integer) obj).intValue());
            case 14:
                return AbstractC1470i.G(((Integer) obj).intValue());
            case 15:
                return AbstractC1470i.I(((Long) obj).longValue());
            case com.amazon.c.a.a.c.f14230g /* 16 */:
                return AbstractC1470i.K(((Integer) obj).intValue());
            case 17:
                return AbstractC1470i.M(((Long) obj).longValue());
            case 18:
                return obj instanceof AbstractC1481u.a ? AbstractC1470i.l(((AbstractC1481u.a) obj).d()) : AbstractC1470i.l(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int d(b bVar, Object obj) {
        l0.b bVarF = bVar.f();
        int iD = bVar.d();
        if (!bVar.e()) {
            return b(bVarF, iD, obj);
        }
        List list = (List) obj;
        int iB = 0;
        if (!bVar.h()) {
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
        return AbstractC1470i.P(iD) + iB + AbstractC1470i.R(iB);
    }

    public static int i(l0.b bVar, boolean z7) {
        if (z7) {
            return 2;
        }
        return bVar.b();
    }

    public static boolean l(Map.Entry entry) {
        android.support.v4.media.session.b.a(entry.getKey());
        throw null;
    }

    public static boolean m(l0.b bVar, Object obj) {
        AbstractC1481u.a(obj);
        switch (a.f16506a[bVar.a().ordinal()]) {
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
                return (obj instanceof AbstractC1467f) || (obj instanceof byte[]);
            case 8:
                return (obj instanceof Integer) || (obj instanceof AbstractC1481u.a);
            case 9:
                return obj instanceof J;
            default:
                return false;
        }
    }

    public static C1478q r() {
        return new C1478q();
    }

    public static void u(AbstractC1470i abstractC1470i, l0.b bVar, int i8, Object obj) {
        if (bVar == l0.b.f16468l) {
            abstractC1470i.u0(i8, (J) obj);
        } else {
            abstractC1470i.Q0(i8, i(bVar, false));
            v(abstractC1470i, bVar, obj);
        }
    }

    public static void v(AbstractC1470i abstractC1470i, l0.b bVar, Object obj) {
        switch (a.f16507b[bVar.ordinal()]) {
            case 1:
                abstractC1470i.l0(((Double) obj).doubleValue());
                return;
            case 2:
                abstractC1470i.t0(((Float) obj).floatValue());
                return;
            case 3:
                abstractC1470i.B0(((Long) obj).longValue());
                return;
            case 4:
                abstractC1470i.U0(((Long) obj).longValue());
                return;
            case 5:
                abstractC1470i.z0(((Integer) obj).intValue());
                return;
            case 6:
                abstractC1470i.r0(((Long) obj).longValue());
                return;
            case 7:
                abstractC1470i.p0(((Integer) obj).intValue());
                return;
            case 8:
                abstractC1470i.f0(((Boolean) obj).booleanValue());
                return;
            case 9:
                abstractC1470i.w0((J) obj);
                return;
            case 10:
                abstractC1470i.D0((J) obj);
                return;
            case D3.m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                if (!(obj instanceof AbstractC1467f)) {
                    abstractC1470i.P0((String) obj);
                    return;
                }
                break;
            case 12:
                if (!(obj instanceof AbstractC1467f)) {
                    abstractC1470i.g0((byte[]) obj);
                    return;
                }
                break;
            case 13:
                abstractC1470i.S0(((Integer) obj).intValue());
                return;
            case 14:
                abstractC1470i.H0(((Integer) obj).intValue());
                return;
            case 15:
                abstractC1470i.J0(((Long) obj).longValue());
                return;
            case com.amazon.c.a.a.c.f14230g /* 16 */:
                abstractC1470i.L0(((Integer) obj).intValue());
                return;
            case 17:
                abstractC1470i.N0(((Long) obj).longValue());
                return;
            case 18:
                abstractC1470i.n0(obj instanceof AbstractC1481u.a ? ((AbstractC1481u.a) obj).d() : ((Integer) obj).intValue());
                return;
            default:
                return;
        }
        abstractC1470i.j0((AbstractC1467f) obj);
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C1478q clone() {
        C1478q c1478qR = r();
        for (int i8 = 0; i8 < this.f16503a.k(); i8++) {
            Map.Entry entryJ = this.f16503a.j(i8);
            android.support.v4.media.session.b.a(entryJ.getKey());
            c1478qR.s(null, entryJ.getValue());
        }
        for (Map.Entry entry : this.f16503a.m()) {
            android.support.v4.media.session.b.a(entry.getKey());
            c1478qR.s(null, entry.getValue());
        }
        c1478qR.f16505c = this.f16505c;
        return c1478qR;
    }

    public Iterator e() {
        return this.f16505c ? new C1484x(this.f16503a.h().iterator()) : this.f16503a.h().iterator();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C1478q) {
            return this.f16503a.equals(((C1478q) obj).f16503a);
        }
        return false;
    }

    public int f() {
        int iG = 0;
        for (int i8 = 0; i8 < this.f16503a.k(); i8++) {
            iG += g(this.f16503a.j(i8));
        }
        Iterator it = this.f16503a.m().iterator();
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
        for (int i8 = 0; i8 < this.f16503a.k(); i8++) {
            Map.Entry entryJ = this.f16503a.j(i8);
            android.support.v4.media.session.b.a(entryJ.getKey());
            iD += d(null, entryJ.getValue());
        }
        for (Map.Entry entry : this.f16503a.m()) {
            android.support.v4.media.session.b.a(entry.getKey());
            iD += d(null, entry.getValue());
        }
        return iD;
    }

    public int hashCode() {
        return this.f16503a.hashCode();
    }

    public boolean j() {
        return this.f16503a.isEmpty();
    }

    public boolean k() {
        for (int i8 = 0; i8 < this.f16503a.k(); i8++) {
            if (!l(this.f16503a.j(i8))) {
                return false;
            }
        }
        Iterator it = this.f16503a.m().iterator();
        while (it.hasNext()) {
            if (!l((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public Iterator n() {
        return this.f16505c ? new C1484x(this.f16503a.entrySet().iterator()) : this.f16503a.entrySet().iterator();
    }

    public void o() {
        if (this.f16504b) {
            return;
        }
        for (int i8 = 0; i8 < this.f16503a.k(); i8++) {
            Map.Entry entryJ = this.f16503a.j(i8);
            if (entryJ.getValue() instanceof AbstractC1480t) {
                ((AbstractC1480t) entryJ.getValue()).G();
            }
        }
        this.f16503a.p();
        this.f16504b = true;
    }

    public void p(C1478q c1478q) {
        for (int i8 = 0; i8 < c1478q.f16503a.k(); i8++) {
            q(c1478q.f16503a.j(i8));
        }
        Iterator it = c1478q.f16503a.m().iterator();
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
        this.f16503a.r(bVar, obj);
    }

    public final void t(b bVar, Object obj) {
        if (!m(bVar.f(), obj)) {
            throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(bVar.d()), bVar.f().a(), obj.getClass().getName()));
        }
    }

    public C1478q(b0 b0Var) {
        this.f16503a = b0Var;
        o();
    }

    public C1478q(boolean z7) {
        this(b0.q(0));
        o();
    }
}
