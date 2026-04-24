package io.flutter.plugin.platform;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: io.flutter.plugin.platform.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C2017n implements InterfaceC2016m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f16773a = new HashMap();

    @Override // io.flutter.plugin.platform.InterfaceC2016m
    public boolean a(String str, AbstractC2015l abstractC2015l) {
        if (this.f16773a.containsKey(str)) {
            return false;
        }
        this.f16773a.put(str, abstractC2015l);
        return true;
    }

    public AbstractC2015l b(String str) {
        return (AbstractC2015l) this.f16773a.get(str);
    }
}
