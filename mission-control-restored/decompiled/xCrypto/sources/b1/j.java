package b1;

import android.content.Context;
import k1.InterfaceC1567a;

/* JADX INFO: loaded from: classes.dex */
public final class j implements c1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V2.a f8256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final V2.a f8257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final V2.a f8258c;

    public j(V2.a aVar, V2.a aVar2, V2.a aVar3) {
        this.f8256a = aVar;
        this.f8257b = aVar2;
        this.f8258c = aVar3;
    }

    public static j a(V2.a aVar, V2.a aVar2, V2.a aVar3) {
        return new j(aVar, aVar2, aVar3);
    }

    public static i c(Context context, InterfaceC1567a interfaceC1567a, InterfaceC1567a interfaceC1567a2) {
        return new i(context, interfaceC1567a, interfaceC1567a2);
    }

    @Override // V2.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public i get() {
        return c((Context) this.f8256a.get(), (InterfaceC1567a) this.f8257b.get(), (InterfaceC1567a) this.f8258c.get());
    }
}
