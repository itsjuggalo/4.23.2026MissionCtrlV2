package com.google.android.gms.measurement;

import android.content.Context;
import android.content.Intent;
import i2.U2;
import i2.V2;
import q0.AbstractC2549a;

/* JADX INFO: loaded from: classes.dex */
public final class AppMeasurementReceiver extends AbstractC2549a implements U2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public V2 f11244c;

    @Override // i2.U2
    public void a(Context context, Intent intent) {
        AbstractC2549a.c(context, intent);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.f11244c == null) {
            this.f11244c = new V2(this);
        }
        this.f11244c.a(context, intent);
    }
}
