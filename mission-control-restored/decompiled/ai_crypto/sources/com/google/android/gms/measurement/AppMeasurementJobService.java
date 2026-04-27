package com.google.android.gms.measurement;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import i2.C1869m6;
import i2.InterfaceC1837i6;

/* JADX INFO: loaded from: classes.dex */
public final class AppMeasurementJobService extends JobService implements InterfaceC1837i6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C1869m6 f11243a;

    @Override // i2.InterfaceC1837i6
    public final void a(Intent intent) {
    }

    @Override // i2.InterfaceC1837i6
    public final void b(JobParameters jobParameters, boolean z7) {
        jobFinished(jobParameters, false);
    }

    public final C1869m6 c() {
        if (this.f11243a == null) {
            this.f11243a = new C1869m6(this);
        }
        return this.f11243a;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        c().a();
    }

    @Override // android.app.Service
    public void onDestroy() {
        c().b();
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        c();
        C1869m6.i(intent);
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        c().e(jobParameters);
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        c();
        C1869m6.j(intent);
        return true;
    }

    @Override // i2.InterfaceC1837i6
    public final boolean zza(int i7) {
        throw new UnsupportedOperationException();
    }
}
