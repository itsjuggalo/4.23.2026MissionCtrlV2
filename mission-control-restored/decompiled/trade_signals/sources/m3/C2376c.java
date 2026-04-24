package m3;

import m3.e;
import p3.C2548b;
import p3.C2555i;
import p3.InterfaceC2560n;

/* JADX INFO: renamed from: m3.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2376c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e.a f21404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2555i f21405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C2555i f21406c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C2548b f21407d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final C2548b f21408e;

    public C2376c(e.a aVar, C2555i c2555i, C2548b c2548b, C2548b c2548b2, C2555i c2555i2) {
        this.f21404a = aVar;
        this.f21405b = c2555i;
        this.f21407d = c2548b;
        this.f21408e = c2548b2;
        this.f21406c = c2555i2;
    }

    public static C2376c b(C2548b c2548b, C2555i c2555i) {
        return new C2376c(e.a.CHILD_ADDED, c2555i, c2548b, null, null);
    }

    public static C2376c c(C2548b c2548b, InterfaceC2560n interfaceC2560n) {
        return b(c2548b, C2555i.d(interfaceC2560n));
    }

    public static C2376c d(C2548b c2548b, C2555i c2555i, C2555i c2555i2) {
        return new C2376c(e.a.CHILD_CHANGED, c2555i, c2548b, null, c2555i2);
    }

    public static C2376c e(C2548b c2548b, InterfaceC2560n interfaceC2560n, InterfaceC2560n interfaceC2560n2) {
        return d(c2548b, C2555i.d(interfaceC2560n), C2555i.d(interfaceC2560n2));
    }

    public static C2376c f(C2548b c2548b, C2555i c2555i) {
        return new C2376c(e.a.CHILD_MOVED, c2555i, c2548b, null, null);
    }

    public static C2376c g(C2548b c2548b, C2555i c2555i) {
        return new C2376c(e.a.CHILD_REMOVED, c2555i, c2548b, null, null);
    }

    public static C2376c h(C2548b c2548b, InterfaceC2560n interfaceC2560n) {
        return g(c2548b, C2555i.d(interfaceC2560n));
    }

    public static C2376c n(C2555i c2555i) {
        return new C2376c(e.a.VALUE, c2555i, null, null, null);
    }

    public C2376c a(C2548b c2548b) {
        return new C2376c(this.f21404a, this.f21405b, this.f21407d, c2548b, this.f21406c);
    }

    public C2548b i() {
        return this.f21407d;
    }

    public e.a j() {
        return this.f21404a;
    }

    public C2555i k() {
        return this.f21405b;
    }

    public C2555i l() {
        return this.f21406c;
    }

    public C2548b m() {
        return this.f21408e;
    }

    public String toString() {
        return "Change: " + this.f21404a + " " + this.f21407d;
    }
}
