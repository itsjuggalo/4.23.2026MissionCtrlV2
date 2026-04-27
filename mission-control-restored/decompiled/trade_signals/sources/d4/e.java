package d4;

import android.util.Log;
import b4.q;
import f4.AbstractC1756e;
import f4.InterfaceC1757f;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import l2.AbstractC2328l;
import l2.InterfaceC2324h;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c4.e f16887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public C1635a f16888b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Executor f16889c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Set f16890d = Collections.newSetFromMap(new ConcurrentHashMap());

    public e(c4.e eVar, C1635a c1635a, Executor executor) {
        this.f16887a = eVar;
        this.f16888b = c1635a;
        this.f16889c = executor;
    }

    public final /* synthetic */ void f(AbstractC2328l abstractC2328l, final InterfaceC1757f interfaceC1757f, com.google.firebase.remoteconfig.internal.b bVar) {
        try {
            com.google.firebase.remoteconfig.internal.b bVar2 = (com.google.firebase.remoteconfig.internal.b) abstractC2328l.k();
            if (bVar2 != null) {
                final AbstractC1756e abstractC1756eB = this.f16888b.b(bVar2);
                this.f16889c.execute(new Runnable() { // from class: d4.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        interfaceC1757f.a(abstractC1756eB);
                    }
                });
            }
        } catch (q e8) {
            Log.w("FirebaseRemoteConfig", "Exception publishing RolloutsState to subscriber. Continuing to listen for changes.", e8);
        }
    }

    public void g(com.google.firebase.remoteconfig.internal.b bVar) {
        try {
            final AbstractC1756e abstractC1756eB = this.f16888b.b(bVar);
            for (final InterfaceC1757f interfaceC1757f : this.f16890d) {
                this.f16889c.execute(new Runnable() { // from class: d4.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        interfaceC1757f.a(abstractC1756eB);
                    }
                });
            }
        } catch (q e8) {
            Log.w("FirebaseRemoteConfig", "Exception publishing RolloutsState to subscribers. Continuing to listen for changes.", e8);
        }
    }

    public void h(final InterfaceC1757f interfaceC1757f) {
        this.f16890d.add(interfaceC1757f);
        final AbstractC2328l abstractC2328lE = this.f16887a.e();
        abstractC2328lE.f(this.f16889c, new InterfaceC2324h() { // from class: d4.c
            @Override // l2.InterfaceC2324h
            public final void onSuccess(Object obj) {
                this.f16882a.f(abstractC2328lE, interfaceC1757f, (com.google.firebase.remoteconfig.internal.b) obj);
            }
        });
    }
}
