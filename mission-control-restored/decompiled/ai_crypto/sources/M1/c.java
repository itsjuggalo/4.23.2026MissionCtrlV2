package M1;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.revenuecat.purchases.common.Constants;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lock f3808c = new ReentrantLock();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static c f3809d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lock f3810a = new ReentrantLock();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SharedPreferences f3811b;

    public c(Context context) {
        this.f3811b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static c b(Context context) {
        AbstractC1207s.k(context);
        Lock lock = f3808c;
        lock.lock();
        try {
            if (f3809d == null) {
                f3809d = new c(context.getApplicationContext());
            }
            c cVar = f3809d;
            lock.unlock();
            return cVar;
        } catch (Throwable th) {
            f3808c.unlock();
            throw th;
        }
    }

    public static final String i(String str, String str2) {
        return str + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + str2;
    }

    public void a() {
        this.f3810a.lock();
        try {
            this.f3811b.edit().clear().apply();
        } finally {
            this.f3810a.unlock();
        }
    }

    public GoogleSignInAccount c() {
        String strG;
        String strG2 = g("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(strG2) || (strG = g(i("googleSignInAccount", strG2))) == null) {
            return null;
        }
        try {
            return GoogleSignInAccount.J(strG);
        } catch (JSONException unused) {
            return null;
        }
    }

    public GoogleSignInOptions d() {
        String strG;
        String strG2 = g("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(strG2) || (strG = g(i("googleSignInOptions", strG2))) == null) {
            return null;
        }
        try {
            return GoogleSignInOptions.J(strG);
        } catch (JSONException unused) {
            return null;
        }
    }

    public String e() {
        return g("refreshToken");
    }

    public void f(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        AbstractC1207s.k(googleSignInAccount);
        AbstractC1207s.k(googleSignInOptions);
        h("defaultGoogleSignInAccount", googleSignInAccount.K());
        AbstractC1207s.k(googleSignInAccount);
        AbstractC1207s.k(googleSignInOptions);
        String strK = googleSignInAccount.K();
        h(i("googleSignInAccount", strK), googleSignInAccount.L());
        h(i("googleSignInOptions", strK), googleSignInOptions.N());
    }

    public final String g(String str) {
        this.f3810a.lock();
        try {
            return this.f3811b.getString(str, null);
        } finally {
            this.f3810a.unlock();
        }
    }

    public final void h(String str, String str2) {
        this.f3810a.lock();
        try {
            this.f3811b.edit().putString(str, str2).apply();
        } finally {
            this.f3810a.unlock();
        }
    }
}
