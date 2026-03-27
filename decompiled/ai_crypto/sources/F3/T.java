package F3;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class T implements InterfaceC0477a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f2079a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f2080b = new HashMap();

    @Override // F3.InterfaceC0477a
    public C3.e a(String str) {
        return (C3.e) this.f2079a.get(str);
    }

    @Override // F3.InterfaceC0477a
    public void b(C3.e eVar) {
        this.f2079a.put(eVar.a(), eVar);
    }

    @Override // F3.InterfaceC0477a
    public C3.j c(String str) {
        return (C3.j) this.f2080b.get(str);
    }

    @Override // F3.InterfaceC0477a
    public void d(C3.j jVar) {
        this.f2080b.put(jVar.b(), jVar);
    }
}
