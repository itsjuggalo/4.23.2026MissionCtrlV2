package S1;

import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.internal.measurement.zzfb;
import java.util.Objects;

/* JADX INFO: renamed from: S1.m6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0629m6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4757a;

    public C0629m6(Context context) {
        AbstractC0940s.k(context);
        this.f4757a = context;
    }

    public static final void i(Intent intent) {
        if (intent == null) {
            Log.e("FA", "onRebind called with null intent");
        } else {
            Log.v("FA", "onRebind called. action: ".concat(String.valueOf(intent.getAction())));
        }
    }

    public static final boolean j(Intent intent) {
        if (intent == null) {
            Log.e("FA", "onUnbind called with null intent");
            return true;
        }
        Log.v("FA", "onUnbind called for intent. action: ".concat(String.valueOf(intent.getAction())));
        return true;
    }

    public final void a() {
        Log.v("FA", this.f4757a.getClass().getSimpleName().concat(" is starting up."));
    }

    public final void b() {
        Log.v("FA", this.f4757a.getClass().getSimpleName().concat(" is shutting down."));
    }

    public final int c(final Intent intent, int i4, final int i5) {
        if (intent == null) {
            Log.w("FA", "AppMeasurementService started with null intent");
            return 2;
        }
        Context context = this.f4757a;
        C0658q3 c0658q3O = C0658q3.O(context, null, null);
        final C2 c2A = c0658q3O.a();
        String action = intent.getAction();
        c0658q3O.c();
        c2A.w().c("Local AppMeasurementService called. startId, action", Integer.valueOf(i5), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            k(b7.F(context), new Runnable() { // from class: S1.l6
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.f4732a.f(i5, c2A, intent);
                }
            });
        }
        return 2;
    }

    public final IBinder d(Intent intent) {
        if (intent == null) {
            Log.e("FA", "onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new S3(b7.F(this.f4757a), null);
        }
        Log.w("FA", "onBind received unknown action: ".concat(String.valueOf(action)));
        return null;
    }

    public final boolean e(final JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("action");
        Log.v("FA", "onStartJob received action: ".concat(String.valueOf(string)));
        if (Objects.equals(string, "com.google.android.gms.measurement.UPLOAD")) {
            String str = (String) AbstractC0940s.k(string);
            b7 b7VarF = b7.F(this.f4757a);
            final C2 c2A = b7VarF.a();
            b7VarF.c();
            c2A.w().b("Local AppMeasurementJobService called. action", str);
            k(b7VarF, new Runnable() { // from class: S1.j6
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.f4703a.g(c2A, jobParameters);
                }
            });
        }
        if (!Objects.equals(string, "com.google.android.gms.measurement.SCION_UPLOAD")) {
            return true;
        }
        zzfb.zza(this.f4757a, null).zzw(new Runnable() { // from class: S1.k6
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f4725a.h(jobParameters);
            }
        });
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ void f(int i4, C2 c22, Intent intent) {
        Context context = this.f4757a;
        InterfaceC0597i6 interfaceC0597i6 = (InterfaceC0597i6) context;
        if (interfaceC0597i6.zza(i4)) {
            c22.w().b("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i4));
            C0658q3.O(context, null, null).a().w().a("Completed wakeful intent.");
            interfaceC0597i6.a(intent);
        }
    }

    public final /* synthetic */ void g(C2 c22, JobParameters jobParameters) {
        c22.w().a("AppMeasurementJobService processed last upload request.");
        ((InterfaceC0597i6) this.f4757a).b(jobParameters, false);
    }

    public final /* synthetic */ void h(JobParameters jobParameters) {
        Log.v("FA", "[sgtm] AppMeasurementJobService processed last Scion upload request.");
        ((InterfaceC0597i6) this.f4757a).b(jobParameters, false);
    }

    public final void k(b7 b7Var, Runnable runnable) {
        b7Var.b().t(new RunnableC0589h6(this, b7Var, runnable));
    }
}
