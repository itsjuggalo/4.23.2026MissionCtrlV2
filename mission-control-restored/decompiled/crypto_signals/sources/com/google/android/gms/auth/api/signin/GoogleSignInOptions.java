package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
import r1.d;
import s1.C0984a;
import t2.u0;
import v1.AbstractC1255a;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class GoogleSignInOptions extends AbstractC1255a implements e, ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final GoogleSignInOptions f5027o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final GoogleSignInOptions f5028p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Scope f5029q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Scope f5030r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Scope f5031s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Scope f5032t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final d f5033u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f5035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Account f5036c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f5037d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f5038f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f5039k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f5040l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ArrayList f5041m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f5042n;

    static {
        Scope scope = new Scope(1, "profile");
        f5029q = new Scope(1, "email");
        Scope scope2 = new Scope(1, "openid");
        f5030r = scope2;
        Scope scope3 = new Scope(1, "https://www.googleapis.com/auth/games_lite");
        f5031s = scope3;
        f5032t = new Scope(1, "https://www.googleapis.com/auth/games");
        HashSet hashSet = new HashSet();
        HashMap map = new HashMap();
        hashSet.add(scope2);
        hashSet.add(scope);
        if (hashSet.contains(f5032t)) {
            Scope scope4 = f5031s;
            if (hashSet.contains(scope4)) {
                hashSet.remove(scope4);
            }
        }
        f5027o = new GoogleSignInOptions(3, new ArrayList(hashSet), null, false, false, false, null, null, map, null);
        HashSet hashSet2 = new HashSet();
        HashMap map2 = new HashMap();
        hashSet2.add(scope3);
        hashSet2.addAll(Arrays.asList(new Scope[0]));
        if (hashSet2.contains(f5032t)) {
            Scope scope5 = f5031s;
            if (hashSet2.contains(scope5)) {
                hashSet2.remove(scope5);
            }
        }
        f5028p = new GoogleSignInOptions(3, new ArrayList(hashSet2), null, false, false, false, null, null, map2, null);
        CREATOR = new r1.e(1);
        f5033u = new d(1);
    }

    public GoogleSignInOptions(int i, ArrayList arrayList, Account account, boolean z6, boolean z7, boolean z8, String str, String str2, HashMap map, String str3) {
        this.f5034a = i;
        this.f5035b = arrayList;
        this.f5036c = account;
        this.f5037d = z6;
        this.e = z7;
        this.f5038f = z8;
        this.f5039k = str;
        this.f5040l = str2;
        this.f5041m = new ArrayList(map.values());
        this.f5042n = str3;
    }

    public static GoogleSignInOptions n(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(1, jSONArray.getString(i)));
        }
        String strOptString = jSONObject.has("accountName") ? jSONObject.optString("accountName") : null;
        return new GoogleSignInOptions(3, new ArrayList(hashSet), !TextUtils.isEmpty(strOptString) ? new Account(strOptString, "com.google") : null, jSONObject.getBoolean("idTokenRequested"), jSONObject.getBoolean("serverAuthRequested"), jSONObject.getBoolean("forceCodeForRefreshToken"), jSONObject.has("serverClientId") ? jSONObject.optString("serverClientId") : null, jSONObject.has("hostedDomain") ? jSONObject.optString("hostedDomain") : null, new HashMap(), null);
    }

    public static HashMap o(ArrayList arrayList) {
        HashMap map = new HashMap();
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                C0984a c0984a = (C0984a) it.next();
                map.put(Integer.valueOf(c0984a.f9503b), c0984a);
            }
        }
        return map;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004b A[Catch: ClassCastException -> 0x0077, TryCatch #0 {ClassCastException -> 0x0077, blocks: (B:5:0x0008, B:7:0x0016, B:10:0x001f, B:12:0x002d, B:15:0x0038, B:21:0x0045, B:23:0x004b, B:29:0x0059, B:31:0x005f, B:33:0x0065, B:35:0x006b, B:26:0x0052, B:19:0x003f), top: B:41:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052 A[Catch: ClassCastException -> 0x0077, TryCatch #0 {ClassCastException -> 0x0077, blocks: (B:5:0x0008, B:7:0x0016, B:10:0x001f, B:12:0x002d, B:15:0x0038, B:21:0x0045, B:23:0x004b, B:29:0x0059, B:31:0x005f, B:33:0x0065, B:35:0x006b, B:26:0x0052, B:19:0x003f), top: B:41:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0075 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.String r0 = r7.f5039k
            java.util.ArrayList r1 = r7.f5035b
            r2 = 0
            if (r8 != 0) goto L8
            return r2
        L8:
            com.google.android.gms.auth.api.signin.GoogleSignInOptions r8 = (com.google.android.gms.auth.api.signin.GoogleSignInOptions) r8     // Catch: java.lang.ClassCastException -> L77
            java.lang.String r3 = r8.f5039k     // Catch: java.lang.ClassCastException -> L77
            android.accounts.Account r4 = r8.f5036c     // Catch: java.lang.ClassCastException -> L77
            java.util.ArrayList r5 = r7.f5041m     // Catch: java.lang.ClassCastException -> L77
            boolean r5 = r5.isEmpty()     // Catch: java.lang.ClassCastException -> L77
            if (r5 == 0) goto L77
            java.util.ArrayList r5 = r8.f5041m     // Catch: java.lang.ClassCastException -> L77
            boolean r5 = r5.isEmpty()     // Catch: java.lang.ClassCastException -> L77
            if (r5 != 0) goto L1f
            goto L77
        L1f:
            int r5 = r1.size()     // Catch: java.lang.ClassCastException -> L77
            java.util.ArrayList r6 = r8.m()     // Catch: java.lang.ClassCastException -> L77
            int r6 = r6.size()     // Catch: java.lang.ClassCastException -> L77
            if (r5 != r6) goto L77
            java.util.ArrayList r5 = r8.m()     // Catch: java.lang.ClassCastException -> L77
            boolean r1 = r1.containsAll(r5)     // Catch: java.lang.ClassCastException -> L77
            if (r1 != 0) goto L38
            goto L77
        L38:
            android.accounts.Account r1 = r7.f5036c     // Catch: java.lang.ClassCastException -> L77
            if (r1 != 0) goto L3f
            if (r4 != 0) goto L77
            goto L45
        L3f:
            boolean r1 = r1.equals(r4)     // Catch: java.lang.ClassCastException -> L77
            if (r1 == 0) goto L77
        L45:
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.ClassCastException -> L77
            if (r1 == 0) goto L52
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.ClassCastException -> L77
            if (r0 == 0) goto L77
            goto L59
        L52:
            boolean r0 = r0.equals(r3)     // Catch: java.lang.ClassCastException -> L77
            if (r0 != 0) goto L59
            goto L77
        L59:
            boolean r0 = r7.f5038f     // Catch: java.lang.ClassCastException -> L77
            boolean r1 = r8.f5038f     // Catch: java.lang.ClassCastException -> L77
            if (r0 != r1) goto L77
            boolean r0 = r7.f5037d     // Catch: java.lang.ClassCastException -> L77
            boolean r1 = r8.f5037d     // Catch: java.lang.ClassCastException -> L77
            if (r0 != r1) goto L77
            boolean r0 = r7.e     // Catch: java.lang.ClassCastException -> L77
            boolean r1 = r8.e     // Catch: java.lang.ClassCastException -> L77
            if (r0 != r1) goto L77
            java.lang.String r0 = r7.f5042n     // Catch: java.lang.ClassCastException -> L77
            java.lang.String r8 = r8.f5042n     // Catch: java.lang.ClassCastException -> L77
            boolean r8 = android.text.TextUtils.equals(r0, r8)     // Catch: java.lang.ClassCastException -> L77
            if (r8 == 0) goto L77
            r8 = 1
            return r8
        L77:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.GoogleSignInOptions.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.f5035b;
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(((Scope) arrayList2.get(i)).f5057b);
        }
        Collections.sort(arrayList);
        int iHashCode = arrayList.hashCode() + (1 * 31);
        Account account = this.f5036c;
        int iHashCode2 = (iHashCode * 31) + (account == null ? 0 : account.hashCode());
        String str = this.f5039k;
        int iHashCode3 = (((((((iHashCode2 * 31) + (str == null ? 0 : str.hashCode())) * 31) + (this.f5038f ? 1 : 0)) * 31) + (this.f5037d ? 1 : 0)) * 31) + (this.e ? 1 : 0);
        String str2 = this.f5042n;
        return (iHashCode3 * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    public final ArrayList m() {
        return new ArrayList(this.f5035b);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iX = u0.X(20293, parcel);
        u0.b0(parcel, 1, 4);
        parcel.writeInt(this.f5034a);
        u0.W(parcel, 2, m(), false);
        u0.S(parcel, 3, this.f5036c, i, false);
        u0.b0(parcel, 4, 4);
        parcel.writeInt(this.f5037d ? 1 : 0);
        u0.b0(parcel, 5, 4);
        parcel.writeInt(this.e ? 1 : 0);
        u0.b0(parcel, 6, 4);
        parcel.writeInt(this.f5038f ? 1 : 0);
        u0.T(parcel, 7, this.f5039k, false);
        u0.T(parcel, 8, this.f5040l, false);
        u0.W(parcel, 9, this.f5041m, false);
        u0.T(parcel, 10, this.f5042n, false);
        u0.a0(iX, parcel);
    }
}
