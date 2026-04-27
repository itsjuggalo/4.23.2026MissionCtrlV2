package d2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;
import com.google.android.gms.common.internal.AbstractC1207s;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: d2.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1451x extends AbstractC1396C {
    public static final Parcelable.Creator<C1451x> CREATOR = new C1417Y();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f13317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Double f13318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f13319c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f13320d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f13321e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final C1398E f13322f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final EnumC1436i0 f13323g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final C1425d f13324h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Long f13325i;

    public C1451x(byte[] bArr, Double d7, String str, List list, Integer num, C1398E c1398e, String str2, C1425d c1425d, Long l7) {
        this.f13317a = (byte[]) AbstractC1207s.k(bArr);
        this.f13318b = d7;
        this.f13319c = (String) AbstractC1207s.k(str);
        this.f13320d = list;
        this.f13321e = num;
        this.f13322f = c1398e;
        this.f13325i = l7;
        if (str2 != null) {
            try {
                this.f13323g = EnumC1436i0.a(str2);
            } catch (C1434h0 e7) {
                throw new IllegalArgumentException(e7);
            }
        } else {
            this.f13323g = null;
        }
        this.f13324h = c1425d;
    }

    public List A() {
        return this.f13320d;
    }

    public C1425d B() {
        return this.f13324h;
    }

    public byte[] C() {
        return this.f13317a;
    }

    public Integer D() {
        return this.f13321e;
    }

    public String E() {
        return this.f13319c;
    }

    public Double F() {
        return this.f13318b;
    }

    public C1398E G() {
        return this.f13322f;
    }

    public boolean equals(Object obj) {
        List list;
        List list2;
        if (!(obj instanceof C1451x)) {
            return false;
        }
        C1451x c1451x = (C1451x) obj;
        return Arrays.equals(this.f13317a, c1451x.f13317a) && AbstractC1206q.b(this.f13318b, c1451x.f13318b) && AbstractC1206q.b(this.f13319c, c1451x.f13319c) && (((list = this.f13320d) == null && c1451x.f13320d == null) || (list != null && (list2 = c1451x.f13320d) != null && list.containsAll(list2) && c1451x.f13320d.containsAll(this.f13320d))) && AbstractC1206q.b(this.f13321e, c1451x.f13321e) && AbstractC1206q.b(this.f13322f, c1451x.f13322f) && AbstractC1206q.b(this.f13323g, c1451x.f13323g) && AbstractC1206q.b(this.f13324h, c1451x.f13324h) && AbstractC1206q.b(this.f13325i, c1451x.f13325i);
    }

    public int hashCode() {
        return AbstractC1206q.c(Integer.valueOf(Arrays.hashCode(this.f13317a)), this.f13318b, this.f13319c, this.f13320d, this.f13321e, this.f13322f, this.f13323g, this.f13324h, this.f13325i);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.k(parcel, 2, C(), false);
        Q1.c.o(parcel, 3, F(), false);
        Q1.c.E(parcel, 4, E(), false);
        Q1.c.I(parcel, 5, A(), false);
        Q1.c.w(parcel, 6, D(), false);
        Q1.c.C(parcel, 7, G(), i7, false);
        EnumC1436i0 enumC1436i0 = this.f13323g;
        Q1.c.E(parcel, 8, enumC1436i0 == null ? null : enumC1436i0.toString(), false);
        Q1.c.C(parcel, 9, B(), i7, false);
        Q1.c.z(parcel, 10, this.f13325i, false);
        Q1.c.b(parcel, iA);
    }
}
