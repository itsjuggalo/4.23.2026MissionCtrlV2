package com.google.protobuf;

import com.google.protobuf.a2;
import com.google.protobuf.c0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class u {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final u f7154d = new u(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p1 f7155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f7156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f7157c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7158a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f7159b;

        static {
            int[] iArr = new int[a2.b.values().length];
            f7159b = iArr;
            try {
                iArr[a2.b.f6901c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7159b[a2.b.f6902d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7159b[a2.b.f6903e.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7159b[a2.b.f6904f.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7159b[a2.b.f6905g.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7159b[a2.b.f6906h.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f7159b[a2.b.f6907i.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f7159b[a2.b.f6908j.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f7159b[a2.b.f6910l.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f7159b[a2.b.f6911m.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f7159b[a2.b.f6909k.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f7159b[a2.b.f6912n.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f7159b[a2.b.f6913o.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f7159b[a2.b.f6915q.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f7159b[a2.b.f6916r.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f7159b[a2.b.f6917s.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f7159b[a2.b.f6918t.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f7159b[a2.b.f6914p.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr2 = new int[a2.c.values().length];
            f7158a = iArr2;
            try {
                iArr2[a2.c.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f7158a[a2.c.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f7158a[a2.c.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f7158a[a2.c.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f7158a[a2.c.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f7158a[a2.c.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f7158a[a2.c.BYTE_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f7158a[a2.c.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f7158a[a2.c.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface b extends Comparable {
        int d();

        boolean e();

        a2.b f();

        boolean g();
    }

    public u() {
        this.f7155a = p1.r(16);
    }

    public static int b(a2.b bVar, int i10, Object obj) {
        int iQ = l.Q(i10);
        if (bVar == a2.b.f6910l) {
            iQ *= 2;
        }
        return iQ + c(bVar, obj);
    }

    public static int c(a2.b bVar, Object obj) {
        switch (a.f7159b[bVar.ordinal()]) {
            case 1:
                return l.k(((Double) obj).doubleValue());
            case 2:
                return l.s(((Float) obj).floatValue());
            case 3:
                return l.z(((Long) obj).longValue());
            case 4:
                return l.U(((Long) obj).longValue());
            case 5:
                return l.x(((Integer) obj).intValue());
            case 6:
                return l.q(((Long) obj).longValue());
            case 7:
                return l.o(((Integer) obj).intValue());
            case 8:
                return l.f(((Boolean) obj).booleanValue());
            case 9:
                return l.u((u0) obj);
            case 10:
                return l.C((u0) obj);
            case 11:
                return obj instanceof i ? l.i((i) obj) : l.P((String) obj);
            case 12:
                return obj instanceof i ? l.i((i) obj) : l.g((byte[]) obj);
            case 13:
                return l.S(((Integer) obj).intValue());
            case 14:
                return l.H(((Integer) obj).intValue());
            case 15:
                return l.J(((Long) obj).longValue());
            case 16:
                return l.L(((Integer) obj).intValue());
            case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                return l.N(((Long) obj).longValue());
            case bb.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                return obj instanceof c0.a ? l.m(((c0.a) obj).d()) : l.m(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int d(b bVar, Object obj) {
        a2.b bVarF = bVar.f();
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
        return l.Q(iD) + iB + l.S(iB);
    }

    public static int i(a2.b bVar, boolean z10) {
        if (z10) {
            return 2;
        }
        return bVar.b();
    }

    public static boolean l(Map.Entry entry) {
        android.support.v4.media.session.b.a(entry.getKey());
        throw null;
    }

    public static boolean m(a2.b bVar, Object obj) {
        c0.a(obj);
        switch (a.f7158a[bVar.a().ordinal()]) {
            case 7:
                if ((obj instanceof i) || (obj instanceof byte[])) {
                }
                break;
            case 8:
                if ((obj instanceof Integer) || (obj instanceof c0.a)) {
                }
                break;
            case 9:
                if (!(obj instanceof u0)) {
                }
                break;
        }
        return false;
    }

    public static u r() {
        return new u();
    }

    public static void u(l lVar, a2.b bVar, int i10, Object obj) {
        if (bVar == a2.b.f6910l) {
            lVar.v0(i10, (u0) obj);
        } else {
            lVar.R0(i10, i(bVar, false));
            v(lVar, bVar, obj);
        }
    }

    public static void v(l lVar, a2.b bVar, Object obj) {
        switch (a.f7159b[bVar.ordinal()]) {
            case 1:
                lVar.m0(((Double) obj).doubleValue());
                break;
            case 2:
                lVar.u0(((Float) obj).floatValue());
                break;
            case 3:
                lVar.C0(((Long) obj).longValue());
                break;
            case 4:
                lVar.V0(((Long) obj).longValue());
                break;
            case 5:
                lVar.A0(((Integer) obj).intValue());
                break;
            case 6:
                lVar.s0(((Long) obj).longValue());
                break;
            case 7:
                lVar.q0(((Integer) obj).intValue());
                break;
            case 8:
                lVar.g0(((Boolean) obj).booleanValue());
                break;
            case 9:
                lVar.x0((u0) obj);
                break;
            case 10:
                lVar.E0((u0) obj);
                break;
            case 11:
                if (!(obj instanceof i)) {
                    lVar.Q0((String) obj);
                } else {
                    lVar.k0((i) obj);
                }
                break;
            case 12:
                if (!(obj instanceof i)) {
                    lVar.h0((byte[]) obj);
                } else {
                    lVar.k0((i) obj);
                }
                break;
            case 13:
                lVar.T0(((Integer) obj).intValue());
                break;
            case 14:
                lVar.I0(((Integer) obj).intValue());
                break;
            case 15:
                lVar.K0(((Long) obj).longValue());
                break;
            case 16:
                lVar.M0(((Integer) obj).intValue());
                break;
            case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                lVar.O0(((Long) obj).longValue());
                break;
            case bb.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                if (!(obj instanceof c0.a)) {
                    lVar.o0(((Integer) obj).intValue());
                } else {
                    lVar.o0(((c0.a) obj).d());
                }
                break;
        }
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public u clone() {
        u uVarR = r();
        for (int i10 = 0; i10 < this.f7155a.l(); i10++) {
            Map.Entry entryK = this.f7155a.k(i10);
            android.support.v4.media.session.b.a(entryK.getKey());
            uVarR.s(null, entryK.getValue());
        }
        for (Map.Entry entry : this.f7155a.n()) {
            android.support.v4.media.session.b.a(entry.getKey());
            uVarR.s(null, entry.getValue());
        }
        uVarR.f7157c = this.f7157c;
        return uVarR;
    }

    public Iterator e() {
        return this.f7157c ? new h0(this.f7155a.i().iterator()) : this.f7155a.i().iterator();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof u) {
            return this.f7155a.equals(((u) obj).f7155a);
        }
        return false;
    }

    public int f() {
        int iG = 0;
        for (int i10 = 0; i10 < this.f7155a.l(); i10++) {
            iG += g(this.f7155a.k(i10));
        }
        Iterator it = this.f7155a.n().iterator();
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
        for (int i10 = 0; i10 < this.f7155a.l(); i10++) {
            Map.Entry entryK = this.f7155a.k(i10);
            android.support.v4.media.session.b.a(entryK.getKey());
            iD += d(null, entryK.getValue());
        }
        for (Map.Entry entry : this.f7155a.n()) {
            android.support.v4.media.session.b.a(entry.getKey());
            iD += d(null, entry.getValue());
        }
        return iD;
    }

    public int hashCode() {
        return this.f7155a.hashCode();
    }

    public boolean j() {
        return this.f7155a.isEmpty();
    }

    public boolean k() {
        for (int i10 = 0; i10 < this.f7155a.l(); i10++) {
            if (!l(this.f7155a.k(i10))) {
                return false;
            }
        }
        Iterator it = this.f7155a.n().iterator();
        while (it.hasNext()) {
            if (!l((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public Iterator n() {
        return this.f7157c ? new h0(this.f7155a.entrySet().iterator()) : this.f7155a.entrySet().iterator();
    }

    public void o() {
        if (this.f7156b) {
            return;
        }
        for (int i10 = 0; i10 < this.f7155a.l(); i10++) {
            Map.Entry entryK = this.f7155a.k(i10);
            if (entryK.getValue() instanceof y) {
                ((y) entryK.getValue()).J();
            }
        }
        this.f7155a.q();
        this.f7156b = true;
    }

    public void p(u uVar) {
        for (int i10 = 0; i10 < uVar.f7155a.l(); i10++) {
            q(uVar.f7155a.k(i10));
        }
        Iterator it = uVar.f7155a.n().iterator();
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
        this.f7155a.s(bVar, obj);
    }

    public final void t(b bVar, Object obj) {
        if (!m(bVar.f(), obj)) {
            throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(bVar.d()), bVar.f().a(), obj.getClass().getName()));
        }
    }

    public u(boolean z10) {
        this(p1.r(0));
        o();
    }

    public u(p1 p1Var) {
        this.f7155a = p1Var;
        o();
    }
}
