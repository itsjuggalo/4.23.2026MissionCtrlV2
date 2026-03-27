package com.amazon.a.a.n.a;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes.dex */
public class f extends com.amazon.a.a.i.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.amazon.a.a.o.c f8644b = new com.amazon.a.a.o.c("DecisionDialog");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b f8646d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final BlockingQueue<a> f8647e = new LinkedBlockingQueue();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Thread f8645c = Thread.currentThread();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.amazon.d.a.a f8650a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f8651b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Intent f8652c;

        public a(com.amazon.d.a.a aVar) {
            this.f8650a = aVar;
            this.f8651b = aVar.a();
            this.f8652c = aVar.b();
        }

        public com.amazon.d.a.a a() {
            return this.f8650a;
        }

        public String b() {
            return this.f8651b;
        }

        public Intent c() {
            return this.f8652c;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f8653a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f8654b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f8655c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final a f8656d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final a f8657e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final a f8658f;

        public b(com.amazon.d.a.f fVar) {
            this.f8653a = fVar.b();
            this.f8654b = fVar.c();
            this.f8655c = fVar.d();
            this.f8656d = a(fVar.e());
            this.f8657e = a(fVar.f());
            this.f8658f = a(fVar.g());
        }

        private a a(com.amazon.d.a.a aVar) {
            if (aVar == null) {
                return null;
            }
            return new a(aVar);
        }

        public String b() {
            return this.f8654b;
        }

        public long c() {
            return this.f8655c;
        }

        public a d() {
            return this.f8658f;
        }

        public a e() {
            return this.f8657e;
        }

        public a f() {
            return this.f8656d;
        }

        public String a() {
            return this.f8653a;
        }
    }

    public f(com.amazon.d.a.f fVar) {
        this.f8646d = new b(fVar);
    }

    private ActivityInfo e(Activity activity) {
        try {
            return activity.getPackageManager().getActivityInfo(activity.getComponentName(), UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
        } catch (PackageManager.NameNotFoundException unused) {
            if (!com.amazon.a.a.o.c.f8810b) {
                return null;
            }
            f8644b.b("Unable to get info for activity: " + activity);
            return null;
        }
    }

    private Dialog f(Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(this.f8646d.a()).setMessage(this.f8646d.b()).setCancelable(false);
        AlertDialog alertDialogCreate = builder.create();
        a(activity, alertDialogCreate, this.f8646d.f(), -1);
        a(activity, alertDialogCreate, this.f8646d.e(), -3);
        a(activity, alertDialogCreate, this.f8646d.d(), -2);
        return alertDialogCreate;
    }

    private com.amazon.d.a.a n() throws com.amazon.a.a.n.a.a.e {
        try {
            if (com.amazon.a.a.o.c.f8809a) {
                f8644b.a("Blocking while awaiting customer decision: " + Thread.currentThread());
            }
            return this.f8647e.take().a();
        } catch (InterruptedException unused) {
            if (com.amazon.a.a.o.c.f8809a) {
                f8644b.a("Interrupted while awaiting decision, throwing decision expired!");
            }
            throw new com.amazon.a.a.n.a.a.e(o());
        }
    }

    private e o() {
        return l() == com.amazon.a.a.i.d.NOT_COMPATIBLE ? e.APP_NOT_COMPATIBLE : e.EXPIRATION_DURATION_ELAPSED;
    }

    private boolean p() {
        return a(this.f8646d.f()) || a(this.f8646d.e()) || a(this.f8646d.d());
    }

    @Override // com.amazon.a.a.i.b
    public Dialog d(Activity activity) {
        return f(activity);
    }

    @Override // com.amazon.a.a.e.c
    public long h() {
        return this.f8646d.c();
    }

    public com.amazon.d.a.a i() {
        if (com.amazon.a.a.o.c.f8809a) {
            f8644b.a("GetCustomerDecision: " + this.f8645c);
        }
        return n();
    }

    public String toString() {
        return "DecisionDialog: " + this.f8646d.a();
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
        boolean z4 = activityInfoE.launchMode == 3;
        com.amazon.a.a.o.c cVar = f8644b;
        cVar.a("Single instance: " + z4);
        boolean z5 = (activityInfoE.flags & 2) != 0;
        cVar.a("Finish on task launch:" + z5);
        boolean z6 = (activityInfoE.flags & UserMetadata.MAX_ROLLOUT_ASSIGNMENTS) != 0;
        cVar.a("No History: " + z6);
        return (z4 || z5 || z6) ? false : true;
    }

    @Override // com.amazon.a.a.i.b
    public void a(com.amazon.a.a.i.d dVar) {
        if (com.amazon.a.a.o.c.f8809a) {
            f8644b.a("Expiring Decision Dialog: Thread: " + Thread.currentThread());
        }
        this.f8645c.interrupt();
    }

    private void a(Activity activity, AlertDialog alertDialog, final a aVar, int i4) {
        if (aVar == null) {
            return;
        }
        alertDialog.setButton(i4, aVar.b(), new DialogInterface.OnClickListener() { // from class: com.amazon.a.a.n.a.f.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i5) {
                if (com.amazon.a.a.o.c.f8809a) {
                    f.f8644b.a("Choice selected!");
                }
                if (f.this.k()) {
                    f.this.f8647e.add(aVar);
                }
            }
        });
    }
}
