package androidx.lifecycle;

import androidx.lifecycle.AbstractC0963i;

/* JADX INFO: renamed from: androidx.lifecycle.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0958d implements InterfaceC0965k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DefaultLifecycleObserver f7767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC0965k f7768b;

    /* JADX INFO: renamed from: androidx.lifecycle.d$a */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7769a;

        static {
            int[] iArr = new int[AbstractC0963i.a.values().length];
            try {
                iArr[AbstractC0963i.a.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AbstractC0963i.a.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AbstractC0963i.a.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AbstractC0963i.a.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AbstractC0963i.a.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AbstractC0963i.a.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[AbstractC0963i.a.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f7769a = iArr;
        }
    }

    public C0958d(DefaultLifecycleObserver defaultLifecycleObserver, InterfaceC0965k interfaceC0965k) {
        kotlin.jvm.internal.r.f(defaultLifecycleObserver, "defaultLifecycleObserver");
        this.f7767a = defaultLifecycleObserver;
        this.f7768b = interfaceC0965k;
    }

    @Override // androidx.lifecycle.InterfaceC0965k
    public void a(InterfaceC0967m source, AbstractC0963i.a event) {
        kotlin.jvm.internal.r.f(source, "source");
        kotlin.jvm.internal.r.f(event, "event");
        switch (a.f7769a[event.ordinal()]) {
            case 1:
                this.f7767a.onCreate(source);
                break;
            case 2:
                this.f7767a.onStart(source);
                break;
            case 3:
                this.f7767a.onResume(source);
                break;
            case 4:
                this.f7767a.onPause(source);
                break;
            case 5:
                this.f7767a.onStop(source);
                break;
            case 6:
                this.f7767a.onDestroy(source);
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        InterfaceC0965k interfaceC0965k = this.f7768b;
        if (interfaceC0965k != null) {
            interfaceC0965k.a(source, event);
        }
    }
}
