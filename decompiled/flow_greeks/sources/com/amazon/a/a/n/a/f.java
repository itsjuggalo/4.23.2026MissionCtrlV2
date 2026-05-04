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

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class f extends com.amazon.a.a.i.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.amazon.a.a.o.c f4456b = new com.amazon.a.a.o.c("DecisionDialog");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b f4458d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final BlockingQueue<a> f4459e = new LinkedBlockingQueue();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Thread f4457c = Thread.currentThread();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.amazon.d.a.a f4462a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f4463b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Intent f4464c;

        public a(com.amazon.d.a.a aVar) {
            this.f4462a = aVar;
            this.f4463b = aVar.a();
            this.f4464c = aVar.b();
        }

        public com.amazon.d.a.a a() {
            return this.f4462a;
        }

        public String b() {
            return this.f4463b;
        }

        public Intent c() {
            return this.f4464c;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f4465a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f4466b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f4467c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final a f4468d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final a f4469e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final a f4470f;

        public b(com.amazon.d.a.f fVar) {
            this.f4465a = fVar.b();
            this.f4466b = fVar.c();
            this.f4467c = fVar.d();
            this.f4468d = a(fVar.e());
            this.f4469e = a(fVar.f());
            this.f4470f = a(fVar.g());
        }

        private a a(com.amazon.d.a.a aVar) {
            if (aVar == null) {
                return null;
            }
            return new a(aVar);
        }

        public String b() {
            return this.f4466b;
        }

        public long c() {
            return this.f4467c;
        }

        public a d() {
            return this.f4470f;
        }

        public a e() {
            return this.f4469e;
        }

        public a f() {
            return this.f4468d;
        }

        public String a() {
            return this.f4465a;
        }
    }

    public f(com.amazon.d.a.f fVar) {
        this.f4458d = new b(fVar);
    }

    private ActivityInfo e(Activity activity) {
        try {
            return activity.getPackageManager().getActivityInfo(activity.getComponentName(), 128);
        } catch (PackageManager.NameNotFoundException unused) {
            if (!com.amazon.a.a.o.c.f4604b) {
                return null;
            }
            f4456b.b("Unable to get info for activity: " + activity);
            return null;
        }
    }

    private Dialog f(Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(this.f4458d.a()).setMessage(this.f4458d.b()).setCancelable(false);
        AlertDialog alertDialogCreate = builder.create();
        a(activity, alertDialogCreate, this.f4458d.f(), -1);
        a(activity, alertDialogCreate, this.f4458d.e(), -3);
        a(activity, alertDialogCreate, this.f4458d.d(), -2);
        return alertDialogCreate;
    }

    private com.amazon.d.a.a n() throws com.amazon.a.a.n.a.a.e {
        try {
            if (com.amazon.a.a.o.c.f4603a) {
                f4456b.a("Blocking while awaiting customer decision: " + Thread.currentThread());
            }
            return this.f4459e.take().a();
        } catch (InterruptedException unused) {
            if (com.amazon.a.a.o.c.f4603a) {
                f4456b.a("Interrupted while awaiting decision, throwing decision expired!");
            }
            throw new com.amazon.a.a.n.a.a.e(o());
        }
    }

    private e o() {
        return l() == com.amazon.a.a.i.d.NOT_COMPATIBLE ? e.APP_NOT_COMPATIBLE : e.EXPIRATION_DURATION_ELAPSED;
    }

    private boolean p() {
        return a(this.f4458d.f()) || a(this.f4458d.e()) || a(this.f4458d.d());
    }

    @Override // com.amazon.a.a.i.b
    public Dialog d(Activity activity) {
        return f(activity);
    }

    @Override // com.amazon.a.a.e.c
    public long h() {
        return this.f4458d.c();
    }

    public com.amazon.d.a.a i() {
        if (com.amazon.a.a.o.c.f4603a) {
            f4456b.a("GetCustomerDecision: " + this.f4457c);
        }
        return n();
    }

    public String toString() {
        return "DecisionDialog: " + this.f4458d.a();
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
        boolean z10 = activityInfoE.launchMode == 3;
        com.amazon.a.a.o.c cVar = f4456b;
        cVar.a("Single instance: " + z10);
        boolean z11 = (activityInfoE.flags & 2) != 0;
        cVar.a("Finish on task launch:" + z11);
        boolean z12 = (activityInfoE.flags & 128) != 0;
        cVar.a("No History: " + z12);
        return (z10 || z11 || z12) ? false : true;
    }

    @Override // com.amazon.a.a.i.b
    public void a(com.amazon.a.a.i.d dVar) {
        if (com.amazon.a.a.o.c.f4603a) {
            f4456b.a("Expiring Decision Dialog: Thread: " + Thread.currentThread());
        }
        this.f4457c.interrupt();
    }

    private void a(Activity activity, AlertDialog alertDialog, final a aVar, int i10) {
        if (aVar == null) {
            return;
        }
        alertDialog.setButton(i10, aVar.b(), new DialogInterface.OnClickListener() { // from class: com.amazon.a.a.n.a.f.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i11) {
                if (com.amazon.a.a.o.c.f4603a) {
                    f.f4456b.a("Choice selected!");
                }
                if (f.this.k()) {
                    f.this.f4459e.add(aVar);
                }
            }
        });
    }
}
