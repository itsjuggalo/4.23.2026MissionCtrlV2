package io.flutter.plugins.firebase.database;

import com.google.android.play.core.integrity.model.IntegrityErrorCode;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\t\u0018\u0000 \u00102\u00060\u0001j\u0002`\u0002:\u0001\u0010B5\b\u0007\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0004\u0012\u0016\b\u0003\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lio/flutter/plugins/firebase/database/FlutterFirebaseDatabaseException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", Constants.ERROR_CODE, "", com.amazon.a.a.o.b.f4552f, "additionalData", "", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getCode", "()Ljava/lang/String;", "getErrorMessage", "getAdditionalData", "()Ljava/util/Map;", "Companion", "firebase_database_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlutterFirebaseDatabaseException extends Exception {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String MODULE = "firebase_database";
    public static final String UNKNOWN_ERROR_CODE = "unknown";
    public static final String UNKNOWN_ERROR_MESSAGE = "An unknown error occurred";
    private final Map<String, Object> additionalData;
    private final String code;
    private final String errorMessage;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000e\u001a\u00020\u00062\u000e\u0010\u0005\u001a\n\u0018\u00010\fj\u0004\u0018\u0001`\r¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0010\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0010\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016¨\u0006\u0019"}, d2 = {"Lio/flutter/plugins/firebase/database/FlutterFirebaseDatabaseException$Companion;", "", "<init>", "()V", "Le8/c;", "e", "Lio/flutter/plugins/firebase/database/FlutterFirebaseDatabaseException;", "fromDatabaseError", "(Le8/c;)Lio/flutter/plugins/firebase/database/FlutterFirebaseDatabaseException;", "Le8/d;", "fromDatabaseException", "(Le8/d;)Lio/flutter/plugins/firebase/database/FlutterFirebaseDatabaseException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "fromException", "(Ljava/lang/Exception;)Lio/flutter/plugins/firebase/database/FlutterFirebaseDatabaseException;", FlutterFirebaseDatabaseException.UNKNOWN_ERROR_CODE, "()Lio/flutter/plugins/firebase/database/FlutterFirebaseDatabaseException;", "", com.amazon.a.a.o.b.f4552f, "(Ljava/lang/String;)Lio/flutter/plugins/firebase/database/FlutterFirebaseDatabaseException;", "UNKNOWN_ERROR_CODE", "Ljava/lang/String;", "UNKNOWN_ERROR_MESSAGE", "MODULE", "firebase_database_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final FlutterFirebaseDatabaseException fromDatabaseError(e8.c e10) {
            cd.q qVarA;
            kotlin.jvm.internal.t.f(e10, "e");
            int iF = e10.f();
            String str = FlutterFirebaseDatabaseException.UNKNOWN_ERROR_MESSAGE;
            if (iF == -25) {
                qVarA = cd.w.a("write-cancelled", "The write was canceled by the user.");
            } else if (iF == -24) {
                qVarA = cd.w.a("network-error", "The operation could not be performed due to a network error.");
            } else if (iF == -4) {
                qVarA = cd.w.a("disconnected", "The operation had to be aborted due to a network disconnect.");
            } else if (iF == -3) {
                qVarA = cd.w.a("permission-denied", "Client doesn't have permission to access the desired data.");
            } else if (iF == -2) {
                qVarA = cd.w.a("failure", "The server indicated that this operation failed.");
            } else if (iF != -1) {
                switch (iF) {
                    case IntegrityErrorCode.NONCE_TOO_SHORT /* -10 */:
                        qVarA = cd.w.a("unavailable", "The service is unavailable.");
                        break;
                    case -9:
                        qVarA = cd.w.a("overridden-by-set", "The transaction was overridden by a subsequent set.");
                        break;
                    case -8:
                        qVarA = cd.w.a("max-retries", "The transaction had too many retries.");
                        break;
                    case -7:
                        qVarA = cd.w.a("invalid-token", "The supplied auth token was invalid.");
                        break;
                    case -6:
                        qVarA = cd.w.a("expired-token", "The supplied auth token has expired.");
                        break;
                    default:
                        qVarA = cd.w.a(FlutterFirebaseDatabaseException.UNKNOWN_ERROR_CODE, FlutterFirebaseDatabaseException.UNKNOWN_ERROR_MESSAGE);
                        break;
                }
            } else {
                qVarA = cd.w.a("data-stale", "The transaction needs to be run again with current data.");
            }
            String str2 = (String) qVarA.a();
            String str3 = (String) qVarA.b();
            if (kotlin.jvm.internal.t.b(str2, FlutterFirebaseDatabaseException.UNKNOWN_ERROR_CODE)) {
                String strH = e10.h();
                if (strH != null) {
                    str = strH;
                }
                return unknown(str);
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            String strG = e10.g();
            kotlin.jvm.internal.t.e(strG, "getDetails(...)");
            linkedHashMap.put(Constants.ERROR_DETAILS, strG);
            return new FlutterFirebaseDatabaseException(str2, str3, linkedHashMap);
        }

        public final FlutterFirebaseDatabaseException fromDatabaseException(e8.d e10) {
            kotlin.jvm.internal.t.f(e10, "e");
            e8.c cVarB = e8.c.b(e10);
            kotlin.jvm.internal.t.e(cVarB, "fromException(...)");
            return fromDatabaseError(cVarB);
        }

        public final FlutterFirebaseDatabaseException fromException(Exception e10) {
            if (e10 == null) {
                return unknown();
            }
            String message = e10.getMessage();
            if (message == null) {
                message = FlutterFirebaseDatabaseException.UNKNOWN_ERROR_MESSAGE;
            }
            return unknown(message);
        }

        public final FlutterFirebaseDatabaseException unknown() {
            return unknown(null);
        }

        private Companion() {
        }

        public final FlutterFirebaseDatabaseException unknown(String errorMessage) {
            String str;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            String str2 = FlutterFirebaseDatabaseException.UNKNOWN_ERROR_MESSAGE;
            String str3 = errorMessage == null ? FlutterFirebaseDatabaseException.UNKNOWN_ERROR_MESSAGE : errorMessage;
            if (kg.c0.P(str3, "Index not defined, add \".indexOn\"", false, 2, null)) {
                String strH = kg.z.H(str3, "java.lang.Exception: ", "", false, 4, null);
                if (strH != null) {
                    str2 = strH;
                }
                str = "index-not-defined";
                str3 = str2;
            } else if (kg.c0.P(str3, "Permission denied", false, 2, null) || kg.c0.P(str3, "Client doesn't have permission", false, 2, null)) {
                str = "permission-denied";
                str3 = "Client doesn't have permission to access the desired data.";
            } else {
                str = FlutterFirebaseDatabaseException.UNKNOWN_ERROR_CODE;
            }
            return new FlutterFirebaseDatabaseException(str, str3, linkedHashMap);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FlutterFirebaseDatabaseException(String code, String errorMessage) {
        this(code, errorMessage, null, 4, null);
        kotlin.jvm.internal.t.f(code, "code");
        kotlin.jvm.internal.t.f(errorMessage, "errorMessage");
    }

    public final Map<String, Object> getAdditionalData() {
        return this.additionalData;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public /* synthetic */ FlutterFirebaseDatabaseException(String str, String str2, Map map, int i10, kotlin.jvm.internal.k kVar) {
        this(str, str2, (i10 & 4) != 0 ? null : map);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlutterFirebaseDatabaseException(String code, String errorMessage, Map<String, ? extends Object> map) {
        Map<String, Object> linkedHashMap;
        super(errorMessage);
        kotlin.jvm.internal.t.f(code, "code");
        kotlin.jvm.internal.t.f(errorMessage, "errorMessage");
        this.code = code;
        this.errorMessage = errorMessage;
        if (map != null && (linkedHashMap = dd.o0.z(map)) != null) {
            linkedHashMap.put(Constants.ERROR_CODE, code);
            linkedHashMap.put(Constants.ERROR_MESSAGE, errorMessage);
        } else {
            linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put(Constants.ERROR_CODE, code);
            linkedHashMap.put(Constants.ERROR_MESSAGE, errorMessage);
        }
        this.additionalData = linkedHashMap;
    }
}
