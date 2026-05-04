package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.j1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final q f1835d = new q(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a1 f1836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1838c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1839a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f1840b;

        static {
            int[] iArr = new int[j1.b.values().length];
            f1840b = iArr;
            try {
                iArr[j1.b.f1768c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1840b[j1.b.f1769d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1840b[j1.b.f1770e.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1840b[j1.b.f1771f.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1840b[j1.b.f1772g.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1840b[j1.b.f1773h.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1840b[j1.b.f1774i.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f1840b[j1.b.f1775j.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f1840b[j1.b.f1777l.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f1840b[j1.b.f1778m.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f1840b[j1.b.f1776k.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f1840b[j1.b.f1779n.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f1840b[j1.b.f1780o.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f1840b[j1.b.f1782q.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f1840b[j1.b.f1783r.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f1840b[j1.b.f1784s.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f1840b[j1.b.f1785t.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f1840b[j1.b.f1781p.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr2 = new int[j1.c.values().length];
            f1839a = iArr2;
            try {
                iArr2[j1.c.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f1839a[j1.c.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f1839a[j1.c.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f1839a[j1.c.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f1839a[j1.c.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f1839a[j1.c.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f1839a[j1.c.BYTE_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f1839a[j1.c.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f1839a[j1.c.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface b extends Comparable {
        int d();

        boolean e();

        j1.b f();

        boolean g();
    }

    public q() {
        this.f1836a = a1.r();
    }

    public static int b(j1.b bVar, int i10, Object obj) {
        int iO = i.O(i10);
        if (bVar == j1.b.f1777l) {
            iO *= 2;
        }
        return iO + c(bVar, obj);
    }

    public static int c(j1.b bVar, Object obj) {
        switch (a.f1840b[bVar.ordinal()]) {
            case 1:
                return i.i(((Double) obj).doubleValue());
            case 2:
                return i.q(((Float) obj).floatValue());
            case 3:
                return i.x(((Long) obj).longValue());
            case 4:
                return i.S(((Long) obj).longValue());
            case 5:
                return i.v(((Integer) obj).intValue());
            case 6:
                return i.o(((Long) obj).longValue());
            case 7:
                return i.m(((Integer) obj).intValue());
            case 8:
                return i.d(((Boolean) obj).booleanValue());
            case 9:
                return i.s((j0) obj);
            case 10:
                return i.A((j0) obj);
            case 11:
                return obj instanceof f ? i.g((f) obj) : i.N((String) obj);
            case 12:
                return obj instanceof f ? i.g((f) obj) : i.e((byte[]) obj);
            case 13:
                return i.Q(((Integer) obj).intValue());
            case 14:
                return i.F(((Integer) obj).intValue());
            case 15:
                return i.H(((Long) obj).longValue());
            case 16:
                return i.J(((Integer) obj).intValue());
            case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                return i.L(((Long) obj).longValue());
            case bb.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                return i.k(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int d(b bVar, Object obj) {
        j1.b bVarF = bVar.f();
        int iD = bVar.d();
        if (!bVar.e()) {
            return b(bVarF, iD, obj);
        }
        List list = (List) obj;
        int size = list.size();
        int i10 = 0;
        if (!bVar.g()) {
            int iB = 0;
            while (i10 < size) {
                iB += b(bVarF, iD, list.get(i10));
                i10++;
            }
            return iB;
        }
        if (list.isEmpty()) {
            return 0;
        }
        int iC = 0;
        while (i10 < size) {
            iC += c(bVarF, list.get(i10));
            i10++;
        }
        return i.O(iD) + iC + i.Q(iC);
    }

    public static int i(j1.b bVar, boolean z10) {
        if (z10) {
            return 2;
        }
        return bVar.b();
    }

    public static boolean l(Map.Entry entry) {
        android.support.v4.media.session.b.a(entry.getKey());
        throw null;
    }

    public static boolean m(j1.b bVar, Object obj) {
        u.a(obj);
        switch (a.f1839a[bVar.a().ordinal()]) {
            case 7:
                if ((obj instanceof f) || (obj instanceof byte[])) {
                }
                break;
            case 8:
                if (!(obj instanceof Integer)) {
                }
                break;
            case 9:
                if (!(obj instanceof j0)) {
                }
                break;
        }
        return false;
    }

    public static q r() {
        return new q();
    }

    public static void u(i iVar, j1.b bVar, int i10, Object obj) {
        if (bVar == j1.b.f1777l) {
            iVar.q0(i10, (j0) obj);
        } else {
            iVar.M0(i10, i(bVar, false));
            v(iVar, bVar, obj);
        }
    }

    public static void v(i iVar, j1.b bVar, Object obj) {
        switch (a.f1840b[bVar.ordinal()]) {
            case 1:
                iVar.h0(((Double) obj).doubleValue());
                break;
            case 2:
                iVar.p0(((Float) obj).floatValue());
                break;
            case 3:
                iVar.x0(((Long) obj).longValue());
                break;
            case 4:
                iVar.Q0(((Long) obj).longValue());
                break;
            case 5:
                iVar.v0(((Integer) obj).intValue());
                break;
            case 6:
                iVar.n0(((Long) obj).longValue());
                break;
            case 7:
                iVar.l0(((Integer) obj).intValue());
                break;
            case 8:
                iVar.b0(((Boolean) obj).booleanValue());
                break;
            case 9:
                iVar.s0((j0) obj);
                break;
            case 10:
                iVar.z0((j0) obj);
                break;
            case 11:
                if (!(obj instanceof f)) {
                    iVar.L0((String) obj);
                } else {
                    iVar.f0((f) obj);
                }
                break;
            case 12:
                if (!(obj instanceof f)) {
                    iVar.c0((byte[]) obj);
                } else {
                    iVar.f0((f) obj);
                }
                break;
            case 13:
                iVar.O0(((Integer) obj).intValue());
                break;
            case 14:
                iVar.D0(((Integer) obj).intValue());
                break;
            case 15:
                iVar.F0(((Long) obj).longValue());
                break;
            case 16:
                iVar.H0(((Integer) obj).intValue());
                break;
            case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                iVar.J0(((Long) obj).longValue());
                break;
            case bb.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                iVar.j0(((Integer) obj).intValue());
                break;
        }
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public q clone() {
        q qVarR = r();
        int iL = this.f1836a.l();
        for (int i10 = 0; i10 < iL; i10++) {
            Map.Entry entryK = this.f1836a.k(i10);
            android.support.v4.media.session.b.a(entryK.getKey());
            qVarR.s(null, entryK.getValue());
        }
        for (Map.Entry entry : this.f1836a.n()) {
            android.support.v4.media.session.b.a(entry.getKey());
            qVarR.s(null, entry.getValue());
        }
        qVarR.f1838c = this.f1838c;
        return qVarR;
    }

    public Iterator e() {
        return j() ? Collections.emptyIterator() : this.f1838c ? new x(this.f1836a.i().iterator()) : this.f1836a.i().iterator();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof q) {
            return this.f1836a.equals(((q) obj).f1836a);
        }
        return false;
    }

    public int f() {
        int iL = this.f1836a.l();
        int iG = 0;
        for (int i10 = 0; i10 < iL; i10++) {
            iG += g(this.f1836a.k(i10));
        }
        Iterator it = this.f1836a.n().iterator();
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
        int iL = this.f1836a.l();
        int iD = 0;
        for (int i10 = 0; i10 < iL; i10++) {
            Map.Entry entryK = this.f1836a.k(i10);
            android.support.v4.media.session.b.a(entryK.getKey());
            iD += d(null, entryK.getValue());
        }
        for (Map.Entry entry : this.f1836a.n()) {
            android.support.v4.media.session.b.a(entry.getKey());
            iD += d(null, entry.getValue());
        }
        return iD;
    }

    public int hashCode() {
        return this.f1836a.hashCode();
    }

    public boolean j() {
        return this.f1836a.isEmpty();
    }

    public boolean k() {
        int iL = this.f1836a.l();
        for (int i10 = 0; i10 < iL; i10++) {
            if (!l(this.f1836a.k(i10))) {
                return false;
            }
        }
        Iterator it = this.f1836a.n().iterator();
        while (it.hasNext()) {
            if (!l((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public Iterator n() {
        return j() ? Collections.emptyIterator() : this.f1838c ? new x(this.f1836a.entrySet().iterator()) : this.f1836a.entrySet().iterator();
    }

    public void o() {
        if (this.f1837b) {
            return;
        }
        int iL = this.f1836a.l();
        for (int i10 = 0; i10 < iL; i10++) {
            Map.Entry entryK = this.f1836a.k(i10);
            if (entryK.getValue() instanceof t) {
                ((t) entryK.getValue()).D();
            }
        }
        this.f1836a.q();
        this.f1837b = true;
    }

    public void p(q qVar) {
        int iL = qVar.f1836a.l();
        for (int i10 = 0; i10 < iL; i10++) {
            q(qVar.f1836a.k(i10));
        }
        Iterator it = qVar.f1836a.n().iterator();
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
        this.f1836a.s(bVar, obj);
    }

    public final void t(b bVar, Object obj) {
        if (!m(bVar.f(), obj)) {
            throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(bVar.d()), bVar.f().a(), obj.getClass().getName()));
        }
    }

    public q(boolean z10) {
        this(a1.r());
        o();
    }

    public q(a1 a1Var) {
        this.f1836a = a1Var;
        o();
    }
}
