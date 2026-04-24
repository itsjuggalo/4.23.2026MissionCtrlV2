package O0;

import android.util.Log;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f4006a = new a();

    @Override // O0.g
    public void a(String tag, String message) {
        r.f(tag, "tag");
        r.f(message, "message");
        Log.d(tag, message);
    }
}
