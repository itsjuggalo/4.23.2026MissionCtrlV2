package i2;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.internal.p002firebaseauthapi.zzaao;
import org.json.JSONException;
import org.json.JSONObject;
import t2.u0;

/* JADX INFO: loaded from: classes.dex */
public final class z extends t {
    public static final Parcelable.Creator<z> CREATOR = new com.google.android.gms.common.internal.Q(9);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f6822c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f6823d;

    public z(long j4, String str, String str2, String str3) {
        com.google.android.gms.common.internal.I.d(str);
        this.f6820a = str;
        this.f6821b = str2;
        this.f6822c = j4;
        com.google.android.gms.common.internal.I.d(str3);
        this.f6823d = str3;
    }

    public static z p(JSONObject jSONObject) {
        if (!jSONObject.has("enrollmentTimestamp")) {
            throw new IllegalArgumentException("An enrollment timestamp in seconds of UTC time since Unix epoch is required to build a PhoneMultiFactorInfo instance.");
        }
        return new z(jSONObject.optLong("enrollmentTimestamp"), jSONObject.optString("uid"), jSONObject.optString("displayName"), jSONObject.optString("phoneNumber"));
    }

    @Override // i2.t
    public final String b() {
        return this.f6820a;
    }

    @Override // i2.t
    public final String k() {
        return this.f6821b;
    }

    @Override // i2.t
    public final long m() {
        return this.f6822c;
    }

    @Override // i2.t
    public final String n() {
        return "phone";
    }

    @Override // i2.t
    public final JSONObject o() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("factorIdKey", "phone");
            jSONObject.putOpt("uid", this.f6820a);
            jSONObject.putOpt("displayName", this.f6821b);
            jSONObject.putOpt("enrollmentTimestamp", Long.valueOf(this.f6822c));
            jSONObject.putOpt("phoneNumber", this.f6823d);
            return jSONObject;
        } catch (JSONException e) {
            Log.d("PhoneMultiFactorInfo", "Failed to jsonify this object");
            throw new zzaao(e);
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iX = u0.X(20293, parcel);
        u0.T(parcel, 1, this.f6820a, false);
        u0.T(parcel, 2, this.f6821b, false);
        u0.b0(parcel, 3, 8);
        parcel.writeLong(this.f6822c);
        u0.T(parcel, 4, this.f6823d, false);
        u0.a0(iX, parcel);
    }
}
