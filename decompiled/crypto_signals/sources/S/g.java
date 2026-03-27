package S;

import androidx.datastore.preferences.protobuf.AbstractC0320b;
import androidx.datastore.preferences.protobuf.AbstractC0337t;
import androidx.datastore.preferences.protobuf.AbstractC0339v;
import androidx.datastore.preferences.protobuf.AbstractC0341x;
import androidx.datastore.preferences.protobuf.C0338u;
import androidx.datastore.preferences.protobuf.InterfaceC0340w;
import androidx.datastore.preferences.protobuf.Q;
import androidx.datastore.preferences.protobuf.T;
import androidx.datastore.preferences.protobuf.U;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.RandomAccess;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class g extends AbstractC0339v {
    private static final g DEFAULT_INSTANCE;
    private static volatile Q PARSER = null;
    public static final int STRINGS_FIELD_NUMBER = 1;
    private InterfaceC0340w strings_ = T.f4512d;

    static {
        g gVar = new g();
        DEFAULT_INSTANCE = gVar;
        AbstractC0339v.j(g.class, gVar);
    }

    public static void l(g gVar, Set set) {
        InterfaceC0340w interfaceC0340w = gVar.strings_;
        if (!((AbstractC0320b) interfaceC0340w).f4536a) {
            T t6 = (T) interfaceC0340w;
            int i = t6.f4514c;
            gVar.strings_ = t6.c(i == 0 ? 10 : i * 2);
        }
        RandomAccess randomAccess = gVar.strings_;
        Charset charset = AbstractC0341x.f4616a;
        set.getClass();
        if (randomAccess instanceof ArrayList) {
            ((ArrayList) randomAccess).ensureCapacity(set.size() + ((T) randomAccess).f4514c);
        }
        T t7 = (T) randomAccess;
        int i6 = t7.f4514c;
        for (Object obj : set) {
            if (obj == null) {
                String str = "Element at index " + (t7.f4514c - i6) + " is null.";
                for (int i7 = t7.f4514c - 1; i7 >= i6; i7--) {
                    t7.remove(i7);
                }
                throw new NullPointerException(str);
            }
            t7.add(obj);
        }
    }

    public static g m() {
        return DEFAULT_INSTANCE;
    }

    public static f o() {
        return (f) ((AbstractC0337t) DEFAULT_INSTANCE.c(5));
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0339v
    public final Object c(int i) {
        Q c0338u;
        switch (i.c(i)) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new U(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"strings_"});
            case 3:
                return new g();
            case 4:
                return new f(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Q q6 = PARSER;
                if (q6 != null) {
                    return q6;
                }
                synchronized (g.class) {
                    try {
                        c0338u = PARSER;
                        if (c0338u == null) {
                            c0338u = new C0338u();
                            PARSER = c0338u;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return c0338u;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final InterfaceC0340w n() {
        return this.strings_;
    }
}
