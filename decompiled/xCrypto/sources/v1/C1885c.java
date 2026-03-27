package v1;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.revenuecat.purchases.common.Constants;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

/* JADX INFO: renamed from: v1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1885c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lock f15292c = new ReentrantLock();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static C1885c f15293d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lock f15294a = new ReentrantLock();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SharedPreferences f15295b;

    public C1885c(Context context) {
        this.f15295b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static C1885c b(Context context) {
        AbstractC0940s.k(context);
        Lock lock = f15292c;
        lock.lock();
        try {
            if (f15293d == null) {
                f15293d = new C1885c(context.getApplicationContext());
            }
            C1885c c1885c = f15293d;
            lock.unlock();
            return c1885c;
        } catch (Throwable th) {
            f15292c.unlock();
            throw th;
        }
    }

    public static final String i(String str, String str2) {
        return str + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + str2;
    }

    public void a() {
        this.f15294a.lock();
        try {
            this.f15295b.edit().clear().apply();
        } finally {
            this.f15294a.unlock();
        }
    }

    public GoogleSignInAccount c() {
        String strG;
        String strG2 = g("defaultGoogleSignInAccount");
        if (!TextUtils.isEmpty(strG2) && (strG = g(i("googleSignInAccount", strG2))) != null) {
            try {
                return GoogleSignInAccount.r(strG);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public GoogleSignInOptions d() {
        String strG;
        String strG2 = g("defaultGoogleSignInAccount");
        if (!TextUtils.isEmpty(strG2) && (strG = g(i("googleSignInOptions", strG2))) != null) {
            try {
                return GoogleSignInOptions.s(strG);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public String e() {
        return g("refreshToken");
    }

    public void f(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        AbstractC0940s.k(googleSignInAccount);
        AbstractC0940s.k(googleSignInOptions);
        h("defaultGoogleSignInAccount", googleSignInAccount.s());
        AbstractC0940s.k(googleSignInAccount);
        AbstractC0940s.k(googleSignInOptions);
        String strS = googleSignInAccount.s();
        h(i("googleSignInAccount", strS), googleSignInAccount.t());
        h(i("googleSignInOptions", strS), googleSignInOptions.w());
    }

    public final String g(String str) {
        this.f15294a.lock();
        try {
            return this.f15295b.getString(str, null);
        } finally {
            this.f15294a.unlock();
        }
    }

    public final void h(String str, String str2) {
        this.f15294a.lock();
        try {
            this.f15295b.edit().putString(str, str2).apply();
        } finally {
            this.f15294a.unlock();
        }
    }
}
