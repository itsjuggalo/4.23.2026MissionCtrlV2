package t2;

import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class i extends h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f20657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f20658c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j f20659d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g f20660e;

    public i(Object value, String tag, j verificationMode, g logger) {
        t.f(value, "value");
        t.f(tag, "tag");
        t.f(verificationMode, "verificationMode");
        t.f(logger, "logger");
        this.f20657b = value;
        this.f20658c = tag;
        this.f20659d = verificationMode;
        this.f20660e = logger;
    }

    @Override // t2.h
    public Object a() {
        return this.f20657b;
    }

    @Override // t2.h
    public h c(String message, pd.k condition) {
        t.f(message, "message");
        t.f(condition, "condition");
        return ((Boolean) condition.invoke(this.f20657b)).booleanValue() ? this : new f(this.f20657b, this.f20658c, message, this.f20660e, this.f20659d);
    }
}
