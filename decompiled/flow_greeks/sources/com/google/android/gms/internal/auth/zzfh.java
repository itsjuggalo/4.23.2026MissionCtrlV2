package com.google.android.gms.internal.auth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzfh extends zzfl {
    private static final Class zza = Collections.unmodifiableList(Collections.EMPTY_LIST).getClass();

    public /* synthetic */ zzfh(zzfg zzfgVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.auth.zzfl
    public final void zza(Object obj, long j10) {
        Object objUnmodifiableList;
        List list = (List) zzhj.zzf(obj, j10);
        if (list instanceof zzff) {
            objUnmodifiableList = ((zzff) list).zze();
        } else {
            if (zza.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzge) && (list instanceof zzez)) {
                zzez zzezVar = (zzez) list;
                if (zzezVar.zzc()) {
                    zzezVar.zzb();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        zzhj.zzp(obj, j10, objUnmodifiableList);
    }

    @Override // com.google.android.gms.internal.auth.zzfl
    public final void zzb(Object obj, Object obj2, long j10) {
        List list;
        List list2;
        List list3 = (List) zzhj.zzf(obj2, j10);
        int size = list3.size();
        List list4 = (List) zzhj.zzf(obj, j10);
        if (list4.isEmpty()) {
            List zzfeVar = list4 instanceof zzff ? new zzfe(size) : ((list4 instanceof zzge) && (list4 instanceof zzez)) ? ((zzez) list4).zzd(size) : new ArrayList(size);
            zzhj.zzp(obj, j10, zzfeVar);
            list2 = zzfeVar;
        } else {
            if (zza.isAssignableFrom(list4.getClass())) {
                ArrayList arrayList = new ArrayList(list4.size() + size);
                arrayList.addAll(list4);
                zzhj.zzp(obj, j10, arrayList);
                list = arrayList;
            } else if (list4 instanceof zzhe) {
                zzfe zzfeVar2 = new zzfe(list4.size() + size);
                zzfeVar2.addAll(zzfeVar2.size(), (zzhe) list4);
                zzhj.zzp(obj, j10, zzfeVar2);
                list = zzfeVar2;
            } else {
                boolean z10 = list4 instanceof zzge;
                list2 = list4;
                if (z10) {
                    boolean z11 = list4 instanceof zzez;
                    list2 = list4;
                    if (z11) {
                        zzez zzezVar = (zzez) list4;
                        list2 = list4;
                        if (!zzezVar.zzc()) {
                            zzez zzezVarZzd = zzezVar.zzd(list4.size() + size);
                            zzhj.zzp(obj, j10, zzezVarZzd);
                            list2 = zzezVarZzd;
                        }
                    }
                }
            }
            list2 = list;
        }
        int size2 = list2.size();
        int size3 = list3.size();
        if (size2 > 0 && size3 > 0) {
            list2.addAll(list3);
        }
        if (size2 > 0) {
            list3 = list2;
        }
        zzhj.zzp(obj, j10, list3);
    }

    private zzfh() {
        super(null);
    }
}
