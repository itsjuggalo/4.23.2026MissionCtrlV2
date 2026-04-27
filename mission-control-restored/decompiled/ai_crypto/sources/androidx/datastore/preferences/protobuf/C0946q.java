package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.k0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import k4.C2105D;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0946q {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C0946q f7530d = new C0946q(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b0 f7531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f7532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f7533c;

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.q$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7534a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f7535b;

        static {
            int[] iArr = new int[k0.b.values().length];
            f7535b = iArr;
            try {
                iArr[k0.b.f7487c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7535b[k0.b.f7488d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7535b[k0.b.f7489e.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7535b[k0.b.f7490f.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7535b[k0.b.f7491g.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7535b[k0.b.f7492h.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f7535b[k0.b.f7493i.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f7535b[k0.b.f7494j.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f7535b[k0.b.f7496l.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f7535b[k0.b.f7497m.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f7535b[k0.b.f7495k.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f7535b[k0.b.f7498n.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f7535b[k0.b.f7499o.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f7535b[k0.b.f7501q.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f7535b[k0.b.f7502r.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f7535b[k0.b.f7503s.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f7535b[k0.b.f7504t.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f7535b[k0.b.f7500p.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr2 = new int[k0.c.values().length];
            f7534a = iArr2;
            try {
                iArr2[k0.c.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f7534a[k0.c.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f7534a[k0.c.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f7534a[k0.c.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f7534a[k0.c.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f7534a[k0.c.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f7534a[k0.c.BYTE_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f7534a[k0.c.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f7534a[k0.c.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.q$b */
    public interface b extends Comparable {
        int d();

        boolean e();

        k0.b f();

        boolean g();
    }

    public C0946q() {
        this.f7531a = b0.r();
    }

    public static int b(k0.b bVar, int i7, Object obj) {
        int iO = AbstractC0938i.O(i7);
        if (bVar == k0.b.f7496l) {
            iO *= 2;
        }
        return iO + c(bVar, obj);
    }

    public static int c(k0.b bVar, Object obj) {
        switch (a.f7535b[bVar.ordinal()]) {
            case 1:
                return AbstractC0938i.i(((Double) obj).doubleValue());
            case 2:
                return AbstractC0938i.q(((Float) obj).floatValue());
            case 3:
                return AbstractC0938i.x(((Long) obj).longValue());
            case 4:
                return AbstractC0938i.S(((Long) obj).longValue());
            case 5:
                return AbstractC0938i.v(((Integer) obj).intValue());
            case 6:
                return AbstractC0938i.o(((Long) obj).longValue());
            case 7:
                return AbstractC0938i.m(((Integer) obj).intValue());
            case 8:
                return AbstractC0938i.d(((Boolean) obj).booleanValue());
            case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                return AbstractC0938i.s((J) obj);
            case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                return AbstractC0938i.A((J) obj);
            case 11:
                return obj instanceof AbstractC0935f ? AbstractC0938i.g((AbstractC0935f) obj) : AbstractC0938i.N((String) obj);
            case 12:
                return obj instanceof AbstractC0935f ? AbstractC0938i.g((AbstractC0935f) obj) : AbstractC0938i.e((byte[]) obj);
            case 13:
                return AbstractC0938i.Q(((Integer) obj).intValue());
            case 14:
                return AbstractC0938i.F(((Integer) obj).intValue());
            case 15:
                return AbstractC0938i.H(((Long) obj).longValue());
            case com.amazon.c.a.a.c.f10119g /* 16 */:
                return AbstractC0938i.J(((Integer) obj).intValue());
            case C2105D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                return AbstractC0938i.L(((Long) obj).longValue());
            case C2105D.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                return AbstractC0938i.k(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int d(b bVar, Object obj) {
        k0.b bVarF = bVar.f();
        int iD = bVar.d();
        if (!bVar.e()) {
            return b(bVarF, iD, obj);
        }
        List list = (List) obj;
        int size = list.size();
        int i7 = 0;
        if (!bVar.g()) {
            int iB = 0;
            while (i7 < size) {
                iB += b(bVarF, iD, list.get(i7));
                i7++;
            }
            return iB;
        }
        if (list.isEmpty()) {
            return 0;
        }
        int iC = 0;
        while (i7 < size) {
            iC += c(bVarF, list.get(i7));
            i7++;
        }
        return AbstractC0938i.O(iD) + iC + AbstractC0938i.Q(iC);
    }

    public static int i(k0.b bVar, boolean z7) {
        if (z7) {
            return 2;
        }
        return bVar.b();
    }

    public static boolean l(Map.Entry entry) {
        android.support.v4.media.session.b.a(entry.getKey());
        throw null;
    }

    public static boolean m(k0.b bVar, Object obj) {
        AbstractC0949u.a(obj);
        switch (a.f7534a[bVar.a().ordinal()]) {
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
                return (obj instanceof AbstractC0935f) || (obj instanceof byte[]);
            case 8:
                return obj instanceof Integer;
            case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                return obj instanceof J;
            default:
                return false;
        }
    }

    public static C0946q r() {
        return new C0946q();
    }

    public static void u(AbstractC0938i abstractC0938i, k0.b bVar, int i7, Object obj) {
        if (bVar == k0.b.f7496l) {
            abstractC0938i.q0(i7, (J) obj);
        } else {
            abstractC0938i.M0(i7, i(bVar, false));
            v(abstractC0938i, bVar, obj);
        }
    }

    public static void v(AbstractC0938i abstractC0938i, k0.b bVar, Object obj) {
        switch (a.f7535b[bVar.ordinal()]) {
            case 1:
                abstractC0938i.h0(((Double) obj).doubleValue());
                break;
            case 2:
                abstractC0938i.p0(((Float) obj).floatValue());
                break;
            case 3:
                abstractC0938i.x0(((Long) obj).longValue());
                break;
            case 4:
                abstractC0938i.Q0(((Long) obj).longValue());
                break;
            case 5:
                abstractC0938i.v0(((Integer) obj).intValue());
                break;
            case 6:
                abstractC0938i.n0(((Long) obj).longValue());
                break;
            case 7:
                abstractC0938i.l0(((Integer) obj).intValue());
                break;
            case 8:
                abstractC0938i.b0(((Boolean) obj).booleanValue());
                break;
            case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                abstractC0938i.s0((J) obj);
                break;
            case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                abstractC0938i.z0((J) obj);
                break;
            case 11:
                if (!(obj instanceof AbstractC0935f)) {
                    abstractC0938i.L0((String) obj);
                } else {
                    abstractC0938i.f0((AbstractC0935f) obj);
                }
                break;
            case 12:
                if (!(obj instanceof AbstractC0935f)) {
                    abstractC0938i.c0((byte[]) obj);
                } else {
                    abstractC0938i.f0((AbstractC0935f) obj);
                }
                break;
            case 13:
                abstractC0938i.O0(((Integer) obj).intValue());
                break;
            case 14:
                abstractC0938i.D0(((Integer) obj).intValue());
                break;
            case 15:
                abstractC0938i.F0(((Long) obj).longValue());
                break;
            case com.amazon.c.a.a.c.f10119g /* 16 */:
                abstractC0938i.H0(((Integer) obj).intValue());
                break;
            case C2105D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                abstractC0938i.J0(((Long) obj).longValue());
                break;
            case C2105D.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                abstractC0938i.j0(((Integer) obj).intValue());
                break;
        }
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0946q clone() {
        C0946q c0946qR = r();
        int iL = this.f7531a.l();
        for (int i7 = 0; i7 < iL; i7++) {
            Map.Entry entryK = this.f7531a.k(i7);
            android.support.v4.media.session.b.a(entryK.getKey());
            c0946qR.s(null, entryK.getValue());
        }
        for (Map.Entry entry : this.f7531a.n()) {
            android.support.v4.media.session.b.a(entry.getKey());
            c0946qR.s(null, entry.getValue());
        }
        c0946qR.f7533c = this.f7533c;
        return c0946qR;
    }

    public Iterator e() {
        return j() ? Collections.emptyIterator() : this.f7533c ? new C0952x(this.f7531a.i().iterator()) : this.f7531a.i().iterator();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0946q) {
            return this.f7531a.equals(((C0946q) obj).f7531a);
        }
        return false;
    }

    public int f() {
        int iL = this.f7531a.l();
        int iG = 0;
        for (int i7 = 0; i7 < iL; i7++) {
            iG += g(this.f7531a.k(i7));
        }
        Iterator it = this.f7531a.n().iterator();
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
        int iL = this.f7531a.l();
        int iD = 0;
        for (int i7 = 0; i7 < iL; i7++) {
            Map.Entry entryK = this.f7531a.k(i7);
            android.support.v4.media.session.b.a(entryK.getKey());
            iD += d(null, entryK.getValue());
        }
        for (Map.Entry entry : this.f7531a.n()) {
            android.support.v4.media.session.b.a(entry.getKey());
            iD += d(null, entry.getValue());
        }
        return iD;
    }

    public int hashCode() {
        return this.f7531a.hashCode();
    }

    public boolean j() {
        return this.f7531a.isEmpty();
    }

    public boolean k() {
        int iL = this.f7531a.l();
        for (int i7 = 0; i7 < iL; i7++) {
            if (!l(this.f7531a.k(i7))) {
                return false;
            }
        }
        Iterator it = this.f7531a.n().iterator();
        while (it.hasNext()) {
            if (!l((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public Iterator n() {
        return j() ? Collections.emptyIterator() : this.f7533c ? new C0952x(this.f7531a.entrySet().iterator()) : this.f7531a.entrySet().iterator();
    }

    public void o() {
        if (this.f7532b) {
            return;
        }
        int iL = this.f7531a.l();
        for (int i7 = 0; i7 < iL; i7++) {
            Map.Entry entryK = this.f7531a.k(i7);
            if (entryK.getValue() instanceof AbstractC0948t) {
                ((AbstractC0948t) entryK.getValue()).D();
            }
        }
        this.f7531a.q();
        this.f7532b = true;
    }

    public void p(C0946q c0946q) {
        int iL = c0946q.f7531a.l();
        for (int i7 = 0; i7 < iL; i7++) {
            q(c0946q.f7531a.k(i7));
        }
        Iterator it = c0946q.f7531a.n().iterator();
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
        this.f7531a.s(bVar, obj);
    }

    public final void t(b bVar, Object obj) {
        if (!m(bVar.f(), obj)) {
            throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(bVar.d()), bVar.f().a(), obj.getClass().getName()));
        }
    }

    public C0946q(boolean z7) {
        this(b0.r());
        o();
    }

    public C0946q(b0 b0Var) {
        this.f7531a = b0Var;
        o();
    }
}
