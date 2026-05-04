package x0;

import android.os.Bundle;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f24138h = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f24139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bundle f24140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Bundle f24141c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f24142d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f24143e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set f24144f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f24145g;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    public g(String type, Bundle requestData, Bundle candidateQueryData, boolean z10, boolean z11, Set allowedProviders, int i10) {
        kotlin.jvm.internal.t.f(type, "type");
        kotlin.jvm.internal.t.f(requestData, "requestData");
        kotlin.jvm.internal.t.f(candidateQueryData, "candidateQueryData");
        kotlin.jvm.internal.t.f(allowedProviders, "allowedProviders");
        this.f24139a = type;
        this.f24140b = requestData;
        this.f24141c = candidateQueryData;
        this.f24142d = z10;
        this.f24143e = z11;
        this.f24144f = allowedProviders;
        this.f24145g = i10;
        requestData.putBoolean("androidx.credentials.BUNDLE_KEY_IS_AUTO_SELECT_ALLOWED", z11);
        candidateQueryData.putBoolean("androidx.credentials.BUNDLE_KEY_IS_AUTO_SELECT_ALLOWED", z11);
        requestData.putInt("androidx.credentials.BUNDLE_KEY_TYPE_PRIORITY_VALUE", i10);
        candidateQueryData.putInt("androidx.credentials.BUNDLE_KEY_TYPE_PRIORITY_VALUE", i10);
    }

    public final Set a() {
        return this.f24144f;
    }

    public final Bundle b() {
        return this.f24141c;
    }

    public final Bundle c() {
        return this.f24140b;
    }

    public final String d() {
        return this.f24139a;
    }

    public final boolean e() {
        return this.f24142d;
    }
}
