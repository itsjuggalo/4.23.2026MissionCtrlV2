package T3;

import android.text.TextUtils;
import com.revenuecat.purchases.common.Constants;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f7991b = TimeUnit.HOURS.toSeconds(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f7992c = Pattern.compile("\\AA[\\w-]{38}\\z");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static p f7993d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final W3.a f7994a;

    public p(W3.a aVar) {
        this.f7994a = aVar;
    }

    public static p c() {
        return d(W3.b.b());
    }

    public static p d(W3.a aVar) {
        if (f7993d == null) {
            f7993d = new p(aVar);
        }
        return f7993d;
    }

    public static boolean g(String str) {
        return f7992c.matcher(str).matches();
    }

    public static boolean h(String str) {
        return str.contains(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
    }

    public long a() {
        return this.f7994a.a();
    }

    public long b() {
        return TimeUnit.MILLISECONDS.toSeconds(a());
    }

    public long e() {
        return (long) (Math.random() * 1000.0d);
    }

    public boolean f(U3.d dVar) {
        return TextUtils.isEmpty(dVar.b()) || dVar.h() + dVar.c() < b() + f7991b;
    }
}
