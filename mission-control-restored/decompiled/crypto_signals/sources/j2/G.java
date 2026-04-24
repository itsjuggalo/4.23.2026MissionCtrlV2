package j2;

import Z.AbstractActivityC0282y;

/* JADX INFO: loaded from: classes.dex */
public final class G {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final G f7638c = new G();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f7639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final P3.u f7640b;

    public G() {
        x xVar = x.f7739d;
        if (P3.u.f2599d == null) {
            P3.u uVar = new P3.u(7);
            uVar.f2601b = false;
            P3.u.f2599d = uVar;
        }
        P3.u uVar2 = P3.u.f2599d;
        this.f7639a = xVar;
        this.f7640b = uVar2;
    }

    public final void a(AbstractActivityC0282y abstractActivityC0282y) {
        x xVar = this.f7639a;
        xVar.getClass();
        x.d(abstractActivityC0282y.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0));
        xVar.f7741b = 0L;
    }
}
