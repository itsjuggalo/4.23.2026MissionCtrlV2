package K3;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public final class s extends w {
    public static final s INSTANCE = new s();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1376a = "null";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ W2.j f1377b = W2.k.a(W2.l.f5481b, a.f1378a);

    public static final class a extends kotlin.jvm.internal.s implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f1378a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final F3.b invoke() {
            return t.f1379a;
        }
    }

    public s() {
        super(null);
    }

    @Override // K3.w
    public String f() {
        return f1376a;
    }

    @Override // K3.w
    public boolean i() {
        return false;
    }

    public final /* synthetic */ F3.b k() {
        return (F3.b) f1377b.getValue();
    }

    public final F3.b serializer() {
        return k();
    }
}
