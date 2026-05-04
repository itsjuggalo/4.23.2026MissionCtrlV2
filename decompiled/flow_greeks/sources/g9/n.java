package g9;

import g9.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f10289a = new HashMap();

    public void a(m mVar) {
        j9.k key = mVar.b().getKey();
        m mVar2 = (m) this.f10289a.get(key);
        if (mVar2 == null) {
            this.f10289a.put(key, mVar);
            return;
        }
        m.a aVarC = mVar2.c();
        m.a aVarC2 = mVar.c();
        m.a aVar = m.a.ADDED;
        if (aVarC2 != aVar && aVarC == m.a.METADATA) {
            this.f10289a.put(key, mVar);
            return;
        }
        if (aVarC2 == m.a.METADATA && aVarC != m.a.REMOVED) {
            this.f10289a.put(key, m.a(aVarC, mVar.b()));
            return;
        }
        m.a aVar2 = m.a.MODIFIED;
        if (aVarC2 == aVar2 && aVarC == aVar2) {
            this.f10289a.put(key, m.a(aVar2, mVar.b()));
            return;
        }
        if (aVarC2 == aVar2 && aVarC == aVar) {
            this.f10289a.put(key, m.a(aVar, mVar.b()));
            return;
        }
        m.a aVar3 = m.a.REMOVED;
        if (aVarC2 == aVar3 && aVarC == aVar) {
            this.f10289a.remove(key);
            return;
        }
        if (aVarC2 == aVar3 && aVarC == aVar2) {
            this.f10289a.put(key, m.a(aVar3, mVar2.b()));
        } else {
            if (aVarC2 != aVar || aVarC != aVar3) {
                throw n9.b.a("Unsupported combination of changes %s after %s", aVarC2, aVarC);
            }
            this.f10289a.put(key, m.a(aVar2, mVar.b()));
        }
    }

    public List b() {
        return new ArrayList(this.f10289a.values());
    }
}
