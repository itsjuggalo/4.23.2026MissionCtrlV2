package m7;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.internal.p002firebaseauthapi.zzaao;
import com.google.android.gms.internal.p002firebaseauthapi.zzaiz;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class x0 extends j0 {
    public static final Parcelable.Creator<x0> CREATOR = new u1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f16069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f16070c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final zzaiz f16071d;

    public x0(String str, String str2, long j10, zzaiz zzaizVar) {
        this.f16068a = com.google.android.gms.common.internal.s.e(str);
        this.f16069b = str2;
        this.f16070c = j10;
        this.f16071d = (zzaiz) com.google.android.gms.common.internal.s.l(zzaizVar, "totpInfo cannot be null.");
    }

    public static x0 U(JSONObject jSONObject) {
        if (!jSONObject.has("enrollmentTimestamp")) {
            throw new IllegalArgumentException("An enrollment timestamp in seconds of UTC time since Unix epoch is required to build a TotpMultiFactorInfo instance.");
        }
        long jOptLong = jSONObject.optLong("enrollmentTimestamp");
        if (jSONObject.opt("totpInfo") == null) {
            throw new IllegalArgumentException("A totpInfo is required to build a TotpMultiFactorInfo instance.");
        }
        return new x0(jSONObject.optString("uid"), jSONObject.optString("displayName"), jOptLong, new zzaiz());
    }

    @Override // m7.j0
    public long R() {
        return this.f16070c;
    }

    @Override // m7.j0
    public String S() {
        return "totp";
    }

    @Override // m7.j0
    public JSONObject T() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("factorIdKey", "totp");
            jSONObject.putOpt("uid", this.f16068a);
            jSONObject.putOpt("displayName", this.f16069b);
            jSONObject.putOpt("enrollmentTimestamp", Long.valueOf(this.f16070c));
            jSONObject.putOpt("totpInfo", this.f16071d);
            return jSONObject;
        } catch (JSONException e10) {
            Log.d("TotpMultiFactorInfo", "Failed to jsonify this object");
            throw new zzaao(e10);
        }
    }

    @Override // m7.j0
    public String a() {
        return this.f16068a;
    }

    @Override // m7.j0
    public String v() {
        return this.f16069b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.E(parcel, 1, a(), false);
        n5.c.E(parcel, 2, v(), false);
        n5.c.x(parcel, 3, R());
        n5.c.C(parcel, 4, this.f16071d, i10, false);
        n5.c.b(parcel, iA);
    }
}
