package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FirebaseAuth.a f6101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FirebaseAuth f6102b;

    public k(FirebaseAuth firebaseAuth, FirebaseAuth.a aVar) {
        this.f6101a = aVar;
        Objects.requireNonNull(firebaseAuth);
        this.f6102b = firebaseAuth;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6101a.a(this.f6102b);
    }
}
