package k2;

import K2.C0054e;
import e3.C0550j;
import h4.C0632k;

/* JADX INFO: renamed from: k2.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0767m implements X2.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0632k f7861c = new C0632k(16);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C0550j f7862d = new C0550j(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public X2.a f7863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile X2.b f7864b;

    public C0767m(C0632k c0632k, X2.b bVar) {
        this.f7863a = c0632k;
        this.f7864b = bVar;
    }

    public final void a(X2.a aVar) {
        X2.b bVar;
        X2.b bVar2;
        X2.b bVar3 = this.f7864b;
        C0550j c0550j = f7862d;
        if (bVar3 != c0550j) {
            aVar.b(bVar3);
            return;
        }
        synchronized (this) {
            bVar = this.f7864b;
            if (bVar != c0550j) {
                bVar2 = bVar;
            } else {
                this.f7863a = new C0054e(16, this.f7863a, aVar);
                bVar2 = null;
            }
        }
        if (bVar2 != null) {
            aVar.b(bVar);
        }
    }

    @Override // X2.b
    public final Object get() {
        return this.f7864b.get();
    }
}
