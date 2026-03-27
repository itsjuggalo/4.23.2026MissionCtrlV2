package q1;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import o1.r;
import t2.u0;
import v1.AbstractC1255a;

/* JADX INFO: renamed from: q1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0921b extends AbstractC1255a {
    public static final Parcelable.Creator<C0921b> CREATOR = new r(17);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PendingIntent f9152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9153c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f9154d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Bundle f9155f;

    public C0921b(int i, int i6, PendingIntent pendingIntent, int i7, Bundle bundle, byte[] bArr) {
        this.e = i;
        this.f9151a = i6;
        this.f9153c = i7;
        this.f9155f = bundle;
        this.f9154d = bArr;
        this.f9152b = pendingIntent;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iX = u0.X(20293, parcel);
        u0.b0(parcel, 1, 4);
        parcel.writeInt(this.f9151a);
        u0.S(parcel, 2, this.f9152b, i, false);
        u0.b0(parcel, 3, 4);
        parcel.writeInt(this.f9153c);
        u0.L(parcel, 4, this.f9155f, false);
        u0.M(parcel, 5, this.f9154d, false);
        u0.b0(parcel, 1000, 4);
        parcel.writeInt(this.e);
        u0.a0(iX, parcel);
    }
}
