package androidx.datastore.preferences.protobuf;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes.dex */
public final class U {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final U f6955c = new U();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f6956d = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentMap f6958b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Z f6957a = new B();

    public static U a() {
        return f6955c;
    }

    public Y b(Class cls, Y y4) {
        AbstractC0807u.b(cls, "messageType");
        AbstractC0807u.b(y4, com.amazon.device.simplesignin.a.a.a.f9260E);
        return (Y) this.f6958b.putIfAbsent(cls, y4);
    }

    public Y c(Class cls) {
        Y yB;
        AbstractC0807u.b(cls, "messageType");
        Y yA = (Y) this.f6958b.get(cls);
        return (yA != null || (yB = b(cls, (yA = this.f6957a.a(cls)))) == null) ? yA : yB;
    }

    public Y d(Object obj) {
        return c(obj.getClass());
    }
}
