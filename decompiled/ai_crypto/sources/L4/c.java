package L4;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile c f3695b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f3696a = new HashMap();

    public static c b() {
        if (f3695b == null) {
            synchronized (c.class) {
                try {
                    if (f3695b == null) {
                        f3695b = new c();
                    }
                } finally {
                }
            }
        }
        return f3695b;
    }

    public io.flutter.embedding.engine.b a(String str) {
        return (io.flutter.embedding.engine.b) this.f3696a.get(str);
    }
}
