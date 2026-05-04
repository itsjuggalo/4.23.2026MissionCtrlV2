package a6;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.fido.zzbi;
import com.google.android.gms.internal.fido.zzbj;
import com.google.android.gms.internal.fido.zzgf;
import com.google.android.gms.internal.fido.zzgx;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class g extends j {
    public static final Parcelable.Creator<g> CREATOR = new w1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zzgx f163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zzgx f164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final zzgx f165c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final zzgx f166d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final zzgx f167e;

    public g(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        byte[] bArr6 = (byte[]) com.google.android.gms.common.internal.s.k(bArr);
        zzgx zzgxVar = zzgx.zzb;
        zzgx zzgxVarZzl = zzgx.zzl(bArr6, 0, bArr6.length);
        byte[] bArr7 = (byte[]) com.google.android.gms.common.internal.s.k(bArr2);
        zzgx zzgxVarZzl2 = zzgx.zzl(bArr7, 0, bArr7.length);
        byte[] bArr8 = (byte[]) com.google.android.gms.common.internal.s.k(bArr3);
        zzgx zzgxVarZzl3 = zzgx.zzl(bArr8, 0, bArr8.length);
        byte[] bArr9 = (byte[]) com.google.android.gms.common.internal.s.k(bArr4);
        zzgx zzgxVarZzl4 = zzgx.zzl(bArr9, 0, bArr9.length);
        zzgx zzgxVarZzl5 = bArr5 == null ? null : zzgx.zzl(bArr5, 0, bArr5.length);
        this.f163a = (zzgx) com.google.android.gms.common.internal.s.k(zzgxVarZzl);
        this.f164b = (zzgx) com.google.android.gms.common.internal.s.k(zzgxVarZzl2);
        this.f165c = (zzgx) com.google.android.gms.common.internal.s.k(zzgxVarZzl3);
        this.f166d = (zzgx) com.google.android.gms.common.internal.s.k(zzgxVarZzl4);
        this.f167e = zzgxVarZzl5;
    }

    public byte[] R() {
        return this.f165c.zzm();
    }

    public byte[] S() {
        return this.f164b.zzm();
    }

    public byte[] T() {
        return this.f163a.zzm();
    }

    public byte[] U() {
        return this.f166d.zzm();
    }

    public byte[] V() {
        zzgx zzgxVar = this.f167e;
        if (zzgxVar == null) {
            return null;
        }
        return zzgxVar.zzm();
    }

    public final JSONObject W() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("clientDataJSON", t5.c.e(S()));
            jSONObject.put("authenticatorData", t5.c.e(R()));
            jSONObject.put("signature", t5.c.e(U()));
            if (this.f167e == null) {
                return jSONObject;
            }
            jSONObject.put("userHandle", t5.c.e(V()));
            return jSONObject;
        } catch (JSONException e10) {
            throw new RuntimeException("Error encoding AuthenticatorAssertionResponse to JSON object", e10);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return com.google.android.gms.common.internal.q.b(this.f163a, gVar.f163a) && com.google.android.gms.common.internal.q.b(this.f164b, gVar.f164b) && com.google.android.gms.common.internal.q.b(this.f165c, gVar.f165c) && com.google.android.gms.common.internal.q.b(this.f166d, gVar.f166d) && com.google.android.gms.common.internal.q.b(this.f167e, gVar.f167e);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(Integer.valueOf(com.google.android.gms.common.internal.q.c(this.f163a)), Integer.valueOf(com.google.android.gms.common.internal.q.c(this.f164b)), Integer.valueOf(com.google.android.gms.common.internal.q.c(this.f165c)), Integer.valueOf(com.google.android.gms.common.internal.q.c(this.f166d)), Integer.valueOf(com.google.android.gms.common.internal.q.c(this.f167e)));
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
        zzbiVarZza.zzb("authenticatorData", zzgfVarZzf3.zzg(bArrR, 0, bArrR.length));
        zzgf zzgfVarZzf4 = zzgf.zzf();
        byte[] bArrU = U();
        zzbiVarZza.zzb("signature", zzgfVarZzf4.zzg(bArrU, 0, bArrU.length));
        byte[] bArrV = V();
        if (bArrV != null) {
            zzbiVarZza.zzb("userHandle", zzgf.zzf().zzg(bArrV, 0, bArrV.length));
        }
        return zzbiVarZza.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.k(parcel, 2, T(), false);
        n5.c.k(parcel, 3, S(), false);
        n5.c.k(parcel, 4, R(), false);
        n5.c.k(parcel, 5, U(), false);
        n5.c.k(parcel, 6, V(), false);
        n5.c.b(parcel, iA);
    }
}
