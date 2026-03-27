package N1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.internal.fido.zzam;
import com.google.android.gms.internal.fido.zzan;
import com.google.android.gms.internal.fido.zzch;
import java.util.Arrays;

/* JADX INFO: renamed from: N1.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0468g extends AbstractC0474j {
    public static final Parcelable.Creator<C0468g> CREATOR = new t0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f2779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f2780b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f2781c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f2782d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f2783e;

    public C0468g(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        this.f2779a = (byte[]) AbstractC0940s.k(bArr);
        this.f2780b = (byte[]) AbstractC0940s.k(bArr2);
        this.f2781c = (byte[]) AbstractC0940s.k(bArr3);
        this.f2782d = (byte[]) AbstractC0940s.k(bArr4);
        this.f2783e = bArr5;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0468g)) {
            return false;
        }
        C0468g c0468g = (C0468g) obj;
        return Arrays.equals(this.f2779a, c0468g.f2779a) && Arrays.equals(this.f2780b, c0468g.f2780b) && Arrays.equals(this.f2781c, c0468g.f2781c) && Arrays.equals(this.f2782d, c0468g.f2782d) && Arrays.equals(this.f2783e, c0468g.f2783e);
    }

    public int hashCode() {
        return AbstractC0939q.c(Integer.valueOf(Arrays.hashCode(this.f2779a)), Integer.valueOf(Arrays.hashCode(this.f2780b)), Integer.valueOf(Arrays.hashCode(this.f2781c)), Integer.valueOf(Arrays.hashCode(this.f2782d)), Integer.valueOf(Arrays.hashCode(this.f2783e)));
    }

    public byte[] i() {
        return this.f2781c;
    }

    public byte[] k() {
        return this.f2780b;
    }

    public byte[] l() {
        return this.f2779a;
    }

    public byte[] m() {
        return this.f2782d;
    }

    public byte[] n() {
        return this.f2783e;
    }

    public String toString() {
        zzam zzamVarZza = zzan.zza(this);
        zzch zzchVarZzf = zzch.zzf();
        byte[] bArr = this.f2779a;
        zzamVarZza.zzb("keyHandle", zzchVarZzf.zzg(bArr, 0, bArr.length));
        zzch zzchVarZzf2 = zzch.zzf();
        byte[] bArr2 = this.f2780b;
        zzamVarZza.zzb("clientDataJSON", zzchVarZzf2.zzg(bArr2, 0, bArr2.length));
        zzch zzchVarZzf3 = zzch.zzf();
        byte[] bArr3 = this.f2781c;
        zzamVarZza.zzb("authenticatorData", zzchVarZzf3.zzg(bArr3, 0, bArr3.length));
        zzch zzchVarZzf4 = zzch.zzf();
        byte[] bArr4 = this.f2782d;
        zzamVarZza.zzb("signature", zzchVarZzf4.zzg(bArr4, 0, bArr4.length));
        byte[] bArr5 = this.f2783e;
        if (bArr5 != null) {
            zzamVarZza.zzb("userHandle", zzch.zzf().zzg(bArr5, 0, bArr5.length));
        }
        return zzamVarZza.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.k(parcel, 2, l(), false);
        A1.c.k(parcel, 3, k(), false);
        A1.c.k(parcel, 4, i(), false);
        A1.c.k(parcel, 5, m(), false);
        A1.c.k(parcel, 6, n(), false);
        A1.c.b(parcel, iA);
    }
}
