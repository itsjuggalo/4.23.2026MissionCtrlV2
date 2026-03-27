package Z2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzaj;
import com.google.android.gms.internal.p002firebaseauthapi.zzam;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class n0 extends Q1.a {
    public static final Parcelable.Creator<n0> CREATOR = new p0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f5808c;

    public n0(String str, String str2, String str3) {
        this.f5806a = str;
        this.f5807b = str2;
        this.f5808c = str3;
    }

    public static final n0 A(JSONObject jSONObject) {
        return new n0(jSONObject.getString("credentialId"), jSONObject.getString("name"), jSONObject.getString("displayName"));
    }

    public static zzaj B(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return zzaj.zza(new ArrayList());
        }
        zzam zzamVarZzg = zzaj.zzg();
        for (int i7 = 0; i7 < jSONArray.length(); i7++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i7);
            zzamVarZzg.zza(new n0(jSONObject.getString("credentialId"), jSONObject.getString("name"), jSONObject.getString("displayName")));
        }
        return zzamVarZzg.zza();
    }

    public static final JSONObject C(n0 n0Var) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("credentialId", n0Var.f5806a);
        jSONObject.put("name", n0Var.f5807b);
        jSONObject.put("displayName", n0Var.f5808c);
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.E(parcel, 1, this.f5806a, false);
        Q1.c.E(parcel, 2, this.f5807b, false);
        Q1.c.E(parcel, 3, this.f5808c, false);
        Q1.c.b(parcel, iA);
    }
}
