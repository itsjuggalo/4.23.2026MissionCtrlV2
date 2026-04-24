package com.google.android.gms.internal.auth;

import android.accounts.Account;
import android.os.Bundle;
import com.google.android.gms.common.api.internal.C0398a;
import com.google.android.gms.tasks.Task;
import k1.C0749b;

/* JADX INFO: loaded from: classes.dex */
public interface zzg {
    /* synthetic */ C0398a getApiKey();

    Task zza(zzbw zzbwVar);

    Task zzb(C0749b c0749b);

    Task zzc(Account account, String str, Bundle bundle);

    Task zzd(Account account);

    Task zze(String str);
}
