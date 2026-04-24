package k4;

import M2.C0700c;
import M2.InterfaceC0701d;
import M2.g;
import M2.i;
import com.google.firebase.components.ComponentRegistrar;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: k4.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2282b implements i {
    public static /* synthetic */ Object c(String str, C0700c c0700c, InterfaceC0701d interfaceC0701d) {
        try {
            c.b(str);
            return c0700c.h().create(interfaceC0701d);
        } finally {
            c.a();
        }
    }

    @Override // M2.i
    public List a(ComponentRegistrar componentRegistrar) {
        ArrayList arrayList = new ArrayList();
        for (final C0700c c0700cT : componentRegistrar.getComponents()) {
            final String strI = c0700cT.i();
            if (strI != null) {
                c0700cT = c0700cT.t(new g() { // from class: k4.a
                    @Override // M2.g
                    public final Object create(InterfaceC0701d interfaceC0701d) {
                        return C2282b.c(strI, c0700cT, interfaceC0701d);
                    }
                });
            }
            arrayList.add(c0700cT);
        }
        return arrayList;
    }
}
