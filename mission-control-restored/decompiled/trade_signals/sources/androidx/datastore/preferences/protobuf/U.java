package androidx.datastore.preferences.protobuf;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes.dex */
public final class U {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final U f11175c = new U();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f11176d = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentMap f11178b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Z f11177a = new B();

    public static U a() {
        return f11175c;
    }

    public Y b(Class cls, Y y7) {
        AbstractC1118u.b(cls, "messageType");
        AbstractC1118u.b(y7, com.amazon.device.simplesignin.a.a.a.f14556E);
        return (Y) this.f11178b.putIfAbsent(cls, y7);
    }

    public Y c(Class cls) {
        AbstractC1118u.b(cls, "messageType");
        Y y7 = (Y) this.f11178b.get(cls);
        if (y7 != null) {
            return y7;
        }
        Y yA = this.f11177a.a(cls);
        Y yB = b(cls, yA);
        return yB != null ? yB : yA;
    }

    public Y d(Object obj) {
        return c(obj.getClass());
    }
}
