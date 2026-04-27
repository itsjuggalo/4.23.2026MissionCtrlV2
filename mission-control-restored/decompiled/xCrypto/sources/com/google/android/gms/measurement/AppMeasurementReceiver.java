package com.google.android.gms.measurement;

import S1.U2;
import S1.V2;
import a0.AbstractC0775a;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public final class AppMeasurementReceiver extends AbstractC0775a implements U2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public V2 f10061c;

    @Override // S1.U2
    public void a(Context context, Intent intent) {
        AbstractC0775a.c(context, intent);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.f10061c == null) {
            this.f10061c = new V2(this);
        }
        this.f10061c.a(context, intent);
    }
}
