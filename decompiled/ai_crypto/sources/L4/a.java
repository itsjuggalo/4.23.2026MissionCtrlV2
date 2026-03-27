package L4;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f3671b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f3672a = new HashMap();

    public static a b() {
        if (f3671b == null) {
            f3671b = new a();
        }
        return f3671b;
    }

    public io.flutter.embedding.engine.a a(String str) {
        return (io.flutter.embedding.engine.a) this.f3672a.get(str);
    }

    public void c(String str, io.flutter.embedding.engine.a aVar) {
        if (aVar != null) {
            this.f3672a.put(str, aVar);
        } else {
            this.f3672a.remove(str);
        }
    }

    public void d(String str) {
        c(str, null);
    }
}
