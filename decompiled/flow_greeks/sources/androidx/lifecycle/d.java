package androidx.lifecycle;

import androidx.lifecycle.i;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DefaultLifecycleObserver f2399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f2400b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2401a;

        static {
            int[] iArr = new int[i.a.values().length];
            try {
                iArr[i.a.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[i.a.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[i.a.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[i.a.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[i.a.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[i.a.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[i.a.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f2401a = iArr;
        }
    }

    public d(DefaultLifecycleObserver defaultLifecycleObserver, k kVar) {
        kotlin.jvm.internal.t.f(defaultLifecycleObserver, "defaultLifecycleObserver");
        this.f2399a = defaultLifecycleObserver;
        this.f2400b = kVar;
    }

    @Override // androidx.lifecycle.k
    public void b(m source, i.a event) {
        kotlin.jvm.internal.t.f(source, "source");
        kotlin.jvm.internal.t.f(event, "event");
        switch (a.f2401a[event.ordinal()]) {
            case 1:
                this.f2399a.onCreate(source);
                break;
            case 2:
                this.f2399a.onStart(source);
                break;
            case 3:
                this.f2399a.onResume(source);
                break;
            case 4:
                this.f2399a.onPause(source);
                break;
            case 5:
                this.f2399a.onStop(source);
                break;
            case 6:
                this.f2399a.onDestroy(source);
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        k kVar = this.f2400b;
        if (kVar != null) {
            kVar.b(source, event);
        }
    }
}
