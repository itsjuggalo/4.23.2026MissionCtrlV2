package a6;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.fido.zzbi;
import com.google.android.gms.internal.fido.zzbj;
import com.google.android.gms.internal.fido.zzgf;
import com.google.android.gms.internal.fido.zzgx;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class h extends j {
    public static final Parcelable.Creator<h> CREATOR = new x1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zzgx f173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zzgx f174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final zzgx f175c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String[] f176d;

    public h(byte[] bArr, byte[] bArr2, byte[] bArr3, String[] strArr) {
        byte[] bArr4 = (byte[]) com.google.android.gms.common.internal.s.k(bArr);
        zzgx zzgxVar = zzgx.zzb;
        zzgx zzgxVarZzl = zzgx.zzl(bArr4, 0, bArr4.length);
        byte[] bArr5 = (byte[]) com.google.android.gms.common.internal.s.k(bArr2);
        zzgx zzgxVarZzl2 = zzgx.zzl(bArr5, 0, bArr5.length);
        byte[] bArr6 = (byte[]) com.google.android.gms.common.internal.s.k(bArr3);
        zzgx zzgxVarZzl3 = zzgx.zzl(bArr6, 0, bArr6.length);
        this.f173a = (zzgx) com.google.android.gms.common.internal.s.k(zzgxVarZzl);
        this.f174b = (zzgx) com.google.android.gms.common.internal.s.k(zzgxVarZzl2);
        this.f175c = (zzgx) com.google.android.gms.common.internal.s.k(zzgxVarZzl3);
        this.f176d = (String[]) com.google.android.gms.common.internal.s.k(strArr);
    }

    public byte[] R() {
        return this.f175c.zzm();
    }

    public byte[] S() {
        return this.f174b.zzm();
    }

    public byte[] T() {
        return this.f173a.zzm();
    }

    public String[] U() {
        return this.f176d;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0125 A[Catch: JSONException -> 0x0019, zzho -> 0x018e, TRY_LEAVE, TryCatch #1 {zzho -> 0x018e, blocks: (B:33:0x00f4, B:39:0x0113, B:41:0x0125, B:46:0x0139, B:49:0x015b, B:51:0x0171, B:53:0x0177, B:56:0x0191, B:57:0x0196, B:58:0x0197, B:59:0x019c, B:64:0x01a7, B:66:0x01b7, B:68:0x01c5, B:69:0x01d8, B:70:0x01dd, B:71:0x01de, B:72:0x01e3, B:77:0x0202, B:78:0x0207), top: B:108:0x00f4, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0202 A[Catch: JSONException -> 0x0019, zzho -> 0x018e, TRY_ENTER, TryCatch #1 {zzho -> 0x018e, blocks: (B:33:0x00f4, B:39:0x0113, B:41:0x0125, B:46:0x0139, B:49:0x015b, B:51:0x0171, B:53:0x0177, B:56:0x0191, B:57:0x0196, B:58:0x0197, B:59:0x019c, B:64:0x01a7, B:66:0x01b7, B:68:0x01c5, B:69:0x01d8, B:70:0x01dd, B:71:0x01de, B:72:0x01e3, B:77:0x0202, B:78:0x0207), top: B:108:0x00f4, outer: #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final org.json.JSONObject V() {
        /*
            Method dump skipped, instruction units count: 600
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a6.h.V():org.json.JSONObject");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return com.google.android.gms.common.internal.q.b(this.f173a, hVar.f173a) && com.google.android.gms.common.internal.q.b(this.f174b, hVar.f174b) && com.google.android.gms.common.internal.q.b(this.f175c, hVar.f175c);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(Integer.valueOf(com.google.android.gms.common.internal.q.c(this.f173a)), Integer.valueOf(com.google.android.gms.common.internal.q.c(this.f174b)), Integer.valueOf(com.google.android.gms.common.internal.q.c(this.f175c)));
    }

    public String toString() {
        zzbi zzbiVarZza = zzbj.zza(this);
        zzgf zzgfVarZzf = zzgf.zzf();
        byte[] bArrT = T();
        zzbiVarZza.zzb("keyHandle", zzgfVarZzf.zzg(bArrT, 0, bArrT.length));
        zzgf zzgfVarZzf2 = zzgf.zzf();
        byte[] bArrS = S();
        zzbiVarZza.zzb("clientDataJSON", zzgfVarZzf2.zzg(bArrS, 0, bArrS.length));
        zzgf zzgfVarZzf3 = zzgf.zzf();
        byte[] bArrR = R();
        zzbiVarZza.zzb("attestationObject", zzgfVarZzf3.zzg(bArrR, 0, bArrR.length));
        zzbiVarZza.zzb("transports", Arrays.toString(this.f176d));
        return zzbiVarZza.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.k(parcel, 2, T(), false);
        n5.c.k(parcel, 3, S(), false);
        n5.c.k(parcel, 4, R(), false);
        n5.c.F(parcel, 5, U(), false);
        n5.c.b(parcel, iA);
    }
}
