package O0;

import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class i extends h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f4029b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f4030c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j f4031d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g f4032e;

    public i(Object value, String tag, j verificationMode, g logger) {
        r.f(value, "value");
        r.f(tag, "tag");
        r.f(verificationMode, "verificationMode");
        r.f(logger, "logger");
        this.f4029b = value;
        this.f4030c = tag;
        this.f4031d = verificationMode;
        this.f4032e = logger;
    }

    @Override // O0.h
    public Object a() {
        return this.f4029b;
    }

    @Override // O0.h
    public h c(String message, Q5.k condition) {
        r.f(message, "message");
        r.f(condition, "condition");
        return ((Boolean) condition.invoke(this.f4029b)).booleanValue() ? this : new f(this.f4029b, this.f4030c, message, this.f4032e, this.f4031d);
    }
}
