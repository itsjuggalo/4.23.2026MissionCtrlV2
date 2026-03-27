package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
final class zzafy extends BroadcastReceiver {
    private final String zza;
    private final /* synthetic */ zzafu zzb;

    public zzafy(zzafu zzafuVar, String str) {
        this.zzb = zzafuVar;
        this.zza = str;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if ("com.google.android.gms.auth.api.phone.SMS_RETRIEVED".equals(intent.getAction())) {
            Bundle extras = intent.getExtras();
            if (((Status) extras.get("com.google.android.gms.auth.api.phone.EXTRA_STATUS")).k() == 0) {
                String str = (String) extras.get("com.google.android.gms.auth.api.phone.EXTRA_SMS_MESSAGE");
                zzagb zzagbVar = (zzagb) this.zzb.zzd.get(this.zza);
                if (zzagbVar == null) {
                    zzafu.zza.c("Verification code received with no active retrieval session.", new Object[0]);
                } else {
                    String strZza = zzafu.zza(str);
                    zzagbVar.zze = strZza;
                    if (strZza == null) {
                        zzafu.zza.c("Unable to extract verification code.", new Object[0]);
                    } else if (!zzae.zzc(zzagbVar.zzd)) {
                        zzafu.zzb(this.zzb, this.zza);
                    }
                }
            }
            context.getApplicationContext().unregisterReceiver(this);
        }
    }
}
