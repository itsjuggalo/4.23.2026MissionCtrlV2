package s1;

import android.accounts.Account;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.I;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: s1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0985b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReentrantLock f9505c = new ReentrantLock();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static C0985b f9506d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReentrantLock f9507a = new ReentrantLock();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SharedPreferences f9508b;

    public C0985b(Context context) {
        this.f9508b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static C0985b a(Context context) {
        I.g(context);
        ReentrantLock reentrantLock = f9505c;
        reentrantLock.lock();
        try {
            if (f9506d == null) {
                f9506d = new C0985b(context.getApplicationContext());
            }
            C0985b c0985b = f9506d;
            reentrantLock.unlock();
            return c0985b;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public static final String f(String str, String str2) {
        return a3.d.k(str, ":", str2);
    }

    public final GoogleSignInAccount b() {
        String strD;
        String strD2 = d("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(strD2) || (strD = d(f("googleSignInAccount", strD2))) == null) {
            return null;
        }
        try {
            return GoogleSignInAccount.m(strD);
        } catch (JSONException unused) {
            return null;
        }
    }

    public final void c(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        I.g(googleSignInAccount);
        I.g(googleSignInOptions);
        String str = googleSignInAccount.f5022m;
        e("defaultGoogleSignInAccount", str);
        String strF = f("googleSignInAccount", str);
        JSONObject jSONObject = new JSONObject();
        try {
            String str2 = googleSignInAccount.f5016b;
            if (str2 != null) {
                jSONObject.put("id", str2);
            }
            String str3 = googleSignInAccount.f5017c;
            if (str3 != null) {
                jSONObject.put("tokenId", str3);
            }
            String str4 = googleSignInAccount.f5018d;
            if (str4 != null) {
                jSONObject.put("email", str4);
            }
            String str5 = googleSignInAccount.e;
            if (str5 != null) {
                jSONObject.put("displayName", str5);
            }
            String str6 = googleSignInAccount.f5024o;
            if (str6 != null) {
                jSONObject.put("givenName", str6);
            }
            String str7 = googleSignInAccount.f5025p;
            if (str7 != null) {
                jSONObject.put("familyName", str7);
            }
            Uri uri = googleSignInAccount.f5019f;
            if (uri != null) {
                jSONObject.put("photoUrl", uri.toString());
            }
            String str8 = googleSignInAccount.f5020k;
            if (str8 != null) {
                jSONObject.put("serverAuthCode", str8);
            }
            jSONObject.put("expirationTime", googleSignInAccount.f5021l);
            jSONObject.put("obfuscatedIdentifier", str);
            JSONArray jSONArray = new JSONArray();
            ArrayList arrayList = googleSignInAccount.f5023n;
            Scope[] scopeArr = (Scope[]) arrayList.toArray(new Scope[arrayList.size()]);
            Arrays.sort(scopeArr, r1.d.f9454b);
            for (Scope scope : scopeArr) {
                jSONArray.put(scope.f5057b);
            }
            jSONObject.put("grantedScopes", jSONArray);
            jSONObject.remove("serverAuthCode");
            e(strF, jSONObject.toString());
            String strF2 = f("googleSignInOptions", str);
            String str9 = googleSignInOptions.f5040l;
            String str10 = googleSignInOptions.f5039k;
            ArrayList arrayList2 = googleSignInOptions.f5035b;
            JSONObject jSONObject2 = new JSONObject();
            try {
                JSONArray jSONArray2 = new JSONArray();
                Collections.sort(arrayList2, GoogleSignInOptions.f5033u);
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    jSONArray2.put(((Scope) it.next()).f5057b);
                }
                jSONObject2.put("scopes", jSONArray2);
                Account account = googleSignInOptions.f5036c;
                if (account != null) {
                    jSONObject2.put("accountName", account.name);
                }
                jSONObject2.put("idTokenRequested", googleSignInOptions.f5037d);
                jSONObject2.put("forceCodeForRefreshToken", googleSignInOptions.f5038f);
                jSONObject2.put("serverAuthRequested", googleSignInOptions.e);
                if (!TextUtils.isEmpty(str10)) {
                    jSONObject2.put("serverClientId", str10);
                }
                if (!TextUtils.isEmpty(str9)) {
                    jSONObject2.put("hostedDomain", str9);
                }
                e(strF2, jSONObject2.toString());
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        } catch (JSONException e2) {
            throw new RuntimeException(e2);
        }
    }

    public final String d(String str) {
        ReentrantLock reentrantLock = this.f9507a;
        reentrantLock.lock();
        try {
            return this.f9508b.getString(str, null);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void e(String str, String str2) {
        ReentrantLock reentrantLock = this.f9507a;
        reentrantLock.lock();
        try {
            this.f9508b.edit().putString(str, str2).apply();
        } finally {
            reentrantLock.unlock();
        }
    }
}
