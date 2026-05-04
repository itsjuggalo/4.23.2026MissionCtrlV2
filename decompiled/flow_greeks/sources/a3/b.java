package a3;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public interface b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f47a = a.f48a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f48a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f49b;

        static {
            String simpleName = b.class.getSimpleName();
            kotlin.jvm.internal.t.e(simpleName, "getSimpleName(...)");
            f49b = simpleName;
        }

        public final b a() {
            int i10 = Build.VERSION.SDK_INT;
            return i10 >= 30 ? g.f54b : i10 >= 29 ? f.f53b : i10 >= 28 ? e.f52b : d.f51b;
        }

        public final String b() {
            return f49b;
        }
    }

    Rect a(Activity activity);

    Rect b(Context context);
}
