package l2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Q;

/* JADX INFO: loaded from: classes.dex */
public final class j extends Q1.a {
    public static final Parcelable.Creator<j> CREATOR = new k();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Q f18303b;

    public j(int i7, Q q7) {
        this.f18302a = i7;
        this.f18303b = q7;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.t(parcel, 1, this.f18302a);
        Q1.c.C(parcel, 2, this.f18303b, i7, false);
        Q1.c.b(parcel, iA);
    }
}
