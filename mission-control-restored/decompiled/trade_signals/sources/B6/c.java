package B6;

import B6.d;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    public static final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f175a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f176b;

        static {
            d.a aVar = d.f178c;
            f176b = (~(aVar.i() | aVar.d())) & aVar.b();
        }

        @Override // B6.c
        public int a() {
            return f176b;
        }
    }

    public static final class b extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f177a = new b();

        @Override // B6.c
        public int a() {
            return 0;
        }
    }

    public abstract int a();

    public String toString() {
        return getClass().getSimpleName();
    }
}
