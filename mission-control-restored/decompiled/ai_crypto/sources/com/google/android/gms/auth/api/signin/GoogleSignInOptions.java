package com.google.android.gms.auth.api.signin;

import L1.f;
import L1.h;
import M1.C0638a;
import M1.b;
import Q1.c;
import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.common.internal.ReflectedParcelable;
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

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class GoogleSignInOptions extends Q1.a implements a.d, ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final GoogleSignInOptions f10794l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final GoogleSignInOptions f10795m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Scope f10796n = new Scope("profile");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Scope f10797o = new Scope("email");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Scope f10798p = new Scope("openid");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Scope f10799q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Scope f10800r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Comparator f10801s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f10803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Account f10804c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f10805d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f10806e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f10807f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f10808g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f10809h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayList f10810i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f10811j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Map f10812k;

    static {
        Scope scope = new Scope("https://www.googleapis.com/auth/games_lite");
        f10799q = scope;
        f10800r = new Scope("https://www.googleapis.com/auth/games");
        a aVar = new a();
        aVar.c();
        aVar.e();
        f10794l = aVar.a();
        a aVar2 = new a();
        aVar2.f(scope, new Scope[0]);
        f10795m = aVar2.a();
        CREATOR = new h();
        f10801s = new f();
    }

    public static GoogleSignInOptions J(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i7 = 0; i7 < length; i7++) {
            hashSet.add(new Scope(jSONArray.getString(i7)));
        }
        String strOptString = jSONObject.has("accountName") ? jSONObject.optString("accountName") : null;
        return new GoogleSignInOptions(3, new ArrayList(hashSet), !TextUtils.isEmpty(strOptString) ? new Account(strOptString, "com.google") : null, jSONObject.getBoolean("idTokenRequested"), jSONObject.getBoolean("serverAuthRequested"), jSONObject.getBoolean("forceCodeForRefreshToken"), jSONObject.has("serverClientId") ? jSONObject.optString("serverClientId") : null, jSONObject.has("hostedDomain") ? jSONObject.optString("hostedDomain") : null, new HashMap(), (String) null);
    }

    public static Map U(List list) {
        HashMap map = new HashMap();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                C0638a c0638a = (C0638a) it.next();
                map.put(Integer.valueOf(c0638a.A()), c0638a);
            }
        }
        return map;
    }

    public Account A() {
        return this.f10804c;
    }

    public ArrayList B() {
        return this.f10810i;
    }

    public String C() {
        return this.f10811j;
    }

    public ArrayList D() {
        return new ArrayList(this.f10803b);
    }

    public String E() {
        return this.f10808g;
    }

    public boolean F() {
        return this.f10807f;
    }

    public boolean G() {
        return this.f10805d;
    }

    public boolean H() {
        return this.f10806e;
    }

    public final String N() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.f10803b, f10801s);
            Iterator it = this.f10803b.iterator();
            while (it.hasNext()) {
                jSONArray.put(((Scope) it.next()).A());
            }
            jSONObject.put("scopes", jSONArray);
            Account account = this.f10804c;
            if (account != null) {
                jSONObject.put("accountName", account.name);
            }
            jSONObject.put("idTokenRequested", this.f10805d);
            jSONObject.put("forceCodeForRefreshToken", this.f10807f);
            jSONObject.put("serverAuthRequested", this.f10806e);
            if (!TextUtils.isEmpty(this.f10808g)) {
                jSONObject.put("serverClientId", this.f10808g);
            }
            if (!TextUtils.isEmpty(this.f10809h)) {
                jSONObject.put("hostedDomain", this.f10809h);
            }
            return jSONObject.toString();
        } catch (JSONException e7) {
            throw new RuntimeException(e7);
        }
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
            java.util.ArrayList r1 = r3.f10810i     // Catch: java.lang.ClassCastException -> L90
            boolean r1 = r1.isEmpty()     // Catch: java.lang.ClassCastException -> L90
            if (r1 == 0) goto L90
            java.util.ArrayList r1 = r4.f10810i     // Catch: java.lang.ClassCastException -> L90
            boolean r1 = r1.isEmpty()     // Catch: java.lang.ClassCastException -> L90
            if (r1 != 0) goto L18
            goto L90
        L18:
            java.util.ArrayList r1 = r3.f10803b     // Catch: java.lang.ClassCastException -> L90
            int r1 = r1.size()     // Catch: java.lang.ClassCastException -> L90
            java.util.ArrayList r2 = r4.D()     // Catch: java.lang.ClassCastException -> L90
            int r2 = r2.size()     // Catch: java.lang.ClassCastException -> L90
            if (r1 != r2) goto L90
            java.util.ArrayList r1 = r3.f10803b     // Catch: java.lang.ClassCastException -> L90
            java.util.ArrayList r2 = r4.D()     // Catch: java.lang.ClassCastException -> L90
            boolean r1 = r1.containsAll(r2)     // Catch: java.lang.ClassCastException -> L90
            if (r1 != 0) goto L35
            goto L90
        L35:
            android.accounts.Account r1 = r3.f10804c     // Catch: java.lang.ClassCastException -> L90
            if (r1 != 0) goto L40
            android.accounts.Account r1 = r4.A()     // Catch: java.lang.ClassCastException -> L90
            if (r1 != 0) goto L90
            goto L4a
        L40:
            android.accounts.Account r2 = r4.A()     // Catch: java.lang.ClassCastException -> L90
            boolean r1 = r1.equals(r2)     // Catch: java.lang.ClassCastException -> L90
            if (r1 == 0) goto L90
        L4a:
            java.lang.String r1 = r3.f10808g     // Catch: java.lang.ClassCastException -> L90
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.ClassCastException -> L90
            if (r1 == 0) goto L5d
            java.lang.String r1 = r4.E()     // Catch: java.lang.ClassCastException -> L90
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.ClassCastException -> L90
            if (r1 == 0) goto L90
            goto L6a
        L5d:
            java.lang.String r1 = r3.f10808g     // Catch: java.lang.ClassCastException -> L90
            java.lang.String r2 = r4.E()     // Catch: java.lang.ClassCastException -> L90
            boolean r1 = r1.equals(r2)     // Catch: java.lang.ClassCastException -> L90
            if (r1 != 0) goto L6a
            goto L90
        L6a:
            boolean r1 = r3.f10807f     // Catch: java.lang.ClassCastException -> L90
            boolean r2 = r4.F()     // Catch: java.lang.ClassCastException -> L90
            if (r1 != r2) goto L90
            boolean r1 = r3.f10805d     // Catch: java.lang.ClassCastException -> L90
            boolean r2 = r4.G()     // Catch: java.lang.ClassCastException -> L90
            if (r1 != r2) goto L90
            boolean r1 = r3.f10806e     // Catch: java.lang.ClassCastException -> L90
            boolean r2 = r4.H()     // Catch: java.lang.ClassCastException -> L90
            if (r1 != r2) goto L90
            java.lang.String r1 = r3.f10811j     // Catch: java.lang.ClassCastException -> L90
            java.lang.String r4 = r4.C()     // Catch: java.lang.ClassCastException -> L90
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
        ArrayList arrayList2 = this.f10803b;
        int size = arrayList2.size();
        for (int i7 = 0; i7 < size; i7++) {
            arrayList.add(((Scope) arrayList2.get(i7)).A());
        }
        Collections.sort(arrayList);
        b bVar = new b();
        bVar.a(arrayList);
        bVar.a(this.f10804c);
        bVar.a(this.f10808g);
        bVar.c(this.f10807f);
        bVar.c(this.f10805d);
        bVar.c(this.f10806e);
        bVar.a(this.f10811j);
        return bVar.b();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int i8 = this.f10802a;
        int iA = c.a(parcel);
        c.t(parcel, 1, i8);
        c.I(parcel, 2, D(), false);
        c.C(parcel, 3, A(), i7, false);
        c.g(parcel, 4, G());
        c.g(parcel, 5, H());
        c.g(parcel, 6, F());
        c.E(parcel, 7, E(), false);
        c.E(parcel, 8, this.f10809h, false);
        c.I(parcel, 9, B(), false);
        c.E(parcel, 10, C(), false);
        c.b(parcel, iA);
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Set f10813a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f10814b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f10815c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f10816d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f10817e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Account f10818f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f10819g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Map f10820h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f10821i;

        public a() {
            this.f10813a = new HashSet();
            this.f10820h = new HashMap();
        }

        public GoogleSignInOptions a() {
            if (this.f10813a.contains(GoogleSignInOptions.f10800r)) {
                Set set = this.f10813a;
                Scope scope = GoogleSignInOptions.f10799q;
                if (set.contains(scope)) {
                    this.f10813a.remove(scope);
                }
            }
            if (this.f10816d && (this.f10818f == null || !this.f10813a.isEmpty())) {
                c();
            }
            return new GoogleSignInOptions(new ArrayList(this.f10813a), this.f10818f, this.f10816d, this.f10814b, this.f10815c, this.f10817e, this.f10819g, this.f10820h, this.f10821i);
        }

        public a b() {
            this.f10813a.add(GoogleSignInOptions.f10797o);
            return this;
        }

        public a c() {
            this.f10813a.add(GoogleSignInOptions.f10798p);
            return this;
        }

        public a d(String str) {
            this.f10816d = true;
            k(str);
            this.f10817e = str;
            return this;
        }

        public a e() {
            this.f10813a.add(GoogleSignInOptions.f10796n);
            return this;
        }

        public a f(Scope scope, Scope... scopeArr) {
            this.f10813a.add(scope);
            this.f10813a.addAll(Arrays.asList(scopeArr));
            return this;
        }

        public a g(String str, boolean z7) {
            this.f10814b = true;
            k(str);
            this.f10817e = str;
            this.f10815c = z7;
            return this;
        }

        public a h(String str) {
            this.f10818f = new Account(AbstractC1207s.e(str), "com.google");
            return this;
        }

        public a i(String str) {
            this.f10819g = AbstractC1207s.e(str);
            return this;
        }

        public a j(String str) {
            this.f10821i = str;
            return this;
        }

        public final String k(String str) {
            AbstractC1207s.e(str);
            String str2 = this.f10817e;
            boolean z7 = true;
            if (str2 != null && !str2.equals(str)) {
                z7 = false;
            }
            AbstractC1207s.b(z7, "two different server client ids provided");
            return str;
        }

        public a(GoogleSignInOptions googleSignInOptions) {
            this.f10813a = new HashSet();
            this.f10820h = new HashMap();
            AbstractC1207s.k(googleSignInOptions);
            this.f10813a = new HashSet(googleSignInOptions.f10803b);
            this.f10814b = googleSignInOptions.f10806e;
            this.f10815c = googleSignInOptions.f10807f;
            this.f10816d = googleSignInOptions.f10805d;
            this.f10817e = googleSignInOptions.f10808g;
            this.f10818f = googleSignInOptions.f10804c;
            this.f10819g = googleSignInOptions.f10809h;
            this.f10820h = GoogleSignInOptions.U(googleSignInOptions.f10810i);
            this.f10821i = googleSignInOptions.f10811j;
        }
    }

    public GoogleSignInOptions(int i7, ArrayList arrayList, Account account, boolean z7, boolean z8, boolean z9, String str, String str2, ArrayList arrayList2, String str3) {
        this(i7, arrayList, account, z7, z8, z9, str, str2, U(arrayList2), str3);
    }

    public GoogleSignInOptions(int i7, ArrayList arrayList, Account account, boolean z7, boolean z8, boolean z9, String str, String str2, Map map, String str3) {
        this.f10802a = i7;
        this.f10803b = arrayList;
        this.f10804c = account;
        this.f10805d = z7;
        this.f10806e = z8;
        this.f10807f = z9;
        this.f10808g = str;
        this.f10809h = str2;
        this.f10810i = new ArrayList(map.values());
        this.f10812k = map;
        this.f10811j = str3;
    }
}
