package io.flutter.plugins.firebase.database;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b&\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lio/flutter/plugins/firebase/database/Constants;", "", "<init>", "()V", "APP_NAME", "", "DATABASE_URL", "DATABASE_LOGGING_ENABLED", "DATABASE_PERSISTENCE_ENABLED", "DATABASE_EMULATOR_HOST", "DATABASE_EMULATOR_PORT", "DATABASE_CACHE_SIZE_BYTES", "EVENT_CHANNEL_NAME_PREFIX", "PATH", "KEY", "VALUE", "PRIORITY", "SNAPSHOT", "COMMITTED", "MODIFIERS", "ORDER_BY", "CURSOR", "LIMIT", "START_AT", "START_AFTER", "END_AT", "END_BEFORE", "LIMIT_TO_FIRST", "LIMIT_TO_LAST", "EVENT_TYPE", "EVENT_TYPE_CHILD_ADDED", "EVENT_TYPE_CHILD_REMOVED", "EVENT_TYPE_CHILD_CHANGED", "EVENT_TYPE_CHILD_MOVED", "EVENT_TYPE_VALUE", "CHILD_KEYS", "PREVIOUS_CHILD_NAME", "METHOD_CALL_TRANSACTION_HANDLER", "TRANSACTION_KEY", "TRANSACTION_APPLY_LOCALLY", "ERROR_CODE", "ERROR_MESSAGE", "ERROR_DETAILS", "firebase_database_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Constants {
    public static final String APP_NAME = "appName";
    public static final String CHILD_KEYS = "childKeys";
    public static final String COMMITTED = "committed";
    public static final String CURSOR = "cursor";
    public static final String DATABASE_CACHE_SIZE_BYTES = "cacheSizeBytes";
    public static final String DATABASE_EMULATOR_HOST = "emulatorHost";
    public static final String DATABASE_EMULATOR_PORT = "emulatorPort";
    public static final String DATABASE_LOGGING_ENABLED = "loggingEnabled";
    public static final String DATABASE_PERSISTENCE_ENABLED = "persistenceEnabled";
    public static final String DATABASE_URL = "databaseURL";
    public static final String END_AT = "endAt";
    public static final String END_BEFORE = "endBefore";
    public static final String ERROR_CODE = "code";
    public static final String ERROR_DETAILS = "details";
    public static final String ERROR_MESSAGE = "message";
    public static final String EVENT_CHANNEL_NAME_PREFIX = "eventChannelNamePrefix";
    public static final String EVENT_TYPE = "eventType";
    public static final String EVENT_TYPE_CHILD_ADDED = "childAdded";
    public static final String EVENT_TYPE_CHILD_CHANGED = "childChanged";
    public static final String EVENT_TYPE_CHILD_MOVED = "childMoved";
    public static final String EVENT_TYPE_CHILD_REMOVED = "childRemoved";
    public static final String EVENT_TYPE_VALUE = "value";
    public static final Constants INSTANCE = new Constants();
    public static final String KEY = "key";
    public static final String LIMIT = "limit";
    public static final String LIMIT_TO_FIRST = "limitToFirst";
    public static final String LIMIT_TO_LAST = "limitToLast";
    public static final String METHOD_CALL_TRANSACTION_HANDLER = "FirebaseDatabase#callTransactionHandler";
    public static final String MODIFIERS = "modifiers";
    public static final String ORDER_BY = "orderBy";
    public static final String PATH = "path";
    public static final String PREVIOUS_CHILD_NAME = "previousChildKey";
    public static final String PRIORITY = "priority";
    public static final String SNAPSHOT = "snapshot";
    public static final String START_AFTER = "startAfter";
    public static final String START_AT = "startAt";
    public static final String TRANSACTION_APPLY_LOCALLY = "transactionApplyLocally";
    public static final String TRANSACTION_KEY = "transactionKey";
    public static final String VALUE = "value";

    private Constants() {
    }
}
