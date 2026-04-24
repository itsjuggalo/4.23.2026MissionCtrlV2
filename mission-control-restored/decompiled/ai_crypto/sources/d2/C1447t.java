package d2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;
import com.google.android.gms.common.internal.AbstractC1207s;
import java.util.Arrays;

/* JADX INFO: renamed from: d2.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1447t extends Q1.a {
    public static final Parcelable.Creator<C1447t> CREATOR = new C1414V();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f13294c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C1433h f13295d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final C1431g f13296e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final C1435i f13297f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final C1427e f13298g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f13299h;

    public C1447t(String str, String str2, byte[] bArr, C1433h c1433h, C1431g c1431g, C1435i c1435i, C1427e c1427e, String str3) {
        boolean z7 = true;
        if ((c1433h == null || c1431g != null || c1435i != null) && ((c1433h != null || c1431g == null || c1435i != null) && (c1433h != null || c1431g != null || c1435i == null))) {
            z7 = false;
        }
        AbstractC1207s.a(z7);
        this.f13292a = str;
        this.f13293b = str2;
        this.f13294c = bArr;
        this.f13295d = c1433h;
        this.f13296e = c1431g;
        this.f13297f = c1435i;
        this.f13298g = c1427e;
        this.f13299h = str3;
    }

    public String A() {
        return this.f13299h;
    }

    public C1427e B() {
        return this.f13298g;
    }

    public String C() {
        return this.f13292a;
    }

    public byte[] D() {
        return this.f13294c;
    }

    public String E() {
        return this.f13293b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1447t)) {
            return false;
        }
        C1447t c1447t = (C1447t) obj;
        return AbstractC1206q.b(this.f13292a, c1447t.f13292a) && AbstractC1206q.b(this.f13293b, c1447t.f13293b) && Arrays.equals(this.f13294c, c1447t.f13294c) && AbstractC1206q.b(this.f13295d, c1447t.f13295d) && AbstractC1206q.b(this.f13296e, c1447t.f13296e) && AbstractC1206q.b(this.f13297f, c1447t.f13297f) && AbstractC1206q.b(this.f13298g, c1447t.f13298g) && AbstractC1206q.b(this.f13299h, c1447t.f13299h);
    }

    public int hashCode() {
        return AbstractC1206q.c(this.f13292a, this.f13293b, this.f13294c, this.f13296e, this.f13295d, this.f13297f, this.f13298g, this.f13299h);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.E(parcel, 1, C(), false);
        Q1.c.E(parcel, 2, E(), false);
        Q1.c.k(parcel, 3, D(), false);
        Q1.c.C(parcel, 4, this.f13295d, i7, false);
        Q1.c.C(parcel, 5, this.f13296e, i7, false);
        Q1.c.C(parcel, 6, this.f13297f, i7, false);
        Q1.c.C(parcel, 7, B(), i7, false);
        Q1.c.E(parcel, 8, A(), false);
        Q1.c.b(parcel, iA);
    }
}
