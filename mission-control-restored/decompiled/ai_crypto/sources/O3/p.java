package O3;

import android.text.TextUtils;
import com.revenuecat.purchases.common.Constants;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f4195b = TimeUnit.HOURS.toSeconds(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f4196c = Pattern.compile("\\AA[\\w-]{38}\\z");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static p f4197d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final R3.a f4198a;

    public p(R3.a aVar) {
        this.f4198a = aVar;
    }

    public static p c() {
        return d(R3.b.b());
    }

    public static p d(R3.a aVar) {
        if (f4197d == null) {
            f4197d = new p(aVar);
        }
        return f4197d;
    }

    public static boolean g(String str) {
        return f4196c.matcher(str).matches();
    }

    public static boolean h(String str) {
        return str.contains(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
    }

    public long a() {
        return this.f4198a.a();
    }

    public long b() {
        return TimeUnit.MILLISECONDS.toSeconds(a());
    }

    public long e() {
        return (long) (Math.random() * 1000.0d);
    }

    public boolean f(P3.d dVar) {
        return TextUtils.isEmpty(dVar.b()) || dVar.h() + dVar.c() < b() + f4195b;
    }
}
