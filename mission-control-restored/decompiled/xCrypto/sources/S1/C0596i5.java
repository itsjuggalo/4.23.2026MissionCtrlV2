package S1;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.PersistableBundle;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.internal.measurement.zzin;

/* JADX INFO: renamed from: S1.i5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0596i5 extends AbstractC0593i2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JobScheduler f4691c;

    public C0596i5(C0658q3 c0658q3) {
        super(c0658q3);
    }

    @Override // S1.AbstractC0593i2
    public final boolean m() {
        return true;
    }

    @Override // S1.AbstractC0593i2
    public final void n() {
        this.f4691c = (JobScheduler) this.f4245a.e().getSystemService("jobscheduler");
    }

    public final void o(long j4) {
        j();
        h();
        JobScheduler jobScheduler = this.f4691c;
        if (jobScheduler != null && jobScheduler.getPendingJob(p()) != null) {
            this.f4245a.a().w().a("[sgtm] There's an existing pending job, skip this schedule.");
            return;
        }
        zzin zzinVarQ = q();
        if (zzinVarQ != zzin.CLIENT_UPLOAD_ELIGIBLE) {
            this.f4245a.a().w().b("[sgtm] Not eligible for Scion upload", zzinVarQ.name());
            return;
        }
        C0658q3 c0658q3 = this.f4245a;
        c0658q3.a().w().b("[sgtm] Scheduling Scion upload, millis", Long.valueOf(j4));
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("action", "com.google.android.gms.measurement.SCION_UPLOAD");
        c0658q3.a().w().b("[sgtm] Scion upload job scheduled with result", ((JobScheduler) AbstractC0940s.k(this.f4691c)).schedule(new JobInfo.Builder(p(), new ComponentName(c0658q3.e(), "com.google.android.gms.measurement.AppMeasurementJobService")).setRequiredNetworkType(1).setMinimumLatency(j4).setOverrideDeadline(j4 + j4).setExtras(persistableBundle).build()) == 1 ? "SUCCESS" : "FAILURE");
    }

    public final int p() {
        return "measurement-client".concat(String.valueOf(this.f4245a.e().getPackageName())).hashCode();
    }

    public final zzin q() {
        j();
        h();
        if (this.f4691c == null) {
            return zzin.MISSING_JOB_SCHEDULER;
        }
        C0658q3 c0658q3 = this.f4245a;
        if (!c0658q3.w().P()) {
            return zzin.NOT_ENABLED_IN_MANIFEST;
        }
        C0658q3 c0658q32 = this.f4245a;
        return c0658q32.L().u() >= 119000 ? !l7.F(c0658q3.e(), "com.google.android.gms.measurement.AppMeasurementJobService") ? zzin.MEASUREMENT_SERVICE_NOT_ENABLED : !c0658q32.J().y() ? zzin.NON_PLAY_MODE : zzin.CLIENT_UPLOAD_ELIGIBLE : zzin.SDK_TOO_OLD;
    }
}
