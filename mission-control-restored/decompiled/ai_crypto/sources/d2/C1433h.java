package d2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.internal.fido.zzam;
import com.google.android.gms.internal.fido.zzan;
import com.google.android.gms.internal.fido.zzch;
import java.util.Arrays;

/* JADX INFO: renamed from: d2.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1433h extends AbstractC1437j {
    public static final Parcelable.Creator<C1433h> CREATOR = new u0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f13240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f13241b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f13242c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String[] f13243d;

    public C1433h(byte[] bArr, byte[] bArr2, byte[] bArr3, String[] strArr) {
        this.f13240a = (byte[]) AbstractC1207s.k(bArr);
        this.f13241b = (byte[]) AbstractC1207s.k(bArr2);
        this.f13242c = (byte[]) AbstractC1207s.k(bArr3);
        this.f13243d = (String[]) AbstractC1207s.k(strArr);
    }

    public byte[] A() {
        return this.f13242c;
    }

    public byte[] B() {
        return this.f13241b;
    }

    public byte[] C() {
        return this.f13240a;
    }

    public String[] D() {
        return this.f13243d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1433h)) {
            return false;
        }
        C1433h c1433h = (C1433h) obj;
        return Arrays.equals(this.f13240a, c1433h.f13240a) && Arrays.equals(this.f13241b, c1433h.f13241b) && Arrays.equals(this.f13242c, c1433h.f13242c);
    }

    public int hashCode() {
        return AbstractC1206q.c(Integer.valueOf(Arrays.hashCode(this.f13240a)), Integer.valueOf(Arrays.hashCode(this.f13241b)), Integer.valueOf(Arrays.hashCode(this.f13242c)));
    }

    public String toString() {
        zzam zzamVarZza = zzan.zza(this);
        zzch zzchVarZzf = zzch.zzf();
        byte[] bArr = this.f13240a;
        zzamVarZza.zzb("keyHandle", zzchVarZzf.zzg(bArr, 0, bArr.length));
        zzch zzchVarZzf2 = zzch.zzf();
        byte[] bArr2 = this.f13241b;
        zzamVarZza.zzb("clientDataJSON", zzchVarZzf2.zzg(bArr2, 0, bArr2.length));
        zzch zzchVarZzf3 = zzch.zzf();
        byte[] bArr3 = this.f13242c;
        zzamVarZza.zzb("attestationObject", zzchVarZzf3.zzg(bArr3, 0, bArr3.length));
        zzamVarZza.zzb("transports", Arrays.toString(this.f13243d));
        return zzamVarZza.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.k(parcel, 2, C(), false);
        Q1.c.k(parcel, 3, B(), false);
        Q1.c.k(parcel, 4, A(), false);
        Q1.c.F(parcel, 5, D(), false);
        Q1.c.b(parcel, iA);
    }
}
