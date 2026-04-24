package q1;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: q1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1719a extends A1.a {
    public static final Parcelable.Creator<C1719a> CREATOR = new k();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f14169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f14170c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f14171d;

    public C1719a(int i4, boolean z4, long j4, boolean z5) {
        this.f14168a = i4;
        this.f14169b = z4;
        this.f14170c = j4;
        this.f14171d = z5;
    }

    public long i() {
        return this.f14170c;
    }

    public boolean k() {
        return this.f14171d;
    }

    public boolean l() {
        return this.f14169b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.t(parcel, 1, this.f14168a);
        A1.c.g(parcel, 2, l());
        A1.c.x(parcel, 3, i());
        A1.c.g(parcel, 4, k());
        A1.c.b(parcel, iA);
    }
}
