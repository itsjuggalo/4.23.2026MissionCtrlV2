package com.google.android.play.core.integrity;

import X1.G;
import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

/* JADX INFO: loaded from: classes.dex */
abstract class y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f10197c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f10199e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final G f10195a = new G("IntegrityDialogWrapper");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f10198d = new Object();

    public y(String str, long j4) {
        this.f10196b = str;
        this.f10197c = j4;
    }

    public final Task a(Activity activity, int i4) {
        synchronized (this.f10198d) {
            try {
                if (this.f10199e) {
                    return Tasks.forResult(0);
                }
                this.f10199e = true;
                this.f10195a.a("checkAndShowDialog(%s)", Integer.valueOf(i4));
                Bundle bundle = new Bundle();
                bundle.putInt("dialog.intent.type", i4);
                bundle.putString("package.name", this.f10196b);
                bundle.putInt("playcore.integrity.version.major", 1);
                bundle.putInt("playcore.integrity.version.minor", 3);
                bundle.putInt("playcore.integrity.version.patch", 0);
                bundle.putLong("request.token.sid", this.f10197c);
                return b(activity, bundle);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract Task b(Activity activity, Bundle bundle);
}
