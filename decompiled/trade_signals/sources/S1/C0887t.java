package S1;

import S1.ComponentCallbacks2C0871c;

/* JADX INFO: renamed from: S1.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0887t implements ComponentCallbacks2C0871c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0873e f7441a;

    public C0887t(C0873e c0873e) {
        this.f7441a = c0873e;
    }

    @Override // S1.ComponentCallbacks2C0871c.a
    public final void a(boolean z7) {
        C0873e c0873e = this.f7441a;
        c0873e.f7422n.sendMessage(c0873e.f7422n.obtainMessage(1, Boolean.valueOf(z7)));
    }
}
