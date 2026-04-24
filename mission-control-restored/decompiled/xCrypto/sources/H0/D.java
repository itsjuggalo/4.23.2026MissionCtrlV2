package H0;

import com.google.android.gms.internal.play_billing.zzco;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class D implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0312n f610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.android.billingclient.api.b f611c;

    public D(com.android.billingclient.api.b bVar, String str, InterfaceC0312n interfaceC0312n) {
        this.f609a = str;
        this.f610b = interfaceC0312n;
        this.f611c = bVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        r0 r0VarC0 = this.f611c.c0(this.f609a, 9);
        if (r0VarC0.b() != null) {
            this.f610b.a(r0VarC0.a(), r0VarC0.b());
            return null;
        }
        this.f610b.a(r0VarC0.a(), zzco.zzl());
        return null;
    }
}
