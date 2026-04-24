package K2;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static List f1007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f1008b;

    public static synchronized List a() {
        f1008b = true;
        return f1007a;
    }
}
