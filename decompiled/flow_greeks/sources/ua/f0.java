package ua;

import eh.b;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class f0 implements l1.e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n0 f22578a;

    public f0(n0 sessionGenerator) {
        kotlin.jvm.internal.t.f(sessionGenerator, "sessionGenerator");
        this.f22578a = sessionGenerator;
    }

    @Override // l1.e0
    public Object a(InputStream inputStream, gd.e eVar) throws l1.d {
        try {
            b.a aVar = eh.b.f8972d;
            String strU = kg.z.u(nd.a.c(inputStream));
            aVar.a();
            return (SessionData) aVar.d(SessionData.INSTANCE.serializer(), strU);
        } catch (Exception e10) {
            throw new l1.d("Cannot parse session data", e10);
        }
    }

    @Override // l1.e0
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public SessionData b() {
        return new SessionData(this.f22578a.a(null), (Time) null, (Map) null, 6, (kotlin.jvm.internal.k) null);
    }

    @Override // l1.e0
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Object c(SessionData sessionData, OutputStream outputStream, gd.e eVar) throws IOException {
        outputStream.write(kg.z.v(eh.b.f8972d.b(SessionData.INSTANCE.serializer(), sessionData)));
        return cd.h0.f3852a;
    }
}
