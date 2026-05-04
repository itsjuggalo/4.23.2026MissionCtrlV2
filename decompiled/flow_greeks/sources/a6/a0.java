package a6;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.fido.zzgx;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a0 extends n5.a {
    public static final Parcelable.Creator<a0> CREATOR = new d1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zzgx f89a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f90b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f91c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f92d;

    public a0(zzgx zzgxVar, String str, String str2, String str3) {
        this.f89a = (zzgx) com.google.android.gms.common.internal.s.k(zzgxVar);
        this.f90b = (String) com.google.android.gms.common.internal.s.k(str);
        this.f91c = str2;
        this.f92d = (String) com.google.android.gms.common.internal.s.k(str3);
    }

    public String R() {
        return this.f91c;
    }

    public byte[] S() {
        return this.f89a.zzm();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a0)) {
            return false;
        }
        a0 a0Var = (a0) obj;
        return com.google.android.gms.common.internal.q.b(this.f89a, a0Var.f89a) && com.google.android.gms.common.internal.q.b(this.f90b, a0Var.f90b) && com.google.android.gms.common.internal.q.b(this.f91c, a0Var.f91c) && com.google.android.gms.common.internal.q.b(this.f92d, a0Var.f92d);
    }

    public String getName() {
        return this.f90b;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(this.f89a, this.f90b, this.f91c, this.f92d);
    }

    public final String toString() {
        return "PublicKeyCredentialUserEntity{\n id=" + t5.c.e(this.f89a.zzm()) + ", \n name='" + this.f90b + "', \n icon='" + this.f91c + "', \n displayName='" + this.f92d + "'}";
    }

    public String v() {
        return this.f92d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.k(parcel, 2, S(), false);
        n5.c.E(parcel, 3, getName(), false);
        n5.c.E(parcel, 4, R(), false);
        n5.c.E(parcel, 5, v(), false);
        n5.c.b(parcel, iA);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public a0(byte[] bArr, String str, String str2, String str3) {
        byte[] bArr2 = (byte[]) com.google.android.gms.common.internal.s.k(bArr);
        zzgx zzgxVar = zzgx.zzb;
        this(zzgx.zzl(bArr2, 0, bArr2.length), str, str2, str3);
    }
}
