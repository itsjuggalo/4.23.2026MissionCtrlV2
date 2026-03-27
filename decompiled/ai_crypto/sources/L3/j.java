package L3;

/* JADX INFO: loaded from: classes.dex */
public interface j {

    public enum a {
        NONE(0),
        SDK(1),
        GLOBAL(2),
        COMBINED(3);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f3669a;

        a(int i7) {
            this.f3669a = i7;
        }

        public int b() {
            return this.f3669a;
        }
    }

    a b(String str);
}
