package com.google.firebase.heartbeatinfo;

/* JADX INFO: loaded from: classes.dex */
public interface HeartBeatInfo {

    public enum HeartBeat {
        NONE(0),
        SDK(1),
        GLOBAL(2),
        COMBINED(3);

        private final int code;

        HeartBeat(int i4) {
            this.code = i4;
        }

        public int getCode() {
            return this.code;
        }
    }

    HeartBeat getHeartBeatCode(String str);
}
