package N1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;

/* JADX INFO: renamed from: N1.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0464e extends A1.a {
    public static final Parcelable.Creator<C0464e> CREATOR = new m0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final G f2774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p0 f2775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C0466f f2776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final r0 f2777d;

    public C0464e(G g4, p0 p0Var, C0466f c0466f, r0 r0Var) {
        this.f2774a = g4;
        this.f2775b = p0Var;
        this.f2776c = c0466f;
        this.f2777d = r0Var;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0464e)) {
            return false;
        }
        C0464e c0464e = (C0464e) obj;
        return AbstractC0939q.b(this.f2774a, c0464e.f2774a) && AbstractC0939q.b(this.f2775b, c0464e.f2775b) && AbstractC0939q.b(this.f2776c, c0464e.f2776c) && AbstractC0939q.b(this.f2777d, c0464e.f2777d);
    }

    public int hashCode() {
        return AbstractC0939q.c(this.f2774a, this.f2775b, this.f2776c, this.f2777d);
    }

    public C0466f i() {
        return this.f2776c;
    }

    public G k() {
        return this.f2774a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.C(parcel, 1, k(), i4, false);
        A1.c.C(parcel, 2, this.f2775b, i4, false);
        A1.c.C(parcel, 3, i(), i4, false);
        A1.c.C(parcel, 4, this.f2777d, i4, false);
        A1.c.b(parcel, iA);
    }
}
