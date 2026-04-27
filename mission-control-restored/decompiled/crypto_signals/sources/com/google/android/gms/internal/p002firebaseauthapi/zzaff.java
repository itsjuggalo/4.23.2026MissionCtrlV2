package com.google.android.gms.internal.p002firebaseauthapi;

import Z1.h;
import android.app.Activity;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.AbstractC0408k;
import com.google.android.gms.common.api.internal.InterfaceC0409l;
import com.google.android.gms.common.internal.I;
import i2.AbstractC0658d;
import i2.AbstractC0669o;
import i2.x;
import j2.InterfaceC0738n;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzaff<ResultT, CallbackT> implements zzafq<ResultT> {
    protected final int zza;
    protected h zzc;
    protected AbstractC0669o zzd;
    protected CallbackT zze;
    protected InterfaceC0738n zzf;
    protected zzafg<ResultT> zzg;
    protected Executor zzi;
    protected zzahv zzj;
    protected zzahk zzk;
    protected zzagv zzl;
    protected zzaif zzm;
    protected AbstractC0658d zzn;
    protected String zzo;
    protected String zzp;
    protected zzaas zzq;
    protected zzahs zzr;
    protected zzahr zzs;
    protected zzair zzt;
    boolean zzu;
    protected final zzafh zzb = new zzafh(this);
    protected final List<x> zzh = new ArrayList();

    public static class zza extends AbstractC0408k {
        private final List<x> zza;

        private zza(InterfaceC0409l interfaceC0409l, List<x> list) {
            super(interfaceC0409l);
            this.mLifecycleFragment.c("PhoneAuthActivityStopCallback", this);
            this.zza = list;
        }

        public static void zza(Activity activity, List<x> list) {
            InterfaceC0409l fragment = AbstractC0408k.getFragment(activity);
            if (((zza) fragment.e(zza.class, "PhoneAuthActivityStopCallback")) == null) {
                new zza(fragment, list);
            }
        }

        @Override // com.google.android.gms.common.api.internal.AbstractC0408k
        public void onStop() {
            synchronized (this.zza) {
                this.zza.clear();
            }
        }
    }

    public zzaff(int i) {
        this.zza = i;
    }

    public final zzaff<ResultT, CallbackT> zza(CallbackT callbackt) {
        I.h(callbackt, "external callback cannot be null");
        this.zze = callbackt;
        return this;
    }

    public abstract void zzb();

    public final void zzb(ResultT resultt) {
        this.zzu = true;
        this.zzg.zza(resultt, null);
    }

    public final zzaff<ResultT, CallbackT> zza(InterfaceC0738n interfaceC0738n) {
        I.h(interfaceC0738n, "external failure callback cannot be null");
        this.zzf = interfaceC0738n;
        return this;
    }

    public final zzaff<ResultT, CallbackT> zza(h hVar) {
        I.h(hVar, "firebaseApp cannot be null");
        this.zzc = hVar;
        return this;
    }

    public final zzaff<ResultT, CallbackT> zza(AbstractC0669o abstractC0669o) {
        I.h(abstractC0669o, "firebaseUser cannot be null");
        this.zzd = abstractC0669o;
        return this;
    }

    public final zzaff<ResultT, CallbackT> zza(x xVar, Activity activity, Executor executor, String str) {
        x xVarZza = zzagb.zza(str, xVar, this);
        synchronized (this.zzh) {
            List<x> list = this.zzh;
            I.g(xVarZza);
            list.add(xVarZza);
        }
        if (activity != null) {
            zza.zza(activity, this.zzh);
        }
        I.g(executor);
        this.zzi = executor;
        return this;
    }

    public static /* synthetic */ void zza(zzaff zzaffVar) {
        zzaffVar.zzb();
        I.i("no success or failure set on method implementation", zzaffVar.zzu);
    }

    public static /* synthetic */ void zza(zzaff zzaffVar, Status status) {
        InterfaceC0738n interfaceC0738n = zzaffVar.zzf;
        if (interfaceC0738n != null) {
            interfaceC0738n.zza(status);
        }
    }

    public final void zza(Status status) {
        this.zzu = true;
        this.zzg.zza(null, status);
    }
}
