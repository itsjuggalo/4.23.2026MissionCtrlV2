package P6;

import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f6493a;

    public static final class a extends g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f6494b = new a();

        public a() {
            super(false, null);
        }
    }

    public static final class b extends g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f6495b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String error) {
            super(false, null);
            AbstractC2304t.f(error, "error");
            this.f6495b = error;
        }
    }

    public static final class c extends g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f6496b = new c();

        public c() {
            super(true, null);
        }
    }

    public g(boolean z7) {
        this.f6493a = z7;
    }

    public final boolean a() {
        return this.f6493a;
    }

    public /* synthetic */ g(boolean z7, AbstractC2296k abstractC2296k) {
        this(z7);
    }
}
