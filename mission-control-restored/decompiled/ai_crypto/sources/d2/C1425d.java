package d2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;

/* JADX INFO: renamed from: d2.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1425d extends Q1.a {
    public static final Parcelable.Creator<C1425d> CREATOR = new n0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1445r f13220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0 f13221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C1399F f13222c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final I0 f13223d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final C1404K f13224e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final C1406M f13225f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final E0 f13226g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final C1409P f13227h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final C1446s f13228i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final C1411S f13229j;

    public C1425d(C1445r c1445r, C0 c02, C1399F c1399f, I0 i02, C1404K c1404k, C1406M c1406m, E0 e02, C1409P c1409p, C1446s c1446s, C1411S c1411s) {
        this.f13220a = c1445r;
        this.f13222c = c1399f;
        this.f13221b = c02;
        this.f13223d = i02;
        this.f13224e = c1404k;
        this.f13225f = c1406m;
        this.f13226g = e02;
        this.f13227h = c1409p;
        this.f13228i = c1446s;
        this.f13229j = c1411s;
    }

    public C1445r A() {
        return this.f13220a;
    }

    public C1399F B() {
        return this.f13222c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1425d)) {
            return false;
        }
        C1425d c1425d = (C1425d) obj;
        return AbstractC1206q.b(this.f13220a, c1425d.f13220a) && AbstractC1206q.b(this.f13221b, c1425d.f13221b) && AbstractC1206q.b(this.f13222c, c1425d.f13222c) && AbstractC1206q.b(this.f13223d, c1425d.f13223d) && AbstractC1206q.b(this.f13224e, c1425d.f13224e) && AbstractC1206q.b(this.f13225f, c1425d.f13225f) && AbstractC1206q.b(this.f13226g, c1425d.f13226g) && AbstractC1206q.b(this.f13227h, c1425d.f13227h) && AbstractC1206q.b(this.f13228i, c1425d.f13228i) && AbstractC1206q.b(this.f13229j, c1425d.f13229j);
    }

    public int hashCode() {
        return AbstractC1206q.c(this.f13220a, this.f13221b, this.f13222c, this.f13223d, this.f13224e, this.f13225f, this.f13226g, this.f13227h, this.f13228i, this.f13229j);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.C(parcel, 2, A(), i7, false);
        Q1.c.C(parcel, 3, this.f13221b, i7, false);
        Q1.c.C(parcel, 4, B(), i7, false);
        Q1.c.C(parcel, 5, this.f13223d, i7, false);
        Q1.c.C(parcel, 6, this.f13224e, i7, false);
        Q1.c.C(parcel, 7, this.f13225f, i7, false);
        Q1.c.C(parcel, 8, this.f13226g, i7, false);
        Q1.c.C(parcel, 9, this.f13227h, i7, false);
        Q1.c.C(parcel, 10, this.f13228i, i7, false);
        Q1.c.C(parcel, 11, this.f13229j, i7, false);
        Q1.c.b(parcel, iA);
    }
}
