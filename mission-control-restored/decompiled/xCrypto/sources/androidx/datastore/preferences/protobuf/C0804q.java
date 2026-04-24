package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.k0;
import com.google.firebase.firestore.index.FirestoreIndexValueWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p2.C1698D;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0804q {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C0804q f7122d = new C0804q(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b0 f7123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f7124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f7125c;

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.q$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7126a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f7127b;

        static {
            int[] iArr = new int[k0.b.values().length];
            f7127b = iArr;
            try {
                iArr[k0.b.f7079c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7127b[k0.b.f7080d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7127b[k0.b.f7081e.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7127b[k0.b.f7082f.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7127b[k0.b.f7083g.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7127b[k0.b.f7084h.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f7127b[k0.b.f7085i.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f7127b[k0.b.f7086j.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f7127b[k0.b.f7088l.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f7127b[k0.b.f7089m.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f7127b[k0.b.f7087k.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f7127b[k0.b.f7090n.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f7127b[k0.b.f7091o.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f7127b[k0.b.f7093q.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f7127b[k0.b.f7094r.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f7127b[k0.b.f7095s.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f7127b[k0.b.f7096t.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f7127b[k0.b.f7092p.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr2 = new int[k0.c.values().length];
            f7126a = iArr2;
            try {
                iArr2[k0.c.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f7126a[k0.c.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f7126a[k0.c.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f7126a[k0.c.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f7126a[k0.c.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f7126a[k0.c.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f7126a[k0.c.BYTE_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f7126a[k0.c.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f7126a[k0.c.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.q$b */
    public interface b extends Comparable {
        boolean d();

        k0.b e();

        boolean f();

        int getNumber();
    }

    public C0804q() {
        this.f7123a = b0.r();
    }

    public static int b(k0.b bVar, int i4, Object obj) {
        int iO = AbstractC0796i.O(i4);
        if (bVar == k0.b.f7088l) {
            iO *= 2;
        }
        return iO + c(bVar, obj);
    }

    public static int c(k0.b bVar, Object obj) {
        switch (a.f7127b[bVar.ordinal()]) {
            case 1:
                return AbstractC0796i.i(((Double) obj).doubleValue());
            case 2:
                return AbstractC0796i.q(((Float) obj).floatValue());
            case 3:
                return AbstractC0796i.x(((Long) obj).longValue());
            case 4:
                return AbstractC0796i.S(((Long) obj).longValue());
            case 5:
                return AbstractC0796i.v(((Integer) obj).intValue());
            case 6:
                return AbstractC0796i.o(((Long) obj).longValue());
            case 7:
                return AbstractC0796i.m(((Integer) obj).intValue());
            case 8:
                return AbstractC0796i.d(((Boolean) obj).booleanValue());
            case 9:
                return AbstractC0796i.s((J) obj);
            case 10:
                return AbstractC0796i.A((J) obj);
            case 11:
                return obj instanceof AbstractC0793f ? AbstractC0796i.g((AbstractC0793f) obj) : AbstractC0796i.N((String) obj);
            case 12:
                return obj instanceof AbstractC0793f ? AbstractC0796i.g((AbstractC0793f) obj) : AbstractC0796i.e((byte[]) obj);
            case 13:
                return AbstractC0796i.Q(((Integer) obj).intValue());
            case 14:
                return AbstractC0796i.F(((Integer) obj).intValue());
            case FirestoreIndexValueWriter.INDEX_TYPE_NUMBER /* 15 */:
                return AbstractC0796i.H(((Long) obj).longValue());
            case 16:
                return AbstractC0796i.J(((Integer) obj).intValue());
            case C1698D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                return AbstractC0796i.L(((Long) obj).longValue());
            case C1698D.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                return AbstractC0796i.k(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int d(b bVar, Object obj) {
        k0.b bVarE = bVar.e();
        int number = bVar.getNumber();
        if (!bVar.d()) {
            return b(bVarE, number, obj);
        }
        List list = (List) obj;
        int size = list.size();
        int i4 = 0;
        if (!bVar.f()) {
            int iB = 0;
            while (i4 < size) {
                iB += b(bVarE, number, list.get(i4));
                i4++;
            }
            return iB;
        }
        if (list.isEmpty()) {
            return 0;
        }
        int iC = 0;
        while (i4 < size) {
            iC += c(bVarE, list.get(i4));
            i4++;
        }
        return AbstractC0796i.O(number) + iC + AbstractC0796i.Q(iC);
    }

    public static int i(k0.b bVar, boolean z4) {
        if (z4) {
            return 2;
        }
        return bVar.c();
    }

    public static boolean l(Map.Entry entry) {
        android.support.v4.media.session.b.a(entry.getKey());
        throw null;
    }

    public static boolean m(k0.b bVar, Object obj) {
        AbstractC0807u.a(obj);
        switch (a.f7126a[bVar.a().ordinal()]) {
            case 7:
                if ((obj instanceof AbstractC0793f) || (obj instanceof byte[])) {
                }
                break;
            case 8:
                if (!(obj instanceof Integer)) {
                }
                break;
            case 9:
                if (!(obj instanceof J)) {
                }
                break;
        }
        return false;
    }

    public static C0804q r() {
        return new C0804q();
    }

    public static void u(AbstractC0796i abstractC0796i, k0.b bVar, int i4, Object obj) {
        if (bVar == k0.b.f7088l) {
            abstractC0796i.q0(i4, (J) obj);
        } else {
            abstractC0796i.M0(i4, i(bVar, false));
            v(abstractC0796i, bVar, obj);
        }
    }

    public static void v(AbstractC0796i abstractC0796i, k0.b bVar, Object obj) {
        switch (a.f7127b[bVar.ordinal()]) {
            case 1:
                abstractC0796i.h0(((Double) obj).doubleValue());
                break;
            case 2:
                abstractC0796i.p0(((Float) obj).floatValue());
                break;
            case 3:
                abstractC0796i.x0(((Long) obj).longValue());
                break;
            case 4:
                abstractC0796i.Q0(((Long) obj).longValue());
                break;
            case 5:
                abstractC0796i.v0(((Integer) obj).intValue());
                break;
            case 6:
                abstractC0796i.n0(((Long) obj).longValue());
                break;
            case 7:
                abstractC0796i.l0(((Integer) obj).intValue());
                break;
            case 8:
                abstractC0796i.b0(((Boolean) obj).booleanValue());
                break;
            case 9:
                abstractC0796i.s0((J) obj);
                break;
            case 10:
                abstractC0796i.z0((J) obj);
                break;
            case 11:
                if (!(obj instanceof AbstractC0793f)) {
                    abstractC0796i.L0((String) obj);
                } else {
                    abstractC0796i.f0((AbstractC0793f) obj);
                }
                break;
            case 12:
                if (!(obj instanceof AbstractC0793f)) {
                    abstractC0796i.c0((byte[]) obj);
                } else {
                    abstractC0796i.f0((AbstractC0793f) obj);
                }
                break;
            case 13:
                abstractC0796i.O0(((Integer) obj).intValue());
                break;
            case 14:
                abstractC0796i.D0(((Integer) obj).intValue());
                break;
            case FirestoreIndexValueWriter.INDEX_TYPE_NUMBER /* 15 */:
                abstractC0796i.F0(((Long) obj).longValue());
                break;
            case 16:
                abstractC0796i.H0(((Integer) obj).intValue());
                break;
            case C1698D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                abstractC0796i.J0(((Long) obj).longValue());
                break;
            case C1698D.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                abstractC0796i.j0(((Integer) obj).intValue());
                break;
        }
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0804q clone() {
        C0804q c0804qR = r();
        int iL = this.f7123a.l();
        for (int i4 = 0; i4 < iL; i4++) {
            Map.Entry entryK = this.f7123a.k(i4);
            android.support.v4.media.session.b.a(entryK.getKey());
            c0804qR.s(null, entryK.getValue());
        }
        for (Map.Entry entry : this.f7123a.n()) {
            android.support.v4.media.session.b.a(entry.getKey());
            c0804qR.s(null, entry.getValue());
        }
        c0804qR.f7125c = this.f7125c;
        return c0804qR;
    }

    public Iterator e() {
        return j() ? Collections.emptyIterator() : this.f7125c ? new C0810x(this.f7123a.i().iterator()) : this.f7123a.i().iterator();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0804q) {
            return this.f7123a.equals(((C0804q) obj).f7123a);
        }
        return false;
    }

    public int f() {
        int iL = this.f7123a.l();
        int iG = 0;
        for (int i4 = 0; i4 < iL; i4++) {
            iG += g(this.f7123a.k(i4));
        }
        Iterator it = this.f7123a.n().iterator();
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
        int iL = this.f7123a.l();
        int iD = 0;
        for (int i4 = 0; i4 < iL; i4++) {
            Map.Entry entryK = this.f7123a.k(i4);
            android.support.v4.media.session.b.a(entryK.getKey());
            iD += d(null, entryK.getValue());
        }
        for (Map.Entry entry : this.f7123a.n()) {
            android.support.v4.media.session.b.a(entry.getKey());
            iD += d(null, entry.getValue());
        }
        return iD;
    }

    public int hashCode() {
        return this.f7123a.hashCode();
    }

    public boolean j() {
        return this.f7123a.isEmpty();
    }

    public boolean k() {
        int iL = this.f7123a.l();
        for (int i4 = 0; i4 < iL; i4++) {
            if (!l(this.f7123a.k(i4))) {
                return false;
            }
        }
        Iterator it = this.f7123a.n().iterator();
        while (it.hasNext()) {
            if (!l((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public Iterator n() {
        return j() ? Collections.emptyIterator() : this.f7125c ? new C0810x(this.f7123a.entrySet().iterator()) : this.f7123a.entrySet().iterator();
    }

    public void o() {
        if (this.f7124b) {
            return;
        }
        int iL = this.f7123a.l();
        for (int i4 = 0; i4 < iL; i4++) {
            Map.Entry entryK = this.f7123a.k(i4);
            if (entryK.getValue() instanceof AbstractC0806t) {
                ((AbstractC0806t) entryK.getValue()).z();
            }
        }
        this.f7123a.q();
        this.f7124b = true;
    }

    public void p(C0804q c0804q) {
        int iL = c0804q.f7123a.l();
        for (int i4 = 0; i4 < iL; i4++) {
            q(c0804q.f7123a.k(i4));
        }
        Iterator it = c0804q.f7123a.n().iterator();
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
        if (!bVar.d()) {
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
        this.f7123a.s(bVar, obj);
    }

    public final void t(b bVar, Object obj) {
        if (!m(bVar.e(), obj)) {
            throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(bVar.getNumber()), bVar.e().a(), obj.getClass().getName()));
        }
    }

    public C0804q(boolean z4) {
        this(b0.r());
        o();
    }

    public C0804q(b0 b0Var) {
        this.f7123a = b0Var;
        o();
    }
}
