package x1;

import t1.AbstractC2653d;
import t1.InterfaceC2651b;
import y1.AbstractC2839f;

/* JADX INFO: loaded from: classes.dex */
public final class g implements InterfaceC2651b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final D5.a f25288a;

    public g(D5.a aVar) {
        this.f25288a = aVar;
    }

    public static AbstractC2839f a(B1.a aVar) {
        return (AbstractC2839f) AbstractC2653d.d(f.a(aVar));
    }

    public static g b(D5.a aVar) {
        return new g(aVar);
    }

    @Override // D5.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public AbstractC2839f get() {
        return a((B1.a) this.f25288a.get());
    }
}
