package com.google.android.gms.internal.p002firebaseauthapi;

import Z2.n0;
import Z2.y0;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.AbstractC1207s;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzahc {
    private String zza;
    private String zzb;
    private boolean zzc;
    private String zzd;
    private String zze;
    private zzahs zzf;
    private String zzg;
    private long zzh;
    private long zzi;
    private boolean zzj;
    private y0 zzk;
    private List<zzahq> zzl;
    private zzaj<n0> zzm;

    public zzahc() {
        this.zzf = new zzahs();
        this.zzm = zzaj.zzh();
    }

    public final long zza() {
        return this.zzh;
    }

    public final long zzb() {
        return this.zzi;
    }

    public final Uri zzc() {
        if (TextUtils.isEmpty(this.zze)) {
            return null;
        }
        return Uri.parse(this.zze);
    }

    public final zzaj<n0> zzd() {
        return this.zzm;
    }

    public final y0 zze() {
        return this.zzk;
    }

    public final zzahs zzf() {
        return this.zzf;
    }

    public final String zzg() {
        return this.zzd;
    }

    public final String zzh() {
        return this.zzb;
    }

    public final String zzi() {
        return this.zza;
    }

    public final String zzj() {
        return this.zzg;
    }

    public final List<zzahq> zzk() {
        return this.zzl;
    }

    public final List<zzaht> zzl() {
        return this.zzf.zza();
    }

    public final boolean zzm() {
        return this.zzc;
    }

    public final boolean zzn() {
        return this.zzj;
    }

    public final zzahc zza(y0 y0Var) {
        this.zzk = y0Var;
        return this;
    }

    public final zzahc zzb(String str) {
        this.zzb = str;
        return this;
    }

    public final zzahc zza(String str) {
        this.zzd = str;
        return this;
    }

    public final zzahc zzc(String str) {
        this.zze = str;
        return this;
    }

    public zzahc(String str, String str2, boolean z7, String str3, String str4, zzahs zzahsVar, String str5, String str6, long j7, long j8, boolean z8, y0 y0Var, List<zzahq> list, zzaj<n0> zzajVar) {
        zzahs zzahsVar2;
        this.zza = str;
        this.zzb = str2;
        this.zzc = z7;
        this.zzd = str3;
        this.zze = str4;
        if (zzahsVar == null) {
            zzahsVar2 = new zzahs();
        } else {
            List<zzaht> listZza = zzahsVar.zza();
            zzahs zzahsVar3 = new zzahs();
            if (listZza != null) {
                zzahsVar3.zza().addAll(listZza);
            }
            zzahsVar2 = zzahsVar3;
        }
        this.zzf = zzahsVar2;
        this.zzg = str6;
        this.zzh = j7;
        this.zzi = j8;
        this.zzj = false;
        this.zzk = null;
        this.zzl = list == null ? new ArrayList<>() : list;
        this.zzm = zzajVar;
    }

    public final zzahc zza(boolean z7) {
        this.zzj = z7;
        return this;
    }

    public final zzahc zza(zzaj<n0> zzajVar) {
        AbstractC1207s.k(zzajVar);
        this.zzm = zzajVar;
        return this;
    }

    public final zzahc zza(List<zzaht> list) {
        AbstractC1207s.k(list);
        zzahs zzahsVar = new zzahs();
        this.zzf = zzahsVar;
        zzahsVar.zza().addAll(list);
        return this;
    }
}
