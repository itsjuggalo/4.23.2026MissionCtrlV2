package i9;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class s0 implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f12152a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f12153b = new HashMap();

    @Override // i9.a
    public f9.e a(String str) {
        return (f9.e) this.f12152a.get(str);
    }

    @Override // i9.a
    public void b(f9.e eVar) {
        this.f12152a.put(eVar.a(), eVar);
    }

    @Override // i9.a
    public void c(f9.j jVar) {
        this.f12153b.put(jVar.b(), jVar);
    }

    @Override // i9.a
    public f9.j d(String str) {
        return (f9.j) this.f12153b.get(str);
    }
}
