package m7;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.internal.p002firebaseauthapi.zzaao;
import io.flutter.plugins.firebase.auth.Constants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class r0 extends j0 {
    public static final Parcelable.Creator<r0> CREATOR = new s1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f16058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f16059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f16060d;

    public r0(String str, String str2, long j10, String str3) {
        this.f16057a = com.google.android.gms.common.internal.s.e(str);
        this.f16058b = str2;
        this.f16059c = j10;
        this.f16060d = com.google.android.gms.common.internal.s.e(str3);
    }

    public static r0 U(JSONObject jSONObject) {
        if (jSONObject.has("enrollmentTimestamp")) {
            return new r0(jSONObject.optString("uid"), jSONObject.optString("displayName"), jSONObject.optLong("enrollmentTimestamp"), jSONObject.optString("phoneNumber"));
        }
        throw new IllegalArgumentException("An enrollment timestamp in seconds of UTC time since Unix epoch is required to build a PhoneMultiFactorInfo instance.");
    }

    @Override // m7.j0
    public long R() {
        return this.f16059c;
    }

    @Override // m7.j0
    public String S() {
        return Constants.SIGN_IN_METHOD_PHONE;
    }

    @Override // m7.j0
    public JSONObject T() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("factorIdKey", Constants.SIGN_IN_METHOD_PHONE);
            jSONObject.putOpt("uid", this.f16057a);
            jSONObject.putOpt("displayName", this.f16058b);
            jSONObject.putOpt("enrollmentTimestamp", Long.valueOf(this.f16059c));
            jSONObject.putOpt("phoneNumber", this.f16060d);
            return jSONObject;
        } catch (JSONException e10) {
            Log.d("PhoneMultiFactorInfo", "Failed to jsonify this object");
            throw new zzaao(e10);
        }
    }

    @Override // m7.j0
    public String a() {
        return this.f16057a;
    }

    public String p() {
        return this.f16060d;
    }

    @Override // m7.j0
    public String v() {
        return this.f16058b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.E(parcel, 1, a(), false);
        n5.c.E(parcel, 2, v(), false);
        n5.c.x(parcel, 3, R());
        n5.c.E(parcel, 4, p(), false);
        n5.c.b(parcel, iA);
    }
}
