package k8;

import j8.l;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f14752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f14753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f14754c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum a {
        Overwrite,
        Merge,
        AckUserWrite,
        ListenComplete
    }

    public d(a aVar, e eVar, l lVar) {
        this.f14752a = aVar;
        this.f14753b = eVar;
        this.f14754c = lVar;
    }

    public l a() {
        return this.f14754c;
    }

    public e b() {
        return this.f14753b;
    }

    public a c() {
        return this.f14752a;
    }

    public abstract d d(r8.b bVar);
}
