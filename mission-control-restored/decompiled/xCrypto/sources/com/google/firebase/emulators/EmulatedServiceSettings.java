package com.google.firebase.emulators;

/* JADX INFO: loaded from: classes.dex */
public final class EmulatedServiceSettings {
    private final String host;
    private final int port;

    public EmulatedServiceSettings(String str, int i4) {
        this.host = str;
        this.port = i4;
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        return this.port;
    }
}
