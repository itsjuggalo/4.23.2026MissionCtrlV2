package g5;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.revenuecat.purchases.common.Constants;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lock f10054c = new ReentrantLock();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static c f10055d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lock f10056a = new ReentrantLock();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SharedPreferences f10057b;

    public c(Context context) {
        this.f10057b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static c b(Context context) {
        com.google.android.gms.common.internal.s.k(context);
        Lock lock = f10054c;
        lock.lock();
        try {
            if (f10055d == null) {
                f10055d = new c(context.getApplicationContext());
            }
            c cVar = f10055d;
            lock.unlock();
            return cVar;
        } catch (Throwable th) {
            f10054c.unlock();
            throw th;
        }
    }

    public static final String i(String str, String str2) {
        StringBuilder sb2 = new StringBuilder(str.length() + 1 + String.valueOf(str2).length());
        sb2.append(str);
        sb2.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        sb2.append(str2);
        return sb2.toString();
    }

    public void a() {
        this.f10056a.lock();
        try {
            this.f10057b.edit().clear().apply();
        } finally {
            this.f10056a.unlock();
        }
    }

    public GoogleSignInAccount c() {
        String strH;
        String strH2 = h("defaultGoogleSignInAccount");
        if (!TextUtils.isEmpty(strH2) && (strH = h(i("googleSignInAccount", strH2))) != null) {
            try {
                return GoogleSignInAccount.X(strH);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public GoogleSignInOptions d() {
        String strH;
        String strH2 = h("defaultGoogleSignInAccount");
        if (!TextUtils.isEmpty(strH2) && (strH = h(i("googleSignInOptions", strH2))) != null) {
            try {
                return GoogleSignInOptions.Z(strH);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public String e() {
        return h("refreshToken");
    }

    public void f(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        com.google.android.gms.common.internal.s.k(googleSignInAccount);
        com.google.android.gms.common.internal.s.k(googleSignInOptions);
        g("defaultGoogleSignInAccount", googleSignInAccount.Z());
        com.google.android.gms.common.internal.s.k(googleSignInAccount);
        com.google.android.gms.common.internal.s.k(googleSignInOptions);
        String strZ = googleSignInAccount.Z();
        g(i("googleSignInAccount", strZ), googleSignInAccount.a0());
        g(i("googleSignInOptions", strZ), googleSignInOptions.a0());
    }

    public final void g(String str, String str2) {
        this.f10056a.lock();
        try {
            this.f10057b.edit().putString(str, str2).apply();
        } finally {
            this.f10056a.unlock();
        }
    }

    public final String h(String str) {
        this.f10056a.lock();
        try {
            return this.f10057b.getString(str, null);
        } finally {
            this.f10056a.unlock();
        }
    }
}
