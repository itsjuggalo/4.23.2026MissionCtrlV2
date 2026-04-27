package com.google.android.play.core.integrity;

import com.google.android.gms.tasks.Task;
import com.google.android.play.core.integrity.StandardIntegrityManager;

/* JADX INFO: loaded from: classes.dex */
final class bt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bn f5414a;

    public bt(bn bnVar) {
        this.f5414a = bnVar;
    }

    public final /* synthetic */ Task a(long j4, long j6, int i, StandardIntegrityManager.StandardIntegrityTokenRequest standardIntegrityTokenRequest) {
        return this.f5414a.d(standardIntegrityTokenRequest.a(), j4, j6, 0);
    }
}
