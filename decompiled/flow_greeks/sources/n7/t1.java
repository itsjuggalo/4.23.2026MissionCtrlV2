package n7;

import com.google.android.gms.internal.p002firebaseauthapi.zzajb;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class t1 {
    public static zzajb a(m7.h hVar, String str) {
        com.google.android.gms.common.internal.s.k(hVar);
        if (hVar instanceof m7.f0) {
            return m7.f0.U((m7.f0) hVar, str);
        }
        if (hVar instanceof m7.l) {
            return m7.l.U((m7.l) hVar, str);
        }
        if (hVar instanceof m7.z0) {
            return m7.z0.U((m7.z0) hVar, str);
        }
        if (hVar instanceof m7.d0) {
            return m7.d0.U((m7.d0) hVar, str);
        }
        if (hVar instanceof m7.s0) {
            return m7.s0.U((m7.s0) hVar, str);
        }
        if (hVar instanceof m7.z1) {
            return m7.z1.X((m7.z1) hVar, str);
        }
        throw new IllegalArgumentException("Unsupported credential type.");
    }
}
