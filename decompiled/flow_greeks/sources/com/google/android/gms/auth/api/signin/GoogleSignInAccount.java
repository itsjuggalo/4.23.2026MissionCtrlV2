package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.s;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import f5.d;
import io.flutter.plugins.firebase.auth.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import n5.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import t5.e;
import t5.h;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class GoogleSignInAccount extends n5.a implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new d();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final e f5398m = h.d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f5401c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f5402d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Uri f5403e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f5404f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f5405g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f5406h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List f5407i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f5408j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f5409k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Set f5410l = new HashSet();

    public GoogleSignInAccount(String str, String str2, String str3, String str4, Uri uri, String str5, long j10, String str6, List list, String str7, String str8) {
        this.f5399a = str;
        this.f5400b = str2;
        this.f5401c = str3;
        this.f5402d = str4;
        this.f5403e = uri;
        this.f5404f = str5;
        this.f5405g = j10;
        this.f5406h = str6;
        this.f5407i = list;
        this.f5408j = str7;
        this.f5409k = str8;
    }

    public static GoogleSignInAccount X(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String strOptString = jSONObject.optString("photoUrl");
        Uri uri = !TextUtils.isEmpty(strOptString) ? Uri.parse(strOptString) : null;
        long j10 = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            hashSet.add(new Scope(jSONArray.getString(i10)));
        }
        GoogleSignInAccount googleSignInAccountY = Y(jSONObject.optString(DiagnosticsEntry.ID_KEY), jSONObject.has("tokenId") ? jSONObject.optString("tokenId") : null, jSONObject.has(Constants.EMAIL) ? jSONObject.optString(Constants.EMAIL) : null, jSONObject.has("displayName") ? jSONObject.optString("displayName") : null, jSONObject.has("givenName") ? jSONObject.optString("givenName") : null, jSONObject.has("familyName") ? jSONObject.optString("familyName") : null, uri, Long.valueOf(j10), jSONObject.getString("obfuscatedIdentifier"), hashSet);
        googleSignInAccountY.f5404f = jSONObject.has(Constants.SERVER_AUTH_CODE) ? jSONObject.optString(Constants.SERVER_AUTH_CODE) : null;
        return googleSignInAccountY;
    }

    public static GoogleSignInAccount Y(String str, String str2, String str3, String str4, String str5, String str6, Uri uri, Long l10, String str7, Set set) {
        return new GoogleSignInAccount(str, str2, str3, str4, uri, null, l10.longValue(), s.e(str7), new ArrayList((Collection) s.k(set)), str5, str6);
    }

    public String K() {
        return this.f5401c;
    }

    public String R() {
        return this.f5409k;
    }

    public String S() {
        return this.f5408j;
    }

    public String T() {
        return this.f5399a;
    }

    public String U() {
        return this.f5400b;
    }

    public Set V() {
        HashSet hashSet = new HashSet(this.f5407i);
        hashSet.addAll(this.f5410l);
        return hashSet;
    }

    public String W() {
        return this.f5404f;
    }

    public final String Z() {
        return this.f5406h;
    }

    public final String a0() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (T() != null) {
                jSONObject.put(DiagnosticsEntry.ID_KEY, T());
            }
            if (U() != null) {
                jSONObject.put("tokenId", U());
            }
            if (K() != null) {
                jSONObject.put(Constants.EMAIL, K());
            }
            if (v() != null) {
                jSONObject.put("displayName", v());
            }
            if (S() != null) {
                jSONObject.put("givenName", S());
            }
            if (R() != null) {
                jSONObject.put("familyName", R());
            }
            Uri uriD = d();
            if (uriD != null) {
                jSONObject.put("photoUrl", uriD.toString());
            }
            if (W() != null) {
                jSONObject.put(Constants.SERVER_AUTH_CODE, W());
            }
            jSONObject.put("expirationTime", this.f5405g);
            jSONObject.put("obfuscatedIdentifier", this.f5406h);
            JSONArray jSONArray = new JSONArray();
            List list = this.f5407i;
            Scope[] scopeArr = (Scope[]) list.toArray(new Scope[list.size()]);
            Arrays.sort(scopeArr, new Comparator() { // from class: f5.c
                @Override // java.util.Comparator
                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    Parcelable.Creator<GoogleSignInAccount> creator = GoogleSignInAccount.CREATOR;
                    return ((Scope) obj).R().compareTo(((Scope) obj2).R());
                }
            });
            for (Scope scope : scopeArr) {
                jSONArray.put(scope.R());
            }
            jSONObject.put("grantedScopes", jSONArray);
            jSONObject.remove(Constants.SERVER_AUTH_CODE);
            return jSONObject.toString();
        } catch (JSONException e10) {
            throw new RuntimeException(e10);
        }
    }

    public Uri d() {
        return this.f5403e;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        return googleSignInAccount.f5406h.equals(this.f5406h) && googleSignInAccount.V().equals(V());
    }

    public int hashCode() {
        return ((this.f5406h.hashCode() + 527) * 31) + V().hashCode();
    }

    public String v() {
        return this.f5402d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = c.a(parcel);
        c.E(parcel, 2, T(), false);
        c.E(parcel, 3, U(), false);
        c.E(parcel, 4, K(), false);
        c.E(parcel, 5, v(), false);
        c.C(parcel, 6, d(), i10, false);
        c.E(parcel, 7, W(), false);
        c.x(parcel, 8, this.f5405g);
        c.E(parcel, 9, this.f5406h, false);
        c.I(parcel, 10, this.f5407i, false);
        c.E(parcel, 11, S(), false);
        c.E(parcel, 12, R(), false);
        c.b(parcel, iA);
    }
}
