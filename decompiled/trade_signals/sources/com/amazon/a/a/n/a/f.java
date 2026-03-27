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
    private static final com.amazon.a.a.o.c f13940b = new com.amazon.a.a.o.c("DecisionDialog");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b f13942d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final BlockingQueue<a> f13943e = new LinkedBlockingQueue();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Thread f13941c = Thread.currentThread();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.amazon.d.a.a f13946a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f13947b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Intent f13948c;

        public a(com.amazon.d.a.a aVar) {
            this.f13946a = aVar;
            this.f13947b = aVar.a();
            this.f13948c = aVar.b();
        }

        public com.amazon.d.a.a a() {
            return this.f13946a;
        }

        public String b() {
            return this.f13947b;
        }

        public Intent c() {
            return this.f13948c;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f13949a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f13950b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f13951c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final a f13952d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final a f13953e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final a f13954f;

        public b(com.amazon.d.a.f fVar) {
            this.f13949a = fVar.b();
            this.f13950b = fVar.c();
            this.f13951c = fVar.d();
            this.f13952d = a(fVar.e());
            this.f13953e = a(fVar.f());
            this.f13954f = a(fVar.g());
        }

        private a a(com.amazon.d.a.a aVar) {
            if (aVar == null) {
                return null;
            }
            return new a(aVar);
        }

        public String b() {
            return this.f13950b;
        }

        public long c() {
            return this.f13951c;
        }

        public a d() {
            return this.f13954f;
        }

        public a e() {
            return this.f13953e;
        }

        public a f() {
            return this.f13952d;
        }

        public String a() {
            return this.f13949a;
        }
    }

    public f(com.amazon.d.a.f fVar) {
        this.f13942d = new b(fVar);
    }

    private void a(Activity activity, AlertDialog alertDialog, final a aVar, int i8) {
        if (aVar == null) {
            return;
        }
        alertDialog.setButton(i8, aVar.b(), new DialogInterface.OnClickListener() { // from class: com.amazon.a.a.n.a.f.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i9) {
                if (com.amazon.a.a.o.c.f14105a) {
                    f.f13940b.a("Choice selected!");
                }
                if (f.this.k()) {
                    f.this.f13943e.add(aVar);
                }
            }
        });
    }

    private ActivityInfo e(Activity activity) {
        try {
            return activity.getPackageManager().getActivityInfo(activity.getComponentName(), 128);
        } catch (PackageManager.NameNotFoundException unused) {
            if (!com.amazon.a.a.o.c.f14106b) {
                return null;
            }
            f13940b.b("Unable to get info for activity: " + activity);
            return null;
        }
    }

    private Dialog f(Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(this.f13942d.a()).setMessage(this.f13942d.b()).setCancelable(false);
        AlertDialog alertDialogCreate = builder.create();
        a(activity, alertDialogCreate, this.f13942d.f(), -1);
        a(activity, alertDialogCreate, this.f13942d.e(), -3);
        a(activity, alertDialogCreate, this.f13942d.d(), -2);
        return alertDialogCreate;
    }

    private com.amazon.d.a.a n() throws com.amazon.a.a.n.a.a.e {
        try {
            if (com.amazon.a.a.o.c.f14105a) {
                f13940b.a("Blocking while awaiting customer decision: " + Thread.currentThread());
            }
            return this.f13943e.take().a();
        } catch (InterruptedException unused) {
            if (com.amazon.a.a.o.c.f14105a) {
                f13940b.a("Interrupted while awaiting decision, throwing decision expired!");
            }
            throw new com.amazon.a.a.n.a.a.e(o());
        }
    }

    private e o() {
        return l() == com.amazon.a.a.i.d.NOT_COMPATIBLE ? e.APP_NOT_COMPATIBLE : e.EXPIRATION_DURATION_ELAPSED;
    }

    private boolean p() {
        return a(this.f13942d.f()) || a(this.f13942d.e()) || a(this.f13942d.d());
    }

    @Override // com.amazon.a.a.i.b
    public Dialog d(Activity activity) {
        return f(activity);
    }

    @Override // com.amazon.a.a.e.c
    public long h() {
        return this.f13942d.c();
    }

    public com.amazon.d.a.a i() {
        if (com.amazon.a.a.o.c.f14105a) {
            f13940b.a("GetCustomerDecision: " + this.f13941c);
        }
        return n();
    }

    public String toString() {
        return "DecisionDialog: " + this.f13942d.a();
    }

    @Override // com.amazon.a.a.i.b
    public void a(com.amazon.a.a.i.d dVar) {
        if (com.amazon.a.a.o.c.f14105a) {
            f13940b.a("Expiring Decision Dialog: Thread: " + Thread.currentThread());
        }
        this.f13941c.interrupt();
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
        com.amazon.a.a.o.c cVar = f13940b;
        cVar.a("Single instance: " + z7);
        boolean z8 = (activityInfoE.flags & 2) != 0;
        cVar.a("Finish on task launch:" + z8);
        boolean z9 = (activityInfoE.flags & 128) != 0;
        cVar.a("No History: " + z9);
        return (z7 || z8 || z9) ? false : true;
    }

    private boolean a(a aVar) {
        return (aVar == null || aVar.c() == null) ? false : true;
    }
}
