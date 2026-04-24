package com.amazon.a.a.i;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public abstract class b extends com.amazon.a.a.e.c<b> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.amazon.a.a.o.c f8480b = new com.amazon.a.a.o.c("Prompt");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.m.c f8481c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f8482d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Activity f8483e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private d f8484f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Dialog f8485g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AtomicBoolean f8486h = new AtomicBoolean(false);

    public b() {
        int i4 = i();
        this.f8482d = i4;
        if (com.amazon.a.a.o.c.f8809a) {
            f8480b.a("Creating Prompt: " + i4);
        }
    }

    private boolean e(Activity activity) {
        if (this.f8481c.b(com.amazon.a.a.m.c.f8584e)) {
            return false;
        }
        return b(activity);
    }

    private void f(Activity activity) {
        if (com.amazon.a.a.o.c.f8809a) {
            f8480b.a("Showing prompt, id: " + j() + ", prompt: " + this + ", activity: " + activity);
        }
        if (this.f8483e != null) {
            m();
        }
        activity.showDialog(j());
    }

    private int i() {
        int iNextInt = new Random().nextInt(2146249079) + 1234567;
        if (iNextInt <= 1234567) {
            return 1234567;
        }
        return iNextInt;
    }

    private void m() {
        if (com.amazon.a.a.o.c.f8809a) {
            f8480b.b("Dismissing dialog: " + this.f8482d);
        }
        try {
            this.f8483e.dismissDialog(this.f8482d);
            this.f8483e.removeDialog(this.f8482d);
        } catch (Exception unused) {
            if (com.amazon.a.a.o.c.f8809a) {
                f8480b.b("Unable to remove dialog: " + this.f8482d);
            }
        }
        this.f8483e = null;
        this.f8485g = null;
    }

    public final void a(Activity activity) {
        com.amazon.a.a.o.a.a.a((Object) activity, "activity");
        com.amazon.a.a.o.a.a.a();
        if (e(activity)) {
            f(activity);
        } else {
            b(d.NOT_COMPATIBLE);
        }
    }

    public abstract void a(d dVar);

    public boolean b(Activity activity) {
        return true;
    }

    public final Dialog c(Activity activity) {
        this.f8483e = activity;
        Dialog dialogD = d(activity);
        this.f8485g = dialogD;
        dialogD.setCancelable(false);
        this.f8485g.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.amazon.a.a.i.b.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i4, KeyEvent keyEvent) {
                return i4 == 84;
            }
        });
        return this.f8485g;
    }

    public abstract Dialog d(Activity activity);

    @Override // com.amazon.a.a.e.a
    public final void d() {
        if (com.amazon.a.a.o.c.f8809a) {
            f8480b.a("Expiring prompt: " + this);
        }
        this.f8444a.a(com.amazon.a.a.n.b.d.FOREGROUND, new com.amazon.a.a.n.a() { // from class: com.amazon.a.a.i.b.2
            @Override // com.amazon.a.a.n.a
            public void a() {
                b.this.k();
            }

            public String toString() {
                return "DismissPromptTask: " + b.this.toString();
            }
        });
        a(l());
    }

    public int j() {
        return this.f8482d;
    }

    public final boolean k() {
        com.amazon.a.a.o.a.a.a();
        if (com.amazon.a.a.o.c.f8809a) {
            f8480b.a("Dismissing Prompt: " + this.f8482d);
        }
        if (!this.f8486h.compareAndSet(false, true)) {
            if (com.amazon.a.a.o.c.f8809a) {
                f8480b.b("Prompt has already been dismissed");
            }
            return false;
        }
        if (this.f8483e != null) {
            m();
        }
        f();
        return true;
    }

    public d l() {
        if (!g()) {
            return null;
        }
        d dVar = this.f8484f;
        return dVar == null ? d.EXPIRATION_DURATION_ELAPSED : dVar;
    }

    private void b(d dVar) {
        if (com.amazon.a.a.o.c.f8809a) {
            f8480b.a("Expiring prompt pre-maturely: id: " + j() + ", prompt: " + this + ",, reason: " + dVar);
        }
        this.f8484f = dVar;
        c();
    }

    public void a(Activity activity, boolean z4) {
        if (activity != this.f8483e) {
            if (com.amazon.a.a.o.c.f8809a) {
                f8480b.a("Unrecognized context");
            }
        } else {
            if (!z4 || this.f8485g.isShowing()) {
                return;
            }
            if (com.amazon.a.a.o.c.f8809a) {
                f8480b.a("showing dialog because it was not showing");
            }
            this.f8485g.show();
        }
    }
}
