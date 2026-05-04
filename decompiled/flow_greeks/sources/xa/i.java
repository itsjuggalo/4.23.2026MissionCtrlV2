package xa;

import cd.h0;
import eh.b;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kg.z;
import l1.e0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f24752a = new i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SessionConfigs f24753b = new SessionConfigs(null, null, null, null, null);

    @Override // l1.e0
    public Object a(InputStream inputStream, gd.e eVar) throws l1.d {
        try {
            b.a aVar = eh.b.f8972d;
            String strU = z.u(nd.a.c(inputStream));
            aVar.a();
            return (SessionConfigs) aVar.d(SessionConfigs.INSTANCE.serializer(), strU);
        } catch (Exception e10) {
            throw new l1.d("Cannot parse session configs", e10);
        }
    }

    @Override // l1.e0
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public SessionConfigs b() {
        return f24753b;
    }

    @Override // l1.e0
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Object c(SessionConfigs sessionConfigs, OutputStream outputStream, gd.e eVar) throws IOException {
        outputStream.write(z.v(eh.b.f8972d.b(SessionConfigs.INSTANCE.serializer(), sessionConfigs)));
        return h0.f3852a;
    }
}
