package t2;

import android.util.Log;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f20632a = new a();

    @Override // t2.g
    public void a(String tag, String message) {
        t.f(tag, "tag");
        t.f(message, "message");
        Log.d(tag, message);
    }
}
