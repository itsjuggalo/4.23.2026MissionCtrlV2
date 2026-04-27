package a3;

import Z2.InterfaceC0750c0;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.internal.p002firebaseauthapi.zzaag;
import com.google.android.gms.internal.p002firebaseauthapi.zzahc;
import com.google.android.gms.internal.p002firebaseauthapi.zzaht;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: a3.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0847e extends Q1.a implements InterfaceC0750c0 {
    public static final Parcelable.Creator<C0847e> CREATOR = new C0845d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f6195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f6196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f6197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f6198d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Uri f6199e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f6200f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f6201g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f6202h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f6203i;

    public C0847e(zzaht zzahtVar) {
        AbstractC1207s.k(zzahtVar);
        this.f6195a = zzahtVar.zzd();
        this.f6196b = AbstractC1207s.e(zzahtVar.zzf());
        this.f6197c = zzahtVar.zzb();
        Uri uriZza = zzahtVar.zza();
        if (uriZza != null) {
            this.f6198d = uriZza.toString();
            this.f6199e = uriZza;
        }
        this.f6200f = zzahtVar.zzc();
        this.f6201g = zzahtVar.zze();
        this.f6202h = false;
        this.f6203i = zzahtVar.zzg();
    }

    public static C0847e A(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new C0847e(jSONObject.optString("userId"), jSONObject.optString("providerId"), jSONObject.optString("email"), jSONObject.optString("phoneNumber"), jSONObject.optString("displayName"), jSONObject.optString("photoUrl"), jSONObject.optBoolean("isEmailVerified"), jSONObject.optString("rawUserInfo"));
        } catch (JSONException e7) {
            Log.d("DefaultAuthUserInfo", "Failed to unpack UserInfo from JSON");
            throw new zzaag(e7);
        }
    }

    public final String B() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("userId", this.f6195a);
            jSONObject.putOpt("providerId", this.f6196b);
            jSONObject.putOpt("displayName", this.f6197c);
            jSONObject.putOpt("photoUrl", this.f6198d);
            jSONObject.putOpt("email", this.f6200f);
            jSONObject.putOpt("phoneNumber", this.f6201g);
            jSONObject.putOpt("isEmailVerified", Boolean.valueOf(this.f6202h));
            jSONObject.putOpt("rawUserInfo", this.f6203i);
            return jSONObject.toString();
        } catch (JSONException e7) {
            Log.d("DefaultAuthUserInfo", "Failed to jsonify this object");
            throw new zzaag(e7);
        }
    }

    @Override // Z2.InterfaceC0750c0
    public final String a() {
        return this.f6195a;
    }

    @Override // Z2.InterfaceC0750c0
    public final String b() {
        return this.f6196b;
    }

    @Override // Z2.InterfaceC0750c0
    public final Uri c() {
        if (!TextUtils.isEmpty(this.f6198d) && this.f6199e == null) {
            this.f6199e = Uri.parse(this.f6198d);
        }
        return this.f6199e;
    }

    @Override // Z2.InterfaceC0750c0
    public final boolean g() {
        return this.f6202h;
    }

    @Override // Z2.InterfaceC0750c0
    public final String k() {
        return this.f6201g;
    }

    @Override // Z2.InterfaceC0750c0
    public final String p() {
        return this.f6197c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.E(parcel, 1, a(), false);
        Q1.c.E(parcel, 2, b(), false);
        Q1.c.E(parcel, 3, p(), false);
        Q1.c.E(parcel, 4, this.f6198d, false);
        Q1.c.E(parcel, 5, x(), false);
        Q1.c.E(parcel, 6, k(), false);
        Q1.c.g(parcel, 7, g());
        Q1.c.E(parcel, 8, this.f6203i, false);
        Q1.c.b(parcel, iA);
    }

    @Override // Z2.InterfaceC0750c0
    public final String x() {
        return this.f6200f;
    }

    public final String zza() {
        return this.f6203i;
    }

    public C0847e(zzahc zzahcVar, String str) {
        AbstractC1207s.k(zzahcVar);
        AbstractC1207s.e(str);
        this.f6195a = AbstractC1207s.e(zzahcVar.zzi());
        this.f6196b = str;
        this.f6200f = zzahcVar.zzh();
        this.f6197c = zzahcVar.zzg();
        Uri uriZzc = zzahcVar.zzc();
        if (uriZzc != null) {
            this.f6198d = uriZzc.toString();
            this.f6199e = uriZzc;
        }
        this.f6202h = zzahcVar.zzm();
        this.f6203i = null;
        this.f6201g = zzahcVar.zzj();
    }

    public C0847e(String str, String str2, String str3, String str4, String str5, String str6, boolean z7, String str7) {
        this.f6195a = str;
        this.f6196b = str2;
        this.f6200f = str3;
        this.f6201g = str4;
        this.f6197c = str5;
        this.f6198d = str6;
        if (!TextUtils.isEmpty(str6)) {
            this.f6199e = Uri.parse(this.f6198d);
        }
        this.f6202h = z7;
        this.f6203i = str7;
    }
}
