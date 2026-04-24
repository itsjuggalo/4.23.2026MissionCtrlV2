package androidx.lifecycle;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: renamed from: androidx.lifecycle.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0846i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AtomicReference f7675a = new AtomicReference();

    /* JADX INFO: renamed from: androidx.lifecycle.i$a */
    public enum a {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY;

        public static final C0110a Companion = new C0110a(null);

        /* JADX INFO: renamed from: androidx.lifecycle.i$a$a, reason: collision with other inner class name */
        public static final class C0110a {

            /* JADX INFO: renamed from: androidx.lifecycle.i$a$a$a, reason: collision with other inner class name */
            public /* synthetic */ class C0111a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f7676a;

                static {
                    int[] iArr = new int[b.values().length];
                    try {
                        iArr[b.CREATED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[b.STARTED.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[b.RESUMED.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[b.DESTROYED.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[b.INITIALIZED.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    f7676a = iArr;
                }
            }

            public /* synthetic */ C0110a(AbstractC1585j abstractC1585j) {
                this();
            }

            public final a a(b state) {
                kotlin.jvm.internal.r.f(state, "state");
                int i4 = C0111a.f7676a[state.ordinal()];
                if (i4 == 1) {
                    return a.ON_DESTROY;
                }
                if (i4 == 2) {
                    return a.ON_STOP;
                }
                if (i4 != 3) {
                    return null;
                }
                return a.ON_PAUSE;
            }

            public final a b(b state) {
                kotlin.jvm.internal.r.f(state, "state");
                int i4 = C0111a.f7676a[state.ordinal()];
                if (i4 == 1) {
                    return a.ON_START;
                }
                if (i4 == 2) {
                    return a.ON_RESUME;
                }
                if (i4 != 5) {
                    return null;
                }
                return a.ON_CREATE;
            }

            public final a c(b state) {
                kotlin.jvm.internal.r.f(state, "state");
                int i4 = C0111a.f7676a[state.ordinal()];
                if (i4 == 1) {
                    return a.ON_CREATE;
                }
                if (i4 == 2) {
                    return a.ON_START;
                }
                if (i4 != 3) {
                    return null;
                }
                return a.ON_RESUME;
            }

            public C0110a() {
            }
        }

        /* JADX INFO: renamed from: androidx.lifecycle.i$a$b */
        public /* synthetic */ class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f7677a;

            static {
                int[] iArr = new int[a.values().length];
                try {
                    iArr[a.ON_CREATE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[a.ON_STOP.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[a.ON_START.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[a.ON_PAUSE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[a.ON_RESUME.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[a.ON_DESTROY.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[a.ON_ANY.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                f7677a = iArr;
            }
        }

        public static final a c(b bVar) {
            return Companion.a(bVar);
        }

        public static final a h(b bVar) {
            return Companion.c(bVar);
        }

        public final b g() {
            switch (b.f7677a[ordinal()]) {
                case 1:
                case 2:
                    return b.CREATED;
                case 3:
                case 4:
                    return b.STARTED;
                case 5:
                    return b.RESUMED;
                case 6:
                    return b.DESTROYED;
                default:
                    throw new IllegalArgumentException(this + " has no target state");
            }
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.i$b */
    public enum b {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public final boolean c(b state) {
            kotlin.jvm.internal.r.f(state, "state");
            return compareTo(state) >= 0;
        }
    }

    public abstract void a(InterfaceC0849l interfaceC0849l);

    public abstract b b();

    public abstract void c(InterfaceC0849l interfaceC0849l);
}
