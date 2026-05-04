package androidx.datastore.preferences.protobuf;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class t0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final t0 f1907c = new t0();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f1908d = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentMap f1910b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y0 f1909a = new b0();

    public static t0 a() {
        return f1907c;
    }

    public x0 b(Class cls, x0 x0Var) {
        u.b(cls, "messageType");
        u.b(x0Var, com.amazon.device.simplesignin.a.a.a.E);
        return (x0) this.f1910b.putIfAbsent(cls, x0Var);
    }

    public x0 c(Class cls) {
        x0 x0VarB;
        u.b(cls, "messageType");
        x0 x0VarA = (x0) this.f1910b.get(cls);
        return (x0VarA != null || (x0VarB = b(cls, (x0VarA = this.f1909a.a(cls)))) == null) ? x0VarA : x0VarB;
    }

    public x0 d(Object obj) {
        return c(obj.getClass());
    }
}
