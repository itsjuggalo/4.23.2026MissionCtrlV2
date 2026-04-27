package S1;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class G6 extends A1.a {
    public static final Parcelable.Creator<G6> CREATOR = new H6();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f3976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f3977b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3978c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Bundle f3979d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f3980e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f3981f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f3982g;

    public G6(long j4, byte[] bArr, String str, Bundle bundle, int i4, long j5, String str2) {
        this.f3976a = j4;
        this.f3977b = bArr;
        this.f3978c = str;
        this.f3979d = bundle;
        this.f3980e = i4;
        this.f3981f = j5;
        this.f3982g = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        long j4 = this.f3976a;
        int iA = A1.c.a(parcel);
        A1.c.x(parcel, 1, j4);
        A1.c.k(parcel, 2, this.f3977b, false);
        A1.c.E(parcel, 3, this.f3978c, false);
        A1.c.j(parcel, 4, this.f3979d, false);
        A1.c.t(parcel, 5, this.f3980e);
        A1.c.x(parcel, 6, this.f3981f);
        A1.c.E(parcel, 7, this.f3982g, false);
        A1.c.b(parcel, iA);
    }
}
