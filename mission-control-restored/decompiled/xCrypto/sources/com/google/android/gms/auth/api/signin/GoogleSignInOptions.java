package com.google.android.gms.auth.api.signin;

import A1.c;
import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.common.internal.ReflectedParcelable;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import u1.C1867f;
import u1.h;
import v1.C1883a;
import v1.C1884b;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class GoogleSignInOptions extends A1.a implements a.d, ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final GoogleSignInOptions f9609l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final GoogleSignInOptions f9610m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Scope f9611n = new Scope("profile");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Scope f9612o = new Scope(Constants.EMAIL);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Scope f9613p = new Scope("openid");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Scope f9614q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Scope f9615r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Comparator f9616s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f9618b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Account f9619c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f9620d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f9621e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f9622f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f9623g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f9624h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayList f9625i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f9626j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Map f9627k;

    static {
        Scope scope = new Scope("https://www.googleapis.com/auth/games_lite");
        f9614q = scope;
        f9615r = new Scope("https://www.googleapis.com/auth/games");
        a aVar = new a();
        aVar.c();
        aVar.e();
        f9609l = aVar.a();
        a aVar2 = new a();
        aVar2.f(scope, new Scope[0]);
        f9610m = aVar2.a();
        CREATOR = new h();
        f9616s = new C1867f();
    }

    public static Map D(List list) {
        HashMap map = new HashMap();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                C1883a c1883a = (C1883a) it.next();
                map.put(Integer.valueOf(c1883a.i()), c1883a);
            }
        }
        return map;
    }

    public static GoogleSignInOptions s(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i4 = 0; i4 < length; i4++) {
            hashSet.add(new Scope(jSONArray.getString(i4)));
        }
        String strOptString = jSONObject.has("accountName") ? jSONObject.optString("accountName") : null;
        return new GoogleSignInOptions(3, new ArrayList(hashSet), !TextUtils.isEmpty(strOptString) ? new Account(strOptString, "com.google") : null, jSONObject.getBoolean("idTokenRequested"), jSONObject.getBoolean("serverAuthRequested"), jSONObject.getBoolean("forceCodeForRefreshToken"), jSONObject.has("serverClientId") ? jSONObject.optString("serverClientId") : null, jSONObject.has("hostedDomain") ? jSONObject.optString("hostedDomain") : null, new HashMap(), (String) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0052 A[Catch: ClassCastException -> 0x0090, TryCatch #0 {ClassCastException -> 0x0090, blocks: (B:5:0x0004, B:7:0x000e, B:10:0x0018, B:12:0x0028, B:15:0x0035, B:17:0x0039, B:22:0x004a, B:24:0x0052, B:30:0x006a, B:32:0x0072, B:34:0x007a, B:36:0x0082, B:27:0x005d, B:20:0x0040), top: B:42:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005d A[Catch: ClassCastException -> 0x0090, TryCatch #0 {ClassCastException -> 0x0090, blocks: (B:5:0x0004, B:7:0x000e, B:10:0x0018, B:12:0x0028, B:15:0x0035, B:17:0x0039, B:22:0x004a, B:24:0x0052, B:30:0x006a, B:32:0x0072, B:34:0x007a, B:36:0x0082, B:27:0x005d, B:20:0x0040), top: B:42:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008e A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            com.google.android.gms.auth.api.signin.GoogleSignInOptions r4 = (com.google.android.gms.auth.api.signin.GoogleSignInOptions) r4     // Catch: java.lang.ClassCastException -> L90
            java.util.ArrayList r1 = r3.f9625i     // Catch: java.lang.ClassCastException -> L90
            boolean r1 = r1.isEmpty()     // Catch: java.lang.ClassCastException -> L90
            if (r1 == 0) goto L90
            java.util.ArrayList r1 = r4.f9625i     // Catch: java.lang.ClassCastException -> L90
            boolean r1 = r1.isEmpty()     // Catch: java.lang.ClassCastException -> L90
            if (r1 != 0) goto L18
            goto L90
        L18:
            java.util.ArrayList r1 = r3.f9618b     // Catch: java.lang.ClassCastException -> L90
            int r1 = r1.size()     // Catch: java.lang.ClassCastException -> L90
            java.util.ArrayList r2 = r4.m()     // Catch: java.lang.ClassCastException -> L90
            int r2 = r2.size()     // Catch: java.lang.ClassCastException -> L90
            if (r1 != r2) goto L90
            java.util.ArrayList r1 = r3.f9618b     // Catch: java.lang.ClassCastException -> L90
            java.util.ArrayList r2 = r4.m()     // Catch: java.lang.ClassCastException -> L90
            boolean r1 = r1.containsAll(r2)     // Catch: java.lang.ClassCastException -> L90
            if (r1 != 0) goto L35
            goto L90
        L35:
            android.accounts.Account r1 = r3.f9619c     // Catch: java.lang.ClassCastException -> L90
            if (r1 != 0) goto L40
            android.accounts.Account r1 = r4.i()     // Catch: java.lang.ClassCastException -> L90
            if (r1 != 0) goto L90
            goto L4a
        L40:
            android.accounts.Account r2 = r4.i()     // Catch: java.lang.ClassCastException -> L90
            boolean r1 = r1.equals(r2)     // Catch: java.lang.ClassCastException -> L90
            if (r1 == 0) goto L90
        L4a:
            java.lang.String r1 = r3.f9623g     // Catch: java.lang.ClassCastException -> L90
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.ClassCastException -> L90
            if (r1 == 0) goto L5d
            java.lang.String r1 = r4.n()     // Catch: java.lang.ClassCastException -> L90
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.ClassCastException -> L90
            if (r1 == 0) goto L90
            goto L6a
        L5d:
            java.lang.String r1 = r3.f9623g     // Catch: java.lang.ClassCastException -> L90
            java.lang.String r2 = r4.n()     // Catch: java.lang.ClassCastException -> L90
            boolean r1 = r1.equals(r2)     // Catch: java.lang.ClassCastException -> L90
            if (r1 != 0) goto L6a
            goto L90
        L6a:
            boolean r1 = r3.f9622f     // Catch: java.lang.ClassCastException -> L90
            boolean r2 = r4.o()     // Catch: java.lang.ClassCastException -> L90
            if (r1 != r2) goto L90
            boolean r1 = r3.f9620d     // Catch: java.lang.ClassCastException -> L90
            boolean r2 = r4.p()     // Catch: java.lang.ClassCastException -> L90
            if (r1 != r2) goto L90
            boolean r1 = r3.f9621e     // Catch: java.lang.ClassCastException -> L90
            boolean r2 = r4.q()     // Catch: java.lang.ClassCastException -> L90
            if (r1 != r2) goto L90
            java.lang.String r1 = r3.f9626j     // Catch: java.lang.ClassCastException -> L90
            java.lang.String r4 = r4.l()     // Catch: java.lang.ClassCastException -> L90
            boolean r4 = android.text.TextUtils.equals(r1, r4)     // Catch: java.lang.ClassCastException -> L90
            if (r4 == 0) goto L90
            r4 = 1
            return r4
        L90:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.GoogleSignInOptions.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.f9618b;
        int size = arrayList2.size();
        for (int i4 = 0; i4 < size; i4++) {
            arrayList.add(((Scope) arrayList2.get(i4)).i());
        }
        Collections.sort(arrayList);
        C1884b c1884b = new C1884b();
        c1884b.a(arrayList);
        c1884b.a(this.f9619c);
        c1884b.a(this.f9623g);
        c1884b.c(this.f9622f);
        c1884b.c(this.f9620d);
        c1884b.c(this.f9621e);
        c1884b.a(this.f9626j);
        return c1884b.b();
    }

    public Account i() {
        return this.f9619c;
    }

    public ArrayList k() {
        return this.f9625i;
    }

    public String l() {
        return this.f9626j;
    }

    public ArrayList m() {
        return new ArrayList(this.f9618b);
    }

    public String n() {
        return this.f9623g;
    }

    public boolean o() {
        return this.f9622f;
    }

    public boolean p() {
        return this.f9620d;
    }

    public boolean q() {
        return this.f9621e;
    }

    public final String w() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.f9618b, f9616s);
            Iterator it = this.f9618b.iterator();
            while (it.hasNext()) {
                jSONArray.put(((Scope) it.next()).i());
            }
            jSONObject.put("scopes", jSONArray);
            Account account = this.f9619c;
            if (account != null) {
                jSONObject.put("accountName", account.name);
            }
            jSONObject.put("idTokenRequested", this.f9620d);
            jSONObject.put("forceCodeForRefreshToken", this.f9622f);
            jSONObject.put("serverAuthRequested", this.f9621e);
            if (!TextUtils.isEmpty(this.f9623g)) {
                jSONObject.put("serverClientId", this.f9623g);
            }
            if (!TextUtils.isEmpty(this.f9624h)) {
                jSONObject.put("hostedDomain", this.f9624h);
            }
            return jSONObject.toString();
        } catch (JSONException e4) {
            throw new RuntimeException(e4);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int i5 = this.f9617a;
        int iA = c.a(parcel);
        c.t(parcel, 1, i5);
        c.I(parcel, 2, m(), false);
        c.C(parcel, 3, i(), i4, false);
        c.g(parcel, 4, p());
        c.g(parcel, 5, q());
        c.g(parcel, 6, o());
        c.E(parcel, 7, n(), false);
        c.E(parcel, 8, this.f9624h, false);
        c.I(parcel, 9, k(), false);
        c.E(parcel, 10, l(), false);
        c.b(parcel, iA);
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Set f9628a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f9629b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f9630c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f9631d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f9632e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Account f9633f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f9634g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Map f9635h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f9636i;

        public a() {
            this.f9628a = new HashSet();
            this.f9635h = new HashMap();
        }

        public GoogleSignInOptions a() {
            if (this.f9628a.contains(GoogleSignInOptions.f9615r)) {
                Set set = this.f9628a;
                Scope scope = GoogleSignInOptions.f9614q;
                if (set.contains(scope)) {
                    this.f9628a.remove(scope);
                }
            }
            if (this.f9631d && (this.f9633f == null || !this.f9628a.isEmpty())) {
                c();
            }
            return new GoogleSignInOptions(new ArrayList(this.f9628a), this.f9633f, this.f9631d, this.f9629b, this.f9630c, this.f9632e, this.f9634g, this.f9635h, this.f9636i);
        }

        public a b() {
            this.f9628a.add(GoogleSignInOptions.f9612o);
            return this;
        }

        public a c() {
            this.f9628a.add(GoogleSignInOptions.f9613p);
            return this;
        }

        public a d(String str) {
            this.f9631d = true;
            k(str);
            this.f9632e = str;
            return this;
        }

        public a e() {
            this.f9628a.add(GoogleSignInOptions.f9611n);
            return this;
        }

        public a f(Scope scope, Scope... scopeArr) {
            this.f9628a.add(scope);
            this.f9628a.addAll(Arrays.asList(scopeArr));
            return this;
        }

        public a g(String str, boolean z4) {
            this.f9629b = true;
            k(str);
            this.f9632e = str;
            this.f9630c = z4;
            return this;
        }

        public a h(String str) {
            this.f9633f = new Account(AbstractC0940s.e(str), "com.google");
            return this;
        }

        public a i(String str) {
            this.f9634g = AbstractC0940s.e(str);
            return this;
        }

        public a j(String str) {
            this.f9636i = str;
            return this;
        }

        public final String k(String str) {
            AbstractC0940s.e(str);
            String str2 = this.f9632e;
            boolean z4 = true;
            if (str2 != null && !str2.equals(str)) {
                z4 = false;
            }
            AbstractC0940s.b(z4, "two different server client ids provided");
            return str;
        }

        public a(GoogleSignInOptions googleSignInOptions) {
            this.f9628a = new HashSet();
            this.f9635h = new HashMap();
            AbstractC0940s.k(googleSignInOptions);
            this.f9628a = new HashSet(googleSignInOptions.f9618b);
            this.f9629b = googleSignInOptions.f9621e;
            this.f9630c = googleSignInOptions.f9622f;
            this.f9631d = googleSignInOptions.f9620d;
            this.f9632e = googleSignInOptions.f9623g;
            this.f9633f = googleSignInOptions.f9619c;
            this.f9634g = googleSignInOptions.f9624h;
            this.f9635h = GoogleSignInOptions.D(googleSignInOptions.f9625i);
            this.f9636i = googleSignInOptions.f9626j;
        }
    }

    public GoogleSignInOptions(int i4, ArrayList arrayList, Account account, boolean z4, boolean z5, boolean z6, String str, String str2, ArrayList arrayList2, String str3) {
        this(i4, arrayList, account, z4, z5, z6, str, str2, D(arrayList2), str3);
    }

    public GoogleSignInOptions(int i4, ArrayList arrayList, Account account, boolean z4, boolean z5, boolean z6, String str, String str2, Map map, String str3) {
        this.f9617a = i4;
        this.f9618b = arrayList;
        this.f9619c = account;
        this.f9620d = z4;
        this.f9621e = z5;
        this.f9622f = z6;
        this.f9623g = str;
        this.f9624h = str2;
        this.f9625i = new ArrayList(map.values());
        this.f9627k = map;
        this.f9626j = str3;
    }
}
