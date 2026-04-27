package m2;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import o2.InterfaceC2457a;

/* JADX INFO: renamed from: m2.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2358k implements InterfaceC2457a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f21365a;

    public C2358k(C2359l c2359l, Activity activity) {
        this.f21365a = activity;
    }

    @Override // o2.InterfaceC2457a
    public final void a(IntentSender intentSender, int i8, Intent intent, int i9, int i10, int i11, Bundle bundle) throws IntentSender.SendIntentException {
        this.f21365a.startIntentSenderForResult(intentSender, i8, intent, i9, i10, i11, bundle);
    }
}
