package H2;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements F2.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f548a;

    @Override // F2.a
    public final void a(Object obj, Object obj2) {
        switch (this.f548a) {
            case 0:
                throw new F2.b("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
            case 1:
                Map.Entry entry = (Map.Entry) obj;
                F2.e eVar = (F2.e) obj2;
                eVar.a(I2.f.f631g, entry.getKey());
                eVar.a(I2.f.f632h, entry.getValue());
                return;
            default:
                throw new F2.b("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
        }
    }
}
