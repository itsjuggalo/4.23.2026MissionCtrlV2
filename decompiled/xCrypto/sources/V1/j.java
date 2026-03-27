package V1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Q;

/* JADX INFO: loaded from: classes.dex */
public final class j extends A1.a {
    public static final Parcelable.Creator<j> CREATOR = new k();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Q f5315b;

    public j(int i4, Q q4) {
        this.f5314a = i4;
        this.f5315b = q4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.t(parcel, 1, this.f5314a);
        A1.c.C(parcel, 2, this.f5315b, i4, false);
        A1.c.b(parcel, iA);
    }
}
