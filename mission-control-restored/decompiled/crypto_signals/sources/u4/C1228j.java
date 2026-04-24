package u4;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: u4.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1228j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C1228j f10433b = new C1228j(new C1226h(2), C1226h.f10411b);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f10434a = new ConcurrentHashMap();

    public C1228j(InterfaceC1227i... interfaceC1227iArr) {
        for (InterfaceC1227i interfaceC1227i : interfaceC1227iArr) {
            this.f10434a.put(interfaceC1227i.g(), interfaceC1227i);
        }
    }
}
