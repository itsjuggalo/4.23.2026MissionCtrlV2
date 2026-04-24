package d2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;

/* JADX INFO: renamed from: d2.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1427e extends Q1.a {
    public static final Parcelable.Creator<C1427e> CREATOR = new m0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1400G f13230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p0 f13231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C1429f f13232c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final r0 f13233d;

    public C1427e(C1400G c1400g, p0 p0Var, C1429f c1429f, r0 r0Var) {
        this.f13230a = c1400g;
        this.f13231b = p0Var;
        this.f13232c = c1429f;
        this.f13233d = r0Var;
    }

    public C1429f A() {
        return this.f13232c;
    }

    public C1400G B() {
        return this.f13230a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1427e)) {
            return false;
        }
        C1427e c1427e = (C1427e) obj;
        return AbstractC1206q.b(this.f13230a, c1427e.f13230a) && AbstractC1206q.b(this.f13231b, c1427e.f13231b) && AbstractC1206q.b(this.f13232c, c1427e.f13232c) && AbstractC1206q.b(this.f13233d, c1427e.f13233d);
    }

    public int hashCode() {
        return AbstractC1206q.c(this.f13230a, this.f13231b, this.f13232c, this.f13233d);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.C(parcel, 1, B(), i7, false);
        Q1.c.C(parcel, 2, this.f13231b, i7, false);
        Q1.c.C(parcel, 3, A(), i7, false);
        Q1.c.C(parcel, 4, this.f13233d, i7, false);
        Q1.c.b(parcel, iA);
    }
}
