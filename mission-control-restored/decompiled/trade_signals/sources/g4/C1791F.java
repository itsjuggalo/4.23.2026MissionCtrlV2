package g4;

import b0.C1173d;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2470H;
import p7.AbstractC2609b;
import s5.InterfaceC2707e;
import z5.AbstractC3013a;

/* JADX INFO: renamed from: g4.F, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1791F implements b0.E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1799N f18025a;

    public C1791F(C1799N sessionGenerator) {
        AbstractC2304t.f(sessionGenerator, "sessionGenerator");
        this.f18025a = sessionGenerator;
    }

    @Override // b0.E
    public Object c(InputStream inputStream, InterfaceC2707e interfaceC2707e) throws C1173d {
        try {
            AbstractC2609b.a aVar = AbstractC2609b.f22439d;
            String strT = V6.A.t(AbstractC3013a.c(inputStream));
            aVar.a();
            return (SessionData) aVar.d(SessionData.INSTANCE.serializer(), strT);
        } catch (Exception e8) {
            throw new C1173d("Cannot parse session data", e8);
        }
    }

    @Override // b0.E
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public SessionData a() {
        return new SessionData(this.f18025a.a(null), (Time) null, (Map) null, 6, (AbstractC2296k) null);
    }

    @Override // b0.E
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Object b(SessionData sessionData, OutputStream outputStream, InterfaceC2707e interfaceC2707e) throws IOException {
        outputStream.write(V6.A.u(AbstractC2609b.f22439d.b(SessionData.INSTANCE.serializer(), sessionData)));
        return C2470H.f21956a;
    }
}
