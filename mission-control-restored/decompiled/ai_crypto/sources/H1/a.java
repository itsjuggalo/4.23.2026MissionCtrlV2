package H1;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class a extends Q1.a {
    public static final Parcelable.Creator<a> CREATOR = new k();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f2554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f2555c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f2556d;

    public a(int i7, boolean z7, long j7, boolean z8) {
        this.f2553a = i7;
        this.f2554b = z7;
        this.f2555c = j7;
        this.f2556d = z8;
    }

    public long A() {
        return this.f2555c;
    }

    public boolean B() {
        return this.f2556d;
    }

    public boolean C() {
        return this.f2554b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.t(parcel, 1, this.f2553a);
        Q1.c.g(parcel, 2, C());
        Q1.c.x(parcel, 3, A());
        Q1.c.g(parcel, 4, B());
        Q1.c.b(parcel, iA);
    }
}
