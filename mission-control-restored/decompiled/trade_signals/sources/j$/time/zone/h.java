package j$.time.zone;

import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class h implements PrivilegedAction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ List f19909a;

    h(ArrayList arrayList) {
        this.f19909a = arrayList;
    }

    @Override // java.security.PrivilegedAction
    public final Object run() {
        String property = System.getProperty("java.time.zone.DefaultZoneRulesProvider");
        if (property == null) {
            j.e(new i());
            return null;
        }
        try {
            j jVar = (j) j.class.cast(Class.forName(property, true, j.class.getClassLoader()).newInstance());
            j.e(jVar);
            this.f19909a.add(jVar);
            return null;
        } catch (Exception e8) {
            throw new Error(e8);
        }
    }
}
