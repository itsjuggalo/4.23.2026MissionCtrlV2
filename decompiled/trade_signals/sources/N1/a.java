package N1;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.AbstractC1294n;
import com.revenuecat.purchases.common.Constants;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lock f5460c = new ReentrantLock();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static a f5461d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lock f5462a = new ReentrantLock();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SharedPreferences f5463b;

    public a(Context context) {
        this.f5463b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static a a(Context context) {
        AbstractC1294n.j(context);
        Lock lock = f5460c;
        lock.lock();
        try {
            if (f5461d == null) {
                f5461d = new a(context.getApplicationContext());
            }
            a aVar = f5461d;
            lock.unlock();
            return aVar;
        } catch (Throwable th) {
            f5460c.unlock();
            throw th;
        }
    }

    public static final String d(String str, String str2) {
        return str + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + str2;
    }

    public GoogleSignInAccount b() {
        String strC;
        String strC2 = c("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(strC2) || (strC = c(d("googleSignInAccount", strC2))) == null) {
            return null;
        }
        try {
            return GoogleSignInAccount.J(strC);
        } catch (JSONException unused) {
            return null;
        }
    }

    public final String c(String str) {
        this.f5462a.lock();
        try {
            return this.f5463b.getString(str, null);
        } finally {
            this.f5462a.unlock();
        }
    }
}
