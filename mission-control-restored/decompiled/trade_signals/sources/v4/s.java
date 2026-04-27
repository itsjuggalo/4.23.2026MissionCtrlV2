package v4;

import io.flutter.plugin.common.MethodCall;

/* JADX INFO: loaded from: classes.dex */
public abstract class s {
    public static Integer a(MethodCall methodCall) {
        return (Integer) methodCall.argument("logLevel");
    }

    public static boolean b(int i8) {
        return i8 >= 1;
    }

    public static boolean c(int i8) {
        return i8 >= 2;
    }
}
