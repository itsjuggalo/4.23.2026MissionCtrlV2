package d;

import Z.AbstractActivityC0282y;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.Q;

/* JADX INFO: renamed from: d.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0507k extends kotlin.jvm.internal.k implements R4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbstractActivityC0282y f5901b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0507k(AbstractActivityC0282y abstractActivityC0282y, int i) {
        super(0);
        this.f5900a = i;
        this.f5901b = abstractActivityC0282y;
    }

    @Override // R4.a
    public final Object invoke() {
        switch (this.f5900a) {
            case 0:
                AbstractActivityC0282y abstractActivityC0282y = this.f5901b;
                return new Q(abstractActivityC0282y.getApplication(), abstractActivityC0282y, abstractActivityC0282y.getIntent() != null ? abstractActivityC0282y.getIntent().getExtras() : null);
            case 1:
                this.f5901b.reportFullyDrawn();
                return G4.l.f540a;
            case 2:
                AbstractActivityC0282y abstractActivityC0282y2 = this.f5901b;
                return new C0510n(abstractActivityC0282y2.f5906f, new C0507k(abstractActivityC0282y2, 1));
            default:
                AbstractActivityC0282y abstractActivityC0282y3 = this.f5901b;
                C0517u c0517u = new C0517u(new RunnableC0500d(abstractActivityC0282y3, 1));
                if (Build.VERSION.SDK_INT >= 33) {
                    if (kotlin.jvm.internal.j.a(Looper.myLooper(), Looper.getMainLooper())) {
                        abstractActivityC0282y3.f9812a.a(new C0502f(c0517u, abstractActivityC0282y3));
                    } else {
                        new Handler(Looper.getMainLooper()).post(new E3.h(24, abstractActivityC0282y3, c0517u));
                    }
                }
                return c0517u;
        }
    }
}
