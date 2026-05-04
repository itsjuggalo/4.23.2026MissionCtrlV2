package ae;

import ae.h;
import dd.r;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class l implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f793a = new l();

    @Override // ae.h
    public List a() {
        return r.k();
    }

    @Override // ae.h
    public /* bridge */ /* synthetic */ Member b() {
        return (Member) d();
    }

    @Override // ae.h
    public boolean c() {
        return h.a.b(this);
    }

    @Override // ae.h
    public Object call(Object[] args) {
        t.f(args, "args");
        throw new UnsupportedOperationException("call/callBy are not supported for this declaration.");
    }

    public Void d() {
        return null;
    }

    @Override // ae.h
    public Type getReturnType() {
        Class TYPE = Void.TYPE;
        t.e(TYPE, "TYPE");
        return TYPE;
    }
}
