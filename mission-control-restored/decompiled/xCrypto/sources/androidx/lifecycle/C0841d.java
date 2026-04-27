package androidx.lifecycle;

import androidx.lifecycle.AbstractC0846i;

/* JADX INFO: renamed from: androidx.lifecycle.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0841d implements InterfaceC0848k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DefaultLifecycleObserver f7669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC0848k f7670b;

    /* JADX INFO: renamed from: androidx.lifecycle.d$a */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7671a;

        static {
            int[] iArr = new int[AbstractC0846i.a.values().length];
            try {
                iArr[AbstractC0846i.a.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AbstractC0846i.a.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AbstractC0846i.a.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AbstractC0846i.a.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AbstractC0846i.a.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AbstractC0846i.a.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[AbstractC0846i.a.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f7671a = iArr;
        }
    }

    public C0841d(DefaultLifecycleObserver defaultLifecycleObserver, InterfaceC0848k interfaceC0848k) {
        kotlin.jvm.internal.r.f(defaultLifecycleObserver, "defaultLifecycleObserver");
        this.f7669a = defaultLifecycleObserver;
        this.f7670b = interfaceC0848k;
    }

    @Override // androidx.lifecycle.InterfaceC0848k
    public void a(InterfaceC0850m source, AbstractC0846i.a event) {
        kotlin.jvm.internal.r.f(source, "source");
        kotlin.jvm.internal.r.f(event, "event");
        switch (a.f7671a[event.ordinal()]) {
            case 1:
                this.f7669a.onCreate(source);
                break;
            case 2:
                this.f7669a.onStart(source);
                break;
            case 3:
                this.f7669a.onResume(source);
                break;
            case 4:
                this.f7669a.onPause(source);
                break;
            case 5:
                this.f7669a.onStop(source);
                break;
            case 6:
                this.f7669a.onDestroy(source);
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        InterfaceC0848k interfaceC0848k = this.f7670b;
        if (interfaceC0848k != null) {
            interfaceC0848k.a(source, event);
        }
    }
}
