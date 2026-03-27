package org.chromium.support_lib_boundary;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public interface ServiceWorkerWebSettingsBoundaryInterface {
    boolean getAllowContentAccess();

    boolean getAllowFileAccess();

    boolean getBlockNetworkLoads();

    int getCacheMode();

    boolean getIncludeCookiesOnIntercept();

    Set<String> getRequestedWithHeaderOriginAllowList();

    void setAllowContentAccess(boolean z6);

    void setAllowFileAccess(boolean z6);

    void setBlockNetworkLoads(boolean z6);

    void setCacheMode(int i);

    void setIncludeCookiesOnIntercept(boolean z6);

    void setRequestedWithHeaderOriginAllowList(Set<String> set);
}
