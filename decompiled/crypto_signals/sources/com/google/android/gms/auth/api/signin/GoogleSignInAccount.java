package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.I;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import r1.e;
import t2.u0;
import v1.AbstractC1255a;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class GoogleSignInAccount extends AbstractC1255a implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new e(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f5017c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f5018d;
    public final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Uri f5019f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f5020k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f5021l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f5022m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ArrayList f5023n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f5024o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f5025p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final HashSet f5026q = new HashSet();

    public GoogleSignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, String str5, long j4, String str6, ArrayList arrayList, String str7, String str8) {
        this.f5015a = i;
        this.f5016b = str;
        this.f5017c = str2;
        this.f5018d = str3;
        this.e = str4;
        this.f5019f = uri;
        this.f5020k = str5;
        this.f5021l = j4;
        this.f5022m = str6;
        this.f5023n = arrayList;
        this.f5024o = str7;
        this.f5025p = str8;
    }

    public static GoogleSignInAccount m(String str) throws JSONException {
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
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(1, jSONArray.getString(i)));
        }
        String strOptString2 = jSONObject.optString("id");
        String strOptString3 = jSONObject.has("tokenId") ? jSONObject.optString("tokenId") : null;
        String strOptString4 = jSONObject.has("email") ? jSONObject.optString("email") : null;
        String strOptString5 = jSONObject.has("displayName") ? jSONObject.optString("displayName") : null;
        String strOptString6 = jSONObject.has("givenName") ? jSONObject.optString("givenName") : null;
        String strOptString7 = jSONObject.has("familyName") ? jSONObject.optString("familyName") : null;
        String string = jSONObject.getString("obfuscatedIdentifier");
        I.d(string);
        GoogleSignInAccount googleSignInAccount = new GoogleSignInAccount(3, strOptString2, strOptString3, strOptString4, strOptString5, uri, null, j4, string, new ArrayList(hashSet), strOptString6, strOptString7);
        googleSignInAccount.f5020k = jSONObject.has("serverAuthCode") ? jSONObject.optString("serverAuthCode") : null;
        return googleSignInAccount;
    }

    public final boolean equals(Object obj) {
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
        if (!googleSignInAccount.f5022m.equals(this.f5022m)) {
            return false;
        }
        HashSet hashSet = new HashSet(googleSignInAccount.f5023n);
        hashSet.addAll(googleSignInAccount.f5026q);
        HashSet hashSet2 = new HashSet(this.f5023n);
        hashSet2.addAll(this.f5026q);
        return hashSet.equals(hashSet2);
    }

    public final int hashCode() {
        int iHashCode = this.f5022m.hashCode() + 527;
        HashSet hashSet = new HashSet(this.f5023n);
        hashSet.addAll(this.f5026q);
        return (iHashCode * 31) + hashSet.hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iX = u0.X(20293, parcel);
        u0.b0(parcel, 1, 4);
        parcel.writeInt(this.f5015a);
        u0.T(parcel, 2, this.f5016b, false);
        u0.T(parcel, 3, this.f5017c, false);
        u0.T(parcel, 4, this.f5018d, false);
        u0.T(parcel, 5, this.e, false);
        u0.S(parcel, 6, this.f5019f, i, false);
        u0.T(parcel, 7, this.f5020k, false);
        u0.b0(parcel, 8, 8);
        parcel.writeLong(this.f5021l);
        u0.T(parcel, 9, this.f5022m, false);
        u0.W(parcel, 10, this.f5023n, false);
        u0.T(parcel, 11, this.f5024o, false);
        u0.T(parcel, 12, this.f5025p, false);
        u0.a0(iX, parcel);
    }
}
