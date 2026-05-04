package m7;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class w0 {
    public static Task a(l0 l0Var) {
        com.google.android.gms.common.internal.s.k(l0Var);
        n7.p pVar = (n7.p) l0Var;
        return FirebaseAuth.getInstance(pVar.R().m0()).b0(pVar);
    }

    public static v0 b(y0 y0Var, String str) {
        return new v0((String) com.google.android.gms.common.internal.s.k(str), (y0) com.google.android.gms.common.internal.s.k(y0Var), null);
    }

    public static v0 c(String str, String str2) {
        return new v0((String) com.google.android.gms.common.internal.s.k(str2), null, (String) com.google.android.gms.common.internal.s.k(str));
    }
}
