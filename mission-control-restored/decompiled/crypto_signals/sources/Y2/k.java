package Y2;

import N1.C0149z;
import android.text.TextUtils;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f3613b = TimeUnit.HOURS.toSeconds(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f3614c = Pattern.compile("\\AA[\\w-]{38}\\z");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static k f3615d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0149z f3616a;

    public k(C0149z c0149z) {
        this.f3616a = c0149z;
    }

    public final boolean a(Z2.b bVar) {
        if (TextUtils.isEmpty(bVar.f3994c)) {
            return true;
        }
        long j4 = bVar.f3996f + bVar.e;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.f3616a.getClass();
        return j4 < timeUnit.toSeconds(System.currentTimeMillis()) + f3613b;
    }
}
