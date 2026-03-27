package P0;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public interface b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6262a = a.f6263a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f6263a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f6264b;

        static {
            String simpleName = b.class.getSimpleName();
            AbstractC2304t.e(simpleName, "getSimpleName(...)");
            f6264b = simpleName;
        }

        public final b a() {
            int i8 = Build.VERSION.SDK_INT;
            return i8 >= 30 ? g.f6269b : i8 >= 29 ? f.f6268b : i8 >= 28 ? e.f6267b : d.f6266b;
        }

        public final String b() {
            return f6264b;
        }
    }

    Rect a(Activity activity);

    Rect b(Context context);
}
