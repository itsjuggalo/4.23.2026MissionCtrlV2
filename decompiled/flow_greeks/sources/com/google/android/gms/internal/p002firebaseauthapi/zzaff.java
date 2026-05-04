package com.google.android.gms.internal.p002firebaseauthapi;

import a7.g;
import android.app.Activity;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.j;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.common.internal.s;
import com.google.firebase.auth.b;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import m7.a0;
import m7.h;
import n7.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzaff<ResultT, CallbackT> implements zzafq<ResultT> {
    protected final int zza;
    protected g zzc;
    protected a0 zzd;
    protected CallbackT zze;
    protected x zzf;
    protected zzafg<ResultT> zzg;
    protected Executor zzi;
    protected zzahv zzj;
    protected zzahk zzk;
    protected zzagv zzl;
    protected zzaif zzm;
    protected h zzn;
    protected String zzo;
    protected String zzp;
    protected zzaas zzq;
    protected zzahs zzr;
    protected zzahr zzs;
    protected zzair zzt;
    boolean zzu;
    protected final zzafh zzb = new zzafh(this);
    protected final List<b.AbstractC0100b> zzh = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class zza extends j {
        private final List<b.AbstractC0100b> zza;

        private zza(k kVar, List<b.AbstractC0100b> list) {
            super(kVar);
            this.mLifecycleFragment.a("PhoneAuthActivityStopCallback", this);
            this.zza = list;
        }

        public static void zza(Activity activity, List<b.AbstractC0100b> list) {
            k fragment = j.getFragment(activity);
            if (((zza) fragment.b("PhoneAuthActivityStopCallback", zza.class)) == null) {
                new zza(fragment, list);
            }
        }

        @Override // com.google.android.gms.common.api.internal.j
        public void onStop() {
            synchronized (this.zza) {
                this.zza.clear();
            }
        }
    }

    public zzaff(int i10) {
        this.zza = i10;
    }

    public final zzaff<ResultT, CallbackT> zza(CallbackT callbackt) {
        this.zze = (CallbackT) s.l(callbackt, "external callback cannot be null");
        return this;
    }

    public abstract void zzb();

    public final void zzb(ResultT resultt) {
        this.zzu = true;
        this.zzg.zza(resultt, null);
    }

    public final zzaff<ResultT, CallbackT> zza(x xVar) {
        this.zzf = (x) s.l(xVar, "external failure callback cannot be null");
        return this;
    }

    public final zzaff<ResultT, CallbackT> zza(g gVar) {
        this.zzc = (g) s.l(gVar, "firebaseApp cannot be null");
        return this;
    }

    public final zzaff<ResultT, CallbackT> zza(a0 a0Var) {
        this.zzd = (a0) s.l(a0Var, "firebaseUser cannot be null");
        return this;
    }

    public final zzaff<ResultT, CallbackT> zza(b.AbstractC0100b abstractC0100b, Activity activity, Executor executor, String str) {
        b.AbstractC0100b abstractC0100bZza = zzagb.zza(str, abstractC0100b, this);
        synchronized (this.zzh) {
            this.zzh.add((b.AbstractC0100b) s.k(abstractC0100bZza));
        }
        if (activity != null) {
            zza.zza(activity, this.zzh);
        }
        this.zzi = (Executor) s.k(executor);
        return this;
    }

    public static /* synthetic */ void zza(zzaff zzaffVar) {
        zzaffVar.zzb();
        s.o(zzaffVar.zzu, "no success or failure set on method implementation");
    }

    public static /* synthetic */ void zza(zzaff zzaffVar, Status status) {
        x xVar = zzaffVar.zzf;
        if (xVar != null) {
            xVar.zza(status);
        }
    }

    public final void zza(Status status) {
        this.zzu = true;
        this.zzg.zza(null, status);
    }
}
