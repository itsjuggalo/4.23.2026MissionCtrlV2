package d;

import Z.G;

/* JADX INFO: renamed from: d.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0515s implements InterfaceC0499c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final G f5937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0517u f5938b;

    public C0515s(C0517u c0517u, G onBackPressedCallback) {
        kotlin.jvm.internal.j.e(onBackPressedCallback, "onBackPressedCallback");
        this.f5938b = c0517u;
        this.f5937a = onBackPressedCallback;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [R4.a, kotlin.jvm.internal.i] */
    @Override // d.InterfaceC0499c
    public final void cancel() {
        C0517u c0517u = this.f5938b;
        H4.f fVar = c0517u.f5941b;
        G g2 = this.f5937a;
        fVar.remove(g2);
        if (kotlin.jvm.internal.j.a(c0517u.f5942c, g2)) {
            g2.a();
            c0517u.f5942c = null;
        }
        g2.f3709b.remove(this);
        ?? r02 = g2.f3710c;
        if (r02 != 0) {
            r02.invoke();
        }
        g2.f3710c = null;
    }
}
