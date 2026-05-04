package a6;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class m extends n {
    public static final Parcelable.Creator<m> CREATOR = new b2();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f195c;

    public m(x xVar, Uri uri, byte[] bArr) {
        this.f193a = (x) com.google.android.gms.common.internal.s.k(xVar);
        U(uri);
        this.f194b = uri;
        V(bArr);
        this.f195c = bArr;
    }

    private static Uri U(Uri uri) {
        com.google.android.gms.common.internal.s.k(uri);
        com.google.android.gms.common.internal.s.b(uri.getScheme() != null, "origin scheme must be non-empty");
        com.google.android.gms.common.internal.s.b(uri.getAuthority() != null, "origin authority must be non-empty");
        return uri;
    }

    private static byte[] V(byte[] bArr) {
        boolean z10 = true;
        if (bArr != null && bArr.length != 32) {
            z10 = false;
        }
        com.google.android.gms.common.internal.s.b(z10, "clientDataHash must be 32 bytes long");
        return bArr;
    }

    public byte[] R() {
        return this.f195c;
    }

    public Uri S() {
        return this.f194b;
    }

    public x T() {
        return this.f193a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return com.google.android.gms.common.internal.q.b(this.f193a, mVar.f193a) && com.google.android.gms.common.internal.q.b(this.f194b, mVar.f194b);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(this.f193a, this.f194b);
    }

    public final String toString() {
        byte[] bArr = this.f195c;
        Uri uri = this.f194b;
        return "BrowserPublicKeyCredentialRequestOptions{\n publicKeyCredentialRequestOptions=" + String.valueOf(this.f193a) + ", \n origin=" + String.valueOf(uri) + ", \n clientDataHash=" + t5.c.e(bArr) + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.C(parcel, 2, T(), i10, false);
        n5.c.C(parcel, 3, S(), i10, false);
        n5.c.k(parcel, 4, R(), false);
        n5.c.b(parcel, iA);
    }
}
