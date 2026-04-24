package com.google.android.recaptcha.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import t3.AbstractC1851z;
import t3.InterfaceC1846w0;
import t3.InterfaceC1847x;
import t3.T;

/* JADX INFO: loaded from: classes.dex */
public final class zzbx {
    public static final T zza(Task task) {
        final InterfaceC1847x interfaceC1847xB = AbstractC1851z.b(null, 1, null);
        task.addOnCompleteListener(zzbv.zza, new OnCompleteListener() { // from class: com.google.android.recaptcha.internal.zzbu
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task2) {
                InterfaceC1847x interfaceC1847x = interfaceC1847xB;
                Exception exception = task2.getException();
                if (exception != null) {
                    interfaceC1847x.G(exception);
                } else if (task2.isCanceled()) {
                    InterfaceC1846w0.a.b(interfaceC1847x, null, 1, null);
                } else {
                    interfaceC1847x.K(task2.getResult());
                }
            }
        });
        return new zzbw(interfaceC1847xB);
    }
}
