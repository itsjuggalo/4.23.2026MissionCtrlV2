package io.flutter.plugins.googlesignin;

import dd.r;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bJ\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0016"}, d2 = {"Lio/flutter/plugins/googlesignin/GetCredentialRequestGoogleIdOptionParams;", "", "filterToAuthorized", "", "autoSelectEnabled", "<init>", "(ZZ)V", "getFilterToAuthorized", "()Z", "getAutoSelectEnabled", "toList", "", "equals", "other", "hashCode", "", "component1", "component2", "copy", "toString", "", "Companion", "google_sign_in_android_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class GetCredentialRequestGoogleIdOptionParams {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean autoSelectEnabled;
    private final boolean filterToAuthorized;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¨\u0006\b"}, d2 = {"Lio/flutter/plugins/googlesignin/GetCredentialRequestGoogleIdOptionParams$Companion;", "", "<init>", "()V", "fromList", "Lio/flutter/plugins/googlesignin/GetCredentialRequestGoogleIdOptionParams;", "pigeonVar_list", "", "google_sign_in_android_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final GetCredentialRequestGoogleIdOptionParams fromList(List<? extends Object> pigeonVar_list) {
            kotlin.jvm.internal.t.f(pigeonVar_list, "pigeonVar_list");
            Object obj = pigeonVar_list.get(0);
            kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.Boolean");
            boolean zBooleanValue = ((Boolean) obj).booleanValue();
            Object obj2 = pigeonVar_list.get(1);
            kotlin.jvm.internal.t.d(obj2, "null cannot be cast to non-null type kotlin.Boolean");
            return new GetCredentialRequestGoogleIdOptionParams(zBooleanValue, ((Boolean) obj2).booleanValue());
        }

        private Companion() {
        }
    }

    public GetCredentialRequestGoogleIdOptionParams(boolean z10, boolean z11) {
        this.filterToAuthorized = z10;
        this.autoSelectEnabled = z11;
    }

    public static /* synthetic */ GetCredentialRequestGoogleIdOptionParams copy$default(GetCredentialRequestGoogleIdOptionParams getCredentialRequestGoogleIdOptionParams, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = getCredentialRequestGoogleIdOptionParams.filterToAuthorized;
        }
        if ((i10 & 2) != 0) {
            z11 = getCredentialRequestGoogleIdOptionParams.autoSelectEnabled;
        }
        return getCredentialRequestGoogleIdOptionParams.copy(z10, z11);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getFilterToAuthorized() {
        return this.filterToAuthorized;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getAutoSelectEnabled() {
        return this.autoSelectEnabled;
    }

    public final GetCredentialRequestGoogleIdOptionParams copy(boolean filterToAuthorized, boolean autoSelectEnabled) {
        return new GetCredentialRequestGoogleIdOptionParams(filterToAuthorized, autoSelectEnabled);
    }

    public boolean equals(Object other) {
        if (!(other instanceof GetCredentialRequestGoogleIdOptionParams)) {
            return false;
        }
        if (this == other) {
            return true;
        }
        return MessagesPigeonUtils.INSTANCE.deepEquals(toList(), ((GetCredentialRequestGoogleIdOptionParams) other).toList());
    }

    public final boolean getAutoSelectEnabled() {
        return this.autoSelectEnabled;
    }

    public final boolean getFilterToAuthorized() {
        return this.filterToAuthorized;
    }

    public int hashCode() {
        return toList().hashCode();
    }

    public final List<Object> toList() {
        return r.n(Boolean.valueOf(this.filterToAuthorized), Boolean.valueOf(this.autoSelectEnabled));
    }

    public String toString() {
        return "GetCredentialRequestGoogleIdOptionParams(filterToAuthorized=" + this.filterToAuthorized + ", autoSelectEnabled=" + this.autoSelectEnabled + ")";
    }
}
