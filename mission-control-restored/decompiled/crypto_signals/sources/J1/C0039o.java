package J1;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import t2.u0;

/* JADX INFO: renamed from: J1.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0039o extends AbstractC0040p {
    public static final Parcelable.Creator<C0039o> CREATOR = new Y(6);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final B f749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f751c;

    public C0039o(B b3, Uri uri, byte[] bArr) {
        com.google.android.gms.common.internal.I.g(b3);
        this.f749a = b3;
        com.google.android.gms.common.internal.I.g(uri);
        boolean z6 = true;
        com.google.android.gms.common.internal.I.a("origin scheme must be non-empty", uri.getScheme() != null);
        com.google.android.gms.common.internal.I.a("origin authority must be non-empty", uri.getAuthority() != null);
        this.f750b = uri;
        if (bArr != null && bArr.length != 32) {
            z6 = false;
        }
        com.google.android.gms.common.internal.I.a("clientDataHash must be 32 bytes long", z6);
        this.f751c = bArr;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C0039o)) {
            return false;
        }
        C0039o c0039o = (C0039o) obj;
        return com.google.android.gms.common.internal.I.j(this.f749a, c0039o.f749a) && com.google.android.gms.common.internal.I.j(this.f750b, c0039o.f750b);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f749a, this.f750b});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iX = u0.X(20293, parcel);
        u0.S(parcel, 2, this.f749a, i, false);
        u0.S(parcel, 3, this.f750b, i, false);
        u0.M(parcel, 4, this.f751c, false);
        u0.a0(iX, parcel);
    }
}
