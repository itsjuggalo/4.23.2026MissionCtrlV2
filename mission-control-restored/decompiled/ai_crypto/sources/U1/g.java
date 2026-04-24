package U1;

import U1.a;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class g extends Q1.a {
    public static final Parcelable.Creator<g> CREATOR = new e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a.C0083a f4783c;

    public g(int i7, String str, a.C0083a c0083a) {
        this.f4781a = i7;
        this.f4782b = str;
        this.f4783c = c0083a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int i8 = this.f4781a;
        int iA = Q1.c.a(parcel);
        Q1.c.t(parcel, 1, i8);
        Q1.c.E(parcel, 2, this.f4782b, false);
        Q1.c.C(parcel, 3, this.f4783c, i7, false);
        Q1.c.b(parcel, iA);
    }

    public g(String str, a.C0083a c0083a) {
        this.f4781a = 1;
        this.f4782b = str;
        this.f4783c = c0083a;
    }
}
