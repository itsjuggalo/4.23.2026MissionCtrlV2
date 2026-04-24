package J1;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import t2.u0;

/* JADX INFO: renamed from: J1.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0038n extends AbstractC0040p {
    public static final Parcelable.Creator<C0038n> CREATOR = new Y(5);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0048y f746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f748c;

    public C0038n(C0048y c0048y, Uri uri, byte[] bArr) {
        com.google.android.gms.common.internal.I.g(c0048y);
        this.f746a = c0048y;
        com.google.android.gms.common.internal.I.g(uri);
        boolean z6 = true;
        com.google.android.gms.common.internal.I.a("origin scheme must be non-empty", uri.getScheme() != null);
        com.google.android.gms.common.internal.I.a("origin authority must be non-empty", uri.getAuthority() != null);
        this.f747b = uri;
        if (bArr != null && bArr.length != 32) {
            z6 = false;
        }
        com.google.android.gms.common.internal.I.a("clientDataHash must be 32 bytes long", z6);
        this.f748c = bArr;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C0038n)) {
            return false;
        }
        C0038n c0038n = (C0038n) obj;
        return com.google.android.gms.common.internal.I.j(this.f746a, c0038n.f746a) && com.google.android.gms.common.internal.I.j(this.f747b, c0038n.f747b);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f746a, this.f747b});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iX = u0.X(20293, parcel);
        u0.S(parcel, 2, this.f746a, i, false);
        u0.S(parcel, 3, this.f747b, i, false);
        u0.M(parcel, 4, this.f748c, false);
        u0.a0(iX, parcel);
    }
}
