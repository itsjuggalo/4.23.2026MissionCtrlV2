package x0;

import android.util.Log;
import kotlin.jvm.internal.r;

/* JADX INFO: renamed from: x0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1912a implements InterfaceC1918g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1912a f15691a = new C1912a();

    @Override // x0.InterfaceC1918g
    public void a(String tag, String message) {
        r.f(tag, "tag");
        r.f(message, "message");
        Log.d(tag, message);
    }
}
