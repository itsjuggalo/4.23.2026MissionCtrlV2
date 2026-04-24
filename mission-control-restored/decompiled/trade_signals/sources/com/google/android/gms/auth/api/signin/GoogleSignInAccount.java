package com.google.android.gms.auth.api.signin;

import T1.a;
import T1.c;
import W1.e;
import W1.h;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.AbstractC1294n;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class GoogleSignInAccount extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new M1.a();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final e f14889n = h.d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14891b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f14892c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f14893d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f14894e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Uri f14895f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f14896g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f14897h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f14898i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List f14899j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f14900k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f14901l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Set f14902m = new HashSet();

    public GoogleSignInAccount(int i8, String str, String str2, String str3, String str4, Uri uri, String str5, long j8, String str6, List list, String str7, String str8) {
        this.f14890a = i8;
        this.f14891b = str;
        this.f14892c = str2;
        this.f14893d = str3;
        this.f14894e = str4;
        this.f14895f = uri;
        this.f14896g = str5;
        this.f14897h = j8;
        this.f14898i = str6;
        this.f14899j = list;
        this.f14900k = str7;
        this.f14901l = str8;
    }

    public static GoogleSignInAccount I(String str, String str2, String str3, String str4, String str5, String str6, Uri uri, Long l8, String str7, Set set) {
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, null, l8.longValue(), AbstractC1294n.d(str7), new ArrayList((Collection) AbstractC1294n.j(set)), str5, str6);
    }

    public static GoogleSignInAccount J(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String strOptString = jSONObject.optString("photoUrl");
        Uri uri = !TextUtils.isEmpty(strOptString) ? Uri.parse(strOptString) : null;
        long j8 = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i8 = 0; i8 < length; i8++) {
            hashSet.add(new Scope(jSONArray.getString(i8)));
        }
        GoogleSignInAccount googleSignInAccountI = I(jSONObject.optString(DiagnosticsEntry.ID_KEY), jSONObject.has("tokenId") ? jSONObject.optString("tokenId") : null, jSONObject.has("email") ? jSONObject.optString("email") : null, jSONObject.has("displayName") ? jSONObject.optString("displayName") : null, jSONObject.has("givenName") ? jSONObject.optString("givenName") : null, jSONObject.has("familyName") ? jSONObject.optString("familyName") : null, uri, Long.valueOf(j8), jSONObject.getString("obfuscatedIdentifier"), hashSet);
        googleSignInAccountI.f14896g = jSONObject.has("serverAuthCode") ? jSONObject.optString("serverAuthCode") : null;
        return googleSignInAccountI;
    }

    public Uri C() {
        return this.f14895f;
    }

    public Set F() {
        HashSet hashSet = new HashSet(this.f14899j);
        hashSet.addAll(this.f14902m);
        return hashSet;
    }

    public String H() {
        return this.f14896g;
    }

    public String a() {
        return this.f14894e;
    }

    public String d() {
        return this.f14893d;
    }

    public String e() {
        return this.f14901l;
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
        return googleSignInAccount.f14898i.equals(this.f14898i) && googleSignInAccount.F().equals(F());
    }

    public String f() {
        return this.f14900k;
    }

    public String h() {
        return this.f14891b;
    }

    public int hashCode() {
        return ((this.f14898i.hashCode() + 527) * 31) + F().hashCode();
    }

    public String n() {
        return this.f14892c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
        int iA = c.a(parcel);
        c.j(parcel, 1, this.f14890a);
        c.p(parcel, 2, h(), false);
        c.p(parcel, 3, n(), false);
        c.p(parcel, 4, d(), false);
        c.p(parcel, 5, a(), false);
        c.o(parcel, 6, C(), i8, false);
        c.p(parcel, 7, H(), false);
        c.m(parcel, 8, this.f14897h);
        c.p(parcel, 9, this.f14898i, false);
        c.s(parcel, 10, this.f14899j, false);
        c.p(parcel, 11, f(), false);
        c.p(parcel, 12, e(), false);
        c.b(parcel, iA);
    }
}
