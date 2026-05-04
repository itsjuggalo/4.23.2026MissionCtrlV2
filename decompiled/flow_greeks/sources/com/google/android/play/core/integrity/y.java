package com.google.android.play.core.integrity;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import n6.v0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
abstract class y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f6011b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f6012c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f6014e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final v0 f6010a = new v0("IntegrityDialogWrapper");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f6013d = new Object();

    public y(String str, long j10) {
        this.f6011b = str;
        this.f6012c = j10;
    }

    public final Task a(Activity activity, int i10) {
        synchronized (this.f6013d) {
            try {
                if (this.f6014e) {
                    return Tasks.forResult(0);
                }
                this.f6014e = true;
                this.f6010a.a("checkAndShowDialog(%s)", Integer.valueOf(i10));
                Bundle bundle = new Bundle();
                bundle.putInt("dialog.intent.type", i10);
                bundle.putString("package.name", this.f6011b);
                bundle.putInt("playcore.integrity.version.major", 1);
                bundle.putInt("playcore.integrity.version.minor", 4);
                bundle.putInt("playcore.integrity.version.patch", 0);
                bundle.putLong("request.token.sid", this.f6012c);
                return b(activity, bundle);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract Task b(Activity activity, Bundle bundle);
}
