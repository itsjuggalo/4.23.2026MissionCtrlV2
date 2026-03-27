package V1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.T;
import z1.C1984b;

/* JADX INFO: loaded from: classes.dex */
public final class l extends A1.a {
    public static final Parcelable.Creator<l> CREATOR = new m();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C1984b f5317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final T f5318c;

    public l(int i4, C1984b c1984b, T t4) {
        this.f5316a = i4;
        this.f5317b = c1984b;
        this.f5318c = t4;
    }

    public final C1984b i() {
        return this.f5317b;
    }

    public final T k() {
        return this.f5318c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.t(parcel, 1, this.f5316a);
        A1.c.C(parcel, 2, this.f5317b, i4, false);
        A1.c.C(parcel, 3, this.f5318c, i4, false);
        A1.c.b(parcel, iA);
    }
}
