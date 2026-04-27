package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import a1.p;
import a1.u;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import l1.AbstractC1589a;

/* JADX INFO: loaded from: classes.dex */
public class JobInfoSchedulerService extends JobService {
    @Override // android.app.job.JobService
    public boolean onStartJob(final JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString("extras");
        int i4 = jobParameters.getExtras().getInt("priority");
        int i5 = jobParameters.getExtras().getInt("attemptNumber");
        u.f(getApplicationContext());
        p.a aVarD = p.a().b(string).d(AbstractC1589a.b(i4));
        if (string2 != null) {
            aVarD.c(Base64.decode(string2, 0));
        }
        u.c().e().m(aVarD.a(), i5, new Runnable() { // from class: h1.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f12104a.jobFinished(jobParameters, false);
            }
        });
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
