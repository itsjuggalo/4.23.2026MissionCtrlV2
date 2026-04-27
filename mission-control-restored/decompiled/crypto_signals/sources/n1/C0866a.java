package n1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Q;
import t2.u0;
import v1.AbstractC1255a;

/* JADX INFO: renamed from: n1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0866a extends AbstractC1255a {
    public static final Parcelable.Creator<C0866a> CREATOR = new Q(26);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f8524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f8525c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f8526d;

    public C0866a(int i, boolean z6, long j4, boolean z7) {
        this.f8523a = i;
        this.f8524b = z6;
        this.f8525c = j4;
        this.f8526d = z7;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iX = u0.X(20293, parcel);
        u0.b0(parcel, 1, 4);
        parcel.writeInt(this.f8523a);
        u0.b0(parcel, 2, 4);
        parcel.writeInt(this.f8524b ? 1 : 0);
        u0.b0(parcel, 3, 8);
        parcel.writeLong(this.f8525c);
        u0.b0(parcel, 4, 4);
        parcel.writeInt(this.f8526d ? 1 : 0);
        u0.a0(iX, parcel);
    }
}
