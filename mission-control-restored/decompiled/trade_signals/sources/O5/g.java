package O5;

import kotlin.jvm.internal.AbstractC2296k;
import o5.AbstractC2484l;
import o5.InterfaceC2483k;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends i {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f6038h = new a(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final InterfaceC2483k f6039i = AbstractC2484l.a(f.f6037a);

    public static final class a {
        public a() {
        }

        public final g a() {
            return (g) g.f6039i.getValue();
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public g(boolean z7) {
        super(new H6.f("DefaultBuiltIns"));
        if (z7) {
            f(false);
        }
    }

    public static final g G0() {
        return new g(false, 1, null);
    }

    public /* synthetic */ g(boolean z7, int i8, AbstractC2296k abstractC2296k) {
        this((i8 & 1) != 0 ? true : z7);
    }
}
