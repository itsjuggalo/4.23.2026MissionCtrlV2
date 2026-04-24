package Z1;

import android.content.Context;
import c3.C0395a;
import k2.C0755a;
import k2.C0758d;
import k2.C0771q;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements X2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3955c;

    public /* synthetic */ d(int i, Object obj, Object obj2) {
        this.f3953a = i;
        this.f3954b = obj;
        this.f3955c = obj2;
    }

    @Override // X2.b
    public final Object get() {
        switch (this.f3953a) {
            case 0:
                h hVar = (h) this.f3954b;
                return new C0395a((Context) this.f3955c, hVar.g(), (J2.c) hVar.f3965d.b(J2.c.class));
            default:
                C0758d c0758d = (C0758d) this.f3954b;
                c0758d.getClass();
                C0755a c0755a = (C0755a) this.f3955c;
                return c0755a.f7836f.c(new C0771q(c0755a, c0758d));
        }
    }
}
