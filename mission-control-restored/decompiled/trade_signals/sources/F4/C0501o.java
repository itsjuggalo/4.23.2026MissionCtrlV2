package F4;

import F4.InterfaceC0498l;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: renamed from: F4.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0501o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0501o f1877b = new C0501o(new InterfaceC0498l.a(), InterfaceC0498l.b.f1851a);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentMap f1878a = new ConcurrentHashMap();

    public C0501o(InterfaceC0500n... interfaceC0500nArr) {
        for (InterfaceC0500n interfaceC0500n : interfaceC0500nArr) {
            this.f1878a.put(interfaceC0500n.a(), interfaceC0500n);
        }
    }

    public static C0501o a() {
        return f1877b;
    }

    public InterfaceC0500n b(String str) {
        return (InterfaceC0500n) this.f1878a.get(str);
    }
}
