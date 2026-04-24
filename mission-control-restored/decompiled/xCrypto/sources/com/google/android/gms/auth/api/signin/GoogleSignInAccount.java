package com.google.android.gms.auth.api.signin;

import A1.c;
import G1.d;
import G1.g;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.flutter.plugins.firebase.auth.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import u1.C1866e;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class GoogleSignInAccount extends A1.a implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new C1866e();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final d f9595n = g.c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9597b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f9598c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f9599d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f9600e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Uri f9601f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f9602g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f9603h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f9604i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List f9605j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f9606k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f9607l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Set f9608m = new HashSet();

    public GoogleSignInAccount(int i4, String str, String str2, String str3, String str4, Uri uri, String str5, long j4, String str6, List list, String str7, String str8) {
        this.f9596a = i4;
        this.f9597b = str;
        this.f9598c = str2;
        this.f9599d = str3;
        this.f9600e = str4;
        this.f9601f = uri;
        this.f9602g = str5;
        this.f9603h = j4;
        this.f9604i = str6;
        this.f9605j = list;
        this.f9606k = str7;
        this.f9607l = str8;
    }

    public static GoogleSignInAccount q(String str, String str2, String str3, String str4, String str5, String str6, Uri uri, Long l4, String str7, Set set) {
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, null, l4.longValue(), AbstractC0940s.e(str7), new ArrayList((Collection) AbstractC0940s.k(set)), str5, str6);
    }

    public static GoogleSignInAccount r(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String strOptString = jSONObject.optString("photoUrl");
        Uri uri = !TextUtils.isEmpty(strOptString) ? Uri.parse(strOptString) : null;
        long j4 = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i4 = 0; i4 < length; i4++) {
            hashSet.add(new Scope(jSONArray.getString(i4)));
        }
        GoogleSignInAccount googleSignInAccountQ = q(jSONObject.optString(DiagnosticsEntry.ID_KEY), jSONObject.has("tokenId") ? jSONObject.optString("tokenId") : null, jSONObject.has(Constants.EMAIL) ? jSONObject.optString(Constants.EMAIL) : null, jSONObject.has("displayName") ? jSONObject.optString("displayName") : null, jSONObject.has("givenName") ? jSONObject.optString("givenName") : null, jSONObject.has("familyName") ? jSONObject.optString("familyName") : null, uri, Long.valueOf(j4), jSONObject.getString("obfuscatedIdentifier"), hashSet);
        googleSignInAccountQ.f9602g = jSONObject.has(Constants.SERVER_AUTH_CODE) ? jSONObject.optString(Constants.SERVER_AUTH_CODE) : null;
        return googleSignInAccountQ;
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
        return googleSignInAccount.f9604i.equals(this.f9604i) && googleSignInAccount.n().equals(n());
    }

    public String getDisplayName() {
        return this.f9600e;
    }

    public String getEmail() {
        return this.f9599d;
    }

    public String getIdToken() {
        return this.f9598c;
    }

    public Uri getPhotoUrl() {
        return this.f9601f;
    }

    public int hashCode() {
        return ((this.f9604i.hashCode() + 527) * 31) + n().hashCode();
    }

    public String i() {
        return this.f9607l;
    }

    public String k() {
        return this.f9606k;
    }

    public Set l() {
        return new HashSet(this.f9605j);
    }

    public String m() {
        return this.f9597b;
    }

    public Set n() {
        HashSet hashSet = new HashSet(this.f9605j);
        hashSet.addAll(this.f9608m);
        return hashSet;
    }

    public String o() {
        return this.f9602g;
    }

    public boolean p() {
        return f9595n.currentTimeMillis() / 1000 >= this.f9603h + (-300);
    }

    public final String s() {
        return this.f9604i;
    }

    public final String t() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (m() != null) {
                jSONObject.put(DiagnosticsEntry.ID_KEY, m());
            }
            if (getIdToken() != null) {
                jSONObject.put("tokenId", getIdToken());
            }
            if (getEmail() != null) {
                jSONObject.put(Constants.EMAIL, getEmail());
            }
            if (getDisplayName() != null) {
                jSONObject.put("displayName", getDisplayName());
            }
            if (k() != null) {
                jSONObject.put("givenName", k());
            }
            if (i() != null) {
                jSONObject.put("familyName", i());
            }
            Uri photoUrl = getPhotoUrl();
            if (photoUrl != null) {
                jSONObject.put("photoUrl", photoUrl.toString());
            }
            if (o() != null) {
                jSONObject.put(Constants.SERVER_AUTH_CODE, o());
            }
            jSONObject.put("expirationTime", this.f9603h);
            jSONObject.put("obfuscatedIdentifier", this.f9604i);
            JSONArray jSONArray = new JSONArray();
            List list = this.f9605j;
            Scope[] scopeArr = (Scope[]) list.toArray(new Scope[list.size()]);
            Arrays.sort(scopeArr, new Comparator() { // from class: u1.d
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    Parcelable.Creator<GoogleSignInAccount> creator = GoogleSignInAccount.CREATOR;
                    return ((Scope) obj).i().compareTo(((Scope) obj2).i());
                }
            });
            for (Scope scope : scopeArr) {
                jSONArray.put(scope.i());
            }
            jSONObject.put("grantedScopes", jSONArray);
            jSONObject.remove(Constants.SERVER_AUTH_CODE);
            return jSONObject.toString();
        } catch (JSONException e4) {
            throw new RuntimeException(e4);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = c.a(parcel);
        c.t(parcel, 1, this.f9596a);
        c.E(parcel, 2, m(), false);
        c.E(parcel, 3, getIdToken(), false);
        c.E(parcel, 4, getEmail(), false);
        c.E(parcel, 5, getDisplayName(), false);
        c.C(parcel, 6, getPhotoUrl(), i4, false);
        c.E(parcel, 7, o(), false);
        c.x(parcel, 8, this.f9603h);
        c.E(parcel, 9, this.f9604i, false);
        c.I(parcel, 10, this.f9605j, false);
        c.E(parcel, 11, k(), false);
        c.E(parcel, 12, i(), false);
        c.b(parcel, iA);
    }
}
