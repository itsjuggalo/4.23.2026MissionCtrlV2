package N1;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import v1.AbstractC1255a;

/* JADX INFO: renamed from: N1.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0099i extends AbstractC1255a {
    public static final Parcelable.Creator<C0099i> CREATOR = new J1.Y(23);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f1652a;

    public C0099i(Bundle bundle) {
        this.f1652a = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iX = t2.u0.X(20293, parcel);
        t2.u0.L(parcel, 1, this.f1652a, false);
        t2.u0.a0(iX, parcel);
    }
}
