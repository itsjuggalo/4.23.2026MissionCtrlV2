package Z2;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.internal.p002firebaseauthapi.zzaag;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class S extends J {
    public static final Parcelable.Creator<S> CREATOR = new s0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5740b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f5741c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f5742d;

    public S(String str, String str2, long j7, String str3) {
        this.f5739a = AbstractC1207s.e(str);
        this.f5740b = str2;
        this.f5741c = j7;
        this.f5742d = AbstractC1207s.e(str3);
    }

    public static S D(JSONObject jSONObject) {
        if (jSONObject.has("enrollmentTimestamp")) {
            return new S(jSONObject.optString("uid"), jSONObject.optString("displayName"), jSONObject.optLong("enrollmentTimestamp"), jSONObject.optString("phoneNumber"));
        }
        throw new IllegalArgumentException("An enrollment timestamp in seconds of UTC time since Unix epoch is required to build a PhoneMultiFactorInfo instance.");
    }

    @Override // Z2.J
    public long A() {
        return this.f5741c;
    }

    @Override // Z2.J
    public String B() {
        return "phone";
    }

    @Override // Z2.J
    public JSONObject C() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("factorIdKey", "phone");
            jSONObject.putOpt("uid", this.f5739a);
            jSONObject.putOpt("displayName", this.f5740b);
            jSONObject.putOpt("enrollmentTimestamp", Long.valueOf(this.f5741c));
            jSONObject.putOpt("phoneNumber", this.f5742d);
            return jSONObject;
        } catch (JSONException e7) {
            Log.d("PhoneMultiFactorInfo", "Failed to jsonify this object");
            throw new zzaag(e7);
        }
    }

    @Override // Z2.J
    public String a() {
        return this.f5739a;
    }

    public String k() {
        return this.f5742d;
    }

    @Override // Z2.J
    public String p() {
        return this.f5740b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.E(parcel, 1, a(), false);
        Q1.c.E(parcel, 2, p(), false);
        Q1.c.x(parcel, 3, A());
        Q1.c.E(parcel, 4, k(), false);
        Q1.c.b(parcel, iA);
    }
}
