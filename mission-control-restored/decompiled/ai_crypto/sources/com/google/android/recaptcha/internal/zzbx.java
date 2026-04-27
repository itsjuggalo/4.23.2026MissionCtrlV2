package com.google.android.recaptcha.internal;

import b6.AbstractC1106z;
import b6.InterfaceC1101w0;
import b6.InterfaceC1102x;
import b6.T;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes.dex */
public final class zzbx {
    public static final T zza(Task task) {
        final InterfaceC1102x interfaceC1102xB = AbstractC1106z.b(null, 1, null);
        task.addOnCompleteListener(zzbv.zza, new OnCompleteListener() { // from class: com.google.android.recaptcha.internal.zzbu
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task2) {
                InterfaceC1102x interfaceC1102x = interfaceC1102xB;
                Exception exception = task2.getException();
                if (exception != null) {
                    interfaceC1102x.V(exception);
                } else if (task2.isCanceled()) {
                    InterfaceC1101w0.a.b(interfaceC1102x, null, 1, null);
                } else {
                    interfaceC1102x.X(task2.getResult());
                }
            }
        });
        return new zzbw(interfaceC1102xB);
    }
}
