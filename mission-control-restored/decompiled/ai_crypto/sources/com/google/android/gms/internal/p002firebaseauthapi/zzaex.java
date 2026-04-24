package com.google.android.gms.internal.p002firebaseauthapi;

import Q2.g;
import Z2.A;
import Z2.AbstractC0759h;
import a3.InterfaceC0885x;
import android.app.Activity;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.AbstractC1173j;
import com.google.android.gms.common.api.internal.InterfaceC1174k;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.firebase.auth.b;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzaex<ResultT, CallbackT> implements zzafi<ResultT> {
    protected final int zza;
    protected g zzc;
    protected A zzd;
    protected CallbackT zze;
    protected InterfaceC0885x zzf;
    protected zzaey<ResultT> zzg;
    protected Executor zzi;
    protected zzahn zzj;
    protected zzahc zzk;
    protected zzagn zzl;
    protected zzahx zzm;
    protected AbstractC0759h zzn;
    protected String zzo;
    protected String zzp;
    protected zzaaj zzq;
    protected zzahk zzr;
    protected zzahj zzs;
    protected zzaij zzt;
    private boolean zzu;
    protected final zzaez zzb = new zzaez(this);
    protected final List<b.AbstractC0192b> zzh = new ArrayList();

    public static class zza extends AbstractC1173j {
        private final List<b.AbstractC0192b> zza;

        private zza(InterfaceC1174k interfaceC1174k, List<b.AbstractC0192b> list) {
            super(interfaceC1174k);
            this.mLifecycleFragment.b("PhoneAuthActivityStopCallback", this);
            this.zza = list;
        }

        public static void zza(Activity activity, List<b.AbstractC0192b> list) {
            InterfaceC1174k fragment = AbstractC1173j.getFragment(activity);
            if (((zza) fragment.d("PhoneAuthActivityStopCallback", zza.class)) == null) {
                new zza(fragment, list);
            }
        }

        @Override // com.google.android.gms.common.api.internal.AbstractC1173j
        public void onStop() {
            synchronized (this.zza) {
                this.zza.clear();
            }
        }
    }

    public zzaex(int i7) {
        this.zza = i7;
    }

    public abstract void zzb();

    public final void zzb(ResultT resultt) {
        this.zzu = true;
        this.zzg.zza(resultt, null);
    }

    public final zzaex<ResultT, CallbackT> zza(CallbackT callbackt) {
        this.zze = (CallbackT) AbstractC1207s.l(callbackt, "external callback cannot be null");
        return this;
    }

    public final zzaex<ResultT, CallbackT> zza(InterfaceC0885x interfaceC0885x) {
        this.zzf = (InterfaceC0885x) AbstractC1207s.l(interfaceC0885x, "external failure callback cannot be null");
        return this;
    }

    public final zzaex<ResultT, CallbackT> zza(g gVar) {
        this.zzc = (g) AbstractC1207s.l(gVar, "firebaseApp cannot be null");
        return this;
    }

    public final zzaex<ResultT, CallbackT> zza(A a7) {
        this.zzd = (A) AbstractC1207s.l(a7, "firebaseUser cannot be null");
        return this;
    }

    public final zzaex<ResultT, CallbackT> zza(b.AbstractC0192b abstractC0192b, Activity activity, Executor executor, String str) {
        b.AbstractC0192b abstractC0192bZza = zzaft.zza(str, abstractC0192b, this);
        synchronized (this.zzh) {
            this.zzh.add((b.AbstractC0192b) AbstractC1207s.k(abstractC0192bZza));
        }
        if (activity != null) {
            zza.zza(activity, this.zzh);
        }
        this.zzi = (Executor) AbstractC1207s.k(executor);
        return this;
    }

    public static /* synthetic */ void zza(zzaex zzaexVar) {
        zzaexVar.zzb();
        AbstractC1207s.o(zzaexVar.zzu, "no success or failure set on method implementation");
    }

    public static /* synthetic */ void zza(zzaex zzaexVar, Status status) {
        InterfaceC0885x interfaceC0885x = zzaexVar.zzf;
        if (interfaceC0885x != null) {
            interfaceC0885x.zza(status);
        }
    }

    public final void zza(Status status) {
        this.zzu = true;
        this.zzg.zza(null, status);
    }
}
