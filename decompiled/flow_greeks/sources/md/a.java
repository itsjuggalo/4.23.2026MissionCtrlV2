package md;

import td.c;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class a extends ld.a {

    /* JADX INFO: renamed from: md.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0291a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0291a f16424a = new C0291a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Integer f16425b;

        static {
            Object obj;
            Integer num = null;
            try {
                obj = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
            } catch (Throwable unused) {
            }
            Integer num2 = obj instanceof Integer ? (Integer) obj : null;
            if (num2 != null && num2.intValue() > 0) {
                num = num2;
            }
            f16425b = num;
        }
    }

    @Override // kd.a
    public c b() {
        return c(34) ? new ud.a() : super.b();
    }

    public final boolean c(int i10) {
        Integer num = C0291a.f16425b;
        return num == null || num.intValue() >= i10;
    }
}
