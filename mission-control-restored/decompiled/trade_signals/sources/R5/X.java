package R5;

import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class X {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0852i f7220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f7221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final X f7222c;

    public X(InterfaceC0852i classifierDescriptor, List arguments, X x8) {
        AbstractC2304t.f(classifierDescriptor, "classifierDescriptor");
        AbstractC2304t.f(arguments, "arguments");
        this.f7220a = classifierDescriptor;
        this.f7221b = arguments;
        this.f7222c = x8;
    }

    public final List a() {
        return this.f7221b;
    }

    public final InterfaceC0852i b() {
        return this.f7220a;
    }

    public final X c() {
        return this.f7222c;
    }
}
