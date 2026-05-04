package com.google.android.recaptcha.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import ng.u0;
import ng.x;
import ng.y1;
import ng.z;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbx {
    public static final u0 zza(Task task) {
        final x xVarB = z.b(null, 1, null);
        task.addOnCompleteListener(zzbv.zza, new OnCompleteListener() { // from class: com.google.android.recaptcha.internal.zzbu
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task2) {
                x xVar = xVarB;
                Exception exception = task2.getException();
                if (exception != null) {
                    xVar.E(exception);
                } else if (task2.isCanceled()) {
                    y1.a.b(xVar, null, 1, null);
                } else {
                    xVar.H(task2.getResult());
                }
            }
        });
        return new zzbw(xVarB);
    }
}
