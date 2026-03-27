package androidx.lifecycle;

/* JADX INFO: renamed from: androidx.lifecycle.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0363u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public EnumC0357n f4687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public r f4688b;

    public final void a(InterfaceC0362t interfaceC0362t, EnumC0356m enumC0356m) {
        EnumC0357n enumC0357nA = enumC0356m.a();
        EnumC0357n state1 = this.f4687a;
        kotlin.jvm.internal.j.e(state1, "state1");
        if (enumC0357nA.compareTo(state1) < 0) {
            state1 = enumC0357nA;
        }
        this.f4687a = state1;
        this.f4688b.d(interfaceC0362t, enumC0356m);
        this.f4687a = enumC0357nA;
    }
}
