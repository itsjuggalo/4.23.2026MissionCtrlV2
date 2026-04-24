package I0;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public final class i extends h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f4043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f4044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j f4045d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g f4046e;

    public i(Object value, String tag, j verificationMode, g logger) {
        AbstractC2304t.f(value, "value");
        AbstractC2304t.f(tag, "tag");
        AbstractC2304t.f(verificationMode, "verificationMode");
        AbstractC2304t.f(logger, "logger");
        this.f4043b = value;
        this.f4044c = tag;
        this.f4045d = verificationMode;
        this.f4046e = logger;
    }

    @Override // I0.h
    public Object a() {
        return this.f4043b;
    }

    @Override // I0.h
    public h c(String message, B5.k condition) {
        AbstractC2304t.f(message, "message");
        AbstractC2304t.f(condition, "condition");
        return ((Boolean) condition.invoke(this.f4043b)).booleanValue() ? this : new f(this.f4043b, this.f4044c, message, this.f4046e, this.f4045d);
    }
}
