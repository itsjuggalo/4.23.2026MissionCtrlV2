package com.google.android.gms.measurement;

import S1.C0629m6;
import S1.InterfaceC0597i6;
import a0.AbstractC0775a;
import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;

/* JADX INFO: loaded from: classes.dex */
public final class AppMeasurementService extends Service implements InterfaceC0597i6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C0629m6 f10062a;

    private final C0629m6 c() {
        if (this.f10062a == null) {
            this.f10062a = new C0629m6(this);
        }
        return this.f10062a;
    }

    @Override // S1.InterfaceC0597i6
    public final void a(Intent intent) {
        AbstractC0775a.b(intent);
    }

    @Override // S1.InterfaceC0597i6
    public final void b(JobParameters jobParameters, boolean z4) {
        throw new UnsupportedOperationException();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return c().d(intent);
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

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i4, int i5) {
        c().c(intent, i4, i5);
        return 2;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        c();
        C0629m6.j(intent);
        return true;
    }

    @Override // S1.InterfaceC0597i6
    public final boolean zza(int i4) {
        return stopSelfResult(i4);
    }
}
