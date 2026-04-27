package P0;

import android.app.Activity;
import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public interface u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6277a = a.f6278a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f6278a = new a();

        public final u a() {
            int i8 = Build.VERSION.SDK_INT;
            return i8 >= 34 ? w.f6280b : i8 >= 30 ? v.f6279b : x.f6281b;
        }
    }

    L0.k a(Context context, l lVar);

    L0.k b(Activity activity, l lVar);

    L0.k c(Context context, l lVar);
}
