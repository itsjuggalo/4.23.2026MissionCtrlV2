package a3;

import android.text.TextUtils;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.internal.p002firebaseauthapi.zzahq;
import com.google.android.gms.internal.p002firebaseauthapi.zzair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: a3.O, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0828O {
    public static Z2.J a(zzahq zzahqVar) {
        if (zzahqVar == null) {
            return null;
        }
        if (!TextUtils.isEmpty(zzahqVar.zze())) {
            return new Z2.S(zzahqVar.zzd(), zzahqVar.zzc(), zzahqVar.zza(), AbstractC1207s.e(zzahqVar.zze()));
        }
        if (zzahqVar.zzb() != null) {
            return new Z2.Y(zzahqVar.zzd(), zzahqVar.zzc(), zzahqVar.zza(), (zzair) AbstractC1207s.l(zzahqVar.zzb(), "totpInfo cannot be null."));
        }
        return null;
    }

    public static List b(List list) {
        if (list == null || list.isEmpty()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Z2.J jA = a((zzahq) it.next());
            if (jA != null) {
                arrayList.add(jA);
            }
        }
        return arrayList;
    }
}
