package K2;

import K2.InterfaceC0364l;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: renamed from: K2.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0367o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0367o f1274b = new C0367o(new InterfaceC0364l.a(), InterfaceC0364l.b.f1213a);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentMap f1275a = new ConcurrentHashMap();

    public C0367o(InterfaceC0366n... interfaceC0366nArr) {
        for (InterfaceC0366n interfaceC0366n : interfaceC0366nArr) {
            this.f1275a.put(interfaceC0366n.a(), interfaceC0366n);
        }
    }

    public static C0367o a() {
        return f1274b;
    }

    public InterfaceC0366n b(String str) {
        return (InterfaceC0366n) this.f1275a.get(str);
    }
}
