package N1;

import N1.EnumC0460c;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;
import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: N1.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0484u extends C {
    public static final Parcelable.Creator<C0484u> CREATOR = new U();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0488y f2844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final A f2845b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f2846c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f2847d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Double f2848e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f2849f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final C0475k f2850g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f2851h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final E f2852i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final EnumC0460c f2853j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final C0462d f2854k;

    public C0484u(C0488y c0488y, A a4, byte[] bArr, List list, Double d4, List list2, C0475k c0475k, Integer num, E e4, String str, C0462d c0462d) {
        this.f2844a = (C0488y) AbstractC0940s.k(c0488y);
        this.f2845b = (A) AbstractC0940s.k(a4);
        this.f2846c = (byte[]) AbstractC0940s.k(bArr);
        this.f2847d = (List) AbstractC0940s.k(list);
        this.f2848e = d4;
        this.f2849f = list2;
        this.f2850g = c0475k;
        this.f2851h = num;
        this.f2852i = e4;
        if (str != null) {
            try {
                this.f2853j = EnumC0460c.a(str);
            } catch (EnumC0460c.a e5) {
                throw new IllegalArgumentException(e5);
            }
        } else {
            this.f2853j = null;
        }
        this.f2854k = c0462d;
    }

    public boolean equals(Object obj) {
        List list;
        List list2;
        if (!(obj instanceof C0484u)) {
            return false;
        }
        C0484u c0484u = (C0484u) obj;
        return AbstractC0939q.b(this.f2844a, c0484u.f2844a) && AbstractC0939q.b(this.f2845b, c0484u.f2845b) && Arrays.equals(this.f2846c, c0484u.f2846c) && AbstractC0939q.b(this.f2848e, c0484u.f2848e) && this.f2847d.containsAll(c0484u.f2847d) && c0484u.f2847d.containsAll(this.f2847d) && (((list = this.f2849f) == null && c0484u.f2849f == null) || (list != null && (list2 = c0484u.f2849f) != null && list.containsAll(list2) && c0484u.f2849f.containsAll(this.f2849f))) && AbstractC0939q.b(this.f2850g, c0484u.f2850g) && AbstractC0939q.b(this.f2851h, c0484u.f2851h) && AbstractC0939q.b(this.f2852i, c0484u.f2852i) && AbstractC0939q.b(this.f2853j, c0484u.f2853j) && AbstractC0939q.b(this.f2854k, c0484u.f2854k);
    }

    public int hashCode() {
        return AbstractC0939q.c(this.f2844a, this.f2845b, Integer.valueOf(Arrays.hashCode(this.f2846c)), this.f2847d, this.f2848e, this.f2849f, this.f2850g, this.f2851h, this.f2852i, this.f2853j, this.f2854k);
    }

    public String i() {
        EnumC0460c enumC0460c = this.f2853j;
        if (enumC0460c == null) {
            return null;
        }
        return enumC0460c.toString();
    }

    public C0462d k() {
        return this.f2854k;
    }

    public C0475k l() {
        return this.f2850g;
    }

    public byte[] m() {
        return this.f2846c;
    }

    public List n() {
        return this.f2849f;
    }

    public List o() {
        return this.f2847d;
    }

    public Integer p() {
        return this.f2851h;
    }

    public C0488y q() {
        return this.f2844a;
    }

    public Double r() {
        return this.f2848e;
    }

    public E s() {
        return this.f2852i;
    }

    public A t() {
        return this.f2845b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.C(parcel, 2, q(), i4, false);
        A1.c.C(parcel, 3, t(), i4, false);
        A1.c.k(parcel, 4, m(), false);
        A1.c.I(parcel, 5, o(), false);
        A1.c.o(parcel, 6, r(), false);
        A1.c.I(parcel, 7, n(), false);
        A1.c.C(parcel, 8, l(), i4, false);
        A1.c.w(parcel, 9, p(), false);
        A1.c.C(parcel, 10, s(), i4, false);
        A1.c.E(parcel, 11, i(), false);
        A1.c.C(parcel, 12, k(), i4, false);
        A1.c.b(parcel, iA);
    }
}
