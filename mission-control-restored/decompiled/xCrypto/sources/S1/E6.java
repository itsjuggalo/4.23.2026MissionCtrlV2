package S1;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PersistableBundle;
import com.google.android.gms.internal.measurement.zzcg;
import com.google.android.gms.internal.measurement.zzch;

/* JADX INFO: loaded from: classes.dex */
public final class E6 extends M6 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AlarmManager f3924d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public A f3925e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f3926f;

    public E6(b7 b7Var) {
        super(b7Var);
        this.f3924d = (AlarmManager) this.f4245a.e().getSystemService("alarm");
    }

    private final void p() {
        JobScheduler jobScheduler = (JobScheduler) this.f4245a.e().getSystemService("jobscheduler");
        if (jobScheduler != null) {
            jobScheduler.cancel(q());
        }
    }

    private final int q() {
        if (this.f3926f == null) {
            this.f3926f = Integer.valueOf("measurement".concat(String.valueOf(this.f4245a.e().getPackageName())).hashCode());
        }
        return this.f3926f.intValue();
    }

    @Override // S1.M6
    public final boolean l() {
        AlarmManager alarmManager = this.f3924d;
        if (alarmManager != null) {
            alarmManager.cancel(r());
        }
        p();
        return false;
    }

    public final void m(long j4) {
        j();
        C0658q3 c0658q3 = this.f4245a;
        c0658q3.c();
        Context contextE = c0658q3.e();
        if (!l7.j0(contextE)) {
            c0658q3.a().v().a("Receiver not registered/enabled");
        }
        if (!l7.E(contextE, false)) {
            c0658q3.a().v().a("Service not registered/enabled");
        }
        n();
        c0658q3.a().w().b("Scheduling upload, millis", Long.valueOf(j4));
        c0658q3.f().a();
        c0658q3.w();
        if (j4 < Math.max(0L, ((Long) AbstractC0569f2.f4526M.b(null)).longValue()) && !o().c()) {
            o().b(j4);
        }
        c0658q3.c();
        Context contextE2 = c0658q3.e();
        ComponentName componentName = new ComponentName(contextE2, "com.google.android.gms.measurement.AppMeasurementJobService");
        int iQ = q();
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("action", "com.google.android.gms.measurement.UPLOAD");
        zzch.zza(contextE2, new JobInfo.Builder(iQ, componentName).setMinimumLatency(j4).setOverrideDeadline(j4 + j4).setExtras(persistableBundle).build(), "com.google.android.gms", "UploadAlarm");
    }

    public final void n() {
        j();
        this.f4245a.a().w().a("Unscheduling upload");
        AlarmManager alarmManager = this.f3924d;
        if (alarmManager != null) {
            alarmManager.cancel(r());
        }
        o().d();
        p();
    }

    public final A o() {
        if (this.f3925e == null) {
            this.f3925e = new D6(this, this.f3955b.f0());
        }
        return this.f3925e;
    }

    public final PendingIntent r() {
        Context contextE = this.f4245a.e();
        return PendingIntent.getBroadcast(contextE, 0, new Intent().setClassName(contextE, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), zzcg.zza);
    }
}
