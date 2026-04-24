package P3;

import N3.C0734o;
import java.util.concurrent.Executor;
import n5.InterfaceC2426a;

/* JADX INFO: renamed from: P3.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0779o implements E3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0778n f6417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2426a f6418b;

    public C0779o(C0778n c0778n, InterfaceC2426a interfaceC2426a) {
        this.f6417a = c0778n;
        this.f6418b = interfaceC2426a;
    }

    public static C0779o a(C0778n c0778n, InterfaceC2426a interfaceC2426a) {
        return new C0779o(c0778n, interfaceC2426a);
    }

    public static C0734o b(C0778n c0778n, Executor executor) {
        return (C0734o) E3.d.e(c0778n.a(executor));
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0734o get() {
        return b(this.f6417a, (Executor) this.f6418b.get());
    }
}
