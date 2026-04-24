package androidx.lifecycle;

import android.os.Bundle;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import o0.d;

/* JADX INFO: loaded from: classes.dex */
public final class E implements d.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0.d f7630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f7631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f7632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final W2.j f7633d;

    public static final class a extends kotlin.jvm.internal.s implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ N f7634a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(N n4) {
            super(0);
            this.f7634a = n4;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final F invoke() {
            return D.e(this.f7634a);
        }
    }

    public E(o0.d savedStateRegistry, N viewModelStoreOwner) {
        kotlin.jvm.internal.r.f(savedStateRegistry, "savedStateRegistry");
        kotlin.jvm.internal.r.f(viewModelStoreOwner, "viewModelStoreOwner");
        this.f7630a = savedStateRegistry;
        this.f7633d = W2.k.b(new a(viewModelStoreOwner));
    }

    @Override // o0.d.c
    public Bundle a() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f7632c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        for (Map.Entry entry : c().f().entrySet()) {
            String str = (String) entry.getKey();
            Bundle bundleA = ((A) entry.getValue()).c().a();
            if (!kotlin.jvm.internal.r.b(bundleA, Bundle.EMPTY)) {
                bundle.putBundle(str, bundleA);
            }
        }
        this.f7631b = false;
        return bundle;
    }

    public final Bundle b(String key) {
        kotlin.jvm.internal.r.f(key, "key");
        d();
        Bundle bundle = this.f7632c;
        Bundle bundle2 = bundle != null ? bundle.getBundle(key) : null;
        Bundle bundle3 = this.f7632c;
        if (bundle3 != null) {
            bundle3.remove(key);
        }
        Bundle bundle4 = this.f7632c;
        if (bundle4 != null && bundle4.isEmpty()) {
            this.f7632c = null;
        }
        return bundle2;
    }

    public final F c() {
        return (F) this.f7633d.getValue();
    }

    public final void d() {
        if (this.f7631b) {
            return;
        }
        Bundle bundleB = this.f7630a.b("androidx.lifecycle.internal.SavedStateHandlesProvider");
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f7632c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        if (bundleB != null) {
            bundle.putAll(bundleB);
        }
        this.f7632c = bundle;
        this.f7631b = true;
        c();
    }
}
