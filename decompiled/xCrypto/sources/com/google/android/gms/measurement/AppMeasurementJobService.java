package com.google.android.gms.measurement;

import S1.C0629m6;
import S1.InterfaceC0597i6;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public final class AppMeasurementJobService extends JobService implements InterfaceC0597i6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C0629m6 f10060a;

    @Override // S1.InterfaceC0597i6
    public final void a(Intent intent) {
    }

    @Override // S1.InterfaceC0597i6
    public final void b(JobParameters jobParameters, boolean z4) {
        jobFinished(jobParameters, false);
    }

    public final C0629m6 c() {
        if (this.f10060a == null) {
            this.f10060a = new C0629m6(this);
        }
        return this.f10060a;
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
        C0629m6.i(intent);
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
        C0629m6.j(intent);
        return true;
    }

    @Override // S1.InterfaceC0597i6
    public final boolean zza(int i4) {
        throw new UnsupportedOperationException();
    }
}
