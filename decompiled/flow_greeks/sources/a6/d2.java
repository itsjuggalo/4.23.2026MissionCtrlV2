package a6;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.fido.zzgx;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class d2 extends n5.a {
    public static final Parcelable.Creator<d2> CREATOR = new e2();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zzgx f142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final zzgx f143c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final zzgx f144d;

    public d2(long j10, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArr4 = (byte[]) com.google.android.gms.common.internal.s.k(bArr);
        zzgx zzgxVar = zzgx.zzb;
        zzgx zzgxVarZzl = zzgx.zzl(bArr4, 0, bArr4.length);
        byte[] bArr5 = (byte[]) com.google.android.gms.common.internal.s.k(bArr2);
        zzgx zzgxVarZzl2 = zzgx.zzl(bArr5, 0, bArr5.length);
        byte[] bArr6 = (byte[]) com.google.android.gms.common.internal.s.k(bArr3);
        zzgx zzgxVarZzl3 = zzgx.zzl(bArr6, 0, bArr6.length);
        this.f141a = j10;
        this.f142b = (zzgx) com.google.android.gms.common.internal.s.k(zzgxVarZzl);
        this.f143c = (zzgx) com.google.android.gms.common.internal.s.k(zzgxVarZzl2);
        this.f144d = (zzgx) com.google.android.gms.common.internal.s.k(zzgxVarZzl3);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof d2)) {
            return false;
        }
        d2 d2Var = (d2) obj;
        return this.f141a == d2Var.f141a && com.google.android.gms.common.internal.q.b(this.f142b, d2Var.f142b) && com.google.android.gms.common.internal.q.b(this.f143c, d2Var.f143c) && com.google.android.gms.common.internal.q.b(this.f144d, d2Var.f144d);
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.q.c(Long.valueOf(this.f141a), this.f142b, this.f143c, this.f144d);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        long j10 = this.f141a;
        int iA = n5.c.a(parcel);
        n5.c.x(parcel, 1, j10);
        n5.c.k(parcel, 2, this.f142b.zzm(), false);
        n5.c.k(parcel, 3, this.f143c.zzm(), false);
        n5.c.k(parcel, 4, this.f144d.zzm(), false);
        n5.c.b(parcel, iA);
    }
}
