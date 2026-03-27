package d2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.internal.fido.zzam;
import com.google.android.gms.internal.fido.zzan;
import com.google.android.gms.internal.fido.zzch;
import java.util.Arrays;

/* JADX INFO: renamed from: d2.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1431g extends AbstractC1437j {
    public static final Parcelable.Creator<C1431g> CREATOR = new t0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f13235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f13236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f13237c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f13238d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f13239e;

    public C1431g(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        this.f13235a = (byte[]) AbstractC1207s.k(bArr);
        this.f13236b = (byte[]) AbstractC1207s.k(bArr2);
        this.f13237c = (byte[]) AbstractC1207s.k(bArr3);
        this.f13238d = (byte[]) AbstractC1207s.k(bArr4);
        this.f13239e = bArr5;
    }

    public byte[] A() {
        return this.f13237c;
    }

    public byte[] B() {
        return this.f13236b;
    }

    public byte[] C() {
        return this.f13235a;
    }

    public byte[] D() {
        return this.f13238d;
    }

    public byte[] E() {
        return this.f13239e;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1431g)) {
            return false;
        }
        C1431g c1431g = (C1431g) obj;
        return Arrays.equals(this.f13235a, c1431g.f13235a) && Arrays.equals(this.f13236b, c1431g.f13236b) && Arrays.equals(this.f13237c, c1431g.f13237c) && Arrays.equals(this.f13238d, c1431g.f13238d) && Arrays.equals(this.f13239e, c1431g.f13239e);
    }

    public int hashCode() {
        return AbstractC1206q.c(Integer.valueOf(Arrays.hashCode(this.f13235a)), Integer.valueOf(Arrays.hashCode(this.f13236b)), Integer.valueOf(Arrays.hashCode(this.f13237c)), Integer.valueOf(Arrays.hashCode(this.f13238d)), Integer.valueOf(Arrays.hashCode(this.f13239e)));
    }

    public String toString() {
        zzam zzamVarZza = zzan.zza(this);
        zzch zzchVarZzf = zzch.zzf();
        byte[] bArr = this.f13235a;
        zzamVarZza.zzb("keyHandle", zzchVarZzf.zzg(bArr, 0, bArr.length));
        zzch zzchVarZzf2 = zzch.zzf();
        byte[] bArr2 = this.f13236b;
        zzamVarZza.zzb("clientDataJSON", zzchVarZzf2.zzg(bArr2, 0, bArr2.length));
        zzch zzchVarZzf3 = zzch.zzf();
        byte[] bArr3 = this.f13237c;
        zzamVarZza.zzb("authenticatorData", zzchVarZzf3.zzg(bArr3, 0, bArr3.length));
        zzch zzchVarZzf4 = zzch.zzf();
        byte[] bArr4 = this.f13238d;
        zzamVarZza.zzb("signature", zzchVarZzf4.zzg(bArr4, 0, bArr4.length));
        byte[] bArr5 = this.f13239e;
        if (bArr5 != null) {
            zzamVarZza.zzb("userHandle", zzch.zzf().zzg(bArr5, 0, bArr5.length));
        }
        return zzamVarZza.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.k(parcel, 2, C(), false);
        Q1.c.k(parcel, 3, B(), false);
        Q1.c.k(parcel, 4, A(), false);
        Q1.c.k(parcel, 5, D(), false);
        Q1.c.k(parcel, 6, E(), false);
        Q1.c.b(parcel, iA);
    }
}
