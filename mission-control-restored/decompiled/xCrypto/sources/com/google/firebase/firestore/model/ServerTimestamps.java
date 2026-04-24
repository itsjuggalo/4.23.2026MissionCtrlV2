package com.google.firebase.firestore.model;

import com.google.firebase.Timestamp;
import com.google.protobuf.u0;
import p2.C1698D;
import p2.u;

/* JADX INFO: loaded from: classes.dex */
public final class ServerTimestamps {
    private static final String LOCAL_WRITE_TIME_KEY = "__local_write_time__";
    private static final String PREVIOUS_VALUE_KEY = "__previous_value__";
    private static final String SERVER_TIMESTAMP_SENTINEL = "server_timestamp";
    private static final String TYPE_KEY = "__type__";

    private ServerTimestamps() {
    }

    public static u0 getLocalWriteTime(C1698D c1698d) {
        return c1698d.C().p(LOCAL_WRITE_TIME_KEY).F();
    }

    public static C1698D getPreviousValue(C1698D c1698d) {
        C1698D c1698dO = c1698d.C().o(PREVIOUS_VALUE_KEY, null);
        return isServerTimestamp(c1698dO) ? getPreviousValue(c1698dO) : c1698dO;
    }

    public static boolean isServerTimestamp(C1698D c1698d) {
        C1698D c1698dO = c1698d != null ? c1698d.C().o("__type__", null) : null;
        return c1698dO != null && SERVER_TIMESTAMP_SENTINEL.equals(c1698dO.E());
    }

    public static C1698D valueOf(Timestamp timestamp, C1698D c1698d) {
        C1698D c1698d2 = (C1698D) C1698D.I().r(SERVER_TIMESTAMP_SENTINEL).build();
        u.b bVarH = u.t().h("__type__", c1698d2).h(LOCAL_WRITE_TIME_KEY, (C1698D) C1698D.I().s(u0.p().g(timestamp.getSeconds()).f(timestamp.getNanoseconds())).build());
        if (isServerTimestamp(c1698d)) {
            c1698d = getPreviousValue(c1698d);
        }
        if (c1698d != null) {
            bVarH.h(PREVIOUS_VALUE_KEY, c1698d);
        }
        return (C1698D) C1698D.I().n(bVarH).build();
    }
}
