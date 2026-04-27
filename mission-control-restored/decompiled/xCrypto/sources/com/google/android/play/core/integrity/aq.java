package com.google.android.play.core.integrity;

import android.app.Activity;
import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes.dex */
final class aq extends IntegrityTokenResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final y f10104b;

    public aq(String str, y yVar) {
        this.f10103a = str;
        this.f10104b = yVar;
    }

    @Override // com.google.android.play.core.integrity.IntegrityTokenResponse
    public final Task<Integer> showDialog(Activity activity, int i4) {
        return this.f10104b.a(activity, i4);
    }

    @Override // com.google.android.play.core.integrity.IntegrityTokenResponse
    public final String token() {
        return this.f10103a;
    }
}
