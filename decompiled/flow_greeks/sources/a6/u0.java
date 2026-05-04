package a6;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.internal.fido.zzfv;
import com.google.android.gms.internal.fido.zzfx;
import com.google.android.gms.internal.fido.zzgj;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class u0 extends n5.a {
    public static final Parcelable.Creator<u0> CREATOR = new v0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f267b = "WebAuthn PRF\u0000".getBytes(StandardCharsets.UTF_8);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[][] f268a;

    public u0(byte[][] bArr) {
        com.google.android.gms.common.internal.s.a(bArr != null);
        com.google.android.gms.common.internal.s.a(1 == ((bArr.length & 1) ^ 1));
        int i10 = 0;
        while (i10 < bArr.length) {
            com.google.android.gms.common.internal.s.a(i10 == 0 || bArr[i10] != null);
            int i11 = i10 + 1;
            com.google.android.gms.common.internal.s.a(bArr[i11] != null);
            int length = bArr[i11].length;
            com.google.android.gms.common.internal.s.a(length == 32 || length == 64);
            i10 += 2;
        }
        this.f268a = bArr;
    }

    public static u0 R(JSONObject jSONObject, boolean z10) throws JSONException {
        ArrayList arrayList = new ArrayList();
        try {
            if (jSONObject.has("eval")) {
                arrayList.add(null);
                if (z10) {
                    arrayList.add(U(jSONObject.getJSONObject("eval")));
                } else {
                    arrayList.add(V(jSONObject.getJSONObject("eval")));
                }
            }
            if (jSONObject.has("evalByCredential")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("evalByCredential");
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    arrayList.add(t5.c.b(next));
                    if (z10) {
                        arrayList.add(U(jSONObject2.getJSONObject(next)));
                    } else {
                        arrayList.add(V(jSONObject2.getJSONObject(next)));
                    }
                }
            }
            return new u0((byte[][]) arrayList.toArray(new byte[0][]));
        } catch (IllegalArgumentException unused) {
            throw new JSONException("invalid base64url value");
        }
    }

    public static JSONObject S(byte[] bArr) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (bArr.length == 32) {
            jSONObject.put("first", t5.c.e(bArr));
            return jSONObject;
        }
        jSONObject.put("first", Base64.encodeToString(bArr, 0, 32, 11));
        jSONObject.put("second", Base64.encodeToString(bArr, 32, 32, 11));
        return jSONObject;
    }

    public static byte[] T(byte[] bArr) {
        zzfv zzfvVarZza = zzfx.zza().zza();
        zzfvVarZza.zza(f267b);
        zzfvVarZza.zza(bArr);
        return zzfvVarZza.zzc().zzd();
    }

    public static byte[] U(JSONObject jSONObject) throws JSONException {
        byte[] bArrB = t5.c.b(jSONObject.getString("first"));
        if (bArrB.length != 32) {
            throw new JSONException("hashed PRF value with wrong length");
        }
        if (!jSONObject.has("second")) {
            return bArrB;
        }
        byte[] bArrB2 = t5.c.b(jSONObject.getString("second"));
        if (bArrB2.length == 32) {
            return zzgj.zza(bArrB, bArrB2);
        }
        throw new JSONException("hashed PRF value with wrong length");
    }

    public static byte[] V(JSONObject jSONObject) {
        byte[] bArrT = T(t5.c.b(jSONObject.getString("first")));
        return !jSONObject.has("second") ? bArrT : zzgj.zza(bArrT, T(t5.c.b(jSONObject.getString("second"))));
    }

    public final boolean equals(Object obj) {
        if (obj instanceof u0) {
            return Arrays.deepEquals(this.f268a, ((u0) obj).f268a);
        }
        return false;
    }

    public final int hashCode() {
        int iC = 0;
        for (byte[] bArr : this.f268a) {
            if (bArr != null) {
                iC ^= com.google.android.gms.common.internal.q.c(bArr);
            }
        }
        return iC;
    }

    public final String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            int i10 = 0;
            JSONObject jSONObject2 = null;
            while (true) {
                byte[][] bArr = this.f268a;
                if (i10 >= bArr.length) {
                    return "PrfExtension{" + jSONObject.toString() + "}";
                }
                if (bArr[i10] == null) {
                    jSONObject.put("eval", S(bArr[i10 + 1]));
                } else {
                    if (jSONObject2 == null) {
                        jSONObject2 = new JSONObject();
                        jSONObject.put("evalByCredential", jSONObject2);
                    }
                    jSONObject2.put(t5.c.e(this.f268a[i10]), S(this.f268a[i10 + 1]));
                }
                i10 += 2;
            }
        } catch (JSONException e10) {
            return "PrfExtension{Exception:" + e10.getMessage() + "}";
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        byte[][] bArr = this.f268a;
        int iA = n5.c.a(parcel);
        n5.c.l(parcel, 1, bArr, false);
        n5.c.b(parcel, iA);
    }
}
