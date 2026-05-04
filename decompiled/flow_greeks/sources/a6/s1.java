package a6;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.fido.zzgx;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class s1 extends n5.a {
    public static final Parcelable.Creator<s1> CREATOR = new t1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zzgx f232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zzgx f233b;

    public s1(zzgx zzgxVar, zzgx zzgxVar2) {
        this.f232a = zzgxVar;
        this.f233b = zzgxVar2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof s1)) {
            return false;
        }
        s1 s1Var = (s1) obj;
        return com.google.android.gms.common.internal.q.b(this.f232a, s1Var.f232a) && com.google.android.gms.common.internal.q.b(this.f233b, s1Var.f233b);
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.q.c(this.f232a, this.f233b);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        zzgx zzgxVar = this.f232a;
        int iA = n5.c.a(parcel);
        n5.c.k(parcel, 1, zzgxVar == null ? null : zzgxVar.zzm(), false);
        zzgx zzgxVar2 = this.f233b;
        n5.c.k(parcel, 2, zzgxVar2 != null ? zzgxVar2.zzm() : null, false);
        n5.c.b(parcel, iA);
    }
}
