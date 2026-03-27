package a3;

import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

/* JADX INFO: renamed from: a3.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0883w implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0877t f6287b;

    public RunnableC0883w(C0877t c0877t, String str) {
        this.f6287b = c0877t;
        this.f6286a = AbstractC1207s.e(str);
    }

    @Override // java.lang.Runnable
    public final void run() {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(Q2.g.p(this.f6286a));
        if (firebaseAuth.m() != null) {
            Task taskD = firebaseAuth.d(true);
            C0877t.f6276h.g("Token refreshing started", new Object[0]);
            taskD.addOnFailureListener(new C0881v(this));
        }
    }
}
