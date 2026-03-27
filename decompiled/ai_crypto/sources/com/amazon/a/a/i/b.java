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
    private static final com.amazon.a.a.o.c f9665b = new com.amazon.a.a.o.c("Prompt");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.m.c f9666c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f9667d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Activity f9668e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private d f9669f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Dialog f9670g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AtomicBoolean f9671h = new AtomicBoolean(false);

    public b() {
        int i7 = i();
        this.f9667d = i7;
        if (com.amazon.a.a.o.c.f9994a) {
            f9665b.a("Creating Prompt: " + i7);
        }
    }

    private boolean e(Activity activity) {
        if (this.f9666c.b(com.amazon.a.a.m.c.f9769e)) {
            return false;
        }
        return b(activity);
    }

    private void f(Activity activity) {
        if (com.amazon.a.a.o.c.f9994a) {
            f9665b.a("Showing prompt, id: " + j() + ", prompt: " + this + ", activity: " + activity);
        }
        if (this.f9668e != null) {
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
        if (com.amazon.a.a.o.c.f9994a) {
            f9665b.b("Dismissing dialog: " + this.f9667d);
        }
        try {
            this.f9668e.dismissDialog(this.f9667d);
            this.f9668e.removeDialog(this.f9667d);
        } catch (Exception unused) {
            if (com.amazon.a.a.o.c.f9994a) {
                f9665b.b("Unable to remove dialog: " + this.f9667d);
            }
        }
        this.f9668e = null;
        this.f9670g = null;
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
        this.f9668e = activity;
        Dialog dialogD = d(activity);
        this.f9670g = dialogD;
        dialogD.setCancelable(false);
        this.f9670g.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.amazon.a.a.i.b.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i7, KeyEvent keyEvent) {
                return i7 == 84;
            }
        });
        return this.f9670g;
    }

    public abstract Dialog d(Activity activity);

    @Override // com.amazon.a.a.e.a
    public final void d() {
        if (com.amazon.a.a.o.c.f9994a) {
            f9665b.a("Expiring prompt: " + this);
        }
        this.f9629a.a(com.amazon.a.a.n.b.d.FOREGROUND, new com.amazon.a.a.n.a() { // from class: com.amazon.a.a.i.b.2
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
        return this.f9667d;
    }

    public final boolean k() {
        com.amazon.a.a.o.a.a.a();
        if (com.amazon.a.a.o.c.f9994a) {
            f9665b.a("Dismissing Prompt: " + this.f9667d);
        }
        if (!this.f9671h.compareAndSet(false, true)) {
            if (com.amazon.a.a.o.c.f9994a) {
                f9665b.b("Prompt has already been dismissed");
            }
            return false;
        }
        if (this.f9668e != null) {
            m();
        }
        f();
        return true;
    }

    public d l() {
        if (!g()) {
            return null;
        }
        d dVar = this.f9669f;
        return dVar == null ? d.EXPIRATION_DURATION_ELAPSED : dVar;
    }

    private void b(d dVar) {
        if (com.amazon.a.a.o.c.f9994a) {
            f9665b.a("Expiring prompt pre-maturely: id: " + j() + ", prompt: " + this + ",, reason: " + dVar);
        }
        this.f9669f = dVar;
        c();
    }

    public void a(Activity activity, boolean z7) {
        if (activity != this.f9668e) {
            if (com.amazon.a.a.o.c.f9994a) {
                f9665b.a("Unrecognized context");
            }
        } else {
            if (!z7 || this.f9670g.isShowing()) {
                return;
            }
            if (com.amazon.a.a.o.c.f9994a) {
                f9665b.a("showing dialog because it was not showing");
            }
            this.f9670g.show();
        }
    }
}
