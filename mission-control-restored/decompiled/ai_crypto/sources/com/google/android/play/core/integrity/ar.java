package com.google.android.play.core.integrity;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

/* JADX INFO: loaded from: classes.dex */
final class ar extends ResultReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ as f11888a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ar(as asVar, Handler handler) {
        super(handler);
        this.f11888a = asVar;
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i7, Bundle bundle) {
        if (i7 == 1) {
            this.f11888a.f11889a.trySetResult(3);
        } else if (i7 == 2) {
            this.f11888a.f11889a.trySetResult(2);
        } else {
            if (i7 != 3) {
                return;
            }
            this.f11888a.f11889a.trySetResult(1);
        }
    }
}
