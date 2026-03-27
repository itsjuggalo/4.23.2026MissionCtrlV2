package N1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;
import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: N1.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0487x extends C {
    public static final Parcelable.Creator<C0487x> CREATOR = new Y();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f2861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Double f2862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2863c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f2864d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f2865e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final E f2866f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final EnumC0473i0 f2867g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final C0462d f2868h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Long f2869i;

    public C0487x(byte[] bArr, Double d4, String str, List list, Integer num, E e4, String str2, C0462d c0462d, Long l4) {
        this.f2861a = (byte[]) AbstractC0940s.k(bArr);
        this.f2862b = d4;
        this.f2863c = (String) AbstractC0940s.k(str);
        this.f2864d = list;
        this.f2865e = num;
        this.f2866f = e4;
        this.f2869i = l4;
        if (str2 != null) {
            try {
                this.f2867g = EnumC0473i0.a(str2);
            } catch (C0471h0 e5) {
                throw new IllegalArgumentException(e5);
            }
        } else {
            this.f2867g = null;
        }
        this.f2868h = c0462d;
    }

    public boolean equals(Object obj) {
        List list;
        List list2;
        if (!(obj instanceof C0487x)) {
            return false;
        }
        C0487x c0487x = (C0487x) obj;
        return Arrays.equals(this.f2861a, c0487x.f2861a) && AbstractC0939q.b(this.f2862b, c0487x.f2862b) && AbstractC0939q.b(this.f2863c, c0487x.f2863c) && (((list = this.f2864d) == null && c0487x.f2864d == null) || (list != null && (list2 = c0487x.f2864d) != null && list.containsAll(list2) && c0487x.f2864d.containsAll(this.f2864d))) && AbstractC0939q.b(this.f2865e, c0487x.f2865e) && AbstractC0939q.b(this.f2866f, c0487x.f2866f) && AbstractC0939q.b(this.f2867g, c0487x.f2867g) && AbstractC0939q.b(this.f2868h, c0487x.f2868h) && AbstractC0939q.b(this.f2869i, c0487x.f2869i);
    }

    public int hashCode() {
        return AbstractC0939q.c(Integer.valueOf(Arrays.hashCode(this.f2861a)), this.f2862b, this.f2863c, this.f2864d, this.f2865e, this.f2866f, this.f2867g, this.f2868h, this.f2869i);
    }

    public List i() {
        return this.f2864d;
    }

    public C0462d k() {
        return this.f2868h;
    }

    public byte[] l() {
        return this.f2861a;
    }

    public Integer m() {
        return this.f2865e;
    }

    public String n() {
        return this.f2863c;
    }

    public Double o() {
        return this.f2862b;
    }

    public E p() {
        return this.f2866f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.k(parcel, 2, l(), false);
        A1.c.o(parcel, 3, o(), false);
        A1.c.E(parcel, 4, n(), false);
        A1.c.I(parcel, 5, i(), false);
        A1.c.w(parcel, 6, m(), false);
        A1.c.C(parcel, 7, p(), i4, false);
        EnumC0473i0 enumC0473i0 = this.f2867g;
        A1.c.E(parcel, 8, enumC0473i0 == null ? null : enumC0473i0.toString(), false);
        A1.c.C(parcel, 9, k(), i4, false);
        A1.c.z(parcel, 10, this.f2869i, false);
        A1.c.b(parcel, iA);
    }
}
