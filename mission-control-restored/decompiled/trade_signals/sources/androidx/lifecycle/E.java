package androidx.lifecycle;

import android.os.Bundle;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.AbstractC2306v;
import o5.AbstractC2484l;
import o5.InterfaceC2483k;
import z0.d;

/* JADX INFO: loaded from: classes.dex */
public final class E implements d.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z0.d f11926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f11927b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f11928c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC2483k f11929d;

    public static final class a extends AbstractC2306v implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ N f11930a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(N n8) {
            super(0);
            this.f11930a = n8;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final F invoke() {
            return D.e(this.f11930a);
        }
    }

    public E(z0.d savedStateRegistry, N viewModelStoreOwner) {
        AbstractC2304t.f(savedStateRegistry, "savedStateRegistry");
        AbstractC2304t.f(viewModelStoreOwner, "viewModelStoreOwner");
        this.f11926a = savedStateRegistry;
        this.f11929d = AbstractC2484l.a(new a(viewModelStoreOwner));
    }

    @Override // z0.d.c
    public Bundle a() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f11928c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        for (Map.Entry entry : c().f().entrySet()) {
            String str = (String) entry.getKey();
            Bundle bundleA = ((A) entry.getValue()).c().a();
            if (!AbstractC2304t.b(bundleA, Bundle.EMPTY)) {
                bundle.putBundle(str, bundleA);
            }
        }
        this.f11927b = false;
        return bundle;
    }

    public final Bundle b(String key) {
        AbstractC2304t.f(key, "key");
        d();
        Bundle bundle = this.f11928c;
        Bundle bundle2 = bundle != null ? bundle.getBundle(key) : null;
        Bundle bundle3 = this.f11928c;
        if (bundle3 != null) {
            bundle3.remove(key);
        }
        Bundle bundle4 = this.f11928c;
        if (bundle4 != null && bundle4.isEmpty()) {
            this.f11928c = null;
        }
        return bundle2;
    }

    public final F c() {
        return (F) this.f11929d.getValue();
    }

    public final void d() {
        if (this.f11927b) {
            return;
        }
        Bundle bundleB = this.f11926a.b("androidx.lifecycle.internal.SavedStateHandlesProvider");
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f11928c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        if (bundleB != null) {
            bundle.putAll(bundleB);
        }
        this.f11928c = bundle;
        this.f11927b = true;
        c();
    }
}
