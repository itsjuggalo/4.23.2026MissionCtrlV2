package i2;

import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.internal.measurement.zzfb;
import java.util.Objects;

/* JADX INFO: renamed from: i2.m6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1869m6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f15916a;

    public C1869m6(Context context) {
        AbstractC1207s.k(context);
        this.f15916a = context;
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
        Log.v("FA", this.f15916a.getClass().getSimpleName().concat(" is starting up."));
    }

    public final void b() {
        Log.v("FA", this.f15916a.getClass().getSimpleName().concat(" is shutting down."));
    }

    public final int c(final Intent intent, int i7, final int i8) {
        if (intent == null) {
            Log.w("FA", "AppMeasurementService started with null intent");
            return 2;
        }
        Context context = this.f15916a;
        C1898q3 c1898q3O = C1898q3.O(context, null, null);
        final C2 c2A = c1898q3O.a();
        String action = intent.getAction();
        c1898q3O.c();
        c2A.w().c("Local AppMeasurementService called. startId, action", Integer.valueOf(i8), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            k(b7.F(context), new Runnable() { // from class: i2.l6
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.f15891a.f(i8, c2A, intent);
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
            return new S3(b7.F(this.f15916a), null);
        }
        Log.w("FA", "onBind received unknown action: ".concat(String.valueOf(action)));
        return null;
    }

    public final boolean e(final JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("action");
        Log.v("FA", "onStartJob received action: ".concat(String.valueOf(string)));
        if (Objects.equals(string, "com.google.android.gms.measurement.UPLOAD")) {
            String str = (String) AbstractC1207s.k(string);
            b7 b7VarF = b7.F(this.f15916a);
            final C2 c2A = b7VarF.a();
            b7VarF.c();
            c2A.w().b("Local AppMeasurementJobService called. action", str);
            k(b7VarF, new Runnable() { // from class: i2.j6
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.f15862a.g(c2A, jobParameters);
                }
            });
        }
        if (!Objects.equals(string, "com.google.android.gms.measurement.SCION_UPLOAD")) {
            return true;
        }
        zzfb.zza(this.f15916a, null).zzw(new Runnable() { // from class: i2.k6
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f15884a.h(jobParameters);
            }
        });
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ void f(int i7, C2 c22, Intent intent) {
        Context context = this.f15916a;
        InterfaceC1837i6 interfaceC1837i6 = (InterfaceC1837i6) context;
        if (interfaceC1837i6.zza(i7)) {
            c22.w().b("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i7));
            C1898q3.O(context, null, null).a().w().a("Completed wakeful intent.");
            interfaceC1837i6.a(intent);
        }
    }

    public final /* synthetic */ void g(C2 c22, JobParameters jobParameters) {
        c22.w().a("AppMeasurementJobService processed last upload request.");
        ((InterfaceC1837i6) this.f15916a).b(jobParameters, false);
    }

    public final /* synthetic */ void h(JobParameters jobParameters) {
        Log.v("FA", "[sgtm] AppMeasurementJobService processed last Scion upload request.");
        ((InterfaceC1837i6) this.f15916a).b(jobParameters, false);
    }

    public final void k(b7 b7Var, Runnable runnable) {
        b7Var.b().t(new RunnableC1829h6(this, b7Var, runnable));
    }
}
