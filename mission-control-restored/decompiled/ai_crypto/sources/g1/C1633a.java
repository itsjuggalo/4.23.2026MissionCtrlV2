package g1;

import android.util.SparseArray;
import h1.InterfaceC1668a;
import kotlin.jvm.internal.r;

/* JADX INFO: renamed from: g1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1633a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1633a f14257a = new C1633a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SparseArray f14258b = new SparseArray();

    public final InterfaceC1668a a(int i7) {
        return (InterfaceC1668a) f14258b.get(i7);
    }

    public final void b(InterfaceC1668a handler) {
        r.f(handler, "handler");
        f14258b.append(handler.getType(), handler);
    }
}
