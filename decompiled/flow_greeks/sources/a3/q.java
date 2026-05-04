package a3;

import android.app.Activity;
import android.content.Context;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public interface q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f62a = a.f63a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f63a = new a();

        public final q a() {
            int i10 = Build.VERSION.SDK_INT;
            return i10 >= 34 ? s.f65b : i10 >= 30 ? r.f64b : t.f66b;
        }
    }

    w2.t a(Context context, l lVar);

    w2.t b(Context context, l lVar);

    w2.t c(Activity activity, l lVar);
}
