package Z;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import androidx.lifecycle.C0364v;
import androidx.lifecycle.EnumC0356m;
import androidx.lifecycle.EnumC0357n;
import d.AbstractActivityC0508l;
import java.util.concurrent.CopyOnWriteArraySet;
import t.InterfaceC1089b;
import u1.C1208j;

/* JADX INFO: renamed from: Z.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractActivityC0282y extends AbstractActivityC0508l implements InterfaceC1089b {
    public boolean y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f3930z;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final B f3928w = new B(new C0281x(this), 0);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final C0364v f3929x = new C0364v(this);

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public boolean f3927A = true;

    public AbstractActivityC0282y() {
        ((Y3.i) this.f5905d.f951c).d("android:support:lifecycle", new C0278u(this, 0));
        final int i = 0;
        e(new C.a(this) { // from class: Z.v

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AbstractActivityC0282y f3920b;

            {
                this.f3920b = this;
            }

            @Override // C.a
            public final void accept(Object obj) {
                switch (i) {
                    case 0:
                        this.f3920b.f3928w.p();
                        break;
                    default:
                        this.f3920b.f3928w.p();
                        break;
                }
            }
        });
        final int i6 = 1;
        this.f5911o.add(new C.a(this) { // from class: Z.v

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AbstractActivityC0282y f3920b;

            {
                this.f3920b = this;
            }

            @Override // C.a
            public final void accept(Object obj) {
                switch (i6) {
                    case 0:
                        this.f3920b.f3928w.p();
                        break;
                    default:
                        this.f3920b.f3928w.p();
                        break;
                }
            }
        });
        C0280w c0280w = new C0280w(this, 0);
        C1208j c1208j = this.f5903b;
        c1208j.getClass();
        AbstractActivityC0508l abstractActivityC0508l = (AbstractActivityC0508l) c1208j.f10294b;
        if (abstractActivityC0508l != null) {
            c0280w.a(abstractActivityC0508l);
        }
        ((CopyOnWriteArraySet) c1208j.f10293a).add(c0280w);
    }

    public static boolean k(P p3) {
        boolean zK = false;
        for (AbstractComponentCallbacksC0277t abstractComponentCallbacksC0277t : p3.f3738c.r()) {
            if (abstractComponentCallbacksC0277t != null) {
                C0281x c0281x = abstractComponentCallbacksC0277t.f3915x;
                if ((c0281x == null ? null : c0281x.f3926k) != null) {
                    zK |= k(abstractComponentCallbacksC0277t.l());
                }
                if (abstractComponentCallbacksC0277t.f3892Q.f4691c.compareTo(EnumC0357n.f4684d) >= 0) {
                    abstractComponentCallbacksC0277t.f3892Q.g();
                    zK = true;
                }
            }
        }
        return zK;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0046  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void dump(java.lang.String r4, java.io.FileDescriptor r5, java.io.PrintWriter r6, java.lang.String[] r7) {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Z.AbstractActivityC0282y.dump(java.lang.String, java.io.FileDescriptor, java.io.PrintWriter, java.lang.String[]):void");
    }

    public final P j() {
        return ((C0281x) this.f3928w.f3700b).f3925f;
    }

    @Override // d.AbstractActivityC0508l, android.app.Activity
    public void onActivityResult(int i, int i6, Intent intent) {
        this.f3928w.p();
        super.onActivityResult(i, i6, intent);
    }

    @Override // d.AbstractActivityC0508l, t.AbstractActivityC1096i, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3929x.e(EnumC0356m.ON_CREATE);
        P p3 = ((C0281x) this.f3928w.f3700b).f3925f;
        p3.f3728G = false;
        p3.f3729H = false;
        p3.N.i = false;
        p3.u(1);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        A a6 = (A) ((C0281x) this.f3928w.f3700b).f3925f.f3740f.onCreateView(view, str, context, attributeSet);
        return a6 == null ? super.onCreateView(view, str, context, attributeSet) : a6;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ((C0281x) this.f3928w.f3700b).f3925f.l();
        this.f3929x.e(EnumC0356m.ON_DESTROY);
    }

    @Override // d.AbstractActivityC0508l, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 6) {
            return ((C0281x) this.f3928w.f3700b).f3925f.j();
        }
        return false;
    }

    @Override // android.app.Activity
    public final void onPause() {
        super.onPause();
        this.f3930z = false;
        ((C0281x) this.f3928w.f3700b).f3925f.u(5);
        this.f3929x.e(EnumC0356m.ON_PAUSE);
    }

    @Override // android.app.Activity
    public final void onPostResume() {
        super.onPostResume();
        this.f3929x.e(EnumC0356m.ON_RESUME);
        P p3 = ((C0281x) this.f3928w.f3700b).f3925f;
        p3.f3728G = false;
        p3.f3729H = false;
        p3.N.i = false;
        p3.u(7);
    }

    @Override // d.AbstractActivityC0508l, android.app.Activity
    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.f3928w.p();
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onResume() {
        B b3 = this.f3928w;
        b3.p();
        super.onResume();
        this.f3930z = true;
        ((C0281x) b3.f3700b).f3925f.A(true);
    }

    @Override // android.app.Activity
    public final void onStart() {
        B b3 = this.f3928w;
        b3.p();
        super.onStart();
        this.f3927A = false;
        boolean z6 = this.y;
        C0281x c0281x = (C0281x) b3.f3700b;
        if (!z6) {
            this.y = true;
            P p3 = c0281x.f3925f;
            p3.f3728G = false;
            p3.f3729H = false;
            p3.N.i = false;
            p3.u(4);
        }
        c0281x.f3925f.A(true);
        this.f3929x.e(EnumC0356m.ON_START);
        P p6 = c0281x.f3925f;
        p6.f3728G = false;
        p6.f3729H = false;
        p6.N.i = false;
        p6.u(5);
    }

    @Override // android.app.Activity
    public final void onStateNotSaved() {
        this.f3928w.p();
    }

    @Override // android.app.Activity
    public final void onStop() {
        super.onStop();
        this.f3927A = true;
        while (k(j())) {
        }
        P p3 = ((C0281x) this.f3928w.f3700b).f3925f;
        p3.f3729H = true;
        p3.N.i = true;
        p3.u(4);
        this.f3929x.e(EnumC0356m.ON_STOP);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        A a6 = (A) ((C0281x) this.f3928w.f3700b).f3925f.f3740f.onCreateView(null, str, context, attributeSet);
        return a6 == null ? super.onCreateView(str, context, attributeSet) : a6;
    }
}
