package N1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.internal.fido.zzam;
import com.google.android.gms.internal.fido.zzan;
import com.google.android.gms.internal.fido.zzch;
import java.util.Arrays;

/* JADX INFO: renamed from: N1.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0470h extends AbstractC0474j {
    public static final Parcelable.Creator<C0470h> CREATOR = new u0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f2784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f2785b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f2786c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String[] f2787d;

    public C0470h(byte[] bArr, byte[] bArr2, byte[] bArr3, String[] strArr) {
        this.f2784a = (byte[]) AbstractC0940s.k(bArr);
        this.f2785b = (byte[]) AbstractC0940s.k(bArr2);
        this.f2786c = (byte[]) AbstractC0940s.k(bArr3);
        this.f2787d = (String[]) AbstractC0940s.k(strArr);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0470h)) {
            return false;
        }
        C0470h c0470h = (C0470h) obj;
        return Arrays.equals(this.f2784a, c0470h.f2784a) && Arrays.equals(this.f2785b, c0470h.f2785b) && Arrays.equals(this.f2786c, c0470h.f2786c);
    }

    public int hashCode() {
        return AbstractC0939q.c(Integer.valueOf(Arrays.hashCode(this.f2784a)), Integer.valueOf(Arrays.hashCode(this.f2785b)), Integer.valueOf(Arrays.hashCode(this.f2786c)));
    }

    public byte[] i() {
        return this.f2786c;
    }

    public byte[] k() {
        return this.f2785b;
    }

    public byte[] l() {
        return this.f2784a;
    }

    public String[] m() {
        return this.f2787d;
    }

    public String toString() {
        zzam zzamVarZza = zzan.zza(this);
        zzch zzchVarZzf = zzch.zzf();
        byte[] bArr = this.f2784a;
        zzamVarZza.zzb("keyHandle", zzchVarZzf.zzg(bArr, 0, bArr.length));
        zzch zzchVarZzf2 = zzch.zzf();
        byte[] bArr2 = this.f2785b;
        zzamVarZza.zzb("clientDataJSON", zzchVarZzf2.zzg(bArr2, 0, bArr2.length));
        zzch zzchVarZzf3 = zzch.zzf();
        byte[] bArr3 = this.f2786c;
        zzamVarZza.zzb("attestationObject", zzchVarZzf3.zzg(bArr3, 0, bArr3.length));
        zzamVarZza.zzb("transports", Arrays.toString(this.f2787d));
        return zzamVarZza.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.k(parcel, 2, l(), false);
        A1.c.k(parcel, 3, k(), false);
        A1.c.k(parcel, 4, i(), false);
        A1.c.F(parcel, 5, m(), false);
        A1.c.b(parcel, iA);
    }
}
