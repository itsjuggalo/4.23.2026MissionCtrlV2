package K4;

import android.os.Build;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Method f1012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Method f1013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Method f1014c;

    public f(Method method, Method method2, Method method3) {
        this.f1012a = method;
        this.f1013b = method2;
        this.f1014c = method3;
    }

    public static void a() {
        if (Build.VERSION.SDK_INT >= 29) {
            throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
        }
    }
}
