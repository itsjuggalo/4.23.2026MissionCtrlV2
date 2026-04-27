package com.google.android.play.core.integrity;

import com.google.android.gms.tasks.Task;
import com.google.android.play.core.integrity.StandardIntegrityManager;

/* JADX INFO: loaded from: classes.dex */
final class bt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bn f11950a;

    public bt(bn bnVar) {
        this.f11950a = bnVar;
    }

    public final /* synthetic */ Task a(long j7, long j8, int i7, StandardIntegrityManager.StandardIntegrityTokenRequest standardIntegrityTokenRequest) {
        return this.f11950a.d(standardIntegrityTokenRequest.a(), j7, j8, 0);
    }
}
