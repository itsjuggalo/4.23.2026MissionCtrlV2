package C2;

import io.flutter.plugin.common.MethodCall;

/* JADX INFO: loaded from: classes3.dex */
public abstract class q {
    public static Integer a(MethodCall methodCall) {
        return (Integer) methodCall.argument("logLevel");
    }

    public static boolean b(int i4) {
        return i4 >= 1;
    }

    public static boolean c(int i4) {
        return i4 >= 2;
    }
}
