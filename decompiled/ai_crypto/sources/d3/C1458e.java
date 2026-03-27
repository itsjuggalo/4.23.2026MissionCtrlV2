package d3;

import S2.a;
import android.os.Bundle;
import e3.C1478g;
import f3.InterfaceC1602b;
import java.util.Locale;

/* JADX INFO: renamed from: d3.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1458e implements a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InterfaceC1602b f13339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InterfaceC1602b f13340b;

    public static void b(InterfaceC1602b interfaceC1602b, String str, Bundle bundle) {
        if (interfaceC1602b == null) {
            return;
        }
        interfaceC1602b.b(str, bundle);
    }

    @Override // S2.a.b
    public void a(int i7, Bundle bundle) {
        String string;
        C1478g.f().i(String.format(Locale.US, "Analytics listener received message. ID: %d, Extras: %s", Integer.valueOf(i7), bundle));
        if (bundle == null || (string = bundle.getString("name")) == null) {
            return;
        }
        Bundle bundle2 = bundle.getBundle("params");
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        c(string, bundle2);
    }

    public final void c(String str, Bundle bundle) {
        b("clx".equals(bundle.getString("_o")) ? this.f13339a : this.f13340b, str, bundle);
    }

    public void d(InterfaceC1602b interfaceC1602b) {
        this.f13340b = interfaceC1602b;
    }

    public void e(InterfaceC1602b interfaceC1602b) {
        this.f13339a = interfaceC1602b;
    }
}
