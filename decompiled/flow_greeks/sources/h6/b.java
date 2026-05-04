package h6;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends n5.a implements com.google.android.gms.common.api.k {
    public static final Parcelable.Creator<b> CREATOR = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11031b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Intent f11032c;

    public b(int i10, int i11, Intent intent) {
        this.f11030a = i10;
        this.f11031b = i11;
        this.f11032c = intent;
    }

    @Override // com.google.android.gms.common.api.k
    public final Status getStatus() {
        return this.f11031b == 0 ? Status.f5455f : Status.f5459j;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int i11 = this.f11030a;
        int iA = n5.c.a(parcel);
        n5.c.t(parcel, 1, i11);
        n5.c.t(parcel, 2, this.f11031b);
        n5.c.C(parcel, 3, this.f11032c, i10, false);
        n5.c.b(parcel, iA);
    }
}
