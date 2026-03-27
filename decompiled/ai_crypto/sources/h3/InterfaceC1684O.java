package h3;

/* JADX INFO: renamed from: h3.O, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceC1684O {

    /* JADX INFO: renamed from: h3.O$a */
    public static abstract class a {
        public static a a(String str, C1682M c1682m) {
            return new C1689c(str, c1682m.b(), c1682m.a());
        }

        public static a b(String str) {
            return new C1689c(str, null, null);
        }

        public abstract String c();

        public abstract String d();

        public abstract String e();
    }

    a a();
}
