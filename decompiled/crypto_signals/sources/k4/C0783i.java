package k4;

import android.content.Intent;

/* JADX INFO: renamed from: k4.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0783i implements InterfaceC0784j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Intent f7905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f7906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ io.flutter.plugins.firebase.messaging.a f7907c;

    public C0783i(io.flutter.plugins.firebase.messaging.a aVar, Intent intent, int i) {
        this.f7907c = aVar;
        this.f7905a = intent;
        this.f7906b = i;
    }

    @Override // k4.InterfaceC0784j
    public final void a() {
        this.f7907c.stopSelf(this.f7906b);
    }

    @Override // k4.InterfaceC0784j
    public final Intent getIntent() {
        return this.f7905a;
    }
}
