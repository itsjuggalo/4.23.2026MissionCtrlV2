package n7;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.p002firebaseauthapi.zzaao;
import com.google.android.gms.internal.p002firebaseauthapi.zzahk;
import com.google.android.gms.internal.p002firebaseauthapi.zzaib;
import io.flutter.plugins.firebase.auth.Constants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends n5.a implements m7.b1 {
    public static final Parcelable.Creator<e> CREATOR = new d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f16732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f16733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f16734c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f16735d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Uri f16736e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f16737f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f16738g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f16739h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f16740i;

    public e(zzaib zzaibVar) {
        com.google.android.gms.common.internal.s.k(zzaibVar);
        this.f16732a = zzaibVar.zzd();
        this.f16733b = com.google.android.gms.common.internal.s.e(zzaibVar.zzf());
        this.f16734c = zzaibVar.zzb();
        Uri uriZza = zzaibVar.zza();
        if (uriZza != null) {
            this.f16735d = uriZza.toString();
            this.f16736e = uriZza;
        }
        this.f16737f = zzaibVar.zzc();
        this.f16738g = zzaibVar.zze();
        this.f16739h = false;
        this.f16740i = zzaibVar.zzg();
    }

    public static e R(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new e(jSONObject.optString("userId"), jSONObject.optString(Constants.PROVIDER_ID), jSONObject.optString(Constants.EMAIL), jSONObject.optString("phoneNumber"), jSONObject.optString("displayName"), jSONObject.optString("photoUrl"), jSONObject.optBoolean("isEmailVerified"), jSONObject.optString("rawUserInfo"));
        } catch (JSONException e10) {
            Log.d("DefaultAuthUserInfo", "Failed to unpack UserInfo from JSON");
            throw new zzaao(e10);
        }
    }

    @Override // m7.b1
    public final String K() {
        return this.f16737f;
    }

    public final String S() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("userId", this.f16732a);
            jSONObject.putOpt(Constants.PROVIDER_ID, this.f16733b);
            jSONObject.putOpt("displayName", this.f16734c);
            jSONObject.putOpt("photoUrl", this.f16735d);
            jSONObject.putOpt(Constants.EMAIL, this.f16737f);
            jSONObject.putOpt("phoneNumber", this.f16738g);
            jSONObject.putOpt("isEmailVerified", Boolean.valueOf(this.f16739h));
            jSONObject.putOpt("rawUserInfo", this.f16740i);
            return jSONObject.toString();
        } catch (JSONException e10) {
            Log.d("DefaultAuthUserInfo", "Failed to jsonify this object");
            throw new zzaao(e10);
        }
    }

    @Override // m7.b1
    public final String a() {
        return this.f16732a;
    }

    @Override // m7.b1
    public final String c() {
        return this.f16733b;
    }

    @Override // m7.b1
    public final Uri d() {
        if (!TextUtils.isEmpty(this.f16735d) && this.f16736e == null) {
            this.f16736e = Uri.parse(this.f16735d);
        }
        return this.f16736e;
    }

    @Override // m7.b1
    public final boolean f() {
        return this.f16739h;
    }

    @Override // m7.b1
    public final String p() {
        return this.f16738g;
    }

    @Override // m7.b1
    public final String v() {
        return this.f16734c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.E(parcel, 1, a(), false);
        n5.c.E(parcel, 2, c(), false);
        n5.c.E(parcel, 3, v(), false);
        n5.c.E(parcel, 4, this.f16735d, false);
        n5.c.E(parcel, 5, K(), false);
        n5.c.E(parcel, 6, p(), false);
        n5.c.g(parcel, 7, f());
        n5.c.E(parcel, 8, this.f16740i, false);
        n5.c.b(parcel, iA);
    }

    public final String zza() {
        return this.f16740i;
    }

    public e(zzahk zzahkVar, String str) {
        com.google.android.gms.common.internal.s.k(zzahkVar);
        com.google.android.gms.common.internal.s.e(str);
        this.f16732a = com.google.android.gms.common.internal.s.e(zzahkVar.zzi());
        this.f16733b = str;
        this.f16737f = zzahkVar.zzh();
        this.f16734c = zzahkVar.zzg();
        Uri uriZzc = zzahkVar.zzc();
        if (uriZzc != null) {
            this.f16735d = uriZzc.toString();
            this.f16736e = uriZzc;
        }
        this.f16739h = zzahkVar.zzm();
        this.f16740i = null;
        this.f16738g = zzahkVar.zzj();
    }

    public e(String str, String str2, String str3, String str4, String str5, String str6, boolean z10, String str7) {
        this.f16732a = str;
        this.f16733b = str2;
        this.f16737f = str3;
        this.f16738g = str4;
        this.f16734c = str5;
        this.f16735d = str6;
        if (!TextUtils.isEmpty(str6)) {
            this.f16736e = Uri.parse(this.f16735d);
        }
        this.f16739h = z10;
        this.f16740i = str7;
    }
}
