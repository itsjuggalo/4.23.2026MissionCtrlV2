package r5;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import r5.InterfaceC2596l;

/* JADX INFO: renamed from: r5.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2599o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C2599o f22764b = new C2599o(new InterfaceC2596l.a(), InterfaceC2596l.b.f22703a);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentMap f22765a = new ConcurrentHashMap();

    public C2599o(InterfaceC2598n... interfaceC2598nArr) {
        for (InterfaceC2598n interfaceC2598n : interfaceC2598nArr) {
            this.f22765a.put(interfaceC2598n.a(), interfaceC2598n);
        }
    }

    public static C2599o a() {
        return f22764b;
    }

    public InterfaceC2598n b(String str) {
        return (InterfaceC2598n) this.f22765a.get(str);
    }
}
