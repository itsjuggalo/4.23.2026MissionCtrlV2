package k4;

import android.app.job.JobParameters;
import android.app.job.JobServiceEngine;

/* JADX INFO: loaded from: classes.dex */
public final class l extends JobServiceEngine {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.flutter.plugins.firebase.messaging.a f7910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f7911b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JobParameters f7912c;

    public l(io.flutter.plugins.firebase.messaging.a aVar) {
        super(aVar);
        this.f7911b = new Object();
        this.f7910a = aVar;
    }

    public final boolean onStartJob(JobParameters jobParameters) {
        this.f7912c = jobParameters;
        this.f7910a.a(false);
        return true;
    }

    public final boolean onStopJob(JobParameters jobParameters) {
        f.d dVar = this.f7910a.f7233c;
        if (dVar != null) {
            ((io.flutter.plugins.firebase.messaging.a) dVar.f6384d).c();
        }
        synchronized (this.f7911b) {
            this.f7912c = null;
        }
        return true;
    }
}
