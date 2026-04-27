package com.google.android.play.core.integrity;

import com.google.android.gms.tasks.Task;
import com.google.android.play.core.integrity.StandardIntegrityManager;

/* JADX INFO: loaded from: classes.dex */
final class bt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bn f10167a;

    public bt(bn bnVar) {
        this.f10167a = bnVar;
    }

    public final /* synthetic */ Task a(long j4, long j5, int i4, StandardIntegrityManager.StandardIntegrityTokenRequest standardIntegrityTokenRequest) {
        return this.f10167a.d(standardIntegrityTokenRequest.a(), j4, j5, 0);
    }
}
