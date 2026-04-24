package k4;

import android.app.job.JobParameters;
import android.app.job.JobWorkItem;
import android.content.Intent;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class k implements InterfaceC0784j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JobWorkItem f7908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f7909b;

    public k(l lVar, JobWorkItem jobWorkItem) {
        this.f7909b = lVar;
        this.f7908a = jobWorkItem;
    }

    @Override // k4.InterfaceC0784j
    public final void a() {
        synchronized (this.f7909b.f7911b) {
            JobParameters jobParameters = this.f7909b.f7912c;
            if (jobParameters != null) {
                try {
                    jobParameters.completeWork(this.f7908a);
                } catch (IllegalArgumentException e) {
                    Log.e("JobServiceEngineImpl", "IllegalArgumentException: Failed to run mParams.completeWork(mJobWork)!", e);
                } catch (SecurityException e2) {
                    Log.e("JobServiceEngineImpl", "SecurityException: Failed to run mParams.completeWork(mJobWork)!", e2);
                }
            }
        }
    }

    @Override // k4.InterfaceC0784j
    public final Intent getIntent() {
        return this.f7908a.getIntent();
    }
}
