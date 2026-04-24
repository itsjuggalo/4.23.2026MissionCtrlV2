package com.google.firebase.firestore.core;

import K2.l0;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.ListenSource;
import com.google.firebase.firestore.core.SyncEngine;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class EventManager implements SyncEngine.SyncEngineCallback {
    private final SyncEngine syncEngine;
    private final Set<EventListener<Void>> snapshotsInSyncListeners = new HashSet();
    private OnlineState onlineState = OnlineState.UNKNOWN;
    private final Map<Query, QueryListenersInfo> queries = new HashMap();

    /* JADX INFO: renamed from: com.google.firebase.firestore.core.EventManager$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$firestore$core$EventManager$ListenerRemovalAction;
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$firestore$core$EventManager$ListenerSetupAction;

        static {
            int[] iArr = new int[ListenerRemovalAction.values().length];
            $SwitchMap$com$google$firebase$firestore$core$EventManager$ListenerRemovalAction = iArr;
            try {
                iArr[ListenerRemovalAction.TERMINATE_LOCAL_LISTEN_AND_REQUIRE_WATCH_DISCONNECTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$core$EventManager$ListenerRemovalAction[ListenerRemovalAction.TERMINATE_LOCAL_LISTEN_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$core$EventManager$ListenerRemovalAction[ListenerRemovalAction.REQUIRE_WATCH_DISCONNECTION_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[ListenerSetupAction.values().length];
            $SwitchMap$com$google$firebase$firestore$core$EventManager$ListenerSetupAction = iArr2;
            try {
                iArr2[ListenerSetupAction.INITIALIZE_LOCAL_LISTEN_AND_REQUIRE_WATCH_CONNECTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$core$EventManager$ListenerSetupAction[ListenerSetupAction.INITIALIZE_LOCAL_LISTEN_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$core$EventManager$ListenerSetupAction[ListenerSetupAction.REQUIRE_WATCH_CONNECTION_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static class ListenOptions {
        public boolean includeDocumentMetadataChanges;
        public boolean includeQueryMetadataChanges;
        public ListenSource source = ListenSource.DEFAULT;
        public boolean waitForSyncWhenOnline;
    }

    public enum ListenerRemovalAction {
        TERMINATE_LOCAL_LISTEN_AND_REQUIRE_WATCH_DISCONNECTION,
        TERMINATE_LOCAL_LISTEN_ONLY,
        REQUIRE_WATCH_DISCONNECTION_ONLY,
        NO_ACTION_REQUIRED
    }

    public enum ListenerSetupAction {
        INITIALIZE_LOCAL_LISTEN_AND_REQUIRE_WATCH_CONNECTION,
        INITIALIZE_LOCAL_LISTEN_ONLY,
        REQUIRE_WATCH_CONNECTION_ONLY,
        NO_ACTION_REQUIRED
    }

    public static class QueryListenersInfo {
        private final List<QueryListener> listeners = new ArrayList();
        private int targetId;
        private ViewSnapshot viewSnapshot;

        public boolean hasRemoteListeners() {
            Iterator<QueryListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                if (it.next().listensToRemoteStore()) {
                    return true;
                }
            }
            return false;
        }
    }

    public EventManager(SyncEngine syncEngine) {
        this.syncEngine = syncEngine;
        syncEngine.setCallback(this);
    }

    private void raiseSnapshotsInSyncEvent() {
        Iterator<EventListener<Void>> it = this.snapshotsInSyncListeners.iterator();
        while (it.hasNext()) {
            it.next().onEvent(null, null);
        }
    }

    public int addQueryListener(QueryListener queryListener) {
        Query query = queryListener.getQuery();
        ListenerSetupAction listenerSetupAction = ListenerSetupAction.NO_ACTION_REQUIRED;
        QueryListenersInfo queryListenersInfo = this.queries.get(query);
        if (queryListenersInfo == null) {
            queryListenersInfo = new QueryListenersInfo();
            this.queries.put(query, queryListenersInfo);
            listenerSetupAction = queryListener.listensToRemoteStore() ? ListenerSetupAction.INITIALIZE_LOCAL_LISTEN_AND_REQUIRE_WATCH_CONNECTION : ListenerSetupAction.INITIALIZE_LOCAL_LISTEN_ONLY;
        } else if (!queryListenersInfo.hasRemoteListeners() && queryListener.listensToRemoteStore()) {
            listenerSetupAction = ListenerSetupAction.REQUIRE_WATCH_CONNECTION_ONLY;
        }
        queryListenersInfo.listeners.add(queryListener);
        Assert.hardAssert(!queryListener.onOnlineStateChanged(this.onlineState), "onOnlineStateChanged() shouldn't raise an event for brand-new listeners.", new Object[0]);
        if (queryListenersInfo.viewSnapshot != null && queryListener.onViewSnapshot(queryListenersInfo.viewSnapshot)) {
            raiseSnapshotsInSyncEvent();
        }
        int i4 = AnonymousClass1.$SwitchMap$com$google$firebase$firestore$core$EventManager$ListenerSetupAction[listenerSetupAction.ordinal()];
        if (i4 == 1) {
            queryListenersInfo.targetId = this.syncEngine.listen(query, true);
        } else if (i4 == 2) {
            queryListenersInfo.targetId = this.syncEngine.listen(query, false);
        } else if (i4 == 3) {
            this.syncEngine.listenToRemoteStore(query);
        }
        return queryListenersInfo.targetId;
    }

    public void addSnapshotsInSyncListener(EventListener<Void> eventListener) {
        this.snapshotsInSyncListeners.add(eventListener);
        eventListener.onEvent(null, null);
    }

    @Override // com.google.firebase.firestore.core.SyncEngine.SyncEngineCallback
    public void handleOnlineStateChange(OnlineState onlineState) {
        this.onlineState = onlineState;
        Iterator<QueryListenersInfo> it = this.queries.values().iterator();
        boolean z4 = false;
        while (it.hasNext()) {
            Iterator it2 = it.next().listeners.iterator();
            while (it2.hasNext()) {
                if (((QueryListener) it2.next()).onOnlineStateChanged(onlineState)) {
                    z4 = true;
                }
            }
        }
        if (z4) {
            raiseSnapshotsInSyncEvent();
        }
    }

    @Override // com.google.firebase.firestore.core.SyncEngine.SyncEngineCallback
    public void onError(Query query, l0 l0Var) {
        QueryListenersInfo queryListenersInfo = this.queries.get(query);
        if (queryListenersInfo != null) {
            Iterator it = queryListenersInfo.listeners.iterator();
            while (it.hasNext()) {
                ((QueryListener) it.next()).onError(Util.exceptionFromStatus(l0Var));
            }
        }
        this.queries.remove(query);
    }

    @Override // com.google.firebase.firestore.core.SyncEngine.SyncEngineCallback
    public void onViewSnapshots(List<ViewSnapshot> list) {
        boolean z4 = false;
        for (ViewSnapshot viewSnapshot : list) {
            QueryListenersInfo queryListenersInfo = this.queries.get(viewSnapshot.getQuery());
            if (queryListenersInfo != null) {
                Iterator it = queryListenersInfo.listeners.iterator();
                while (it.hasNext()) {
                    if (((QueryListener) it.next()).onViewSnapshot(viewSnapshot)) {
                        z4 = true;
                    }
                }
                queryListenersInfo.viewSnapshot = viewSnapshot;
            }
        }
        if (z4) {
            raiseSnapshotsInSyncEvent();
        }
    }

    public void removeQueryListener(QueryListener queryListener) {
        Query query = queryListener.getQuery();
        QueryListenersInfo queryListenersInfo = this.queries.get(query);
        ListenerRemovalAction listenerRemovalAction = ListenerRemovalAction.NO_ACTION_REQUIRED;
        if (queryListenersInfo == null) {
            return;
        }
        queryListenersInfo.listeners.remove(queryListener);
        if (queryListenersInfo.listeners.isEmpty()) {
            listenerRemovalAction = queryListener.listensToRemoteStore() ? ListenerRemovalAction.TERMINATE_LOCAL_LISTEN_AND_REQUIRE_WATCH_DISCONNECTION : ListenerRemovalAction.TERMINATE_LOCAL_LISTEN_ONLY;
        } else if (!queryListenersInfo.hasRemoteListeners() && queryListener.listensToRemoteStore()) {
            listenerRemovalAction = ListenerRemovalAction.REQUIRE_WATCH_DISCONNECTION_ONLY;
        }
        int i4 = AnonymousClass1.$SwitchMap$com$google$firebase$firestore$core$EventManager$ListenerRemovalAction[listenerRemovalAction.ordinal()];
        if (i4 == 1) {
            this.queries.remove(query);
            this.syncEngine.stopListening(query, true);
        } else if (i4 == 2) {
            this.queries.remove(query);
            this.syncEngine.stopListening(query, false);
        } else {
            if (i4 != 3) {
                return;
            }
            this.syncEngine.stopListeningToRemoteStore(query);
        }
    }

    public void removeSnapshotsInSyncListener(EventListener<Void> eventListener) {
        this.snapshotsInSyncListeners.remove(eventListener);
    }
}
