package u6;

import I6.v0;
import J6.e;
import R5.InterfaceC0844a;

/* JADX INFO: renamed from: u6.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C2790e implements e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f23532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC0844a f23533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC0844a f23534c;

    public C2790e(boolean z7, InterfaceC0844a interfaceC0844a, InterfaceC0844a interfaceC0844a2) {
        this.f23532a = z7;
        this.f23533b = interfaceC0844a;
        this.f23534c = interfaceC0844a2;
    }

    @Override // J6.e.a
    public boolean a(v0 v0Var, v0 v0Var2) {
        return C2792g.h(this.f23532a, this.f23533b, this.f23534c, v0Var, v0Var2);
    }
}
