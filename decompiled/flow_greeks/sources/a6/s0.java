package a6;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.fido.zzgx;
import com.google.android.gms.internal.fido.zzhp;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class s0 extends n5.a {
    public static final Parcelable.Creator<s0> CREATOR = new t0();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final zzhp f224e = zzhp.zzg(1);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final zzhp f225f = zzhp.zzg(2);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final zzhp f226g = zzhp.zzg(3);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final zzhp f227h = zzhp.zzg(4);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zzgx f228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zzgx f229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final zzgx f230c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f231d;

    public s0(zzgx zzgxVar, zzgx zzgxVar2, zzgx zzgxVar3, int i10) {
        this.f228a = zzgxVar;
        this.f229b = zzgxVar2;
        this.f230c = zzgxVar3;
        this.f231d = i10;
    }

    public final byte[] R() {
        zzgx zzgxVar = this.f228a;
        if (zzgxVar == null) {
            return null;
        }
        return zzgxVar.zzm();
    }

    public final byte[] S() {
        zzgx zzgxVar = this.f230c;
        if (zzgxVar == null) {
            return null;
        }
        return zzgxVar.zzm();
    }

    public final byte[] T() {
        zzgx zzgxVar = this.f229b;
        if (zzgxVar == null) {
            return null;
        }
        return zzgxVar.zzm();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof s0)) {
            return false;
        }
        s0 s0Var = (s0) obj;
        return com.google.android.gms.common.internal.q.b(this.f228a, s0Var.f228a) && com.google.android.gms.common.internal.q.b(this.f229b, s0Var.f229b) && com.google.android.gms.common.internal.q.b(this.f230c, s0Var.f230c) && this.f231d == s0Var.f231d;
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.q.c(this.f228a, this.f229b, this.f230c, Integer.valueOf(this.f231d));
    }

    public final String toString() {
        return "HmacSecretExtension{coseKeyAgreement=" + t5.c.e(R()) + ", saltEnc=" + t5.c.e(T()) + ", saltAuth=" + t5.c.e(S()) + ", getPinUvAuthProtocol=" + this.f231d + "}";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.k(parcel, 1, R(), false);
        n5.c.k(parcel, 2, T(), false);
        n5.c.k(parcel, 3, S(), false);
        n5.c.t(parcel, 4, this.f231d);
        n5.c.b(parcel, iA);
    }
}
