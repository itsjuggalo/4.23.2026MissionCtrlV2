package T6;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f8004a = new ConcurrentHashMap();

    public static final Void a(String message) {
        AbstractC2304t.f(message, "message");
        throw new IllegalStateException(message.toString());
    }

    public static /* synthetic */ Void b(String str, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = "should not be called";
        }
        return a(str);
    }
}
