package m7;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzah;
import com.google.android.gms.internal.p002firebaseauthapi.zzak;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class p1 extends n5.a {
    public static final Parcelable.Creator<p1> CREATOR = new o1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f16054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f16055c;

    public p1(String str, String str2, String str3) {
        this.f16053a = str;
        this.f16054b = str2;
        this.f16055c = str3;
    }

    public static zzah R(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return zzah.zzg();
        }
        zzak zzakVarZzf = zzah.zzf();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i10);
            zzakVarZzf.zza(new p1(jSONObject.getString("credentialId"), jSONObject.getString("name"), jSONObject.getString("displayName")));
        }
        return zzakVarZzf.zza();
    }

    public static final p1 S(JSONObject jSONObject) {
        return new p1(jSONObject.getString("credentialId"), jSONObject.getString("name"), jSONObject.getString("displayName"));
    }

    public static final JSONObject T(p1 p1Var) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("credentialId", p1Var.f16053a);
        jSONObject.put("name", p1Var.f16054b);
        jSONObject.put("displayName", p1Var.f16055c);
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.E(parcel, 1, this.f16053a, false);
        n5.c.E(parcel, 2, this.f16054b, false);
        n5.c.E(parcel, 3, this.f16055c, false);
        n5.c.b(parcel, iA);
    }
}
