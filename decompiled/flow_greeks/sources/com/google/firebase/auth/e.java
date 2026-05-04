package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FirebaseAuth.b f6077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FirebaseAuth f6078b;

    public e(FirebaseAuth firebaseAuth, FirebaseAuth.b bVar) {
        this.f6077a = bVar;
        Objects.requireNonNull(firebaseAuth);
        this.f6078b = firebaseAuth;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6077a.a(this.f6078b);
    }
}
