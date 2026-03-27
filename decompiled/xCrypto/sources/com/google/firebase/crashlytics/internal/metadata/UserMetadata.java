package com.google.firebase.crashlytics.internal.metadata;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class UserMetadata {
    public static final String INTERNAL_KEYDATA_FILENAME = "internal-keys";
    public static final String KEYDATA_FILENAME = "keys";
    public static final int MAX_ATTRIBUTES = 64;
    public static final int MAX_ATTRIBUTE_SIZE = 1024;
    public static final int MAX_INTERNAL_KEY_SIZE = 8192;
    public static final int MAX_ROLLOUT_ASSIGNMENTS = 128;
    public static final String ROLLOUTS_STATE_FILENAME = "rollouts-state";
    public static final String USERDATA_FILENAME = "user-data";
    private final CrashlyticsWorkers crashlyticsWorkers;
    private final MetaDataStore metaDataStore;
    private String sessionIdentifier;
    private final SerializeableKeysMap customKeys = new SerializeableKeysMap(false);
    private final SerializeableKeysMap internalKeys = new SerializeableKeysMap(true);
    private final RolloutAssignmentList rolloutsState = new RolloutAssignmentList(MAX_ROLLOUT_ASSIGNMENTS);
    private final AtomicMarkableReference<String> userId = new AtomicMarkableReference<>(null, false);

    public class SerializeableKeysMap {
        private final boolean isInternal;
        final AtomicMarkableReference<KeysMap> map;
        private final AtomicReference<Runnable> queuedSerializer = new AtomicReference<>(null);

        public SerializeableKeysMap(boolean z4) {
            this.isInternal = z4;
            this.map = new AtomicMarkableReference<>(new KeysMap(64, z4 ? UserMetadata.MAX_INTERNAL_KEY_SIZE : UserMetadata.MAX_ATTRIBUTE_SIZE), false);
        }

        public static /* synthetic */ void a(SerializeableKeysMap serializeableKeysMap) throws Throwable {
            serializeableKeysMap.queuedSerializer.set(null);
            serializeableKeysMap.serializeIfMarked();
        }

        private void scheduleSerializationTaskIfNeeded() {
            Runnable runnable = new Runnable() { // from class: com.google.firebase.crashlytics.internal.metadata.d
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    UserMetadata.SerializeableKeysMap.a(this.f10355a);
                }
            };
            if (com.amazon.a.a.l.d.a(this.queuedSerializer, null, runnable)) {
                UserMetadata.this.crashlyticsWorkers.diskWrite.submit(runnable);
            }
        }

        private void serializeIfMarked() throws Throwable {
            Map<String, String> keys;
            synchronized (this) {
                try {
                    if (this.map.isMarked()) {
                        keys = this.map.getReference().getKeys();
                        AtomicMarkableReference<KeysMap> atomicMarkableReference = this.map;
                        atomicMarkableReference.set(atomicMarkableReference.getReference(), false);
                    } else {
                        keys = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (keys != null) {
                UserMetadata.this.metaDataStore.writeKeyData(UserMetadata.this.sessionIdentifier, keys, this.isInternal);
            }
        }

        public Map<String, String> getKeys() {
            return this.map.getReference().getKeys();
        }

        public boolean setKey(String str, String str2) {
            synchronized (this) {
                try {
                    if (!this.map.getReference().setKey(str, str2)) {
                        return false;
                    }
                    AtomicMarkableReference<KeysMap> atomicMarkableReference = this.map;
                    atomicMarkableReference.set(atomicMarkableReference.getReference(), true);
                    scheduleSerializationTaskIfNeeded();
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void setKeys(Map<String, String> map) {
            synchronized (this) {
                this.map.getReference().setKeys(map);
                AtomicMarkableReference<KeysMap> atomicMarkableReference = this.map;
                atomicMarkableReference.set(atomicMarkableReference.getReference(), true);
            }
            scheduleSerializationTaskIfNeeded();
        }
    }

    public UserMetadata(String str, FileStore fileStore, CrashlyticsWorkers crashlyticsWorkers) {
        this.sessionIdentifier = str;
        this.metaDataStore = new MetaDataStore(fileStore);
        this.crashlyticsWorkers = crashlyticsWorkers;
    }

    public static /* synthetic */ void c(UserMetadata userMetadata, String str, Map map, List list) throws Throwable {
        if (userMetadata.getUserId() != null) {
            userMetadata.metaDataStore.writeUserData(str, userMetadata.getUserId());
        }
        if (!map.isEmpty()) {
            userMetadata.metaDataStore.writeKeyData(str, map);
        }
        if (list.isEmpty()) {
            return;
        }
        userMetadata.metaDataStore.writeRolloutState(str, list);
    }

    public static UserMetadata loadFromExistingSession(String str, FileStore fileStore, CrashlyticsWorkers crashlyticsWorkers) {
        MetaDataStore metaDataStore = new MetaDataStore(fileStore);
        UserMetadata userMetadata = new UserMetadata(str, fileStore, crashlyticsWorkers);
        userMetadata.customKeys.map.getReference().setKeys(metaDataStore.readKeyData(str, false));
        userMetadata.internalKeys.map.getReference().setKeys(metaDataStore.readKeyData(str, true));
        userMetadata.userId.set(metaDataStore.readUserId(str), false);
        userMetadata.rolloutsState.updateRolloutAssignmentList(metaDataStore.readRolloutsState(str));
        return userMetadata;
    }

    public static String readUserId(String str, FileStore fileStore) {
        return new MetaDataStore(fileStore).readUserId(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void serializeUserDataIfNeeded() throws Throwable {
        boolean z4;
        String userId;
        synchronized (this.userId) {
            try {
                z4 = false;
                if (this.userId.isMarked()) {
                    userId = getUserId();
                    this.userId.set(userId, false);
                    z4 = true;
                } else {
                    userId = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z4) {
            this.metaDataStore.writeUserData(this.sessionIdentifier, userId);
        }
    }

    public Map<String, String> getCustomKeys(Map<String, String> map) {
        if (map.isEmpty()) {
            return this.customKeys.getKeys();
        }
        HashMap map2 = new HashMap(this.customKeys.getKeys());
        int i4 = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String strSanitizeString = KeysMap.sanitizeString(entry.getKey(), MAX_ATTRIBUTE_SIZE);
            if (map2.size() < 64 || map2.containsKey(strSanitizeString)) {
                map2.put(strSanitizeString, KeysMap.sanitizeString(entry.getValue(), MAX_ATTRIBUTE_SIZE));
            } else {
                i4++;
            }
        }
        if (i4 > 0) {
            Logger.getLogger().w("Ignored " + i4 + " keys when adding event specific keys. Maximum allowable: " + MAX_ATTRIBUTE_SIZE);
        }
        return Collections.unmodifiableMap(map2);
    }

    public Map<String, String> getInternalKeys() {
        return this.internalKeys.getKeys();
    }

    public List<CrashlyticsReport.Session.Event.RolloutAssignment> getRolloutsState() {
        return this.rolloutsState.getReportRolloutsState();
    }

    public String getUserId() {
        return this.userId.getReference();
    }

    public boolean setCustomKey(String str, String str2) {
        return this.customKeys.setKey(str, str2);
    }

    public void setCustomKeys(Map<String, String> map) {
        this.customKeys.setKeys(map);
    }

    public boolean setInternalKey(String str, String str2) {
        return this.internalKeys.setKey(str, str2);
    }

    public void setNewSession(final String str) {
        synchronized (this.sessionIdentifier) {
            this.sessionIdentifier = str;
            final Map<String, String> keys = this.customKeys.getKeys();
            final List<RolloutAssignment> rolloutAssignmentList = this.rolloutsState.getRolloutAssignmentList();
            this.crashlyticsWorkers.diskWrite.submit(new Runnable() { // from class: com.google.firebase.crashlytics.internal.metadata.b
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    UserMetadata.c(this.f10350a, str, keys, rolloutAssignmentList);
                }
            });
        }
    }

    public void setUserId(String str) {
        String strSanitizeString = KeysMap.sanitizeString(str, MAX_ATTRIBUTE_SIZE);
        synchronized (this.userId) {
            try {
                if (CommonUtils.nullSafeEquals(strSanitizeString, this.userId.getReference())) {
                    return;
                }
                this.userId.set(strSanitizeString, true);
                this.crashlyticsWorkers.diskWrite.submit(new Runnable() { // from class: com.google.firebase.crashlytics.internal.metadata.c
                    @Override // java.lang.Runnable
                    public final void run() throws Throwable {
                        this.f10354a.serializeUserDataIfNeeded();
                    }
                });
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean updateRolloutsState(List<RolloutAssignment> list) {
        synchronized (this.rolloutsState) {
            try {
                if (!this.rolloutsState.updateRolloutAssignmentList(list)) {
                    return false;
                }
                final List<RolloutAssignment> rolloutAssignmentList = this.rolloutsState.getRolloutAssignmentList();
                this.crashlyticsWorkers.diskWrite.submit(new Runnable() { // from class: com.google.firebase.crashlytics.internal.metadata.a
                    @Override // java.lang.Runnable
                    public final void run() throws Throwable {
                        UserMetadata userMetadata = this.f10348a;
                        userMetadata.metaDataStore.writeRolloutState(userMetadata.sessionIdentifier, rolloutAssignmentList);
                    }
                });
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Map<String, String> getCustomKeys() {
        return this.customKeys.getKeys();
    }
}
