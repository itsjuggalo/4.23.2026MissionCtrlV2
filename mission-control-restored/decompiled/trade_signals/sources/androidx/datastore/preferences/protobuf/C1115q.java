package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.k0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1115q {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C1115q f11342d = new C1115q(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b0 f11343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f11344b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f11345c;

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.q$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11346a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f11347b;

        static {
            int[] iArr = new int[k0.b.values().length];
            f11347b = iArr;
            try {
                iArr[k0.b.f11299c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11347b[k0.b.f11300d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11347b[k0.b.f11301e.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11347b[k0.b.f11302f.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f11347b[k0.b.f11303g.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f11347b[k0.b.f11304h.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f11347b[k0.b.f11305i.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f11347b[k0.b.f11306j.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f11347b[k0.b.f11308l.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f11347b[k0.b.f11309m.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f11347b[k0.b.f11307k.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f11347b[k0.b.f11310n.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f11347b[k0.b.f11311o.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f11347b[k0.b.f11313q.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f11347b[k0.b.f11314r.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f11347b[k0.b.f11315s.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f11347b[k0.b.f11316t.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f11347b[k0.b.f11312p.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr2 = new int[k0.c.values().length];
            f11346a = iArr2;
            try {
                iArr2[k0.c.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f11346a[k0.c.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f11346a[k0.c.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f11346a[k0.c.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f11346a[k0.c.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f11346a[k0.c.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f11346a[k0.c.BYTE_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f11346a[k0.c.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f11346a[k0.c.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.q$b */
    public interface b extends Comparable {
        int d();

        boolean e();

        k0.b f();

        boolean h();
    }

    public C1115q() {
        this.f11343a = b0.q();
    }

    public static int b(k0.b bVar, int i8, Object obj) {
        int iO = AbstractC1107i.O(i8);
        if (bVar == k0.b.f11308l) {
            iO *= 2;
        }
        return iO + c(bVar, obj);
    }

    public static int c(k0.b bVar, Object obj) {
        switch (a.f11347b[bVar.ordinal()]) {
            case 1:
                return AbstractC1107i.i(((Double) obj).doubleValue());
            case 2:
                return AbstractC1107i.q(((Float) obj).floatValue());
            case 3:
                return AbstractC1107i.x(((Long) obj).longValue());
            case 4:
                return AbstractC1107i.S(((Long) obj).longValue());
            case 5:
                return AbstractC1107i.v(((Integer) obj).intValue());
            case 6:
                return AbstractC1107i.o(((Long) obj).longValue());
            case 7:
                return AbstractC1107i.m(((Integer) obj).intValue());
            case 8:
                return AbstractC1107i.d(((Boolean) obj).booleanValue());
            case 9:
                return AbstractC1107i.s((J) obj);
            case 10:
                return AbstractC1107i.A((J) obj);
            case D3.m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                return obj instanceof AbstractC1104f ? AbstractC1107i.g((AbstractC1104f) obj) : AbstractC1107i.N((String) obj);
            case 12:
                return obj instanceof AbstractC1104f ? AbstractC1107i.g((AbstractC1104f) obj) : AbstractC1107i.e((byte[]) obj);
            case 13:
                return AbstractC1107i.Q(((Integer) obj).intValue());
            case 14:
                return AbstractC1107i.F(((Integer) obj).intValue());
            case 15:
                return AbstractC1107i.H(((Long) obj).longValue());
            case com.amazon.c.a.a.c.f14230g /* 16 */:
                return AbstractC1107i.J(((Integer) obj).intValue());
            case 17:
                return AbstractC1107i.L(((Long) obj).longValue());
            case 18:
                return AbstractC1107i.k(((Integer) obj).intValue());
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
        int i8 = 0;
        if (!bVar.h()) {
            int iB = 0;
            while (i8 < size) {
                iB += b(bVarF, iD, list.get(i8));
                i8++;
            }
            return iB;
        }
        if (list.isEmpty()) {
            return 0;
        }
        int iC = 0;
        while (i8 < size) {
            iC += c(bVarF, list.get(i8));
            i8++;
        }
        return AbstractC1107i.O(iD) + iC + AbstractC1107i.Q(iC);
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
        AbstractC1118u.a(obj);
        switch (a.f11346a[bVar.a().ordinal()]) {
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
                return (obj instanceof AbstractC1104f) || (obj instanceof byte[]);
            case 8:
                return obj instanceof Integer;
            case 9:
                return obj instanceof J;
            default:
                return false;
        }
    }

    public static C1115q r() {
        return new C1115q();
    }

    public static void u(AbstractC1107i abstractC1107i, k0.b bVar, int i8, Object obj) {
        if (bVar == k0.b.f11308l) {
            abstractC1107i.q0(i8, (J) obj);
        } else {
            abstractC1107i.M0(i8, i(bVar, false));
            v(abstractC1107i, bVar, obj);
        }
    }

    public static void v(AbstractC1107i abstractC1107i, k0.b bVar, Object obj) {
        switch (a.f11347b[bVar.ordinal()]) {
            case 1:
                abstractC1107i.h0(((Double) obj).doubleValue());
                return;
            case 2:
                abstractC1107i.p0(((Float) obj).floatValue());
                return;
            case 3:
                abstractC1107i.x0(((Long) obj).longValue());
                return;
            case 4:
                abstractC1107i.Q0(((Long) obj).longValue());
                return;
            case 5:
                abstractC1107i.v0(((Integer) obj).intValue());
                return;
            case 6:
                abstractC1107i.n0(((Long) obj).longValue());
                return;
            case 7:
                abstractC1107i.l0(((Integer) obj).intValue());
                return;
            case 8:
                abstractC1107i.b0(((Boolean) obj).booleanValue());
                return;
            case 9:
                abstractC1107i.s0((J) obj);
                return;
            case 10:
                abstractC1107i.z0((J) obj);
                return;
            case D3.m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                if (!(obj instanceof AbstractC1104f)) {
                    abstractC1107i.L0((String) obj);
                    return;
                }
                break;
            case 12:
                if (!(obj instanceof AbstractC1104f)) {
                    abstractC1107i.c0((byte[]) obj);
                    return;
                }
                break;
            case 13:
                abstractC1107i.O0(((Integer) obj).intValue());
                return;
            case 14:
                abstractC1107i.D0(((Integer) obj).intValue());
                return;
            case 15:
                abstractC1107i.F0(((Long) obj).longValue());
                return;
            case com.amazon.c.a.a.c.f14230g /* 16 */:
                abstractC1107i.H0(((Integer) obj).intValue());
                return;
            case 17:
                abstractC1107i.J0(((Long) obj).longValue());
                return;
            case 18:
                abstractC1107i.j0(((Integer) obj).intValue());
                return;
            default:
                return;
        }
        abstractC1107i.f0((AbstractC1104f) obj);
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C1115q clone() {
        C1115q c1115qR = r();
        int iK = this.f11343a.k();
        for (int i8 = 0; i8 < iK; i8++) {
            Map.Entry entryJ = this.f11343a.j(i8);
            android.support.v4.media.session.b.a(entryJ.getKey());
            c1115qR.s(null, entryJ.getValue());
        }
        for (Map.Entry entry : this.f11343a.m()) {
            android.support.v4.media.session.b.a(entry.getKey());
            c1115qR.s(null, entry.getValue());
        }
        c1115qR.f11345c = this.f11345c;
        return c1115qR;
    }

    public Iterator e() {
        return j() ? Collections.emptyIterator() : this.f11345c ? new C1121x(this.f11343a.h().iterator()) : this.f11343a.h().iterator();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C1115q) {
            return this.f11343a.equals(((C1115q) obj).f11343a);
        }
        return false;
    }

    public int f() {
        int iK = this.f11343a.k();
        int iG = 0;
        for (int i8 = 0; i8 < iK; i8++) {
            iG += g(this.f11343a.j(i8));
        }
        Iterator it = this.f11343a.m().iterator();
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
        int iK = this.f11343a.k();
        int iD = 0;
        for (int i8 = 0; i8 < iK; i8++) {
            Map.Entry entryJ = this.f11343a.j(i8);
            android.support.v4.media.session.b.a(entryJ.getKey());
            iD += d(null, entryJ.getValue());
        }
        for (Map.Entry entry : this.f11343a.m()) {
            android.support.v4.media.session.b.a(entry.getKey());
            iD += d(null, entry.getValue());
        }
        return iD;
    }

    public int hashCode() {
        return this.f11343a.hashCode();
    }

    public boolean j() {
        return this.f11343a.isEmpty();
    }

    public boolean k() {
        int iK = this.f11343a.k();
        for (int i8 = 0; i8 < iK; i8++) {
            if (!l(this.f11343a.j(i8))) {
                return false;
            }
        }
        Iterator it = this.f11343a.m().iterator();
        while (it.hasNext()) {
            if (!l((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public Iterator n() {
        return j() ? Collections.emptyIterator() : this.f11345c ? new C1121x(this.f11343a.entrySet().iterator()) : this.f11343a.entrySet().iterator();
    }

    public void o() {
        if (this.f11344b) {
            return;
        }
        int iK = this.f11343a.k();
        for (int i8 = 0; i8 < iK; i8++) {
            Map.Entry entryJ = this.f11343a.j(i8);
            if (entryJ.getValue() instanceof AbstractC1117t) {
                ((AbstractC1117t) entryJ.getValue()).D();
            }
        }
        this.f11343a.p();
        this.f11344b = true;
    }

    public void p(C1115q c1115q) {
        int iK = c1115q.f11343a.k();
        for (int i8 = 0; i8 < iK; i8++) {
            q(c1115q.f11343a.j(i8));
        }
        Iterator it = c1115q.f11343a.m().iterator();
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
        this.f11343a.r(bVar, obj);
    }

    public final void t(b bVar, Object obj) {
        if (!m(bVar.f(), obj)) {
            throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(bVar.d()), bVar.f().a(), obj.getClass().getName()));
        }
    }

    public C1115q(b0 b0Var) {
        this.f11343a = b0Var;
        o();
    }

    public C1115q(boolean z7) {
        this(b0.q());
        o();
    }
}
