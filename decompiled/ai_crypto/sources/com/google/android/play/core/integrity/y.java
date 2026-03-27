package com.google.android.play.core.integrity;

import F2.G;
import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

/* JADX INFO: loaded from: classes.dex */
abstract class y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f11979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f11980c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f11982e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final G f11978a = new G("IntegrityDialogWrapper");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f11981d = new Object();

    public y(String str, long j7) {
        this.f11979b = str;
        this.f11980c = j7;
    }

    public final Task a(Activity activity, int i7) {
        synchronized (this.f11981d) {
            try {
                if (this.f11982e) {
                    return Tasks.forResult(0);
                }
                this.f11982e = true;
                this.f11978a.a("checkAndShowDialog(%s)", Integer.valueOf(i7));
                Bundle bundle = new Bundle();
                bundle.putInt("dialog.intent.type", i7);
                bundle.putString("package.name", this.f11979b);
                bundle.putInt("playcore.integrity.version.major", 1);
                bundle.putInt("playcore.integrity.version.minor", 3);
                bundle.putInt("playcore.integrity.version.patch", 0);
                bundle.putLong("request.token.sid", this.f11980c);
                return b(activity, bundle);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract Task b(Activity activity, Bundle bundle);
}
