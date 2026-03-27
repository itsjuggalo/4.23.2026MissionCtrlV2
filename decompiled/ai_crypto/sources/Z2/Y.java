package Z2;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.internal.p002firebaseauthapi.zzaag;
import com.google.android.gms.internal.p002firebaseauthapi.zzair;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class Y extends J {
    public static final Parcelable.Creator<Y> CREATOR = new u0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f5749c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final zzair f5750d;

    public Y(String str, String str2, long j7, zzair zzairVar) {
        this.f5747a = AbstractC1207s.e(str);
        this.f5748b = str2;
        this.f5749c = j7;
        this.f5750d = (zzair) AbstractC1207s.l(zzairVar, "totpInfo cannot be null.");
    }

    public static Y D(JSONObject jSONObject) {
        if (!jSONObject.has("enrollmentTimestamp")) {
            throw new IllegalArgumentException("An enrollment timestamp in seconds of UTC time since Unix epoch is required to build a TotpMultiFactorInfo instance.");
        }
        long jOptLong = jSONObject.optLong("enrollmentTimestamp");
        if (jSONObject.opt("totpInfo") == null) {
            throw new IllegalArgumentException("A totpInfo is required to build a TotpMultiFactorInfo instance.");
        }
        return new Y(jSONObject.optString("uid"), jSONObject.optString("displayName"), jOptLong, new zzair());
    }

    @Override // Z2.J
    public long A() {
        return this.f5749c;
    }

    @Override // Z2.J
    public String B() {
        return "totp";
    }

    @Override // Z2.J
    public JSONObject C() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("factorIdKey", "totp");
            jSONObject.putOpt("uid", this.f5747a);
            jSONObject.putOpt("displayName", this.f5748b);
            jSONObject.putOpt("enrollmentTimestamp", Long.valueOf(this.f5749c));
            jSONObject.putOpt("totpInfo", this.f5750d);
            return jSONObject;
        } catch (JSONException e7) {
            Log.d("TotpMultiFactorInfo", "Failed to jsonify this object");
            throw new zzaag(e7);
        }
    }

    @Override // Z2.J
    public String a() {
        return this.f5747a;
    }

    @Override // Z2.J
    public String p() {
        return this.f5748b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.E(parcel, 1, a(), false);
        Q1.c.E(parcel, 2, p(), false);
        Q1.c.x(parcel, 3, A());
        Q1.c.C(parcel, 4, this.f5750d, i7, false);
        Q1.c.b(parcel, iA);
    }
}
