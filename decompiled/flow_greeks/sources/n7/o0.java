package n7;

import android.text.TextUtils;
import com.google.android.gms.internal.p002firebaseauthapi.zzahy;
import com.google.android.gms.internal.p002firebaseauthapi.zzaiz;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class o0 {
    public static List a(List list) {
        if (list == null || list.isEmpty()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            m7.j0 j0VarB = b((zzahy) it.next());
            if (j0VarB != null) {
                arrayList.add(j0VarB);
            }
        }
        return arrayList;
    }

    public static m7.j0 b(zzahy zzahyVar) {
        if (zzahyVar == null) {
            return null;
        }
        if (!TextUtils.isEmpty(zzahyVar.zze())) {
            return new m7.r0(zzahyVar.zzd(), zzahyVar.zzc(), zzahyVar.zza(), com.google.android.gms.common.internal.s.e(zzahyVar.zze()));
        }
        if (zzahyVar.zzb() != null) {
            return new m7.x0(zzahyVar.zzd(), zzahyVar.zzc(), zzahyVar.zza(), (zzaiz) com.google.android.gms.common.internal.s.l(zzahyVar.zzb(), "totpInfo cannot be null."));
        }
        return null;
    }
}
