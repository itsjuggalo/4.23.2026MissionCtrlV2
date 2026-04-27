package com.google.android.play.core.integrity;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

/* JADX INFO: loaded from: classes.dex */
final class ar extends ResultReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ as f10105a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ar(as asVar, Handler handler) {
        super(handler);
        this.f10105a = asVar;
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i4, Bundle bundle) {
        if (i4 == 1) {
            this.f10105a.f10106a.trySetResult(3);
        } else if (i4 == 2) {
            this.f10105a.f10106a.trySetResult(2);
        } else {
            if (i4 != 3) {
                return;
            }
            this.f10105a.f10106a.trySetResult(1);
        }
    }
}
