package u1;

import android.content.Intent;

/* JADX INFO: renamed from: u1.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1206h extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Intent f10287a;

    public C1206h(Intent intent, int i) {
        super("Google Play Services not available");
        this.f10287a = intent;
    }
}
