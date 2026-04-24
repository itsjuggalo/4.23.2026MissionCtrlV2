package com.google.android.gms.auth.api.signin;

import L1.e;
import Q1.c;
import W1.d;
import W1.g;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
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

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class GoogleSignInAccount extends Q1.a implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new e();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final d f10780n = g.d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f10783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f10784d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f10785e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Uri f10786f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f10787g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f10788h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f10789i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List f10790j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f10791k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f10792l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Set f10793m = new HashSet();

    public GoogleSignInAccount(int i7, String str, String str2, String str3, String str4, Uri uri, String str5, long j7, String str6, List list, String str7, String str8) {
        this.f10781a = i7;
        this.f10782b = str;
        this.f10783c = str2;
        this.f10784d = str3;
        this.f10785e = str4;
        this.f10786f = uri;
        this.f10787g = str5;
        this.f10788h = j7;
        this.f10789i = str6;
        this.f10790j = list;
        this.f10791k = str7;
        this.f10792l = str8;
    }

    public static GoogleSignInAccount I(String str, String str2, String str3, String str4, String str5, String str6, Uri uri, Long l7, String str7, Set set) {
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, null, l7.longValue(), AbstractC1207s.e(str7), new ArrayList((Collection) AbstractC1207s.k(set)), str5, str6);
    }

    public static GoogleSignInAccount J(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String strOptString = jSONObject.optString("photoUrl");
        Uri uri = !TextUtils.isEmpty(strOptString) ? Uri.parse(strOptString) : null;
        long j7 = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i7 = 0; i7 < length; i7++) {
            hashSet.add(new Scope(jSONArray.getString(i7)));
        }
        GoogleSignInAccount googleSignInAccountI = I(jSONObject.optString(DiagnosticsEntry.ID_KEY), jSONObject.has("tokenId") ? jSONObject.optString("tokenId") : null, jSONObject.has("email") ? jSONObject.optString("email") : null, jSONObject.has("displayName") ? jSONObject.optString("displayName") : null, jSONObject.has("givenName") ? jSONObject.optString("givenName") : null, jSONObject.has("familyName") ? jSONObject.optString("familyName") : null, uri, Long.valueOf(j7), jSONObject.getString("obfuscatedIdentifier"), hashSet);
        googleSignInAccountI.f10787g = jSONObject.has("serverAuthCode") ? jSONObject.optString("serverAuthCode") : null;
        return googleSignInAccountI;
    }

    public String A() {
        return this.f10792l;
    }

    public String B() {
        return this.f10791k;
    }

    public Set C() {
        return new HashSet(this.f10790j);
    }

    public String D() {
        return this.f10782b;
    }

    public String E() {
        return this.f10783c;
    }

    public Set F() {
        HashSet hashSet = new HashSet(this.f10790j);
        hashSet.addAll(this.f10793m);
        return hashSet;
    }

    public String G() {
        return this.f10787g;
    }

    public boolean H() {
        return f10780n.a() / 1000 >= this.f10788h + (-300);
    }

    public final String K() {
        return this.f10789i;
    }

    public final String L() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (D() != null) {
                jSONObject.put(DiagnosticsEntry.ID_KEY, D());
            }
            if (E() != null) {
                jSONObject.put("tokenId", E());
            }
            if (x() != null) {
                jSONObject.put("email", x());
            }
            if (p() != null) {
                jSONObject.put("displayName", p());
            }
            if (B() != null) {
                jSONObject.put("givenName", B());
            }
            if (A() != null) {
                jSONObject.put("familyName", A());
            }
            Uri uriC = c();
            if (uriC != null) {
                jSONObject.put("photoUrl", uriC.toString());
            }
            if (G() != null) {
                jSONObject.put("serverAuthCode", G());
            }
            jSONObject.put("expirationTime", this.f10788h);
            jSONObject.put("obfuscatedIdentifier", this.f10789i);
            JSONArray jSONArray = new JSONArray();
            List list = this.f10790j;
            Scope[] scopeArr = (Scope[]) list.toArray(new Scope[list.size()]);
            Arrays.sort(scopeArr, new Comparator() { // from class: L1.d
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    Parcelable.Creator<GoogleSignInAccount> creator = GoogleSignInAccount.CREATOR;
                    return ((Scope) obj).A().compareTo(((Scope) obj2).A());
                }
            });
            for (Scope scope : scopeArr) {
                jSONArray.put(scope.A());
            }
            jSONObject.put("grantedScopes", jSONArray);
            jSONObject.remove("serverAuthCode");
            return jSONObject.toString();
        } catch (JSONException e7) {
            throw new RuntimeException(e7);
        }
    }

    public Uri c() {
        return this.f10786f;
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
        return googleSignInAccount.f10789i.equals(this.f10789i) && googleSignInAccount.F().equals(F());
    }

    public int hashCode() {
        return ((this.f10789i.hashCode() + 527) * 31) + F().hashCode();
    }

    public String p() {
        return this.f10785e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = c.a(parcel);
        c.t(parcel, 1, this.f10781a);
        c.E(parcel, 2, D(), false);
        c.E(parcel, 3, E(), false);
        c.E(parcel, 4, x(), false);
        c.E(parcel, 5, p(), false);
        c.C(parcel, 6, c(), i7, false);
        c.E(parcel, 7, G(), false);
        c.x(parcel, 8, this.f10788h);
        c.E(parcel, 9, this.f10789i, false);
        c.I(parcel, 10, this.f10790j, false);
        c.E(parcel, 11, B(), false);
        c.E(parcel, 12, A(), false);
        c.b(parcel, iA);
    }

    public String x() {
        return this.f10784d;
    }
}
