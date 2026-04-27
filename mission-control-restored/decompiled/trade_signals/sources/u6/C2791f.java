package u6;

import R5.InterfaceC0844a;
import R5.InterfaceC0856m;

/* JADX INFO: renamed from: u6.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C2791f implements B5.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0844a f23535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC0844a f23536b;

    public C2791f(InterfaceC0844a interfaceC0844a, InterfaceC0844a interfaceC0844a2) {
        this.f23535a = interfaceC0844a;
        this.f23536b = interfaceC0844a2;
    }

    @Override // B5.o
    public Object invoke(Object obj, Object obj2) {
        return Boolean.valueOf(C2792g.i(this.f23535a, this.f23536b, (InterfaceC0856m) obj, (InterfaceC0856m) obj2));
    }
}
