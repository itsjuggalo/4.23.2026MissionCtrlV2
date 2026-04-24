package com.google.android.recaptcha.internal;

import H4.h;
import Y4.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.j;
import y5.a;

/* JADX INFO: loaded from: classes.dex */
public final class zzfu {
    private Set zza;
    private Set zzb;
    private Long zzc;
    private int zzd;

    private static final boolean zzc(String str, Set set) {
        List listD;
        j.e(str, "<this>");
        String strValueOf = String.valueOf(new char[]{'.'}[0]);
        int iW = d.W(str, strValueOf, 0, false);
        if (iW != -1) {
            ArrayList arrayList = new ArrayList(10);
            int length = 0;
            do {
                arrayList.add(str.subSequence(length, iW).toString());
                length = strValueOf.length() + iW;
                iW = d.W(str, strValueOf, length, false);
            } while (iW != -1);
            arrayList.add(str.subSequence(length, str.length()).toString());
            listD = arrayList;
        } else {
            listD = a.D(str.toString());
        }
        Iterator it = listD.iterator();
        String strConcat = "";
        while (it.hasNext()) {
            String strConcat2 = strConcat.concat(String.valueOf((String) it.next()));
            if (set.contains(strConcat2)) {
                return true;
            }
            strConcat = strConcat2.concat(".");
        }
        return false;
    }

    public final void zza(zzrv zzrvVar) {
        this.zza = h.r0(zzrvVar.zzf().zzi());
        this.zzb = h.r0(zzrvVar.zzg().zzi());
    }

    public final boolean zzb(String str) {
        Set set = this.zza;
        if (set == null || this.zzb == null) {
            if (this.zzc == null) {
                this.zzc = Long.valueOf(System.currentTimeMillis());
            }
            this.zzd++;
            return true;
        }
        if (set.isEmpty()) {
            return true;
        }
        Set set2 = this.zzb;
        j.c(set2, "null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
        if (zzc(str, set2)) {
            return false;
        }
        return zzc(str, set);
    }
}
