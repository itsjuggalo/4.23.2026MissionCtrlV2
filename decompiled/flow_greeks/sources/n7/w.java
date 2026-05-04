package n7;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class w implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t f16869b;

    public w(t tVar, String str) {
        Objects.requireNonNull(tVar);
        this.f16869b = tVar;
        this.f16868a = com.google.android.gms.common.internal.s.e(str);
    }

    @Override // java.lang.Runnable
    public final void run() {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(a7.g.p(this.f16868a));
        if (firebaseAuth.m() != null) {
            Task taskC = firebaseAuth.c(true);
            t.f16849h.g("Token refreshing started", new Object[0]);
            taskC.addOnFailureListener(new v(this));
        }
    }
}
