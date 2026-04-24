package I0;

import android.util.Log;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public final class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f4018a = new a();

    @Override // I0.g
    public void a(String tag, String message) {
        AbstractC2304t.f(tag, "tag");
        AbstractC2304t.f(message, "message");
        Log.d(tag, message);
    }
}
