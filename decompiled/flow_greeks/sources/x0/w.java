package x0;

import android.content.ComponentName;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class w {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f24160f = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f24161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f24162b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f24163c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ComponentName f24164d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f24165e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List f24166a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f24167b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f24168c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f24169d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ComponentName f24170e;

        public final a a(g credentialOption) {
            kotlin.jvm.internal.t.f(credentialOption, "credentialOption");
            this.f24166a.add(credentialOption);
            return this;
        }

        public final w b() {
            return new w(dd.a0.I0(this.f24166a), this.f24167b, this.f24168c, this.f24170e, this.f24169d);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {
        public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final Bundle a(w request) {
            kotlin.jvm.internal.t.f(request, "request");
            Bundle bundle = new Bundle();
            bundle.putBoolean("androidx.credentials.BUNDLE_KEY_PREFER_IDENTITY_DOC_UI", request.c());
            bundle.putBoolean("androidx.credentials.BUNDLE_KEY_PREFER_IMMEDIATELY_AVAILABLE_CREDENTIALS", request.e());
            bundle.putParcelable("androidx.credentials.BUNDLE_KEY_PREFER_UI_BRANDING_COMPONENT_NAME", request.d());
            return bundle;
        }

        public b() {
        }
    }

    public w(List credentialOptions, String str, boolean z10, ComponentName componentName, boolean z11) {
        kotlin.jvm.internal.t.f(credentialOptions, "credentialOptions");
        this.f24161a = credentialOptions;
        this.f24162b = str;
        this.f24163c = z10;
        this.f24164d = componentName;
        this.f24165e = z11;
        if (credentialOptions.isEmpty()) {
            throw new IllegalArgumentException("credentialOptions should not be empty");
        }
        if (credentialOptions.size() > 1) {
            if (credentialOptions == null || !credentialOptions.isEmpty()) {
                Iterator it = credentialOptions.iterator();
                while (it.hasNext()) {
                }
            }
            for (g gVar : this.f24161a) {
            }
        }
    }

    public final List a() {
        return this.f24161a;
    }

    public final String b() {
        return this.f24162b;
    }

    public final boolean c() {
        return this.f24163c;
    }

    public final ComponentName d() {
        return this.f24164d;
    }

    public final boolean e() {
        return this.f24165e;
    }
}
