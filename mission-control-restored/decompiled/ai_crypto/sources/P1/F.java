package P1;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class F extends Q1.a {
    public static final Parcelable.Creator<F> CREATOR = new G();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f4268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4270c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f4271d;

    public F(boolean z7, String str, int i7, int i8) {
        this.f4268a = z7;
        this.f4269b = str;
        this.f4270c = M.a(i7) - 1;
        this.f4271d = s.a(i8) - 1;
    }

    public final boolean A() {
        return this.f4268a;
    }

    public final int B() {
        return s.a(this.f4271d);
    }

    public final int C() {
        return M.a(this.f4270c);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.g(parcel, 1, this.f4268a);
        Q1.c.E(parcel, 2, this.f4269b, false);
        Q1.c.t(parcel, 3, this.f4270c);
        Q1.c.t(parcel, 4, this.f4271d);
        Q1.c.b(parcel, iA);
    }

    public final String zza() {
        return this.f4269b;
    }
}
