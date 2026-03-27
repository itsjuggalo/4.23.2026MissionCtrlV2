package androidx.datastore.preferences.protobuf;

import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public final class E {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0336s f4480b = new C0336s(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f4481a;

    public E(C0330l c0330l) {
        AbstractC0341x.a(c0330l, "output");
        this.f4481a = c0330l;
        c0330l.f4581a = this;
    }

    public void a(int i, Object obj, V v2) {
        C0330l c0330l = (C0330l) this.f4481a;
        c0330l.p0(i, 3);
        v2.e((AbstractC0319a) obj, c0330l.f4581a);
        c0330l.p0(i, 4);
    }

    public E() {
        S s6 = S.f4509c;
        K k6 = f4480b;
        try {
            k6 = (K) Class.forName("androidx.datastore.preferences.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
        }
        K[] kArr = {C0336s.f4612b, k6};
        D d4 = new D();
        d4.f4479a = kArr;
        Charset charset = AbstractC0341x.f4616a;
        this.f4481a = d4;
    }
}
