package a3;

import Z2.AbstractC0759h;
import Z2.C0746a0;
import Z2.C0767l;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.internal.p002firebaseauthapi.zzait;

/* JADX INFO: renamed from: a3.u0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0880u0 {
    public static zzait a(AbstractC0759h abstractC0759h, String str) {
        AbstractC1207s.k(abstractC0759h);
        if (Z2.F.class.isAssignableFrom(abstractC0759h.getClass())) {
            return Z2.F.D((Z2.F) abstractC0759h, str);
        }
        if (C0767l.class.isAssignableFrom(abstractC0759h.getClass())) {
            return C0767l.D((C0767l) abstractC0759h, str);
        }
        if (C0746a0.class.isAssignableFrom(abstractC0759h.getClass())) {
            return C0746a0.D((C0746a0) abstractC0759h, str);
        }
        if (Z2.D.class.isAssignableFrom(abstractC0759h.getClass())) {
            return Z2.D.D((Z2.D) abstractC0759h, str);
        }
        if (Z2.T.class.isAssignableFrom(abstractC0759h.getClass())) {
            return Z2.T.D((Z2.T) abstractC0759h, str);
        }
        if (Z2.y0.class.isAssignableFrom(abstractC0759h.getClass())) {
            return Z2.y0.J((Z2.y0) abstractC0759h, str);
        }
        throw new IllegalArgumentException("Unsupported credential type.");
    }
}
