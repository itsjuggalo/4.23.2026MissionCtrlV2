package h4;

import g4.InterfaceC1804T;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: h4.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1881a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1881a f18669a = new C1881a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static InterfaceC1804T f18670b;

    public static final void b() {
        try {
            if (f18670b == null) {
                f18669a.c(InterfaceC1804T.f18076a.a());
            }
            C1881a c1881a = f18669a;
            if (c1881a.a().a()) {
                c1881a.a().b();
            }
        } catch (Exception unused) {
        }
    }

    public final InterfaceC1804T a() {
        InterfaceC1804T interfaceC1804T = f18670b;
        if (interfaceC1804T != null) {
            return interfaceC1804T;
        }
        AbstractC2304t.s("sharedSessionRepository");
        return null;
    }

    public final void c(InterfaceC1804T interfaceC1804T) {
        AbstractC2304t.f(interfaceC1804T, "<set-?>");
        f18670b = interfaceC1804T;
    }
}
