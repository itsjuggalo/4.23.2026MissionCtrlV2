package com.google.android.play.core.integrity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

/* JADX INFO: loaded from: classes.dex */
abstract class y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f5441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f5442c;
    private boolean e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final S1.z f5440a = new S1.z("IntegrityDialogWrapper");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f5443d = new Object();

    public y(String str, long j4) {
        this.f5441b = str;
        this.f5442c = j4;
    }

    public final Task a(Activity activity, int i) {
        synchronized (this.f5443d) {
            try {
                if (this.e) {
                    return Tasks.forResult(0);
                }
                this.e = true;
                S1.z zVar = this.f5440a;
                Object[] objArr = {Integer.valueOf(i)};
                zVar.getClass();
                if (Log.isLoggable("PlayCore", 3)) {
                    Log.d("PlayCore", S1.z.c(zVar.f2879a, "checkAndShowDialog(%s)", objArr));
                }
                Bundle bundle = new Bundle();
                bundle.putInt("dialog.intent.type", i);
                bundle.putString("package.name", this.f5441b);
                bundle.putInt("playcore.integrity.version.major", 1);
                bundle.putInt("playcore.integrity.version.minor", 3);
                bundle.putInt("playcore.integrity.version.patch", 0);
                bundle.putLong("request.token.sid", this.f5442c);
                return b(activity, bundle);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract Task b(Activity activity, Bundle bundle);
}
