package V1;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public final class b extends A1.a implements com.google.android.gms.common.api.k {
    public static final Parcelable.Creator<b> CREATOR = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5310b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Intent f5311c;

    public b(int i4, int i5, Intent intent) {
        this.f5309a = i4;
        this.f5310b = i5;
        this.f5311c = intent;
    }

    @Override // com.google.android.gms.common.api.k
    public final Status getStatus() {
        return this.f5310b == 0 ? Status.f9653f : Status.f9657j;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int i5 = this.f5309a;
        int iA = A1.c.a(parcel);
        A1.c.t(parcel, 1, i5);
        A1.c.t(parcel, 2, this.f5310b);
        A1.c.C(parcel, 3, this.f5311c, i4, false);
        A1.c.b(parcel, iA);
    }
}
