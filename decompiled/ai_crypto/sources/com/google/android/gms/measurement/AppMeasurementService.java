package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import i2.C1869m6;
import i2.InterfaceC1837i6;
import q0.AbstractC2549a;

/* JADX INFO: loaded from: classes.dex */
public final class AppMeasurementService extends Service implements InterfaceC1837i6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C1869m6 f11245a;

    private final C1869m6 c() {
        if (this.f11245a == null) {
            this.f11245a = new C1869m6(this);
        }
        return this.f11245a;
    }

    @Override // i2.InterfaceC1837i6
    public final void a(Intent intent) {
        AbstractC2549a.b(intent);
    }

    @Override // i2.InterfaceC1837i6
    public final void b(JobParameters jobParameters, boolean z7) {
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
        C1869m6.i(intent);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i7, int i8) {
        c().c(intent, i7, i8);
        return 2;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        c();
        C1869m6.j(intent);
        return true;
    }

    @Override // i2.InterfaceC1837i6
    public final boolean zza(int i7) {
        return stopSelfResult(i7);
    }
}
