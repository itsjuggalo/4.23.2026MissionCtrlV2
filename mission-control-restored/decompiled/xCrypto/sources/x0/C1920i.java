package x0;

import kotlin.jvm.internal.r;

/* JADX INFO: renamed from: x0.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1920i extends AbstractC1919h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f15714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f15715c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final EnumC1921j f15716d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final InterfaceC1918g f15717e;

    public C1920i(Object value, String tag, EnumC1921j verificationMode, InterfaceC1918g logger) {
        r.f(value, "value");
        r.f(tag, "tag");
        r.f(verificationMode, "verificationMode");
        r.f(logger, "logger");
        this.f15714b = value;
        this.f15715c = tag;
        this.f15716d = verificationMode;
        this.f15717e = logger;
    }

    @Override // x0.AbstractC1919h
    public Object a() {
        return this.f15714b;
    }

    @Override // x0.AbstractC1919h
    public AbstractC1919h c(String message, i3.k condition) {
        r.f(message, "message");
        r.f(condition, "condition");
        return ((Boolean) condition.invoke(this.f15714b)).booleanValue() ? this : new C1917f(this.f15714b, this.f15715c, message, this.f15717e, this.f15716d);
    }
}
