package P0;

import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public interface l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6271a = a.f6272a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f6272a = new a();

        public final l a() {
            return Build.VERSION.SDK_INT >= 34 ? m.f6273b : n.f6274b;
        }
    }

    float a(Context context);
}
