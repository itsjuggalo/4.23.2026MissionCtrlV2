package androidx.lifecycle;

import androidx.lifecycle.AbstractC1157i;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: androidx.lifecycle.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1152d implements InterfaceC1159k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DefaultLifecycleObserver f11965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC1159k f11966b;

    /* JADX INFO: renamed from: androidx.lifecycle.d$a */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11967a;

        static {
            int[] iArr = new int[AbstractC1157i.a.values().length];
            try {
                iArr[AbstractC1157i.a.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AbstractC1157i.a.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AbstractC1157i.a.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AbstractC1157i.a.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AbstractC1157i.a.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AbstractC1157i.a.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[AbstractC1157i.a.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f11967a = iArr;
        }
    }

    public C1152d(DefaultLifecycleObserver defaultLifecycleObserver, InterfaceC1159k interfaceC1159k) {
        AbstractC2304t.f(defaultLifecycleObserver, "defaultLifecycleObserver");
        this.f11965a = defaultLifecycleObserver;
        this.f11966b = interfaceC1159k;
    }

    @Override // androidx.lifecycle.InterfaceC1159k
    public void b(InterfaceC1161m source, AbstractC1157i.a event) {
        AbstractC2304t.f(source, "source");
        AbstractC2304t.f(event, "event");
        switch (a.f11967a[event.ordinal()]) {
            case 1:
                this.f11965a.onCreate(source);
                break;
            case 2:
                this.f11965a.onStart(source);
                break;
            case 3:
                this.f11965a.onResume(source);
                break;
            case 4:
                this.f11965a.onPause(source);
                break;
            case 5:
                this.f11965a.onStop(source);
                break;
            case 6:
                this.f11965a.onDestroy(source);
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        InterfaceC1159k interfaceC1159k = this.f11966b;
        if (interfaceC1159k != null) {
            interfaceC1159k.b(source, event);
        }
    }
}
