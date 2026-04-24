package com.google.android.gms.tasks;

import android.app.Activity;
import com.google.android.gms.common.api.internal.AbstractC0408k;
import com.google.android.gms.common.api.internal.InterfaceC0409l;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzv extends AbstractC0408k {
    private final List zza;

    private zzv(InterfaceC0409l interfaceC0409l) {
        super(interfaceC0409l);
        this.zza = new ArrayList();
        this.mLifecycleFragment.c("TaskOnStopCallback", this);
    }

    public static zzv zza(Activity activity) {
        zzv zzvVar;
        InterfaceC0409l fragment = AbstractC0408k.getFragment(activity);
        synchronized (fragment) {
            try {
                zzvVar = (zzv) fragment.e(zzv.class, "TaskOnStopCallback");
                if (zzvVar == null) {
                    zzvVar = new zzv(fragment);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzvVar;
    }

    @Override // com.google.android.gms.common.api.internal.AbstractC0408k
    public final void onStop() {
        synchronized (this.zza) {
            try {
                Iterator it = this.zza.iterator();
                while (it.hasNext()) {
                    zzq zzqVar = (zzq) ((WeakReference) it.next()).get();
                    if (zzqVar != null) {
                        zzqVar.zzc();
                    }
                }
                this.zza.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzb(zzq zzqVar) {
        synchronized (this.zza) {
            this.zza.add(new WeakReference(zzqVar));
        }
    }
}
