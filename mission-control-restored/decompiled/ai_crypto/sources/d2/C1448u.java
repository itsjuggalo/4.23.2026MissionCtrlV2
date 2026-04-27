package d2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;
import com.google.android.gms.common.internal.AbstractC1207s;
import d2.EnumC1423c;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: d2.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1448u extends AbstractC1396C {
    public static final Parcelable.Creator<C1448u> CREATOR = new C1413U();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1452y f13300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C1394A f13301b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f13302c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f13303d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Double f13304e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f13305f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final C1438k f13306g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f13307h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final C1398E f13308i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final EnumC1423c f13309j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final C1425d f13310k;

    public C1448u(C1452y c1452y, C1394A c1394a, byte[] bArr, List list, Double d7, List list2, C1438k c1438k, Integer num, C1398E c1398e, String str, C1425d c1425d) {
        this.f13300a = (C1452y) AbstractC1207s.k(c1452y);
        this.f13301b = (C1394A) AbstractC1207s.k(c1394a);
        this.f13302c = (byte[]) AbstractC1207s.k(bArr);
        this.f13303d = (List) AbstractC1207s.k(list);
        this.f13304e = d7;
        this.f13305f = list2;
        this.f13306g = c1438k;
        this.f13307h = num;
        this.f13308i = c1398e;
        if (str != null) {
            try {
                this.f13309j = EnumC1423c.a(str);
            } catch (EnumC1423c.a e7) {
                throw new IllegalArgumentException(e7);
            }
        } else {
            this.f13309j = null;
        }
        this.f13310k = c1425d;
    }

    public String A() {
        EnumC1423c enumC1423c = this.f13309j;
        if (enumC1423c == null) {
            return null;
        }
        return enumC1423c.toString();
    }

    public C1425d B() {
        return this.f13310k;
    }

    public C1438k C() {
        return this.f13306g;
    }

    public byte[] D() {
        return this.f13302c;
    }

    public List E() {
        return this.f13305f;
    }

    public List F() {
        return this.f13303d;
    }

    public Integer G() {
        return this.f13307h;
    }

    public C1452y H() {
        return this.f13300a;
    }

    public Double I() {
        return this.f13304e;
    }

    public C1398E J() {
        return this.f13308i;
    }

    public C1394A K() {
        return this.f13301b;
    }

    public boolean equals(Object obj) {
        List list;
        List list2;
        if (!(obj instanceof C1448u)) {
            return false;
        }
        C1448u c1448u = (C1448u) obj;
        return AbstractC1206q.b(this.f13300a, c1448u.f13300a) && AbstractC1206q.b(this.f13301b, c1448u.f13301b) && Arrays.equals(this.f13302c, c1448u.f13302c) && AbstractC1206q.b(this.f13304e, c1448u.f13304e) && this.f13303d.containsAll(c1448u.f13303d) && c1448u.f13303d.containsAll(this.f13303d) && (((list = this.f13305f) == null && c1448u.f13305f == null) || (list != null && (list2 = c1448u.f13305f) != null && list.containsAll(list2) && c1448u.f13305f.containsAll(this.f13305f))) && AbstractC1206q.b(this.f13306g, c1448u.f13306g) && AbstractC1206q.b(this.f13307h, c1448u.f13307h) && AbstractC1206q.b(this.f13308i, c1448u.f13308i) && AbstractC1206q.b(this.f13309j, c1448u.f13309j) && AbstractC1206q.b(this.f13310k, c1448u.f13310k);
    }

    public int hashCode() {
        return AbstractC1206q.c(this.f13300a, this.f13301b, Integer.valueOf(Arrays.hashCode(this.f13302c)), this.f13303d, this.f13304e, this.f13305f, this.f13306g, this.f13307h, this.f13308i, this.f13309j, this.f13310k);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.C(parcel, 2, H(), i7, false);
        Q1.c.C(parcel, 3, K(), i7, false);
        Q1.c.k(parcel, 4, D(), false);
        Q1.c.I(parcel, 5, F(), false);
        Q1.c.o(parcel, 6, I(), false);
        Q1.c.I(parcel, 7, E(), false);
        Q1.c.C(parcel, 8, C(), i7, false);
        Q1.c.w(parcel, 9, G(), false);
        Q1.c.C(parcel, 10, J(), i7, false);
        Q1.c.E(parcel, 11, A(), false);
        Q1.c.C(parcel, 12, B(), i7, false);
        Q1.c.b(parcel, iA);
    }
}
