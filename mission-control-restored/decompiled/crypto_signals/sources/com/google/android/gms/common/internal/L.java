package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzc;

/* JADX INFO: loaded from: classes.dex */
public final class L extends zzb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AbstractC0428f f5202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5203b;

    public L(AbstractC0428f abstractC0428f, int i) {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
        this.f5202a = abstractC0428f;
        this.f5203b = i;
    }

    @Override // com.google.android.gms.internal.common.zzb
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i6) {
        int i7 = this.f5203b;
        if (i == 1) {
            int i8 = parcel.readInt();
            IBinder strongBinder = parcel.readStrongBinder();
            Bundle bundle = (Bundle) zzc.zza(parcel, Bundle.CREATOR);
            zzc.zzb(parcel);
            I.h(this.f5202a, "onPostInitComplete can be called only once per call to getRemoteService");
            this.f5202a.onPostInitHandler(i8, strongBinder, bundle, i7);
            this.f5202a = null;
        } else if (i == 2) {
            parcel.readInt();
            zzc.zzb(parcel);
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        } else {
            if (i != 3) {
                return false;
            }
            int i9 = parcel.readInt();
            IBinder strongBinder2 = parcel.readStrongBinder();
            P p3 = (P) zzc.zza(parcel, P.CREATOR);
            zzc.zzb(parcel);
            AbstractC0428f abstractC0428f = this.f5202a;
            I.h(abstractC0428f, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
            I.g(p3);
            AbstractC0428f.zzj(abstractC0428f, p3);
            Bundle bundle2 = p3.f5209a;
            I.h(this.f5202a, "onPostInitComplete can be called only once per call to getRemoteService");
            this.f5202a.onPostInitHandler(i9, strongBinder2, bundle2, i7);
            this.f5202a = null;
        }
        parcel2.writeNoException();
        return true;
    }
}
