package M5;

import M5.h;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2595q;

/* JADX INFO: loaded from: classes2.dex */
public final class l implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f5416a = new l();

    @Override // M5.h
    public List a() {
        return AbstractC2595q.i();
    }

    @Override // M5.h
    public /* bridge */ /* synthetic */ Member b() {
        return (Member) d();
    }

    @Override // M5.h
    public boolean c() {
        return h.a.b(this);
    }

    @Override // M5.h
    public Object call(Object[] args) {
        AbstractC2304t.f(args, "args");
        throw new UnsupportedOperationException("call/callBy are not supported for this declaration.");
    }

    public Void d() {
        return null;
    }

    @Override // M5.h
    public Type getReturnType() {
        Class TYPE = Void.TYPE;
        AbstractC2304t.e(TYPE, "TYPE");
        return TYPE;
    }
}
