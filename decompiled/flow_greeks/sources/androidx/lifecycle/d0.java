package androidx.lifecycle;

import android.os.Bundle;
import java.util.Map;
import k2.d;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class d0 implements d.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k2.d f2402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2403b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f2404c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final cd.k f2405d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends kotlin.jvm.internal.v implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m0 f2406a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(m0 m0Var) {
            super(0);
            this.f2406a = m0Var;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e0 invoke() {
            return c0.e(this.f2406a);
        }
    }

    public d0(k2.d savedStateRegistry, m0 viewModelStoreOwner) {
        kotlin.jvm.internal.t.f(savedStateRegistry, "savedStateRegistry");
        kotlin.jvm.internal.t.f(viewModelStoreOwner, "viewModelStoreOwner");
        this.f2402a = savedStateRegistry;
        this.f2405d = cd.l.b(new a(viewModelStoreOwner));
    }

    @Override // k2.d.c
    public Bundle a() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f2404c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        for (Map.Entry entry : c().f().entrySet()) {
            String str = (String) entry.getKey();
            Bundle bundleA = ((z) entry.getValue()).c().a();
            if (!kotlin.jvm.internal.t.b(bundleA, Bundle.EMPTY)) {
                bundle.putBundle(str, bundleA);
            }
        }
        this.f2403b = false;
        return bundle;
    }

    public final Bundle b(String key) {
        kotlin.jvm.internal.t.f(key, "key");
        d();
        Bundle bundle = this.f2404c;
        Bundle bundle2 = bundle != null ? bundle.getBundle(key) : null;
        Bundle bundle3 = this.f2404c;
        if (bundle3 != null) {
            bundle3.remove(key);
        }
        Bundle bundle4 = this.f2404c;
        if (bundle4 != null && bundle4.isEmpty()) {
            this.f2404c = null;
        }
        return bundle2;
    }

    public final e0 c() {
        return (e0) this.f2405d.getValue();
    }

    public final void d() {
        if (this.f2403b) {
            return;
        }
        Bundle bundleB = this.f2402a.b("androidx.lifecycle.internal.SavedStateHandlesProvider");
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f2404c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        if (bundleB != null) {
            bundle.putAll(bundleB);
        }
        this.f2404c = bundle;
        this.f2403b = true;
        c();
    }
}
