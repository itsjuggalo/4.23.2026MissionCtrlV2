package H0;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class E implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0311m f616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.android.billingclient.api.b f617c;

    public E(com.android.billingclient.api.b bVar, String str, InterfaceC0311m interfaceC0311m) {
        this.f615a = str;
        this.f616b = interfaceC0311m;
        this.f617c = bVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        L lV0 = this.f617c.v0(this.f615a);
        this.f616b.a(lV0.a(), lV0.b());
        return null;
    }
}
