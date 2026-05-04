package n7;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class m extends m7.h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f16814a;

    public m(i iVar) {
        com.google.android.gms.common.internal.s.k(iVar);
        this.f16814a = iVar;
    }

    @Override // m7.h0
    public final Task a(m7.i0 i0Var, String str) {
        com.google.android.gms.common.internal.s.k(i0Var);
        i iVar = this.f16814a;
        return FirebaseAuth.getInstance(iVar.m0()).V(iVar, i0Var, str);
    }

    @Override // m7.h0
    public final List b() {
        return this.f16814a.z0();
    }

    @Override // m7.h0
    public final Task c() {
        return this.f16814a.S(false).continueWithTask(new l(this));
    }

    @Override // m7.h0
    public final Task d(String str) {
        com.google.android.gms.common.internal.s.e(str);
        i iVar = this.f16814a;
        return FirebaseAuth.getInstance(iVar.m0()).T(iVar, str);
    }
}
