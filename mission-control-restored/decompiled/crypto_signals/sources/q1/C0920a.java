package q1;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import o1.r;
import t2.u0;
import v1.AbstractC1255a;

/* JADX INFO: renamed from: q1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0920a extends AbstractC1255a {
    public static final Parcelable.Creator<C0920a> CREATOR = new r(16);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f9148c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f9149d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Bundle f9150f;

    public C0920a(int i, String str, int i6, long j4, byte[] bArr, Bundle bundle) {
        this.e = i;
        this.f9146a = str;
        this.f9147b = i6;
        this.f9148c = j4;
        this.f9149d = bArr;
        this.f9150f = bundle;
    }

    public final String toString() {
        return "ProxyRequest[ url: " + this.f9146a + ", method: " + this.f9147b + " ]";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iX = u0.X(20293, parcel);
        u0.T(parcel, 1, this.f9146a, false);
        u0.b0(parcel, 2, 4);
        parcel.writeInt(this.f9147b);
        u0.b0(parcel, 3, 8);
        parcel.writeLong(this.f9148c);
        u0.M(parcel, 4, this.f9149d, false);
        u0.L(parcel, 5, this.f9150f, false);
        u0.b0(parcel, 1000, 4);
        parcel.writeInt(this.e);
        u0.a0(iX, parcel);
    }
}
