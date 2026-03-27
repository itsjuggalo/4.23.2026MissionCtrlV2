package F4;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static List f1594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f1595b;

    public static synchronized List a() {
        f1595b = true;
        return f1594a;
    }
}
