package com.amazon.a.a.n.a;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes.dex */
public class f extends com.amazon.a.a.i.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.amazon.a.a.o.c f9829b = new com.amazon.a.a.o.c("DecisionDialog");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b f9831d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final BlockingQueue<a> f9832e = new LinkedBlockingQueue();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Thread f9830c = Thread.currentThread();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.amazon.d.a.a f9835a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f9836b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Intent f9837c;

        public a(com.amazon.d.a.a aVar) {
            this.f9835a = aVar;
            this.f9836b = aVar.a();
            this.f9837c = aVar.b();
        }

        public com.amazon.d.a.a a() {
            return this.f9835a;
        }

        public String b() {
            return this.f9836b;
        }

        public Intent c() {
            return this.f9837c;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9838a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f9839b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f9840c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final a f9841d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final a f9842e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final a f9843f;

        public b(com.amazon.d.a.f fVar) {
            this.f9838a = fVar.b();
            this.f9839b = fVar.c();
            this.f9840c = fVar.d();
            this.f9841d = a(fVar.e());
            this.f9842e = a(fVar.f());
            this.f9843f = a(fVar.g());
        }

        private a a(com.amazon.d.a.a aVar) {
            if (aVar == null) {
                return null;
            }
            return new a(aVar);
        }

        public String b() {
            return this.f9839b;
        }

        public long c() {
            return this.f9840c;
        }

        public a d() {
            return this.f9843f;
        }

        public a e() {
            return this.f9842e;
        }

        public a f() {
            return this.f9841d;
        }

        public String a() {
            return this.f9838a;
        }
    }

    public f(com.amazon.d.a.f fVar) {
        this.f9831d = new b(fVar);
    }

    private ActivityInfo e(Activity activity) {
        try {
            return activity.getPackageManager().getActivityInfo(activity.getComponentName(), 128);
        } catch (PackageManager.NameNotFoundException unused) {
            if (!com.amazon.a.a.o.c.f9995b) {
                return null;
            }
            f9829b.b("Unable to get info for activity: " + activity);
            return null;
        }
    }

    private Dialog f(Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(this.f9831d.a()).setMessage(this.f9831d.b()).setCancelable(false);
        AlertDialog alertDialogCreate = builder.create();
        a(activity, alertDialogCreate, this.f9831d.f(), -1);
        a(activity, alertDialogCreate, this.f9831d.e(), -3);
        a(activity, alertDialogCreate, this.f9831d.d(), -2);
        return alertDialogCreate;
    }

    private com.amazon.d.a.a n() throws com.amazon.a.a.n.a.a.e {
        try {
            if (com.amazon.a.a.o.c.f9994a) {
                f9829b.a("Blocking while awaiting customer decision: " + Thread.currentThread());
            }
            return this.f9832e.take().a();
        } catch (InterruptedException unused) {
            if (com.amazon.a.a.o.c.f9994a) {
                f9829b.a("Interrupted while awaiting decision, throwing decision expired!");
            }
            throw new com.amazon.a.a.n.a.a.e(o());
        }
    }

    private e o() {
        return l() == com.amazon.a.a.i.d.NOT_COMPATIBLE ? e.APP_NOT_COMPATIBLE : e.EXPIRATION_DURATION_ELAPSED;
    }

    private boolean p() {
        return a(this.f9831d.f()) || a(this.f9831d.e()) || a(this.f9831d.d());
    }

    @Override // com.amazon.a.a.i.b
    public Dialog d(Activity activity) {
        return f(activity);
    }

    @Override // com.amazon.a.a.e.c
    public long h() {
        return this.f9831d.c();
    }

    public com.amazon.d.a.a i() {
        if (com.amazon.a.a.o.c.f9994a) {
            f9829b.a("GetCustomerDecision: " + this.f9830c);
        }
        return n();
    }

    public String toString() {
        return "DecisionDialog: " + this.f9831d.a();
    }

    private boolean a(a aVar) {
        return (aVar == null || aVar.c() == null) ? false : true;
    }

    @Override // com.amazon.a.a.i.b
    public boolean b(Activity activity) {
        if (!p()) {
            return true;
        }
        ActivityInfo activityInfoE = e(activity);
        if (activityInfoE == null) {
            return false;
        }
        boolean z7 = activityInfoE.launchMode == 3;
        com.amazon.a.a.o.c cVar = f9829b;
        cVar.a("Single instance: " + z7);
        boolean z8 = (activityInfoE.flags & 2) != 0;
        cVar.a("Finish on task launch:" + z8);
        boolean z9 = (activityInfoE.flags & 128) != 0;
        cVar.a("No History: " + z9);
        return (z7 || z8 || z9) ? false : true;
    }

    @Override // com.amazon.a.a.i.b
    public void a(com.amazon.a.a.i.d dVar) {
        if (com.amazon.a.a.o.c.f9994a) {
            f9829b.a("Expiring Decision Dialog: Thread: " + Thread.currentThread());
        }
        this.f9830c.interrupt();
    }

    private void a(Activity activity, AlertDialog alertDialog, final a aVar, int i7) {
        if (aVar == null) {
            return;
        }
        alertDialog.setButton(i7, aVar.b(), new DialogInterface.OnClickListener() { // from class: com.amazon.a.a.n.a.f.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i8) {
                if (com.amazon.a.a.o.c.f9994a) {
                    f.f9829b.a("Choice selected!");
                }
                if (f.this.k()) {
                    f.this.f9832e.add(aVar);
                }
            }
        });
    }
}
