package io.flutter.plugins.googlesignin;

import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lio/flutter/plugins/googlesignin/GetCredentialFailureType;", "", "raw", "", "<init>", "(Ljava/lang/String;II)V", "getRaw", "()I", "UNEXPECTED_CREDENTIAL_TYPE", "MISSING_SERVER_CLIENT_ID", "NO_ACTIVITY", "INTERRUPTED", "CANCELED", "NO_CREDENTIAL", "PROVIDER_CONFIGURATION_ISSUE", "UNSUPPORTED", "UNKNOWN", "Companion", "google_sign_in_android_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetCredentialFailureType {
    private static final /* synthetic */ jd.a $ENTRIES;
    private static final /* synthetic */ GetCredentialFailureType[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final int raw;
    public static final GetCredentialFailureType UNEXPECTED_CREDENTIAL_TYPE = new GetCredentialFailureType("UNEXPECTED_CREDENTIAL_TYPE", 0, 0);
    public static final GetCredentialFailureType MISSING_SERVER_CLIENT_ID = new GetCredentialFailureType("MISSING_SERVER_CLIENT_ID", 1, 1);
    public static final GetCredentialFailureType NO_ACTIVITY = new GetCredentialFailureType("NO_ACTIVITY", 2, 2);
    public static final GetCredentialFailureType INTERRUPTED = new GetCredentialFailureType("INTERRUPTED", 3, 3);
    public static final GetCredentialFailureType CANCELED = new GetCredentialFailureType("CANCELED", 4, 4);
    public static final GetCredentialFailureType NO_CREDENTIAL = new GetCredentialFailureType("NO_CREDENTIAL", 5, 5);
    public static final GetCredentialFailureType PROVIDER_CONFIGURATION_ISSUE = new GetCredentialFailureType("PROVIDER_CONFIGURATION_ISSUE", 6, 6);
    public static final GetCredentialFailureType UNSUPPORTED = new GetCredentialFailureType("UNSUPPORTED", 7, 7);
    public static final GetCredentialFailureType UNKNOWN = new GetCredentialFailureType("UNKNOWN", 8, 8);

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lio/flutter/plugins/googlesignin/GetCredentialFailureType$Companion;", "", "<init>", "()V", "ofRaw", "Lio/flutter/plugins/googlesignin/GetCredentialFailureType;", "raw", "", "google_sign_in_android_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final GetCredentialFailureType ofRaw(int raw) {
            for (GetCredentialFailureType getCredentialFailureType : GetCredentialFailureType.values()) {
                if (getCredentialFailureType.getRaw() == raw) {
                    return getCredentialFailureType;
                }
            }
            return null;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ GetCredentialFailureType[] $values() {
        return new GetCredentialFailureType[]{UNEXPECTED_CREDENTIAL_TYPE, MISSING_SERVER_CLIENT_ID, NO_ACTIVITY, INTERRUPTED, CANCELED, NO_CREDENTIAL, PROVIDER_CONFIGURATION_ISSUE, UNSUPPORTED, UNKNOWN};
    }

    static {
        GetCredentialFailureType[] getCredentialFailureTypeArr$values = $values();
        $VALUES = getCredentialFailureTypeArr$values;
        $ENTRIES = jd.b.a(getCredentialFailureTypeArr$values);
        INSTANCE = new Companion(null);
    }

    private GetCredentialFailureType(String str, int i10, int i11) {
        this.raw = i11;
    }

    public static jd.a getEntries() {
        return $ENTRIES;
    }

    public static GetCredentialFailureType valueOf(String str) {
        return (GetCredentialFailureType) Enum.valueOf(GetCredentialFailureType.class, str);
    }

    public static GetCredentialFailureType[] values() {
        return (GetCredentialFailureType[]) $VALUES.clone();
    }

    public final int getRaw() {
        return this.raw;
    }
}
