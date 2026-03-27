package c0;

import com.google.android.gms.common.api.a;

/* JADX INFO: renamed from: c0.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1123l extends v {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Throwable f9287b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1123l(Throwable finalException) {
        super(a.e.API_PRIORITY_OTHER, null);
        kotlin.jvm.internal.r.f(finalException, "finalException");
        this.f9287b = finalException;
    }

    public final Throwable b() {
        return this.f9287b;
    }
}
