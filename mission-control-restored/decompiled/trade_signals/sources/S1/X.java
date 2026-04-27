package S1;

import Q1.C0790b;
import android.app.Dialog;
import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.internal.AbstractC1294n;

/* JADX INFO: loaded from: classes.dex */
public final class X implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V f7380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Y f7381b;

    public X(Y y7, V v8) {
        this.f7381b = y7;
        this.f7380a = v8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f7381b.f7382b) {
            C0790b c0790bB = this.f7380a.b();
            if (c0790bB.f()) {
                Y y7 = this.f7381b;
                y7.f7425a.startActivityForResult(GoogleApiActivity.a(y7.b(), (PendingIntent) AbstractC1294n.j(c0790bB.e()), this.f7380a.a(), false), 1);
                return;
            }
            Y y8 = this.f7381b;
            if (y8.f7385e.b(y8.b(), c0790bB.a(), null) != null) {
                Y y9 = this.f7381b;
                y9.f7385e.w(y9.b(), y9.f7425a, c0790bB.a(), 2, this.f7381b);
                return;
            }
            if (c0790bB.a() != 18) {
                this.f7381b.l(c0790bB, this.f7380a.a());
                return;
            }
            Y y10 = this.f7381b;
            Dialog dialogR = y10.f7385e.r(y10.b(), y10);
            Y y11 = this.f7381b;
            y11.f7385e.s(y11.b().getApplicationContext(), new W(this, dialogR));
        }
    }
}
