package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FirebaseAuth f6103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ka.b f6104b;

    public l(FirebaseAuth firebaseAuth, ka.b bVar) {
        this.f6103a = firebaseAuth;
        this.f6104b = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator it = this.f6103a.f6026d.iterator();
        while (it.hasNext()) {
            ((n7.a) it.next()).a(this.f6104b);
        }
        Iterator it2 = this.f6103a.f6024b.iterator();
        while (it2.hasNext()) {
            ((FirebaseAuth.b) it2.next()).a(this.f6103a);
        }
    }
}
