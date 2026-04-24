package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.InterfaceC0426d;
import com.google.android.gms.common.internal.InterfaceC0427e;
import com.google.android.gms.common.internal.InterfaceC0436n;
import java.util.Set;
import u1.C1202d;

/* JADX INFO: loaded from: classes.dex */
public interface g extends b {
    void connect(InterfaceC0426d interfaceC0426d);

    void disconnect();

    void disconnect(String str);

    C1202d[] getAvailableFeatures();

    String getEndpointPackageName();

    String getLastDisconnectMessage();

    int getMinApkVersion();

    void getRemoteService(InterfaceC0436n interfaceC0436n, Set set);

    Set getScopesForConnectionlessNonSignIn();

    boolean isConnected();

    boolean isConnecting();

    void onUserSignOut(InterfaceC0427e interfaceC0427e);

    boolean requiresGooglePlayServices();

    boolean requiresSignIn();
}
