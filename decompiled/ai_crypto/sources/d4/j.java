package d4;

import c4.InterfaceC1143b;

/* JADX INFO: loaded from: classes.dex */
public final class j implements InterfaceC1143b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final D5.a f13392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final D5.a f13393b;

    public j(D5.a aVar, D5.a aVar2) {
        this.f13392a = aVar;
        this.f13393b = aVar2;
    }

    public static j a(D5.a aVar, D5.a aVar2) {
        return new j(aVar, aVar2);
    }

    public static i c(m mVar, m mVar2) {
        return new i(mVar, mVar2);
    }

    @Override // D5.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public i get() {
        return c((m) this.f13392a.get(), (m) this.f13393b.get());
    }
}
