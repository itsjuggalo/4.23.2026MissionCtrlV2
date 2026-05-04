package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.s;
import f5.e;
import f5.f;
import g5.b;
import io.flutter.plugins.firebase.auth.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import n5.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class GoogleSignInOptions extends n5.a implements a.d, ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final GoogleSignInOptions f5411l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final GoogleSignInOptions f5412m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Scope f5413n = new Scope("profile");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Scope f5414o = new Scope(Constants.EMAIL);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Scope f5415p = new Scope("openid");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Scope f5416q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Scope f5417r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Comparator f5418s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f5420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Account f5421c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f5422d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f5423e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f5424f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f5425g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f5426h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayList f5427i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f5428j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Map f5429k;

    static {
        Scope scope = new Scope("https://www.googleapis.com/auth/games_lite");
        f5416q = scope;
        f5417r = new Scope("https://www.googleapis.com/auth/games");
        a aVar = new a();
        aVar.b();
        aVar.c();
        f5411l = aVar.a();
        a aVar2 = new a();
        aVar2.d(scope, new Scope[0]);
        f5412m = aVar2.a();
        CREATOR = new f();
        f5418s = new e();
    }

    public /* synthetic */ GoogleSignInOptions(int i10, ArrayList arrayList, Account account, boolean z10, boolean z11, boolean z12, String str, String str2, Map map, String str3, byte[] bArr) {
        this(3, arrayList, account, z10, z11, z12, str, str2, map, str3);
    }

    public static GoogleSignInOptions Z(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            hashSet.add(new Scope(jSONArray.getString(i10)));
        }
        String strOptString = jSONObject.has("accountName") ? jSONObject.optString("accountName") : null;
        return new GoogleSignInOptions(3, new ArrayList(hashSet), !TextUtils.isEmpty(strOptString) ? new Account(strOptString, "com.google") : null, jSONObject.getBoolean("idTokenRequested"), jSONObject.getBoolean("serverAuthRequested"), jSONObject.getBoolean("forceCodeForRefreshToken"), jSONObject.has("serverClientId") ? jSONObject.optString("serverClientId") : null, jSONObject.has("hostedDomain") ? jSONObject.optString("hostedDomain") : null, new HashMap(), (String) null);
    }

    public static Map l0(List list) {
        HashMap map = new HashMap();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                g5.a aVar = (g5.a) it.next();
                map.put(Integer.valueOf(aVar.R()), aVar);
            }
        }
        return map;
    }

    public Account R() {
        return this.f5421c;
    }

    public ArrayList S() {
        return this.f5427i;
    }

    public String T() {
        return this.f5428j;
    }

    public ArrayList U() {
        return new ArrayList(this.f5420b);
    }

    public String V() {
        return this.f5425g;
    }

    public boolean W() {
        return this.f5424f;
    }

    public boolean X() {
        return this.f5422d;
    }

    public boolean Y() {
        return this.f5423e;
    }

    public final String a0() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            ArrayList arrayList = this.f5420b;
            Collections.sort(arrayList, f5418s);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                jSONArray.put(((Scope) it.next()).R());
            }
            jSONObject.put("scopes", jSONArray);
            Account account = this.f5421c;
            if (account != null) {
                jSONObject.put("accountName", account.name);
            }
            jSONObject.put("idTokenRequested", this.f5422d);
            jSONObject.put("forceCodeForRefreshToken", this.f5424f);
            jSONObject.put("serverAuthRequested", this.f5423e);
            if (!TextUtils.isEmpty(this.f5425g)) {
                jSONObject.put("serverClientId", this.f5425g);
            }
            if (!TextUtils.isEmpty(this.f5426h)) {
                jSONObject.put("hostedDomain", this.f5426h);
            }
            return jSONObject.toString();
        } catch (JSONException e10) {
            throw new RuntimeException(e10);
        }
    }

    public final /* synthetic */ ArrayList c0() {
        return this.f5420b;
    }

    public final /* synthetic */ Account d0() {
        return this.f5421c;
    }

    public final /* synthetic */ boolean e0() {
        return this.f5422d;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0050 A[Catch: ClassCastException -> 0x008e, TryCatch #0 {ClassCastException -> 0x008e, blocks: (B:5:0x0004, B:7:0x000e, B:10:0x0018, B:12:0x0028, B:15:0x0033, B:17:0x0037, B:22:0x0048, B:24:0x0050, B:30:0x0068, B:32:0x0070, B:34:0x0078, B:36:0x0080, B:27:0x005b, B:20:0x003e), top: B:42:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005b A[Catch: ClassCastException -> 0x008e, TryCatch #0 {ClassCastException -> 0x008e, blocks: (B:5:0x0004, B:7:0x000e, B:10:0x0018, B:12:0x0028, B:15:0x0033, B:17:0x0037, B:22:0x0048, B:24:0x0050, B:30:0x0068, B:32:0x0070, B:34:0x0078, B:36:0x0080, B:27:0x005b, B:20:0x003e), top: B:42:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008c A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L4
            return r0
        L4:
            com.google.android.gms.auth.api.signin.GoogleSignInOptions r5 = (com.google.android.gms.auth.api.signin.GoogleSignInOptions) r5     // Catch: java.lang.ClassCastException -> L8e
            java.util.ArrayList r1 = r4.f5427i     // Catch: java.lang.ClassCastException -> L8e
            boolean r1 = r1.isEmpty()     // Catch: java.lang.ClassCastException -> L8e
            if (r1 == 0) goto L8e
            java.util.ArrayList r1 = r5.f5427i     // Catch: java.lang.ClassCastException -> L8e
            boolean r1 = r1.isEmpty()     // Catch: java.lang.ClassCastException -> L8e
            if (r1 != 0) goto L18
            goto L8e
        L18:
            java.util.ArrayList r1 = r4.f5420b     // Catch: java.lang.ClassCastException -> L8e
            int r2 = r1.size()     // Catch: java.lang.ClassCastException -> L8e
            java.util.ArrayList r3 = r5.U()     // Catch: java.lang.ClassCastException -> L8e
            int r3 = r3.size()     // Catch: java.lang.ClassCastException -> L8e
            if (r2 != r3) goto L8e
            java.util.ArrayList r2 = r5.U()     // Catch: java.lang.ClassCastException -> L8e
            boolean r1 = r1.containsAll(r2)     // Catch: java.lang.ClassCastException -> L8e
            if (r1 != 0) goto L33
            goto L8e
        L33:
            android.accounts.Account r1 = r4.f5421c     // Catch: java.lang.ClassCastException -> L8e
            if (r1 != 0) goto L3e
            android.accounts.Account r1 = r5.R()     // Catch: java.lang.ClassCastException -> L8e
            if (r1 != 0) goto L8e
            goto L48
        L3e:
            android.accounts.Account r2 = r5.R()     // Catch: java.lang.ClassCastException -> L8e
            boolean r1 = r1.equals(r2)     // Catch: java.lang.ClassCastException -> L8e
            if (r1 == 0) goto L8e
        L48:
            java.lang.String r1 = r4.f5425g     // Catch: java.lang.ClassCastException -> L8e
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.ClassCastException -> L8e
            if (r1 == 0) goto L5b
            java.lang.String r1 = r5.V()     // Catch: java.lang.ClassCastException -> L8e
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.ClassCastException -> L8e
            if (r1 == 0) goto L8e
            goto L68
        L5b:
            java.lang.String r1 = r4.f5425g     // Catch: java.lang.ClassCastException -> L8e
            java.lang.String r2 = r5.V()     // Catch: java.lang.ClassCastException -> L8e
            boolean r1 = r1.equals(r2)     // Catch: java.lang.ClassCastException -> L8e
            if (r1 != 0) goto L68
            goto L8e
        L68:
            boolean r1 = r4.f5424f     // Catch: java.lang.ClassCastException -> L8e
            boolean r2 = r5.W()     // Catch: java.lang.ClassCastException -> L8e
            if (r1 != r2) goto L8e
            boolean r1 = r4.f5422d     // Catch: java.lang.ClassCastException -> L8e
            boolean r2 = r5.X()     // Catch: java.lang.ClassCastException -> L8e
            if (r1 != r2) goto L8e
            boolean r1 = r4.f5423e     // Catch: java.lang.ClassCastException -> L8e
            boolean r2 = r5.Y()     // Catch: java.lang.ClassCastException -> L8e
            if (r1 != r2) goto L8e
            java.lang.String r1 = r4.f5428j     // Catch: java.lang.ClassCastException -> L8e
            java.lang.String r5 = r5.T()     // Catch: java.lang.ClassCastException -> L8e
            boolean r5 = android.text.TextUtils.equals(r1, r5)     // Catch: java.lang.ClassCastException -> L8e
            if (r5 == 0) goto L8e
            r5 = 1
            return r5
        L8e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.GoogleSignInOptions.equals(java.lang.Object):boolean");
    }

    public final /* synthetic */ boolean f0() {
        return this.f5423e;
    }

    public final /* synthetic */ boolean g0() {
        return this.f5424f;
    }

    public final /* synthetic */ String h0() {
        return this.f5425g;
    }

    public int hashCode() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.f5420b;
        int size = arrayList2.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.add(((Scope) arrayList2.get(i10)).R());
        }
        Collections.sort(arrayList);
        b bVar = new b();
        bVar.a(arrayList);
        bVar.a(this.f5421c);
        bVar.a(this.f5425g);
        bVar.c(this.f5424f);
        bVar.c(this.f5422d);
        bVar.c(this.f5423e);
        bVar.a(this.f5428j);
        return bVar.b();
    }

    public final /* synthetic */ String i0() {
        return this.f5426h;
    }

    public final /* synthetic */ ArrayList j0() {
        return this.f5427i;
    }

    public final /* synthetic */ String k0() {
        return this.f5428j;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int i11 = this.f5419a;
        int iA = c.a(parcel);
        c.t(parcel, 1, i11);
        c.I(parcel, 2, U(), false);
        c.C(parcel, 3, R(), i10, false);
        c.g(parcel, 4, X());
        c.g(parcel, 5, Y());
        c.g(parcel, 6, W());
        c.E(parcel, 7, V(), false);
        c.E(parcel, 8, this.f5426h, false);
        c.I(parcel, 9, S(), false);
        c.E(parcel, 10, T(), false);
        c.b(parcel, iA);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Set f5430a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f5431b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f5432c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f5433d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f5434e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Account f5435f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f5436g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Map f5437h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f5438i;

        public a() {
            this.f5430a = new HashSet();
            this.f5437h = new HashMap();
        }

        public GoogleSignInOptions a() {
            if (this.f5430a.contains(GoogleSignInOptions.f5417r)) {
                Set set = this.f5430a;
                Scope scope = GoogleSignInOptions.f5416q;
                if (set.contains(scope)) {
                    this.f5430a.remove(scope);
                }
            }
            if (this.f5433d && (this.f5435f == null || !this.f5430a.isEmpty())) {
                b();
            }
            return new GoogleSignInOptions(3, new ArrayList(this.f5430a), this.f5435f, this.f5433d, this.f5431b, this.f5432c, this.f5434e, this.f5436g, this.f5437h, this.f5438i, null);
        }

        public a b() {
            this.f5430a.add(GoogleSignInOptions.f5415p);
            return this;
        }

        public a c() {
            this.f5430a.add(GoogleSignInOptions.f5413n);
            return this;
        }

        public a d(Scope scope, Scope... scopeArr) {
            this.f5430a.add(scope);
            this.f5430a.addAll(Arrays.asList(scopeArr));
            return this;
        }

        public a e(String str) {
            this.f5438i = str;
            return this;
        }

        public a(GoogleSignInOptions googleSignInOptions) {
            this.f5430a = new HashSet();
            this.f5437h = new HashMap();
            s.k(googleSignInOptions);
            this.f5430a = new HashSet(googleSignInOptions.c0());
            this.f5431b = googleSignInOptions.f0();
            this.f5432c = googleSignInOptions.g0();
            this.f5433d = googleSignInOptions.e0();
            this.f5434e = googleSignInOptions.h0();
            this.f5435f = googleSignInOptions.d0();
            this.f5436g = googleSignInOptions.i0();
            this.f5437h = GoogleSignInOptions.l0(googleSignInOptions.j0());
            this.f5438i = googleSignInOptions.k0();
        }
    }

    public GoogleSignInOptions(int i10, ArrayList arrayList, Account account, boolean z10, boolean z11, boolean z12, String str, String str2, ArrayList arrayList2, String str3) {
        this(i10, arrayList, account, z10, z11, z12, str, str2, l0(arrayList2), str3);
    }

    public GoogleSignInOptions(int i10, ArrayList arrayList, Account account, boolean z10, boolean z11, boolean z12, String str, String str2, Map map, String str3) {
        this.f5419a = i10;
        this.f5420b = arrayList;
        this.f5421c = account;
        this.f5422d = z10;
        this.f5423e = z11;
        this.f5424f = z12;
        this.f5425g = str;
        this.f5426h = str2;
        this.f5427i = new ArrayList(map.values());
        this.f5429k = map;
        this.f5428j = str3;
    }
}
