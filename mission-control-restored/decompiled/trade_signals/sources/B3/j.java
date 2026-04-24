package B3;

/* JADX INFO: loaded from: classes.dex */
public interface j {

    public enum a {
        NONE(0),
        SDK(1),
        GLOBAL(2),
        COMBINED(3);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f147a;

        a(int i8) {
            this.f147a = i8;
        }

        public int b() {
            return this.f147a;
        }
    }

    a b(String str);
}
