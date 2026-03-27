package com.google.android.gms.internal.auth;

import android.accounts.Account;
import android.os.Bundle;
import com.google.android.gms.common.api.internal.C0898c;
import com.google.android.gms.tasks.Task;
import n1.C1616b;

/* JADX INFO: loaded from: classes.dex */
public interface zzg {
    /* synthetic */ C0898c getApiKey();

    Task zza(zzbw zzbwVar);

    Task zzb(C1616b c1616b);

    Task zzc(Account account, String str, Bundle bundle);

    Task zzd(Account account);

    Task zze(String str);
}
