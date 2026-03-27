package androidx.datastore.preferences.protobuf;

/* JADX INFO: loaded from: classes.dex */
public final class B {
    public static InterfaceC0340w a(Object obj, long j4) {
        InterfaceC0340w interfaceC0340w = (InterfaceC0340w) i0.f4568c.h(obj, j4);
        if (((AbstractC0320b) interfaceC0340w).f4536a) {
            return interfaceC0340w;
        }
        T t6 = (T) interfaceC0340w;
        int i = t6.f4514c;
        T tC = t6.c(i == 0 ? 10 : i * 2);
        i0.o(obj, j4, tC);
        return tC;
    }
}
