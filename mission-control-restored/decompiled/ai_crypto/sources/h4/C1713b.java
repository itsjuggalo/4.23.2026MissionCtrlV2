package h4;

import b3.C0986c;
import b3.InterfaceC0987d;
import b3.InterfaceC0990g;
import b3.InterfaceC0992i;
import com.google.firebase.components.ComponentRegistrar;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: h4.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1713b implements InterfaceC0992i {
    public static /* synthetic */ Object c(String str, C0986c c0986c, InterfaceC0987d interfaceC0987d) {
        try {
            AbstractC1714c.b(str);
            return c0986c.h().a(interfaceC0987d);
        } finally {
            AbstractC1714c.a();
        }
    }

    @Override // b3.InterfaceC0992i
    public List a(ComponentRegistrar componentRegistrar) {
        ArrayList arrayList = new ArrayList();
        for (final C0986c c0986cT : componentRegistrar.getComponents()) {
            final String strI = c0986cT.i();
            if (strI != null) {
                c0986cT = c0986cT.t(new InterfaceC0990g() { // from class: h4.a
                    @Override // b3.InterfaceC0990g
                    public final Object a(InterfaceC0987d interfaceC0987d) {
                        return C1713b.c(strI, c0986cT, interfaceC0987d);
                    }
                });
            }
            arrayList.add(c0986cT);
        }
        return arrayList;
    }
}
