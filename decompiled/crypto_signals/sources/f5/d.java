package f5;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List f6504a;

    static {
        try {
            Iterator it = Arrays.asList(new b5.b()).iterator();
            kotlin.jvm.internal.j.e(it, "<this>");
            f6504a = X4.f.O(new X4.a(new X4.c(it, 2)));
        } catch (Throwable th) {
            throw new ServiceConfigurationError(th.getMessage(), th);
        }
    }
}
